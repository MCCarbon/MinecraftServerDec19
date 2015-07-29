package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agg;
import net.minecraft.server.class_aiq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_alb extends class_aiq {
   public static final class_any a = class_any.a("color", class_zy.class);

   public class_alb(class_atk var1) {
      super(var1, false);
      this.j(this.M.b().set(a, class_zy.a));
      this.a((CreativeTab)CreativeTab.b);
   }

   public int a(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public class_atl g(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public int a(Random var1) {
      return 0;
   }

   protected boolean K() {
      return true;
   }

   public boolean d() {
      return false;
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_zy.b(var1));
   }

   public void c(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public int c(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }
}
