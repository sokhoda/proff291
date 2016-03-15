import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by i.gonchar on 3/10/2016.
 */
public class AddClientTest extends BaseTest {
/*    @FindBy(id = "signInButton")
    private WebElement loginButton;*/


    @Test
    public void addClientTest() throws InterruptedException {
        jsExecutor.executeScript("document.getElementById('inputLogin').value='Igor';");
        jsExecutor.executeScript("document.getElementById('inputPassword').value='aaaaaaaa';");

        WebElement loginButton = driver.findElement(By.cssSelector("#signInButton"));
       // driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Thread.sleep(500);
        loginButton.click();

        loginButton = driver.findElement(By.cssSelector("#clientRB"));
        Thread.sleep(500);
        loginButton.click();

        loginButton = driver.findElement(By.cssSelector("#choicePageAddButton"));
        Thread.sleep(500);
        loginButton.click();

        jsExecutor.executeScript("document.getElementById('clientName').value='Igor';");
        jsExecutor.executeScript("document.getElementById('clientSurname').value='Surname';");
        jsExecutor.executeScript("document.getElementById('clientPhone').value='1111111';");
        jsExecutor.executeScript("document.getElementById('clientAddress').value='Address';");
        loginButton = driver.findElement(By.cssSelector("#addClientButton"));
        Thread.sleep(500);
        loginButton.click();

        String expectedText = "Client with such name: Igor and phone: 1111111 already exists";
        boolean containsText = driver.getPageSource().contains(expectedText);

        Assert.assertTrue(containsText);
    }
}
