import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    protected WebDriver driver = new FirefoxDriver();
    protected JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    @Before
    public void setUp(){

        driver.get("http://localhost:8085/");
       // driver.get("http://facebook.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
