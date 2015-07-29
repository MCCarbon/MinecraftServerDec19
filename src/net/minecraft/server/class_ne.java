package net.minecraft.server;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.server.class_nb;

public class class_ne extends ForwardingSet implements class_nb {
	private final Set a = Sets.newHashSet();

	public void a(JsonElement var1) {
		if (var1.isJsonArray()) {
			Iterator var2 = var1.getAsJsonArray().iterator();

			while (var2.hasNext()) {
				JsonElement var3 = (JsonElement) var2.next();
				this.add(var3.getAsString());
			}
		}

	}

	public JsonElement a() {
		JsonArray var1 = new JsonArray();
		Iterator var2 = this.iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			var1.add(new JsonPrimitive(var3));
		}

		return var1;
	}

	protected Set delegate() {
		return this.a;
	}

}
