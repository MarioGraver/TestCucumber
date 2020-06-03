package com.cucumberPepinazo.com;



import static junit.framework.Assert.*;
import static junit.framework.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


public class StepsDef {
	
	public WebDriver driver;

	@Before
	public void setUpTest() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDownTest() {
		//driver.quit();
	}
  @Given("^I have open the browser$")
  public void I_have_open_the_browser() {
		assertNotNull(driver);
	}

  @When("^I open Facebook website$")
  public void I_open_Facebook_website() {
		driver.get("https://facebook.com");
	}

  @Then("^Login button should exist$")
  public void Login_button_exists() {
		String loginButtonXpath = "//input[@data-testid='royal_login_button']";
		WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));
		assertTrue(loginButton.isDisplayed());
	}
  @And("^I click the login button$")
	public void I_click_the_login_button() {
		String loginButtonXpath = "//input[@data-testid='royal_login_button']";
		WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));
		loginButton.click();
		
	}
  @Then("^Facebook asks me to enter credentials$")
	public void Facebook_asks_me_to_enter_credentials() {
	    
		WebElement emailField1 = driver.findElement(By.name("email"));
		WebElement passField1 = driver.findElement(By.name("pass"));
		//assertTrue(emailField1.isDisplayed() && passField1.isDisplayed());

	}
  @And("^I login using cell phone number$")
	public void I_login_using_cell_phone_number() {
		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passField = driver.findElement(By.id("pass"));
		String loginButtonXpath = "//input[@data-testid='royal_login_button']";
		WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));

		emailField.sendKeys("111@gmail.com");

		passField.sendKeys("pass");
		

		loginButton.click();
	}
  @Then("^I can see Home Page$")
	public void I_can_see_Home_Page() {
		WebElement facebookLogo = driver.findElement(By.cssSelector("[data-click='bluebar_logo']"));
		WebElement searchBox = driver.findElement(By.name("q"));
		assertTrue(facebookLogo.isDisplayed() && searchBox.isDisplayed());
	}
  @And("^I logout the session$")
	public void I_logout_the_session() {
		WebElement optionsButton = driver.findElement(By.id("userNavigationLabel"));
		optionsButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement closeBtnOpt = driver.findElement(By.xpath("(//span[@class='_54nh'])[7]"));
		closeBtnOpt.click();
		
	}
}
