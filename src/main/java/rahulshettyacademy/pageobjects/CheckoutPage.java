package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.AbstractComponent;



public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	 JavascriptExecutor executor = (JavascriptExecutor) driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css = ".action__submit")
	 private WebElement submit;
	
	

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementAppaer(By.cssSelector(".ta-results"));
		selectCountry.click();
		//waitForClickable(submit);
		
		
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException
	{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(submit).click().perform();
		//Thread.sleep(5000);
		//submit.click();
		//Thread.sleep(4000);
//		executor.executeScript("arguments[0].click();", submit);
//		executor.executeScript("window.scrollBy(0,600)");
//			executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
		return new ConfirmationPage(driver);
		
		
	}

}
