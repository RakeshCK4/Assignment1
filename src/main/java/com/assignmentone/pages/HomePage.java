package com.assignmentone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assignmentone.base.BaseTest;

public class HomePage extends BaseTest {

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// search for an item & go to view list
	By searchBox = By.cssSelector("#twotabsearchtextbox");
	By searchButton = By.cssSelector((".nav-search-submit"));

	// click an item
	By shoe = By.xpath(
			"//*[text()='La Milano Mens Cap Toe Oxford Leather Lace Up Classic Comfortable Modern Formal Business Dress Shoes for Men']");

	// Add to cart
	By cartAdd = By.id("add-to-cart-button");

	// proceed to cart
	By goToCart = By.id("hlb-view-cart-announce");

	public void searchItem() {
		driver.findElement(searchBox).sendKeys("Lancer Men's Formal Shoes");
		driver.findElement(searchButton).click();
	}

	public void chooseItem() {
		driver.findElement(shoe).click();
	}

	public void addToCart() {
		driver.findElement(cartAdd).click();
	}

	public void viewCart() {
		driver.findElement(goToCart).click();
	}

}
