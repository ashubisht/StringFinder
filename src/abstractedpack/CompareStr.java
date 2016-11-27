package abstractedpack;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompareStr {
	String defString;

	public CompareStr() {
		getDefStringFromFile();
	}
	
	public String getDefString() {
		return defString;
	}

	public void setDefString(String defString) {
		this.defString = defString;
	}
	
	public boolean testStr(String str){
		if(defString.equals(str))
			return true;
		else
			return false;
	}
	
	public void getDefStringFromFile(){
		try{
			Properties properties = new Properties();
			properties.load(new FileReader(new File(this.getClass().getClassLoader().getResource("./propFiles/defaultStr.properties").getFile())));
			this.defString = properties.getProperty("key");
		}catch(Exception e){
			this.defString = "";
			Logger.getLogger("logger").log(Level.ALL, "Invalid details from file. Properties cant be read");
		}
		
	}
	
}
