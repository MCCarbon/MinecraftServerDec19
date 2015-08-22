package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class class_du extends class_eb {
	private static final Logger b = LogManager.getLogger();
	private List c = Lists.newArrayList();
	private byte d = 0;

	@Override
	void a(DataOutput var1) throws IOException {
		if (!c.isEmpty()) {
			d = ((class_eb) c.get(0)).a();
		} else {
			d = 0;
		}

		var1.writeByte(d);
		var1.writeInt(c.size());

		for (int var2 = 0; var2 < c.size(); ++var2) {
			((class_eb) c.get(var2)).a(var1);
		}

	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(296L);
		if (var2 > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			d = var1.readByte();
			int var4 = var1.readInt();
			if ((d == 0) && (var4 > 0)) {
				throw new RuntimeException("Missing type on ListTag");
			} else {
				var3.a(32L * var4);
				c = Lists.newArrayListWithCapacity(var4);

				for (int var5 = 0; var5 < var4; ++var5) {
					class_eb var6 = class_eb.a(d);
					var6.a(var1, var2 + 1, var3);
					c.add(var6);
				}

			}
		}
	}

	@Override
	public byte a() {
		return (byte) 9;
	}

	@Override
	public String toString() {
		StringBuilder var1 = new StringBuilder("[");

		for (int var2 = 0; var2 < c.size(); ++var2) {
			if (var2 != 0) {
				var1.append(',');
			}

			var1.append(var2).append(':').append(c.get(var2));
		}

		return var1.append(']').toString();
	}

	public void a(class_eb var1) {
		if (var1.a() == 0) {
			b.warn("Invalid TagEnd added to ListTag");
		} else {
			if (d == 0) {
				d = var1.a();
			} else if (d != var1.a()) {
				b.warn("Adding mismatching tag types to tag list");
				return;
			}

			c.add(var1);
		}
	}

	public void a(int var1, class_eb var2) {
		if (var2.a() == 0) {
			b.warn("Invalid TagEnd added to ListTag");
		} else if ((var1 >= 0) && (var1 < c.size())) {
			if (d == 0) {
				d = var2.a();
			} else if (d != var2.a()) {
				b.warn("Adding mismatching tag types to tag list");
				return;
			}

			c.set(var1, var2);
		} else {
			b.warn("index out of bounds to set tag in tag list");
		}
	}

	public class_eb a(int var1) {
		return (class_eb) c.remove(var1);
	}

	@Override
	public boolean c_() {
		return c.isEmpty();
	}

	public class_dn b(int var1) {
		if ((var1 >= 0) && (var1 < c.size())) {
			class_eb var2 = (class_eb) c.get(var1);
			if (var2.a() == 10) {
				return (class_dn) var2;
			}
		}

		return new class_dn();
	}

	public int c(int var1) {
		if ((var1 >= 0) && (var1 < c.size())) {
			class_eb var2 = (class_eb) c.get(var1);
			if (var2.a() == 3) {
				return ((class_dt) var2).d();
			}
		}

		return 0;
	}

	public int[] d(int var1) {
		if ((var1 >= 0) && (var1 < c.size())) {
			class_eb var2 = (class_eb) c.get(var1);
			if (var2.a() == 11) {
				return ((class_ds) var2).c();
			}
		}

		return new int[0];
	}

	public double e(int var1) {
		if ((var1 >= 0) && (var1 < c.size())) {
			class_eb var2 = (class_eb) c.get(var1);
			if (var2.a() == 6) {
				return ((class_dp) var2).g();
			}
		}

		return 0.0D;
	}

	public float f(int var1) {
		if ((var1 >= 0) && (var1 < c.size())) {
			class_eb var2 = (class_eb) c.get(var1);
			if (var2.a() == 5) {
				return ((class_dr) var2).h();
			}
		}

		return 0.0F;
	}

	public String g(int var1) {
		if ((var1 >= 0) && (var1 < c.size())) {
			class_eb var2 = (class_eb) c.get(var1);
			return var2.a() == 8 ? var2.a_() : var2.toString();
		} else {
			return "";
		}
	}

	public class_eb h(int var1) {
		return (var1 >= 0) && (var1 < c.size()) ? (class_eb) c.get(var1) : new class_dq();
	}

	public int c() {
		return c.size();
	}

	@Override
	public class_eb b() {
		class_du var1 = new class_du();
		var1.d = d;
		Iterator var2 = c.iterator();

		while (var2.hasNext()) {
			class_eb var3 = (class_eb) var2.next();
			class_eb var4 = var3.b();
			var1.c.add(var4);
		}

		return var1;
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			class_du var2 = (class_du) var1;
			if (d == var2.d) {
				return c.equals(var2.c);
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ c.hashCode();
	}

	public int d() {
		return d;
	}
}
