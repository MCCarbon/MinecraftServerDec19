package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_aqq {
	private static final Integer[] a = new Integer[] { Integer.valueOf(15), Integer.valueOf(255), Integer.valueOf(4095) };
	private class_ct b = new class_ct(16);
	private int c = 0;
	private List d;
	private class_aqq.class_a_in_class_aqq e;

	public class_aqq(class_aqq.class_a_in_class_aqq var1) {
		d = Lists.newArrayList((Object[]) a);
		e = var1;
		b.a(Blocks.AIR.getBlockData(), 0);
		++c;
	}

	public class_apn a(int var1) {
		class_apn var2 = (class_apn) b.a(var1);
		return var2 == null ? Blocks.AIR.getBlockData() : var2;
	}

	public int a(class_apn var1) {
		int var2 = b.a(var1);
		if (var2 == -1) {
			var2 = c;
			b.a(var1, var2);
			if (!d.isEmpty() && (c > ((Integer) d.get(0)).intValue())) {
				d.remove(0);
				e = e.a(((Integer) d.get(0)).intValue());
			}

			++c;
		}

		return var2;
	}

	public void a(PacketDataSerializer var1) {
		var1.b(c);
		Iterator var2 = b.iterator();

		while (var2.hasNext()) {
			class_apn var3 = (class_apn) var2.next();
			var1.b(Block.d.a(var3));
			var1.b(b.a(var3));
		}

	}

	public interface class_a_in_class_aqq {
		class_aqj a(int var1);
	}
}
