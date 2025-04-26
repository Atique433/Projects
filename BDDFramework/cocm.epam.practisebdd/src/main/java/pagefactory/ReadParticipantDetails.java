package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ReadParticipantDetails
{
    WebDriver driver;
    public ReadParticipantDetails(WebDriver driver)
    {
        this.driver=driver;
    }
   public HomePage searchByName(String search) throws InterruptedException {
       Thread.sleep(3000);
       WebElement searchByName=driver.findElement(By.xpath("//input[@type='search']"));
       searchByName.clear();
       searchByName.sendKeys(search);
       return new HomePage(driver);
   }
}
