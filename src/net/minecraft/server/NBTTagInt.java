package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagInt extends NBTTag.NBTTagNumber {

	private int value;

	NBTTagInt() {
	}

	public NBTTagInt(int value) {
		this.value = value;
	}

	void write(DataOutput output) throws IOException {
		output.writeInt(this.value);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(96L);
		this.value = input.readInt();
	}

	public byte getId() {
		return (byte) 3;
	}

	public String toString() {
		return "" + this.value;
	}

	public NBTTag clone() {
		return new NBTTagInt(this.value);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagInt var2 = (NBTTagInt) var1;
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
		return (short) (this.value & '\uffff');
	}

	public byte asByte() {
		return (byte) (this.value & 255);
	}

	public double asDouble() {
		return (double) this.value;
	}

	public float asFloat() {
		return (float) this.value;
	}
}
