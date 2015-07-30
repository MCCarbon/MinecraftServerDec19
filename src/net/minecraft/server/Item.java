package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import net.minecraft.server.class_aaa;
import net.minecraft.server.class_aab;
import net.minecraft.server.class_aac;
import net.minecraft.server.class_aad;
import net.minecraft.server.class_aae;
import net.minecraft.server.class_aaf;
import net.minecraft.server.class_aag;
import net.minecraft.server.class_aah;
import net.minecraft.server.class_aai;
import net.minecraft.server.class_aaj;
import net.minecraft.server.class_aak;
import net.minecraft.server.class_aal;
import net.minecraft.server.class_aam;
import net.minecraft.server.class_aan;
import net.minecraft.server.class_aao;
import net.minecraft.server.class_aap;
import net.minecraft.server.class_aaq;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aat;
import net.minecraft.server.Items;
import net.minecraft.server.class_aav;
import net.minecraft.server.class_aaw;
import net.minecraft.server.class_aax;
import net.minecraft.server.class_aay;
import net.minecraft.server.class_aaz;
import net.minecraft.server.class_aba;
import net.minecraft.server.class_abb;
import net.minecraft.server.class_abc;
import net.minecraft.server.class_abd;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_abf;
import net.minecraft.server.class_abg;
import net.minecraft.server.class_abh;
import net.minecraft.server.class_abi;
import net.minecraft.server.class_abj;
import net.minecraft.server.class_abk;
import net.minecraft.server.class_abl;
import net.minecraft.server.class_abm;
import net.minecraft.server.class_abn;
import net.minecraft.server.class_abo;
import net.minecraft.server.class_abp;
import net.minecraft.server.class_abq;
import net.minecraft.server.class_abr;
import net.minecraft.server.class_abs;
import net.minecraft.server.class_abt;
import net.minecraft.server.class_abu;
import net.minecraft.server.class_abv;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_abx;
import net.minecraft.server.class_aby;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_aca;
import net.minecraft.server.class_acb;
import net.minecraft.server.class_acc;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_ajh;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_akc;
import net.minecraft.server.class_aki;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_akr;
import net.minecraft.server.BlockStone;
import net.minecraft.server.class_ali;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.RegistryMaterials;
import net.minecraft.server.IRegistry;
import net.minecraft.server.RegistrySimple;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_dn;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_va;
import net.minecraft.server.class_vc;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yz;
import net.minecraft.server.class_za;
import net.minecraft.server.class_zb;
import net.minecraft.server.class_zc;
import net.minecraft.server.class_zd;
import net.minecraft.server.class_ze;
import net.minecraft.server.class_zf;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.class_zh;
import net.minecraft.server.class_zi;
import net.minecraft.server.class_zj;
import net.minecraft.server.class_zk;
import net.minecraft.server.class_zl;
import net.minecraft.server.class_zm;
import net.minecraft.server.class_zn;
import net.minecraft.server.class_zo;
import net.minecraft.server.class_zp;
import net.minecraft.server.class_zq;
import net.minecraft.server.class_zr;
import net.minecraft.server.class_zs;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zw;
import net.minecraft.server.class_zx;
import net.minecraft.server.class_zz;

public class Item {

	public static final RegistryMaterials<MinecraftKey, Item> ITEM_REGISTRY = new RegistryMaterials<MinecraftKey, Item>();
	private static final Map<Block, Item> BLOCK_TO_ITEM = Maps.newHashMap();
	private static final class_aat b = new class_aat() {
	};
	private static final class_aat c = new class_aat() {
	};
	private static final class_aat d = new class_aat() {
	};
	private IRegistry<MinecraftKey, class_aat> k = new RegistrySimple<MinecraftKey, class_aat>();
	protected static final UUID uuid = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	protected static Random random = new Random();

	protected int h = 64;
	private int m;
	protected boolean i;
	protected boolean j;
	private Item n;
	private String o;

	public static int getId(Item item) {
		return item == null ? 0 : ITEM_REGISTRY.getId(item);
	}

	public static Item getById(int id) {
		return ITEM_REGISTRY.get(id);
	}

	public static Item getByBlock(Block block) {
		return BLOCK_TO_ITEM.get(block);
	}

	public static Item getByName(String string) {
		Item item = ITEM_REGISTRY.get(new MinecraftKey(string));
		if (item == null) {
			try {
				return getById(Integer.parseInt(string));
			} catch (NumberFormatException var3) {
			}
		}
		return item;
	}

	public final void a(MinecraftKey var1, class_aat var2) {
		this.k.register(var1, var2);
	}

	public boolean a(class_dn var1) {
		return false;
	}

	public Item() {
		this.a(new MinecraftKey("lefthanded"), d);
	}

	public Item d(int var1) {
		this.h = var1;
		return this;
	}

	public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		return class_oq.b;
	}

	public float a(class_aas var1, Block var2) {
		return 1.0F;
	}

	public class_or a(class_aas var1, World var2, class_xa var3, EnumUsedHand var4) {
		return new class_or(class_oq.b, var1);
	}

	public class_aas a(class_aas var1, World var2, class_qa var3) {
		return var1;
	}

	public int j() {
		return this.h;
	}

	public int a(int var1) {
		return 0;
	}

	public boolean k() {
		return this.j;
	}

	protected Item a(boolean var1) {
		this.j = var1;
		return this;
	}

	public int l() {
		return this.m;
	}

	protected Item e(int var1) {
		this.m = var1;
		if (var1 > 0) {
			this.a(new MinecraftKey("damaged"), b);
			this.a(new MinecraftKey("damage"), c);
		}

		return this;
	}

	public boolean m() {
		return this.m > 0 && !this.j;
	}

	public boolean a(class_aas var1, class_qa var2, class_qa var3) {
		return false;
	}

	public boolean a(class_aas var1, World var2, Block var3, BlockPosition var4, class_qa var5) {
		return false;
	}

	public boolean b(Block var1) {
		return false;
	}

	public boolean a(class_aas var1, class_xa var2, class_qa var3, EnumUsedHand var4) {
		return false;
	}

	public Item n() {
		this.i = true;
		return this;
	}

	public Item c(String var1) {
		this.o = var1;
		return this;
	}

	public String j(class_aas var1) {
		String var2 = this.e_(var1);
		return var2 == null ? "" : LocaleI18n.get(var2);
	}

	public String a() {
		return "item." + this.o;
	}

	public String e_(class_aas var1) {
		return "item." + this.o;
	}

	public Item c(Item var1) {
		this.n = var1;
		return this;
	}

	public boolean p() {
		return true;
	}

	public Item q() {
		return this.n;
	}

	public boolean r() {
		return this.n != null;
	}

	public void a(class_aas var1, World var2, class_pr var3, int var4, boolean var5) {
	}

	public void b(class_aas var1, World var2, class_xa var3) {
	}

	public boolean f() {
		return false;
	}

	public class_abz f(class_aas var1) {
		return class_abz.a;
	}

	public int e(class_aas var1) {
		return 0;
	}

	public void a(class_aas var1, World var2, class_qa var3, int var4) {
	}

	public String a(class_aas var1) {
		return ("" + LocaleI18n.get(this.j(var1) + ".name")).trim();
	}

	public class_abf g(class_aas var1) {
		return var1.w() ? class_abf.c : class_abf.a;
	}

	public boolean f_(class_aas var1) {
		return this.j() == 1 && this.m();
	}

	protected class_awg a(World var1, class_xa var2, boolean var3) {
		float var4 = var2.z;
		float var5 = var2.y;
		double var6 = var2.s;
		double var8 = var2.t + (double) var2.aU();
		double var10 = var2.u;
		Vec3D var12 = new Vec3D(var6, var8, var10);
		float var13 = MathHelper.cos(-var5 * 0.017453292F - 3.1415927F);
		float var14 = MathHelper.sin(-var5 * 0.017453292F - 3.1415927F);
		float var15 = -MathHelper.cos(-var4 * 0.017453292F);
		float var16 = MathHelper.sin(-var4 * 0.017453292F);
		float var17 = var14 * var15;
		float var19 = var13 * var15;
		double var20 = 5.0D;
		Vec3D var22 = var12.add((double) var17 * var20, (double) var16 * var20, (double) var19 * var20);
		return var1.a(var12, var22, var3, !var3, false);
	}

	public int c() {
		return 0;
	}

	public Item a(CreativeTab var1) {
		return this;
	}

	public boolean s() {
		return false;
	}

	public boolean a(class_aas var1, class_aas var2) {
		return false;
	}

	public Multimap<?, ?> a(class_pw var1) {
		return HashMultimap.create();
	}

	public static void init() {
		register((Block) Blocks.STONE, (Item) (new class_aba(Blocks.STONE, Blocks.STONE, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return BlockStone.EnumStoneVariant.getByData(var1.i()).getILocaleName();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("stone"));
		register((Block) Blocks.GRASS, (Item) (new class_abx(Blocks.GRASS, false)));
		register((Block) Blocks.DIRT, (Item) (new class_aba(Blocks.DIRT, Blocks.DIRT, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ahj.class_a_in_class_ahj.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("dirt"));
		register(Blocks.COBBLESTONE);
		register((Block) Blocks.PLANKS, (Item) (new class_aba(Blocks.PLANKS, Blocks.PLANKS, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ajw.class_a_in_class_ajw.a(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("wood"));
		register((Block) Blocks.SAPLING, (Item) (new class_aba(Blocks.SAPLING, Blocks.SAPLING, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ajw.class_a_in_class_ajw.a(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("sapling"));
		register(Blocks.BEDROCK);
		register((Block) Blocks.SAND, (Item) (new class_aba(Blocks.SAND, Blocks.SAND, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_akq.class_a_in_class_akq.a(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("sand"));
		register(Blocks.GRAVEL);
		register(Blocks.GOLD_ORE);
		register(Blocks.IRON_ORE);
		register(Blocks.COAL_ORE);
		register((Block) Blocks.LOG, (Item) (new class_aba(Blocks.LOG, Blocks.LOG, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ajw.class_a_in_class_ajw.a(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("log"));
		register((Block) Blocks.LOG2, (Item) (new class_aba(Blocks.LOG2, Blocks.LOG2, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ajw.class_a_in_class_ajw.a(var1.i() + 4).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("log"));
		register((Block) Blocks.LEAVES, (Item) (new class_aaw(Blocks.LEAVES)).b("leaves"));
		register((Block) Blocks.LEAVES2, (Item) (new class_aaw(Blocks.LEAVES2)).b("leaves"));
		register((Block) Blocks.SPONGE, (Item) (new class_aba(Blocks.SPONGE, Blocks.SPONGE, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return (var1.i() & 1) == 1 ? "wet" : "dry";
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("sponge"));
		register(Blocks.GLASS);
		register(Blocks.LAPIS_ORE);
		register(Blocks.LAPIS_BLOCK);
		register(Blocks.DISPENSER);
		register((Block) Blocks.SANDSTONE, (Item) (new class_aba(Blocks.SANDSTONE, Blocks.SANDSTONE, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_akr.class_a_in_class_akr.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("sandStone"));
		register(Blocks.NOTEBLOCK);
		register(Blocks.GOLDEN_RAIL);
		register(Blocks.DETECTOR_RAIL);
		register((Block) Blocks.STICKY_PISTON, (Item) (new class_abd(Blocks.STICKY_PISTON)));
		register(Blocks.WEB);
		register((Block) Blocks.TALLGRASS, (Item) (new class_abx(Blocks.TALLGRASS, true)).a(new String[] { "shrub", "grass", "fern" }));
		register((Block) Blocks.DEADBUSH);
		register((Block) Blocks.PISTON, (Item) (new class_abd(Blocks.PISTON)));
		register((Block) Blocks.WOOL, (Item) (new class_aaa(Blocks.WOOL)).b("cloth"));
		register((Block) Blocks.YELLOW_FLOWER, (Item) (new class_aba(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_aic.class_a_in_class_aic.a(class_aic.class_b_in_class_aic.a, var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("flower"));
		register((Block) Blocks.RED_FLOWER, (Item) (new class_aba(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_aic.class_a_in_class_aic.a(class_aic.class_b_in_class_aic.b, var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("rose"));
		register((Block) Blocks.BROWN_MUSHROOM);
		register((Block) Blocks.RED_MUSHROOM);
		register(Blocks.GOLD_BLOCK);
		register(Blocks.IRON_BLOCK);
		register((Block) Blocks.STONE_SLAB, (Item) (new class_abq(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_SANDSTONE_SLAB)).b("stoneSlab"));
		register(Blocks.BRICK_BLOCK);
		register(Blocks.TNT);
		register(Blocks.BOOKSHELF);
		register(Blocks.MOSSY_COBBLESTONE);
		register(Blocks.OBSIDIAN);
		register(Blocks.TORCH);
		register(Blocks.END_ROD);
		register(Blocks.CHORUS_PLANT);
		register(Blocks.CHORUS_FLOWER);
		register(Blocks.PURPUR_BLOCK);
		register(Blocks.PURPUR_PILLAR);
		register(Blocks.PURPUR_STAIRS);
		register((Block) Blocks.PURPUR_SLAB, (Item) (new class_abq(Blocks.PURPUR_SLAB, Blocks.PURPUR_SLAB, Blocks.PURPUR_DOUBLE_SLAB)).b("purpurSlab"));
		register(Blocks.MOB_SPAWNER);
		register(Blocks.OAK_STAIRS);
		register((Block) Blocks.CHEST);
		register(Blocks.DIAMOND_ORE);
		register(Blocks.DIAMOND_BLOCK);
		register(Blocks.CRAFTING_TABLE);
		register(Blocks.FARMLAND);
		register(Blocks.FURNACE);
		register(Blocks.LIT_FURNACE);
		register(Blocks.LADDER);
		register(Blocks.RAIL);
		register(Blocks.STONE_STAIRS);
		register(Blocks.LEVER);
		register(Blocks.STONE_PRESSURE_PLATE);
		register(Blocks.WOODEN_PRESSURE_PLATE);
		register(Blocks.REDSTONE_ORE);
		register(Blocks.REDSTONE_TORCH);
		register(Blocks.STONE_BUTTON);
		register((Block) Blocks.SNOW_LAYER, (Item) (new class_abr(Blocks.SNOW_LAYER)));
		register(Blocks.ICE);
		register(Blocks.SNOW);
		register((Block) Blocks.CACTUS);
		register(Blocks.CLAY);
		register(Blocks.JUKEBOX);
		register(Blocks.FENCE);
		register(Blocks.SPRUCE_FENCE);
		register(Blocks.BIRCH_FENCE);
		register(Blocks.JUNGLE_FENCE);
		register(Blocks.DARK_OAK_FENCE);
		register(Blocks.ACACIA_FENCE);
		register(Blocks.PUMPKIN);
		register(Blocks.NETHERRACK);
		register(Blocks.SOUL_SAND);
		register(Blocks.GLOWSTONE);
		register(Blocks.LIT_PUMPKIN);
		register(Blocks.TRAPDOOR);
		register((Block) Blocks.MONSTER_EGG, (Item) (new class_aba(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ajh.class_a_in_class_ajh.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("monsterStoneEgg"));
		register((Block) Blocks.STONEBRICK, (Item) (new class_aba(Blocks.STONEBRICK, Blocks.STONEBRICK, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ali.class_a_in_class_ali.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("stonebricksmooth"));
		register(Blocks.BROWN_MUSHROOM_BLOCK);
		register(Blocks.RED_MUSHROOM_BLOCK);
		register(Blocks.IRON_BARS);
		register(Blocks.GLASS_PANE);
		register(Blocks.MELON_BLOCK);
		register((Block) Blocks.VINE, (Item) (new class_abx(Blocks.VINE, false)));
		register(Blocks.FENCE_GATE);
		register(Blocks.SPRUCE_FENCE_GATE);
		register(Blocks.BIRCH_FENCE_GATE);
		register(Blocks.JUGLE_FENCE_GATE);
		register(Blocks.DARK_OAK_FENCE_GATE);
		register(Blocks.ACACIA_FENCE_GATE);
		register(Blocks.BRICK_STAIRS);
		register(Blocks.STONE_BRICK_STAIRS);
		register((Block) Blocks.MYCELIM);
		register((Block) Blocks.WATERLILY, (Item) (new class_aca(Blocks.WATERLILY)));
		register(Blocks.NETHER_BRICK);
		register(Blocks.NETHER_BRICK_FENCE);
		register(Blocks.NETHER_BTICK_STAIRS);
		register(Blocks.ENCHANTING_TABLE);
		register(Blocks.END_PORTAL_FRAME);
		register(Blocks.END_STONE);
		register(Blocks.END_BRICKS);
		register(Blocks.DRAGON_EGG);
		register(Blocks.REDSTONE_LAMP);
		register((Block) Blocks.WOODEN_SLAB, (Item) (new class_abq(Blocks.WOODEN_SLAB, Blocks.WOODEN_SLAB, Blocks.DOUBLE_WOODEN_SLAB)).b("woodSlab"));
		register(Blocks.SANDSTONE_STAIRS);
		register(Blocks.EMERALD_ORE);
		register(Blocks.ENDER_CHEST);
		register((Block) Blocks.TRIPWIRE_HOOK);
		register(Blocks.EMERALD_BLOCK);
		register(Blocks.SPRUCE_STAIRS);
		register(Blocks.BIRCH_STAIRS);
		register(Blocks.JUNGKE_STAIRS);
		register(Blocks.COMMAND_BLOCK);
		register((Block) Blocks.BEACON);
		register((Block) Blocks.COBBLESTONE_WALL, (Item) (new class_aba(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_alv.class_a_in_class_alv.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("cobbleWall"));
		register(Blocks.WOODEN_BUTTON);
		register((Block) Blocks.ANVIL, (Item) (new class_yz(Blocks.ANVIL)).b("anvil"));
		register(Blocks.TRAPPED_CHEST);
		register(Blocks.LIGHT_W_PRESSURE_PLATE);
		register(Blocks.HEAVY_W_PRESSURE_PLATE);
		register((Block) Blocks.DAYLIGHT_DETECTOR);
		register(Blocks.REDSTONE_BLOCK);
		register(Blocks.QUARTZ_ORE);
		register((Block) Blocks.HOPPER);
		register((Block) Blocks.QUARTZ_BLOCK, (Item) (new class_aba(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK, new String[] { "default", "chiseled", "lines" })).b("quartzBlock"));
		register(Blocks.QUARTZ_STAIRS);
		register(Blocks.ACTIVATOR_RAIL);
		register(Blocks.DROPPER);
		register((Block) Blocks.STAINED_HARDENED_CLAY, (Item) (new class_aaa(Blocks.STAINED_HARDENED_CLAY)).b("clayHardenedStained"));
		register(Blocks.BARRIER);
		register(Blocks.IRON_TRAPDOOR);
		register(Blocks.HAY_BLOCK);
		register((Block) Blocks.CARPET, (Item) (new class_aaa(Blocks.CARPET)).b("woolCarpet"));
		register(Blocks.HARDENED_CLAY);
		register(Blocks.COAL_BLOCK);
		register(Blocks.PACKED_ICE);
		register(Blocks.ACACIA_STAIRS);
		register(Blocks.DARK_OAK_STAIRS);
		register(Blocks.SLINE);
		register(Blocks.GRASS_PATH);
		register((Block) Blocks.DOUBLE_PLANT, (Item) (new class_zx(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_ahm.class_b_in_class_ahm.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("doublePlant"));
		register((Block) Blocks.STAINED_GLASS, (Item) (new class_aaa(Blocks.STAINED_GLASS)).b("stainedGlass"));
		register((Block) Blocks.STAINED_GLASS_PANE, (Item) (new class_aaa(Blocks.STAINED_GLASS_PANE)).b("stainedGlassPane"));
		register((Block) Blocks.PRISMARINE, (Item) (new class_aba(Blocks.PRISMARINE, Blocks.PRISMARINE, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_akc.class_a_in_class_akc.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("prismarine"));
		register(Blocks.SEA_LANTERN);
		register((Block) Blocks.RED_SANDSTONE, (Item) (new class_aba(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new Function<Object, Object>() {
			public String a(class_aas var1) {
				return class_aki.class_a_in_class_aki.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((class_aas) var1);
			}
		})).b("redSandStone"));
		register(Blocks.RED_SANDSTONE_STAIRS);
		register((Block) Blocks.STONE_SLAB2, (Item) (new class_abq(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2)).b("stoneSlab2"));
		register(256, (String) "iron_shovel", (new class_abm(Item.class_a_in_class_aar.c)).c("shovelIron"));
		register(257, (String) "iron_pickaxe", (new class_abc(Item.class_a_in_class_aar.c)).c("pickaxeIron"));
		register(258, (String) "iron_axe", (new class_zd(Item.class_a_in_class_aar.c)).c("hatchetIron"));
		register(259, (String) "flint_and_steel", (new class_aam()).c("flintAndSteel"));
		register(260, (String) "apple", (new class_aan(4, 0.3F, false)).c("apple"));
		register(261, (String) "bow", (new class_zl()).c("bow"));
		register(262, (String) "arrow", (new class_zc()).c("arrow"));
		register(263, (String) "coal", (new class_zr()).c("coal"));
		register(264, (String) "diamond", (new Item()).c("diamond").a(CreativeTab.l));
		register(265, (String) "iron_ingot", (new Item()).c("ingotIron").a(CreativeTab.l));
		register(266, (String) "gold_ingot", (new Item()).c("ingotGold").a(CreativeTab.l));
		register(267, (String) "iron_sword", (new class_abw(Item.class_a_in_class_aar.c)).c("swordIron"));
		register(268, (String) "wooden_sword", (new class_abw(Item.class_a_in_class_aar.a)).c("swordWood"));
		register(269, (String) "wooden_shovel", (new class_abm(Item.class_a_in_class_aar.a)).c("shovelWood"));
		register(270, (String) "wooden_pickaxe", (new class_abc(Item.class_a_in_class_aar.a)).c("pickaxeWood"));
		register(271, (String) "wooden_axe", (new class_zd(Item.class_a_in_class_aar.a)).c("hatchetWood"));
		register(272, (String) "stone_sword", (new class_abw(Item.class_a_in_class_aar.b)).c("swordStone"));
		register(273, (String) "stone_shovel", (new class_abm(Item.class_a_in_class_aar.b)).c("shovelStone"));
		register(274, (String) "stone_pickaxe", (new class_abc(Item.class_a_in_class_aar.b)).c("pickaxeStone"));
		register(275, (String) "stone_axe", (new class_zd(Item.class_a_in_class_aar.b)).c("hatchetStone"));
		register(276, (String) "diamond_sword", (new class_abw(Item.class_a_in_class_aar.d)).c("swordDiamond"));
		register(277, (String) "diamond_shovel", (new class_abm(Item.class_a_in_class_aar.d)).c("shovelDiamond"));
		register(278, (String) "diamond_pickaxe", (new class_abc(Item.class_a_in_class_aar.d)).c("pickaxeDiamond"));
		register(279, (String) "diamond_axe", (new class_zd(Item.class_a_in_class_aar.d)).c("hatchetDiamond"));
		register(280, (String) "stick", (new Item()).n().c("stick").a(CreativeTab.l));
		register(281, (String) "bowl", (new Item()).c("bowl").a(CreativeTab.l));
		register(282, (String) "mushroom_stew", (new class_zm(6)).c("mushroomStew"));
		register(283, (String) "golden_sword", (new class_abw(Item.class_a_in_class_aar.e)).c("swordGold"));
		register(284, (String) "golden_shovel", (new class_abm(Item.class_a_in_class_aar.e)).c("shovelGold"));
		register(285, (String) "golden_pickaxe", (new class_abc(Item.class_a_in_class_aar.e)).c("pickaxeGold"));
		register(286, (String) "golden_axe", (new class_zd(Item.class_a_in_class_aar.e)).c("hatchetGold"));
		register(287, (String) "string", (new class_zh(Blocks.TRIPWIRE)).c("string").a(CreativeTab.l));
		register(288, (String) "feather", (new Item()).c("feather").a(CreativeTab.l));
		register(289, (String) "gunpowder", (new Item()).c("sulphur").a(CreativeTab.l));
		register(290, (String) "wooden_hoe", (new class_aaq(Item.class_a_in_class_aar.a)).c("hoeWood"));
		register(291, (String) "stone_hoe", (new class_aaq(Item.class_a_in_class_aar.b)).c("hoeStone"));
		register(292, (String) "iron_hoe", (new class_aaq(Item.class_a_in_class_aar.c)).c("hoeIron"));
		register(293, (String) "diamond_hoe", (new class_aaq(Item.class_a_in_class_aar.d)).c("hoeDiamond"));
		register(294, (String) "golden_hoe", (new class_aaq(Item.class_a_in_class_aar.e)).c("hoeGold"));
		register(295, (String) "wheat_seeds", (new class_abk(Blocks.WHEAT, Blocks.FARMLAND)).c("seeds"));
		register(296, (String) "wheat", (new Item()).c("wheat").a(CreativeTab.l));
		register(297, (String) "bread", (new class_aan(5, 0.6F, false)).c("bread"));
		register(298, (String) "leather_helmet", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.f)).c("helmetCloth"));
		register(299, (String) "leather_chestplate", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.e)).c("chestplateCloth"));
		register(300, (String) "leather_leggings", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.d)).c("leggingsCloth"));
		register(301, (String) "leather_boots", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.c)).c("bootsCloth"));
		register(302, (String) "chainmail_helmet", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.f)).c("helmetChain"));
		register(303, (String) "chainmail_chestplate", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.e)).c("chestplateChain"));
		register(304, (String) "chainmail_leggings", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.d)).c("leggingsChain"));
		register(305, (String) "chainmail_boots", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.c)).c("bootsChain"));
		register(306, (String) "iron_helmet", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.f)).c("helmetIron"));
		register(307, (String) "iron_chestplate", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.e)).c("chestplateIron"));
		register(308, (String) "iron_leggings", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.d)).c("leggingsIron"));
		register(309, (String) "iron_boots", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.c)).c("bootsIron"));
		register(310, (String) "diamond_helmet", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.f)).c("helmetDiamond"));
		register(311, (String) "diamond_chestplate", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.e)).c("chestplateDiamond"));
		register(312, (String) "diamond_leggings", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.d)).c("leggingsDiamond"));
		register(313, (String) "diamond_boots", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.c)).c("bootsDiamond"));
		register(314, (String) "golden_helmet", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.f)).c("helmetGold"));
		register(315, (String) "golden_chestplate", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.e)).c("chestplateGold"));
		register(316, (String) "golden_leggings", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.d)).c("leggingsGold"));
		register(317, (String) "golden_boots", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.c)).c("bootsGold"));
		register(318, (String) "flint", (new Item()).c("flint").a(CreativeTab.l));
		register(319, (String) "porkchop", (new class_aan(3, 0.3F, true)).c("porkchopRaw"));
		register(320, (String) "cooked_porkchop", (new class_aan(8, 0.8F, true)).c("porkchopCooked"));
		register(321, (String) "painting", (new class_aap(class_vc.class)).c("painting"));
		register(322, (String) "golden_apple", (new class_aao(4, 1.2F, false)).h().a(new class_pl(class_pm.j, 100, 1), 1.0F).c("appleGold"));
		register(323, (String) "sign", (new class_abn()).c("sign"));
		register(324, (String) "wooden_door", (new class_zw(Blocks.WOODEN_DOOR)).c("doorOak"));
		Item var0 = (new class_zn(Blocks.AIR)).c("bucket").d(16);
		register(325, (String) "bucket", var0);
		register(326, (String) "water_bucket", (new class_zn(Blocks.FLOWING_WATER)).c("bucketWater").c(var0));
		register(327, (String) "lava_bucket", (new class_zn(Blocks.FLOWING_LAVA)).c("bucketLava").c(var0));
		register(328, (String) "minecart", (new class_aaz(class_vn.class_a_in_class_vn.a)).c("minecart"));
		register(329, (String) "saddle", (new class_abi()).c("saddle"));
		register(330, (String) "iron_door", (new class_zw(Blocks.IRON_DOOR)).c("doorIron"));
		register(331, (String) "redstone", (new class_abh()).c("redstone"));
		register(332, (String) "snowball", (new class_abs()).c("snowball"));
		register(333, (String) "boat", (new class_zi()).c("boat"));
		register(334, (String) "leather", (new Item()).c("leather").a(CreativeTab.l));
		register(335, (String) "milk_bucket", (new class_aay()).c("milk").c(var0));
		register(336, (String) "brick", (new Item()).c("brick").a(CreativeTab.l));
		register(337, (String) "clay_ball", (new Item()).c("clay").a(CreativeTab.l));
		register(338, (String) "reeds", (new class_zh(Blocks.REEDS)).c("reeds").a(CreativeTab.l));
		register(339, (String) "paper", (new Item()).c("paper").a(CreativeTab.f));
		register(340, (String) "book", (new class_zj()).c("book").a(CreativeTab.f));
		register(341, (String) "slime_ball", (new Item()).c("slimeball").a(CreativeTab.f));
		register(342, (String) "chest_minecart", (new class_aaz(class_vn.class_a_in_class_vn.b)).c("minecartChest"));
		register(343, (String) "furnace_minecart", (new class_aaz(class_vn.class_a_in_class_vn.c)).c("minecartFurnace"));
		register(344, (String) "egg", (new class_aab()).c("egg"));
		register(345, (String) "compass", (new class_zs()).c("compass").a(CreativeTab.i));
		register(346, (String) "fishing_rod", (new class_aal()).c("fishingRod"));
		register(347, (String) "clock", (new class_zq()).c("clock").a(CreativeTab.i));
		register(348, (String) "glowstone_dust", (new Item()).c("yellowDust").a(CreativeTab.l));
		register(349, (String) "fish", (new class_aak(false)).c("fish").a(true));
		register(350, (String) "cooked_fish", (new class_aak(true)).c("fish").a(true));
		register(351, (String) "dye", (new class_zz()).c("dyePowder"));
		register(352, (String) "bone", (new Item()).c("bone").n().a(CreativeTab.f));
		register(353, (String) "sugar", (new Item()).c("sugar").a(CreativeTab.l));
		register(354, (String) "cake", (new class_zh(Blocks.CAKE)).d(1).c("cake").a(CreativeTab.h));
		register(355, (String) "bed", (new class_zf()).d(1).c("bed"));
		register(356, (String) "repeater", (new class_zh(Blocks.UNPOWERED_REPEATER)).c("diode").a(CreativeTab.d));
		register(357, (String) "cookie", (new class_aan(2, 0.1F, false)).c("cookie"));
		register(358, (String) "filled_map", (new class_aax()).c("map"));
		register(359, (String) "shears", (new class_abl()).c("shears"));
		register(360, (String) "melon", (new class_aan(2, 0.3F, false)).c("melon"));
		register(361, (String) "pumpkin_seeds", (new class_abk(Blocks.PUMPKIN_STEM, Blocks.FARMLAND)).c("seeds_pumpkin"));
		register(362, (String) "melon_seeds", (new class_abk(Blocks.MELON_STEM, Blocks.FARMLAND)).c("seeds_melon"));
		register(363, (String) "beef", (new class_aan(3, 0.3F, true)).c("beefRaw"));
		register(364, (String) "cooked_beef", (new class_aan(8, 0.8F, true)).c("beefCooked"));
		register(365, (String) "chicken", (new class_aan(2, 0.3F, true)).a(new class_pl(class_pm.q, 600, 0), 0.3F).c("chickenRaw"));
		register(366, (String) "cooked_chicken", (new class_aan(6, 0.6F, true)).c("chickenCooked"));
		register(367, (String) "rotten_flesh", (new class_aan(4, 0.1F, true)).a(new class_pl(class_pm.q, 600, 0), 0.8F).c("rottenFlesh"));
		register(368, (String) "ender_pearl", (new class_aaf()).c("enderPearl"));
		register(369, (String) "blaze_rod", (new Item()).c("blazeRod").a(CreativeTab.l).n());
		register(370, (String) "ghast_tear", (new Item()).c("ghastTear").a(CreativeTab.k));
		register(371, (String) "gold_nugget", (new Item()).c("goldNugget").a(CreativeTab.l));
		register(372, (String) "nether_wart", (new class_abk(Blocks.NETHER_WART, Blocks.SOUL_SAND)).c("netherStalkSeeds"));
		register(373, (String) "potion", (new class_abe()).c("potion"));
		register(374, (String) "glass_bottle", (new class_zk()).c("glassBottle"));
		register(375, (String) "spider_eye", (new class_aan(2, 0.8F, false)).a(new class_pl(class_pm.s, 100, 0), 1.0F).c("spiderEye"));
		register(376, (String) "fermented_spider_eye", (new Item()).c("fermentedSpiderEye").a(CreativeTab.k));
		register(377, (String) "blaze_powder", (new Item()).c("blazePowder").a(CreativeTab.k));
		register(378, (String) "magma_cream", (new Item()).c("magmaCream").a(CreativeTab.k));
		register(379, (String) "brewing_stand", (new class_zh(Blocks.BREWING_STAND)).c("brewingStand").a(CreativeTab.k));
		register(380, (String) "cauldron", (new class_zh(Blocks.CAULDRON)).c("cauldron").a(CreativeTab.k));
		register(381, (String) "ender_eye", (new class_aae()).c("eyeOfEnder"));
		register(382, (String) "speckled_melon", (new Item()).c("speckledMelon").a(CreativeTab.k));
		register(383, (String) "spawn_egg", (new class_abt()).c("monsterPlacer"));
		register(384, (String) "experience_bottle", (new class_aag()).c("expBottle"));
		register(385, (String) "fire_charge", (new class_aah()).c("fireball"));
		register(386, (String) "writable_book", (new class_acb()).c("writingBook").a(CreativeTab.f));
		register(387, (String) "written_book", (new class_acc()).c("writtenBook").d(16));
		register(388, (String) "emerald", (new Item()).c("emerald").a(CreativeTab.l));
		register(389, (String) "item_frame", (new class_aap(class_va.class)).c("frame"));
		register(390, (String) "flower_pot", (new class_zh(Blocks.FLOWER_POT)).c("flowerPot").a(CreativeTab.c));
		register(391, (String) "carrot", (new class_abj(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).c("carrots"));
		register(392, (String) "potato", (new class_abj(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).c("potato"));
		register(393, (String) "baked_potato", (new class_aan(5, 0.6F, false)).c("potatoBaked"));
		register(394, (String) "poisonous_potato", (new class_aan(2, 0.3F, false)).a(new class_pl(class_pm.s, 100, 0), 0.6F).c("potatoPoisonous"));
		register(395, (String) "map", (new class_aac()).c("emptyMap"));
		register(396, (String) "golden_carrot", (new class_aan(6, 1.2F, false)).c("carrotGolden").a(CreativeTab.k));
		register(397, (String) "skull", (new class_abp()).c("skull"));
		register(398, (String) "carrot_on_a_stick", (new class_zo()).c("carrotOnAStick"));
		register(399, (String) "nether_star", (new class_abo()).c("netherStar").a(CreativeTab.l));
		register(400, (String) "pumpkin_pie", (new class_aan(8, 0.3F, false)).c("pumpkinPie").a(CreativeTab.h));
		register(401, (String) "fireworks", (new class_aaj()).c("fireworks"));
		register(402, (String) "firework_charge", (new class_aai()).c("fireworksCharge").a(CreativeTab.f));
		register(403, (String) "enchanted_book", (new class_aad()).d(1).c("enchantedBook"));
		register(404, (String) "comparator", (new class_zh(Blocks.UNPOWERED_COMPARATOR)).c("comparator").a(CreativeTab.d));
		register(405, (String) "netherbrick", (new Item()).c("netherbrick").a(CreativeTab.l));
		register(406, (String) "quartz", (new Item()).c("netherquartz").a(CreativeTab.l));
		register(407, (String) "tnt_minecart", (new class_aaz(class_vn.class_a_in_class_vn.d)).c("minecartTnt"));
		register(408, (String) "hopper_minecart", (new class_aaz(class_vn.class_a_in_class_vn.f)).c("minecartHopper"));
		register(409, (String) "prismarine_shard", (new Item()).c("prismarineShard").a(CreativeTab.l));
		register(410, (String) "prismarine_crystals", (new Item()).c("prismarineCrystals").a(CreativeTab.l));
		register(411, (String) "rabbit", (new class_aan(3, 0.3F, true)).c("rabbitRaw"));
		register(412, (String) "cooked_rabbit", (new class_aan(5, 0.6F, true)).c("rabbitCooked"));
		register(413, (String) "rabbit_stew", (new class_zm(10)).c("rabbitStew"));
		register(414, (String) "rabbit_foot", (new Item()).c("rabbitFoot").a(CreativeTab.k));
		register(415, (String) "rabbit_hide", (new Item()).c("rabbitHide").a(CreativeTab.l));
		register(416, (String) "armor_stand", (new class_zb()).c("armorStand").d(16));
		register(417, (String) "iron_horse_armor", (new Item()).c("horsearmormetal").d(1).a(CreativeTab.f));
		register(418, (String) "golden_horse_armor", (new Item()).c("horsearmorgold").d(1).a(CreativeTab.f));
		register(419, (String) "diamond_horse_armor", (new Item()).c("horsearmordiamond").d(1).a(CreativeTab.f));
		register(420, (String) "lead", (new class_aav()).c("leash"));
		register(421, (String) "name_tag", (new class_abb()).c("nameTag"));
		register(422, (String) "command_block_minecart", (new class_aaz(class_vn.class_a_in_class_vn.g)).c("minecartCommandBlock").a((CreativeTab) null));
		register(423, (String) "mutton", (new class_aan(2, 0.3F, true)).c("muttonRaw"));
		register(424, (String) "cooked_mutton", (new class_aan(6, 0.8F, true)).c("muttonCooked"));
		register(425, (String) "banner", (new class_ze()).b("banner"));
		register(427, (String) "spruce_door", (new class_zw(Blocks.SPRUCE_DOOR)).c("doorSpruce"));
		register(428, (String) "birch_door", (new class_zw(Blocks.BIRCH_DOOR)).c("doorBirch"));
		register(429, (String) "jungle_door", (new class_zw(Blocks.JUNGLE_DOOR)).c("doorJungle"));
		register(430, (String) "acacia_door", (new class_zw(Blocks.ACACIA_DOOR)).c("doorAcacia"));
		register(431, (String) "dark_oak_door", (new class_zw(Blocks.DARK_OAK_DOOR)).c("doorDarkOak"));
		register(432, (String) "chorus_fruit", (new class_zp(4, 0.3F)).h().c("chorusFruit").a(CreativeTab.l));
		register(433, (String) "chorus_fruit_popped", (new Item()).c("chorusFruitPopped").a(CreativeTab.l));
		register(434, (String) "beetroot", (new class_aan(1, 0.6F, false)).c("beetroot"));
		register(435, (String) "beetroot_seeds", (new class_abk(Blocks.BEETROOTS, Blocks.FARMLAND)).c("beetroot_seeds"));
		register(436, (String) "beetroot_soup", (new class_zm(6)).c("beetroot_soup"));
		register(438, (String) "splash_potion", (new class_abv()).c("splash_potion"));
		register(439, (String) "spectral_arrow", (new class_abu()).c("spectral_arrow"));
		register(440, (String) "tipped_arrow", (new class_aby()).c("tipped_arrow"));
		register(2256, (String) "record_13", (new class_abg("13")).c("record"));
		register(2257, (String) "record_cat", (new class_abg("cat")).c("record"));
		register(2258, (String) "record_blocks", (new class_abg("blocks")).c("record"));
		register(2259, (String) "record_chirp", (new class_abg("chirp")).c("record"));
		register(2260, (String) "record_far", (new class_abg("far")).c("record"));
		register(2261, (String) "record_mall", (new class_abg("mall")).c("record"));
		register(2262, (String) "record_mellohi", (new class_abg("mellohi")).c("record"));
		register(2263, (String) "record_stal", (new class_abg("stal")).c("record"));
		register(2264, (String) "record_strad", (new class_abg("strad")).c("record"));
		register(2265, (String) "record_ward", (new class_abg("ward")).c("record"));
		register(2266, (String) "record_11", (new class_abg("11")).c("record"));
		register(2267, (String) "record_wait", (new class_abg("wait")).c("record"));
	}

	private static void register(Block var0) {
		register((Block) var0, (Item) (new ItemBlock(var0)));
	}

	protected static void register(Block var0, Item var1) {
		a(Block.getId(var0), (MinecraftKey) Block.BLOCK_REGISTRY.getKey(var0), var1);
		BLOCK_TO_ITEM.put(var0, var1);
	}

	private static void register(int var0, String var1, Item var2) {
		a(var0, new MinecraftKey(var1), var2);
	}

	private static void a(int var0, MinecraftKey var1, Item var2) {
		ITEM_REGISTRY.register(var0, var1, var2);
	}

	public static enum class_a_in_class_aar {
		a(0, 59, 2.0F, 0.0F, 15), b(1, 131, 4.0F, 1.0F, 5), c(2, 250, 6.0F, 2.0F, 14), d(3, 1561, 8.0F, 3.0F, 10), e(0, 32, 12.0F, 0.0F, 22);

		private final int f;
		private final int g;
		private final float h;
		private final float i;
		private final int j;

		private class_a_in_class_aar(int var3, int var4, float var5, float var6, int var7) {
			this.f = var3;
			this.g = var4;
			this.h = var5;
			this.i = var6;
			this.j = var7;
		}

		public int a() {
			return this.g;
		}

		public float b() {
			return this.h;
		}

		public float c() {
			return this.i;
		}

		public int d() {
			return this.f;
		}

		public int e() {
			return this.j;
		}

		public Item f() {
			return this == a ? Item.getByBlock(Blocks.PLANKS) : (this == b ? Item.getByBlock(Blocks.COBBLESTONE) : (this == e ? Items.m : (this == c ? Items.l : (this == d ? Items.k : null))));
		}
	}
}
