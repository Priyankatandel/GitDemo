import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.emulation.Emulation;

public class CdpCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		Map deviceMatrics=new HashMap();
		deviceMatrics.put("width", 600);
		deviceMatrics.put("height", 1000);
		deviceMatrics.put("deviceScaleFactor", 50);
		deviceMatrics.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMatrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
	}

}
