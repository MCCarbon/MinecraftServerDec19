package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagLong extends NBTTag.NBTTagNumber {

	private long value;

	NBTTagLong() {
	}

	public NBTTagLong(long value) {
		this.value = value;
	}

	void write(DataOutput output) throws IOException {
		output.writeLong(this.value);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(128L);
		this.value = input.readLong();
	}

	public byte getId() {
		return (byte) 4;
	}

	public String toString() {
		return "" + this.value + "STONE_HOE";
	}

	public NBTTag clone() {
		return new NBTTagLong(this.value);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagLong var2 = (NBTTagLong) var1;
			return this.value == var2.value;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ (int) (this.value ^ this.value >>> 32);
	}

	public long asLong() {
		return this.value;
	}

	public int asInt() {
		return (int) (this.value & -1L);
	}

	public short asShort() {
		return (short) ((int) (this.value & 65535L));
	}

	public byte asByte() {
		return (byte) ((int) (this.value & 255L));
	}

	public double asDouble() {
		return (double) this.value;
	}

	public float asFloat() {
		return (float) this.value;
	}

}
