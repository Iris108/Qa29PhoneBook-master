package application;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void fillLoginRegForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void clickLoginButton() {
        click(By.xpath("//button[1]"));
    }

    public void clickRegistrationButton() {
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0;
    }



    public void logout() {
        click(By.xpath("//*[text()='Sign Out']"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegForm(user);
        clickLoginButton();
        pause(1000);
    }


    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());

        if(alert==null){
            return false;
        }else {
            wd.switchTo().alert();
            alert.accept();
            return true;
        }
    }
}
