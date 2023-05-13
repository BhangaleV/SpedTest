package com.testNitin.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	WebDriver driver;
	
	@BeforeSuite
	public void LaunchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
	}
	
	@Test
	public void EnterLoginDetails() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_ViewMyDetails")).click();
		
	}
	
	@Test
	public void VerifyMyInfo() {
		System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
		driver.quit();
	}
	
	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		driver.quit();
	}
}
