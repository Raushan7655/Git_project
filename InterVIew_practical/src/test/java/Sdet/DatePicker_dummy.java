package Sdet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_dummy {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
String date="29";

driver.findElement(By.xpath("//*[@id=\"dob\"]")).click();
Select mon=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
mon.selectByVisibleText("Jan");
Select year=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
year.selectByVisibleText("2022");

List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']"));
for(WebElement expDate:dates)
{
	String dt = expDate.getText();
	if(dt.equals(date))
	{
		expDate.click();
		break;
	}
}
	}

}
