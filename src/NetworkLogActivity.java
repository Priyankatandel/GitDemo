import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.Request;
import org.openqa.selenium.devtools.v111.network.model.Response;


public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//Event wiill get fired
		devTools.addListener(Network.requestWillBeSent(), request->
		{
			Request req=request.getRequest();
			//System.out.println(req.getUrl());
			
		});
		devTools.addListener(Network.responseReceived(), response->
		{
			
			Response res=response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+"is falling with status code"+res.getStatus());
			}
				
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn-primary")).click();
	}

}
