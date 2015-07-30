package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_vi;

public class class_bm extends class_i {
   public String c() {
      return "summon";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.summon.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 1) {
         throw new class_cf("commands.summon.usage", new Object[0]);
      } else {
         String var3 = var2[0];
         BlockPosition var4 = var1.c();
         Vec3D var5 = var1.d();
         double var6 = var5.x;
         double var8 = var5.y;
         double var10 = var5.z;
         if(var2.length >= 4) {
            var6 = b(var6, var2[1], true);
            var8 = b(var8, var2[2], false);
            var10 = b(var10, var2[3], true);
            var4 = new BlockPosition(var6, var8, var10);
         }

         World var12 = var1.e();
         if(!var12.e(var4)) {
            throw new class_bz("commands.summon.outOfWorld", new Object[0]);
         } else if("LightningBolt".equals(var3)) {
            var12.d((class_pr)(new class_vi(var12, var6, var8, var10)));
            a(var1, this, "commands.summon.success", new Object[0]);
         } else {
            class_dn var13 = new class_dn();
            boolean var14 = false;
            if(var2.length >= 5) {
               IChatBaseComponent var15 = a(var1, var2, 4);

               try {
                  var13 = class_ed.a(var15.c());
                  var14 = true;
               } catch (class_ec var20) {
                  throw new class_bz("commands.summon.tagError", new Object[]{var20.getMessage()});
               }
            }

            var13.a("id", var3);

            class_pr var21;
            try {
               var21 = class_pt.a(var13, var12);
            } catch (RuntimeException var19) {
               throw new class_bz("commands.summon.failed", new Object[0]);
            }

            if(var21 == null) {
               throw new class_bz("commands.summon.failed", new Object[0]);
            } else {
               var21.b(var6, var8, var10, var21.y, var21.z);
               if(!var14 && var21 instanceof class_qb) {
                  ((class_qb)var21).a((class_on)var12.E(new BlockPosition(var21)), (class_qd)null);
               }

               if(!var12.a(var21)) {
                  throw new class_bz("commands.summon.failed", new Object[0]);
               } else {
                  class_pr var16 = var21;

                  for(class_dn var17 = var13; var16 != null && var17.b("Riding", 10); var17 = var17.n("Riding")) {
                     class_pr var18 = class_pt.a(var17.n("Riding"), var12);
                     if(var18 != null) {
                        var18.b(var6, var8, var10, var18.y, var18.z);
                        var12.a(var18);
                        var16.a(var18);
                     }

                     var16 = var18;
                  }

                  a(var1, this, "commands.summon.success", new Object[0]);
               }
            }
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, class_pt.b()):(var2.length > 1 && var2.length <= 4?a(var2, 1, var3):null);
   }
}
