package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTTagByteArray;
import net.minecraft.server.NBTTagByte;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagDouble;
import net.minecraft.server.NBTTagEnd;
import net.minecraft.server.NBTTagFloat;
import net.minecraft.server.NBTTagIntArray;
import net.minecraft.server.NBTTagInt;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTagLong;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTagShort;
import net.minecraft.server.NBTTagString;

public abstract class NBTTag {

	public static final String[] TYPE = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]" };

	abstract void write(DataOutput output) throws IOException;

	abstract void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException;

	public abstract String toString();

	public abstract byte getId();

	protected static NBTTag getById(byte id) {
		switch (id) {
			case 0:
				return new NBTTagEnd();
			case 1:
				return new NBTTagByte();
			case 2:
				return new NBTTagShort();
			case 3:
				return new NBTTagInt();
			case 4:
				return new NBTTagLong();
			case 5:
				return new NBTTagFloat();
			case 6:
				return new NBTTagDouble();
			case 7:
				return new NBTTagByteArray();
			case 8:
				return new NBTTagString();
			case 9:
				return new NBTTagList();
			case 10:
				return new NBTTagCompound();
			case 11:
				return new NBTTagIntArray();
			default:
				return null;
		}
	}

	public abstract NBTTag clone();

	public boolean isEmpty() {
		return false;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof NBTTag)) {
			return false;
		} else {
			NBTTag var2 = (NBTTag) var1;
			return this.getId() == var2.getId();
		}
	}

	public int hashCode() {
		return this.getId();
	}

	protected String asString() {
		return this.toString();
	}

	public abstract static class NBTTagNumber extends NBTTag {
		public abstract long asLong();

		public abstract int asInt();

		public abstract short asShort();

		public abstract byte asByte();

		public abstract double asDouble();

		public abstract float asFloat();
	}

}
