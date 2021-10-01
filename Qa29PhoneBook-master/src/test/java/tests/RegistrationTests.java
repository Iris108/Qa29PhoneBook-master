package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if(app.userHelper().isLogged()){
            app.userHelper().logout();
        }

    }

    @Test
    public void registrationTestSuccess(){
        int i =(int) ((System.currentTimeMillis()/1000)%3600);
        app.userHelper().openLoginRegistrationForm();
        app.userHelper().fillLoginRegForm(new User().withEmail("john"+i+"@gmail.com").withPassword("Jj123$"+i));
        app.userHelper().clickRegistrationButton();
        Assert.assertTrue(app.userHelper().isLogged());
    }

@Test
    public void registrationNegativeWrongPassword(){
    int i =(int) ((System.currentTimeMillis()/1000)%3600);
    app.userHelper().openLoginRegistrationForm();
    app.userHelper().fillLoginRegForm(new User().withEmail("john"+i+"@gmail.com").withPassword("j123"+i));
    app.userHelper().clickRegistrationButton();
    Assert.assertTrue(app.userHelper().isAlertPresent());

}

}
