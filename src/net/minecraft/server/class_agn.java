package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amh;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;

public class class_agn extends class_agd {
   public static final class_anw[] a = new class_anw[]{class_anw.a("has_bottle_0"), class_anw.a("has_bottle_1"), class_anw.a("has_bottle_2")};

   public class_agn() {
      super(class_atk.f);
      this.j(this.M.b().set(a[0], Boolean.valueOf(false)).set(a[1], Boolean.valueOf(false)).set(a[2], Boolean.valueOf(false)));
   }

   public String f() {
      return class_di.a("item.brewingStand.name");
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amh();
   }

   public boolean d() {
      return false;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.j();
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amh) {
            var4.a((class_oj)((class_amh)var11));
            var4.b(class_nc.M);
         }

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_qa var4, class_aas var5) {
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amh) {
            ((class_amh)var6).a(var5.q());
         }
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_amh) {
         class_ol.a(var1, (class_cj)var2, (class_amh)var4);
      }

      super.b(var1, var2, var3);
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.bI;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return class_xz.a(var1.s(var2));
   }

   public IBlockData a(int var1) {
      IBlockData var2 = this.S();

      for(int var3 = 0; var3 < 3; ++var3) {
         var2 = var2.set(a[var3], Boolean.valueOf((var1 & 1 << var3) > 0));
      }

      return var2;
   }

   public int c(IBlockData var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 3; ++var3) {
         if(((Boolean)var1.get(a[var3])).booleanValue()) {
            var2 |= 1 << var3;
         }
      }

      return var2;
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a[0], a[1], a[2]});
   }
}
