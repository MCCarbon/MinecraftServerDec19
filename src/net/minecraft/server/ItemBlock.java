package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class ItemBlock extends Item {

	protected final Block block;

	public ItemBlock(Block block) {
		this.block = block;
	}

	public ItemBlock b(String var1) {
		super.c(var1);
		return this;
	}

	public class_oq a(ItemStack var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		IBlockData var10 = var3.p(var4);
		Block var11 = var10.getBlock();
		if (!var11.isReplaceable(var3, var4)) {
			var4 = var4.shift(var6);
		}

		if (var1.count == 0) {
			return class_oq.b;
		} else if (!var2.a(var4, var6, var1)) {
			return class_oq.b;
		} else if (var3.a(this.block, var4, false, var6, (class_pr) null, var1)) {
			int var12 = this.a(var1.i());
			IBlockData var13 = this.block.a(var3, var4, var6, var7, var8, var9, var12, var2);
			if (var3.a((BlockPosition) var4, (IBlockData) var13, 3)) {
				var13 = var3.p(var4);
				if (var13.getBlock() == this.block) {
					a(var3, var2, var4, var1);
					this.block.a(var3, var4, var13, var2, var1);
				}

				var3.a((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), this.block.stepSound.b(), (this.block.stepSound.d() + 1.0F) / 2.0F, this.block.stepSound.e() * 0.8F);
				--var1.count;
			}

			return class_oq.a;
		} else {
			return class_oq.b;
		}
	}

	public static boolean a(World var0, class_xa var1, BlockPosition var2, ItemStack var3) {
		MinecraftServer var4 = MinecraftServer.N();
		if (var4 == null) {
			return false;
		} else {
			if (var3.hasTag() && var3.getTag().hasOfType("BlockEntityTag", 10)) {
				class_amg var5 = var0.s(var2);
				if (var5 != null) {
					if (!var0.D && var5.F() && !var4.getPlayerList().h(var1.cf())) {
						return false;
					}

					NBTTagCompound var6 = new NBTTagCompound();
					NBTTagCompound var7 = (NBTTagCompound) var6.clone();
					var5.b(var6);
					NBTTagCompound var8 = (NBTTagCompound) var3.getTag().getTag("BlockEntityTag");
					var6.copyFrom(var8);
					var6.put("x", var2.getX());
					var6.put("y", var2.getY());
					var6.put("z", var2.getZ());
					if (!var6.equals(var7)) {
						var5.a(var6);
						var5.p_();
						return true;
					}
				}
			}

			return false;
		}
	}

	public String e_(ItemStack var1) {
		return this.block.getInternalName();
	}

	public String a() {
		return this.block.getInternalName();
	}

	public Block getBlock() {
		return this.block;
	}

	// $FF: synthetic method
	public Item c(String var1) {
		return this.b(var1);
	}
}
