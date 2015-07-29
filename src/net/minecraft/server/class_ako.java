package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahh;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;

public class class_ako extends class_ahh {
   public static final class_anw a = class_anw.a("locked");
   public static final class_anz b = class_anz.a("delay", 1, 4);

   protected class_ako(boolean var1) {
      super(var1);
      this.j(this.M.b().set(O, class_cq.c).set(b, Integer.valueOf(1)).set(a, Boolean.valueOf(false)));
   }

   public String f() {
      return class_di.a("item.diode.name");
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      return var1.set(a, Boolean.valueOf(this.b(var2, var3, var1)));
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((class_cq)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(O)));
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(!var4.bH.e) {
         return false;
      } else {
         var1.a((class_cj)var2, (IBlockData)var3.a(b), 3);
         return true;
      }
   }

   protected int d(IBlockData var1) {
      return ((Integer)var1.get(b)).intValue() * 2;
   }

   protected IBlockData e(IBlockData var1) {
      Integer var2 = (Integer)var1.get(b);
      Boolean var3 = (Boolean)var1.get(a);
      class_cq var4 = (class_cq)var1.get(O);
      return class_agk.bc.S().set(O, var4).set(b, var2).set(a, var3);
   }

   protected IBlockData k(IBlockData var1) {
      Integer var2 = (Integer)var1.get(b);
      Boolean var3 = (Boolean)var1.get(a);
      class_cq var4 = (class_cq)var1.get(O);
      return class_agk.bb.S().set(O, var4).set(b, var2).set(a, var3);
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aau.bd;
   }

   public boolean b(class_aer var1, class_cj var2, IBlockData var3) {
      return this.c(var1, var2, var3) > 0;
   }

   protected boolean c(Block var1) {
      return d(var1);
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      super.b(var1, var2, var3);
      this.h(var1, var2, var3);
   }

   public IBlockData a(int var1) {
      return this.S().set(O, class_cq.b(var1)).set(a, Boolean.valueOf(false)).set(b, Integer.valueOf(1 + (var1 >> 2)));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.get(O)).b();
      var3 |= ((Integer)var1.get(b)).intValue() - 1 << 2;
      return var3;
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{O, b, a});
   }
}
