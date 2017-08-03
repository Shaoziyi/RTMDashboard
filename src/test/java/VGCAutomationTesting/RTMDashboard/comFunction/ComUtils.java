package VGCAutomationTesting.RTMDashboard.comFunction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ComUtils
{
	//Write Log function
	public static boolean logWriter(final String log, final String filePathName, final Boolean isAppend)
	{
		boolean isSuccess = true;
		//Convert file path
		final String filePathConvert = filePathName.replaceAll("\\\\", "/");
		final int index = filePathConvert.lastIndexOf("/");
		final String filePath = filePathConvert.substring(0, index);
		final File fileFolder = new File(filePath);
		fileFolder.mkdir();
		File file = null;
		try
		{
			file = new File(filePathName);
			file.createNewFile();
		}
		catch (final IOException e)
		{
			isSuccess = false;
		}
		//
		FileWriter fileWriter = null;

		try
		{
			fileWriter = new FileWriter(file, isAppend);
			fileWriter.write(log);
			fileWriter.flush();
		}
		catch (final IOException e)
		{
			isSuccess = false;
		}
		finally
		{
			try
			{
				fileWriter.close();
			}
			catch (final IOException e)
			{
				//e.printStackTrace();
			}
		}
		return isSuccess;
	}

	//
	public static boolean createNewFile(final String filePathName)
	{
		boolean isSuccess = true;
		//
		final String filePathTurn = filePathName.replaceAll("\\\\", "/");
		//
		final int index = filePathTurn.lastIndexOf("/");
		final String dir = filePathTurn.substring(0, index);
		//
		final File fileForlder = new File(dir);
		isSuccess = fileForlder.mkdirs();
		//create the files
		final File file = new File(filePathTurn);
		try
		{
			isSuccess = file.createNewFile();
		}
		catch (final IOException e)
		{
			isSuccess = false;
			//e.printStackTrace();
		}
		return isSuccess;
	}

	/**
	 * @param browser
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver getDriver(final String location, final String browser, final String nodeURL)
			throws MalformedURLException
	{
		WebDriver driver = null;
		if (location.equals("remote"))
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
			driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver.exe");
			switch (browser)
			{
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "ie":
					driver = new ChromeDriver();
					break;
				case "firefox":
					driver = new ChromeDriver();
					break;
			}
		}
		return driver;
	}
}
