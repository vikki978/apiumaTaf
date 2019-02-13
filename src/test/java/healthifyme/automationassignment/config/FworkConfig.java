/*
 This class initializes the jsonObject for reading the test data from json file.
 */

package healthifyme.automationassignment.config;

import com.google.gson.JsonObject;

public class FworkConfig {
	public  JsonObject fConfig = null;
	public JsonObject testConfig = null;
	
	public FworkConfig()
	{
		testConfig = PrepareConfigJSON.GetJsonObjectFromFile("config","testConfig.json");
	}
}
