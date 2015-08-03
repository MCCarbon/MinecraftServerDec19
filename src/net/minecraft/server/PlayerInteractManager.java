package net.minecraft.server;


public class PlayerInteractManager {

	public World world;
	public EntityPlayer player;
	private WorldSettings.EnumGameMode gamemode;
	private boolean d;
	private int lastDigTick;
	private BlockPosition f;
	private int currentTick;
	private boolean h;
	private BlockPosition i;
	private int j;
	private int k;

	public PlayerInteractManager(World var1) {
		gamemode = WorldSettings.EnumGameMode.NOT_SET;
		f = BlockPosition.ZERO;
		i = BlockPosition.ZERO;
		k = -1;
		world = var1;
	}

	public void setGameMode(WorldSettings.EnumGameMode var1) {
		gamemode = var1;
		var1.setAbilities(player.abilities);
		player.t();
		player.b.getPlayerList().a((new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.class_a_in_class_gz.b, new EntityPlayer[] { player })));
	}

	public WorldSettings.EnumGameMode getGameMode() {
		return gamemode;
	}

	public boolean c() {
		return gamemode.isSurvivalOrAdventure();
	}

	public boolean d() {
		return gamemode.isCreative();
	}

	public void b(WorldSettings.EnumGameMode var1) {
		if (gamemode == WorldSettings.EnumGameMode.NOT_SET) {
			gamemode = var1;
		}

		this.setGameMode(gamemode);
	}

	public void a() {
		++currentTick;
		float var3;
		int var4;
		if (h) {
			int var1 = currentTick - j;
			Block var2 = world.getType(i).getBlock();
			if (var2.getMaterial() == Material.AIR) {
				h = false;
			} else {
				var3 = var2.getDamage(player, player.o, i) * (var1 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != k) {
					world.c(player.getId(), i, var4);
					k = var4;
				}

				if (var3 >= 1.0F) {
					h = false;
					breakBlock(i);
				}
			}
		} else if (d) {
			Block var5 = world.getType(f).getBlock();
			if (var5.getMaterial() == Material.AIR) {
				world.c(player.getId(), f, -1);
				k = -1;
				d = false;
			} else {
				int var6 = currentTick - lastDigTick;
				var3 = var5.getDamage(player, player.o, i) * (var6 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != k) {
					world.c(player.getId(), f, var4);
					k = var4;
				}
			}
		}

	}

	public void a(BlockPosition var1, EnumDirection var2) {
		if (d()) {
			if (!world.a((EntityHuman) null, var1, var2)) {
				breakBlock(var1);
			}

		} else {
			Block var3 = world.getType(var1).getBlock();
			if (gamemode.isAdventureOrSpectator()) {
				if (gamemode == WorldSettings.EnumGameMode.SPECTATOR) {
					return;
				}

				if (!player.cp()) {
					ItemStack var4 = player.bA();
					if (var4 == null) {
						return;
					}

					if (!var4.c(var3)) {
						return;
					}
				}
			}

			world.a((EntityHuman) null, var1, var2);
			lastDigTick = currentTick;
			float var6 = 1.0F;
			if (var3.getMaterial() != Material.AIR) {
				var3.attack(world, var1, player);
				var6 = var3.getDamage(player, player.o, var1);
			}

			if ((var3.getMaterial() != Material.AIR) && (var6 >= 1.0F)) {
				breakBlock(var1);
			} else {
				d = true;
				f = var1;
				int var5 = (int) (var6 * 10.0F);
				world.c(player.getId(), var1, var5);
				k = var5;
			}

		}
	}

	public void a(BlockPosition var1) {
		if (var1.equals(f)) {
			int var2 = currentTick - lastDigTick;
			Block var3 = world.getType(var1).getBlock();
			if (var3.getMaterial() != Material.AIR) {
				float var4 = var3.getDamage(player, player.o, var1) * (var2 + 1);
				if (var4 >= 0.7F) {
					d = false;
					world.c(player.getId(), var1, -1);
					breakBlock(var1);
				} else if (!h) {
					d = false;
					h = true;
					i = var1;
					j = lastDigTick;
				}
			}
		}

	}

	public void e() {
		d = false;
		world.c(player.getId(), f, -1);
	}

	private boolean c(BlockPosition var1) {
		IBlockData var2 = world.getType(var1);
		var2.getBlock().a(world, var1, var2, player);
		boolean var3 = world.setAir(var1);
		if (var3) {
			var2.getBlock().postBreak(world, var1, var2);
		}

		return var3;
	}

	public boolean breakBlock(BlockPosition var1) {
		if (gamemode.isCreative() && (player.bA() != null) && (player.bA().getItem() instanceof class_abw)) {
			return false;
		} else {
			IBlockData var2 = world.getType(var1);
			TileEntity var3 = world.getTileEntity(var1);
			if (gamemode.isAdventureOrSpectator()) {
				if (gamemode == WorldSettings.EnumGameMode.SPECTATOR) {
					return false;
				}

				if (!player.cp()) {
					ItemStack var4 = player.bA();
					if (var4 == null) {
						return false;
					}

					if (!var4.c(var2.getBlock())) {
						return false;
					}
				}
			}

			world.a(player, 2001, var1, Block.getCombinedId(var2));
			boolean var8 = this.c(var1);
			if (d()) {
				player.playerConnection.sendPacket((new PacketPlayOutBlockChange(world, var1)));
			} else {
				ItemStack var5 = player.bA();
				ItemStack var6 = var5 == null ? null : var5.clone();
				boolean var7 = player.b(var2.getBlock());
				if (var5 != null) {
					var5.a(world, var2.getBlock(), var1, player);
					if (var5.count == 0) {
						player.a(EnumUsedHand.MAIN_HAND, (ItemStack) null);
					}
				}

				if (var8 && var7) {
					var2.getBlock().breakBlockNaturally(world, player, var1, var2, var3, var6);
				}
			}

			return var8;
		}
	}

	public UseResult useItem(EntityHuman var1, World var2, ItemStack var3, EnumUsedHand var4) {
		if (gamemode == WorldSettings.EnumGameMode.SPECTATOR) {
			return UseResult.CANT_USE;
		} else {
			int var5 = var3.count;
			int var6 = var3.i();
			class_or var7 = var3.a(var2, var1, var4);
			ItemStack var8 = (ItemStack) var7.b();
			if ((var8 != var3) || (var8.count != var5) || (var8.l() > 0) || (var8.i() != var6)) {
				var1.a(var4, var8);
				if (d()) {
					var8.count = var5;
					if (var8.e()) {
						var8.setData(var6);
					}
				}

				if (var8.count == 0) {
					var1.a(var4, (ItemStack) null);
				}

				if (!var1.bS()) {
					((EntityPlayer) var1).a(var1.bq);
				}
			}

			return var7.a();
		}
	}

	public UseResult interact(EntityHuman var1, World var2, ItemStack var3, EnumUsedHand var4, BlockPosition var5, EnumDirection var6, float var7, float var8, float var9) {
		if (gamemode == WorldSettings.EnumGameMode.SPECTATOR) {
			TileEntity var14 = var2.getTileEntity(var5);
			if (var14 instanceof ITileInventory) {
				Block var15 = var2.getType(var5).getBlock();
				ITileInventory var16 = (ITileInventory) var14;
				if ((var16 instanceof TileEntityChest) && (var15 instanceof BlockChest)) {
					var16 = ((BlockChest) var15).f(var2, var5);
				}

				if (var16 != null) {
					var1.openContainer(var16);
					return UseResult.SUCCESS;
				}
			} else if (var14 instanceof IInventory) {
				var1.openContainer((IInventory) var14);
				return UseResult.SUCCESS;
			}

			return UseResult.CANT_USE;
		} else {
			if (!var1.ax() || (var1.bA() == null)) {
				IBlockData var10 = var2.getType(var5);
				if (var10.getBlock().interact(var2, var5, var10, var1, var4, var3, var6, var7, var8, var9)) {
					return UseResult.SUCCESS;
				}
			}

			if (var3 == null) {
				return UseResult.CANT_USE;
			} else if (d()) {
				int var13 = var3.i();
				int var11 = var3.count;
				UseResult var12 = var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
				var3.setData(var13);
				var3.count = var11;
				return var12;
			} else {
				return var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
			}
		}
	}

	public void a(WorldServer var1) {
		world = var1;
	}
}
