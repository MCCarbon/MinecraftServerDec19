package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.class_afg;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aoe;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aoz;
import net.minecraft.server.class_apj;
import net.minecraft.server.class_apk;
import net.minecraft.server.class_app;
import net.minecraft.server.class_arr;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_lh;

public abstract class class_aoy {
   public static final float[] a = new float[]{1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F};
   protected World b;
   private class_aes g;
   private String h;
   protected class_afd c;
   protected boolean d;
   protected boolean e;
   protected final float[] f = new float[16];
   private final float[] i = new float[4];

   public final void a(World var1) {
      this.b = var1;
      this.g = var1.Q().u();
      this.h = var1.Q().B();
      this.b();
      this.a();
   }

   protected void a() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   protected void b() {
      class_aes var1 = this.b.Q().u();
      if(var1 == class_aes.c) {
         class_arr var2 = class_arr.a(this.b.Q().B());
         this.c = new class_afg(class_aez.a(var2.a(), class_aez.ad), 0.5F);
      } else if(var1 == class_aes.g) {
         this.c = new class_afg(class_aez.q, 0.0F);
      } else {
         this.c = new class_afd(this.b);
      }

   }

   public class_aoh c() {
      return (class_aoh)(this.g == class_aes.c?new class_apk(this.b, this.b.K(), this.b.Q().s(), this.h):(this.g == class_aes.g?new class_apj(this.b):(this.g == class_aes.f?new class_app(this.b, this.b.K(), this.b.Q().s(), this.h):new class_app(this.b, this.b.K(), this.b.Q().s(), this.h))));
   }

   public boolean a(int var1, int var2) {
      return this.b.c(new BlockPosition(var1, 0, var2)) == Blocks.GRASS;
   }

   public float a(long var1, float var3) {
      int var4 = (int)(var1 % 24000L);
      float var5 = ((float)var4 + var3) / 24000.0F - 0.25F;
      if(var5 < 0.0F) {
         ++var5;
      }

      if(var5 > 1.0F) {
         --var5;
      }

      float var6 = var5;
      var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
      var5 = var6 + (var5 - var6) / 3.0F;
      return var5;
   }

   public int a(long var1) {
      return (int)(var1 / 24000L % 8L + 8L) % 8;
   }

   public boolean d() {
      return true;
   }

   public boolean e() {
      return true;
   }

   public BlockPosition h() {
      return null;
   }

   public int i() {
      return this.g == class_aes.c?4:this.b.G() + 1;
   }

   public class_afd k() {
      return this.c;
   }

   public boolean l() {
      return this.d;
   }

   public boolean m() {
      return this.e;
   }

   public float[] n() {
      return this.f;
   }

   public class_aoe o() {
      return new class_aoe();
   }

   public void a(class_lh var1) {
   }

   public void b(class_lh var1) {
   }

   public abstract class_aoz p();

   public void q() {
   }

   public void r() {
   }

   public boolean c(int var1, int var2) {
      return true;
   }
}
