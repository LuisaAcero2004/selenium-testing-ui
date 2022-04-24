package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "gh-ac")
    private WebElement searchBar;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public void searchProduct(String product) throws InterruptedException {
        searchBar.sendKeys(product);
        applyWait(driver,"implicit",5);
        searchButton.click();
    }

}
