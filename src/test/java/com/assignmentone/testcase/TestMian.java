package com.assignmentone.testcase;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assignmentone.base.BaseTest;
import com.assignmentone.pages.HomePage;

public class TestMian extends BaseTest {

	HomePage hp;
	JavascriptExecutor js;

	@BeforeTest
	public void setUp() {
		initialize();
		js = (JavascriptExecutor) driver;
		hp = new HomePage(driver);
	}

	@Test
	public void addItemToCart() throws IOException {

		// search for an Item
		hp.searchItem();

		// scroll the page
		js.executeScript("window.scrollBy(0,200)");

		// get Item screenshot
		takeScreenShot("View Item image");
		
		// click an Item
		hp.chooseItem();

		// Add to cart
		hp.addToCart();

		// proceed to cart
		hp.viewCart();

		// get Cart screenshot
		takeScreenShot("Cart Item image");
	}

	@AfterTest
	public void close() throws IOException {
		extentReport();
		driver.quit();
	}
}
