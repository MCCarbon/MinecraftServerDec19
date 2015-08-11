package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.util.Iterator;
import java.util.UUID;

import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.UtilColor;

public final class NBTStructSerializer {

	public static GameProfile getGameProfile(NBTTagCompound compound) {
		String var1 = null;
		String var2 = null;
		if (compound.hasOfType("Name", 8)) {
			var1 = compound.getString("Name");
		}

		if (compound.hasOfType("Id", 8)) {
			var2 = compound.getString("Id");
		}

		if (UtilColor.isStringEmpty(var1) && UtilColor.isStringEmpty(var2)) {
			return null;
		} else {
			UUID var3;
			try {
				var3 = UUID.fromString(var2);
			} catch (Throwable var12) {
				var3 = null;
			}

			GameProfile var4 = new GameProfile(var3, var1);
			if (compound.hasOfType("Properties", 10)) {
				NBTTagCompound var5 = compound.getCompound("Properties");
				Iterator<?> var6 = var5.getKeys().iterator();

				while (var6.hasNext()) {
					String var7 = (String) var6.next();
					NBTTagList var8 = var5.getList(var7, 10);

					for (int var9 = 0; var9 < var8.getSize(); ++var9) {
						NBTTagCompound var10 = var8.getCompound(var9);
						String var11 = var10.getString("Value");
						if (var10.hasOfType("Signature", 8)) {
							var4.getProperties().put(var7, new Property(var7, var11, var10.getString("Signature")));
						} else {
							var4.getProperties().put(var7, new Property(var7, var11));
						}
					}
				}
			}

			return var4;
		}
	}

	public static NBTTagCompound writeGameProfile(NBTTagCompound compound, GameProfile profile) {
		if (!UtilColor.isStringEmpty(profile.getName())) {
			compound.put("Name", profile.getName());
		}

		if (profile.getId() != null) {
			compound.put("Id", profile.getId().toString());
		}

		if (!profile.getProperties().isEmpty()) {
			NBTTagCompound var2 = new NBTTagCompound();
			Iterator<String> var3 = profile.getProperties().keySet().iterator();

			while (var3.hasNext()) {
				String var4 = (String) var3.next();
				NBTTagList var5 = new NBTTagList();

				NBTTagCompound var8;
				for (Iterator<Property> var6 = profile.getProperties().get(var4).iterator(); var6.hasNext(); var5.add((NBTTag) var8)) {
					Property var7 = (Property) var6.next();
					var8 = new NBTTagCompound();
					var8.put("Value", var7.getValue());
					if (var7.hasSignature()) {
						var8.put("Signature", var7.getSignature());
					}
				}

				var2.put((String) var4, (NBTTag) var5);
			}

			compound.put((String) "Properties", (NBTTag) var2);
		}

		return compound;
	}

	public static boolean a(NBTTag var0, NBTTag var1, boolean var2) {
		if (var0 == var1) {
			return true;
		} else if (var0 == null) {
			return true;
		} else if (var1 == null) {
			return false;
		} else if (!var0.getClass().equals(var1.getClass())) {
			return false;
		} else if (var0 instanceof NBTTagCompound) {
			NBTTagCompound var9 = (NBTTagCompound) var0;
			NBTTagCompound var10 = (NBTTagCompound) var1;
			Iterator<?> var11 = var9.getKeys().iterator();

			String var12;
			NBTTag var13;
			do {
				if (!var11.hasNext()) {
					return true;
				}

				var12 = (String) var11.next();
				var13 = var9.getTag(var12);
			} while (a(var13, var10.getTag(var12), var2));

			return false;
		} else if (var0 instanceof NBTTagList && var2) {
			NBTTagList var3 = (NBTTagList) var0;
			NBTTagList var4 = (NBTTagList) var1;
			if (var3.getSize() == 0) {
				return var4.getSize() == 0;
			} else {
				for (int var5 = 0; var5 < var3.getSize(); ++var5) {
					NBTTag var6 = var3.getTag(var5);
					boolean var7 = false;

					for (int var8 = 0; var8 < var4.getSize(); ++var8) {
						if (a(var6, var4.getTag(var8), var2)) {
							var7 = true;
							break;
						}
					}

					if (!var7) {
						return false;
					}
				}

				return true;
			}
		} else {
			return var0.equals(var1);
		}
	}

	public static NBTTagCompound toNBT(UUID uuid) {
		NBTTagCompound var1 = new NBTTagCompound();
		var1.put("M", uuid.getMostSignificantBits());
		var1.put("L", uuid.getLeastSignificantBits());
		return var1;
	}

	public static UUID getUUID(NBTTagCompound var0) {
		return new UUID(var0.getLong("M"), var0.getLong("L"));
	}

	public static BlockPosition getBlockPosition(NBTTagCompound compound) {
		return new BlockPosition(compound.getInt("X"), compound.getInt("Y"), compound.getInt("Z"));
	}

	public static NBTTagCompound toNBT(BlockPosition position) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.put("X", position.getX());
		tag.put("Y", position.getY());
		tag.put("Z", position.getZ());
		return tag;
	}

}
