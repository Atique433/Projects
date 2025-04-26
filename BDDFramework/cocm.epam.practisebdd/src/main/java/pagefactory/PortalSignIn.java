package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static constant.PortalPageConstant.Portal_URL;

public class PortalSignIn
{
    WebDriver driver;
    public PortalSignIn(WebDriver driver)
    {
        this.driver =driver;
    }
    private final By signUp=By.xpath("//a[text() ='Sign up']");
    private final By signUpClick=By.id("form_submit");
    private final By signInClick=By.id("form_submit");

    public void baseUrl()  throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get(Portal_URL);

    }
    public void signIn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(signUp).click();
        WebElement signUpEmail=driver.findElement(By.id("exampleInputEmail1"));
        signUpEmail.sendKeys("Anis@google.com");
        WebElement signUpPassword=driver.findElement(By.id("exampleInputPassword1"));
        signUpPassword.sendKeys("Rahman@878");
        driver.findElement(signUpClick).click();
        Thread.sleep(1000);
        WebElement signInEmail=driver.findElement(By.id("exampleInputEmail1"));
        signInEmail.sendKeys("Anis@google.com");
        WebElement signInPassword=driver.findElement(By.id("exampleInputPassword1"));
        signInPassword.sendKeys("Rahman@878");
        driver.findElement(signInClick).click();
    }
    public HomePage navigateToHomePage()

    {
        return new HomePage(driver);
    }
}
