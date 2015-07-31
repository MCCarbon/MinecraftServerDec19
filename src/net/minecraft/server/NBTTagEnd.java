package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.server.NBTReadLimiter;
import net.minecraft.server.NBTTag;

public class NBTTagEnd extends NBTTag {

	void read(DataInput input, int var2, NBTReadLimiter limit) throws IOException {
		limit.read(64L);
	}

	void write(DataOutput output) throws IOException {
	}

	public byte getId() {
		return (byte) 0;
	}

	public String toString() {
		return "END";
	}

	public NBTTag clone() {
		return new NBTTagEnd();
	}

}
