package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browsername) {
		 if (browsername.equalsIgnoreCase("firefox") ) {
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  }else if (browsername.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		  }else if (browsername.equalsIgnoreCase("edge_chromimum")) {
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		  }else {
			 throw new RuntimeException("Please enter correct support browser");
		  }
		 
		 return driver;
	}
	
	protected WebDriver getBrowserDriver(String browsername, String appURL) {
		 if (browsername.equalsIgnoreCase("firefox") ) {
			 WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  }else if (browsername.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		  }else if (browsername.equalsIgnoreCase("edge_chromimum")) {
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		  }else {
			 throw new RuntimeException("Please enter correct support browser");
		  }
		 driver.get(appURL);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 return driver;
	}
	
}
