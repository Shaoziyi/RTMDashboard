package VGCAutomationTesting.RTMDashboard;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import VGCAutomationTesting.RTMDashboard.comFunction.ComUtils;


public class GridDemo
{
	static WebDriver driver = null;
	static String locationType;

	/**
	 * @param nodeURL
	 *           node 节点的地址
	 * @param browser
	 *           node 节点的浏览器
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */

	@Test(dataProvider = "data")
	public void Testing(final String nodeURL, final String browser) throws InterruptedException, MalformedURLException
	{
		driver = ComUtils.getDriver(locationType, browser, nodeURL);
		//driver = ComUtils.getDriver("local", browser, nodeURL);
		//      打开百度
		driver.get("http://www.bing.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println(browser + driver.getTitle());
		ComUtils.logWriter("Jenkins  ", "log/log20170731.txt", true);
		Thread.sleep(10000);
		//      关闭浏览器
		driver.quit();
	}

	/**
	 * @param location
	 */
	@Parameters(
	{ "location" })
	@BeforeMethod
	public void beforeMethod(final String location)
	{
		locationType = location;

	}

	@AfterMethod
	public void afterMethod()
	{
	}

	@DataProvider(name = "data", parallel = true)
	public Object[][] data()
	{
		return new Object[][]
		{
				//{ "http://120.0.0.1", "ie" },
				//{ "http://16.187.153.11:5555", "ie" },
				//{ "http://16.187.153.9:5555", "ie" },
				//{ "http://16.187.153.9:5555", "ie" },
				{ "http://16.165.188.77:5555", "chrome" }, };
	}

}
