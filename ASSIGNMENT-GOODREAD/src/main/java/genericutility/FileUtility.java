package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String toReadData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./testresources/CommonData.properties");
		Properties file=new Properties();
		file.load(fis);
		String value = file.getProperty(key);
		return value;
		
	}
}
