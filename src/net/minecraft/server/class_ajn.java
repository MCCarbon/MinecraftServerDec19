package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;

public class class_ajn extends class_aja {
   public static final class_any Q = class_any.a("variant", class_ajw.class_a_in_class_ajw.class, new Predicate() {
      public boolean a(class_ajw.class_a_in_class_ajw var1) {
         return var1.a() >= 4;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_ajw.class_a_in_class_ajw)var1);
      }
   });

   public class_ajn() {
      this.j(this.M.b().set(Q, class_ajw.class_a_in_class_ajw.e).set(b, Boolean.valueOf(true)).set(a, Boolean.valueOf(true)));
   }

   protected void a(class_aen var1, class_cj var2, IBlockData var3, int var4) {
      if(var3.get(Q) == class_ajw.class_a_in_class_ajw.f && var1.s.nextInt(var4) == 0) {
         a(var1, var2, new class_aas(class_aau.e));
      }

   }

   public int a(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(Q)).a();
   }

   public int j(class_aen var1, class_cj var2) {
      IBlockData var3 = var1.p(var2);
      return var3.getBlock().c(var3) & 3;
   }

   protected class_aas i(IBlockData var1) {
      return new class_aas(class_aar.a((Block)this), 1, ((class_ajw.class_a_in_class_ajw)var1.get(Q)).a() - 4);
   }

   public IBlockData a(int var1) {
      return this.S().set(Q, this.b(var1)).set(a, Boolean.valueOf((var1 & 4) == 0)).set(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.get(Q)).a() - 4;
      if(!((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 4;
      }

      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public class_ajw.class_a_in_class_ajw b(int var1) {
      return class_ajw.class_a_in_class_ajw.a((var1 & 3) + 4);
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{Q, b, a});
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, IBlockData var4, class_amg var5, class_aas var6) {
      if(!var1.D && var6 != null && var6.b() == class_aau.bg) {
         var2.b(class_nc.ab[Block.getId((Block)this)]);
         a(var1, var3, new class_aas(class_aar.a((Block)this), 1, ((class_ajw.class_a_in_class_ajw)var4.get(Q)).a() - 4));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }
   }
}
