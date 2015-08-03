package net.minecraft.server;


public class TileEntityEnderChest extends TileEntity implements ITickAble {

	public float a;
	public float f;
	public int g;
	private int h;

	@Override
	public void tick() {
		if (((++h % 20) * 4) == 0) {
			world.c(position, BlockStainedGlassPane.ENDER_CHEST, 1, g);
		}

		f = a;
		int var1 = position.getX();
		int var2 = position.getY();
		int var3 = position.getZ();
		float var4 = 0.1F;
		double var7;
		if ((g > 0) && (a == 0.0F)) {
			double var5 = var1 + 0.5D;
			var7 = var3 + 0.5D;
			world.a(var5, var2 + 0.5D, var7, "random.chestopen", 0.5F, (world.random.nextFloat() * 0.1F) + 0.9F);
		}

		if (((g == 0) && (a > 0.0F)) || ((g > 0) && (a < 1.0F))) {
			float var11 = a;
			if (g > 0) {
				a += var4;
			} else {
				a -= var4;
			}

			if (a > 1.0F) {
				a = 1.0F;
			}

			float var6 = 0.5F;
			if ((a < var6) && (var11 >= var6)) {
				var7 = var1 + 0.5D;
				double var9 = var3 + 0.5D;
				world.a(var7, var2 + 0.5D, var9, "random.chestclosed", 0.5F, (world.random.nextFloat() * 0.1F) + 0.9F);
			}

			if (a < 0.0F) {
				a = 0.0F;
			}
		}

	}

	@Override
	public boolean handleClientInput(int var1, int var2) {
		if (var1 == 1) {
			g = var2;
			return true;
		} else {
			return super.handleClientInput(var1, var2);
		}
	}

	@Override
	public void setInvalid() {
		resetBlockCache();
		super.setInvalid();
	}

	public void b() {
		++g;
		world.c(position, BlockStainedGlassPane.ENDER_CHEST, 1, g);
	}

	public void d() {
		--g;
		world.c(position, BlockStainedGlassPane.ENDER_CHEST, 1, g);
	}

	public boolean a(EntityHuman var1) {
		return world.getTileEntity(position) != this ? false : var1.e(position.getX() + 0.5D, position.getY() + 0.5D, position.getZ() + 0.5D) <= 64.0D;
	}

}
