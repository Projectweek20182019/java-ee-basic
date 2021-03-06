package ucll.project.ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import ucll.project.domain.user.Gender;
import ucll.project.domain.user.Role;
import ucll.project.domain.user.User;
import ucll.project.ui.pages.HomePage;
import ucll.project.ui.pages.LoginPage;
import ucll.project.ui.pages.SignUpPage;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private static WebDriver driver;
    private static User user;
    private static String password;

    @BeforeClass //executes once before all tests are ran
    public static void SetupChromeDriver() {
        // Setup the Chrome driver for the whole class
        driver = ChromeDriverHelper.getDriver();
    }

    @AfterClass //executes once after all tests are ran
    public static void CloseChrome() {
        // close it in the end, comment this away to keep chrome open
        driver.close();
    }

    @Before //executes before each test
    public void generateUser() {
        user = new User();

        String userName = RandomStringUtils.random(5, true, false);
        password = RandomStringUtils.random(5, true, false).toLowerCase();

        user.setEmail(userName + "@email.com");
        user.setUserName(userName);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender(Gender.MALE);
        user.setRole(Role.USER);

        user = new User(userName, "firstName", "lastName", userName + "@email.com", Gender.MALE, Role.USER);
        user.hashAndSetPassword(password);
    }

    @After //executes after each test
    public void deleteUser() {
        /*
         * TODO delete user from Database
         */
        System.out.println("DELETE USER " + user.getUserName());
        /**
         * When using a database you should delete the user here from the database again.
         * Since this test is not using a database, this is not required for the demo project.
         */
    }

    @Test
    public void test_Register_With_All_Fields_Correct_And_Login_With_All_Fields_Correct_And_Logout() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.navigateTo();
        LoginPage loginPage = signUpPage.registerUserExpectSuccess(user, "01/01/2000", password);

        HomePage homePage = loginPage.loginAs(user.getUserName(), password);
        assertEquals("Logout, " + user.getUserName(), homePage.getLogoutLinkText());

        homePage = homePage.clickLogoutLink();
        assertEquals("Hello world!", homePage.getPageTitle());
    }


}
