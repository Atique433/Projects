package pagefactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class VerifyParticipant
{
    private WebElement text;
    @FindBy(className ="dataTables_empty")

    Logger logger = LogManager.getLogger(VerifyParticipant.class);
    WebDriver driver;
    public VerifyParticipant(WebDriver driver)
    {
        this.driver=driver;
    }
    public void verifyByName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']"))).clear();

        WebElement searchByName = driver.findElement(By.xpath("//input[@type='search']"));
        searchByName.sendKeys("Ateeq");

    }
    public void check() {

        String actualData = text.getText();
        String expectedData = "No matching records found";
        SoftAssert softAssert = new SoftAssert();
        logger.info("Actual Data : "+actualData);
        softAssert.assertEquals(actualData,expectedData);
    }
}
