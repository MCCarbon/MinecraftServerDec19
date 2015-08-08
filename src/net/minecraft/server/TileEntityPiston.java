package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class TileEntityPiston extends TileEntity implements ITickAble {

	private IBlockData a;
	private EnumDirection f;
	private boolean g;
	private boolean h;
	private float i;
	private float j;
	private List k = Lists.newArrayList();

	public TileEntityPiston() {
	}

	public TileEntityPiston(IBlockData var1, EnumDirection var2, boolean var3, boolean var4) {
		a = var1;
		f = var2;
		g = var3;
		h = var4;
	}

	public IBlockData b() {
		return a;
	}

	@Override
	public int getMetadata() {
		return 0;
	}

	public boolean d() {
		return g;
	}

	public EnumDirection e() {
		return f;
	}

	public float a(float var1) {
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		return j + ((i - j) * var1);
	}

	private void a(float var1, float var2) {
		if (g) {
			var1 = 1.0F - var1;
		} else {
			--var1;
		}

		AxisAlignedBB var3 = Blocks.PISTON_EXTENSION.a(world, position, a, var1, f);
		if (var3 != null) {
			List var4 = world.getEntities((Entity) null, var3);
			if (!var4.isEmpty()) {
				k.addAll(var4);
				Iterator var5 = k.iterator();

				while (true) {
					while (var5.hasNext()) {
						Entity var6 = (Entity) var5.next();
						if ((a.getBlock() == Blocks.SLINE) && g) {
							switch (TileEntityPiston.SyntheticClass_1.a[f.getAxis().ordinal()]) {
								case 1:
									var6.motX = f.getAdjacentX();
									break;
								case 2:
									var6.motY = f.getAdjacentY();
									break;
								case 3:
									var6.motZ = f.getAdjacentZ();
							}
						} else {
							var6.d(var2 * f.getAdjacentX(), var2 * f.getAdjacentY(), var2 * f.getAdjacentZ());
						}
					}

					k.clear();
					break;
				}
			}
		}

	}

	public void h() {
		if ((j < 1.0F) && (world != null)) {
			j = i = 1.0F;
			world.t(position);
			setInvalid();
			if (world.getType(position).getBlock() == Blocks.PISTON_EXTENSION) {
				world.setTypeAndData(position, a, 3);
				world.d(position, a.getBlock());
			}
		}

	}

	@Override
	public void tick() {
		j = i;
		if (j >= 1.0F) {
			this.a(1.0F, 0.25F);
			world.t(position);
			setInvalid();
			if (world.getType(position).getBlock() == Blocks.PISTON_EXTENSION) {
				world.setTypeAndData(position, a, 3);
				world.d(position, a.getBlock());
			}

		} else {
			i += 0.5F;
			if (i >= 1.0F) {
				i = 1.0F;
			}

			if (g) {
				this.a(i, (i - j) + 0.0625F);
			}

		}
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a = Block.getById(var1.getInt("blockId")).fromLegacyData(var1.getInt("blockData"));
		f = EnumDirection.getById(var1.getInt("facing"));
		j = i = var1.getFloat("progress");
		g = var1.getBoolean("extending");
	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("blockId", Block.getId(a.getBlock()));
		var1.put("blockData", a.getBlock().toLegacyData(a));
		var1.put("facing", f.getId());
		var1.put("progress", j);
		var1.put("extending", g);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[EnumDirection.EnumAxis.values().length];

		static {
			try {
				a[EnumDirection.EnumAxis.X.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[EnumDirection.EnumAxis.Y.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[EnumDirection.EnumAxis.Z.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
