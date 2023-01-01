package Sdet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_RedBus {
	public static void main(String [] arg)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//label[@for='onward_cal']")).click();
		String day="12";
		String month="Aug";
		String year="2023";
		while(true)
		{
			String month_year = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[]=month_year.split(" ");
			String mon=arr[0];
			String yearr=arr[1];
			
			if(mon.equals(month)&& yearr.equals(year))
			   break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}
            List<WebElement> alldate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
            for(WebElement date:alldate)
            {
            String dt = date.getText();
            if(dt.equals(day))
            {
            	date.click();
            	break;
            }
            }
		
	
	}
 
}
