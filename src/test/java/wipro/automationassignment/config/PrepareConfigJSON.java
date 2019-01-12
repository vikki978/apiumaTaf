/*
 This class prepares the jsonObject from reading the json file and returns the desired
 json value from json test data.
 */
package wipro.automationassignment.config;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.testng.Reporter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class PrepareConfigJSON {

	
	public static JsonObject GetJsonObjectFromFile(String dir, String fileName)
	{
		System.out.println("Working Directory = " +System.getProperty("user.dir"));
		Reporter.log("Working Directory = " +System.getProperty("user.dir"));
		JsonParser parser = new JsonParser();
		try {
			System.out.println("************************ PREPARING JSON ****************************");
			System.out.println(System.getProperty("user.dir")+dir+fileName);
			Reporter.log("Working Directory2 = " +System.getProperty("user.dir")+dir+fileName);
			Object obj = parser.parse(new FileReader(System.getProperty("user.dir")+dir+fileName));
			System.out.println("************************ PARSING COMPLETED ****************************");
				return (JsonObject) obj;
		} catch (FileNotFoundException e) {
			System.out
					.println("FILE_NOT_FOUND :: Check the pathConfig file is present or not!!!! - "+fileName);
		} catch (JsonParseException e) {
			System.out
					.println("InvalidJsonFormat :: Please check the input format of input json!!!! - "+fileName);
			e.printStackTrace();
		}
		return null;
	}
}
