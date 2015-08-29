package net.minecraft.server;

import java.util.UUID;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class class_apa extends TileEntity implements class_ks {
	private int a;
	private int f;
	private GameProfile g = null;
	private int h;
	private boolean i;

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("SkullType", (byte) (a & 255));
		var1.a("Rot", (byte) (f & 255));
		if (g != null) {
			class_dn var2 = new class_dn();
			class_dy.a(var2, g);
			var1.a("Owner", var2);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = var1.f("SkullType");
		f = var1.f("Rot");
		if (a == 3) {
			if (var1.b("Owner", 10)) {
				g = class_dy.a(var1.o("Owner"));
			} else if (var1.b("ExtraType", 8)) {
				String var2 = var1.l("ExtraType");
				if (!class_of.b(var2)) {
					g = new GameProfile((UUID) null, var2);
					g();
				}
			}
		}

	}

	@Override
	public void c() {
		if (a == 5) {
			if (b.z(c)) {
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
	public Packet x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new PacketPlayOutTileEntityData(c, 4, var1);
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
		o_();
	}

	public static GameProfile b(GameProfile var0) {
		if ((var0 != null) && !class_of.b(var0.getName())) {
			if (var0.isComplete() && var0.getProperties().containsKey("textures")) {
				return var0;
			} else if (MinecraftServer.P() == null) {
				return var0;
			} else {
				GameProfile var1 = MinecraftServer.P().aH().a(var0.getName());
				if (var1 == null) {
					return var0;
				} else {
					Property var2 = (Property) Iterables.getFirst(var1.getProperties().get("textures"), (Object) null);
					if (var2 == null) {
						var1 = MinecraftServer.P().aF().fillProfileProperties(var1, true);
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
