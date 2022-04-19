package assignment.week4;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.leafground.com/pages/table.html");
		
	 List<WebElement> columns = driver.findElements(By.xpath("//th"));
	 int columnSize = columns.size();
	 System.out.println("Column Size "+columnSize);
	 
	 List<WebElement> rows = driver.findElements(By.xpath("//tr"));
	 int rowSize = rows.size();
	 System.out.println("Row Size "+rowSize);
	 
	 List<WebElement> lo = driver.findElements(By.xpath("//td[normalize-space()='Learn to interact with Elements']"));
	 System.out.println(lo.size());
	 List<String> percents= new ArrayList<String>();
	 for(int i=1; i<=lo.size(); i++) {
            WebElement percentName = driver.findElement(By.xpath("(//td[normalize-space()='Learn to interact with Elements'])["+i+"]/following-sibling::td[1]"));
            String text = percentName.getText();
            percents.add(text);
            
           }
	 System.out.println("The progress value of 'Learn to interact with ElementT is "+percents);
	 List<Integer> eachList= new ArrayList<Integer>();
	 List<WebElement> numbers = driver.findElements(By.xpath("//td[2]"));
	 System.out.println("Size of Number present is "+numbers.size());
	 for (WebElement valueOfeach : numbers) {
		String eachOne = valueOfeach.getText().replace("%", "");
	    
		eachList.add(Integer.parseInt(eachOne));
	 }
	 System.out.println("Value Available are "+eachList);
	 int leastValue=Collections.min(eachList);
	 driver.findElement(By.xpath("//*[contains(text(),'"+leastValue+"%')]/following::td")).click();
	}

}
