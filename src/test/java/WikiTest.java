// здесь вынес отдельно pageobject. НЕ_работает

import org.example.WikiPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;



public class WikiTest {
    private final String url = "https://ru.wikipedia.org";
    private WebDriver driver;

    @BeforeClass
    public static void initProperties() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");    // chrome
    }

    @Before
    public void initWebDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();      // chrome
        capabilities.setCapability("marionette", true);

        driver = new ChromeDriver(capabilities);      // chrome
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    @Test
    public void test() {

        WikiPage page = new WikiPage(driver); // вызов этого конструктора ведет к падению теста

        page.setSearchText("Hello is");

        page.clickToSearch();

        page.clickToSearch2();

       // int searchResultCount = page.getSearchResultCount().size();
        //System.out.println("searchResultCount" + searchResultCount); // не работает, а жаль

       // Assert.assertTrue(searchResultCount>1);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}


