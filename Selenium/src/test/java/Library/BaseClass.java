package Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    private Properties prop;

    public BaseClass() {
        try {
            prop = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/test/java/Resources/Properties";
            FileInputStream fis = null;
            fis = new FileInputStream(filePath);
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getUsername(String uname) {
        return (prop.getProperty(uname));
    }
    public String getPassword(String pass) {
        return (prop.getProperty(pass));
    }

    public String getFirstName(String fname) {
        return (prop.getProperty(fname));
    }
    public String getSurName(String sname) {
        return (prop.getProperty(sname));
    }
    public String getDOB(String dob) {
        return (prop.getProperty(dob));
    }
    public String getString(String string) {
        return (prop.getProperty(string));
    }

    public void setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://carepro-training.ihmafrica.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //implicit wait
    }


    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
