package seleniumP3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestP3 {

public static void main(String[] args) {
// TODO Auto-generated method stub

//setting the driver executable
System.setProperty("webdriver.chrome.driver", "C:\\Users\\ececa\\Desktop\\SUMMER 21\\CS 458\\Project 1\\SeleniumTest\\chromedriver.exe");

//Initiating your chromedriver
WebDriver driver=new ChromeDriver();

//Applied wait time
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
driver.manage().window().maximize();

//open browser with desired URL
driver.get("http://127.0.0.1:5500/index.html");


WebElement latitudeElement = driver.findElement(By.cssSelector("input[name='lat']"));
WebElement longitudeElement = driver.findElement(By.cssSelector("input[name='lng']"));
WebElement submitButtonElement = driver.findElement(By.cssSelector("input[name='locationBtn']"));


// PART A
// Test case #1: Displaying the given location correctly with a marker
latitudeElement.sendKeys("39.90430");
longitudeElement.sendKeys("32.83665560000001");
submitButtonElement.click();

// Test case #2: Testing the out of range values (below)
latitudeElement.sendKeys("-91");
longitudeElement.sendKeys("-181");
submitButtonElement.click();

//Test case #3: Testing for out of range values (above)
latitudeElement.sendKeys("91");
longitudeElement.sendKeys("181");
submitButtonElement.click();

// Test #4: Testing alphanumeric input
latitudeElement.sendKeys("91abc");
longitudeElement.sendKeys("181def");
submitButtonElement.click();

//Test #5: Testing symbol input
latitudeElement.sendKeys("%-*");
longitudeElement.sendKeys("?(^");
submitButtonElement.click();

//Test #6: Testing null value
latitudeElement.sendKeys("");
longitudeElement.sendKeys("");
submitButtonElement.click();

//Test #7: Testing whitespace characters
latitudeElement.sendKeys(" ");
longitudeElement.sendKeys("		");
submitButtonElement.click();


// PART B
// Test #1: Testing if the method can be called properly
WebElement bigBenElement = driver.findElement(By.cssSelector("button[name='bigBenBtn']"));
bigBenElement.click();

// PART C
//Test #1: Testing if the method can be called properly
WebElement earthCoreElement = driver.findElement(By.cssSelector("button[name='earthCoreBtn']"));
earthCoreElement.click();

//closing the browser
//driver.close();

}

}