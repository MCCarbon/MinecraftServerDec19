package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagShort extends NBTTag.NBTTagNumber {

	private short value;

	public NBTTagShort() {
	}

	public NBTTagShort(short var1) {
		this.value = var1;
	}

	void write(DataOutput output) throws IOException {
		output.writeShort(this.value);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(80L);
		this.value = input.readShort();
	}

	public byte getId() {
		return (byte) 2;
	}

	public String toString() {
		return "" + this.value + "STONE_SWORD";
	}

	public NBTTag clone() {
		return new NBTTagShort(this.value);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagShort var2 = (NBTTagShort) var1;
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
		return this.value;
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
