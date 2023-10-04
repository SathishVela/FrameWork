package pom_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProviderwithJXL {
	WebDriver driver;
	String uname;
	String pword;
	@DataProvider(name="logindetails")
	public String[][] logindetails() throws BiffException, IOException {
		String[][] data = excellogindetails();
		return data;
		}
	public String[][] excellogindetails() throws BiffException, IOException {
		FileInputStream excelfile=new FileInputStream("C:\\Users\\Sathis kumar\\Downloads\\logindetails.xls");
		Workbook workbooks=Workbook.getWorkbook(excelfile);
		Sheet sheets1 = workbooks.getSheet("Sheet1");
		int rowscount=sheets1.getRows();		
		int columncount=sheets1.getColumns();
		String testdata[][]=new String [rowscount-1][columncount];
		for (int i = 1; i < rowscount; i++) {
			for (int j = 0; j < columncount; j++) {
				testdata[i-1][j]=sheets1.getCell(j,i).getContents();
			}
		}
		return testdata;
		}
	@BeforeTest
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		}
	@Test(dataProvider = "logindetails")
	public void logincredentials(String uname,String pword) {
		driver.get("https://www.saucedemo.com");
		WebElement UN=driver.findElement(By.id("user-name"));
		UN.sendKeys(uname);
		WebElement PW=driver.findElement(By.id("password"));
		PW.sendKeys(pword);
		WebElement loginbutton=driver.findElement(By.id("login-button"));
		loginbutton.click();
		}
	@AfterTest
	public void closebrowser() {
		driver.quit();
		}
	}
