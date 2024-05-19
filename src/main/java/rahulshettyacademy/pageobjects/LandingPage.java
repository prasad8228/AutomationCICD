package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
		public LandingPage(WebDriver driver) {
			
		super(driver);
		//initialize driver	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//WebElement userEmail =  driver.findElement(By.id("userEmail"));//.sendKeys("dg@gmail.com");
	//driver.findElement(By.id("userPassword")).sendKeys("123!@#Cmgi");
	//driver.findElement(By.id("login")).click();
	
	//page factory design pattern
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement PasswordEle;
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		PasswordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	 
	 

}
