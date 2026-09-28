package utilities;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	
	private static final Properties properties=new Properties();
	static {
        try (FileInputStream fis =
                     new FileInputStream(Ipathconstant.propertyfile_path)) {

            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties file", e);
        }

}
	
	
	private ConfigReader() {
		
	}
	
	public static String getproperty(String Key) {
		
		
		String value=properties.getProperty(Key);
		if(value==null||value.trim().isEmpty()) {
			throw new RuntimeException("property not found in config.properties"+Key);
		}
		return value.trim();
		
	}
	
	
	
	
}
