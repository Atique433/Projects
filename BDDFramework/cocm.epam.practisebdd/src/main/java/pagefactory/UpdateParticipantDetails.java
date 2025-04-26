package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateParticipantDetails
{
    private final By Edit=By.id("tooltip1");
    @FindBy(name = "taskName")
    private WebElement EditName;
    @FindBy(xpath ="//button[text()='Save']")
    private WebElement SaveButton;
    WebDriver driver;
    public UpdateParticipantDetails(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    public void editButton() {
        driver.findElement(Edit).click();
        EditName.click();
        EditName.clear();
    }
    public HomePage updateDetails(String update)
    {
        EditName.sendKeys(update);
        SaveButton.click();
        return new HomePage(driver);
    }

}
