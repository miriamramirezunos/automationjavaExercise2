package MyPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Setup {
	public WebDriver driver;
	
	private String dUrl, dtitle,  
	fbUrl = "https://www.facebook.com/",
	fbTitle= "Facebook - Log In or Sign Up"; 
	
	public String getDUrl(){
        return dUrl;
    }
    public void setDUrl(String dUrl){
        this.dUrl = dUrl;
    }
    
	public String getDTitle(){
        return dtitle;
    }
    public void setDTitle(String dtitle){
        this.dtitle = dtitle;
    }
		
  @Test  
  public void exercise2() { 
	  // 1 - Go to facebook.com
	  System.out.println("Opening google chrome browser");
	  driver.get(fbUrl);	
	  // 2 - Validate that URL is correct
	  setDUrl(driver.getCurrentUrl()); 
	  Assert.assertEquals(getDUrl(), fbUrl);
	  // 3 - Validate the Title of the page, should be : Facebook - Log In or Sign Up
	  setDTitle(driver.getTitle()); 
	  Assert.assertEquals(getDTitle(), fbTitle);
	  // 4 - Fill all Sign Up section (do not click on Sign Up button) 
	  MyPackage.Execution.fillSignUp(driver);
	  // 5 - Choose a different Birthday not the default one 
	  MyPackage.Execution.chooseBirthday(driver);
	  // 6 - Click on Female
	  MyPackage.Execution.clickFemale(driver);
	  // 7 - Validate following text is present: Connect with friends and the world around you on Facebook.
	  MyPackage.Execution.validateText(driver);
	  // 8 - Click on Forgot Account?
	  MyPackage.Execution.clickForgot(driver);
	  // 9 - Validate following text is displayed: “Find Your Account”.
	  MyPackage.Execution.validateTextFindAccount(driver);	  
	  // 10 - Enter a valid email but non existing one and click on search.
	  MyPackage.Execution.enterEmail(driver);
	  // 11 - Validate Error message is displayed (No search Results).
	  MyPackage.Execution.validateNoResults(driver);
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  System.out.println("End");
  }
  
@BeforeClass
  public void beforeClass() {
	  System.out.println("launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers2\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  System.out.print("\nBrowser close");
	  driver.quit();
  }

}
