package pom_datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_OrderandCart {
	public static WebElement product1stone(WebDriver driver) {
		return driver.findElement(By.partialLinkText("Sauce"));
	}
	public static WebElement addcart1stone(WebDriver driver) {
		return driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
	}

}
