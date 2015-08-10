package net.minecraft.server;

public class DamageSource {

	public static final DamageSource FIRE = (new DamageSource("inFire")).n();
	public static final DamageSource LIGHTNING = new DamageSource("lightningBolt");
	public static final DamageSource BURN = (new DamageSource("onFire")).k().n();
	public static final DamageSource LAVA = (new DamageSource("lava")).n();
	public static final DamageSource STUCK = (new DamageSource("inWall")).k();
	public static final DamageSource DROWN = (new DamageSource("drown")).k();
	public static final DamageSource STARVE = (new DamageSource("starve")).k().m();
	public static final DamageSource CACTUS = new DamageSource("cactus");
	public static final DamageSource FALL = (new DamageSource("fall")).k();
	public static final DamageSource OUT_OF_WORLD = (new DamageSource("outOfWorld")).k().l();
	public static final DamageSource GENERIC = (new DamageSource("generic")).k();
	public static final DamageSource MAGIC = (new DamageSource("magic")).k().setMagic();
	public static final DamageSource WITHER = (new DamageSource("wither")).k();
	public static final DamageSource ANVIL = new DamageSource("anvil");
	public static final DamageSource FALLING_BLOCK = new DamageSource("fallingBlock");

	private boolean q;
	private boolean r;
	private boolean s;
	private float t = 0.3F;
	private boolean u;
	private boolean v;
	private boolean w;
	private boolean x;
	private boolean y;
	public String p;

	public static DamageSource mobAttack(EntityLiving var0) {
		return new EntityDamageSource("mob", var0);
	}

	public static DamageSource a(Entity var0, EntityLiving var1) {
		return new EntityDamageSourceIndirect("mob", var0, var1);
	}

	public static DamageSource playerAttack(EntityHuman var0) {
		return new EntityDamageSource("player", var0);
	}

	public static DamageSource arrow(EntityArrow var0, Entity var1) {
		return (new EntityDamageSourceIndirect("arrow", var0, var1)).b();
	}

	public static DamageSource fireball(EntityFireball var0, Entity var1) {
		return var1 == null ? (new EntityDamageSourceIndirect("onFire", var0, var0)).n().b() : (new EntityDamageSourceIndirect("fireball", var0, var1)).n().b();
	}

	public static DamageSource projectile(Entity var0, Entity var1) {
		return (new EntityDamageSourceIndirect("thrown", var0, var1)).b();
	}

	public static DamageSource b(Entity var0, Entity var1) {
		return (new EntityDamageSourceIndirect("indirectMagic", var0, var1)).k().setMagic();
	}

	public static DamageSource a(Entity var0) {
		return (new EntityDamageSource("thorns", var0)).v().setMagic();
	}

	public static DamageSource explosion(Explosion var0) {
		return var0 != null && var0.getSource() != null ? (new EntityDamageSource("explosion.player", var0.getSource())).q().d() : (new DamageSource("explosion")).q().d();
	}

	public boolean a() {
		return this.v;
	}

	public DamageSource b() {
		this.v = true;
		return this;
	}

	public boolean isExplosion() {
		return this.y;
	}

	public DamageSource d() {
		this.y = true;
		return this;
	}

	public boolean ignoresArmor() {
		return this.q;
	}

	public float getExhaustionCost() {
		return this.t;
	}

	public boolean ignoresInvulnerability() {
		return this.r;
	}

	public boolean isStarvation() {
		return this.s;
	}

	protected DamageSource(String var1) {
		this.p = var1;
	}

	public Entity i() {
		return this.getEntity();
	}

	public Entity getEntity() {
		return null;
	}

	protected DamageSource k() {
		this.q = true;
		this.t = 0.0F;
		return this;
	}

	protected DamageSource l() {
		this.r = true;
		return this;
	}

	protected DamageSource m() {
		this.s = true;
		this.t = 0.0F;
		return this;
	}

	protected DamageSource n() {
		this.u = true;
		return this;
	}

	public IChatBaseComponent b(EntityLiving var1) {
		EntityLiving var2 = var1.bu();
		String var3 = "death.attack." + this.p;
		String var4 = var3 + ".player";
		return var2 != null && LocaleI18n.c(var4) ? new ChatMessage(var4, new Object[] { var1.getScoreboardDisplayName(), var2.getScoreboardDisplayName() }) : new ChatMessage(var3, new Object[] { var1.getScoreboardDisplayName() });
	}

	public boolean o() {
		return this.u;
	}

	public String p() {
		return this.p;
	}

	public DamageSource q() {
		this.w = true;
		return this;
	}

	public boolean r() {
		return this.w;
	}

	public boolean isMagic() {
		return this.x;
	}

	public DamageSource setMagic() {
		this.x = true;
		return this;
	}

	public boolean u() {
		Entity var1 = this.getEntity();
		return var1 instanceof EntityHuman && ((EntityHuman) var1).abilities.instabuild;
	}
}
