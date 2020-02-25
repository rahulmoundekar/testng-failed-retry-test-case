package com.app.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.app.listners.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sentrifugo {

	private static WebDriver driver;

	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.sentrifugo.com/index.php/");
	}

	@Test(retryAnalyzer = Retry.class)
	public void login() {

		driver.findElement(By.id("username")).sendKeys("abc");

		driver.findElement(By.id("password")).sendKeys("abc123");

		driver.findElement(By.id("loginsubmit")).click();

		driver.findElement(By.id("logoutbutton")).click();

		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
