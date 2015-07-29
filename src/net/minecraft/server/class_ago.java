package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.CreativeTab;

public class class_ago extends Block {
   protected class_ago() {
      this(class_atk.k);
   }

   protected class_ago(class_atk var1) {
      this(var1, var1.r());
   }

   protected class_ago(class_atk var1, class_atl var2) {
      super(var1, var2);
      this.a(true);
      float var3 = 0.2F;
      this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
      this.a(CreativeTab.c);
   }

   public boolean d(class_aen var1, class_cj var2) {
      return super.d(var1, var2) && this.c(var1.p(var2.b()).getBlock());
   }

   protected boolean c(Block var1) {
      return var1 == class_agk.c || var1 == class_agk.d || var1 == class_agk.ak;
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      this.e(var1, var2, var3);
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      this.e(var1, var2, var3);
   }

   protected void e(class_aen var1, class_cj var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         this.b(var1, var2, var3, 0);
         var1.a((class_cj)var2, (IBlockData)class_agk.a.S(), 3);
      }

   }

   public boolean f(class_aen var1, class_cj var2, IBlockData var3) {
      return this.c(var1.p(var2.b()).getBlock());
   }

   public class_awf a(class_aen var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }
}
