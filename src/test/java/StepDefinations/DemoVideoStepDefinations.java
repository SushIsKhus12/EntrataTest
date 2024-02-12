package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.EntrataDemoVideoPO;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoVideoStepDefinations {
	public WebDriverWait wait;
	TestContextSetup TC;
	 public DemoVideoStepDefinations(TestContextSetup TC)
	 {
		 this.TC=TC;
	 }
	
	@When("User is on the entrata home page")
	public void user_is_on_the_entrata_home_page() throws InterruptedException {
		TC.driver.getCurrentUrl();
		Thread.sleep(5000);
	}

	@When("User clicks on the Watch Demo")
	public void user_clicks_on_the_watch_demo() throws InterruptedException {
		
		EntrataDemoVideoPO eDemo= new EntrataDemoVideoPO(TC.driver);
		
		wait = new WebDriverWait(TC.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Watch Demo']")));
		eDemo.watch_demo();
		Thread.sleep(3000);
	
	}

	@When("User enters the {string} {string} {string} {string} and  {string}")
	public void user_enters_the_and(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
		EntrataDemoVideoPO eDemo= new EntrataDemoVideoPO(TC.driver);

		eDemo.first_nme(string);
		eDemo.last_nme(string2);
		eDemo.mail(string3);
		eDemo.comp(string4);
		eDemo.mob(string5);
		
		Thread.sleep(3000);
	}

	@When("User enters the count and {string}")
	public void user_enters_the_count_and(String string) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) TC.driver;
		js.executeScript("window.scrollBy(0,100)");
		
		wait = new WebDriverWait(TC.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Unit_Count__c")));
		
		TC.driver.findElement(By.id("Unit_Count__c")).click();
		Select sc= new Select(TC.driver.findElement(By.id("Unit_Count__c")));
		sc.selectByValue("1 - 10");
		//Thread.sleep(3000);
		
	
		EntrataDemoVideoPO eDemo= new EntrataDemoVideoPO(TC.driver);
		eDemo.titl_e(string);
		
	}

	@Then("User goes to the home page")
	public void user_goes_to_the_home_page() throws InterruptedException {
		Thread.sleep(3000);

		TC.driver.navigate().back();
		TC.driver.quit();
	}
}
