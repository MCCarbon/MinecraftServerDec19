package net.minecraft.server;

import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vk;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zi extends Item {
   public class_zi() {
      this.h = 1;
      this.a(CreativeTab.e);
   }

   public class_or a(ItemStack var1, World var2, class_xa var3, EnumUsedHand var4) {
      float var5 = 1.0F;
      float var6 = var3.B + (var3.z - var3.B) * var5;
      float var7 = var3.A + (var3.y - var3.A) * var5;
      double var8 = var3.p + (var3.s - var3.p) * (double)var5;
      double var10 = var3.q + (var3.t - var3.q) * (double)var5 + (double)var3.aU();
      double var12 = var3.r + (var3.u - var3.r) * (double)var5;
      Vec3D var14 = new Vec3D(var8, var10, var12);
      float var15 = MathHelper.cos(-var7 * 0.017453292F - 3.1415927F);
      float var16 = MathHelper.sin(-var7 * 0.017453292F - 3.1415927F);
      float var17 = -MathHelper.cos(-var6 * 0.017453292F);
      float var18 = MathHelper.sin(-var6 * 0.017453292F);
      float var19 = var16 * var17;
      float var21 = var15 * var17;
      double var22 = 5.0D;
      Vec3D var24 = var14.add((double)var19 * var22, (double)var18 * var22, (double)var21 * var22);
      class_awg var25 = var2.a(var14, var24, true);
      if(var25 == null) {
         return new class_or(class_oq.b, var1);
      } else {
         Vec3D var26 = var3.d(var5);
         boolean var27 = false;
         float var28 = 1.0F;
         List var29 = var2.b((class_pr)var3, (class_awf)var3.aT().a(var26.x * var22, var26.y * var22, var26.z * var22).b((double)var28, (double)var28, (double)var28));

         for(int var30 = 0; var30 < var29.size(); ++var30) {
            class_pr var31 = (class_pr)var29.get(var30);
            if(var31.ad()) {
               float var32 = var31.ao();
               class_awf var33 = var31.aT().b((double)var32, (double)var32, (double)var32);
               if(var33.a(var14)) {
                  var27 = true;
               }
            }
         }

         if(var27) {
            return new class_or(class_oq.b, var1);
         } else if(var25.a == class_awg.class_a_in_class_awg.b) {
            BlockPosition var34 = var25.a();
            if(var2.p(var34).getBlock() == Blocks.SNOW_LAYER) {
               var34 = var34.shiftDown();
            }

            class_vk var35 = new class_vk(var2, (double)((float)var34.getX() + 0.5F), (double)((float)var34.getY() + 1.0F), (double)((float)var34.getZ() + 0.5F));
            var35.y = (float)(((MathHelper.floor((double)(var3.y * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);
            if(!var2.a((class_pr)var35, (class_awf)var35.aT().b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
               return new class_or(class_oq.b, var1);
            } else {
               if(!var2.D) {
                  var2.a((class_pr)var35);
               }

               if(!var3.bH.d) {
                  --var1.count;
               }

               var3.b(class_nc.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, var1);
            }
         } else {
            return new class_or(class_oq.b, var1);
         }
      }
   }
}
