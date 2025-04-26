package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddParticipantDetails
{
    @FindBy(name ="taskName")
    private WebElement NAME;
    @FindBy(name ="taskStatus")
    private WebElement EMAIL;
    @FindBy(name ="gender")
    private WebElement GENDER;
    @FindBy(name ="status")
    private WebElement STATUS;
    @FindBy(name ="isfaculty")
    private WebElement FACULTY;
    @FindBy(name ="collegeName")
    private WebElement COLLEGE;
    @FindBy(name ="mobile")
    private WebElement MOBILE;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement save;
    private final By AddParticipant=By.xpath("(//button[@class='uui-button blue'])[1]");

    WebDriver driver;
    public AddParticipantDetails(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void addDetails(String name, String email, String gender)
    {
        driver.findElement(AddParticipant).click();
        NAME.click();
        NAME.sendKeys(name);
        EMAIL.click();
        EMAIL.sendKeys(email);
        GENDER.click();
        Select selectGender = new Select(GENDER);
        selectGender.selectByVisibleText(gender);

    }
     public HomePage addAdditionalDetails(String status, String isFaculty, String college, String mobile) throws InterruptedException {
         STATUS.click();
         Select selectStatus = new Select(STATUS);
         selectStatus.selectByVisibleText(status);
         FACULTY.click();
         Select selectIsFaculty = new Select(FACULTY);
         selectIsFaculty.selectByVisibleText(isFaculty);
         COLLEGE.click();
         Select selectCollegeName = new Select(COLLEGE);
         selectCollegeName.selectByVisibleText(college);
         MOBILE.click();
         MOBILE.sendKeys(mobile);
         Thread.sleep(1000);
         save.click();
         return new HomePage(driver);
     }
}
