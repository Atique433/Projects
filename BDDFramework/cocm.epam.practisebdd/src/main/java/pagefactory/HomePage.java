package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class HomePage
{
    private final By HamBurgerMenu=By.className("uui-toggle-box");
    private final By ProgramsManagement=By.xpath("(//span[text()='Programs management'])[2]");
    private final By Participant=By.xpath("(//span[text()='Participants'])[2]");
    private final By Batch=By.name("batch");
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void portalHomePage() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(HamBurgerMenu).click();
        driver.findElement(ProgramsManagement).click();
        driver.findElement(Participant).click();
        driver.findElement(Batch).click();
        WebElement selectBatch=driver.findElement(By.name("batch"));
        Select selectTesting = new Select(selectBatch);
        selectTesting.selectByIndex(0);
    }
    public AddParticipantDetails navigateToAddParticipant()

    {
        return new AddParticipantDetails(driver);
    }
    public ReadParticipantDetails navigateToReadParticipant()

    {
        return new ReadParticipantDetails(driver);
    }
    public UpdateParticipantDetails navigateToUpdateParticipant()

    {
        return new UpdateParticipantDetails(driver);
    }
    public DeleteParticipantDetails navigateToDeleteParticipant() {
        return new DeleteParticipantDetails(driver);
    }
    public VerifyParticipant navigateToVerifyParticipant(){
        return new VerifyParticipant(driver);
    }
}
