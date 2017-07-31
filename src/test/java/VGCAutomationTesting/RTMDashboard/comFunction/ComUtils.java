package VGCAutomationTesting.RTMDashboard.comFunction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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

}
