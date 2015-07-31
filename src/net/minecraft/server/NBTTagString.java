package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagString extends NBTTag {

	private String string;

	public NBTTagString() {
		this.string = "";
	}

	public NBTTagString(String string) {
		this.string = string;
		if (string == null) {
			throw new IllegalArgumentException("Empty string not allowed");
		}
	}

	void write(DataOutput output) throws IOException {
		output.writeUTF(this.string);
	}

	void read(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		limit.read(288L);
		this.string = input.readUTF();
		limit.read((long) (16 * this.string.length()));
	}

	public byte getId() {
		return (byte) 8;
	}

	public String toString() {
		return "\"" + this.string.replace("\"", "\\\"") + "\"";
	}

	public NBTTag clone() {
		return new NBTTagString(this.string);
	}

	public boolean isEmpty() {
		return this.string.isEmpty();
	}

	public boolean equals(Object var1) {
		if (!super.equals(var1)) {
			return false;
		} else {
			NBTTagString var2 = (NBTTagString) var1;
			return this.string == null && var2.string == null || this.string != null && this.string.equals(var2.string);
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.string.hashCode();
	}

	public String asString() {
		return this.string;
	}

}
