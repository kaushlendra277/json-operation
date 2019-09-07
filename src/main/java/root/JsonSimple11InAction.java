package root;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import root.jsonsimple.JsonSimple11Utils;

public class JsonSimple11InAction {

	public static void main(String[] args) {
		try {
			String file = "./asyncGraph.json";
			JSONArray jArray = JsonSimple11Utils.fromJsonFile(file);
			Map<String, JSONArray> mergedGraph = new HashMap<>();
			for (Object object : jArray) {
				JSONArray jInnerArray = (JSONArray)object;
				merge2(jInnerArray,mergedGraph);
			}
			System.out.println(mergedGraph);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void merge(JSONArray jInnerArray, Map<String, JSONArray> mergedGraph) {
		JSONObject jObject = (JSONObject)jInnerArray.get(0);
		Set<String> jObjectKeys = jObject.keySet();
		for(String key : jObjectKeys ) {
			JSONArray jInnerObjects = (JSONArray)jObject.get(key);
			JSONObject jInnerObject = (JSONObject)jInnerObjects.get(0);
			if(mergedGraph.containsKey(key)) {
				JSONArray jArray = mergedGraph.get(key);
				jArray.add(jInnerObject);
				mergedGraph.put(key, jArray);
			}else {
				JSONArray jArray = new JSONArray();
				jArray.add(jInnerObject);
				mergedGraph.put(key,jArray);
			}
		}
	}
	
	private static void merge2(JSONArray jInnerArray, Map<String, JSONArray> mergedGraph) {
		JSONObject jObject = (JSONObject)jInnerArray.get(0);
		Set<String> jObjectKeys = jObject.keySet();
		for(String key : jObjectKeys ) {
			JSONArray jInnerObjects = (JSONArray)jObject.get(key);
			JSONObject jInnerObject = (JSONObject)jInnerObjects.get(0);
			mergedGraph.compute(key, 
					(k,v)-> {
						JSONArray jArray = v;
						if(jArray != null) {
							jArray.add(jInnerObject);
						}else {
							jArray = new JSONArray();
							jArray.add(jInnerObject);
						}
						return jArray;
					});
		}
	}

}
