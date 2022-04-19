package assignment.week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		WebElement l1 = list.get(2);
		WebElement l2 = list.get(0);
		Actions action = new Actions(driver);
		action.clickAndHold(l1)
		.moveToElement(l2)
		.release(l2)
		.build().perform();

	}

}
