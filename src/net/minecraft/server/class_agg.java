package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amf;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aok;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nl;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_agg extends class_agd {
   public class_agg() {
      super(Material.SHATTERABLE, MaterialMapColor.COLOR32);
      this.setStrength(3.0F);
      this.a(CreativeTab.f);
   }

   public class_amg a(World var1, int var2) {
      return new class_amf();
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amf) {
            var4.a((class_oj)((class_amf)var11));
            var4.b(class_nc.N);
         }

         return true;
      }
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, class_aas var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amf) {
            ((class_amf)var6).a(var5.q());
         }
      }

   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_amf) {
         ((class_amf)var5).m();
         var1.c(var2, this, 1, 0);
      }

   }

   public static void f(final World var0, final BlockPosition var1) {
      class_nl.a.submit(new Runnable() {
         public void run() {
            class_aok var1x = var0.f(var1);

            for(int var2 = var1.getY() - 1; var2 >= 0; --var2) {
               final BlockPosition var3 = new BlockPosition(var1.getX(), var2, var1.getZ());
               if(!var1x.d(var3)) {
                  break;
               }

               IBlockData var4 = var0.p(var3);
               if(var4.getBlock() == Blocks.BEACON) {
                  ((class_lg)var0).a(new Runnable() {
                     public void run() {
                        class_amg var1x = var0.s(var3);
                        if(var1x instanceof class_amf) {
                           ((class_amf)var1x).m();
                           var0.c(var3, Blocks.BEACON, 1, 0);
                        }

                     }
                  });
               }
            }

         }
      });
   }
}
