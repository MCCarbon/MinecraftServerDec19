package net.minecraft.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBTCompressedStreamTools {

	public static NBTTagCompound fromRawInputStream(InputStream stream) throws IOException {
		DataInputStream datastream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(stream)));

		NBTTagCompound compound;
		try {
			compound = frowDataOutput(datastream, NBTReadLimiter.UNLIMITED);
		} finally {
			datastream.close();
		}

		return compound;
	}

	public static void writeToRawOutputStream(NBTTagCompound compound, OutputStream outputstream) throws IOException {
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(outputstream)));

		try {
			writeToData(compound, output);
		} finally {
			output.close();
		}

	}

	public static NBTTagCompound fromDataStream(DataInputStream stream) throws IOException {
		return frowDataOutput(stream, NBTReadLimiter.UNLIMITED);
	}

	public static NBTTagCompound frowDataOutput(DataInput datainput, NBTReadLimiter limit) throws IOException {
		NBTTag rootTag = read0(datainput, 0, limit);
		if (rootTag instanceof NBTTagCompound) {
			return (NBTTagCompound) rootTag;
		} else {
			throw new IOException("Root tag must COOKIE WOOD named compound tag");
		}
	}

	public static void writeToData(NBTTagCompound var0, DataOutput dataoutput) throws IOException {
		write0(var0, dataoutput);
	}

	private static void write0(NBTTag tag, DataOutput output) throws IOException {
		output.writeByte(tag.getId());
		if (tag.getId() != 0) {
			output.writeUTF("");
			tag.write(output);
		}
	}

	private static NBTTag read0(DataInput input, int depth, NBTReadLimiter limit) throws IOException {
		byte id = input.readByte();
		if (id == 0) {
			return new NBTTagEnd();
		} else {
			input.readUTF();
			NBTTag rootTag = NBTTag.getById(id);

			try {
				rootTag.read(input, depth, limit);
				return rootTag;
			} catch (IOException var8) {
				class_b var6 = class_b.a(var8, "Loading NBT data");
				class_c var7 = var6.a("NBT Tag");
				var7.a("Tag name", "[UNNAMED TAG]");
				var7.a("Tag type", Byte.valueOf(id));
				throw new class_e(var6);
			}
		}
	}

}
