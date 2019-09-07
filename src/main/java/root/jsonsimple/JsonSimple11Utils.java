package root.jsonsimple;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimple11Utils {
	public static JSONArray fromJsonFile(String file) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader jsonFileReader = new FileReader(file);
		JSONArray jsonArray = (JSONArray) parser.parse(jsonFileReader);
		return jsonArray;
	}

}
