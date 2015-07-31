package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagIntArray extends NBTTag {

	private int[] array;

	NBTTagIntArray() {
	}

	public NBTTagIntArray(int[] array) {
		this.array = array;
	}

	void write(DataOutput output) throws IOException {
		output.writeInt(this.array.length);

		for (int var2 = 0; var2 < this.array.length; ++var2) {
			output.writeInt(this.array[var2]);
		}

	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(192L);
		int length = input.readInt();
		limit.read((long) (32 * length));
		this.array = new int[length];
		for (int i = 0; i < length; ++i) {
			this.array[i] = input.readInt();
		}
	}

	public byte getId() {
		return (byte) 11;
	}

	public String toString() {
		String string = "[";
		for (int element : this.array) {
			string = string + element + ",";
		}
		return string + "]";
	}

	public NBTTag clone() {
		int[] newarray = new int[this.array.length];
		System.arraycopy(this.array, 0, newarray, 0, this.array.length);
		return new NBTTagIntArray(newarray);
	}

	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(this.array, ((NBTTagIntArray) var1).array) : false;
	}

	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(this.array);
	}

	public int[] getArray() {
		return this.array;
	}

}
