package net.minecraft.server;

import java.util.EnumSet;
import java.util.List;

public class CommandTp extends CommandAbstract {
   public String getCommand() {
      return "tp";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.tp.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 1) {
         throw new class_cf("commands.tp.usage", new Object[0]);
      } else {
         byte var3 = 0;
         Object var4;
         if(var2.length != 2 && var2.length != 4 && var2.length != 6) {
            var4 = b(var1);
         } else {
            var4 = b(var1, var2[0]);
            var3 = 1;
         }

         if(var2.length != 1 && var2.length != 2) {
            if(var2.length < var3 + 3) {
               throw new class_cf("commands.tp.usage", new Object[0]);
            } else if(((Entity)var4).world != null) {
               int var14 = var3 + 1;
               CommandAbstract.class_a_in_class_i var6 = a(((Entity)var4).locX, var2[var3], true);
               CommandAbstract.class_a_in_class_i var7 = a(((Entity)var4).locY, var2[var14++], 0, 0, false);
               CommandAbstract.class_a_in_class_i var8 = a(((Entity)var4).locZ, var2[var14++], true);
               CommandAbstract.class_a_in_class_i var9 = a((double)((Entity)var4).yaw, var2.length > var14?var2[var14++]:"~", false);
               CommandAbstract.class_a_in_class_i var10 = a((double)((Entity)var4).pitch, var2.length > var14?var2[var14]:"~", false);
               float var12;
               if(var4 instanceof EntityPlayer) {
                  EnumSet var11 = EnumSet.noneOf(PacketPlayOutPosition.class_a_in_class_fi.class);
                  if(var6.c()) {
                     var11.add(PacketPlayOutPosition.class_a_in_class_fi.a);
                  }

                  if(var7.c()) {
                     var11.add(PacketPlayOutPosition.class_a_in_class_fi.b);
                  }

                  if(var8.c()) {
                     var11.add(PacketPlayOutPosition.class_a_in_class_fi.c);
                  }

                  if(var10.c()) {
                     var11.add(PacketPlayOutPosition.class_a_in_class_fi.e);
                  }

                  if(var9.c()) {
                     var11.add(PacketPlayOutPosition.class_a_in_class_fi.d);
                  }

                  var12 = (float)var9.b();
                  if(!var9.c()) {
                     var12 = MathHelper.clampAngle(var12);
                  }

                  float var13 = (float)var10.b();
                  if(!var10.c()) {
                     var13 = MathHelper.clampAngle(var13);
                  }

                  if(var13 > 90.0F || var13 < -90.0F) {
                     var13 = MathHelper.clampAngle(180.0F - var13);
                     var12 = MathHelper.clampAngle(var12 + 180.0F);
                  }

                  ((Entity)var4).a((Entity)null);
                  ((EntityPlayer)var4).playerConnection.a(var6.b(), var7.b(), var8.b(), var12, var13, var11);
                  ((Entity)var4).f(var12);
               } else {
                  float var15 = (float)MathHelper.clampAngle(var9.a());
                  var12 = (float)MathHelper.clampAngle(var10.a());
                  if(var12 > 90.0F || var12 < -90.0F) {
                     var12 = MathHelper.clampAngle(180.0F - var12);
                     var15 = MathHelper.clampAngle(var15 + 180.0F);
                  }

                  ((Entity)var4).setPositionRotation(var6.a(), var7.a(), var8.a(), var15, var12);
                  ((Entity)var4).f(var15);
               }

               a(var1, this, "commands.tp.success.coordinates", new Object[]{((Entity)var4).getName(), Double.valueOf(var6.a()), Double.valueOf(var7.a()), Double.valueOf(var8.a())});
            }
         } else {
            Entity var5 = b(var1, var2[var2.length - 1]);
            if(var5.world != ((Entity)var4).world) {
               throw new class_bz("commands.tp.notSameDimension", new Object[0]);
            } else {
               ((Entity)var4).a((Entity)null);
               if(var4 instanceof EntityPlayer) {
                  ((EntityPlayer)var4).playerConnection.a(var5.locX, var5.locY, var5.locZ, var5.yaw, var5.pitch);
               } else {
                  ((Entity)var4).setPositionRotation(var5.locX, var5.locY, var5.locZ, var5.yaw, var5.pitch);
               }

               a(var1, this, "commands.tp.success", new Object[]{((Entity)var4).getName(), var5.getName()});
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length != 1 && var2.length != 2?null:a(var2, MinecraftServer.getServer().getPlayers());
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
