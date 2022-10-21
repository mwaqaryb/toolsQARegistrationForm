package toolsQA.automation.testcomponents;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import toolsQA.test.utility.Utils;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static javafx.application.Platform.exit;

public class BaseTest {
    public WebDriver driver;
    public WebDriver initializeDriver() {
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : Utils.getElementFromPropertiesFile("browser", "global");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();

            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        }
        else{
            System.out.println("Only affords Chrome Browser");
            exit();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void loadRegistrationForm() {
        driver = initializeDriver();
        driver.get(Utils.getElementFromPropertiesFile("url", "global"));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.close();
    }
}