package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Explosion {

	private final Random random = new Random();
	private final boolean a;
	private final boolean b;
	private final World world;
	private final double x;
	private final double y;
	private final double z;
	private final Entity source;
	private final float size;
	private final List<BlockPosition> blocks = Lists.newArrayList();
	private final Map<EntityHuman, Vec3D> affectedPlayers = Maps.newHashMap();

	public Explosion(World var1, Entity var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11) {
		this.world = var1;
		this.source = var2;
		this.size = var9;
		this.x = var3;
		this.y = var5;
		this.z = var7;
		this.a = var10;
		this.b = var11;
	}

	public void doStage1() {
		HashSet<BlockPosition> var1 = Sets.newHashSet();

		int var4;
		int var5;
		for (int var3 = 0; var3 < 16; ++var3) {
			for (var4 = 0; var4 < 16; ++var4) {
				for (var5 = 0; var5 < 16; ++var5) {
					if (var3 == 0 || var3 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15) {
						double var6 = (double) ((float) var3 / 15.0F * 2.0F - 1.0F);
						double var8 = (double) ((float) var4 / 15.0F * 2.0F - 1.0F);
						double var10 = (double) ((float) var5 / 15.0F * 2.0F - 1.0F);
						double var12 = Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
						var6 /= var12;
						var8 /= var12;
						var10 /= var12;
						float var14 = this.size * (0.7F + this.world.random.nextFloat() * 0.6F);
						double var15 = this.x;
						double var17 = this.y;
						double var19 = this.z;

						for (; var14 > 0.0F; var14 -= 0.22500001F) {
							BlockPosition var22 = new BlockPosition(var15, var17, var19);
							IBlockData var23 = this.world.getType(var22);
							if (var23.getBlock().getMaterial() != Material.AIR) {
								float var24 = this.source != null ? this.source.a(this, this.world, var22, var23) : var23.getBlock().getResistance((Entity) null);
								var14 -= (var24 + 0.3F) * 0.3F;
							}

							if (var14 > 0.0F && (this.source == null || this.source.a(this, this.world, var22, var23, var14))) {
								var1.add(var22);
							}

							var15 += var6 * 0.30000001192092896D;
							var17 += var8 * 0.30000001192092896D;
							var19 += var10 * 0.30000001192092896D;
						}
					}
				}
			}
		}

		this.blocks.addAll(var1);
		float var30 = this.size * 2.0F;
		var4 = MathHelper.floor(this.x - (double) var30 - 1.0D);
		var5 = MathHelper.floor(this.x + (double) var30 + 1.0D);
		int var31 = MathHelper.floor(this.y - (double) var30 - 1.0D);
		int var7 = MathHelper.floor(this.y + (double) var30 + 1.0D);
		int var32 = MathHelper.floor(this.z - (double) var30 - 1.0D);
		int var9 = MathHelper.floor(this.z + (double) var30 + 1.0D);
		List<?> var33 = this.world.getEntities(this.source, new AxisAlignedBB((double) var4, (double) var31, (double) var32, (double) var5, (double) var7, (double) var9));
		Vec3D var11 = new Vec3D(this.x, this.y, this.z);

		for (int var34 = 0; var34 < var33.size(); ++var34) {
			Entity var13 = (Entity) var33.get(var34);
			if (!var13.aX()) {
				double var35 = var13.f(this.x, this.y, this.z) / (double) var30;
				if (var35 <= 1.0D) {
					double var16 = var13.s - this.x;
					double var18 = var13.t + (double) var13.aU() - this.y;
					double var20 = var13.u - this.z;
					double var36 = (double) MathHelper.sqrt(var16 * var16 + var18 * var18 + var20 * var20);
					if (var36 != 0.0D) {
						var16 /= var36;
						var18 /= var36;
						var20 /= var36;
						double var37 = (double) this.world.a(var11, var13.aT());
						double var26 = (1.0D - var35) * var37;
						var13.damageEntity(DamageSource.a(this), (float) ((int) ((var26 * var26 + var26) / 2.0D * 8.0D * (double) var30 + 1.0D)));
						double var28 = 1.0D;
						if (var13 instanceof EntityLiving) {
							var28 = class_ads.a((EntityLiving) var13, var26);
						}

						var13.v += var16 * var28;
						var13.motY += var18 * var28;
						var13.x += var20 * var28;
						if (var13 instanceof EntityHuman && !((EntityHuman) var13).abilities.invulnerable) {
							this.affectedPlayers.put((EntityHuman) var13, new Vec3D(var16 * var26, var18 * var26, var20 * var26));
						}
					}
				}
			}
		}

	}

	public void doStage2(boolean var1) {
		this.world.a(this.x, this.y, this.z, "random.explode", 4.0F, (1.0F + (this.world.random.nextFloat() - this.world.random.nextFloat()) * 0.2F) * 0.7F);
		if (this.size >= 2.0F && this.b) {
			this.world.a(class_cy.c, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D, new int[0]);
		} else {
			this.world.a(class_cy.b, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D, new int[0]);
		}

		Iterator<BlockPosition> var2;
		BlockPosition var3;
		if (this.b) {
			var2 = this.blocks.iterator();

			while (var2.hasNext()) {
				var3 = (BlockPosition) var2.next();
				Block var4 = this.world.getType(var3).getBlock();
				if (var1) {
					double var5 = (double) ((float) var3.getX() + this.world.random.nextFloat());
					double var7 = (double) ((float) var3.getY() + this.world.random.nextFloat());
					double var9 = (double) ((float) var3.getZ() + this.world.random.nextFloat());
					double var11 = var5 - this.x;
					double var13 = var7 - this.y;
					double var15 = var9 - this.z;
					double var17 = (double) MathHelper.sqrt(var11 * var11 + var13 * var13 + var15 * var15);
					var11 /= var17;
					var13 /= var17;
					var15 /= var17;
					double var19 = 0.5D / (var17 / (double) this.size + 0.1D);
					var19 *= (double) (this.world.random.nextFloat() * this.world.random.nextFloat() + 0.3F);
					var11 *= var19;
					var13 *= var19;
					var15 *= var19;
					this.world.a(class_cy.a, (var5 + this.x * 1.0D) / 2.0D, (var7 + this.y * 1.0D) / 2.0D, (var9 + this.z * 1.0D) / 2.0D, var11, var13, var15, new int[0]);
					this.world.a(class_cy.l, var5, var7, var9, var11, var13, var15, new int[0]);
				}

				if (var4.getMaterial() != Material.AIR) {
					if (var4.dropsFromExplosion(this)) {
						var4.dropNaturally(this.world, var3, this.world.getType(var3), 1.0F / this.size, 0);
					}

					this.world.setTypeAndData((BlockPosition) var3, (IBlockData) Blocks.AIR.getBlockData(), 3);
					var4.wasExploded(this.world, var3, this);
				}
			}
		}

		if (this.a) {
			var2 = this.blocks.iterator();

			while (var2.hasNext()) {
				var3 = (BlockPosition) var2.next();
				if (this.world.getType(var3).getBlock().getMaterial() == Material.AIR && this.world.getType(var3.down()).getBlock().isFullBlock() && this.random.nextInt(3) == 0) {
					this.world.setTypeUpdate(var3, Blocks.FIRE.getBlockData());
				}
			}
		}

	}

	public Map<EntityHuman, Vec3D> getAffectedPlayers() {
		return this.affectedPlayers;
	}

	public EntityLiving getSource() {
		return this.source == null ? null : (this.source instanceof EntityTNTPrimed ? ((EntityTNTPrimed) this.source).getSource() : (this.source instanceof EntityLiving ? (EntityLiving) this.source : null));
	}

	public void clearBlocks() {
		this.blocks.clear();
	}

	public List<BlockPosition> getBlocks() {
		return this.blocks;
	}

}
