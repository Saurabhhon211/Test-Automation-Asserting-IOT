package com.Kiran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Studyopedia {

	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		// Test 1:: Check NodeMcu Connected to 5G network
		driver.get("http://localhost/loginsystem/AddCard.php");
		String url3 = driver.getCurrentUrl();
		String pageTitle2 = driver.getTitle();
		if ("Add a new User".equals(pageTitle2)) {
			System.out.println("Test Case 1 Passed :- NodeMCU connected to Network");
		} else {
			System.out.println("Test Case 1: NodeMCU not connected to Network");
		}

		Thread.sleep(10000); // Delay for 2 seconds

		// Test 2:: Open the Page and verify page
		driver.get("http://localhost/loginsystem/AddCard.php");
		String url = driver.getCurrentUrl();
		System.out.println("Current url: " + url);
		String pageTitle = driver.getTitle();
		if ("Add a new User".equals(pageTitle)) {
			System.out.println("Test Case 2 Passed :- Registered page found");
		} else {
			System.out.println("Test Case 2: Registered page found");
		}

		Thread.sleep(10000); // Delay for 2 seconds

		// Test 3:: Check the Empty entry
		driver.findElement(By.xpath("//*[@id=\"lo\"]")).click();
		WebElement element = driver
				.findElement(By.xpath("/html/body/div[1]/div[1]/form/table/tbody/tr[1]/td[2]/input"));
		WebElement element1 = driver
				.findElement(By.xpath("/html/body/div[1]/div[1]/form/table/tbody/tr[2]/td[2]/input"));
		if (element != null || element1 != null) {
			System.out.println("Test Case 3 Failed: Element is present on the field");
		} else {
			System.out.println("Test Case 3 Passed: Element is not present on the field");
		}

		Thread.sleep(10000); // Delay for 2 seconds

		// Test 4:: pin the Card
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/input")).sendKeys("442399125");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/button[2]/img")).click();
		WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/label"));
		if (element2.isDisplayed()) {
			System.out.println("Test Case 4 Passed: Card pin");
		} else {
			System.out.println("Test Case 4 Failed: Card not pin");
		}

		Thread.sleep(10000); // Delay for 2 seconds

		// Test 5:: Enter name, number and role for card
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/table/tbody/tr[1]/td[2]/input")).sendKeys("Dipjyot");
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("83");
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"lo\"]")).click();
		WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/label"));
		if (element3.isDisplayed()) {
			System.out.println("Test Case 5 Passed: New Card Added");
		} else {
			System.out.println("Test Case 5 Failed: New Card Failed to Add");
		}

		Thread.sleep(10000); // Delay for 2 seconds

		// Test 6:: Open the Attendance Log
		driver.findElement(By.xpath("/html/body/header/a")).click();
		String pageTitle1 = driver.getTitle();
		if ("Users Logs".equals(pageTitle1)) {
			System.out.println("Test Case 6 Passed :- Registered page found");
		} else {
			System.out.println("Test Case 6: Registered page found");
		}
		Thread.sleep(10000);
		driver.quit();
	}

}
