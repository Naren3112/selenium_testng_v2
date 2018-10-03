package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Read_Write_ConfigFile
{
	public String getValueFromConfigFile(String configFileName,String key)
	{
		String value="";
		try
		{
		Properties prop = new Properties();
		FileInputStream fio = new FileInputStream("src//test//resources//properties//"+configFileName+".properties");
		prop.load(fio);
		value = prop.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		return value;
		}
	}

}
