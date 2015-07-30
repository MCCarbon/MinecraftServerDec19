package net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.apache.commons.lang3.StringUtils;

public class class_nk {

	public static boolean d(JsonObject jsonObject, String string) {
		if (!class_nk.g((JsonObject) jsonObject, (String) string)) {
			return false;
		}
		if (jsonObject.get(string).isJsonArray()) {
			return true;
		}
		return false;
	}

	public static boolean g(JsonObject jsonObject, String string) {
		if (jsonObject == null) {
			return false;
		}
		if (jsonObject.get(string) != null) {
			return true;
		}
		return false;
	}

	public static String a(JsonElement jsonElement, String string) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + string + " to be a string, was " + class_nk.d((JsonElement) jsonElement));
		}
		return jsonElement.getAsString();
	}

	public static String h(JsonObject jsonObject, String string) {
		if (!jsonObject.has(string)) {
			throw new JsonSyntaxException("Missing " + string + ", expected to find a string");
		}
		return class_nk.a((JsonElement) jsonObject.get(string), (String) string);
	}

	public static boolean b(JsonElement jsonElement, String string) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + string + " to be a Boolean, was " + class_nk.d((JsonElement) jsonElement));
		}
		return jsonElement.getAsBoolean();
	}

	public static boolean a(JsonObject jsonObject, String string, boolean bl) {
		if (!jsonObject.has(string)) {
			return bl;
		}
		return class_nk.b((JsonElement) jsonObject.get(string), (String) string);
	}

	public static float d(JsonElement jsonElement, String string) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + string + " to be a Float, was " + class_nk.d((JsonElement) jsonElement));
		}
		if (!jsonElement.getAsJsonPrimitive().isNumber()) {
			throw new JsonSyntaxException("Expected " + string + " to be a Float, was " + class_nk.d((JsonElement) jsonElement));
		}
		return jsonElement.getAsFloat();
	}

	public static float a(JsonObject jsonObject, String string, float f) {
		if (!jsonObject.has(string)) {
			return f;
		}
		return class_nk.d((JsonElement) jsonObject.get(string), (String) string);
	}

	public static int f(JsonElement jsonElement, String string) {
		if (!jsonElement.isJsonPrimitive()) {
			throw new JsonSyntaxException("Expected " + string + " to be a Int, was " + class_nk.d((JsonElement) jsonElement));
		}
		if (!jsonElement.getAsJsonPrimitive().isNumber()) {
			throw new JsonSyntaxException("Expected " + string + " to be a Int, was " + class_nk.d((JsonElement) jsonElement));
		}
		return jsonElement.getAsInt();
	}

	public static int m(JsonObject jsonObject, String string) {
		if (!jsonObject.has(string)) {
			throw new JsonSyntaxException("Missing " + string + ", expected to find a Int");
		}
		return class_nk.f((JsonElement) jsonObject.get(string), (String) string);
	}

	public static int a(JsonObject jsonObject, String string, int n) {
		if (!jsonObject.has(string)) {
			return n;
		}
		return class_nk.f((JsonElement) jsonObject.get(string), (String) string);
	}

	public static JsonObject l(JsonElement jsonElement, String string) {
		if (!jsonElement.isJsonObject()) {
			throw new JsonSyntaxException("Expected " + string + " to be a JsonObject, was " + class_nk.d((JsonElement) jsonElement));
		}
		return jsonElement.getAsJsonObject();
	}

	public static JsonArray m(JsonElement jsonElement, String string) {
		if (!jsonElement.isJsonArray()) {
			throw new JsonSyntaxException("Expected " + string + " to be a JsonArray, was " + class_nk.d((JsonElement) jsonElement));
		}
		return jsonElement.getAsJsonArray();
	}

	public static JsonArray t(JsonObject jsonObject, String string) {
		if (!jsonObject.has(string)) {
			throw new JsonSyntaxException("Missing " + string + ", expected to find a JsonArray");
		}
		return class_nk.m((JsonElement) jsonObject.get(string), (String) string);
	}

	public static String d(JsonElement jsonElement) {
		String string = StringUtils.abbreviateMiddle((String) String.valueOf((Object) jsonElement), (String) "...", (int) 10);
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

	public static <T> T a(Gson gson, Reader reader, Class<T> class_, boolean bl) {
		try {
			JsonReader jsonReader = new JsonReader(reader);
			jsonReader.setLenient(bl);
			return (T) gson.getAdapter(class_).read(jsonReader);
		} catch (IOException e) {
			throw new JsonParseException(e);
		}
	}

	public static <T> T a(Gson gson, String string, Class<T> class_) {
		return (T) class_nk.a((Gson) gson, (String) string, class_, (boolean) false);
	}

	public static <T> T a(Gson gson, String string, Class<T> class_, boolean bl) {
		return (T) class_nk.a((Gson) gson, (Reader) new StringReader(string), class_, (boolean) bl);
	}

}
