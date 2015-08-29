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

public class DataWatcher {
	private static final Map<Class<?>, Integer> ENTITY_CLASS_TO_ID = Maps.newHashMap();
	private final Entity entity;
	private final Map<Integer, WatchableObject> watcheddata = Maps.newHashMap();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private boolean e = true;
	private boolean f;

	public DataWatcher(Entity entity) {
		this.entity = entity;
	}

	public static class_jz claimId(Class<?> clazz, class_ka var1) {
		int id;
		if (ENTITY_CLASS_TO_ID.containsKey(clazz)) {
			id = ((Integer) ENTITY_CLASS_TO_ID.get(clazz)).intValue() + 1;
		} else {
			int var3 = 0;
			Class<?> superClazz = clazz;

			while (superClazz != Entity.class) {
				superClazz = superClazz.getSuperclass();
				if (ENTITY_CLASS_TO_ID.containsKey(superClazz)) {
					var3 = ((Integer) ENTITY_CLASS_TO_ID.get(superClazz)).intValue() + 1;
					break;
				}
			}

			id = var3;
		}

		if (id > 254) {
			throw new IllegalArgumentException("Data value id is too big with " + id + "! (Max is " + 254 + ")");
		} else {
			ENTITY_CLASS_TO_ID.put(clazz, Integer.valueOf(id));
			return var1.a(id);
		}
	}

	public void a(class_jz var1, Object var2) {
		int var3 = var1.a();
		if (var3 > 254) {
			throw new IllegalArgumentException("Data value id is too big with " + var3 + "! (Max is " + 254 + ")");
		} else if (watcheddata.containsKey(Integer.valueOf(var3))) {
			throw new IllegalArgumentException("Duplicate id value for " + var3 + "!");
		} else if (class_kb.b(var1.b()) < 0) {
			throw new IllegalArgumentException("Unregistered serializer " + var1.b() + " for " + var3 + "!");
		} else {
			this.c(var1, var2);
		}
	}

	private void c(class_jz var1, Object var2) {
		DataWatcher.WatchableObject var3 = new DataWatcher.WatchableObject(var1, var2);
		lock.writeLock().lock();
		watcheddata.put(Integer.valueOf(var1.a()), var3);
		e = false;
		lock.writeLock().unlock();
	}

	private DataWatcher.WatchableObject c(class_jz var1) {
		lock.readLock().lock();

		DataWatcher.WatchableObject var2;
		try {
			var2 = (DataWatcher.WatchableObject) watcheddata.get(Integer.valueOf(var1.a()));
		} catch (Throwable var6) {
			class_b var4 = class_b.a(var6, "Getting synched entity data");
			class_c var5 = var4.a("Synched entity data");
			var5.a("Data ID", var1);
			throw new class_e(var4);
		}

		lock.readLock().unlock();
		return var2;
	}

	public Object a(class_jz var1) {
		return this.c(var1).b();
	}

	public void b(class_jz var1, Object var2) {
		DataWatcher.WatchableObject var3 = this.c(var1);
		if (ObjectUtils.notEqual(var2, var3.b())) {
			var3.a(var2);
			entity.a(var1);
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
				DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject) var2.next();
				a(var1, var3);
			}
		}

		var1.writeByte(255);
	}

	public List b() {
		ArrayList var1 = null;
		if (f) {
			lock.readLock().lock();
			Iterator var2 = watcheddata.values().iterator();

			while (var2.hasNext()) {
				DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject) var2.next();
				if (var3.c()) {
					var3.a(false);
					if (var1 == null) {
						var1 = Lists.newArrayList();
					}

					var1.add(var3);
				}
			}

			lock.readLock().unlock();
		}

		f = false;
		return var1;
	}

	public void a(PacketDataSerializer var1) throws IOException {
		lock.readLock().lock();
		Iterator var2 = watcheddata.values().iterator();

		while (var2.hasNext()) {
			DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject) var2.next();
			a(var1, var3);
		}

		lock.readLock().unlock();
		var1.writeByte(255);
	}

	public List c() {
		ArrayList var1 = null;
		lock.readLock().lock();

		DataWatcher.WatchableObject var3;
		for (Iterator var2 = watcheddata.values().iterator(); var2.hasNext(); var1.add(var3)) {
			var3 = (DataWatcher.WatchableObject) var2.next();
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}
		}

		lock.readLock().unlock();
		return var1;
	}

	private static void a(PacketDataSerializer var0, DataWatcher.WatchableObject var1) throws IOException {
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

			var1.add(new DataWatcher.WatchableObject(var4.a(var2), var4.a(var0)));
		}

		return var1;
	}

	public boolean d() {
		return e;
	}

	public void e() {
		f = false;
	}

	public static class WatchableObject {
		private final class_jz a;
		private Object b;
		private boolean c;

		public WatchableObject(class_jz var1, Object var2) {
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
