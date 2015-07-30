package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.World;
import net.minecraft.server.class_aet;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiq;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aix extends class_aiq {
   public class_aix() {
      super(Material.ICE, false);
      this.frictionFactor = 0.98F;
      this.setTicking(true);
      this.a(CreativeTab.b);
   }

   public void a(World var1, class_xa var2, BlockPosition var3, IBlockData var4, class_amg var5, class_aas var6) {
      var2.b(class_nc.ab[Block.getId((Block)this)]);
      var2.a(0.025F);
      if(this.K() && class_adk.a(class_adm.q, var6) > 0) {
         class_aas var9 = this.i(var4);
         if(var9 != null) {
            a(var1, var3, var9);
         }
      } else {
         if(var1.t.l()) {
            var1.g(var3);
            return;
         }

         int var7 = class_adk.a(class_adm.s, var6);
         this.b(var1, var3, var4, var7);
         Material var8 = var1.p(var3.shiftDown()).getBlock().getMaterial();
         if(var8.isSolid() || var8.isLiquid()) {
            var1.a(var3, Blocks.FLOWING_WATER.getBlockData());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.b(class_aet.b, var2) > 11 - this.getLightOpacity()) {
         if(var1.t.l()) {
            var1.g(var2);
         } else {
            this.b(var1, var2, var1.p(var2), 0);
            var1.a(var2, Blocks.WATER.getBlockData());
         }
      }
   }

   public int getPushReaction() {
      return 0;
   }
}
