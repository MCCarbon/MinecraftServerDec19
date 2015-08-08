package net.minecraft.server;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public class BlockNote extends BlockContainer {

	private static final ArrayList<String> note = Lists.newArrayList((new String[] { "harp", "bd", "snare", "hat", "bassattack" }));

	public BlockNote() {
		super(Material.WOOD);
		setCreativeTab(CreativeTab.REDSTONE);
	}

	@Override
	public void doPhysics(World world, BlockPosition position, IBlockData blockdata, Block block) {
		boolean blockIndirectlyPowered = world.isBlockIndirectlyPowered(position);
		TileEntity var6 = world.getTileEntity(position);
		if (var6 instanceof TileEntityNote) {
			TileEntityNote tileentity = (TileEntityNote) var6;
			if (tileentity.f != blockIndirectlyPowered) {
				if (blockIndirectlyPowered) {
					tileentity.play(world, position);
				}

				tileentity.f = blockIndirectlyPowered;
			}
		}

	}

	@Override
	public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
		if (var1.isClientSide) {
			return true;
		} else {
			TileEntity var11 = var1.getTileEntity(var2);
			if (var11 instanceof TileEntityNote) {
				TileEntityNote var12 = (TileEntityNote) var11;
				var12.b();
				var12.play(var1, var2);
				var4.b(StatisticList.S);
			}

			return true;
		}
	}

	@Override
	public void attack(World var1, BlockPosition var2, EntityHuman var3) {
		if (!var1.isClientSide) {
			TileEntity var4 = var1.getTileEntity(var2);
			if (var4 instanceof TileEntityNote) {
				((TileEntityNote) var4).play(var1, var2);
				var3.b(StatisticList.R);
			}

		}
	}

	@Override
	public TileEntity createTileEntity(World var1, int var2) {
		return new TileEntityNote();
	}

	private String getNoteByName(int id) {
		if ((id < 0) || (id >= note.size())) {
			id = 0;
		}

		return note.get(id);
	}

	@Override
	public boolean a(World var1, BlockPosition var2, IBlockData var3, int var4, int var5) {
		float var6 = (float) Math.pow(2.0D, (var5 - 12) / 12.0D);
		var1.makeSound(var2.getX() + 0.5D, var2.getY() + 0.5D, var2.getZ() + 0.5D, "note." + getNoteByName(var4), 3.0F, var6);
		var1.addParticle(EnumParticle.x, var2.getX() + 0.5D, var2.getY() + 1.2D, var2.getZ() + 0.5D, var5 / 24.0D, 0.0D, 0.0D, new int[0]);
		return true;
	}

	@Override
	public int getRenderType() {
		return 3;
	}

}
