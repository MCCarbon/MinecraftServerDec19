package net.minecraft.server;


public class TileEntityCommand extends TileEntity {

	private final class_aed a = new class_aed() {
		@Override
		public BlockPosition c() {
			return TileEntityCommand.this.position;
		}

		@Override
		public Vec3D d() {
			return new Vec3D(TileEntityCommand.this.position.getX() + 0.5D, TileEntityCommand.this.position.getY() + 0.5D, TileEntityCommand.this.position.getZ() + 0.5D);
		}

		@Override
		public World e() {
			return TileEntityCommand.this.getWorld();
		}

		@Override
		public void a(String var1) {
			super.a(var1);
			TileEntityCommand.this.update();
		}

		@Override
		public void h() {
			TileEntityCommand.this.getWorld().notify(TileEntityCommand.this.position);
		}

		@Override
		public Entity f() {
			return null;
		}
	};

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		a.a(var1);
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a.b(var1);
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		write(var1);
		return new PacketPlayOutTileEntityData(position, 2, var1);
	}

	@Override
	public boolean F() {
		return true;
	}

	public class_aed b() {
		return a;
	}

	public class_n c() {
		return a.n();
	}
}
