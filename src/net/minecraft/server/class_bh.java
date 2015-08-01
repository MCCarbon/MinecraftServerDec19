package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_i;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;

public class class_bh extends class_i {
   public String c() {
      return "spawnpoint";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.spawnpoint.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length > 1 && var2.length < 4) {
         throw new class_cf("commands.spawnpoint.usage", new Object[0]);
      } else {
         EntityPlayer var3 = var2.length > 0?a(var1, var2[0]):b(var1);
         BlockPosition var4 = var2.length > 3?a(var1, var2, 1, true):var3.c();
         if(var3.o != null) {
            var3.a((BlockPosition)var4, true);
            a(var1, this, "commands.spawnpoint.success", new Object[]{var3.getName(), Integer.valueOf(var4.getX()), Integer.valueOf(var4.getY()), Integer.valueOf(var4.getZ())});
         }

      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().K()):(var2.length > 1 && var2.length <= 4?a(var2, 1, var3):null);
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
