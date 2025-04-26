package pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteParticipantDetails {
    @FindBy(id = "tooltip2")
    private WebElement Delete;
    @FindBy(xpath = "//button[text()='Delete ']")
    private WebElement SaveButton;
    @FindBy(className = "dataTables_empty")
    private WebElement text;

    WebDriver driver;

    public DeleteParticipantDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public HomePage deleteParticipant() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(Delete)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
        return new HomePage(driver);
    }
}


