package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utilities.Browser;
import utilities.BrowserFactory;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void applyWait(WebDriver driver, String waitType, int seconds) throws InterruptedException {
        switch (waitType){
            case "sleep":
                int s = (seconds * 1000);
                Thread.sleep(s);
                break;

            case "implicit":
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

        }

    }


}
