package model.props;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import model.exceptions.InvalidFileProperties;

public class AppJavaFXProperties implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String jarFile, mainClass;
	
	public AppJavaFXProperties() {
		
	}
	
	public void loadJavaFXProperties() {
		Properties props = loadProperties();
		
		setJarFile(props.getProperty("jarFile"));
		setMainClass(props.getProperty("mainClass"));
	}
		
	public String getJarFile() {
		return jarFile;
	}

	private void setJarFile(String jarFile) {
		this.jarFile = jarFile;
	}

	public String getMainClass() {
		return mainClass;
	}

	private void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	private static Properties loadProperties() {
		try(FileInputStream fileInputStream = new FileInputStream("executeJavaFX.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties; 
		} catch (IOException e) {
			throw new InvalidFileProperties(e.getMessage());
		}						
	}	
}
