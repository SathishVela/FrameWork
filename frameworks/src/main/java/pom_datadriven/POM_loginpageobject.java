package pom_datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_loginpageobject {
	
	public static WebElement username(WebDriver driver) {
		return driver.findElement(By.id("user-name"));
		}
	public static WebElement password(WebDriver driver) {
		return driver.findElement(By.id("password"));
		}
	public static WebElement loginbutton(WebDriver driver) {
		return driver.findElement(By.id("login-button"));
		}	
	}

