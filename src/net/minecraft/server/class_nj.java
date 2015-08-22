package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class class_nj extends ForwardingSet implements class_ng {
	private final Set a = Sets.newHashSet();

	@Override
	public void a(JsonElement var1) {
		if (var1.isJsonArray()) {
			Iterator var2 = var1.getAsJsonArray().iterator();

			while (var2.hasNext()) {
				JsonElement var3 = (JsonElement) var2.next();
				add(var3.getAsString());
			}
		}

	}

	@Override
	public JsonElement a() {
		JsonArray var1 = new JsonArray();
		Iterator var2 = iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			var1.add(new JsonPrimitive(var3));
		}

		return var1;
	}

	@Override
	protected Set delegate() {
		return a;
	}

}
