package net.minecraft.server;

public class ItemFood extends Item {

	public final int a;
	private final int b;
	private final float c;
	private final boolean d;
	private boolean k;
	private MobEffect l;
	private float m;

	public ItemFood(int var1, float var2, boolean var3) {
		this.a = 32;
		this.b = var1;
		this.d = var3;
		this.c = var2;
		setCreativeTab(CreativeTab.FOOD);
	}

	public ItemFood(int var1, boolean var2) {
		this(var1, 0.6F, var2);
	}

	@Override
	public ItemStack onUseFinish(ItemStack var1, World var2, EntityLiving var3) {
		--var1.count;
		if (var3 instanceof EntityHuman) {
			EntityHuman var4 = (EntityHuman) var3;
			var4.getFoodData().a(this, var1);
			var2.a((Entity) var4, "random.burp", 0.5F, (var2.random.nextFloat() * 0.1F) + 0.9F);
			this.a(var1, var2, var4);
			var4.b(StatisticList.ad[Item.getId(this)]);
		}

		return var1;
	}

	protected void a(ItemStack var1, World var2, EntityHuman var3) {
		if (!var2.isClientSide && (l != null) && (var2.random.nextFloat() < m)) {
			var3.addEffect(new MobEffect(l));
		}

	}

	@Override
	public int getUseDuration(ItemStack var1) {
		return 32;
	}

	@Override
	public EnumAnimation getAnimation(ItemStack var1) {
		return EnumAnimation.EAT;
	}

	@Override
	public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
		if (var3.j(k)) {
			var3.c(var4);
			return new UseResultWithValue(UseResult.SUCCESS, var1);
		} else {
			return new UseResultWithValue(UseResult.CANT_USE, var1);
		}
	}

	public int h(ItemStack var1) {
		return b;
	}

	public float i(ItemStack var1) {
		return c;
	}

	public boolean g() {
		return d;
	}

	public ItemFood a(MobEffect var1, float var2) {
		this.l = var1;
		this.m = var2;
		return this;
	}

	public ItemFood h() {
		this.k = true;
		return this;
	}
}
