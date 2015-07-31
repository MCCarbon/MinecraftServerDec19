package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

import com.google.common.collect.Maps;

public class NBTTagCompound extends NBTTag {

	private Map<String, NBTTag> map = Maps.newHashMap();

	@Override
	void write(DataOutput outut) throws IOException {
		for (Entry<String, NBTTag> entry : map.entrySet()) {
			writeTag(entry.getKey(), entry.getValue(), outut);
		}
		outut.writeByte(0);
	}

	@Override
	void read(DataInput inpit, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(384L);
		if (depth > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			map.clear();

			byte id;
			while ((id = readId(inpit, limit)) != 0) {
				String key = readKey(inpit, limit);
				limit.read(224 + (16 * key.length()));
				NBTTag tag = readTag(id, key, inpit, depth + 1, limit);
				if (map.put(key, tag) != null) {
					limit.read(288L);
				}
			}
		}
	}

	public Set<String> getKeys() {
		return map.keySet();
	}

	@Override
	public byte getId() {
		return (byte) 10;
	}

	public void put(String key, NBTTag tag) {
		map.put(key, tag);
	}

	public void put(String key, byte b) {
		map.put(key, new NBTTagByte(b));
	}

	public void put(String key, short s) {
		map.put(key, new NBTTagShort(s));
	}

	public void put(String key, int i) {
		map.put(key, new NBTTagInt(i));
	}

	public void put(String key, long l) {
		map.put(key, new NBTTagLong(l));
	}

	public void put(String key, UUID uuid) {
		this.put(key + "Most", uuid.getMostSignificantBits());
		this.put(key + "Least", uuid.getLeastSignificantBits());
	}

	public UUID getUUID(String key) {
		return hasOfType(key + "Most", 99) && hasOfType(key + "Least", 99) ? new UUID(getLong(key + "Most"), getLong(key + "Least")) : null;
	}

	public void put(String var1, float var2) {
		map.put(var1, new NBTTagFloat(var2));
	}

	public void put(String var1, double var2) {
		map.put(var1, new NBTTagDouble(var2));
	}

	public void put(String var1, String var2) {
		map.put(var1, new NBTTagString(var2));
	}

	public void put(String var1, byte[] var2) {
		map.put(var1, new NBTTagByteArray(var2));
	}

	public void put(String var1, int[] var2) {
		map.put(var1, new NBTTagIntArray(var2));
	}

	public void put(String var1, boolean var2) {
		this.put(var1, (byte) (var2 ? 1 : 0));
	}

	public NBTTag getTag(String var1) {
		return map.get(var1);
	}

	public byte getTagType(String key) {
		NBTTag var2 = map.get(key);
		return var2 != null ? var2.getId() : 0;
	}

	public boolean has(String key) {
		return map.containsKey(key);
	}

	public boolean hasOfType(String var1, int inputType) {
		byte type = getTagType(var1);
		if (type == inputType) {
			return true;
		} else if (inputType != 99) {
			return false;
		} else {
			return (type == 1) || (type == 2) || (type == 3) || (type == 4) || (type == 5) || (type == 6);
		}
	}

	public byte getByte(String key) {
		try {
			return !hasOfType(key, 99) ? 0 : ((NBTTag.NBTTagNumber) map.get(key)).asByte();
		} catch (ClassCastException var3) {
			return (byte) 0;
		}
	}

	public short getShort(String key) {
		try {
			return !hasOfType(key, 99) ? 0 : ((NBTTag.NBTTagNumber) map.get(key)).asShort();
		} catch (ClassCastException var3) {
			return (short) 0;
		}
	}

	public int getInt(String key) {
		try {
			return !hasOfType(key, 99) ? 0 : ((NBTTag.NBTTagNumber) map.get(key)).asInt();
		} catch (ClassCastException var3) {
			return 0;
		}
	}

	public long getLong(String key) {
		try {
			return !hasOfType(key, 99) ? 0L : ((NBTTag.NBTTagNumber) map.get(key)).asLong();
		} catch (ClassCastException var3) {
			return 0L;
		}
	}

	public float getFloat(String key) {
		try {
			return !hasOfType(key, 99) ? 0.0F : ((NBTTag.NBTTagNumber) map.get(key)).asFloat();
		} catch (ClassCastException var3) {
			return 0.0F;
		}
	}

	public double getDouble(String key) {
		try {
			return !hasOfType(key, 99) ? 0.0D : ((NBTTag.NBTTagNumber) map.get(key)).asDouble();
		} catch (ClassCastException var3) {
			return 0.0D;
		}
	}

	public String getString(String key) {
		try {
			return !hasOfType(key, 8) ? "" : map.get(key).asString();
		} catch (ClassCastException var3) {
			return "";
		}
	}

	public byte[] getByteArray(String key) {
		try {
			return !hasOfType(key, 7) ? new byte[0] : ((NBTTagByteArray) map.get(key)).getArray();
		} catch (ClassCastException var3) {
			throw new class_e(this.a(key, 7, var3));
		}
	}

	public int[] getIntArray(String key) {
		try {
			return !hasOfType(key, 11) ? new int[0] : ((NBTTagIntArray) map.get(key)).getArray();
		} catch (ClassCastException var3) {
			throw new class_e(this.a(key, 11, var3));
		}
	}

	public NBTTagCompound getCompound(String key) {
		try {
			return !hasOfType(key, 10) ? new NBTTagCompound() : (NBTTagCompound) map.get(key);
		} catch (ClassCastException var3) {
			throw new class_e(this.a(key, 10, var3));
		}
	}

	public NBTTagList getList(String key, int type) {
		try {
			if (getTagType(key) != 9) {
				return new NBTTagList();
			} else {
				NBTTagList var3 = (NBTTagList) map.get(key);
				return (var3.getSize() > 0) && (var3.getType() != type) ? new NBTTagList() : var3;
			}
		} catch (ClassCastException var4) {
			throw new class_e(this.a(key, 9, var4));
		}
	}

	public boolean getBoolean(String key) {
		return getByte(key) != 0;
	}

	public void remove(String key) {
		map.remove(key);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");

		for (Entry<String, NBTTag> entry : map.entrySet()) {
			if (builder.length() != 1) {
				builder.append(',');
			}
			builder.append(entry.getKey()).append(':').append(entry.getValue());
		}

		return builder.append('}').toString();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public NBTTag clone() {
		NBTTagCompound newCompound = new NBTTagCompound();
		for (Entry<String, NBTTag> entry : map.entrySet()) {
			newCompound.put(entry.getKey(), entry.getValue().clone());
		}
		return newCompound;
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagCompound var2 = (NBTTagCompound) var1;
			return map.entrySet().equals(var2.map.entrySet());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ map.hashCode();
	}

	private static void writeTag(String key, NBTTag tag, DataOutput output) throws IOException {
		output.writeByte(tag.getId());
		if (tag.getId() != 0) {
			output.writeUTF(key);
			tag.write(output);
		}
	}

	private static byte readId(DataInput input, NBTReadLimiter limit) throws IOException {
		return input.readByte();
	}

	private static String readKey(DataInput input, NBTReadLimiter limit) throws IOException {
		return input.readUTF();
	}

	static NBTTag readTag(byte id, String key, DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		NBTTag tag = NBTTag.getById(id);
		try {
			tag.read(input, depth, limit);
			return tag;
		} catch (IOException var9) {
			class_b var7 = class_b.a(var9, "Loading NBT data");
			class_c var8 = var7.a("NBT Tag");
			var8.a("Tag name", key);
			var8.a("Tag type", Byte.valueOf(id));
			throw new class_e(var7);
		}
	}

	public void copyFrom(NBTTagCompound compound) {
		for (Entry<String, NBTTag> entry : map.entrySet()) {
			String key = entry.getKey();
			NBTTag tag = entry.getValue();
			if (tag.getId() == 10) {
				if (hasOfType(key, 10)) {
					NBTTagCompound localCompound = getCompound(key);
					localCompound.copyFrom((NBTTagCompound) tag);
				} else {
					this.put(key, tag.clone());
				}
			} else {
				this.put(key, tag.clone());
			}
		}
	}

	private class_b a(final String var1, final int var2, ClassCastException var3) {
		class_b var4 = class_b.a(var3, "Reading NBT data");
		class_c var5 = var4.a("Corrupt NBT tag", 1);
		var5.a("Tag type found", new Callable<Object>() {
			public String a() throws Exception {
				return NBTTag.TYPE[map.get(var1).getId()];
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var5.a("Tag type expected", new Callable<Object>() {
			public String a() throws Exception {
				return NBTTag.TYPE[var2];
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var5.a("Tag name", var1);
		return var4;
	}

}
