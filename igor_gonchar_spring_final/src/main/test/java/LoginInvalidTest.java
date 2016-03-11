import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by i.gonchar on 3/11/2016.
 */
public class LoginInvalidTest extends BaseTest {
    @Test
    public void loginInvalidTest() throws InterruptedException {
        jsExecutor.executeScript("document.getElementById('inputLogin').value='Igor';");
        jsExecutor.executeScript("document.getElementById('inputPassword').value='aaaaaaa';");

        WebElement loginButton = driver.findElement(By.cssSelector("#signInButton"));
        Thread.sleep(500);
        loginButton.click();

        String expectedText = "No such registered user";
        boolean containsText = driver.getPageSource().contains(expectedText);

        Assert.assertTrue(containsText);
    }
}
