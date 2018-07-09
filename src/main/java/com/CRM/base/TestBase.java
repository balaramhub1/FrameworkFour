package com.CRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.util.DriverEventListener;
import com.CRM.util.TestUtil;


public class TestBase {
	
	public static WebDriver drv;
	public Properties prop;
	public static DriverEventListener webEventListener;
	public static EventFiringWebDriver e_drv;
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	
	
	public void init(){

		// Initializing the Log4j
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		readProp();
		getBrowser(prop.getProperty("browser"));
		
		// initializing the object of EventFiringWebDriver before navigating to url
		e_drv=new EventFiringWebDriver(drv);
		
		// initializing the object of DriverEventListener to register it with EventFiringWebDriver
		webEventListener=new DriverEventListener();
		e_drv.register(webEventListener);
		drv=e_drv;
		
		getUrl(prop.getProperty("url"));
		
	}
	
	public void readProp(){
		try{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/CRM/config/config.properties");
		prop.load(fis);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	
	}
	
	// Method to select the browser
	public void getBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			log.info("Creating object of :"+browser);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			drv=new ChromeDriver();
		
		}
		
		else if(browser.equalsIgnoreCase("firefox")){
			log.info("Creating object of :"+browser);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			drv=new FirefoxDriver();
		}
	}
	
	// Method to launch the website
	public void getUrl(String url){
		log.info("Navigating to : "+url);
		drv.get(url);
		drv.manage().timeouts().implicitlyWait(TestUtil.IMPL_WAIT, TimeUnit.SECONDS);
		drv.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		drv.manage().window().maximize();
		
				
	}

}
