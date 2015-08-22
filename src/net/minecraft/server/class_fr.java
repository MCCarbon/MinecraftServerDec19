package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class class_fr implements class_ff {
	private Map a;

	public class_fr() {
	}

	public class_fr(Map var1) {
		a = var1;
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		int var2 = var1.g();
		a = Maps.newHashMap();

		for (int var3 = 0; var3 < var2; ++var3) {
			class_nd var4 = class_nh.a(var1.c(32767));
			int var5 = var1.g();
			if (var4 != null) {
				a.put(var4, Integer.valueOf(var5));
			}
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a.size());
		Iterator var2 = a.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.a(((class_nd) var3.getKey()).e);
			var1.b(((Integer) var3.getValue()).intValue());
		}

	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
