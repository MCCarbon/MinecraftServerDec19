package net.minecraft.server;

import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang3.ObjectUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_kc {
	private static final Map a = Maps.newHashMap();
	private final Entity b;
	private final Map c = Maps.newHashMap();
	private final ReadWriteLock d = new ReentrantReadWriteLock();
	private boolean e = true;
	private boolean f;

	public class_kc(Entity var1) {
		b = var1;
	}

	public static class_jz a(Class var0, class_ka var1) {
		int var2;
		if (a.containsKey(var0)) {
			var2 = ((Integer) a.get(var0)).intValue() + 1;
		} else {
			int var3 = 0;
			Class var4 = var0;

			while (var4 != Entity.class) {
				var4 = var4.getSuperclass();
				if (a.containsKey(var4)) {
					var3 = ((Integer) a.get(var4)).intValue() + 1;
					break;
				}
			}

			var2 = var3;
		}

		if (var2 > 254) {
			throw new IllegalArgumentException("Data value id is too big with " + var2 + "! (Max is " + 254 + ")");
		} else {
			a.put(var0, Integer.valueOf(var2));
			return var1.a(var2);
		}
	}

	public void a(class_jz var1, Object var2) {
		int var3 = var1.a();
		if (var3 > 254) {
			throw new IllegalArgumentException("Data value id is too big with " + var3 + "! (Max is " + 254 + ")");
		} else if (c.containsKey(Integer.valueOf(var3))) {
			throw new IllegalArgumentException("Duplicate id value for " + var3 + "!");
		} else if (class_kb.b(var1.b()) < 0) {
			throw new IllegalArgumentException("Unregistered serializer " + var1.b() + " for " + var3 + "!");
		} else {
			this.c(var1, var2);
		}
	}

	private void c(class_jz var1, Object var2) {
		class_kc.class_a_in_class_kc var3 = new class_kc.class_a_in_class_kc(var1, var2);
		d.writeLock().lock();
		c.put(Integer.valueOf(var1.a()), var3);
		e = false;
		d.writeLock().unlock();
	}

	private class_kc.class_a_in_class_kc c(class_jz var1) {
		d.readLock().lock();

		class_kc.class_a_in_class_kc var2;
		try {
			var2 = (class_kc.class_a_in_class_kc) c.get(Integer.valueOf(var1.a()));
		} catch (Throwable var6) {
			class_b var4 = class_b.a(var6, "Getting synched entity data");
			class_c var5 = var4.a("Synched entity data");
			var5.a("Data ID", var1);
			throw new class_e(var4);
		}

		d.readLock().unlock();
		return var2;
	}

	public Object a(class_jz var1) {
		return this.c(var1).b();
	}

	public void b(class_jz var1, Object var2) {
		class_kc.class_a_in_class_kc var3 = this.c(var1);
		if (ObjectUtils.notEqual(var2, var3.b())) {
			var3.a(var2);
			b.a(var1);
			var3.a(true);
			f = true;
		}

	}

	public void b(class_jz var1) {
		this.c(var1).c = true;
		f = true;
	}

	public boolean a() {
		return f;
	}

	public static void a(List var0, PacketDataSerializer var1) throws IOException {
		if (var0 != null) {
			Iterator var2 = var0.iterator();

			while (var2.hasNext()) {
				class_kc.class_a_in_class_kc var3 = (class_kc.class_a_in_class_kc) var2.next();
				a(var1, var3);
			}
		}

		var1.writeByte(255);
	}

	public List b() {
		ArrayList var1 = null;
		if (f) {
			d.readLock().lock();
			Iterator var2 = c.values().iterator();

			while (var2.hasNext()) {
				class_kc.class_a_in_class_kc var3 = (class_kc.class_a_in_class_kc) var2.next();
				if (var3.c()) {
					var3.a(false);
					if (var1 == null) {
						var1 = Lists.newArrayList();
					}

					var1.add(var3);
				}
			}

			d.readLock().unlock();
		}

		f = false;
		return var1;
	}

	public void a(PacketDataSerializer var1) throws IOException {
		d.readLock().lock();
		Iterator var2 = c.values().iterator();

		while (var2.hasNext()) {
			class_kc.class_a_in_class_kc var3 = (class_kc.class_a_in_class_kc) var2.next();
			a(var1, var3);
		}

		d.readLock().unlock();
		var1.writeByte(255);
	}

	public List c() {
		ArrayList var1 = null;
		d.readLock().lock();

		class_kc.class_a_in_class_kc var3;
		for (Iterator var2 = c.values().iterator(); var2.hasNext(); var1.add(var3)) {
			var3 = (class_kc.class_a_in_class_kc) var2.next();
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}
		}

		d.readLock().unlock();
		return var1;
	}

	private static void a(PacketDataSerializer var0, class_kc.class_a_in_class_kc var1) throws IOException {
		class_jz var2 = var1.a();
		int var3 = class_kb.b(var2.b());
		if (var3 < 0) {
			throw new EncoderException("Unknown serializer type " + var2.b());
		} else {
			var0.writeByte(var2.a());
			var0.b(var3);
			var2.b().a(var0, var1.b());
		}
	}

	public static List b(PacketDataSerializer var0) throws IOException {
		ArrayList var1 = null;

		short var2;
		while ((var2 = var0.readUnsignedByte()) != 255) {
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}

			short var3 = var0.readUnsignedByte();
			class_ka var4 = class_kb.a(var3);
			if (var4 == null) {
				throw new DecoderException("Unknown serializer type " + var3);
			}

			var1.add(new class_kc.class_a_in_class_kc(var4.a(var2), var4.a(var0)));
		}

		return var1;
	}

	public boolean d() {
		return e;
	}

	public void e() {
		f = false;
	}

	public static class class_a_in_class_kc {
		private final class_jz a;
		private Object b;
		private boolean c;

		public class_a_in_class_kc(class_jz var1, Object var2) {
			a = var1;
			b = var2;
			c = true;
		}

		public class_jz a() {
			return a;
		}

		public void a(Object var1) {
			b = var1;
		}

		public Object b() {
			return b;
		}

		public boolean c() {
			return c;
		}

		public void a(boolean var1) {
			c = var1;
		}
	}
}
