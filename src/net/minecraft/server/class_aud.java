package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class class_aud extends class_auo {
	private double d = 0.004D;

	public class_aud() {
	}

	@Override
	public String a() {
		return "Mineshaft";
	}

	public class_aud(Map var1) {
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("chance")) {
				d = class_oa.a((String) var3.getValue(), d);
			}
		}

	}

	@Override
	protected boolean a(int var1, int var2) {
		return (b.nextDouble() < d) && (b.nextInt(80) < Math.max(Math.abs(var1), Math.abs(var2)));
	}

	@Override
	protected class_aus b(int var1, int var2) {
		return new class_auf(c, b, var1, var2);
	}
}
