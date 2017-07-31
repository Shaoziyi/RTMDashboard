package VGCAutomationTesting.RTMDashboard;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import VGCAutomationTesting.RTMDashboard.comFunction.ComUtils;


public class GridDemo
{
	/**
	 * @param nodeURL
	 *           node 节点的地址
	 * @param browser
	 *           node 节点的浏览器
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "data")
	public void Testing(final String nodeURL, final String browser) throws IOException, InterruptedException
	{
		final DesiredCapabilities desiredCapabilities;
		//    判断要打开的浏览器
		if (browser == "chrome")
		{
			desiredCapabilities = DesiredCapabilities.chrome();
		}
		else if (browser == "ie")
		{
			desiredCapabilities = DesiredCapabilities.internetExplorer();
		}
		else
		{
			desiredCapabilities = DesiredCapabilities.firefox();
		}

		final String url = nodeURL + "/wd/hub";
		//获得WebDriver
		final WebDriver driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
		//      打开百度
		driver.get("http://www.bing.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println(browser + driver.getTitle());
		ComUtils.logWriter("Jenkins  ", "log\\log20170731.txt", true);
		Thread.sleep(10000);
		//      关闭浏览器
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod()
	{
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
