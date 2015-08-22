package net.minecraft.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;

public abstract class class_lz extends class_mh {
	public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	protected final Date b;
	protected final String c;
	protected final Date d;
	protected final String e;

	public class_lz(Object var1, Date var2, String var3, Date var4, String var5) {
		super(var1);
		b = var2 == null ? new Date() : var2;
		c = var3 == null ? "(Unknown)" : var3;
		d = var4;
		e = var5 == null ? "Banned by an operator." : var5;
	}

	protected class_lz(Object var1, JsonObject var2) {
		super(var1, var2);

		Date var3;
		try {
			var3 = var2.has("created") ? a.parse(var2.get("created").getAsString()) : new Date();
		} catch (ParseException var7) {
			var3 = new Date();
		}

		b = var3;
		c = var2.has("source") ? var2.get("source").getAsString() : "(Unknown)";

		Date var4;
		try {
			var4 = var2.has("expires") ? a.parse(var2.get("expires").getAsString()) : null;
		} catch (ParseException var6) {
			var4 = null;
		}

		d = var4;
		e = var2.has("reason") ? var2.get("reason").getAsString() : "Banned by an operator.";
	}

	public Date c() {
		return d;
	}

	public String d() {
		return e;
	}

	@Override
	boolean e() {
		return d == null ? false : d.before(new Date());
	}

	@Override
	protected void a(JsonObject var1) {
		var1.addProperty("created", a.format(b));
		var1.addProperty("source", c);
		var1.addProperty("expires", d == null ? "forever" : a.format(d));
		var1.addProperty("reason", e);
	}
}
