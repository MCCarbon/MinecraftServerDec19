package net.minecraft.server;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class JsonHelper {

	public static boolean d(JsonObject jsonObject, String string) {
		if (!JsonHelper.has(jsonObject, string)) {
			return false;
		}
		if (jsonObject.get(string).isJsonArray()) {
			return true;
		}
		return false;
	}

	public static boolean has(JsonObject jsonObject, String key) {
		if (jsonObject == null) {
			return false;
		}
		if (jsonObject.get(key) != null) {
			return true;
		}
		return false;
	}

	public static String asString(JsonElement jsonElement, String key) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + key + " to be a string, was " + JsonHelper.toString(jsonElement));
		}
		return jsonElement.getAsString();
	}

	public static String getString(JsonObject jsonObject, String key) {
		if (!jsonObject.has(key)) {
			throw new JsonSyntaxException("Missing " + key + ", expected to find a string");
		}
		return JsonHelper.asString(jsonObject.get(key), key);
	}

	public static boolean asBoolean(JsonElement jsonElement, String key) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + key + " to be a Boolean, was " + JsonHelper.toString(jsonElement));
		}
		return jsonElement.getAsBoolean();
	}

	public static boolean getBoolean(JsonObject jsonObject, String key, boolean defaultValue) {
		if (!jsonObject.has(key)) {
			return defaultValue;
		}
		return JsonHelper.asBoolean(jsonObject.get(key), key);
	}

	public static float asFloat(JsonElement jsonElement, String key) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + key + " to be a Float, was " + JsonHelper.toString(jsonElement));
		}
		if (!jsonElement.getAsJsonPrimitive().isNumber()) {
			throw new JsonSyntaxException("Expected " + key + " to be a Float, was " + JsonHelper.toString(jsonElement));
		}
		return jsonElement.getAsFloat();
	}

	public static float getFloat(JsonObject jsonObject, String key, float defaultValue) {
		if (!jsonObject.has(key)) {
			return defaultValue;
		}
		return JsonHelper.asFloat(jsonObject.get(key), key);
	}

	public static int asInt(JsonElement jsonElement, String key) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + key + " to be a Int, was " + JsonHelper.toString(jsonElement));
		}
		if (!jsonElement.getAsJsonPrimitive().isNumber()) {
			throw new JsonSyntaxException("Expected " + key + " to be a Int, was " + JsonHelper.toString(jsonElement));
		}
		return jsonElement.getAsInt();
	}

	public static int getInt(JsonObject jsonObject, String string) {
		if (!jsonObject.has(string)) {
			throw new JsonSyntaxException("Missing " + string + ", expected to find a Int");
		}
		return JsonHelper.asInt(jsonObject.get(string), string);
	}

	public static int getInt(JsonObject jsonObject, String string, int defaultValue) {
		if (!jsonObject.has(string)) {
			return defaultValue;
		}
		return JsonHelper.asInt(jsonObject.get(string), string);
	}

	public static JsonObject asJsonObject(JsonElement jsonElement, String key) {
		if (!jsonElement.isJsonObject()) {
			throw new JsonSyntaxException("Expected " + key + " to be a JsonObject, was " + JsonHelper.toString(jsonElement));
		}
		return jsonElement.getAsJsonObject();
	}

	public static JsonArray asJsonArray(JsonElement jsonElement, String key) {
		if (!jsonElement.isJsonArray()) {
			throw new JsonSyntaxException("Expected " + key + " to be a JsonArray, was " + JsonHelper.toString(jsonElement));
		}
		return jsonElement.getAsJsonArray();
	}

	public static JsonArray getJsonArray(JsonObject jsonObject, String key) {
		if (!jsonObject.has(key)) {
			throw new JsonSyntaxException("Missing " + key + ", expected to find a JsonArray");
		}
		return JsonHelper.asJsonArray(jsonObject.get(key), key);
	}

	public static String toString(JsonElement jsonElement) {
		String string = StringUtils.abbreviateMiddle(String.valueOf(jsonElement), "...", 10);
		if (jsonElement == null) {
			return "null (missing)";
		}
		if (jsonElement.isJsonNull()) {
			return "null (json)";
		}
		if (jsonElement.isJsonArray()) {
			return "an array (" + string + ")";
		}
		if (jsonElement.isJsonObject()) {
			return "an object (" + string + ")";
		}
		if (!jsonElement.isJsonPrimitive()) {
			return string;
		}
		JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
		if (jsonPrimitive.isNumber()) {
			return "a number (" + string + ")";
		}
		if (!jsonPrimitive.isBoolean()) {
			return string;
		}
		return "a boolean (" + string + ")";
	}

	public static <T> T fromJson(Gson gson, Reader reader, Class<T> class_, boolean lenient) {
		try {
			JsonReader jsonReader = new JsonReader(reader);
			jsonReader.setLenient(lenient);
			return gson.getAdapter(class_).read(jsonReader);
		} catch (IOException e) {
			throw new JsonParseException(e);
		}
	}

	public static <T> T fromJson(Gson gson, String string, Class<T> class_) {
		return JsonHelper.fromJson(gson, string, class_, false);
	}

	public static <T> T fromJson(Gson gson, String string, Class<T> class_, boolean lenient) {
		return JsonHelper.fromJson(gson, new StringReader(string), class_, lenient);
	}

}
