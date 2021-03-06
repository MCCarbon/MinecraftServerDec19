package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class PacketPlayOutStatistic implements Packet {
	private Map a;

	public PacketPlayOutStatistic() {
	}

	public PacketPlayOutStatistic(Map var1) {
		a = var1;
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		int var2 = var1.g();
		a = Maps.newHashMap();

		for (int var3 = 0; var3 < var2; ++var3) {
			class_nd var4 = StatisticList.a(var1.c(32767));
			int var5 = var1.g();
			if (var4 != null) {
				a.put(var4, Integer.valueOf(var5));
			}
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
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
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
