package net.minecraft.server;

import java.util.Random;

import net.minecraft.server.BlockWood.EnumLogVariant;

public class BlockSapling extends BlockPlant implements IBlockFragilePlantElement {

	public static final BlockStateEnum<EnumLogVariant> VARIANT = BlockStateEnum.of("type", EnumLogVariant.class);
	public static final BlockStateInteger STAGE = BlockStateInteger.of("stage", 0, 1);

	protected BlockSapling() {
		setBlockData(blockStateList.getFirst().set(VARIANT, BlockWood.EnumLogVariant.OAK).set(STAGE, Integer.valueOf(0)));
		float var1 = 0.4F;
		setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
		setCreativeTab(CreativeTab.DECORATIONS);
	}

	@Override
	public String getName() {
		return LocaleI18n.get(getInternalName() + "." + BlockWood.EnumLogVariant.OAK.d() + ".name");
	}

	@Override
	public void tick(World world, BlockPosition position, IBlockData blockdata, Random rnd) {
		if (!world.isClientSide) {
			super.tick(world, position, blockdata, rnd);
			if ((world.l(position.up()) >= 9) && (rnd.nextInt(7) == 0)) {
				grow(world, position, blockdata, rnd);
			}
		}
	}

	public void grow(World world, BlockPosition var2, IBlockData blockdata, Random var4) {
		if (blockdata.get(STAGE).intValue() == 0) {
			world.setTypeAndData(var2, blockdata.a(STAGE), 4);
		} else {
			this.growTree(world, var2, blockdata, var4);
		}
	}

	public void growTree(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		Object var5 = var4.nextInt(10) == 0 ? new class_apx(true) : new class_arn(true);
		int var6 = 0;
		int var7 = 0;
		boolean var8 = false;
		IBlockData var9;
		switch (var3.get(VARIANT)) {
			case SPRUCE:
				label68: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2, var6, var7, BlockWood.EnumLogVariant.SPRUCE)) {
							var5 = new class_aqx(false, var4.nextBoolean());
							var8 = true;
							break label68;
						}
					}
				}

				if (!var8) {
					var7 = 0;
					var6 = 0;
					var5 = new class_ark(true);
				}
				break;
			case BIRCH:
				var5 = new class_apy(true, false);
				break;
			case JUNGLE:
				var9 = Blocks.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.JUNGLE);
				IBlockData var10 = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.JUNGLE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

				label82: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2, var6, var7, BlockWood.EnumLogVariant.JUNGLE)) {
							var5 = new class_aqw(true, 10, 20, var9, var10);
							var8 = true;
							break label82;
						}
					}
				}

				if (!var8) {
					var7 = 0;
					var6 = 0;
					var5 = new class_arn(true, 4 + var4.nextInt(7), var9, var10, false);
				}
				break;
			case ACACIA:
				var5 = new class_arh(true);
				break;
			case DARK_OAK:
				label96: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2, var6, var7, BlockWood.EnumLogVariant.DARK_OAK)) {
							var5 = new class_arf(true);
							var8 = true;
							break label96;
						}
					}
				}

				if (!var8) {
					return;
				}
			case OAK:
				break;
		}

		var9 = Blocks.AIR.getBlockData();
		if (var8) {
			var1.setTypeAndData(var2.add(var6, 0, var7), var9, 4);
			var1.setTypeAndData(var2.add(var6 + 1, 0, var7), var9, 4);
			var1.setTypeAndData(var2.add(var6, 0, var7 + 1), var9, 4);
			var1.setTypeAndData(var2.add(var6 + 1, 0, var7 + 1), var9, 4);
		} else {
			var1.setTypeAndData(var2, var9, 4);
		}

		if (!((WorldGenerator) var5).generate(var1, var4, var2.add(var6, 0, var7))) {
			if (var8) {
				var1.setTypeAndData(var2.add(var6, 0, var7), var3, 4);
				var1.setTypeAndData(var2.add(var6 + 1, 0, var7), var3, 4);
				var1.setTypeAndData(var2.add(var6, 0, var7 + 1), var3, 4);
				var1.setTypeAndData(var2.add(var6 + 1, 0, var7 + 1), var3, 4);
			} else {
				var1.setTypeAndData(var2, var3, 4);
			}
		}

	}

	private boolean a(World var1, BlockPosition var2, int var3, int var4, BlockWood.EnumLogVariant var5) {
		return this.a(var1, var2.add(var3, 0, var4), var5) && this.a(var1, var2.add(var3 + 1, 0, var4), var5) && this.a(var1, var2.add(var3, 0, var4 + 1), var5) && this.a(var1, var2.add(var3 + 1, 0, var4 + 1), var5);
	}

	public boolean a(World var1, BlockPosition var2, BlockWood.EnumLogVariant var3) {
		IBlockData var4 = var1.getType(var2);
		return (var4.getBlock() == this) && (var4.get(VARIANT) == var3);
	}

	@Override
	public int getDropData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getId();
	}

	@Override
	public boolean a(World world, BlockPosition position, IBlockData blockdata, boolean bool) {
		return true;
	}

	@Override
	public boolean a(World world, Random rnd, BlockPosition var3, IBlockData blockdata) {
		return world.random.nextFloat() < 0.45D;
	}

	@Override
	public void b(World world, Random rnd, BlockPosition position, IBlockData blockdata) {
		grow(world, position, blockdata, rnd);
	}

	@Override
	public IBlockData fromLegacyData(int data) {
		return getBlockData().set(VARIANT, BlockWood.EnumLogVariant.getById(data & 7)).set(STAGE, (data & 8) >> 3);
	}

	@Override
	public int toLegacyData(IBlockData blockdata) {
		byte var2 = 0;
		int var3 = var2 | blockdata.get(VARIANT).getId();
		var3 |= blockdata.get(STAGE).intValue() << 3;
		return var3;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { VARIANT, STAGE });
	}

}
