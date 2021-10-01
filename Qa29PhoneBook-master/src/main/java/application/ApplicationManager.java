package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;

     public  void init(){
         wd = new ChromeDriver();
         wd.manage().window().maximize();
         wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
         wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         userHelper = new UserHelper(wd);
         contactHelper = new ContactHelper(wd);

     }

     public void stop(){
         wd.quit();
     }

    public UserHelper userHelper() {
        return userHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
