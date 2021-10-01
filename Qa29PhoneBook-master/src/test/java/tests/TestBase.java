package tests;

import application.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

 protected  static ApplicationManager app = new ApplicationManager();
    @BeforeClass
    public void setUp(){
app.init();
    }

    @AfterClass
    public void  tearDown(){
       app.stop();

    }
}
