package com.gp.webapp.pages;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gp.webapp.utility.Commons;

public class Map {
          public Map(WebDriver driver)
          {
        	  Commons.driver=driver;
          }
          
          @FindBy(xpath = "//*[@id=\"onesignal-slidedown-cancel-button\"]")
          WebElement alert;
          
          @FindBy(css   = "h4#div_site_count")
          WebElement site;
          
          @FindBy(xpath = "//*[@id=\"suggestion_box\"]/div[1]/label")
          @CacheLookup
          WebElement cross;
          
          @FindBy(xpath = "//*[@id=\"select2-dd_dtr-container\"]")
          WebElement dtr;
          
          @FindBy(id="search_tb")
          WebElement tab;
          
          @FindBy(xpath = "//*[@id=\"search_bt\"]/i")
          @CacheLookup
          WebElement search;
          
          @FindBy(xpath = "//*[@id=\"myNavbar\"]/ul[2]/ul[2]/a/label")
          @CacheLookup
          WebElement user;
          
          @FindBy(xpath = "//*[@id=\"myNavbar\"]/ul[2]/ul[2]/ul/li/a")
          @CacheLookup
          WebElement log;
          
          public void check(String object) throws IOException, InterruptedException
          {
        	  Appender appender=new FileAppender(Commons.l, "map.txt");
        	  Commons.log.addAppender(appender);
        	  
        	  // to click on later button of alert window
        	  alert.click();
        	  
        	  Commons.log.info("We successfully clicked on later button of pop up window");
        	  
        	  Thread.sleep(3000);
        	  
        	  // to click on site button
        	  site.click();
        	  
        	  Commons.log.info("We successfully clicked on site");
        	  
        	  Thread.sleep(3000);
        	  
        	  // to click on click here to close statics box 
        	  Actions action=new Actions(Commons.driver);
        	  action.moveToElement(cross).click().build().perform();
        	  
        	  Commons.log.info("We successfully closed statics box");
        	  
        	  Thread.sleep(3000);
        	  
        	  //now we have to go for select ROFANANDA A 
        	  String dp=Commons.excel_dropdown();
        	  Select select=new Select(dtr);
        	  select.selectByVisibleText(dp);
        	  
        	  Commons.log.info("We successfully selected ROFANANDA A");
        	  
        	  Thread.sleep(3000);
        	  
        	  // we have to search ROFANANDAA1007 in text box
        	  tab.click();
        	  
        	  Commons.log.info("We successfully clicked on text box");
        	  
        	  Thread.sleep(3000);
        	  
        	  tab.sendKeys("7");
        	  
        	  Commons.log.info("Here we had to type 7 in text box");
        	  
        	  Thread.sleep(3000);
        	  
        	  JavascriptExecutor js=(JavascriptExecutor)Commons.driver;
        	  String doc="return document.getElementById(\"search_tb\").value;";
        	  String data=(String)js.executeScript(doc);
        	  Commons.log.info("What we typed inside text box? = "+data);
        	  
        	  // now we have to select ROFANANDAA1007
        	  while (!data.equalsIgnoreCase(object)) {
        		  
        		Thread.sleep(3000);
        		
        		tab.sendKeys(Keys.DOWN);
        		
				doc="return document.getElementById(\"search_tb\").value;";
				data=(String)js.executeScript(doc);
				Commons.log.info("Print upto ROFANANDAA1007 = "+data);
			}
        	  
        	  tab.sendKeys(Keys.ENTER);
        	  
        	  Commons.log.info("We had to successfully select ROFANANDAA1007");
        	  
        	  Thread.sleep(3000);
        	  
        	  // to click on search button
        	  search.click();
        	  
        	  Commons.log.info("We successfully clicked on search button");
        	  
        	  Thread.sleep(3000);
        	  
        	  Commons.log.info("Now we had successfully see the consumer information of ROFANANDAA1007");
        	  
        	  // now we have to go for logout
        	  user.click();
        	  
        	  Commons.log.info("We successfully clicked on automationuser hyper link");
        	  
        	  Thread.sleep(3000);
        	  
        	  log.click();
        	  
        	  Commons.log.info("We successfully clicked on logged out button");
        	  
        	  Commons.log.info("We successfully logged out");
        	  
        	  Thread.sleep(3000);
          }
}
