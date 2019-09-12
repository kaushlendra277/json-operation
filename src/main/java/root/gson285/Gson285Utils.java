package root.gson285;

import com.google.gson.Gson;

public class Gson285Utils {
	public static <U> U toObject(String jObjectStr, Class<U> u) {
		Gson gson = new Gson();
		U obj = gson.fromJson(jObjectStr, u);
		return obj;
	}

}
