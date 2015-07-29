package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.CreativeTab;

public abstract class class_amb extends class_aio {
   public static final class_any b = class_any.a("variant", class_ajw.class_a_in_class_ajw.class);

   public class_amb() {
      super(class_atk.d);
      IBlockData var1 = this.M.b();
      if(!this.l()) {
         var1 = var1.set(a, class_aio.class_a_in_class_aio.b);
      }

      this.j(var1.set(b, class_ajw.class_a_in_class_ajw.a));
      this.a((CreativeTab)CreativeTab.b);
   }

   public class_atl g(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(b)).c();
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aar.a((Block)class_agk.bM);
   }

   public String b(int var1) {
      return super.a() + "." + class_ajw.class_a_in_class_ajw.a(var1).d();
   }

   public IBlockState n() {
      return b;
   }

   public Object a(class_aas var1) {
      return class_ajw.class_a_in_class_ajw.a(var1.i() & 7);
   }

   public IBlockData a(int var1) {
      IBlockData var2 = this.S().set(b, class_ajw.class_a_in_class_ajw.a(var1 & 7));
      if(!this.l()) {
         var2 = var2.set(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.get(b)).a();
      if(!this.l() && var1.get(a) == class_aio.class_a_in_class_aio.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected class_anm e() {
      return this.l()?new class_anm(this, new IBlockState[]{b}):new class_anm(this, new IBlockState[]{a, b});
   }

   public int a(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(b)).a();
   }
}
