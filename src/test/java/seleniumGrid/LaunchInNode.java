package seleniumGrid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchInNode {
	
	@Test
	public void gridTest() throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setPlatform(Platform.WIN10);
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"), options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chromedriver.chromium.org/downloads");
		
		
	}

}
