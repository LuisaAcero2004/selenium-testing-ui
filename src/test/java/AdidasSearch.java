import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pages.HomePage;
import pages.ResultsPage;
import utilities.Browser;
import utilities.BrowserFactory;
import java.time.Duration;

public class AdidasSearch {

    private HomePage homePage;
    private ResultsPage resultsPage;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        //Choose driver -> Chrome or Edge
        BrowserFactory factory = new BrowserFactory("Edge");
        Browser browser = factory.createBrowser();
        driver = browser.createDriver();
        driver.get("https://www.ebay.com/");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterSuite
    public void afterTest(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void searchAdidasShoes() throws InterruptedException {
        homePage.searchProduct("shoes");
        resultsPage.selectBrand("adidas");
        Assert.assertTrue(resultsPage.readQtyResults() > 2000);

    }



}
