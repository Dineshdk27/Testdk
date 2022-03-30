package dk.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JUnitTestCases {
	
	
	public static WebDriver driver;
	public static String ScrSht;
	
	@BeforeClass
	public static void bLaunch() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("....Launching Browser...");
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    String link =("https://www.flipkart.com/");
	    driver.manage().window().maximize();
	    driver.get(link);
	    String url=driver.getCurrentUrl();
	    System.out.println(url);
	    String title=driver.getTitle();
	    System.out.println(title);
        Thread.sleep(3000);
		}
	
	@AfterClass
	public static  void clBrowser() {
		// TODO Auto-generated method stub

	}
	
	
	@Test 
	public void alertss() {
		// TODO Auto-generated method stub
         WebElement cls=driver.findElement(By.xpath("(//button[contains(@text,'')])[2]"));
         cls.click();
         
	}

	@Test
	public void met1() throws InterruptedException {
		Actions a=new Actions(driver);


		WebElement fash=driver.findElement(By.xpath("(//img[contains(@alt,'Fashion')])[1]"));
		a.moveToElement(fash).perform();

		String f=fash.getAttribute("alt");
		System.out.println(f);
		Thread.sleep(2000);

		WebElement elec=driver.findElement(By.xpath("//img[@alt='Electronics']"));
		a.moveToElement(elec).perform();


		String e=elec.getAttribute("alt");
		System.out.println(e);
		Thread.sleep(2000);
	}
	
	@Test
	public void met2() {
		WebElement sr=driver.findElement(By.xpath("//input[contains(@type,'text')]"));
		sr.sendKeys(("DSLR Sony Alpha"),Keys.ENTER);
			
	}
	
	@Test
	public void met3() throws Exception {
		// TODO Auto-generated method stub
		
		Thread.sleep(2000);
         WebElement p1 =driver.findElement(By.xpath("(//a[contains(@target,'blank')])[1] "));
	     p1.click();
	     
	}
	@Test
	public void met4() {
		// TODO Auto-generated method stub

		String pWin=driver.getWindowHandle();
		Set<String> cWin=driver.getWindowHandles();
		
		for(String x:cWin)
		{
			if(!pWin.equals(x));
			driver.switchTo().window(x);
			
			String title1=driver.getTitle();
			System.out.println(title1);
		}
		
		
	}
	
	
	@Test 
	public void met5() throws Exception {
		// TODO Auto-generated method stub
		Robot r= new Robot();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
   WebElement pin=driver.findElement(By.xpath("//input[contains(@id,'pincode')]"));
    pin.sendKeys("600067");
    
    driver.findElement(By.xpath("//span[contains(@class,'2P')]")).click();
    
    //JavascriptExecutor j=(JavascriptExecutor)driver;
    
    
    //WebElement readMore=driver.findElement(By.xpath("(//button[contains(@text,\\\"\\\")])[5]"));
    //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    
    //j.executeScript("arguments[].scrollIntoView(true)",readMore);

 
 
		
		
	}
	@Test
	public void met6() throws Exception {
		// TODO Auto-generated method stub

		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File targ=new File("C:\\Users\\91805\\JAVA\\ECLIPSEMAVEN WORKSPACE\\JunitTest\\ScreenShots"+ ScrSht +".jpg");
		try {
            FileUtils.copyFile(src,targ);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	
	
	}
		
	
	
}
