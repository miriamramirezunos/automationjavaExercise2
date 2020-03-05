package MyPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Execution {
	
  public static void fillSignUp(WebDriver driver) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#u_0_m")));
	  driver.findElement(By.cssSelector("#u_0_m")).sendKeys("Mfirst Name");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#u_0_o")));
	  driver.findElement(By.cssSelector("#u_0_o")).sendKeys("Mlast Name");	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#u_0_r")));
	  driver.findElement(By.cssSelector("#u_0_r")).sendKeys("miriautomationjavae2@yopmail.com");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#u_0_u")));
	  driver.findElement(By.cssSelector("#u_0_u")).sendKeys("miriautomationjavae2@yopmail.com");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#u_0_w")));
	  driver.findElement(By.cssSelector("#u_0_w")).sendKeys("miriPWjavae2");	  
  }
  
  public static void chooseBirthday(WebDriver driver) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#month")));
	  WebElement sMonthElement = driver.findElement(By.cssSelector("#month")); 
	  Select sMonth= new Select(sMonthElement); 
	  sMonth.selectByValue("12");	  	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#day")));
	  WebElement sDayElement = driver.findElement(By.cssSelector("#day")); 
	  Select sDay= new Select(sDayElement); 
	  sDay.selectByValue("31");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#year")));
	  WebElement sYearElement = driver.findElement(By.cssSelector("#year")); 
	  Select sYear= new Select(sYearElement); 
	  sYear.selectByValue("2000");
  }
  
  public static void clickFemale(WebDriver driver) {
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.cssSelector("#u_0_y>span>span:nth-of-type(1)")).click();	  
  }
  
  public static void validateText(WebDriver driver) {
	  String dtext, 
	  	connectText = "Connect with friends and the world around you on Facebook."; 
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#globalContainer>div>div>div>div>div>h2")));
	  dtext = driver.findElement(By.cssSelector("#globalContainer>div>div>div>div>div>h2")).getText(); 
	  Assert.assertEquals(dtext, connectText);
	  WebElement signUpButton = driver.findElement(By.cssSelector("#u_0_13")); 
	  wait.until(ExpectedConditions.elementToBeClickable(signUpButton));	  
  }
  
  public static void clickForgot (WebDriver driver) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement linkForgot = driver.findElement(By.cssSelector("#login_form>table>tbody>tr:nth-of-type(3)>td>div>a"));
	  wait.until(ExpectedConditions.visibilityOf(linkForgot));
	  linkForgot.click();
  }

  public static void validateTextFindAccount (WebDriver driver) {
	  String dtext, 
	  	findAccountText = "Find Your Account"; 
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identify_yourself_flow>div>div>div>div:nth-of-type(2)>h2")));
	  dtext = driver.findElement(By.cssSelector("#identify_yourself_flow>div>div>div>div:nth-of-type(2)>h2")).getText(); 
	  Assert.assertEquals(dtext, findAccountText);	  
  }
  
  public static void enterEmail(WebDriver driver) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identify_email")));
	  driver.findElement(By.cssSelector("#identify_email")).sendKeys("miriautomationjavae2@yopmail.com");
	  WebElement searchButton = driver.findElement(By.cssSelector("#did_submit")); 
	  wait.until(ExpectedConditions.elementToBeClickable(searchButton)); 
	  searchButton.click();
  }
  
  public static void validateNoResults(WebDriver driver) {
	  String dtext, 
	  	findAccountText = "No Search Results"; 
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identify_yourself_flow>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")));
	  dtext = driver.findElement(By.cssSelector("#identify_yourself_flow>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")).getText();
	  System.out.println(dtext);
	  Assert.assertEquals(dtext, findAccountText);	  	  
  }
}
