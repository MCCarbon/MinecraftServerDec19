package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahz;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pr;
import net.minecraft.server.CreativeTab;

public abstract class class_age extends Block {
   protected class_age(Material var1) {
      this(var1, var1.getMapColor());
   }

   protected class_age(Material var1, MaterialMapColor var2) {
      super(var1, var2);
      this.a((CreativeTab)CreativeTab.d);
      this.setTicking(true);
   }

   public void a(class_aer var1, class_cj var2) {
      this.d(var1.p(var2));
   }

   protected void d(IBlockData var1) {
      boolean var2 = this.e(var1) > 0;
      float var3 = 0.0625F;
      if(var2) {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F, 0.9375F);
      } else {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
      }

   }

   public int a(World var1) {
      return 20;
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(class_aer var1, class_cj var2) {
      return true;
   }

   public boolean g() {
      return true;
   }

   public boolean d(World var1, class_cj var2) {
      return this.m(var1, var2.b());
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(!this.m(var1, var2.b())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private boolean m(World var1, class_cj var2) {
      return World.a((class_aer)var1, (class_cj)var2) || var1.p(var2).getBlock() instanceof class_ahz;
   }

   public void a(World var1, class_cj var2, IBlockData var3, Random var4) {
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         int var5 = this.e(var3);
         if(var5 > 0) {
            this.a(var1, var2, var3, var5);
         }

      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_pr var4) {
      if(!var1.D) {
         int var5 = this.e(var3);
         if(var5 == 0) {
            this.a(var1, var2, var3, var5);
         }

      }
   }

   protected void a(World var1, class_cj var2, IBlockData var3, int var4) {
      int var5 = this.f(var1, var2);
      boolean var6 = var4 > 0;
      boolean var7 = var5 > 0;
      if(var4 != var5) {
         var3 = this.a(var3, var5);
         var1.a((class_cj)var2, (IBlockData)var3, 2);
         this.e(var1, var2);
         var1.b(var2, var2);
      }

      if(!var7 && var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
      } else if(var7 && !var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(var7) {
         var1.a((class_cj)var2, (Block)this, this.a(var1));
      }

   }

   protected class_awf a(class_cj var1) {
      float var2 = 0.125F;
      return new class_awf((double)((float)var1.n() + 0.125F), (double)var1.o(), (double)((float)var1.p() + 0.125F), (double)((float)(var1.n() + 1) - 0.125F), (double)var1.o() + 0.25D, (double)((float)(var1.p() + 1) - 0.125F));
   }

   public void b(World var1, class_cj var2, IBlockData var3) {
      if(this.e(var3) > 0) {
         this.e(var1, var2);
      }

      super.b(var1, var2, var3);
   }

   protected void e(World var1, class_cj var2) {
      var1.c((class_cj)var2, (Block)this);
      var1.c((class_cj)var2.b(), (Block)this);
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return this.e(var3);
   }

   public int b(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return var4 == class_cq.b?this.e(var3):0;
   }

   public boolean isPowerSource() {
      return true;
   }

   public void j() {
      float var1 = 0.5F;
      float var2 = 0.125F;
      float var3 = 0.5F;
      this.setSizes(0.0F, 0.375F, 0.0F, 1.0F, 0.625F, 1.0F);
   }

   public int k() {
      return 1;
   }

   protected abstract int f(World var1, class_cj var2);

   protected abstract int e(IBlockData var1);

   protected abstract IBlockData a(IBlockData var1, int var2);
}
