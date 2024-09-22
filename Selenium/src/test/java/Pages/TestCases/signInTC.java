package Pages.TestCases;

import Library.BaseClass;
import Pages.TestMethods.HomePage_TM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class signInTC extends BaseClass {

    HomePage_TM home = new HomePage_TM();

    @BeforeClass
    public void setupDriver(){
        setup();
    }

    @Test(description = "User can sign in using correct username and password and redirect to select province page", priority = 1)
    public void Login_CorrectInfo() throws InterruptedException {
        Thread.sleep(2000);
        home.LogIn(getUsername("username"), getPassword("password"), driver);
    }

    @Test(priority = 2)
    public void selectProvince() throws InterruptedException {
        Thread.sleep(2000);

        home.SelectFacilityTM(driver);
    }
   // @Test(description = "Finding Exact User", priority = 3)
    public void testSearchPatient_TC01() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //implicit wait
        Thread.sleep(1000);
        home.testSearchPatient(getFirstName("FirstName"),getSurName("SurName"),
                getDOB("DOByear"), getDOB("DOBmonth"),getDOB("DOBdate"),getString("Sex"), driver);
      }

    @Test(description = "Finding User by only DOB and Partial Name", priority = 3)
    public void testSearchPatient_TC02() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // implicit wait
        Thread.sleep(5000);

        home.testSearchPatient(getFirstName(""),getSurName("SurName"),
                getDOB(""), getDOB(""),getDOB(""),getString("Sex"), driver);
    }




    // Negative Tests

 //   @Test(description = "Try to sign in using correct username and Wrong password and redirect to select province page", priority = 1)
    public void LogIn_CorrectUsernameWrongPass() throws InterruptedException {
        Thread.sleep(2000);
        home.LogIn(getUsername("username"), getPassword("Wrong_password"), driver);
    }

  //  @Test(description = "Try to sign in using correct username and Wrong password and redirect to select province page", priority = 1)
    public void LogIn_WrongUsernameCorrectPass() throws InterruptedException {
        Thread.sleep(2000);
        home.LogIn(getUsername("Wrong_username"), getPassword("password"), driver);
    }





    @AfterClass
    public void tearDownDriver() throws InterruptedException {
         Thread.sleep(5000);
        tearDown();
    }
}
