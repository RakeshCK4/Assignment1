package com.assignmentone.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {

	public static WebDriver driver;
	static List<String> path;

	public static void initialize() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		path = new ArrayList<String>();
	}

	// Take screenshot
	public static void takeScreenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./ScreenShots/"+name+"-"+ (new Date().getTime()) + ".png");
		FileUtils.copyFile(source, destination);

		path.add(destination.getAbsolutePath());
	}

	// To Generate Report
	public void extentReport() throws IOException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report/Extent Rport -" + (new Date().getTime()) + ".html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest("AmazonTest");
		logger.log(Status.INFO, "Test run status");
		logger.log(Status.PASS, "Test pass Status");
		for (String p : path) {
			logger.addScreenCaptureFromPath(p);
		}

		extent.flush();
	}

	// End the driver excution
	public static void terminate() {
		driver.close();
	}
}
