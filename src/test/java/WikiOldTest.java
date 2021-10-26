// здесь не выносил pageobject. Работает

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WikiOldTest {
    private final String url = "https://ru.wikipedia.org";
    private WebDriver driver;

    @BeforeClass
    public static void initProperties() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");    // chrome
    }

    @Before
    public void initwebDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();      // chrome
        capabilities.setCapability("marionette", true);

        driver = new ChromeDriver(capabilities);      // chrome
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    @Test
    public void test() {
        try {

            WebElement searchInputElement = driver.findElement(By.cssSelector("input[id='searchInput']"));
            searchInputElement.sendKeys("Hello selenium");

            WebElement searchButton = driver.findElements(By.id("searchButton")).get(0);
            searchButton.click();

            WebElement searchButton2 = driver.findElements(By.className("oo-ui-labelElement-label")).get(0);
            searchButton2.click();

            int searchResult = driver.findElements(By.className("searchresult")).size();
            //System.out.println("searchResult" + searchResult); // не работает, а жаль

            Assert.assertTrue(searchResult>5);

        } catch (WebDriverException e) {
            e.printStackTrace();
         }
    }
    @After
    public void closeDriver() {
        driver.quit();
    }
}
