package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagByteArray extends NBTTag {

	private byte[] array;

	NBTTagByteArray() {
	}

	public NBTTagByteArray(byte[] array) {
		this.array = array;
	}

	void write(DataOutput output) throws IOException {
		output.writeInt(this.array.length);
		output.write(this.array);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(192L);
		int length = input.readInt();
		limit.read((long) (8 * length));
		this.array = new byte[length];
		input.readFully(this.array);
	}

	public byte getId() {
		return (byte) 7;
	}

	public String toString() {
		return "[" + this.array.length + " bytes]";
	}

	public NBTTag clone() {
		byte[] var1 = new byte[this.array.length];
		System.arraycopy(this.array, 0, var1, 0, this.array.length);
		return new NBTTagByteArray(var1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(this.array, ((NBTTagByteArray) var1).array) : false;
	}

	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(this.array);
	}

	public byte[] getArray() {
		return this.array;
	}

}
