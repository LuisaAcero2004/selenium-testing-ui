package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ResultsPage extends BasePage{

    public ResultsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "h1[class=\"srp-controls__count-heading\"] span[class=\"BOLD\"]")
    private WebElement QtyResults;


    public void selectBrand(String brand){

        WebElement brandCheckbox;
        brandCheckbox = driver.findElement(By.cssSelector("input[aria-label=\"" + brand + "\"]"));
        brandCheckbox.click();

    }

    public int readQtyResults(){
        int qtyResults = Integer.parseInt(QtyResults.getText().replace(".",""));

        return qtyResults;
    }
}
