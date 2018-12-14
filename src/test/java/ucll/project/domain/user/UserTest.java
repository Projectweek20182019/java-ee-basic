package ucll.project.domain.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a UnitTest that tests the User class
 */
public class UserTest {

    @Test
    public void text_CreateUserTest_sets_all_fields() {
        User user = new User(
                "userName",
                "firstName",
                "lastName",
                "email@example.com",
                Gender.FEMALE,
                Role.ADMIN
        );
        assertEquals(user.getUserName(), "userName");
        assertEquals(user.getFirstName(), "firstName");
        assertEquals(user.getLastName(), "lastName");
        assertEquals(user.getEmail(), "email@example.com");
        assertEquals(user.getGender(), Gender.FEMALE);
        assertEquals(user.getRole(), Role.ADMIN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateUser_with_invalid_email() {
        User user = new User(
                "userName",
                "firstName",
                "lastName",
                "emailexample.com", // user without @ in email
                Gender.FEMALE,
                Role.ADMIN
        );
    }
}
