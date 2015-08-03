package net.minecraft.server;

public class DamageSource {
   public static DamageSource a = (new DamageSource("inFire")).n();
   public static DamageSource b = new DamageSource("lightningBolt");
   public static DamageSource c = (new DamageSource("onFire")).k().n();
   public static DamageSource d = (new DamageSource("lava")).n();
   public static DamageSource e = (new DamageSource("inWall")).k();
   public static DamageSource f = (new DamageSource("drown")).k();
   public static DamageSource g = (new DamageSource("starve")).k().m();
   public static DamageSource h = new DamageSource("cactus");
   public static DamageSource i = (new DamageSource("fall")).k();
   public static DamageSource j = (new DamageSource("outOfWorld")).k().l();
   public static DamageSource k = (new DamageSource("generic")).k();
   public static DamageSource l = (new DamageSource("magic")).k().t();
   public static DamageSource m = (new DamageSource("wither")).k();
   public static DamageSource n = new DamageSource("anvil");
   public static DamageSource o = new DamageSource("fallingBlock");
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

   public static DamageSource a(EntityLiving var0) {
      return new class_pd("mob", var0);
   }

   public static DamageSource a(Entity var0, EntityLiving var1) {
      return new class_pe("mob", var0, var1);
   }

   public static DamageSource a(EntityHuman var0) {
      return new class_pd("player", var0);
   }

   public static DamageSource a(class_xd var0, Entity var1) {
      return (new class_pe("arrow", var0, var1)).b();
   }

   public static DamageSource a(class_xf var0, Entity var1) {
      return var1 == null?(new class_pe("onFire", var0, var0)).n().b():(new class_pe("fireball", var0, var1)).n().b();
   }

   public static DamageSource a(Entity var0, Entity var1) {
      return (new class_pe("thrown", var0, var1)).b();
   }

   public static DamageSource b(Entity var0, Entity var1) {
      return (new class_pe("indirectMagic", var0, var1)).k().t();
   }

   public static DamageSource a(Entity var0) {
      return (new class_pd("thorns", var0)).v().t();
   }

   public static DamageSource a(Explosion var0) {
      return var0 != null && var0.getSource() != null?(new class_pd("explosion.player", var0.getSource())).q().d():(new DamageSource("explosion")).q().d();
   }

   public boolean a() {
      return this.v;
   }

   public DamageSource b() {
      this.v = true;
      return this;
   }

   public boolean c() {
      return this.y;
   }

   public DamageSource d() {
      this.y = true;
      return this;
   }

   public boolean e() {
      return this.q;
   }

   public float f() {
      return this.t;
   }

   public boolean g() {
      return this.r;
   }

   public boolean h() {
      return this.s;
   }

   protected DamageSource(String var1) {
      this.p = var1;
   }

   public Entity i() {
      return this.j();
   }

   public Entity j() {
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
      return var2 != null && LocaleI18n.c(var4)?new ChatMessage(var4, new Object[]{var1.getScoreboardDisplayName(), var2.getScoreboardDisplayName()}):new ChatMessage(var3, new Object[]{var1.getScoreboardDisplayName()});
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

   public boolean s() {
      return this.x;
   }

   public DamageSource t() {
      this.x = true;
      return this;
   }

   public boolean u() {
      Entity var1 = this.j();
      return var1 instanceof EntityHuman && ((EntityHuman)var1).abilities.instabuild;
   }
}
