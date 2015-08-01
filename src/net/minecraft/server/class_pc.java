package net.minecraft.server;

import net.minecraft.server.class_aej;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_pd;
import net.minecraft.server.class_pe;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xf;

public class class_pc {
   public static class_pc a = (new class_pc("inFire")).n();
   public static class_pc b = new class_pc("lightningBolt");
   public static class_pc c = (new class_pc("onFire")).k().n();
   public static class_pc d = (new class_pc("lava")).n();
   public static class_pc e = (new class_pc("inWall")).k();
   public static class_pc f = (new class_pc("drown")).k();
   public static class_pc g = (new class_pc("starve")).k().m();
   public static class_pc h = new class_pc("cactus");
   public static class_pc i = (new class_pc("fall")).k();
   public static class_pc j = (new class_pc("outOfWorld")).k().l();
   public static class_pc k = (new class_pc("generic")).k();
   public static class_pc l = (new class_pc("magic")).k().t();
   public static class_pc m = (new class_pc("wither")).k();
   public static class_pc n = new class_pc("anvil");
   public static class_pc o = new class_pc("fallingBlock");
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

   public static class_pc a(class_qa var0) {
      return new class_pd("mob", var0);
   }

   public static class_pc a(class_pr var0, class_qa var1) {
      return new class_pe("mob", var0, var1);
   }

   public static class_pc a(class_xa var0) {
      return new class_pd("player", var0);
   }

   public static class_pc a(class_xd var0, class_pr var1) {
      return (new class_pe("arrow", var0, var1)).b();
   }

   public static class_pc a(class_xf var0, class_pr var1) {
      return var1 == null?(new class_pe("onFire", var0, var0)).n().b():(new class_pe("fireball", var0, var1)).n().b();
   }

   public static class_pc a(class_pr var0, class_pr var1) {
      return (new class_pe("thrown", var0, var1)).b();
   }

   public static class_pc b(class_pr var0, class_pr var1) {
      return (new class_pe("indirectMagic", var0, var1)).k().t();
   }

   public static class_pc a(class_pr var0) {
      return (new class_pd("thorns", var0)).v().t();
   }

   public static class_pc a(class_aej var0) {
      return var0 != null && var0.c() != null?(new class_pd("explosion.player", var0.c())).q().d():(new class_pc("explosion")).q().d();
   }

   public boolean a() {
      return this.v;
   }

   public class_pc b() {
      this.v = true;
      return this;
   }

   public boolean c() {
      return this.y;
   }

   public class_pc d() {
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

   protected class_pc(String var1) {
      this.p = var1;
   }

   public class_pr i() {
      return this.j();
   }

   public class_pr j() {
      return null;
   }

   protected class_pc k() {
      this.q = true;
      this.t = 0.0F;
      return this;
   }

   protected class_pc l() {
      this.r = true;
      return this;
   }

   protected class_pc m() {
      this.s = true;
      this.t = 0.0F;
      return this;
   }

   protected class_pc n() {
      this.u = true;
      return this;
   }

   public IChatBaseComponent b(class_qa var1) {
      class_qa var2 = var1.bu();
      String var3 = "death.attack." + this.p;
      String var4 = var3 + ".player";
      return var2 != null && LocaleI18n.c(var4)?new class_fb(var4, new Object[]{var1.f_(), var2.f_()}):new class_fb(var3, new Object[]{var1.f_()});
   }

   public boolean o() {
      return this.u;
   }

   public String p() {
      return this.p;
   }

   public class_pc q() {
      this.w = true;
      return this;
   }

   public boolean r() {
      return this.w;
   }

   public boolean s() {
      return this.x;
   }

   public class_pc t() {
      this.x = true;
      return this;
   }

   public boolean u() {
      class_pr var1 = this.j();
      return var1 instanceof class_xa && ((class_xa)var1).bH.instabuild;
   }
}
