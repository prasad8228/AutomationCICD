package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
		public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
		
	//	List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//page factory design pattern
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementAppaer(productsBy);
		return products;
	}
	
	public WebElement getProductname(String productName) {
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addproductTocart(String productName) throws InterruptedException {
		WebElement prod = getProductname(productName);
		prod.findElement(addTocart).click();
		waitForElementAppaer(toastMessage);
		waitForElementDisAppaer(spinner);
	}
	
	
	
	
	
	
	
	
	 
	 

}
