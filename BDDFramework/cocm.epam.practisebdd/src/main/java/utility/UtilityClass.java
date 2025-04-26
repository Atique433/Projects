package utility;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class UtilityClass {

    public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
    {
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file,new File("src/test/java/screen_shot/"+fileName+".png"));
    }
}
