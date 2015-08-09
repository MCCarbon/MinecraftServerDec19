package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Block {

	private static final MinecraftKey AIR_KEY = new MinecraftKey("air");
	public static final RegistryBlocks<MinecraftKey, Block> BLOCK_REGISTRY = new RegistryBlocks<MinecraftKey, Block>(AIR_KEY);
	public static final RegistryID<IBlockData> BLOCKDATA_REGISTRY = new RegistryID<IBlockData>();
	public static final Block.Sound STEP_SOUND_STONE1 = new Block.Sound("stone", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_WOOD = new Block.Sound("wood", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_GRAVEL = new Block.Sound("gravel", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_GRASS = new Block.Sound("grass", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_STONE2 = new Block.Sound("stone", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_STONE3 = new Block.Sound("stone", 1.0F, 1.5F);
	public static final Block.Sound STEP_SOUND_STONE4 = new Block.Sound("stone", 1.0F, 1.0F) {
		@Override
		public String getBreakSound() {
			return "dig.glass";
		}

		@Override
		public String getPlaceSound() {
			return "step.stone";
		}
	};
	public static final Block.Sound STEP_SOUND_CLOTH = new Block.Sound("cloth", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_SAND = new Block.Sound("sand", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_SNOW = new Block.Sound("snow", 1.0F, 1.0F);
	public static final Block.Sound STEP_SOUND_LADDER = new Block.Sound("ladder", 1.0F, 1.0F) {
		@Override
		public String getBreakSound() {
			return "dig.wood";
		}
	};
	public static final Block.Sound STEP_SOUND_ANVIL = new Block.Sound("anvil", 0.3F, 1.0F) {
		@Override
		public String getBreakSound() {
			return "dig.stone";
		}

		@Override
		public String getPlaceSound() {
			return "random.anvil_land";
		}
	};
	public static final Block.Sound STEP_SOUND_SLIME = new Block.Sound("slime", 1.0F, 1.0F) {
		@Override
		public String getBreakSound() {
			return "mob.slime.big";
		}

		@Override
		public String getPlaceSound() {
			return "mob.slime.big";
		}

		@Override
		public String getStepSound() {
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
	public Block.Sound stepSound;
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
		int data = (combinedId >> 12) & 15;
		return getById(id).fromLegacyData(data);
	}

	public static Block getByItem(Item item) {
		return item instanceof ItemBlock ? ((ItemBlock) item).getBlock() : null;
	}

	public static Block getByName(String name) {
		MinecraftKey key = new MinecraftKey(name);
		if (BLOCK_REGISTRY.has(key)) {
			return BLOCK_REGISTRY.get(key);
		} else {
			try {
				return BLOCK_REGISTRY.get(Integer.parseInt(name));
			} catch (NumberFormatException e) {
				return null;
			}
		}
	}

	public Block(Material material, MaterialMapColor mapcolor) {
		useBreakStat = true;
		stepSound = STEP_SOUND_STONE1;
		frictionFactor = 0.6F;
		this.material = material;
		this.mapcolor = mapcolor;
		setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		isFullBlock = isOpaqueCube();
		lightOpacity = isOpaqueCube() ? 255 : 0;
		translucent = !material.blocksLight();
		blockStateList = getStateList();
		setBlockData(blockStateList.getFirst());
	}

	protected Block(Material material) {
		this(material, material.getMapColor());
	}

	public boolean isFullBlock() {
		return isFullBlock;
	}

	public int getLightOpacity() {
		return lightOpacity;
	}

	public int getLightLevel() {
		return lightLevel;
	}

	public boolean useNeighborBrightness() {
		return useNeighborBrightness;
	}

	public Material getMaterial() {
		return material;
	}

	public MaterialMapColor getMapColor(IBlockData data) {
		return mapcolor;
	}

	public IBlockData fromLegacyData(int data) {
		return getBlockData();
	}

	public int toLegacyData(IBlockData blockdata) {
		if ((blockdata != null) && !blockdata.getStates().isEmpty()) {
			throw new IllegalArgumentException("Don\'t know how to convert " + blockdata + " back into data...");
		} else {
			return 0;
		}
	}

	public IBlockData updateState(IBlockData data, IBlockAccess access, BlockPosition position) {
		return data;
	}

	public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
		return var1;
	}

	public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
		return var1;
	}

	protected Block setStepSound(Block.Sound stepSound) {
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
		return material.isSolid() && isFullCube();
	}

	public boolean isOccluding() {
		return material.isOpaque() && isFullCube() && !isPowerSource();
	}

	public boolean isVisuallyOpaque() {
		return material.isSolid() && isFullCube();
	}

	public boolean isFullCube() {
		return true;
	}

	public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
		return !material.isSolid();
	}

	public int getRenderType() {
		return 3;
	}

	public boolean isReplaceable(World world, BlockPosition var2) {
		return false;
	}

	protected Block setStrength(float strength) {
		this.strength = strength;
		if (explosionResist < (strength * 5.0F)) {
			explosionResist = strength * 5.0F;
		}
		return this;
	}

	protected Block setUnbreakable() {
		setStrength(-1.0F);
		return this;
	}

	public float getStrength(World world, BlockPosition var2) {
		return strength;
	}

	protected Block setTicking(boolean isTicking) {
		this.isTicking = isTicking;
		return this;
	}

	public boolean isTicking() {
		return isTicking;
	}

	public boolean isTileEntity() {
		return isTileEntity;
	}

	protected final void setSizes(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public boolean isBuildable(IBlockAccess access, BlockPosition position, EnumDirection face) {
		return access.getType(position).getBlock().getMaterial().isBuildable();
	}

	public void addBBIfInsideInputBB(World world, BlockPosition position, IBlockData blodata, AxisAlignedBB bigBB, List<AxisAlignedBB> list, Entity entity) {
		AxisAlignedBB bb = getBoundingBox(world, position, blodata);
		if ((bb != null) && bigBB.isInside(bb)) {
			list.add(bb);
		}
	}

	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		return new AxisAlignedBB(var2.getX() + minX, var2.getY() + minY, var2.getZ() + minZ, var2.getX() + maxX, var2.getY() + maxY, var2.getZ() + maxZ);
	}

	public boolean isOpaqueCube() {
		return true;
	}

	public boolean canCollide(IBlockData data, boolean var2) {
		return isCollidable();
	}

	public boolean isCollidable() {
		return true;
	}

	public void randomTick(World world, BlockPosition position, IBlockData blockdata, Random random) {
		tick(world, position, blockdata, random);
	}

	public void tick(World world, BlockPosition position, IBlockData blockdata, Random random) {
	}

	public void postBreak(World world, BlockPosition position, IBlockData blockdata) {
	}

	public void doPhysics(World world, BlockPosition position, IBlockData blockdata, Block block) {
	}

	public int tickInterval(World world) {
		return 10;
	}

	public void onPlace(World world, BlockPosition position, IBlockData blockdata) {
	}

	public void remove(World world, BlockPosition position, IBlockData blockdata) {
	}

	public int getDropCount(Random rnd) {
		return 1;
	}

	public Item getDropType(IBlockData blockdata, Random random, int var3) {
		return Item.getItemOf(this);
	}

	public float getDamage(EntityHuman player, World world, BlockPosition position) {
		float strength = getStrength(world, position);
		return strength < 0.0F ? 0.0F : (!player.b(this) ? player.a(this) / strength / 100.0F : player.a(this) / strength / 30.0F);
	}

	public final void dropNaturallyForSure(World world, BlockPosition position, IBlockData blockdata, int fortuneEnchLevel) {
		dropNaturally(world, position, blockdata, 1.0F, fortuneEnchLevel);
	}

	public void dropNaturally(World world, BlockPosition position, IBlockData blockdata, float change, int fortuneEnchLevel) {
		if (!world.isClientSide) {
			int count = getDropCount(fortuneEnchLevel, world.random);
			for (int i = 0; i < count; ++i) {
				if (world.random.nextFloat() <= change) {
					Item item = getDropType(blockdata, world.random, fortuneEnchLevel);
					if (item != null) {
						dropItem(world, position, new ItemStack(item, 1, getDropData(blockdata)));
					}
				}
			}
		}
	}

	public static void dropItem(World world, BlockPosition position, ItemStack itemstack) {
		if (!world.isClientSide && world.R().getBooleanValue("doTileDrops")) {
			float centerAdd = 0.5F;
			double addX = (world.random.nextFloat() * centerAdd) + ((1.0F - centerAdd) * 0.5D);
			double addY = (world.random.nextFloat() * centerAdd) + ((1.0F - centerAdd) * 0.5D);
			double addZ = (world.random.nextFloat() * centerAdd) + ((1.0F - centerAdd) * 0.5D);
			EntityItem item = new EntityItem(world, position.getX() + addX, position.getY() + addY, position.getZ() + addZ, itemstack);
			item.setPickupDelay();
			world.addEntity(item);
		}
	}

	protected void dropExperience(World world, BlockPosition blockposition, int amount) {
		if (!world.isClientSide) {
			while (amount > 0) {
				int orbvalue = EntityExperienceOrb.getOrbValue(amount);
				amount -= orbvalue;
				world.addEntity((new EntityExperienceOrb(world, blockposition.getX() + 0.5D, blockposition.getY() + 0.5D, blockposition.getZ() + 0.5D, orbvalue)));
			}
		}
	}

	public int getDropData(IBlockData blockdata) {
		return 0;
	}

	public float getResistance(Entity entity) {
		return explosionResist / 5.0F;
	}

	public MovingObjectPosition rayTraceCollision(World world, BlockPosition position, Vec3D start, Vec3D end) {
		updateShape(world, position);
		start = start.add((-position.getX()), (-position.getY()), (-position.getZ()));
		end = end.add((-position.getX()), (-position.getY()), (-position.getZ()));
		Vec3D var5 = start.getIntermediateWithXValue(end, minX);
		Vec3D var6 = start.getIntermediateWithXValue(end, maxX);
		Vec3D var7 = start.getIntermediateWithYValue(end, minY);
		Vec3D var8 = start.getIntermediateWithYValue(end, maxY);
		Vec3D var9 = start.getIntermediateWithZValue(end, minZ);
		Vec3D var10 = start.getIntermediateWithZValue(end, maxZ);
		if (!isVecInsideYZBounds(var5)) {
			var5 = null;
		}

		if (!isVecInsideYZBounds(var6)) {
			var6 = null;
		}

		if (!isVecInsideXZBounds(var7)) {
			var7 = null;
		}

		if (!isVecInsideXZBounds(var8)) {
			var8 = null;
		}

		if (!isVecInsideXYBounds(var9)) {
			var9 = null;
		}

		if (!isVecInsideXYBounds(var10)) {
			var10 = null;
		}

		Vec3D var11 = null;
		if ((var5 != null) && ((var11 == null) || (start.distanceSquared(var5) < start.distanceSquared(var11)))) {
			var11 = var5;
		}

		if ((var6 != null) && ((var11 == null) || (start.distanceSquared(var6) < start.distanceSquared(var11)))) {
			var11 = var6;
		}

		if ((var7 != null) && ((var11 == null) || (start.distanceSquared(var7) < start.distanceSquared(var11)))) {
			var11 = var7;
		}

		if ((var8 != null) && ((var11 == null) || (start.distanceSquared(var8) < start.distanceSquared(var11)))) {
			var11 = var8;
		}

		if ((var9 != null) && ((var11 == null) || (start.distanceSquared(var9) < start.distanceSquared(var11)))) {
			var11 = var9;
		}

		if ((var10 != null) && ((var11 == null) || (start.distanceSquared(var10) < start.distanceSquared(var11)))) {
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

			return new MovingObjectPosition(var11.add(position.getX(), position.getY(), position.getZ()), var12, position);
		}
	}

	private boolean isVecInsideYZBounds(Vec3D vec) {
		return vec == null ? false : (vec.y >= minY) && (vec.y <= maxY) && (vec.z >= minZ) && (vec.z <= maxZ);
	}

	private boolean isVecInsideXZBounds(Vec3D vec) {
		return vec == null ? false : (vec.x >= minX) && (vec.x <= maxX) && (vec.z >= minZ) && (vec.z <= maxZ);
	}

	private boolean isVecInsideXYBounds(Vec3D vec) {
		return vec == null ? false : (vec.x >= minX) && (vec.x <= maxX) && (vec.y >= minY) && (vec.y <= maxY);
	}

	public void wasExploded(World world, BlockPosition position, Explosion explosion) {
	}

	public boolean canPlace(World world, BlockPosition position, EnumDirection direction, ItemStack itemstack) {
		return this.canPlace(world, position, direction);
	}

	public boolean canPlace(World wolrd, BlockPosition position, EnumDirection direction) {
		return canPlace(wolrd, position);
	}

	public boolean canPlace(World world, BlockPosition position) {
		return world.getType(position).getBlock().material.isReplaceable();
	}

	public boolean interact(World world, BlockPosition position, IBlockData blockdata, EntityHuman human, EnumUsedHand hand, ItemStack itemstack, EnumDirection face, float cX, float cY, float cZ) {
		return false;
	}

	public void onCollide(World world, BlockPosition position, Entity entity) {
	}

	public IBlockData getPlacedState(World world, BlockPosition position, EnumDirection face, float cX, float cY, float cZ, int meta, EntityLiving entity) {
		return fromLegacyData(meta);
	}

	public void attack(World world, BlockPosition position, EntityHuman player) {
	}

	public Vec3D modifyVelocity(World world, BlockPosition position, Entity entity, Vec3D vector) {
		return vector;
	}

	public void updateShape(IBlockAccess var1, BlockPosition var2) {
	}

	public final double getMinX() {
		return minX;
	}

	public final double getMaxX() {
		return maxX;
	}

	public final double getMinY() {
		return minY;
	}

	public final double getMaxY() {
		return maxY;
	}

	public final double getMinZ() {
		return minZ;
	}

	public final double getMaxZ() {
		return maxZ;
	}

	public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
		return 0;
	}

	public boolean isPowerSource() {
		return false;
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
	}

	public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
		return 0;
	}

	public void j() {
	}

	public void breakBlockNaturally(World world, EntityHuman entityhuman, BlockPosition blockposition, IBlockData iblockdata, TileEntity te, ItemStack itemstack) {
		entityhuman.b(StatisticList.ab[getId(this)]);
		entityhuman.a(0.025F);
		if (canApplySilkTouch() && (EnchantmentManager.getLevel(RegistryEnchantments.q, itemstack) > 0)) {
			ItemStack drop = createItemStack(iblockdata);
			if (drop != null) {
				dropItem(world, blockposition, drop);
			}
		} else {
			int fortuneLevel = EnchantmentManager.getLevel(RegistryEnchantments.s, itemstack);
			dropNaturallyForSure(world, blockposition, iblockdata, fortuneLevel);
		}
	}

	protected boolean canApplySilkTouch() {
		return isFullCube() && !isTileEntity;
	}

	protected ItemStack createItemStack(IBlockData blockdata) {
		int data = 0;
		Item item = Item.getItemOf(this);
		if ((item != null) && item.usesData()) {
			data = toLegacyData(blockdata);
		}
		return new ItemStack(item, 1, data);
	}

	public int getDropCount(int fortuneEnchLevel, Random rnd) {
		return this.getDropCount(rnd);
	}

	public void postPlace(World world, BlockPosition blockposition, IBlockData blockdata, EntityLiving entity, ItemStack itemstack) {
	}

	public boolean g() {
		return !material.isBuildable() && !material.isLiquid();
	}

	public Block setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return LocaleI18n.get(getInternalName() + ".name");
	}

	public String getInternalName() {
		return "tile." + name;
	}

	public boolean a(World var1, BlockPosition var2, IBlockData var3, int var4, int var5) {
		return false;
	}

	public boolean useBreakStat() {
		return useBreakStat;
	}

	protected Block disableBreakStat() {
		useBreakStat = false;
		return this;
	}

	public int getPushReaction() {
		return material.getPushReaction();
	}

	public void fallOn(World world, BlockPosition blockposition, Entity entity, float dist) {
		entity.e(dist, 1.0F);
	}

	public void landOn(World world, Entity entity) {
		entity.motY = 0.0D;
	}

	public int getDropData(World wolrd, BlockPosition position) {
		return getDropData(wolrd.getType(position));
	}

	public Block setCreativeTab(CreativeTab tab) {
		return this;
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
	}

	public void rainTick(World world, BlockPosition position) {
	}

	public boolean P() {
		return true;
	}

	public boolean dropsFromExplosion(Explosion explosion) {
		return true;
	}

	public boolean b(Block var1) {
		return this == var1;
	}

	public static boolean a(Block var0, Block var1) {
		return (var0 != null) && (var1 != null) ? (var0 == var1 ? true : var0.b(var1)) : false;
	}

	public boolean isComplexRedstone() {
		return false;
	}

	public int getRedstonePower(World world, BlockPosition position) {
		return 0;
	}

	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[0]);
	}

	public BlockStateList getBlockStateList() {
		return blockStateList;
	}

	protected final void setBlockData(IBlockData blockdata) {
		blockData = blockdata;
	}

	public final IBlockData getBlockData() {
		return blockData;
	}

	@Override
	public String toString() {
		return "Block{" + BLOCK_REGISTRY.getKey(this) + "}";
	}

	public static void init() {
		register(0, AIR_KEY, (new BlockAir()).setName("air"));
		register(1, "stone", (new BlockStone()).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stone"));
		register(2, "grass", (new BlockGrass()).setStrength(0.6F).setStepSound(STEP_SOUND_GRASS).setName("grass"));
		register(3, "dirt", (new BlockDirt()).setStrength(0.5F).setStepSound(STEP_SOUND_GRAVEL).setName("dirt"));
		Block cobble = (new Block(Material.STONE)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stonebrick").setCreativeTab(CreativeTab.BUILDING_BLOCKS);
		register(4, "cobblestone", cobble);
		Block wood = (new BlockWood()).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("wood");
		register(5, "planks", wood);
		register(6, "sapling", (new BlockSapling()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("sapling"));
		register(7, "bedrock", (new Block(Material.STONE)).setUnbreakable().setExplosionResist(6000000.0F).setStepSound(STEP_SOUND_STONE2).setName("bedrock").disableBreakStat().setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(8, "flowing_water", (new BlockFlowing(Material.WATER)).setStrength(100.0F).setLightOpacity(3).setName("water").disableBreakStat());
		register(9, "water", (new BlockStationary(Material.WATER)).setStrength(100.0F).setLightOpacity(3).setName("water").disableBreakStat());
		register(10, "flowing_lava", (new BlockFlowing(Material.LAVA)).setStrength(100.0F).setLightLevel(1.0F).setName("lava").disableBreakStat());
		register(11, "lava", (new BlockStationary(Material.LAVA)).setStrength(100.0F).setLightLevel(1.0F).setName("lava").disableBreakStat());
		register(12, "sand", (new BlockSand()).setStrength(0.5F).setStepSound(STEP_SOUND_SAND).setName("sand"));
		register(13, "gravel", (new BlockGravel()).setStrength(0.6F).setStepSound(STEP_SOUND_GRAVEL).setName("gravel"));
		register(14, "gold_ore", (new BlockOre()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreGold"));
		register(15, "iron_ore", (new BlockOre()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreIron"));
		register(16, "coal_ore", (new BlockOre()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreCoal"));
		register(17, "log", (new BlockLog1()).setName("log"));
		register(18, "leaves", (new BlockLeaves1()).setName("leaves"));
		register(19, "sponge", (new BlockSponge()).setStrength(0.6F).setStepSound(STEP_SOUND_GRASS).setName("sponge"));
		register(20, "glass", (new BlockGlass(Material.SHATTERABLE, false)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("glass"));
		register(21, "lapis_ore", (new BlockOre()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreLapis"));
		register(22, "lapis_block", (new Block(Material.ORE, MaterialMapColor.COLOR33)).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("blockLapis").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(23, "dispenser", (new BlockDispenser()).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setName("dispenser"));
		Block sandstone = (new BlockSandStone()).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setName("sandStone");
		register(24, "sandstone", sandstone);
		register(25, "noteblock", (new BlockNote()).setStrength(0.8F).setName("musicBlock"));
		register(26, "bed", (new BlockBed()).setStepSound(STEP_SOUND_WOOD).setStrength(0.2F).setName("bed").disableBreakStat());
		register(27, "golden_rail", (new BlockPoweredRail()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("goldenRail"));
		register(28, "detector_rail", (new BlockMinecartDetector()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("detectorRail"));
		register(29, "sticky_piston", (new BlockPiston(true)).setName("pistonStickyBase"));
		register(30, "web", (new BlockWeb()).setLightOpacity(1).setStrength(4.0F).setName("web"));
		register(31, "tallgrass", (new BlockLongGrass()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("tallgrass"));
		register(32, "deadbush", (new BlockDeadBush()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("deadbush"));
		register(33, "piston", (new BlockPiston(false)).setName("pistonBase"));
		register(34, "piston_head", (new BlockPistonExtension()).setName("pistonBase"));
		register(35, "wool", (new BlockCloth(Material.CLOTH)).setStrength(0.8F).setStepSound(STEP_SOUND_CLOTH).setName("cloth"));
		register(36, "piston_extension", new BlockPistonMoving());
		register(37, "yellow_flower", (new BlockYellowFlowers()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("flower1"));
		register(38, "red_flower", (new BlockRedFlowers()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("flower2"));
		Block brown_mush = (new BlockMushroom()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setLightLevel(0.125F).setName("mushroom");
		register(39, "brown_mushroom", brown_mush);
		Block red_mush = (new BlockMushroom()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("mushroom");
		register(40, "red_mushroom", red_mush);
		register(41, "gold_block", (new Block(Material.ORE, MaterialMapColor.COLOR31)).setStrength(3.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockGold").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(42, "iron_block", (new Block(Material.ORE, MaterialMapColor.COLOR7)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockIron").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(43, "double_stone_slab", (new BlockDoubleStep()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab"));
		register(44, "stone_slab", (new BlockStep()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab"));
		Block brick = (new Block(Material.STONE, MaterialMapColor.COLOR29)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("brick").setCreativeTab(CreativeTab.BUILDING_BLOCKS);
		register(45, "brick_block", brick);
		register(46, "tnt", (new BlockTNT()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("tnt"));
		register(47, "bookshelf", (new BlockBookshelf()).setStrength(1.5F).setStepSound(STEP_SOUND_WOOD).setName("bookshelf"));
		register(48, "mossy_cobblestone", (new Block(Material.STONE)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneMoss").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(49, "obsidian", (new BlockObsidian()).setStrength(50.0F).setExplosionResist(2000.0F).setStepSound(STEP_SOUND_STONE2).setName("obsidian"));
		register(50, "torch", (new BlockTorch()).setStrength(0.0F).setLightLevel(0.9375F).setStepSound(STEP_SOUND_WOOD).setName("torch"));
		register(51, "fire", (new BlockFire()).setStrength(0.0F).setLightLevel(1.0F).setStepSound(STEP_SOUND_CLOTH).setName("fire").disableBreakStat());
		register(52, "mob_spawner", (new BlockMobSpawner()).setStrength(5.0F).setStepSound(STEP_SOUND_STONE3).setName("mobSpawner").disableBreakStat());
		register(53, "oak_stairs", (new BlockStairs(wood.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.OAK))).setName("stairsWood"));
		register(54, "chest", (new BlockChest(0)).setStrength(2.5F).setStepSound(STEP_SOUND_WOOD).setName("chest"));
		register(55, "redstone_wire", (new BlockRedstoneWire()).setStrength(0.0F).setStepSound(STEP_SOUND_STONE1).setName("redstoneDust").disableBreakStat());
		register(56, "diamond_ore", (new BlockOre()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreDiamond"));
		register(57, "diamond_block", (new Block(Material.ORE, MaterialMapColor.COLOR32)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockDiamond").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(58, "crafting_table", (new BlockWorkbench()).setStrength(2.5F).setStepSound(STEP_SOUND_WOOD).setName("workbench"));
		register(59, "wheat", (new BlockCrops()).setName("crops"));
		Block var6 = (new BlockSoil()).setStrength(0.6F).setStepSound(STEP_SOUND_GRAVEL).setName("farmland");
		register(60, "farmland", var6);
		register(61, "furnace", (new BlockFurnace(false)).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setName("furnace").setCreativeTab(CreativeTab.DECORATIONS));
		register(62, "lit_furnace", (new BlockFurnace(true)).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setLightLevel(0.875F).setName("furnace"));
		register(63, "standing_sign", (new BlockFloorSign()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("sign").disableBreakStat());
		register(64, "wooden_door", (new BlockDoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorOak").disableBreakStat());
		register(65, "ladder", (new BlockLadder()).setStrength(0.4F).setStepSound(STEP_SOUND_LADDER).setName("ladder"));
		register(66, "rail", (new BlockMinecartTrack()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("rail"));
		register(67, "stone_stairs", (new BlockStairs(cobble.getBlockData())).setName("stairsStone"));
		register(68, "wall_sign", (new BlockWallSign()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("sign").disableBreakStat());
		register(69, "lever", (new BlockLever()).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("lever"));
		register(70, "stone_pressure_plate", (new BlockPressurePlateBinary(Material.STONE, BlockPressurePlateBinary.class_a_in_class_akb.b)).setStrength(0.5F).setStepSound(STEP_SOUND_STONE2).setName("pressurePlateStone"));
		register(71, "iron_door", (new BlockDoor(Material.ORE)).setStrength(5.0F).setStepSound(STEP_SOUND_STONE3).setName("doorIron").disableBreakStat());
		register(72, "wooden_pressure_plate", (new BlockPressurePlateBinary(Material.WOOD, BlockPressurePlateBinary.class_a_in_class_akb.a)).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("pressurePlateWood"));
		register(73, "redstone_ore", (new BlockRedstoneOre(false)).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreRedstone").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(74, "lit_redstone_ore", (new BlockRedstoneOre(true)).setLightLevel(0.625F).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreRedstone"));
		register(75, "unlit_redstone_torch", (new BlockRedstoneTorch(false)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("notGate"));
		register(76, "redstone_torch", (new BlockRedstoneTorch(true)).setStrength(0.0F).setLightLevel(0.5F).setStepSound(STEP_SOUND_WOOD).setName("notGate").setCreativeTab(CreativeTab.REDSTONE));
		register(77, "stone_button", (new BlockStoneButton()).setStrength(0.5F).setStepSound(STEP_SOUND_STONE2).setName("button"));
		register(78, "snow_layer", (new BlockSnow()).setStrength(0.1F).setStepSound(STEP_SOUND_SNOW).setName("snow").setLightOpacity(0));
		register(79, "ice", (new BlockIce()).setStrength(0.5F).setLightOpacity(3).setStepSound(STEP_SOUND_STONE4).setName("ice"));
		register(80, "snow", (new BlockSnowBlock()).setStrength(0.2F).setStepSound(STEP_SOUND_SNOW).setName("snow"));
		register(81, "cactus", (new BlockCactus()).setStrength(0.4F).setStepSound(STEP_SOUND_CLOTH).setName("cactus"));
		register(82, "clay", (new BlockClay()).setStrength(0.6F).setStepSound(STEP_SOUND_GRAVEL).setName("clay"));
		register(83, "reeds", (new BlockReed()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("reeds").disableBreakStat());
		register(84, "jukebox", (new BlockJukeBox()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("jukebox"));
		register(85, "fence", (new BlockFence(Material.WOOD, BlockWood.EnumLogVariant.OAK.getMapColor())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("fence"));
		Block pumpkin = (new BlockPumpkin()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("pumpkin");
		register(86, "pumpkin", pumpkin);
		register(87, "netherrack", (new BlockBloodstone()).setStrength(0.4F).setStepSound(STEP_SOUND_STONE2).setName("hellrock"));
		register(88, "soul_sand", (new BlockSlowSand()).setStrength(0.5F).setStepSound(STEP_SOUND_SAND).setName("hellsand"));
		register(89, "glowstone", (new BlockLightstone(Material.SHATTERABLE)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setLightLevel(1.0F).setName("lightgem"));
		register(90, "portal", (new BlockPortal()).setStrength(-1.0F).setStepSound(STEP_SOUND_STONE4).setLightLevel(0.75F).setName("portal"));
		register(91, "lit_pumpkin", (new BlockPumpkin()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setLightLevel(1.0F).setName("litpumpkin"));
		register(92, "cake", (new BlockCake()).setStrength(0.5F).setStepSound(STEP_SOUND_CLOTH).setName("cake").disableBreakStat());
		register(93, "unpowered_repeater", (new BlockRedstoneRepeater(false)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("diode").disableBreakStat());
		register(94, "powered_repeater", (new BlockRedstoneRepeater(true)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("diode").disableBreakStat());
		register(95, "stained_glass", (new BlockStainedGlass(Material.SHATTERABLE)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("stainedGlass"));
		register(96, "trapdoor", (new BlockTrapdoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("trapdoor").disableBreakStat());
		register(97, "monster_egg", (new BlockMonsterEggs()).setStrength(0.75F).setName("monsterStoneEgg"));
		Block smoothbrick = (new BlockSmoothBrick()).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stonebricksmooth");
		register(98, "stonebrick", smoothbrick);
		register(99, "brown_mushroom_block", (new BlockHugeMushroom(Material.WOOD, MaterialMapColor.COLOR11, brown_mush)).setStrength(0.2F).setStepSound(STEP_SOUND_WOOD).setName("mushroom"));
		register(100, "red_mushroom_block", (new BlockHugeMushroom(Material.WOOD, MaterialMapColor.COLOR29, red_mush)).setStrength(0.2F).setStepSound(STEP_SOUND_WOOD).setName("mushroom"));
		register(101, "iron_bars", (new BlockThin(Material.ORE, true)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("fenceIron"));
		register(102, "glass_pane", (new BlockThin(Material.SHATTERABLE, false)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("thinGlass"));
		Block melon = (new BlockMelon()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("melon");
		register(103, "melon_block", melon);
		register(104, "pumpkin_stem", (new BlockStem(pumpkin)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("pumpkinStem"));
		register(105, "melon_stem", (new BlockStem(melon)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("pumpkinStem"));
		register(106, "vine", (new BlockVine()).setStrength(0.2F).setStepSound(STEP_SOUND_GRASS).setName("vine"));
		register(107, "fence_gate", (new BlockFenceGate(BlockWood.EnumLogVariant.OAK)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("fenceGate"));
		register(108, "brick_stairs", (new BlockStairs(brick.getBlockData())).setName("stairsBrick"));
		register(109, "stone_brick_stairs", (new BlockStairs(smoothbrick.getBlockData().set(BlockSmoothBrick.a, BlockSmoothBrick.EnumSmoothBrickType.a))).setName("stairsStoneBrickSmooth"));
		register(110, "mycelium", (new BlockMycel()).setStrength(0.6F).setStepSound(STEP_SOUND_GRASS).setName("mycel"));
		register(111, "waterlily", (new BlockWaterLily()).setStrength(0.0F).setStepSound(STEP_SOUND_GRASS).setName("waterlily"));
		Block netherbrick = (new BlockNetherbrick()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("netherBrick").setCreativeTab(CreativeTab.BUILDING_BLOCKS);
		register(112, "nether_brick", netherbrick);
		register(113, "nether_brick_fence", (new BlockFence(Material.STONE, MaterialMapColor.COLOR36)).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("netherFence"));
		register(114, "nether_brick_stairs", (new BlockStairs(netherbrick.getBlockData())).setName("stairsNetherBrick"));
		register(115, "nether_wart", (new BlockNetherWart()).setName("netherStalk"));
		register(116, "enchanting_table", (new BlockEnchantmentTable()).setStrength(5.0F).setExplosionResist(2000.0F).setName("enchantmentTable"));
		register(117, "brewing_stand", (new BlockBrewingStand()).setStrength(0.5F).setLightLevel(0.125F).setName("brewingStand"));
		register(118, "cauldron", (new BlockCauldron()).setStrength(2.0F).setName("cauldron"));
		register(119, "end_portal", (new BlockEnderPortal(Material.PORTAL)).setStrength(-1.0F).setExplosionResist(6000000.0F));
		register(120, "end_portal_frame", (new BlockEnderPortalFrame()).setStepSound(STEP_SOUND_STONE4).setLightLevel(0.125F).setStrength(-1.0F).setName("endPortalFrame").setExplosionResist(6000000.0F).setCreativeTab(CreativeTab.DECORATIONS));
		register(121, "end_stone", (new Block(Material.STONE, MaterialMapColor.COLOR3)).setStrength(3.0F).setExplosionResist(15.0F).setStepSound(STEP_SOUND_STONE2).setName("whiteStone").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(122, "dragon_egg", (new BlockDragonEgg()).setStrength(3.0F).setExplosionResist(15.0F).setStepSound(STEP_SOUND_STONE2).setLightLevel(0.125F).setName("dragonEgg"));
		register(123, "redstone_lamp", (new BlockRedstoneLamp(false)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("redstoneLight").setCreativeTab(CreativeTab.REDSTONE));
		register(124, "lit_redstone_lamp", (new BlockRedstoneLamp(true)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("redstoneLight"));
		register(125, "double_wooden_slab", (new BlockDoubleWoodStep()).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("woodSlab"));
		register(126, "wooden_slab", (new BlockWoodStep()).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("woodSlab"));
		register(127, "cocoa", (new BlockCocoa()).setStrength(0.2F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("cocoa"));
		register(128, "sandstone_stairs", (new BlockStairs(sandstone.getBlockData().set(BlockSandStone.TYPE, BlockSandStone.EnumSandstoneVariant.SMOOTH))).setName("stairsSandStone"));
		register(129, "emerald_ore", (new BlockOre()).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("oreEmerald"));
		register(130, "ender_chest", (new class_ahv()).setStrength(22.5F).setExplosionResist(1000.0F).setStepSound(STEP_SOUND_STONE2).setName("enderChest").setLightLevel(0.5F));
		register(131, "tripwire_hook", (new BlockTripwireHook()).setName("tripWireSource"));
		register(132, "tripwire", (new BlockTripwire()).setName("tripWire"));
		register(133, "emerald_block", (new Block(Material.ORE, MaterialMapColor.COLOR34)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockEmerald").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(134, "spruce_stairs", (new BlockStairs(wood.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.SPRUCE))).setName("stairsWoodSpruce"));
		register(135, "birch_stairs", (new BlockStairs(wood.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.BIRCH))).setName("stairsWoodBirch"));
		register(136, "jungle_stairs", (new BlockStairs(wood.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.JUNGLE))).setName("stairsWoodJungle"));
		register(137, "command_block", (new BlockCommand()).setUnbreakable().setExplosionResist(6000000.0F).setName("commandBlock"));
		register(138, "beacon", (new BlockBeacon()).setName("beacon").setLightLevel(1.0F));
		register(139, "cobblestone_wall", (new BlockCobbleWall(cobble)).setName("cobbleWall"));
		register(140, "flower_pot", (new BlockFlowerPot()).setStrength(0.0F).setStepSound(STEP_SOUND_STONE1).setName("flowerPot"));
		register(141, "carrots", (new BlockCarrots()).setName("carrots"));
		register(142, "potatoes", (new BlockPotatoes()).setName("potatoes"));
		register(143, "wooden_button", (new BlockWoodButton()).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("button"));
		register(144, "skull", (new BlockSkull()).setStrength(1.0F).setStepSound(STEP_SOUND_STONE2).setName("skull"));
		register(145, "anvil", (new BlockAnvil()).setStrength(5.0F).setStepSound(STEP_SOUND_ANVIL).setExplosionResist(2000.0F).setName("anvil"));
		register(146, "trapped_chest", (new BlockChest(1)).setStrength(2.5F).setStepSound(STEP_SOUND_WOOD).setName("chestTrap"));
		register(147, "light_weighted_pressure_plate", (new BlockPressurePlateWeighted(Material.ORE, 15, MaterialMapColor.COLOR31)).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("weightedPlate_light"));
		register(148, "heavy_weighted_pressure_plate", (new BlockPressurePlateWeighted(Material.ORE, 150)).setStrength(0.5F).setStepSound(STEP_SOUND_WOOD).setName("weightedPlate_heavy"));
		register(149, "unpowered_comparator", (new BlockRedstoneComparator(false)).setStrength(0.0F).setStepSound(STEP_SOUND_WOOD).setName("comparator").disableBreakStat());
		register(150, "powered_comparator", (new BlockRedstoneComparator(true)).setStrength(0.0F).setLightLevel(0.625F).setStepSound(STEP_SOUND_WOOD).setName("comparator").disableBreakStat());
		register(151, "daylight_detector", new BlockDaylightDetector(false));
		register(152, "redstone_block", (new BlockPowered(Material.ORE, MaterialMapColor.COLOR5)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE3).setName("blockRedstone").setCreativeTab(CreativeTab.REDSTONE));
		register(153, "quartz_ore", (new BlockOre(MaterialMapColor.COLOR36)).setStrength(3.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_STONE2).setName("netherquartz"));
		register(154, "hopper", (new BlockHopper()).setStrength(3.0F).setExplosionResist(8.0F).setStepSound(STEP_SOUND_STONE3).setName("hopper"));
		Block quartz = (new BlockQuartz()).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setName("quartzBlock");
		register(155, "quartz_block", quartz);
		register(156, "quartz_stairs", (new BlockStairs(quartz.getBlockData().set(BlockQuartz.a, BlockQuartz.class_a_in_class_akf.a))).setName("stairsQuartz"));
		register(157, "activator_rail", (new BlockPoweredRail()).setStrength(0.7F).setStepSound(STEP_SOUND_STONE3).setName("activatorRail"));
		register(158, "dropper", (new BlockDropper()).setStrength(3.5F).setStepSound(STEP_SOUND_STONE2).setName("dropper"));
		register(159, "stained_hardened_clay", (new BlockCloth(Material.STONE)).setStrength(1.25F).setExplosionResist(7.0F).setStepSound(STEP_SOUND_STONE2).setName("clayHardenedStained"));
		register(160, "stained_glass_pane", (new BlockStainedGlassPane()).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setName("thinStainedGlass"));
		register(161, "leaves2", (new BlockLeaves2()).setName("leaves"));
		register(162, "log2", (new BlockLog2()).setName("log"));
		register(163, "acacia_stairs", (new BlockStairs(wood.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.ACACIA))).setName("stairsWoodAcacia"));
		register(164, "dark_oak_stairs", (new BlockStairs(wood.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.DARK_OAK))).setName("stairsWoodDarkOak"));
		register(165, "slime", (new BlockSlime()).setName("slime").setStepSound(STEP_SOUND_SLIME));
		register(166, "barrier", (new BlockBarrier()).setName("barrier"));
		register(167, "iron_trapdoor", (new BlockTrapdoor(Material.ORE)).setStrength(5.0F).setStepSound(STEP_SOUND_STONE3).setName("ironTrapdoor").disableBreakStat());
		register(168, "prismarine", (new BlockPrismarine()).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("prismarine"));
		register(169, "sea_lantern", (new BlockSeaLantern(Material.SHATTERABLE)).setStrength(0.3F).setStepSound(STEP_SOUND_STONE4).setLightLevel(1.0F).setName("seaLantern"));
		register(170, "hay_block", (new BlockHay()).setStrength(0.5F).setStepSound(STEP_SOUND_GRASS).setName("hayBlock").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(171, "carpet", (new BlockCarpet()).setStrength(0.1F).setStepSound(STEP_SOUND_CLOTH).setName("woolCarpet").setLightOpacity(0));
		register(172, "hardened_clay", (new BlockHardenedClay()).setStrength(1.25F).setExplosionResist(7.0F).setStepSound(STEP_SOUND_STONE2).setName("clayHardened"));
		register(173, "coal_block", (new Block(Material.STONE, MaterialMapColor.COLOR30)).setStrength(5.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("blockCoal").setCreativeTab(CreativeTab.BUILDING_BLOCKS));
		register(174, "packed_ice", (new BlockPackedIce()).setStrength(0.5F).setStepSound(STEP_SOUND_STONE4).setName("icePacked"));
		register(175, "double_plant", new BlockTallPlant());
		register(176, "standing_banner", (new BlockBanner.BlockStandingBanner()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("banner").disableBreakStat());
		register(177, "wall_banner", (new BlockBanner.BlockWallBanner()).setStrength(1.0F).setStepSound(STEP_SOUND_WOOD).setName("banner").disableBreakStat());
		register(178, "daylight_detector_inverted", new BlockDaylightDetector(true));
		Block redsandstone = (new BlockRedSandstone()).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setName("redSandStone");
		register(179, "red_sandstone", redsandstone);
		register(180, "red_sandstone_stairs", (new BlockStairs(redsandstone.getBlockData().set(BlockRedSandstone.a, BlockRedSandstone.class_a_in_class_aki.c))).setName("stairsRedSandStone"));
		register(181, "double_stone_slab2", (new BlockDoubleStoneStep2()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab2"));
		register(182, "stone_slab2", (new BlockStoneStep2()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("stoneSlab2"));
		register(183, "spruce_fence_gate", (new BlockFenceGate(BlockWood.EnumLogVariant.SPRUCE)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("spruceFenceGate"));
		register(184, "birch_fence_gate", (new BlockFenceGate(BlockWood.EnumLogVariant.BIRCH)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("birchFenceGate"));
		register(185, "jungle_fence_gate", (new BlockFenceGate(BlockWood.EnumLogVariant.JUNGLE)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("jungleFenceGate"));
		register(186, "dark_oak_fence_gate", (new BlockFenceGate(BlockWood.EnumLogVariant.DARK_OAK)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("darkOakFenceGate"));
		register(187, "acacia_fence_gate", (new BlockFenceGate(BlockWood.EnumLogVariant.ACACIA)).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("acaciaFenceGate"));
		register(188, "spruce_fence", (new BlockFence(Material.WOOD, BlockWood.EnumLogVariant.SPRUCE.getMapColor())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("spruceFence"));
		register(189, "birch_fence", (new BlockFence(Material.WOOD, BlockWood.EnumLogVariant.BIRCH.getMapColor())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("birchFence"));
		register(190, "jungle_fence", (new BlockFence(Material.WOOD, BlockWood.EnumLogVariant.JUNGLE.getMapColor())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("jungleFence"));
		register(191, "dark_oak_fence", (new BlockFence(Material.WOOD, BlockWood.EnumLogVariant.DARK_OAK.getMapColor())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("darkOakFence"));
		register(192, "acacia_fence", (new BlockFence(Material.WOOD, BlockWood.EnumLogVariant.ACACIA.getMapColor())).setStrength(2.0F).setExplosionResist(5.0F).setStepSound(STEP_SOUND_WOOD).setName("acaciaFence"));
		register(193, "spruce_door", (new BlockDoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorSpruce").disableBreakStat());
		register(194, "birch_door", (new BlockDoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorBirch").disableBreakStat());
		register(195, "jungle_door", (new BlockDoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorJungle").disableBreakStat());
		register(196, "acacia_door", (new BlockDoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorAcacia").disableBreakStat());
		register(197, "dark_oak_door", (new BlockDoor(Material.WOOD)).setStrength(3.0F).setStepSound(STEP_SOUND_WOOD).setName("doorDarkOak").disableBreakStat());
		//=====new blocks start=======
		register(198, "end_rod", (new BlockEndRod()).setStrength(0.0F).setLightLevel(0.9375F).setStepSound(STEP_SOUND_WOOD).setName("endRod"));
		register(199, "chorus_plant", (new BlockChorusPlant()).setStrength(0.4F).setStepSound(STEP_SOUND_WOOD).setName("chorusPlant"));
		register(200, "chorus_flower", (new BlockChorusFlower()).setStrength(0.4F).setStepSound(STEP_SOUND_WOOD).setName("chorusFlower"));
		Block purpur = (new Block(Material.STONE)).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setCreativeTab(CreativeTab.BUILDING_BLOCKS).setName("purpurBlock");
		register(201, "purpur_block", purpur);
		register(202, "purpur_pillar", (new BlockRotatable(Material.STONE)).setStrength(1.5F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setCreativeTab(CreativeTab.BUILDING_BLOCKS).setName("purpurPillar"));
		register(203, "purpur_stairs", (new BlockStairs(purpur.getBlockData())).setName("stairsPurpur"));
		register(204, "purpur_double_slab", (new BlockPurpurSlabAbstract.BlockPurpurDoubleSlab()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("purpurSlab"));
		register(205, "purpur_slab", (new BlockPurpurSlabAbstract.BlockPuprpurSlab()).setStrength(2.0F).setExplosionResist(10.0F).setStepSound(STEP_SOUND_STONE2).setName("purpurSlab"));
		register(206, "end_bricks", (new Block(Material.STONE)).setStepSound(STEP_SOUND_STONE2).setStrength(0.8F).setCreativeTab(CreativeTab.BUILDING_BLOCKS).setName("endBricks"));
		register(207, "beetroots", (new BlockBeetroots()).setName("beetroots"));
		Block grass_path = (new BlockGrassPath()).setStrength(0.65F).setStepSound(STEP_SOUND_GRASS).setName("grassPath").disableBreakStat();
		register(208, "grass_path", grass_path);
		register(209, "end_gateway", (new BlockEndGateway(Material.PORTAL)).setStrength(-1.0F).setExplosionResist(6000000.0F));
		register(255, "structure_block", (new BlockStructureBlock()).setUnbreakable().setExplosionResist(6000000.0F).setName("structureBlock").setLightLevel(1.0F));
		//=====new blocks end========
		BLOCK_REGISTRY.checkValid();

		Iterator<Block> iterator = BLOCK_REGISTRY.iterator();
		while (true) {
			Block block;
			while (iterator.hasNext()) {
				block = iterator.next();
				if (block.material == Material.AIR) {
					block.useNeighborBrightness = false;
				} else {
					boolean useNBr = false;
					boolean var18 = block instanceof BlockStairs;
					boolean var19 = block instanceof BlockStepAbstract;
					boolean var20 = (block == var6) || (block == grass_path);
					boolean var21 = block.translucent;
					boolean var22 = block.lightOpacity == 0;
					if (var18 || var19 || var20 || var21 || var22) {
						useNBr = true;
					}

					block.useNeighborBrightness = useNBr;
				}
			}

			iterator = BLOCK_REGISTRY.iterator();
			while (iterator.hasNext()) {
				block = iterator.next();
				Iterator<?> var23 = block.getBlockStateList().a().iterator();

				while (var23.hasNext()) {
					IBlockData var24 = (IBlockData) var23.next();
					int var25 = (BLOCK_REGISTRY.getId(block) << 4) | block.toLegacyData(var24);
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
				b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			a = new int[Block.EnumRotation.values().length];

			try {
				a[Block.EnumRotation.NONE.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static class Sound {
		public final String basename;
		public final float volume;
		public final float pitch;

		public Sound(String basename, float volume, float pitch) {
			this.basename = basename;
			this.volume = volume;
			this.pitch = pitch;
		}

		public float getVolume() {
			return volume;
		}

		public float getPitch() {
			return pitch;
		}

		public String getBreakSound() {
			return "dig." + basename;
		}

		public String getStepSound() {
			return "step." + basename;
		}

		public String getPlaceSound() {
			return getBreakSound();
		}

	}

	public static enum class_a_in_class_agj {
		NONE, LEFT_RIGHT, FRONT_BACK;

		public int a(int var1, int var2) {
			int var3 = var2 / 2;
			int var4 = var1 > var3 ? var1 - var2 : var1;
			switch (Block.SyntheticClass_1.b[ordinal()]) {
				case 1:
					return (var2 - var4) % var2;
				case 2:
					return ((var3 - var4) + var2) % var2;
				default:
					return var1;
			}
		}

		public Block.EnumRotation a(EnumDirection var1) {
			EnumDirection.EnumAxis var2 = var1.getAxis();
			return ((this != LEFT_RIGHT) || (var2 != EnumDirection.EnumAxis.Z)) && ((this != FRONT_BACK) || (var2 != EnumDirection.EnumAxis.X)) ? Block.EnumRotation.NONE : Block.EnumRotation.CLOCKWISE_180;
		}

		public EnumDirection b(EnumDirection var1) {
			switch (Block.SyntheticClass_1.b[ordinal()]) {
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

	public static enum EnumRotation {
		NONE, CLOCKWISE_90, CLOCKWISE_180, COUNTERCLOCKWISE_90;

		public Block.EnumRotation a(Block.EnumRotation var1) {
			switch (Block.SyntheticClass_1.a[var1.ordinal()]) {
				case 3:
					switch (Block.SyntheticClass_1.a[ordinal()]) {
						case 1:
							return CLOCKWISE_180;
						case 2:
							return COUNTERCLOCKWISE_90;
						case 3:
							return NONE;
						case 4:
							return CLOCKWISE_90;
					}
				case 4:
					switch (Block.SyntheticClass_1.a[ordinal()]) {
						case 1:
							return COUNTERCLOCKWISE_90;
						case 2:
							return NONE;
						case 3:
							return CLOCKWISE_90;
						case 4:
							return CLOCKWISE_180;
					}
				case 2:
					switch (Block.SyntheticClass_1.a[ordinal()]) {
						case 1:
							return CLOCKWISE_90;
						case 2:
							return CLOCKWISE_180;
						case 3:
							return COUNTERCLOCKWISE_90;
						case 4:
							return NONE;
					}
				default:
					return this;
			}
		}

		public EnumDirection a(EnumDirection var1) {
			if (var1.getAxis() == EnumDirection.EnumAxis.Y) {
				return var1;
			} else {
				switch (Block.SyntheticClass_1.a[ordinal()]) {
					case 2:
						return var1.rotateY();
					case 3:
						return var1.opposite();
					case 4:
						return var1.rotateYCCW();
					default:
						return var1;
				}
			}
		}

		public int a(int var1, int var2) {
			switch (Block.SyntheticClass_1.a[ordinal()]) {
				case 2:
					return (var1 + (var2 / 4)) % var2;
				case 3:
					return (var1 + (var2 / 2)) % var2;
				case 4:
					return (var1 + ((var2 * 3) / 4)) % var2;
				default:
					return var1;
			}
		}
	}
}
