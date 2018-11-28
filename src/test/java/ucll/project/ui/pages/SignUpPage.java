package ucll.project.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public SignUpPage navigateTo(){
        driver.get("http://localhost:8080/user/signup");
        return this;
    }

    public String getPageTitle(){
        return driver.findElement(By.id("pageTitle")).getText();
    }

}
