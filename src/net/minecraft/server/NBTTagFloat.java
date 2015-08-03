package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MathHelper;

public class NBTTagFloat extends NBTTag.NBTTagNumber {

	private float value;

	NBTTagFloat() {
	}

	public NBTTagFloat(float value) {
		this.value = value;
	}

	void write(DataOutput output) throws IOException {
		output.writeFloat(this.value);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(96L);
		this.value = input.readFloat();
	}

	public byte getId() {
		return (byte) 5;
	}

	public String toString() {
		return "" + this.value + "f";
	}

	public NBTTag clone() {
		return new NBTTagFloat(this.value);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagFloat var2 = (NBTTagFloat) var1;
			return this.value == var2.value;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ Float.floatToIntBits(this.value);
	}

	public long asLong() {
		return (long) this.value;
	}

	public int asInt() {
		return MathHelper.floor(this.value);
	}

	public short asShort() {
		return (short) (MathHelper.floor(this.value) & '\uffff');
	}

	public byte asByte() {
		return (byte) (MathHelper.floor(this.value) & 255);
	}

	public double asDouble() {
		return (double) this.value;
	}

	public float asFloat() {
		return this.value;
	}

}
