package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MathHelper;

public class NBTTagDouble extends NBTTag.NBTTagNumber {

	private double value;

	NBTTagDouble() {
	}

	public NBTTagDouble(double value) {
		this.value = value;
	}

	void write(DataOutput output) throws IOException {
		output.writeDouble(this.value);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(128L);
		this.value = input.readDouble();
	}

	public byte getId() {
		return (byte) 6;
	}

	public String toString() {
		return "" + this.value + "d";
	}

	public NBTTag clone() {
		return new NBTTagDouble(this.value);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagDouble var2 = (NBTTagDouble) var1;
			return this.value == var2.value;
		} else {
			return false;
		}
	}

	public int hashCode() {
		long var1 = Double.doubleToLongBits(this.value);
		return super.hashCode() ^ (int) (var1 ^ var1 >>> 32);
	}

	public long asLong() {
		return (long) Math.floor(this.value);
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
		return this.value;
	}

	public float asFloat() {
		return (float) this.value;
	}
}
