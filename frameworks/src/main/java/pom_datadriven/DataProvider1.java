package pom_datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	 String[][] datasource= { {"standard_user","secret_sauce"}, {"Admin1","dummy"},
	 {"Admin1","admin123"}, {"Admin","admin1"} };
	 
	 @DataProvider(name="data") 
	 public String[][] dataprovider() { 
	 return datasource; 
	 }
	 
	@Test(dataProvider = "data")
	public void logincredentials(String uname,String pword) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		WebElement UN=driver.findElement(By.id("user-name"));
		UN.sendKeys(uname);
		WebElement PW=driver.findElement(By.id("password"));
		PW.sendKeys(pword);
		WebElement loginbutton=driver.findElement(By.id("login-button"));
		loginbutton.click();
		
	}	
}
