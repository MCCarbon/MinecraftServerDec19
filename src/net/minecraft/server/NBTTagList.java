package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class NBTTagList extends NBTTag {

	private static final Logger logger = LogManager.getLogger();
	private List<NBTTag> list = Lists.newArrayList();
	private byte listTagType = 0;

	@Override
	void write(DataOutput output) throws IOException {
		if (!list.isEmpty()) {
			listTagType = list.get(0).getId();
		} else {
			listTagType = 0;
		}

		output.writeByte(listTagType);
		output.writeInt(list.size());

		for (int i = 0; i < list.size(); ++i) {
			list.get(i).write(output);
		}
	}

	@Override
	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(296L);
		if (depth > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			listTagType = input.readByte();
			int var4 = input.readInt();
			if ((listTagType == 0) && (var4 > 0)) {
				throw new RuntimeException("Missing type on ListTag");
			} else {
				limit.read(32L * var4);
				list = Lists.newArrayListWithCapacity(var4);

				for (int i = 0; i < var4; ++i) {
					NBTTag tag = NBTTag.getById(listTagType);
					tag.read(input, depth + 1, limit);
					list.add(tag);
				}
			}
		}
	}

	@Override
	public byte getId() {
		return (byte) 9;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");

		for (int i = 0; i < list.size(); ++i) {
			if (i != 0) {
				builder.append(',');
			}
			builder.append(i).append(':').append(list.get(i));
		}

		return builder.append(']').toString();
	}

	public void add(NBTTag tag) {
		if (tag.getId() == 0) {
			logger.warn("Invalid TagEnd added to ListTag");
		} else {
			if (listTagType == 0) {
				listTagType = tag.getId();
			} else if (listTagType != tag.getId()) {
				logger.warn("Adding mismatching tag types to tag list");
				return;
			}

			list.add(tag);
		}
	}

	public void set(int index, NBTTag tag) {
		if (tag.getId() == 0) {
			logger.warn("Invalid TagEnd added to ListTag");
		} else if ((index >= 0) && (index < list.size())) {
			if (listTagType == 0) {
				listTagType = tag.getId();
			} else if (listTagType != tag.getId()) {
				logger.warn("Adding mismatching tag types to tag list");
				return;
			}

			list.set(index, tag);
		} else {
			logger.warn("index out of bounds to set tag in tag list");
		}
	}

	public NBTTag remove(int var1) {
		return list.remove(var1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public NBTTagCompound getCompound(int index) {
		if ((index >= 0) && (index < list.size())) {
			NBTTag tag = list.get(index);
			return tag.getId() == 10 ? (NBTTagCompound) tag : new NBTTagCompound();
		} else {
			return new NBTTagCompound();
		}
	}

	public int getInt(int index) {
		if ((index >= 0) && (index < list.size())) {
			NBTTag tag = list.get(index);
			return tag.getId() == 3 ? ((NBTTagInt) tag).asInt() : 0;
		} else {
			return 0;
		}
	}

	public int[] getIntArray(int index) {
		if ((index >= 0) && (index < list.size())) {
			NBTTag tag = list.get(index);
			return tag.getId() == 11 ? ((NBTTagIntArray) tag).getArray() : new int[0];
		} else {
			return new int[0];
		}
	}

	public double getDouble(int index) {
		if ((index >= 0) && (index < list.size())) {
			NBTTag tag = list.get(index);
			return tag.getId() == 6 ? ((NBTTagDouble) tag).asDouble() : 0.0D;
		} else {
			return 0.0D;
		}
	}

	public float getFloat(int index) {
		if ((index >= 0) && (index < list.size())) {
			NBTTag tag = list.get(index);
			return tag.getId() == 5 ? ((NBTTagFloat) tag).asFloat() : 0.0F;
		} else {
			return 0.0F;
		}
	}

	public String getString(int index) {
		if ((index >= 0) && (index < list.size())) {
			NBTTag tag = list.get(index);
			return tag.getId() == 8 ? tag.asString() : tag.toString();
		} else {
			return "";
		}
	}

	public NBTTag getTag(int index) {
		return (index >= 0) && (index < list.size()) ? (NBTTag) list.get(index) : new NBTTagEnd();
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public NBTTag clone() {
		NBTTagList newtag = new NBTTagList();
		newtag.listTagType = listTagType;
		for (NBTTag tag : list) {
			newtag.list.add(tag.clone());
		}
		return newtag;
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagList var2 = (NBTTagList) var1;
			if (listTagType == var2.listTagType) {
				return list.equals(var2.list);
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ list.hashCode();
	}

	public int getType() {
		return listTagType;
	}

}
