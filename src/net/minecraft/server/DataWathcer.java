package net.minecraft.server;

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

public class DataWathcer {

	private static final Map<Class<?>, Integer> TYPE = Maps.newHashMap();
	private static final Map<Class<?>, Integer> ENTITY_CLASS_TO_ID = Maps.newHashMap();

	static {
		TYPE.put(Byte.class, Integer.valueOf(0));
		TYPE.put(Short.class, Integer.valueOf(1));
		TYPE.put(Integer.class, Integer.valueOf(2));
		TYPE.put(Float.class, Integer.valueOf(3));
		TYPE.put(String.class, Integer.valueOf(4));
		TYPE.put(ItemStack.class, Integer.valueOf(5));
		TYPE.put(BlockPosition.class, Integer.valueOf(6));
		TYPE.put(class_dc.class, Integer.valueOf(7));
	}

	private final Entity entity;
	private boolean b = true;
	private final Map<Integer, WatchableObject> watcheddata = Maps.newHashMap();
	private boolean e;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public DataWathcer(Entity entity) {
		this.entity = entity;
	}

	public static int claimId(Class<?> clazz) {
		int id;
		if (ENTITY_CLASS_TO_ID.containsKey(clazz)) {
			id = (ENTITY_CLASS_TO_ID.get(clazz)).intValue() + 1;
		} else {
			int searchId = 0;
			Class<?> superClazz = clazz;

			while (superClazz != Entity.class) {
				superClazz = superClazz.getSuperclass();
				if (ENTITY_CLASS_TO_ID.containsKey(superClazz)) {
					searchId = ENTITY_CLASS_TO_ID.get(superClazz).intValue() + 1;
					break;
				}
			}

			id = searchId;
		}

		if (id > 31) {
			throw new IllegalArgumentException("Data value id is too big with " + id + "! (Max is " + 31 + ")");
		} else {
			ENTITY_CLASS_TO_ID.put(clazz, id);
			return id;
		}
	}

	public void add(int id, Object obj) {
		if (id > 31) {
			throw new IllegalArgumentException("Data value id is too big with " + id + "! (Max is " + 31 + ")");
		} else {
			Integer type = TYPE.get(obj.getClass());
			if (type == null) {
				throw new IllegalArgumentException("Unknown data type: " + obj.getClass());
			} else if (id > 31) {
				throw new IllegalArgumentException("Data value id is too big with " + id + "! (Max is " + 31 + ")");
			} else if (watcheddata.containsKey(Integer.valueOf(id))) {
				throw new IllegalArgumentException("Duplicate id value for " + id + "!");
			} else {
				this.aad0(id, type.intValue(), obj);
			}
		}
	}

	public void addNull(int id, int type) {
		if (id > 31) {
			throw new IllegalArgumentException("Data value id is too big with " + id + "! (Max is " + 31 + ")");
		} else {
			this.aad0(id, type, (Object) null);
		}
	}

	private void aad0(int id, int type, Object obj) {
		DataWathcer.WatchableObject var4 = new DataWathcer.WatchableObject(type, id, obj);
		lock.writeLock().lock();
		watcheddata.put(Integer.valueOf(id), var4);
		lock.writeLock().unlock();
		b = false;
	}

	public byte getByte(int id) {
		return ((Byte) get(id).getValue()).byteValue();
	}

	public short getShort(int id) {
		return ((Short) get(id).getValue()).shortValue();
	}

	public int getInt(int id) {
		return ((Integer) get(id).getValue()).intValue();
	}

	public float getFloat(int id) {
		return ((Float) get(id).getValue()).floatValue();
	}

	public String getString(int id) {
		return (String) get(id).getValue();
	}

	public ItemStack getItemStack(int id) {
		return (ItemStack) get(id).getValue();
	}

	private DataWathcer.WatchableObject get(int id) {
		lock.readLock().lock();

		DataWathcer.WatchableObject object;
		try {
			object = watcheddata.get(id);
		} catch (Throwable var6) {
			class_b var4 = class_b.a(var6, "Getting synched entity data");
			class_c var5 = var4.a("Synched entity data");
			var5.a("Data ID", Integer.valueOf(id));
			throw new class_e(var4);
		}

		lock.readLock().unlock();
		return object;
	}

	public BlockPosition getBlockPosition(int id) {
		return (BlockPosition) get(id).getValue();
	}

	public class_dc h(int var1) {
		return (class_dc) get(var1).getValue();
	}

	public void update(int id, Object obj) {
		DataWathcer.WatchableObject watchable = get(id);
		if (ObjectUtils.notEqual(obj, watchable.getValue())) {
			watchable.setValue(obj);
			entity.d(id);
			watchable.a(true);
			e = true;
		}
	}

	public void i(int var1) {
		get(var1).d = true;
		e = true;
	}

	public boolean a() {
		return e;
	}

	public static void a(List<?> var0, PacketDataSerializer var1) throws IOException {
		if (var0 != null) {
			Iterator<?> var2 = var0.iterator();

			while (var2.hasNext()) {
				DataWathcer.WatchableObject var3 = (DataWathcer.WatchableObject) var2.next();
				a(var1, var3);
			}
		}

		var1.writeByte(127);
	}

	public List<WatchableObject> b() {
		ArrayList<WatchableObject> var1 = null;
		if (e) {
			lock.readLock().lock();
			Iterator<WatchableObject> var2 = watcheddata.values().iterator();

			while (var2.hasNext()) {
				DataWathcer.WatchableObject var3 = var2.next();
				if (var3.d()) {
					var3.a(false);
					if (var1 == null) {
						var1 = Lists.newArrayList();
					}

					var1.add(var3);
				}
			}

			lock.readLock().unlock();
		}

		e = false;
		return var1;
	}

	public void a(PacketDataSerializer var1) throws IOException {
		lock.readLock().lock();
		Iterator<WatchableObject> var2 = watcheddata.values().iterator();

		while (var2.hasNext()) {
			DataWathcer.WatchableObject var3 = var2.next();
			a(var1, var3);
		}

		lock.readLock().unlock();
		var1.writeByte(127);
	}

	public List<WatchableObject> getObjects() {
		ArrayList<WatchableObject> var1 = null;
		lock.readLock().lock();

		DataWathcer.WatchableObject var3;
		for (Iterator<WatchableObject> var2 = watcheddata.values().iterator(); var2.hasNext(); var1.add(var3)) {
			var3 = var2.next();
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}
		}

		lock.readLock().unlock();
		return var1;
	}

	private static void a(PacketDataSerializer var0, DataWathcer.WatchableObject var1) throws IOException {
		int var2 = ((var1.getType() << 5) | (var1.getId() & 31)) & 255;
		var0.writeByte(var2);
		switch (var1.getType()) {
			case 0:
				var0.writeByte(((Byte) var1.getValue()).byteValue());
				break;
			case 1:
				var0.writeShort(((Short) var1.getValue()).shortValue());
				break;
			case 2:
				var0.writeInt(((Integer) var1.getValue()).intValue());
				break;
			case 3:
				var0.writeFloat(((Float) var1.getValue()).floatValue());
				break;
			case 4:
				var0.writeString((String) var1.getValue());
				break;
			case 5:
				ItemStack var3 = (ItemStack) var1.getValue();
				var0.writeItemStack(var3);
				break;
			case 6:
				BlockPosition var4 = (BlockPosition) var1.getValue();
				var0.writeInt(var4.getX());
				var0.writeInt(var4.getY());
				var0.writeInt(var4.getZ());
				break;
			case 7:
				class_dc var5 = (class_dc) var1.getValue();
				var0.writeFloat(var5.b());
				var0.writeFloat(var5.c());
				var0.writeFloat(var5.d());
		}

	}

	public static List<WatchableObject> b(PacketDataSerializer var0) throws IOException {
		ArrayList<WatchableObject> var1 = null;

		for (byte var2 = var0.readByte(); var2 != 127; var2 = var0.readByte()) {
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}

			int var3 = (var2 & 224) >> 5;
			int var4 = var2 & 31;
			DataWathcer.WatchableObject var5 = null;
			switch (var3) {
				case 0:
					var5 = new DataWathcer.WatchableObject(var3, var4, Byte.valueOf(var0.readByte()));
					break;
				case 1:
					var5 = new DataWathcer.WatchableObject(var3, var4, Short.valueOf(var0.readShort()));
					break;
				case 2:
					var5 = new DataWathcer.WatchableObject(var3, var4, Integer.valueOf(var0.readInt()));
					break;
				case 3:
					var5 = new DataWathcer.WatchableObject(var3, var4, Float.valueOf(var0.readFloat()));
					break;
				case 4:
					var5 = new DataWathcer.WatchableObject(var3, var4, var0.readString(32767));
					break;
				case 5:
					var5 = new DataWathcer.WatchableObject(var3, var4, var0.readItemStack());
					break;
				case 6:
					int var6 = var0.readInt();
					int var7 = var0.readInt();
					int var8 = var0.readInt();
					var5 = new DataWathcer.WatchableObject(var3, var4, new BlockPosition(var6, var7, var8));
					break;
				case 7:
					float var9 = var0.readFloat();
					float var10 = var0.readFloat();
					float var11 = var0.readFloat();
					var5 = new DataWathcer.WatchableObject(var3, var4, new class_dc(var9, var10, var11));
			}

			var1.add(var5);
		}

		return var1;
	}

	public boolean d() {
		return b;
	}

	public void e() {
		e = false;
	}

	public static class WatchableObject {
		private final int type;
		private final int id;
		private Object value;
		private boolean d;

		public WatchableObject(int type, int id, Object value) {
			this.id = id;
			this.value = value;
			this.type = type;
			this.d = true;
		}

		public int getId() {
			return id;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

		public int getType() {
			return type;
		}

		public boolean d() {
			return d;
		}

		public void a(boolean var1) {
			d = var1;
		}
	}

}
