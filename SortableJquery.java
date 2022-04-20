package assignment.week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableJquery {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		 List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
         WebElement w1 = list.get(0);
         WebElement w2 = list.get(4);
         Point location = w2.getLocation();
         int x = location.getX();
         int y = location.getY();
         Actions action = new Actions(driver);
         action.dragAndDropBy(w1, x, y).perform();
	}

}
