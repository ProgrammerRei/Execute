package application;

import java.io.IOException;

import model.exceptions.InvalidFileProperties;
import model.props.AppJavaFXProperties;

public class Main {

	public static void main(String[] args) {
		try {
			AppJavaFXProperties javaFXExecuteProperties = new AppJavaFXProperties();
			javaFXExecuteProperties.loadJavaFXProperties();
						
			String javafx = "javafx-sdk" + (char)92 + "lib";
			String jdk = "jdk" + (char)92 + "bin" + (char)92 + "java";
			
			StringBuilder sb = new StringBuilder();			
			sb.append("cmd /c " + jdk + " --module-path " + javafx + " --add-modules javafx.controls,javafx.fxml -cp ");
			sb.append(javaFXExecuteProperties.getJarFile() + " ");
			sb.append(javaFXExecuteProperties.getMainClass());
			
			Runtime.getRuntime().exec(sb.toString());
		} catch (IOException e) {             
			e.printStackTrace();
		} catch(InvalidFileProperties e) {
			e.printStackTrace();
		}
	}

}
