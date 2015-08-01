package net.minecraft.server;


public class TileEntityMobSpawner extends TileEntity implements ITickAble {

	private final class_aee a = new class_aee() {
		@Override
		public void a(int var1) {
			TileEntityMobSpawner.this.world.c(TileEntityMobSpawner.this.position, Blocks.MOB_SPAWNER, var1, 0);
		}

		@Override
		public World a() {
			return TileEntityMobSpawner.this.world;
		}

		@Override
		public BlockPosition b() {
			return TileEntityMobSpawner.this.position;
		}

		@Override
		public void a(class_aee.class_a_in_class_aee var1) {
			super.a(var1);
			if (this.a() != null) {
				this.a().h(TileEntityMobSpawner.this.position);
			}

		}
	};

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a.a(var1);
	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		a.b(var1);
	}

	@Override
	public void tick() {
		a.c();
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		write(var1);
		var1.remove("SpawnPotentials");
		return new PacketPlayOutTileEntityData(position, 1, var1);
	}

	@Override
	public boolean handleClientInput(int var1, int var2) {
		return a.b(var1) ? true : super.handleClientInput(var1, var2);
	}

	@Override
	public boolean F() {
		return true;
	}

	public class_aee b() {
		return a;
	}
}
