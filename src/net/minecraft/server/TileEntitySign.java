package net.minecraft.server;

import com.google.gson.JsonParseException;

public class TileEntitySign extends TileEntity {

	public final IChatBaseComponent[] lines = new IChatBaseComponent[] { new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("") };
	public int f = -1;
	private boolean g = true;
	private EntityHuman h;
	private final class_n i = new class_n();

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = IChatBaseComponent.ChatSerializer.toJson(lines[var2]);
			var1.put("Text" + (var2 + 1), var3);
		}

		i.b(var1);
	}

	@Override
	public void read(NBTTagCompound var1) {
		g = false;
		super.read(var1);
		class_m var2 = new class_m() {
			@Override
			public String getName() {
				return "Sign";
			}

			@Override
			public IChatBaseComponent getScoreboardDisplayName() {
				return new ChatComponentText(getName());
			}

			@Override
			public void a(IChatBaseComponent var1) {
			}

			@Override
			public boolean a(int var1, String var2) {
				return true;
			}

			@Override
			public BlockPosition c() {
				return TileEntitySign.this.position;
			}

			@Override
			public Vec3D d() {
				return new Vec3D(TileEntitySign.this.position.getX() + 0.5D, TileEntitySign.this.position.getY() + 0.5D, TileEntitySign.this.position.getZ() + 0.5D);
			}

			@Override
			public World e() {
				return TileEntitySign.this.world;
			}

			@Override
			public Entity f() {
				return null;
			}

			@Override
			public boolean u_() {
				return false;
			}

			@Override
			public void a(class_n.class_a_in_class_n var1, int var2) {
			}
		};

		for (int var3 = 0; var3 < 4; ++var3) {
			String var4 = var1.getString("Text" + (var3 + 1));

			try {
				IChatBaseComponent var5 = IChatBaseComponent.ChatSerializer.b(var4);

				try {
					lines[var3] = class_ev.a(var2, var5, (Entity) null);
				} catch (class_bz var7) {
					lines[var3] = var5;
				}
			} catch (JsonParseException var8) {
				lines[var3] = new ChatComponentText(var4);
			}
		}

		i.a(var1);
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		IChatBaseComponent[] var1 = new IChatBaseComponent[4];
		System.arraycopy(lines, 0, var1, 0, 4);
		return new PacketPlayOutUpdateSign(world, position, var1);
	}

	@Override
	public boolean F() {
		return true;
	}

	public boolean b() {
		return g;
	}

	public void a(EntityHuman var1) {
		h = var1;
	}

	public EntityHuman c() {
		return h;
	}

	public boolean b(final EntityHuman var1) {
		class_m var2 = new class_m() {
			@Override
			public String getName() {
				return var1.getName();
			}

			@Override
			public IChatBaseComponent getScoreboardDisplayName() {
				return var1.getScoreboardDisplayName();
			}

			@Override
			public void a(IChatBaseComponent var1x) {
			}

			@Override
			public boolean a(int var1x, String var2) {
				return var1x <= 2;
			}

			@Override
			public BlockPosition c() {
				return TileEntitySign.this.position;
			}

			@Override
			public Vec3D d() {
				return new Vec3D(TileEntitySign.this.position.getX() + 0.5D, TileEntitySign.this.position.getY() + 0.5D, TileEntitySign.this.position.getZ() + 0.5D);
			}

			@Override
			public World e() {
				return var1.e();
			}

			@Override
			public Entity f() {
				return var1;
			}

			@Override
			public boolean u_() {
				return false;
			}

			@Override
			public void a(class_n.class_a_in_class_n var1x, int var2) {
				i.a(this, var1x, var2);
			}
		};

		for (int var3 = 0; var3 < lines.length; ++var3) {
			ChatModifier var4 = lines[var3] == null ? null : lines[var3].b();
			if ((var4 != null) && (var4.h() != null)) {
				class_et var5 = var4.h();
				if (var5.a() == class_et.class_a_in_class_et.c) {
					MinecraftServer.N().P().a(var2, var5.b());
				}
			}
		}

		return true;
	}

	public class_n d() {
		return i;
	}
}
