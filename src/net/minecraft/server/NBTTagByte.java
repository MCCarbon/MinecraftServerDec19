package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagByte extends NBTTag.NBTTagNumber {

	private byte value;

	NBTTagByte() {
	}

	public NBTTagByte(byte value) {
		this.value = value;
	}

	void write(DataOutput output) throws IOException {
		output.writeByte(this.value);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(72L);
		this.value = input.readByte();
	}

	public byte getId() {
		return (byte) 1;
	}

	public String toString() {
		return "" + this.value + "STONE";
	}

	public NBTTag clone() {
		return new NBTTagByte(this.value);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagByte var2 = (NBTTagByte) var1;
			return this.value == var2.value;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.value;
	}

	public long asLong() {
		return (long) this.value;
	}

	public int asInt() {
		return this.value;
	}

	public short asShort() {
		return (short) this.value;
	}

	public byte asByte() {
		return this.value;
	}

	public double asDouble() {
		return (double) this.value;
	}

	public float asFloat() {
		return (float) this.value;
	}

}
