package PageComponents;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class DataReader {

	public String readData(String key) throws IOException {
		
		JsonObject dataobject = null;

		try {
			FileReader reader = new FileReader(new File(System.getProperty("user.dir") + "//TestData//Data.json"));
			dataobject = JsonParser.parseReader(reader).getAsJsonObject();

			return dataobject.get(key).getAsString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
