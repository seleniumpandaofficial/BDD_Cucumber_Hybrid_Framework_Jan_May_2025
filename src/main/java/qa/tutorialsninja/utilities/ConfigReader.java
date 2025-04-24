package qa.tutorialsninja.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties initializePropertiesFile() throws Exception {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\tutorialsninja\\config\\Config.properties");
		prop.load(ip);
		return prop;
	}
	

}
