package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if(!app.userHelper().isLogged()){
            app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

    }

    @Test(invocationCount = 5)
    public void addContactTest() {
        //if number of contact <5
        int index = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        Contact contact=  Contact.builder()
                .name("Lisa" + index)
                .lastname("Freez" + index)
                .phone("Lisa" + index + "@gmail.com")
                .email("Lisa" + index + "@gmail.com")
                .address("Haifa, Herzel,4")
                .description("university friend")
                .build();


        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveNewContact();
        app.contact().pause(500);
        Assert.assertTrue(app.contact().isContactCreated(contact.getName()));

    }
}
