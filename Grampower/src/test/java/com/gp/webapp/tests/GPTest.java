package com.gp.webapp.tests;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gp.webapp.pages.LoginPage;
import com.gp.webapp.pages.Map;
import com.gp.webapp.utility.Commons;

public class GPTest {
          @BeforeSuite
          public void openBrowser() throws IOException
          {
        	  Appender appender=new FileAppender(Commons.l,"test.txt");
        	  Commons.log.addAppender(appender);
        	  
        	  System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
        	  
        	  Commons.driver=new ChromeDriver();
        	  
        	  Commons.log.info("Browser opened successfully");
          }
          
          @BeforeTest
          public void openUrl() throws IOException
          {
        	  Appender appender=new FileAppender(Commons.l,"test.txt");
        	  Commons.log.addAppender(appender);
        	  
        	  Commons.fis=Commons.url();
        	  
        	  Commons.driver.get(Commons.pro.getProperty("url"));
        	  
        	  Commons.log.info("Gram power url opened successfully");
          }
          
          @BeforeClass
          public void max() throws IOException
          {
        	  Appender appender=new FileAppender(Commons.l,"test.txt");
        	  Commons.log.addAppender(appender);
        	  
        	  Commons.driver.manage().window().maximize();
        	  
        	  Commons.log.info("Screen maximized successfully");
          }
          
          @BeforeMethod
          public void timeAndCookies() throws IOException, InterruptedException
          {
        	  Appender appender=new FileAppender(Commons.l,"test.txt");
        	  Commons.log.addAppender(appender);
        	  
        	  Thread.sleep(3000);
        	  
        	  Commons.log.info("We successfully pause execution for 3 milli seconds");
        	  
        	  //now we get for cookies
        	  Set<Cookie> cookies=Commons.driver.manage().getCookies();
        	  for(Cookie cookie:cookies)
        	  {
        		  Commons.log.info("Details of cookies");
        		  Commons.log.info("Name of cookies = "+cookie.getName());
        		  Commons.log.info("Domain of cookies = "+cookie.getDomain());
        		  Commons.log.info("Class name of cookies = "+cookie.getClass());
        		  Commons.log.info("Values of cookies = "+cookie.getValue());
        		  Commons.log.info("Path of cookies = "+cookie.getPath());
        		  Commons.log.info("Expiry date and time of cookies = "+cookie.getExpiry());
        		  Commons.log.info("Is http only? = "+cookie.isHttpOnly());
        		  Commons.log.info("Are cookies secure? = "+cookie.isSecure());
        		  Commons.log.info("==============================================================================");
        	  }
          }
          
          @Test(priority=1)
          public void login() throws IOException, InterruptedException
          {
        	  Appender appender=new FileAppender(Commons.l,"test.txt");
        	  Commons.log.addAppender(appender);
        	  
        	  Commons.log.info("Now we have to go for log in");
        	  
        	  LoginPage lp=PageFactory.initElements(Commons.driver, LoginPage.class);
        	            lp.loginCheck();
          }
          
			
			  @DataProvider 
			  public Object[][] getData() {
				  return new Object[][] { 
					  new Object[] {"ROFANANDAA1007"}
					  }; 
					  }
			  
			  @Test(priority = 2,dataProvider="getData") 
			  public void checkMap(String data)throws IOException, InterruptedException 
			  { 
			    Appender appender=new FileAppender(Commons.l,"test.txt"); 
			    Commons.log.addAppender(appender);
			  
			  // now we have to go for check the consumer information 
			  Map m=PageFactory.initElements(Commons.driver, Map.class); 
			  m.check(data);
			  
			  Commons.log.info("We successfully checked the consumer information"); 
			  }
			  
			  @AfterMethod 
			  public void screenshot() throws IOException 
			  { 
				  Appender appender=new FileAppender(Commons.l,"test.txt");
			      Commons.log.addAppender(appender);
			  
			  File src=((TakesScreenshot)Commons.driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFileToDirectory(src, new File("src//test//resources//screenshot"));
			  
			  Commons.log.info("We successfully taken screenshot"); 
			  }
			  
			  @AfterClass 
			  public void deleteCookies() throws IOException 
			  { 
				  Appender appender=new FileAppender(Commons.l,"test.txt");
			      Commons.log.addAppender(appender);
			  
			      Commons.driver.manage().deleteAllCookies();
			  
			      Commons.log.info("After deleted all cookies");
			  
			  Set<Cookie> cookies=Commons.driver.manage().getCookies(); 
			  for(Cookie cookie:cookies) 
			  { 
			      Commons.log.info("Details of cookies");
			      Commons.log.info("Name of cookies = "+cookie.getName());
			      Commons.log.info("Domain of cookies = "+cookie.getDomain());
			      Commons.log.info("Class name of cookies = "+cookie.getClass());
			      Commons.log.info("Values of cookies = "+cookie.getValue());
			      Commons.log.info("Path of cookies = "+cookie.getPath());
			      Commons.log.info("Expiry date and time of cookies = "+cookie.getExpiry());
			      Commons.log.info("Is http only? = "+cookie.isHttpOnly());
			      Commons.log.info("Are cookies secure? = "+cookie.isSecure());
			      Commons.log.info("=============================================================================="); 
			   } 
			  }
			  
			  @AfterTest 
			  public void dbClose() throws IOException 
			  { 
				  Appender appender=new FileAppender(Commons.l,"test.txt"); 
				  Commons.log.addAppender(appender);
			  
			      Commons.log.info("We successfully closed the database connection"); 
			  }
			  
			  @AfterSuite 
			  public void browserClose() throws IOException 
			  { 
				  Appender appender=new FileAppender(Commons.l,"test.txt");
			      Commons.log.addAppender(appender);
			  
			      Commons.driver.close();
			  
			      Commons.log.info("We successfully closed the browser"); 
			  }
			 
}
