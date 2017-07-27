package VGCAutomationTesting.RTMDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NewTest
{
	private static WebDriver driver = null;

	@Test
	public void f()
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\shaozi-y\\seleniumnode\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com"); //浏览器访问百度
		driver.manage().window().maximize();//浏览器maximize为100%
		System.out.println("1 page Title is :" + driver.getTitle());//获取网页的title
		final WebElement element = driver.findElement(By.id("kw"));//通过网页元素的id寻找百度的DOM
		element.sendKeys("读大学到底读什么");//输入搜索字
		element.submit();//提交至百度所在的form
		driver.close();
	}

	@BeforeMethod
	public void beforeMethod()
	{
	}

	@AfterMethod
	public void afterMethod()
	{
	}

}
