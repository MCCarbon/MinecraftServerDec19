package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumParticle;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.WorldServer;
import net.minecraft.server.ICommandListener;

public class CommandParticle extends CommandAbstract {
   public String getCommand() {
      return "particle";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.particle.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 8) {
         throw new class_cf("commands.particle.usage", new Object[0]);
      } else {
         boolean var3 = false;
         EnumParticle var4 = null;
         EnumParticle[] var5 = EnumParticle.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumParticle var8 = var5[var7];
            if(var8.f()) {
               if(var2[0].startsWith(var8.b())) {
                  var3 = true;
                  var4 = var8;
                  break;
               }
            } else if(var2[0].equals(var8.b())) {
               var3 = true;
               var4 = var8;
               break;
            }
         }

         if(!var3) {
            throw new class_bz("commands.particle.notFound", new Object[]{var2[0]});
         } else {
            String var30 = var2[0];
            Vec3D var31 = var1.d();
            double var32 = (double)((float)b(var31.x, var2[1], true));
            double var9 = (double)((float)b(var31.y, var2[2], true));
            double var11 = (double)((float)b(var31.z, var2[3], true));
            double var13 = (double)((float)c(var2[4]));
            double var15 = (double)((float)c(var2[5]));
            double var17 = (double)((float)c(var2[6]));
            double var19 = (double)((float)c(var2[7]));
            int var21 = 0;
            if(var2.length > 8) {
               var21 = a(var2[8], 0);
            }

            boolean var22 = false;
            if(var2.length > 9 && "force".equals(var2[9])) {
               var22 = true;
            }

            World var23 = var1.e();
            if(var23 instanceof WorldServer) {
               WorldServer var24 = (WorldServer)var23;
               int[] var25 = new int[var4.d()];
               if(var4.f()) {
                  String[] var26 = var2[0].split("_", 3);

                  for(int var27 = 1; var27 < var26.length; ++var27) {
                     try {
                        var25[var27 - 1] = Integer.parseInt(var26[var27]);
                     } catch (NumberFormatException var29) {
                        throw new class_bz("commands.particle.notFound", new Object[]{var2[0]});
                     }
                  }
               }

               var24.a(var4, var22, var32, var9, var11, var21, var13, var15, var17, var19, var25);
               a(var1, this, "commands.particle.success", new Object[]{var30, Integer.valueOf(Math.max(var21, 1))});
            }

         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, EnumParticle.a()):(var2.length > 1 && var2.length <= 4?a(var2, 1, var3):(var2.length == 10?a(var2, new String[]{"normal", "force"}):null));
   }
}
