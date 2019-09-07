package root;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import root.gson285.Gson285Utils;

public class Gson285InAction {
	public static void main(String[] args) {
		String path = "./asyncGraph.json";
		try {
			JsonArray jArray = Gson285Utils.fromJsonFile(path);
			System.out.println(jArray);
			Map<String, JsonArray> mergedGraph = new HashMap<>();
			for (JsonElement jElement : jArray) {
				JsonArray jInnerArray = jElement.getAsJsonArray();
				merge2(jInnerArray, mergedGraph);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	private static void merge2(JsonArray jInnerArray, Map<String, JsonArray> mergedGraph) {

		JsonObject jObject = (JsonObject) jInnerArray.get(0);
		Set<String> jObjectKeys = jObject.keySet();
		for (String key : jObjectKeys) {
			JsonArray jInnerObjects = jObject.get(key).getAsJsonArray();
			JsonObject jInnerObject = (JsonObject) jInnerObjects.get(0);
			mergedGraph.compute(key, (k, v) -> {
				JsonArray jArray = v;
				if (jArray != null) {
					jArray.add(jInnerObject);
				} else {
					jArray = new JsonArray();
					jArray.add(jInnerObject);
				}
				return jArray;
			});
		}
	}
}
