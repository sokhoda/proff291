import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by i.gonchar on 3/11/2016.
 */
public class LoginTest extends BaseTest {
    @Test
    public void loginTest() throws InterruptedException {
        jsExecutor.executeScript("document.getElementById('inputLogin').value='Igor';");
        jsExecutor.executeScript("document.getElementById('inputPassword').value='aaaaaaaa';");

        WebElement loginButton = driver.findElement(By.cssSelector("#signInButton"));
        Thread.sleep(1000);
        loginButton.click();

        loginButton = driver.findElement(By.id("choicePageHeader"));
        String actualHeader = loginButton.getText();
        String expected = "Welcome, Igor, you was authorized!";
        Assert.assertEquals(expected, actualHeader);
    }
}
