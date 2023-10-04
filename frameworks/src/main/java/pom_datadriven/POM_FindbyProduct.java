package pom_datadriven;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_FindbyProduct {
	@FindBy(partialLinkText="Sauce")
	public static WebElement product1stone;
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	public static WebElement addcart1stone;
}
