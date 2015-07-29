package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_amc extends Block {
   public static final class_any a = class_any.a("color", class_zy.class);

   protected class_amc() {
      super(class_atk.r);
      this.j(this.M.b().set(a, class_zy.a));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
      this.a(true);
      this.a(CreativeTab.c);
      this.b(0);
   }

   public class_atl g(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void j() {
      this.b(0);
   }

   public void a(class_aer var1, class_cj var2) {
      this.b(0);
   }

   protected void b(int var1) {
      byte var2 = 0;
      float var3 = (float)(1 * (1 + var2)) / 16.0F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2) && this.e(var1, var2);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(class_aen var1, class_cj var2, IBlockData var3) {
      if(!this.e(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   private boolean e(class_aen var1, class_cj var2) {
      return !var1.d(var2.b());
   }

   public int a(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public IBlockData a(int var1) {
      return this.S().set(a, class_zy.b(var1));
   }

   public int c(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new IBlockState[]{a});
   }
}
