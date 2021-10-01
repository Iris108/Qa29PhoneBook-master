package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if(app.userHelper().isLogged()){
            app.userHelper().logout();
        }

    }

    @Test
    public void loginTestPositiveBase() {
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        app.userHelper().openLoginRegistrationForm();
        app.userHelper().fillLoginRegForm(user);
        app.userHelper().clickLoginButton();

        Assert.assertTrue(app.userHelper().isLogged());


    }


}
