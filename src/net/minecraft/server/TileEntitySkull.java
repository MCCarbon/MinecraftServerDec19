package net.minecraft.server;

import java.util.UUID;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class TileEntitySkull extends TileEntity implements ITickAble {

	private int a;
	private int f;
	private GameProfile g = null;
	private int h;
	private boolean i;

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("SkullType", (byte) (a & 255));
		var1.put("Rot", (byte) (f & 255));
		if (g != null) {
			NBTTagCompound var2 = new NBTTagCompound();
			NBTStructSerializer.writeGameProfile(var2, g);
			var1.put("Owner", var2);
		}

	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a = var1.getByte("SkullType");
		f = var1.getByte("Rot");
		if (a == 3) {
			if (var1.hasOfType("Owner", 10)) {
				g = NBTStructSerializer.getGameProfile(var1.getCompound("Owner"));
			} else if (var1.hasOfType("ExtraType", 8)) {
				String var2 = var1.getString("ExtraType");
				if (!UtilColor.isStringEmpty(var2)) {
					g = new GameProfile((UUID) null, var2);
					g();
				}
			}
		}

	}

	@Override
	public void tick() {
		if (a == 5) {
			if (world.isBlockIndirectlyPowered(position)) {
				i = true;
				++h;
			} else {
				i = false;
			}
		}

	}

	public GameProfile b() {
		return g;
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		write(var1);
		return new PacketPlayOutTileEntityData(position, 4, var1);
	}

	public void a(int var1) {
		a = var1;
		g = null;
	}

	public void a(GameProfile var1) {
		a = 3;
		g = var1;
		g();
	}

	private void g() {
		g = b(g);
		update();
	}

	public static GameProfile b(GameProfile var0) {
		if ((var0 != null) && !UtilColor.isStringEmpty(var0.getName())) {
			if (var0.isComplete() && var0.getProperties().containsKey("textures")) {
				return var0;
			} else if (MinecraftServer.getServer() == null) {
				return var0;
			} else {
				GameProfile var1 = MinecraftServer.getServer().aF().a(var0.getName());
				if (var1 == null) {
					return var0;
				} else {
					Property var2 = (Property) Iterables.getFirst(var1.getProperties().get("textures"), (Object) null);
					if (var2 == null) {
						var1 = MinecraftServer.getServer().aD().fillProfileProperties(var1, true);
					}

					return var1;
				}
			}
		} else {
			return var0;
		}
	}

	public int d() {
		return a;
	}

	public void b(int var1) {
		f = var1;
	}
}
