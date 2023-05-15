import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class BasePageTest {
    public static WebDriver driver;

    public static WebDriver getDriver(){

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            return driver;

    }

    // Creating url path
    private static final String urlPath = "file://" + System.getProperty("user.dir") + "/";

    // Creating Url for page
    public static final String homePage = urlPath + "QE-index.html";

    //method to navigate
    public void navigateTo(String url) {

        driver.get(url);
    }

}