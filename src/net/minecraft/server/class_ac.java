package net.minecraft.server;

import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;

public class class_ac extends class_i {
   public String getCommand() {
      return "entitydata";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.entitydata.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.entitydata.usage", new Object[0]);
      } else {
         Entity var3 = b(var1, var2[0]);
         if(var3 instanceof EntityHuman) {
            throw new class_bz("commands.entitydata.noPlayers", new Object[]{var3.getScoreboardDisplayName()});
         } else {
            NBTTagCompound var4 = new NBTTagCompound();
            var3.e(var4);
            NBTTagCompound var5 = (NBTTagCompound)var4.clone();

            NBTTagCompound var6;
            try {
               var6 = class_ed.a(a(var1, var2, 1).c());
            } catch (class_ec var8) {
               throw new class_bz("commands.entitydata.tagError", new Object[]{var8.getMessage()});
            }

            var6.remove("UUIDMost");
            var6.remove("UUIDLeast");
            var4.copyFrom(var6);
            if(var4.equals(var5)) {
               throw new class_bz("commands.entitydata.failed", new Object[]{var4.toString()});
            } else {
               var3.f(var4);
               a(var1, this, "commands.entitydata.success", new Object[]{var4.toString()});
            }
         }
      }
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
