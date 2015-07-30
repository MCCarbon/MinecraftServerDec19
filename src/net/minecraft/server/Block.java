package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.class_aej;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.BlockAir;
import net.minecraft.server.class_aga;
import net.minecraft.server.class_agb;
import net.minecraft.server.class_agc;
import net.minecraft.server.class_agg;
import net.minecraft.server.class_agh;
import net.minecraft.server.class_agi;
import net.minecraft.server.class_agm;
import net.minecraft.server.class_agn;
import net.minecraft.server.class_agq;
import net.minecraft.server.class_agr;
import net.minecraft.server.class_ags;
import net.minecraft.server.class_agt;
import net.minecraft.server.class_agu;
import net.minecraft.server.class_agv;
import net.minecraft.server.class_agw;
import net.minecraft.server.class_agx;
import net.minecraft.server.class_agy;
import net.minecraft.server.class_agz;
import net.minecraft.server.class_aha;
import net.minecraft.server.class_ahb;
import net.minecraft.server.class_ahc;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_ahe;
import net.minecraft.server.class_ahf;
import net.minecraft.server.class_ahg;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_ahk;
import net.minecraft.server.class_ahl;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_ahn;
import net.minecraft.server.class_aho;
import net.minecraft.server.class_ahp;
import net.minecraft.server.class_ahq;
import net.minecraft.server.class_ahr;
import net.minecraft.server.class_ahs;
import net.minecraft.server.class_aht;
import net.minecraft.server.class_ahu;
import net.minecraft.server.class_ahv;
import net.minecraft.server.class_ahy;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_aia;
import net.minecraft.server.class_aib;
import net.minecraft.server.class_aid;
import net.minecraft.server.class_aie;
import net.minecraft.server.class_aif;
import net.minecraft.server.class_aig;
import net.minecraft.server.class_aih;
import net.minecraft.server.class_aii;
import net.minecraft.server.class_aij;
import net.minecraft.server.BlockGrass;
import net.minecraft.server.class_ail;
import net.minecraft.server.class_aim;
import net.minecraft.server.class_ain;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_aip;
import net.minecraft.server.class_air;
import net.minecraft.server.class_ais;
import net.minecraft.server.class_ait;
import net.minecraft.server.class_aiu;
import net.minecraft.server.class_aiw;
import net.minecraft.server.class_aix;
import net.minecraft.server.class_aiy;
import net.minecraft.server.class_aiz;
import net.minecraft.server.class_ajc;
import net.minecraft.server.class_ajf;
import net.minecraft.server.class_ajg;
import net.minecraft.server.class_ajh;
import net.minecraft.server.class_aji;
import net.minecraft.server.class_ajj;
import net.minecraft.server.class_ajk;
import net.minecraft.server.class_ajl;
import net.minecraft.server.class_ajm;
import net.minecraft.server.class_ajn;
import net.minecraft.server.class_ajo;
import net.minecraft.server.class_ajq;
import net.minecraft.server.class_ajr;
import net.minecraft.server.class_ajs;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_aju;
import net.minecraft.server.class_ajv;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_ajx;
import net.minecraft.server.class_ajy;
import net.minecraft.server.class_ajz;
import net.minecraft.server.class_aka;
import net.minecraft.server.class_akb;
import net.minecraft.server.class_akc;
import net.minecraft.server.class_akd;
import net.minecraft.server.class_ake;
import net.minecraft.server.class_akf;
import net.minecraft.server.class_akg;
import net.minecraft.server.class_akh;
import net.minecraft.server.class_aki;
import net.minecraft.server.class_akj;
import net.minecraft.server.class_akk;
import net.minecraft.server.class_akl;
import net.minecraft.server.class_akm;
import net.minecraft.server.class_akn;
import net.minecraft.server.class_ako;
import net.minecraft.server.class_akp;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_akr;
import net.minecraft.server.class_aks;
import net.minecraft.server.class_akt;
import net.minecraft.server.class_akv;
import net.minecraft.server.class_akw;
import net.minecraft.server.class_akx;
import net.minecraft.server.class_aky;
import net.minecraft.server.class_akz;
import net.minecraft.server.class_ala;
import net.minecraft.server.class_alb;
import net.minecraft.server.class_alc;
import net.minecraft.server.class_ald;
import net.minecraft.server.class_ale;
import net.minecraft.server.class_alf;
import net.minecraft.server.class_alg;
import net.minecraft.server.BlockStone;
import net.minecraft.server.class_ali;
import net.minecraft.server.class_alj;
import net.minecraft.server.class_all;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_aln;
import net.minecraft.server.class_alo;
import net.minecraft.server.class_alp;
import net.minecraft.server.class_alr;
import net.minecraft.server.class_als;
import net.minecraft.server.class_alt;
import net.minecraft.server.class_alu;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_alw;
import net.minecraft.server.class_alx;
import net.minecraft.server.class_aly;
import net.minecraft.server.class_alz;
import net.minecraft.server.class_ama;
import net.minecraft.server.class_amc;
import net.minecraft.server.class_amd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ane;
import net.minecraft.server.class_anf;
import net.minecraft.server.class_anh;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.RegistryBlocks;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.RegistryID;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_px;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_xa;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.CreativeTab;

public class Block {

	private static final MinecraftKey AIR_KEY = new MinecraftKey("air");
	public static final RegistryBlocks<MinecraftKey, Block> BLOCK_REGISTRY = new RegistryBlocks<MinecraftKey, Block>(AIR_KEY);
	public static final RegistryID<IBlockData> BLOCKDATA_REGISTRY = new RegistryID<IBlockData>();
	public static final Block.StepSound STEP_SOUND_STONE1 = new Block.StepSound("stone", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_WOOD = new Block.StepSound("wood", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_GRAVEL = new Block.StepSound("gravel", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_GRASS = new Block.StepSound("grass", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_STONE2 = new Block.StepSound("stone", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_STONE3 = new Block.StepSound("stone", 1.0F, 1.5F);
	public static final Block.StepSound STEP_SOUND_STONE4 = new Block.StepSound("stone", 1.0F, 1.0F) {
		public String a() {
			return "dig.glass";
		}

		public String b() {
			return "step.stone";
		}
	};
	public static final Block.StepSound STEP_SOUND_CLOTH = new Block.StepSound("cloth", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_SAND = new Block.StepSound("sand", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_SNOW = new Block.StepSound("snow", 1.0F, 1.0F);
	public static final Block.StepSound STEP_SOUND_LADDER = new Block.StepSound("ladder", 1.0F, 1.0F) {
		public String a() {
			return "dig.wood";
		}
	};
	public static final Block.StepSound STEP_SOUND_ANVIL = new Block.StepSound("anvil", 0.3F, 1.0F) {
		public String a() {
			return "dig.stone";
		}

		public String b() {
			return "random.anvil_land";
		}
	};
	public static final Block.StepSound STEP_SOUND_SLIME = new Block.StepSound("slime", 1.0F, 1.0F) {
		public String a() {
			return "mob.slime.big";
		}

		public String b() {
			return "mob.slime.big";
		}

		public String c() {
			return "mob.slime.small";
		}
	};

	protected boolean isFullBlock;
	protected int lightOpacity;
	protected boolean translucent;
	protected int lightLevel;
	protected boolean useNeighborBrightness;
	protected float strength;
	protected float explosionResist;
	protected boolean useBreakStat;
	protected boolean isTicking;
	protected boolean isTileEntity;
	protected double minX;
	protected double minY;
	protected double minZ;
	protected double maxX;
	protected double maxY;
	protected double maxZ;
	public Block.StepSound stepSound;
	protected final Material material;
	protected final MaterialMapColor mapcolor;
	public float frictionFactor;
	protected final BlockStateList blockStateList;
	private IBlockData blockData;
	private String name;

	public static int getId(Block block) {
		return BLOCK_REGISTRY.getId(block);
	}

	public static int getCombinedId(IBlockData data) {
		Block block = data.getBlock();
		return getId(block) + (block.toLegacyData(data) << 12);
	}

	public static Block getById(int id) {
		return BLOCK_REGISTRY.get(id);
	}

	public static IBlockData getByCombinedId(int combinedId) {
		int id = combinedId & 4095;
		int data = combinedId >> 12 & 15;
		return getById(id).fromLegacyData(data);
	}

	public static Block getByItem(Item item) {
		return item instanceof ItemBlock ? ((ItemBlock) item).getBlock() : null;
	}

	public static Block getByName(String name) {
		MinecraftKey key = new MinecraftKey(name);
		if (BLOCK_REGISTRY.has(key)) {
			return (Block) BLOCK_REGISTRY.get(key);
		} else {
			try {
				return (Block) BLOCK_REGISTRY.get(Integer.parseInt(name));
			} catch (NumberFormatException e) {
				return null;
			}
		}
	}

	public Block(Material material, MaterialMapColor mapcolor) {
		this.useBreakStat = true;
		this.stepSound = STEP_SOUND_STONE1;
		this.frictionFactor = 0.6F;
		this.material = material;
		this.mapcolor = mapcolor;
		this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.isFullBlock = this.isOpaqueCube();
		this.lightOpacity = this.isOpaqueCube() ? 255 : 0;
		this.translucent = !material.blocksLight();
		this.blockStateList = this.createBlockStateList();
		this.setBlockData(this.blockStateList.getFirst());
	}

	protected Block(Material material) {
		this(material, material.getMapColor());
	}

	public boolean isFullBlock() {
		return this.isFullBlock;
	}

	public int getLightOpacity() {
		return this.lightOpacity;
	}

	public int getLightLevel() {
		return this.lightLevel;
	}

	public boolean useNeighborBrightness() {
		return this.useNeighborBrightness;
	}

	public Material getMaterial() {
		return this.material;
	}

	public MaterialMapColor getMapColor(IBlockData data) {
		return this.mapcolor;
	}

	public IBlockData fromLegacyData(int data) {
		return this.getBlockData();
	}

	public int toLegacyData(IBlockData blockdata) {
		if (blockdata != null && !blockdata.getStates().isEmpty()) {
			throw new IllegalArgumentException("Don\'t know how to convert " + blockdata + " back into data...");
		} else {
			return 0;
		}
	}

	public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
		return var1;
	}

	public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
		return var1;
	}

	public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
		return var1;
	}

	protected Block setStepSound(Block.StepSound stepSound) {
		this.stepSound = stepSound;
		return this;
	}

	protected Block setLightOpacity(int lightOpacity) {
		this.lightOpacity = lightOpacity;
		return this;
	}

	protected Block setLightLevel(float lightLevel) {
		this.lightLevel = (int) (15.0F * lightLevel);
		return this;
	}

	protected Block setExplosionResist(float explosionResist) {
		this.explosionResist = explosionResist * 3.0F;
		return this;
	}

	public boolean isSoildFullCube() {
		return this.material.isSolid() && this.isFullCube();
	}

	public boolean isOccluding() {
		return this.material.isOpaque() && this.isFullCube() && !this.isPowerSource();
	}

	public boolean isVisuallyOpaque() {
		return this.material.isSolid() && this.isFullCube();
	}

	public boolean isFullCube() {
		return true;
	}

	public boolean isPassable(class_aer var1, BlockPosition var2) {
		return !this.material.isSolid();
	}

	public int getRenderType() {
		return 3;
	}

	public boolean isReplaceable(World world, BlockPosition var2) {
		return false;
	}

	protected Block setStrength(float strength) {
		this.strength = strength;
		if (this.explosionResist < strength * 5.0F) {
			this.explosionResist = strength * 5.0F;
		}

		return this;
	}

	protected Block setUnbreakable() {
		this.setStrength(-1.0F);
		return this;
	}

	public float getStrength(World world, BlockPosition var2) {
		return this.strength;
	}

	protected Block setTicking(boolean isTicking) {
		this.isTicking = isTicking;
		return this;
	}

	public boolean isTicking() {
		return this.isTicking;
	}

	public boolean isTileEntity() {
		return this.isTileEntity;
	}

	protected final void setSizes(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		this.minX = (double) minX;
		this.minY = (double) minY;
		this.minZ = (double) minZ;
		this.maxX = (double) maxX;
		this.maxY = (double) maxY;
		this.maxZ = (double) maxZ;
	}

	public boolean b(class_aer var1, BlockPosition var2, EnumDirection var3) {
		return var1.p(var2).getBlock().getMaterial().isBuildable();
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List<class_awf> var5, class_pr var6) {
		class_awf var7 = this.a(var1, var2, var3);
		if (var7 != null && var4.b(var7)) {
			var5.add(var7);
		}

	}

	public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
		return new class_awf((double) var2.getX() + this.minX, (double) var2.getY() + this.minY, (double) var2.getZ() + this.minZ, (double) var2.getX() + this.maxX, (double) var2.getY() + this.maxY, (double) var2.getZ() + this.maxZ);
	}

	public boolean isOpaqueCube() {
		return true;
	}

	public boolean a(IBlockData var1, boolean var2) {
		return this.C();
	}

	public boolean C() {
		return true;
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		this.b(var1, var2, var3, var4);
	}

	public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
	}

	public void d(World var1, BlockPosition var2, IBlockData var3) {
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
	}

	public int a(World var1) {
		return 10;
	}

	public void c(World var1, BlockPosition var2, IBlockData var3) {
	}

	public void b(World var1, BlockPosition var2, IBlockData var3) {
	}

	public int a(Random var1) {
		return 1;
	}

	public Item getDropType(IBlockData blockdata, Random random, int var3) {
		return Item.getByBlock(this);
	}

	public float a(class_xa var1, World var2, BlockPosition var3) {
		float var4 = this.getStrength(var2, var3);
		return var4 < 0.0F ? 0.0F : (!var1.b(this) ? var1.a(this) / var4 / 100.0F : var1.a(this) / var4 / 30.0F);
	}

	public final void b(World var1, BlockPosition var2, IBlockData var3, int var4) {
		this.dropNaturally(var1, var2, var3, 1.0F, var4);
	}

	public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = this.a(var5, var1.s);

			for (int var7 = 0; var7 < var6; ++var7) {
				if (var1.s.nextFloat() <= var4) {
					Item var8 = this.getDropType(var3, var1.s, var5);
					if (var8 != null) {
						a(var1, var2, new class_aas(var8, 1, this.getDropData(var3)));
					}
				}
			}

		}
	}

	public static void a(World var0, BlockPosition var1, class_aas var2) {
		if (!var0.D && var0.R().b("doTileDrops")) {
			float var3 = 0.5F;
			double var4 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			double var6 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			double var8 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			class_vm var10 = new class_vm(var0, (double) var1.getX() + var4, (double) var1.getY() + var6, (double) var1.getZ() + var8, var2);
			var10.p();
			var0.a((class_pr) var10);
		}
	}

	protected void b(World var1, BlockPosition var2, int var3) {
		if (!var1.D) {
			while (var3 > 0) {
				int var4 = class_px.a(var3);
				var3 -= var4;
				var1.a((class_pr) (new class_px(var1, (double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, var4)));
			}
		}

	}

	public int getDropData(IBlockData blockdata) {
		return 0;
	}

	public float a(class_pr var1) {
		return this.explosionResist / 5.0F;
	}

	public class_awg a(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
		this.a((class_aer) var1, (BlockPosition) var2);
		var3 = var3.add((double) (-var2.getX()), (double) (-var2.getY()), (double) (-var2.getZ()));
		var4 = var4.add((double) (-var2.getX()), (double) (-var2.getY()), (double) (-var2.getZ()));
		Vec3D var5 = var3.getIntermediateWithXValue(var4, this.minX);
		Vec3D var6 = var3.getIntermediateWithXValue(var4, this.maxX);
		Vec3D var7 = var3.getIntermediateWithYValue(var4, this.minY);
		Vec3D var8 = var3.getIntermediateWithYValue(var4, this.maxY);
		Vec3D var9 = var3.getIntermediateWithZValue(var4, this.minZ);
		Vec3D var10 = var3.getIntermediateWithZValue(var4, this.maxZ);
		if (!this.a(var5)) {
			var5 = null;
		}

		if (!this.a(var6)) {
			var6 = null;
		}

		if (!this.b(var7)) {
			var7 = null;
		}

		if (!this.b(var8)) {
			var8 = null;
		}

		if (!this.c(var9)) {
			var9 = null;
		}

		if (!this.c(var10)) {
			var10 = null;
		}

		Vec3D var11 = null;
		if (var5 != null && (var11 == null || var3.distanceSquared(var5) < var3.distanceSquared(var11))) {
			var11 = var5;
		}

		if (var6 != null && (var11 == null || var3.distanceSquared(var6) < var3.distanceSquared(var11))) {
			var11 = var6;
		}

		if (var7 != null && (var11 == null || var3.distanceSquared(var7) < var3.distanceSquared(var11))) {
			var11 = var7;
		}

		if (var8 != null && (var11 == null || var3.distanceSquared(var8) < var3.distanceSquared(var11))) {
			var11 = var8;
		}

		if (var9 != null && (var11 == null || var3.distanceSquared(var9) < var3.distanceSquared(var11))) {
			var11 = var9;
		}

		if (var10 != null && (var11 == null || var3.distanceSquared(var10) < var3.distanceSquared(var11))) {
			var11 = var10;
		}

		if (var11 == null) {
			return null;
		} else {
			EnumDirection var12 = null;
			if (var11 == var5) {
				var12 = EnumDirection.WEST;
			}

			if (var11 == var6) {
				var12 = EnumDirection.EAST;
			}

			if (var11 == var7) {
				var12 = EnumDirection.DOWN;
			}

			if (var11 == var8) {
				var12 = EnumDirection.UP;
			}

			if (var11 == var9) {
				var12 = EnumDirection.NORTH;
			}

			if (var11 == var10) {
				var12 = EnumDirection.SOUTH;
			}

			return new class_awg(var11.add((double) var2.getX(), (double) var2.getY(), (double) var2.getZ()), var12, var2);
		}
	}

	private boolean a(Vec3D var1) {
		return var1 == null ? false : var1.y >= this.minY && var1.y <= this.maxY && var1.z >= this.minZ && var1.z <= this.maxZ;
	}

	private boolean b(Vec3D var1) {
		return var1 == null ? false : var1.x >= this.minX && var1.x <= this.maxX && var1.z >= this.minZ && var1.z <= this.maxZ;
	}

	private boolean c(Vec3D var1) {
		return var1 == null ? false : var1.x >= this.minX && var1.x <= this.maxX && var1.y >= this.minY && var1.y <= this.maxY;
	}

	public void a(World var1, BlockPosition var2, class_aej var3) {
	}

	public boolean a(World var1, BlockPosition var2, EnumDirection var3, class_aas var4) {
		return this.b(var1, var2, var3);
	}

	public boolean b(World var1, BlockPosition var2, EnumDirection var3) {
		return this.d(var1, var2);
	}

	public boolean d(World var1, BlockPosition var2) {
		return var1.p(var2).getBlock().material.isReplaceable();
	}

	public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
		return false;
	}

	public void a(World var1, BlockPosition var2, class_pr var3) {
	}

	public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
		return this.fromLegacyData(var7);
	}

	public void a(World var1, BlockPosition var2, class_xa var3) {
	}

	public Vec3D a(World var1, BlockPosition var2, class_pr var3, Vec3D var4) {
		return var4;
	}

	public void a(class_aer var1, BlockPosition var2) {
	}

	public final double getMinX() {
		return this.minX;
	}

	public final double getMaxX() {
		return this.maxX;
	}

	public final double getMinY() {
		return this.minY;
	}

	public final double getMaxY() {
		return this.maxY;
	}

	public final double getMinZ() {
		return this.minZ;
	}

	public final double getMaxZ() {
		return this.maxZ;
	}

	public int a(class_aer var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
		return 0;
	}

	public boolean isPowerSource() {
		return false;
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, class_pr var4) {
	}

	public int b(class_aer var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
		return 0;
	}

	public void j() {
	}

	public void a(World var1, class_xa var2, BlockPosition var3, IBlockData var4, class_amg var5, class_aas var6) {
		var2.b(class_nc.ab[getId(this)]);
		var2.a(0.025F);
		if (this.K() && class_adk.a(class_adm.q, var6) > 0) {
			class_aas var8 = this.i(var4);
			if (var8 != null) {
				a(var1, var3, var8);
			}
		} else {
			int var7 = class_adk.a(class_adm.s, var6);
			this.b(var1, var3, var4, var7);
		}

	}

	protected boolean K() {
		return this.isFullCube() && !this.isTileEntity;
	}

	protected class_aas i(IBlockData var1) {
		int var2 = 0;
		Item var3 = Item.getByBlock(this);
		if (var3 != null && var3.k()) {
			var2 = this.toLegacyData(var1);
		}

		return new class_aas(var3, 1, var2);
	}

	public int a(int var1, Random var2) {
		return this.a(var2);
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, class_aas var5) {
	}

	public boolean g() {
		return !this.material.isBuildable() && !this.material.isLiquid();
	}

	public Block setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return LocaleI18n.get(this.getInternalName() + ".name");
	}

	public String getInternalName() {
		return "tile." + this.name;
	}

	public boolean a(World var1, BlockPosition var2, IBlockData var3, int var4, int var5) {
		return false;
	}

	public boolean useBreakStat() {
		return this.useBreakStat;
	}

	protected Block disableBreakStat() {
		this.useBreakStat = false;
		return this;
	}

	public int getPushReaction() {
		return this.material.getPushReaction();
	}

	public void a(World var1, BlockPosition var2, class_pr var3, float var4) {
		var3.e(var4, 1.0F);
	}

	public void a(World var1, class_pr var2) {
		var2.w = 0.0D;
	}

	public int j(World var1, BlockPosition var2) {
		return this.getDropData(var1.p(var2));
	}

	public Block a(CreativeTab var1) {
		return this;
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, class_xa var4) {
	}

	public void k(World var1, BlockPosition var2) {
	}

	public boolean P() {
		return true;
	}

	public boolean a(class_aej var1) {
		return true;
	}

	public boolean b(Block var1) {
		return this == var1;
	}

	public static boolean a(Block var0, Block var1) {
		return var0 != null && var1 != null ? (var0 == var1 ? true : var0.b(var1)) : false;
	}

	public boolean Q() {
		return false;
	}

	public int l(World var1, BlockPosition var2) {
		return 0;
	}

	protected BlockStateList createBlockStateList() {
		return new BlockStateList(this, new IBlockState[0]);
	}

	public BlockStateList getBlockStateList() {
		return this.blockStateList;
	}

	protected final void setBlockData(IBlockData blockdata) {
		this.blockData = blockdata;
	}

	public final IBlockData getBlockData() {
		return this.blockData;
	}

	public String toString() {
		return "Block{" + BLOCK_REGISTRY.getKey(this) + "}";
	}

	public static void init() {
		register(0, AIR_KEY, (new BlockAir()).setName("air"));
		register(1, "stone", (new BlockStone()).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stone"));
		register(2, "grass", (new BlockGrass()).setStrength(0.6F).setStepSound(STEP_SOUND_GRASS).setName("grass"));
		register(3, "dirt", (new class_ahj()).setStrength(0.5F).setStepSound(STEP_SOUND_GRAVEL).setName("dirt"));
		Block var0 = (new Block(Material.STONE)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stonebrick").a(CreativeTab.b);
		register(4, "cobblestone", var0);
		Block var1 = (new class_ajw()).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("wood");
		register(5, "planks", var1);
		register(6, "sapling", (new class_aks()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("sapling"));
		register(7, "bedrock", (new Block(Material.STONE)).setUnbreakable().setExplosionResist(6000000.0F).setStepSound(STEP_SOUND_STONE2).setName("bedrock").disableBreakStat().a(CreativeTab.b));
		register(8, "flowing_water", (new class_ahp(Material.WATER)).setStrength(100.0F).setLightOpacity(3).setName("water").disableBreakStat());
		register(9, "water", (new class_alf(Material.WATER)).setStrength(100.0F).setLightOpacity(3).setName("water").disableBreakStat());
		register(10, "flowing_lava", (new class_ahp(Material.LAVA)).setStrength(100.0F).setLightLevel(1.0F).setName("lava").disableBreakStat());
		register(11, "lava", (new class_alf(Material.LAVA)).setStrength(100.0F).setLightLevel(1.0F).setName("lava").disableBreakStat());
		register(12, "sand", (new class_akq()).setStrength(0.5F).setStepSound(STEP_SOUND_SAND).setName("sand"));
		register(13, "gravel", (new class_aim()).setStrength(0.6F).setStepSound(STEP_SOUND_GRAVEL).setName("gravel"));
		register(14, "gold_ore", (new class_aju()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreGold"));
		register(15, "iron_ore", (new class_aju()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreIron"));
		register(16, "coal_ore", (new class_aju()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreCoal"));
		register(17, "log", (new class_ajt()).setName("log"));
		register(18, "leaves", (new class_ajs()).setName("leaves"));
		register(19, "sponge", (new class_ala()).setStrength(0.6F).setStepSound(STEP_SOUND_GRASS).setName("sponge"));
		register(20, "glass", (new class_aii(Material.SHATTERABLE, false)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("glass"));
		register(21, "lapis_ore", (new class_aju()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreLapis"));
		register(22, "lapis_block", (new Block(Material.ORE, MaterialMapColor.COLOR33)).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("blockLapis").a(CreativeTab.b));
		register(23, "dispenser", (new class_ahk()).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setName("dispenser"));
		Block var2 = (new class_akr()).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setName("sandStone");
		register(24, "sandstone", var2);
		register(25, "noteblock", (new class_ajq()).setStrength(0.8F).setName("musicBlock"));
		register(26, "bed", (new class_agh()).setStepSound(STEP_SOUND_WOOD).setStrength(0.2F).setName("bed").disableBreakStat());
		register(27, "golden_rail", (new class_aka()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("goldenRail"));
		register(28, "detector_rail", (new class_ahg()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("detectorRail"));
		register(29, "sticky_piston", (new class_ane(true)).setName("pistonStickyBase"));
		register(30, "web", (new class_aly()).setLightOpacity(1).setStrength(4.0F).setName("web"));
		register(31, "tallgrass", (new class_alm()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("tallgrass"));
		register(32, "deadbush", (new class_ahf()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("deadbush"));
		register(33, "piston", (new class_ane(false)).setName("pistonBase"));
		register(34, "piston_head", (new class_anf()).setName("pistonBase"));
		register(35, "wool", (new class_agz(Material.CLOTH)).setStrength(0.8F).setStepSound(STEP_SOUND_CLOTH).setName("cloth"));
		register(36, "piston_extension", new class_anh());
		register(37, "yellow_flower", (new class_amd()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("flower1"));
		register(38, "red_flower", (new class_akh()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("flower2"));
		Block var3 = (new class_aji()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setLightLevel(0.125F).setName("mushroom");
		register(39, "brown_mushroom", var3);
		Block var4 = (new class_aji()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("mushroom");
		register(40, "red_mushroom", var4);
		register(41, "gold_block", (new Block(Material.ORE, MaterialMapColor.COLOR31)).setStrength(3.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockGold").a(CreativeTab.b));
		register(42, "iron_block", (new Block(Material.ORE, MaterialMapColor.COLOR7)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockIron").a(CreativeTab.b));
		register(43, "double_stone_slab", (new class_aif()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab"));
		register(44, "stone_slab", (new class_aip()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab"));
		Block var5 = (new Block(Material.STONE, MaterialMapColor.COLOR29)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("brick").a(CreativeTab.b);
		register(45, "brick_block", var5);
		register(46, "tnt", (new class_alo()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("tnt"));
		register(47, "bookshelf", (new class_agm()).setStrength(1.5F).setStepSound(STEP_SOUND_WOOD).setName("bookshelf"));
		register(48, "mossy_cobblestone", (new Block(Material.STONE)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneMoss").a(CreativeTab.b));
		register(49, "obsidian", (new class_ajr()).setStrength(50.0F).setExplosionResist(2000.0F).setStepSound(STEP_SOUND_STONE2).setName("obsidian"));
		register(50, "torch", (new class_alp()).setStrength(0.0F).setLightLevel(0.9375F).setStepSound(STEP_SOUND_WOOD).setName("torch"));
		register(51, "fire", (new class_aib()).setStrength(0.0F).setLightLevel(1.0F).setStepSound(STEP_SOUND_CLOTH).setName("fire").disableBreakStat());
		register(52, "mob_spawner", (new class_ajg()).setStrength(5.0F).setStepSound(STEP_SOUND_STONE3).setName("mobSpawner").disableBreakStat());
		register(53, "oak_stairs", (new class_ald(var1.getBlockData().set(class_ajw.a, class_ajw.class_a_in_class_ajw.a))).setName("stairsWood"));
		register(54, "chest", (new class_agu(0)).setStrength(2.5F).setStepSound(STEP_SOUND_WOOD).setName("chest"));
		register(55, "redstone_wire", (new class_akk()).setStrength(0.0F).setStepSound(STEP_SOUND_STONE1).setName("redstoneDust").disableBreakStat());
		register(56, "diamond_ore", (new class_aju()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreDiamond"));
		register(57, "diamond_block", (new Block(Material.ORE, MaterialMapColor.COLOR32)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockDiamond").a(CreativeTab.b));
		register(58, "crafting_table", (new class_ahc()).setStrength(2.5F).setStepSound(STEP_SOUND_WOOD).setName("workbench"));
		register(59, "wheat", (new class_ahd()).setName("crops"));
		Block var6 = (new class_ahy()).setStrength(0.6F).setStepSound(STEP_SOUND_GRAVEL).setName("farmland");
		register(60, "farmland", var6);
		register(61, "furnace", (new class_aih(false)).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setName("furnace").a(CreativeTab.c));
		register(62, "lit_furnace", (new class_aih(true)).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setLightLevel(0.875F).setName("furnace"));
		register(63, "standing_sign", (new class_ale()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("sign").disableBreakStat());
		register(64, "wooden_door", (new class_ahl(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorOak").disableBreakStat());
		register(65, "ladder", (new class_aiz()).setStrength(0.4F).setStepSound(STEP_SOUND_LADDER).setName("ladder"));
		register(66, "rail", (new class_akg()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("rail"));
		register(67, "stone_stairs", (new class_ald(var0.getBlockData())).setName("stairsStone"));
		register(68, "wall_sign", (new class_alw()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("sign").disableBreakStat());
		register(69, "lever", (new class_ajc()).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("lever"));
		register(70, "stone_pressure_plate", (new class_akb(Material.STONE, class_akb.class_a_in_class_akb.b)).setStrength(0.5F).setStepSound(STEP_SOUND_STONE2).setName("pressurePlateStone"));
		register(71, "iron_door", (new class_ahl(Material.ORE)).setStrength(5.0F).setStepSound(STEP_SOUND_STONE3).setName("doorIron").disableBreakStat());
		register(72, "wooden_pressure_plate", (new class_akb(Material.WOOD, class_akb.class_a_in_class_akb.a)).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("pressurePlateWood"));
		register(73, "redstone_ore", (new class_akj(false)).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreRedstone").a(CreativeTab.b));
		register(74, "lit_redstone_ore", (new class_akj(true)).setLightLevel(0.625F).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreRedstone"));
		register(75, "unlit_redstone_torch", (new class_akm(false)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("notGate"));
		register(76, "redstone_torch", (new class_akm(true)).setStrength(0.0F).setLightLevel(0.5F).setStepSound(STEP_SOUND_WOOD).setName("notGate").a(CreativeTab.d));
		register(77, "stone_button", (new class_alj()).setStrength(0.5F).setStepSound(STEP_SOUND_STONE2).setName("button"));
		register(78, "snow_layer", (new class_aky()).setStrength(0.1F).setStepSound(STEP_SOUND_SNOW).setName("snow").setLightOpacity(0));
		register(79, "ice", (new class_aix()).setStrength(0.5F).setLightOpacity(3).setStepSound(STEP_SOUND_STONE4).setName("ice"));
		register(80, "snow", (new class_akx()).setStrength(0.2F).setStepSound(STEP_SOUND_SNOW).setName("snow"));
		register(81, "cactus", (new class_agq()).setStrength(0.4F).setStepSound(STEP_SOUND_CLOTH).setName("cactus"));
		register(82, "clay", (new class_agx()).setStrength(0.6F).setStepSound(STEP_SOUND_GRAVEL).setName("clay"));
		register(83, "reeds", (new class_akn()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("reeds").disableBreakStat());
		register(84, "jukebox", (new class_aiy()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("jukebox"));
		register(85, "fence", (new class_ahz(Material.WOOD, class_ajw.class_a_in_class_ajw.a.c())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("fence"));
		Block var7 = (new class_akd()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("pumpkin");
		register(86, "pumpkin", var7);
		register(87, "netherrack", (new class_ajm()).setStrength(0.4F).setStepSound(STEP_SOUND_STONE2).setName("hellrock"));
		register(88, "soul_sand", (new class_akz()).setStrength(0.5F).setStepSound(STEP_SOUND_SAND).setName("hellsand"));
		register(89, "glowstone", (new class_aij(Material.SHATTERABLE)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setLightLevel(1.0F).setName("lightgem"));
		register(90, "portal", (new class_ajx()).setStrength(-1.0F).setStepSound(STEP_SOUND_STONE4).setLightLevel(0.75F).setName("portal"));
		register(91, "lit_pumpkin", (new class_akd()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setLightLevel(1.0F).setName("litpumpkin"));
		register(92, "cake", (new class_agr()).setStrength(0.5F).setStepSound(STEP_SOUND_CLOTH).setName("cake").disableBreakStat());
		register(93, "unpowered_repeater", (new class_ako(false)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("diode").disableBreakStat());
		register(94, "powered_repeater", (new class_ako(true)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("diode").disableBreakStat());
		register(95, "stained_glass", (new class_alb(Material.SHATTERABLE)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("stainedGlass"));
		register(96, "trapdoor", (new class_alr(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("trapdoor").disableBreakStat());
		register(97, "monster_egg", (new class_ajh()).setStrength(0.75F).setName("monsterStoneEgg"));
		Block var8 = (new class_ali()).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stonebricksmooth");
		register(98, "stonebrick", var8);
		register(99, "brown_mushroom_block", (new class_aiw(Material.WOOD, MaterialMapColor.COLOR11, var3)).setStrength(0.2F).setStepSound(STEP_SOUND_WOOD).setName("mushroom"));
		register(100, "red_mushroom_block", (new class_aiw(Material.WOOD, MaterialMapColor.COLOR29, var4)).setStrength(0.2F).setStepSound(STEP_SOUND_WOOD).setName("mushroom"));
		register(101, "iron_bars", (new class_aln(Material.ORE, true)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("fenceIron"));
		register(102, "glass_pane", (new class_aln(Material.SHATTERABLE, false)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("thinGlass"));
		Block var9 = (new class_ajf()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("melon");
		register(103, "melon_block", var9);
		register(104, "pumpkin_stem", (new class_alg(var7)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("pumpkinStem"));
		register(105, "melon_stem", (new class_alg(var9)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("pumpkinStem"));
		register(106, "vine", (new class_alu()).setStrength(0.2F).setStepSound(STEP_SOUND_GRASS).setName("vine"));
		register(107, "fence_gate", (new class_aia(class_ajw.class_a_in_class_ajw.a)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("fenceGate"));
		register(108, "brick_stairs", (new class_ald(var5.getBlockData())).setName("stairsBrick"));
		register(109, "stone_brick_stairs", (new class_ald(var8.getBlockData().set(class_ali.a, class_ali.class_a_in_class_ali.a))).setName("stairsStoneBrickSmooth"));
		register(110, "mycelium", (new class_ajj()).setStrength(0.6F).setStepSound(STEP_SOUND_GRASS).setName("mycel"));
		register(111, "waterlily", (new class_alx()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("waterlily"));
		Block var10 = (new class_ajk()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("netherBrick").a(CreativeTab.b);
		register(112, "nether_brick", var10);
		register(113, "nether_brick_fence", (new class_ahz(Material.STONE, MaterialMapColor.COLOR36)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("netherFence"));
		register(114, "nether_brick_stairs", (new class_ald(var10.getBlockData())).setName("stairsNetherBrick"));
		register(115, "nether_wart", (new class_ajl()).setName("netherStalk"));
		register(116, "enchanting_table", (new class_ahq()).setStrength(5.0F).setExplosionResist(2000.0F).setName("enchantmentTable"));
		register(117, "brewing_stand", (new class_agn()).setStrength(0.5F).setLightLevel(0.125F).setName("brewingStand"));
		register(118, "cauldron", (new class_agt()).setStrength(2.0F).setName("cauldron"));
		register(119, "end_portal", (new class_ahs(Material.PORTAL)).setStrength(-1.0F).setExplosionResist(6000000.0F));
		register(120, "end_portal_frame", (new class_aht()).setStepSound(STEP_SOUND_STONE4).setLightLevel(0.125F).setStrength(-1.0F).setName("endPortalFrame").setExplosionResist(6000000.0F).a(CreativeTab.c));
		register(121, "end_stone", (new Block(Material.STONE, MaterialMapColor.COLOR3)).setStrength(3.0F).setExplosionResist(15.0F).setStepSound(STEP_SOUND_STONE2).setName("whiteStone").a(CreativeTab.b));
		register(122, "dragon_egg", (new class_ahn()).setStrength(3.0F).setExplosionResist(15.0F).setStepSound(STEP_SOUND_STONE2).setLightLevel(0.125F).setName("dragonEgg"));
		register(123, "redstone_lamp", (new class_akl(false)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("redstoneLight").a(CreativeTab.d));
		register(124, "lit_redstone_lamp", (new class_akl(true)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("redstoneLight"));
		register(125, "double_wooden_slab", (new class_aig()).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("woodSlab"));
		register(126, "wooden_slab", (new class_air()).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("woodSlab"));
		register(127, "cocoa", (new class_agy()).setStrength(0.2F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("cocoa"));
		register(128, "sandstone_stairs", (new class_ald(var2.getBlockData().set(class_akr.a, class_akr.class_a_in_class_akr.c))).setName("stairsSandStone"));
		register(129, "emerald_ore", (new class_aju()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreEmerald"));
		register(130, "ender_chest", (new class_ahv()).setStrength(22.5F).setExplosionResist(1000.0F).setStepSound(STEP_SOUND_STONE2).setName("enderChest").setLightLevel(0.5F));
		register(131, "tripwire_hook", (new class_alt()).setName("tripWireSource"));
		register(132, "tripwire", (new class_als()).setName("tripWire"));
		register(133, "emerald_block", (new Block(Material.ORE, MaterialMapColor.COLOR34)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockEmerald").a(CreativeTab.b));
		register(134, "spruce_stairs", (new class_ald(var1.getBlockData().set(class_ajw.a, class_ajw.class_a_in_class_ajw.b))).setName("stairsWoodSpruce"));
		register(135, "birch_stairs", (new class_ald(var1.getBlockData().set(class_ajw.a, class_ajw.class_a_in_class_ajw.c))).setName("stairsWoodBirch"));
		register(136, "jungle_stairs", (new class_ald(var1.getBlockData().set(class_ajw.a, class_ajw.class_a_in_class_ajw.d))).setName("stairsWoodJungle"));
		register(137, "command_block", (new class_aha()).setUnbreakable().setExplosionResist(6000000.0F).setName("commandBlock"));
		register(138, "beacon", (new class_agg()).setName("beacon").setLightLevel(1.0F));
		register(139, "cobblestone_wall", (new class_alv(var0)).setName("cobbleWall"));
		register(140, "flower_pot", (new class_aid()).setStrength(0.0F).setStepSound(STEP_SOUND_STONE1).setName("flowerPot"));
		register(141, "carrots", (new class_ags()).setName("carrots"));
		register(142, "potatoes", (new class_ajy()).setName("potatoes"));
		register(143, "wooden_button", (new class_ama()).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("button"));
		register(144, "skull", (new class_akv()).setStrength(1.0F).setStepSound(STEP_SOUND_STONE2).setName("skull"));
		register(145, "anvil", (new class_aga()).setStrength(5.0F).setStepSound(STEP_SOUND_ANVIL).setExplosionResist(2000.0F).setName("anvil"));
		register(146, "trapped_chest", (new class_agu(1)).setStrength(2.5F).setStepSound(STEP_SOUND_WOOD).setName("chestTrap"));
		register(147, "light_weighted_pressure_plate", (new class_alz(Material.ORE, 15, MaterialMapColor.COLOR31)).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("weightedPlate_light"));
		register(148, "heavy_weighted_pressure_plate", (new class_alz(Material.ORE, 150)).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("weightedPlate_heavy"));
		register(149, "unpowered_comparator", (new class_ahb(false)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("comparator").disableBreakStat());
		register(150, "powered_comparator", (new class_ahb(true)).setStrength(0.0F).setLightLevel(0.625F).setStepSound(STEP_SOUND_WOOD).setName("comparator").disableBreakStat());
		register(151, "daylight_detector", new class_ahe(false));
		register(152, "redstone_block", (new class_ajz(Material.ORE, MaterialMapColor.COLOR5)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockRedstone").a(CreativeTab.d));
		register(153, "quartz_ore", (new class_aju(MaterialMapColor.COLOR36)).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("netherquartz"));
		register(154, "hopper", (new class_aiu()).setStrength(3.0F).setExplosionResist(8.0F).setStepSound(STEP_SOUND_STONE3).setName("hopper"));
		Block var11 = (new class_akf()).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setName("quartzBlock");
		register(155, "quartz_block", var11);
		register(156, "quartz_stairs", (new class_ald(var11.getBlockData().set(class_akf.a, class_akf.class_a_in_class_akf.a))).setName("stairsQuartz"));
		register(157, "activator_rail", (new class_aka()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("activatorRail"));
		register(158, "dropper", (new class_aho()).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setName("dropper"));
		register(159, "stained_hardened_clay", (new class_agz(Material.STONE)).setStrength(1.25F).setExplosionResist(7.0F).setStepSound(STEP_SOUND_STONE2).setName("clayHardenedStained"));
		register(160, "stained_glass_pane", (new class_alc()).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("thinStainedGlass"));
		register(161, "leaves2", (new class_ajn()).setName("leaves"));
		register(162, "log2", (new class_ajo()).setName("log"));
		register(163, "acacia_stairs", (new class_ald(var1.getBlockData().set(class_ajw.a, class_ajw.class_a_in_class_ajw.e))).setName("stairsWoodAcacia"));
		register(164, "dark_oak_stairs", (new class_ald(var1.getBlockData().set(class_ajw.a, class_ajw.class_a_in_class_ajw.f))).setName("stairsWoodDarkOak"));
		register(165, "slime", (new class_akw()).setName("slime").setStepSound(STEP_SOUND_SLIME));
		register(166, "barrier", (new class_agc()).setName("barrier"));
		register(167, "iron_trapdoor", (new class_alr(Material.ORE)).setStrength(5.0F).setStepSound(STEP_SOUND_STONE3).setName("ironTrapdoor").disableBreakStat());
		register(168, "prismarine", (new class_akc()).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("prismarine"));
		register(169, "sea_lantern", (new class_akt(Material.SHATTERABLE)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setLightLevel(1.0F).setName("seaLantern"));
		register(170, "hay_block", (new class_ait()).setStrength(0.5F).setStepSound(STEP_SOUND_GRASS).setName("hayBlock").a(CreativeTab.b));
		register(171, "carpet", (new class_amc()).setStrength(0.1F).setStepSound(STEP_SOUND_CLOTH).setName("woolCarpet").setLightOpacity(0));
		register(172, "hardened_clay", (new class_ais()).setStrength(1.25F).setExplosionResist(7.0F).setStepSound(STEP_SOUND_STONE2).setName("clayHardened"));
		register(173, "coal_block", (new Block(Material.STONE, MaterialMapColor.COLOR30)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("blockCoal").a(CreativeTab.b));
		register(174, "packed_ice", (new class_ajv()).setStrength(0.5F).setStepSound(STEP_SOUND_STONE4).setName("icePacked"));
		register(175, "double_plant", new class_ahm());
		register(176, "standing_banner", (new class_agb.class_a_in_class_agb()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("banner").disableBreakStat());
		register(177, "wall_banner", (new class_agb.class_b_in_class_agb()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("banner").disableBreakStat());
		register(178, "daylight_detector_inverted", new class_ahe(true));
		Block var12 = (new class_aki()).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setName("redSandStone");
		register(179, "red_sandstone", var12);
		register(180, "red_sandstone_stairs", (new class_ald(var12.getBlockData().set(class_aki.a, class_aki.class_a_in_class_aki.c))).setName("stairsRedSandStone"));
		register(181, "double_stone_slab2", (new class_aie()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab2"));
		register(182, "stone_slab2", (new class_ain()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab2"));
		register(183, "spruce_fence_gate", (new class_aia(class_ajw.class_a_in_class_ajw.b)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("spruceFenceGate"));
		register(184, "birch_fence_gate", (new class_aia(class_ajw.class_a_in_class_ajw.c)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("birchFenceGate"));
		register(185, "jungle_fence_gate", (new class_aia(class_ajw.class_a_in_class_ajw.d)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("jungleFenceGate"));
		register(186, "dark_oak_fence_gate", (new class_aia(class_ajw.class_a_in_class_ajw.f)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("darkOakFenceGate"));
		register(187, "acacia_fence_gate", (new class_aia(class_ajw.class_a_in_class_ajw.e)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("acaciaFenceGate"));
		register(188, "spruce_fence", (new class_ahz(Material.WOOD, class_ajw.class_a_in_class_ajw.b.c())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("spruceFence"));
		register(189, "birch_fence", (new class_ahz(Material.WOOD, class_ajw.class_a_in_class_ajw.c.c())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("birchFence"));
		register(190, "jungle_fence", (new class_ahz(Material.WOOD, class_ajw.class_a_in_class_ajw.d.c())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("jungleFence"));
		register(191, "dark_oak_fence", (new class_ahz(Material.WOOD, class_ajw.class_a_in_class_ajw.f.c())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("darkOakFence"));
		register(192, "acacia_fence", (new class_ahz(Material.WOOD, class_ajw.class_a_in_class_ajw.e.c())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("acaciaFence"));
		register(193, "spruce_door", (new class_ahl(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorSpruce").disableBreakStat());
		register(194, "birch_door", (new class_ahl(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorBirch").disableBreakStat());
		register(195, "jungle_door", (new class_ahl(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorJungle").disableBreakStat());
		register(196, "acacia_door", (new class_ahl(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorAcacia").disableBreakStat());
		register(197, "dark_oak_door", (new class_ahl(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorDarkOak").disableBreakStat());
		register(198, "end_rod", (new class_ahu()).setStrength(0.0F).setLightLevel(0.9375F).setStepSound(STEP_SOUND_WOOD).setName("endRod"));
		register(199, "chorus_plant", (new class_agw()).setStrength(0.4F).setStepSound(STEP_SOUND_WOOD).setName("chorusPlant"));
		register(200, "chorus_flower", (new class_agv()).setStrength(0.4F).setStepSound(STEP_SOUND_WOOD).setName("chorusFlower"));
		Block var13 = (new Block(Material.STONE)).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).a(CreativeTab.b).setName("purpurBlock");
		register(201, "purpur_block", var13);
		register(202, "purpur_pillar", (new class_akp(Material.STONE)).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).a(CreativeTab.b).setName("purpurPillar"));
		register(203, "purpur_stairs", (new class_ald(var13.getBlockData())).setName("stairsPurpur"));
		register(204, "purpur_double_slab", (new class_ake.class_a_in_class_ake()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("purpurSlab"));
		register(205, "purpur_slab", (new class_ake.class_b_in_class_ake()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("purpurSlab"));
		register(206, "end_bricks", (new Block(Material.STONE)).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).a(CreativeTab.b).setName("endBricks"));
		register(207, "beetroots", (new class_agi()).setName("beetroots"));
		Block var14 = (new class_ail()).setStrength(0.65F).setStepSound(STEP_SOUND_GRASS).setName("grassPath").disableBreakStat();
		register(208, "grass_path", var14);
		register(209, "end_gateway", (new class_ahr(Material.PORTAL)).setStrength(-1.0F).setExplosionResist(6000000.0F));
		register(255, "structure_block", (new class_all()).setUnbreakable().setExplosionResist(6000000.0F).setName("structureBlock").setLightLevel(1.0F));
		BLOCK_REGISTRY.checkValid();
		Iterator<?> var15 = BLOCK_REGISTRY.iterator();

		while (true) {
			Block var16;
			while (var15.hasNext()) {
				var16 = (Block) var15.next();
				if (var16.material == Material.AIR) {
					var16.useNeighborBrightness = false;
				} else {
					boolean var17 = false;
					boolean var18 = var16 instanceof class_ald;
					boolean var19 = var16 instanceof class_aio;
					boolean var20 = var16 == var6 || var16 == var14;
					boolean var21 = var16.translucent;
					boolean var22 = var16.lightOpacity == 0;
					if (var18 || var19 || var20 || var21 || var22) {
						var17 = true;
					}

					var16.useNeighborBrightness = var17;
				}
			}

			var15 = BLOCK_REGISTRY.iterator();

			while (var15.hasNext()) {
				var16 = (Block) var15.next();
				Iterator<?> var23 = var16.getBlockStateList().a().iterator();

				while (var23.hasNext()) {
					IBlockData var24 = (IBlockData) var23.next();
					int var25 = BLOCK_REGISTRY.getId(var16) << 4 | var16.toLegacyData(var24);
					BLOCKDATA_REGISTRY.regiter(var24, var25);
				}
			}

			return;
		}
	}

	private static void register(int id, MinecraftKey key, Block block) {
		BLOCK_REGISTRY.register(id, key, block);
	}

	private static void register(int id, String name, Block block) {
		register(id, new MinecraftKey(name), block);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_agj.values().length];

		static {
			try {
				b[Block.class_a_in_class_agj.b.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[Block.class_a_in_class_agj.c.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			a = new int[Block.class_c_in_class_agj.values().length];

			try {
				a[Block.class_c_in_class_agj.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[Block.class_c_in_class_agj.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_agj.c.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_agj.d.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static class StepSound {
		public final String a;
		public final float b;
		public final float c;

		public StepSound(String var1, float var2, float var3) {
			this.a = var1;
			this.b = var2;
			this.c = var3;
		}

		public float d() {
			return this.b;
		}

		public float e() {
			return this.c;
		}

		public String a() {
			return "dig." + this.a;
		}

		public String c() {
			return "step." + this.a;
		}

		public String b() {
			return this.a();
		}
	}

	public static enum class_a_in_class_agj {
		a, b, c;

		public int a(int var1, int var2) {
			int var3 = var2 / 2;
			int var4 = var1 > var3 ? var1 - var2 : var1;
			switch (Block.SyntheticClass_1.b[this.ordinal()]) {
				case 1:
					return (var2 - var4) % var2;
				case 2:
					return (var3 - var4 + var2) % var2;
				default:
					return var1;
			}
		}

		public Block.class_c_in_class_agj a(EnumDirection var1) {
			EnumDirection.EnumAxis var2 = var1.getAxis();
			return (this != b || var2 != EnumDirection.EnumAxis.Z) && (this != c || var2 != EnumDirection.EnumAxis.X) ? Block.class_c_in_class_agj.a : Block.class_c_in_class_agj.c;
		}

		public EnumDirection b(EnumDirection var1) {
			switch (Block.SyntheticClass_1.b[this.ordinal()]) {
				case 1:
					if (var1 == EnumDirection.WEST) {
						return EnumDirection.EAST;
					} else {
						if (var1 == EnumDirection.EAST) {
							return EnumDirection.WEST;
						}

						return var1;
					}
				case 2:
					if (var1 == EnumDirection.NORTH) {
						return EnumDirection.SOUTH;
					} else {
						if (var1 == EnumDirection.SOUTH) {
							return EnumDirection.NORTH;
						}

						return var1;
					}
				default:
					return var1;
			}
		}
	}

	public static enum class_c_in_class_agj {
		a, b, c, d;

		public Block.class_c_in_class_agj a(Block.class_c_in_class_agj var1) {
			switch (Block.SyntheticClass_1.a[var1.ordinal()]) {
				case 3:
					switch (Block.SyntheticClass_1.a[this.ordinal()]) {
						case 1:
							return c;
						case 2:
							return d;
						case 3:
							return a;
						case 4:
							return b;
					}
				case 4:
					switch (Block.SyntheticClass_1.a[this.ordinal()]) {
						case 1:
							return d;
						case 2:
							return a;
						case 3:
							return b;
						case 4:
							return c;
					}
				case 2:
					switch (Block.SyntheticClass_1.a[this.ordinal()]) {
						case 1:
							return b;
						case 2:
							return c;
						case 3:
							return d;
						case 4:
							return a;
					}
				default:
					return this;
			}
		}

		public EnumDirection a(EnumDirection var1) {
			if (var1.getAxis() == EnumDirection.EnumAxis.Y) {
				return var1;
			} else {
				switch (Block.SyntheticClass_1.a[this.ordinal()]) {
					case 2:
						return var1.rotateY();
					case 3:
						return var1.getOpposite();
					case 4:
						return var1.rotateYCCW();
					default:
						return var1;
				}
			}
		}

		public int a(int var1, int var2) {
			switch (Block.SyntheticClass_1.a[this.ordinal()]) {
				case 2:
					return (var1 + var2 / 4) % var2;
				case 3:
					return (var1 + var2 / 2) % var2;
				case 4:
					return (var1 + var2 * 3 / 4) % var2;
				default:
					return var1;
			}
		}
	}
}
