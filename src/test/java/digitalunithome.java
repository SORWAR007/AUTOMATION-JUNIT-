import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class digitalunithome extends utilis {

    WebDriver driver;
  @Test
    public  void setup() throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.manage().window().maximize();
       driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.xpath("//input[@id='edit-name']")).sendKeys(utilis.firstname());
        driver.findElement(By.xpath("//input[@id='edit-number']")).sendKeys("0181208841");
        driver.findElement(By.xpath(" //input[@id='edit-date']")).sendKeys("20-5-2024");
        //input[@id='edit-email']
        driver.findElement(By.xpath(" //input[@id='edit-email']")).sendKeys(utilis.firstname()+"@gmail.com");
       driver.findElement(By.xpath("//textarea[@id='edit-tell-us-a-bit-about-yourself-']")).sendKeys("MY NAME IS JISAN");
        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='edit-uploadocument-upload']"));
        uploadElement.sendKeys("D:\\jisan.jpg");
        WebElement element = driver.findElement(By.xpath("//input[@id='edit-age']"));
         JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        WebElement submitbtn = driver.findElement(By.xpath("//input[@id='edit-submit']"));
        executor.executeScript("arguments[0].click();", submitbtn);
        driver.switchTo().alert().accept();
        Thread.sleep(Duration.ofSeconds(300));
        String Exresult=driver.findElement(By.xpath("//*[@id=\"block-pagetitle-2\"]/h1")).getText();
        String Actual= "Thank you for your submission!";
       Assert.assertEquals(Exresult,Actual);
       driver.quit();


    }

}
