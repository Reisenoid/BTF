import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestJ1
{
   WebDriver WD;

   @BeforeTest()
   public void beforeTestFixture()
   {
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--remote-allow-origins=*");

       WD = WebDriverManager
               .chromedriver()
               .capabilities(chromeOptions)
               .create();
   }

   @Test()
   public void firstTest()
   {
        WD.get("https://stackoverflow.com/?tab=interesting"); //Действие 1
        WD.manage().window().maximize(); //Действие

        try
        {
            TimeUnit.SECONDS.sleep(5);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace(System.err);
        }

        By buttonChatLocator = By.xpath("/html/body/div[5]/div[2]/div[1]/nav/ol/li[1]/ol/li[6]/a/div/span");
        WebElement buttonChatElement = WD.findElement(buttonChatLocator);
        buttonChatElement.click(); //Действие 3

       try
       {
           TimeUnit.SECONDS.sleep(5);
       }

       catch (InterruptedException e)
       {
           e.printStackTrace(System.err);
       }

       By buttonPeopleLocator = By.xpath("/html/body/div[1]/div[5]/div[5]");
       WebElement buttonPeopleElement = WD.findElement(buttonPeopleLocator);
       buttonPeopleElement.click(); //Действие 4

       try
       {
           TimeUnit.SECONDS.sleep(5);
       }

       catch (InterruptedException e)
       {
           e.printStackTrace(System.err);
       }

       By buttonNextLocator = By.xpath("/html/body/div[1]/div[5]/div[7]/div[21]/a[5]/span");
       WebElement buttonNextElement = WD.findElement(buttonNextLocator);
       buttonNextElement.click(); //Действие 5

       try
       {
           TimeUnit.SECONDS.sleep(5);
       }

       catch (InterruptedException e)
       {
           e.printStackTrace(System.err);
       }

       WebElement roomsHeader = WD.findElement(By.xpath("//*[contains(text(), 'Rooms')]")); //Колхозный автотест на наличия текса Rooms на странице
       Assert.assertTrue(
               roomsHeader.isDisplayed(),
               "Заголовок 'Rooms' не отображается!"
       );

       WD.quit(); //Возможно действие 6
   }

}
