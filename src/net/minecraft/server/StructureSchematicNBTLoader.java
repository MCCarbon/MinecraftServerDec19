package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.common.collect.Maps;

public class StructureSchematicNBTLoader {

	private final Map<String, SctructureSchmeatic> schematics = Maps.newHashMap();

	public SctructureSchmeatic getSchematic(MinecraftKey key) {
		String name = key.getName();
		if (this.schematics.containsKey(name)) {
			return this.schematics.get(name);
		} else {
			this.loadSchematic(key);
			if (this.schematics.containsKey(name)) {
				return this.schematics.get(name);
			} else {
				SctructureSchmeatic var3 = new SctructureSchmeatic();
				this.schematics.put(name, var3);
				return var3;
			}
		}
	}

	public boolean loadSchematic(MinecraftKey key) {
		String name = key.getName();
		File folder = MinecraftServer.getServer().d("structures");
		File file = new File(folder, name + ".nbt");
		if (!file.exists()) {
			return this.loadSchematic0(key);
		} else {
			FileInputStream is = null;
			boolean success;
			try {
				is = new FileInputStream(file);
				this.loadSchematicInputStream(name, is);
				return true;
			} catch (Throwable var11) {
				success = false;
			} finally {
				IOUtils.closeQuietly(is);
			}
			return success;
		}
	}

	private boolean loadSchematic0(MinecraftKey var1) {
		String namespace = var1.getNamespace();
		String name = var1.getName();
		InputStream is = null;

		boolean var6;
		try {
			is = MinecraftServer.class.getResourceAsStream("/assets/" + namespace + "/structures/" + name + ".nbt");
			this.loadSchematicInputStream(name, is);
			return true;
		} catch (Throwable var10) {
			var6 = false;
		} finally {
			IOUtils.closeQuietly(is);
		}

		return var6;
	}

	private void loadSchematicInputStream(String name, InputStream is) throws IOException {
		NBTTagCompound compound = NBTCompressedStreamTools.fromRawInputStream(is);
		SctructureSchmeatic schematic = new SctructureSchmeatic();
		schematic.load(compound);
		this.schematics.put(name, schematic);
	}

	public boolean saveSchematic(MinecraftKey var1) {
		String name = var1.getName();
		if (!this.schematics.containsKey(name)) {
			return false;
		} else {
			File folder = MinecraftServer.getServer().d("structures");
			if (!folder.exists()) {
				if (!folder.mkdirs()) {
					return false;
				}
			} else if (!folder.isDirectory()) {
				return false;
			}

			File file = new File(folder, name + ".nbt");
			NBTTagCompound compound = new NBTTagCompound();
			SctructureSchmeatic schematic = this.schematics.get(name);
			FileOutputStream os = null;

			boolean success;
			try {
				schematic.save(compound);
				os = new FileOutputStream(file);
				NBTCompressedStreamTools.writeToRawOutputStream(compound, os);
				return true;
			} catch (Throwable var13) {
				success = false;
			} finally {
				IOUtils.closeQuietly(os);
			}

			return success;
		}
	}

}
