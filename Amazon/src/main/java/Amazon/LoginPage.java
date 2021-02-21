package Amazon;

import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

//import org.apache.log4j.Logger;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	static WebDriver driver;
	static Obj OBJ=new Obj();
	//static public Logger log = Logger.getLogger(LoginPage.class);
	
	public static void openbrowser(String url){	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//log.info("Log 4 j Working fine");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
	
	public static WebElement id (String id) {
		return driver.findElement(By.id(id));
		
		
	}
	
	public static WebElement xpath (String xpath) {
		return driver.findElement(By.xpath(xpath));
		
	}
	
	public static void _mangesh(String log)
	
	{
		
		System.out.println(log);
	}
	
	
	public static void login () throws Exception {
		id(OBJ.userid_id).sendKeys(OBJ.userid);
		_mangesh("User Name Entered Within The User Field");
		
		id(OBJ.con_btn_id).click();
		_mangesh("Continu button clicked");
		
		id(OBJ.userpassword_id).sendKeys(OBJ.userpassword);
		_mangesh("Password Entered Successfully");
		
		id(OBJ.signin_id).click();
		_mangesh("Login Successfully Done");
		
		Thread.sleep(5000);
		boolean log_veriy=xpath(OBJ.page_logo_xpath).isDisplayed();
		System.out.println(log_veriy);
		
		if(log_veriy==true) {
			
			_mangesh("Ok");
			
		}else
		{
			_mangesh("Not Ok");
			
		}
	}
	
	public static void menue () throws InterruptedException  {
	id(OBJ.menue_id).click();
	_mangesh(" Menue Clicked successfully");
	
	xpath(OBJ.BestSellers_xpath).click();
	_mangesh("Best seller clicked successfully");
	
	xpath(OBJ.amazon_Launchpad_xpath).click();
	_mangesh("amazon launchoad click successfully");
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	boolean logo_verify = xpath(OBJ.amazon_Launchpad_logo_xpath).isDisplayed();
	
	if (logo_verify == true) {
		System.out.println("amazon Launchpad logo showing - Passed");
	}
	else {
		System.out.println("amazon Launchpad logo not showing - Failed");
	}

	}
	}
