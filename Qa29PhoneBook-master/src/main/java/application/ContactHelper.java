package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void openContactForm() {
        wd.findElement(By.cssSelector("[href='/add']")).click();
    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getPhone());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveNewContact() {
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = wd.findElements(By.xpath("//h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;

        }
        return false;
    }
}
