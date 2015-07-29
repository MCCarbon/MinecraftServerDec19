package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adb;
import net.minecraft.server.class_adc;
import net.minecraft.server.class_add;
import net.minecraft.server.class_ade;
import net.minecraft.server.class_adf;
import net.minecraft.server.class_adg;
import net.minecraft.server.class_adh;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_adn;
import net.minecraft.server.class_ado;
import net.minecraft.server.class_adp;
import net.minecraft.server.class_adq;
import net.minecraft.server.class_adr;
import net.minecraft.server.class_ads;
import net.minecraft.server.class_adt;
import net.minecraft.server.class_adu;
import net.minecraft.server.class_adv;
import net.minecraft.server.class_adw;
import net.minecraft.server.class_cx;
import net.minecraft.server.class_di;
import net.minecraft.server.class_jz;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qf;

public abstract class class_adi {
   public static final class_cx b = new class_cx();
   private final class_pw[] a;
   private final class_adi.class_a_in_class_adi e;
   public class_adj c;
   protected String d;

   public static class_adi c(int var0) {
      return (class_adi)b.a(var0);
   }

   public static int b(class_adi var0) {
      return b.a(var0);
   }

   public static class_adi b(String var0) {
      return (class_adi)b.c(new class_jz(var0));
   }

   protected class_adi(class_adi.class_a_in_class_adi var1, class_adj var2, class_pw[] var3) {
      this.e = var1;
      this.c = var2;
      this.a = var3;
   }

   public Iterable a(class_qa var1) {
      ArrayList var2 = Lists.newArrayList();
      class_pw[] var3 = this.a;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_pw var6 = var3[var5];
         class_aas var7 = var1.a(var6);
         if(var7 != null) {
            var2.add(var7);
         }
      }

      return var2.size() > 0?var2:null;
   }

   public class_adi.class_a_in_class_adi c() {
      return this.e;
   }

   public int d() {
      return 1;
   }

   public int b() {
      return 1;
   }

   public int a(int var1) {
      return 1 + var1 * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 5;
   }

   public int a(int var1, class_pc var2) {
      return 0;
   }

   public float a(int var1, class_qf var2) {
      return 0.0F;
   }

   public boolean a(class_adi var1) {
      return this != var1;
   }

   public class_adi c(String var1) {
      this.d = var1;
      return this;
   }

   public String a() {
      return "enchantment." + this.d;
   }

   public String d(int var1) {
      String var2 = class_di.a(this.a());
      return var2 + " " + class_di.a("enchantment.level." + var1);
   }

   public boolean a(class_aas var1) {
      return this.c.a(var1.b());
   }

   public void a(class_qa var1, class_pr var2, int var3) {
   }

   public void b(class_qa var1, class_pr var2, int var3) {
   }

   public static void e() {
      b.a(0, new class_jz("protection"), new class_ads(class_adi.class_a_in_class_adi.a, class_ads.class_a_in_class_ads.a, class_pw.values()));
      b.a(1, new class_jz("fire_protection"), new class_ads(class_adi.class_a_in_class_adi.b, class_ads.class_a_in_class_ads.b, class_pw.values()));
      b.a(2, new class_jz("feather_falling"), new class_ads(class_adi.class_a_in_class_adi.b, class_ads.class_a_in_class_ads.c, class_pw.values()));
      b.a(3, new class_jz("blast_protection"), new class_ads(class_adi.class_a_in_class_adi.c, class_ads.class_a_in_class_ads.d, class_pw.values()));
      b.a(4, new class_jz("projectile_protection"), new class_ads(class_adi.class_a_in_class_adi.b, class_ads.class_a_in_class_ads.e, class_pw.values()));
      b.a(5, new class_jz("respiration"), new class_adr(class_adi.class_a_in_class_adi.c, class_pw.values()));
      b.a(6, new class_jz("aqua_affinity"), new class_adw(class_adi.class_a_in_class_adi.c, class_pw.values()));
      b.a(7, new class_jz("thorns"), new class_adt(class_adi.class_a_in_class_adi.d, class_pw.values()));
      b.a(8, new class_jz("depth_strider"), new class_adv(class_adi.class_a_in_class_adi.c, class_pw.values()));
      b.a(16, new class_jz("sharpness"), new class_adf(class_adi.class_a_in_class_adi.a, 0, new class_pw[]{class_pw.a}));
      b.a(17, new class_jz("smite"), new class_adf(class_adi.class_a_in_class_adi.b, 1, new class_pw[]{class_pw.a}));
      b.a(18, new class_jz("bane_of_arthropods"), new class_adf(class_adi.class_a_in_class_adi.b, 2, new class_pw[]{class_pw.a}));
      b.a(19, new class_jz("knockback"), new class_adp(class_adi.class_a_in_class_adi.b, new class_pw[]{class_pw.a}));
      b.a(20, new class_jz("fire_aspect"), new class_adn(class_adi.class_a_in_class_adi.c, new class_pw[]{class_pw.a}));
      b.a(21, new class_jz("looting"), new class_adq(class_adi.class_a_in_class_adi.c, class_adj.g, new class_pw[]{class_pw.a}));
      b.a(32, new class_jz("efficiency"), new class_adh(class_adi.class_a_in_class_adi.a, new class_pw[]{class_pw.a}));
      b.a(33, new class_jz("silk_touch"), new class_adu(class_adi.class_a_in_class_adi.d, new class_pw[]{class_pw.a}));
      b.a(34, new class_jz("unbreaking"), new class_adg(class_adi.class_a_in_class_adi.b, new class_pw[]{class_pw.a}));
      b.a(35, new class_jz("fortune"), new class_adq(class_adi.class_a_in_class_adi.c, class_adj.h, new class_pw[]{class_pw.a}));
      b.a(48, new class_jz("power"), new class_adb(class_adi.class_a_in_class_adi.a, new class_pw[]{class_pw.a}));
      b.a(49, new class_jz("punch"), new class_ade(class_adi.class_a_in_class_adi.c, new class_pw[]{class_pw.a}));
      b.a(50, new class_jz("flame"), new class_adc(class_adi.class_a_in_class_adi.c, new class_pw[]{class_pw.a}));
      b.a(51, new class_jz("infinity"), new class_add(class_adi.class_a_in_class_adi.d, new class_pw[]{class_pw.a}));
      b.a(61, new class_jz("luck_of_the_sea"), new class_adq(class_adi.class_a_in_class_adi.c, class_adj.i, new class_pw[]{class_pw.a}));
      b.a(62, new class_jz("lure"), new class_ado(class_adi.class_a_in_class_adi.c, class_adj.i, new class_pw[]{class_pw.a}));
   }

   public static enum class_a_in_class_adi {
      a(10),
      b(5),
      c(2),
      d(1);

      private final int e;

      private class_a_in_class_adi(int var3) {
         this.e = var3;
      }

      public int a() {
         return this.e;
      }
   }
}
