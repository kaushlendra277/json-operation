package root.gson285;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class Gson285Utils {
	public static JsonArray fromJsonFile(String path) throws IOException, ParseException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		Gson gson = new Gson();
		JsonArray jArray = gson.fromJson(bufferedReader, JsonArray.class);
		return jArray;
	}

}
