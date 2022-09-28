package com.gp.webapp.pages;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.gp.webapp.utility.Commons;

public class LoginPage {
      public LoginPage(WebDriver driver)
      {
    	  Commons.driver=driver;
      }
      
      @FindBy(xpath="//*[@id=\"register\"]/form/input[2]")
      WebElement un;
      @FindBy(xpath = "//*[@id=\"register\"]/form/input[3]")
      WebElement pw;
      @FindBy(xpath = "//*[@id=\"register\"]/form/div[1]/input")
      @CacheLookup
      WebElement btn;
      
      public void loginCheck() throws IOException, InterruptedException
      {
    	  Appender appender=new FileAppender(Commons.l,"login.txt");
    	  Commons.log.addAppender(appender);
    	  
    	  String username=Commons.excel_username();
    	  String password=Commons.excel_password();
    	  
    	  // to enter user name
    	  un.sendKeys(username);
    	  
    	  // to enter password
    	  pw.sendKeys(password);
    	  
    	  Thread.sleep(3000);
    	  
    	  // to click on log in button
    	  btn.click();
    	  
    	  Commons.log.info("We successfully logged in");
    	  
    	  Thread.sleep(3000);
      }
}
