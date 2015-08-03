package net.minecraft.server;


public class TileEntityNote extends TileEntity {

	public byte a;
	public boolean f;

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("note", a);
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a = var1.getByte("note");
		a = (byte) MathHelper.clamp(a, 0, 24);
	}

	public void b() {
		a = (byte) ((a + 1) % 25);
		update();
	}

	public void play(World var1, BlockPosition var2) {
		if (var1.getType(var2.up()).getBlock().getMaterial() == Material.AIR) {
			Material var3 = var1.getType(var2.down()).getBlock().getMaterial();
			byte var4 = 0;
			if (var3 == Material.STONE) {
				var4 = 1;
			}

			if (var3 == Material.SAND) {
				var4 = 2;
			}

			if (var3 == Material.SHATTERABLE) {
				var4 = 3;
			}

			if (var3 == Material.WOOD) {
				var4 = 4;
			}

			var1.c(var2, BlockStainedGlassPane.NOTEBLOCK, var4, a);
		}
	}

}
