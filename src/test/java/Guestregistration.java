import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.time.Duration;



public class Guestregistration extends utilis{

    WebDriver driver;

    @Test
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("first_name")).sendKeys(utilis.firstname());
        driver.findElement(By.id("last_name")).sendKeys(utilis.lastname());
        driver.findElement(By.id("user_email")).sendKeys(firstname() + "@gmail.com");
        driver.findElement(By.id("user_pass")).sendKeys("123Jisan$");
        driver.findElement(By.id("radio_1665627729_Male")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dateElement = driver.findElements(By.className("ur-flatpickr-field")).get(0);
        js.executeScript("arguments[0].setAttribute('value','1999-12-08')", dateElement);
        driver.findElement(By.id("input_box_1665629217")).sendKeys("bangladeshi");
        driver.findElement(By.xpath("//input[@id='phone_1665627880']")).sendKeys("0173187916");
        Select country = new Select(driver.findElement(By.xpath("//select[@id='country_1665629257']")));
        country.selectByVisibleText("Bangladesh");
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//input[@id='phone_1665627865']")).sendKeys("0173187945");
        WebElement dateElement1 = driver.findElements(By.className("ur-flatpickr-field")).get(1);
        js.executeScript("arguments[0].setAttribute('value','2024-08-02')", dateElement1);
        driver.findElement(By.xpath("//div[@id='date_box_1665629845_field']//input[1]")).sendKeys("2024-8-15");
        driver.findElement(By.xpath("//input[@id='number_box_1665629930']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id='input_box_1665630010']")).sendKeys("3");
        driver.findElement(By.xpath("//textarea[@id='textarea_1665630078']")).sendKeys("Businessman");
        driver.findElement(By.xpath("//input[@id='radio_1665627931_Yes']")).click();
        driver.findElement(By.xpath("//input[@id='radio_1665627997_Shared Room']")).click();
        driver.findElement(By.xpath("//input[@id='radio_1665628131_Glutten Allergy']")).click();
        Select activities = new Select(driver.findElement(By.xpath("//select[@id='select_1665628361']")));
        activities.selectByVisibleText("Luncheon");
        driver.findElement(By.xpath("//input[@id='privacy_policy_1665633140']")).click();
        WebElement submitbtn = driver.findElement(By.cssSelector(("button[type='submit']")));
        submitbtn.click();
        String actualtext=driver.findElement(By.xpath("//ul[text()='User successfully registered.']")).getText();

        String Expectedtext="User successfully registered.";

        Assert.assertEquals(actualtext,Expectedtext);


    }
}
