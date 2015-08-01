package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Item;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.class_i;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class class_t extends class_i {
   public String c() {
      return "clear";
   }

   public String c(class_m var1) {
      return "commands.clear.usage";
   }

   public int a() {
      return 2;
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      EntityPlayer var3 = var2.length == 0?b(var1):a(var1, var2[0]);
      Item var4 = var2.length >= 2?f(var1, var2[1]):null;
      int var5 = var2.length >= 3?a(var2[2], -1):-1;
      int var6 = var2.length >= 4?a(var2[3], -1):-1;
      NBTTagCompound var7 = null;
      if(var2.length >= 5) {
         try {
            var7 = class_ed.a(a(var2, 4));
         } catch (class_ec var9) {
            throw new class_bz("commands.clear.tagError", new Object[]{var9.getMessage()});
         }
      }

      if(var2.length >= 2 && var4 == null) {
         throw new class_bz("commands.clear.failure", new Object[]{var3.getName()});
      } else {
         int var8 = var3.bp.a(var4, var5, var6, var7);
         var3.bq.b();
         if(!var3.bH.instabuild) {
            var3.o();
         }

         var1.a(class_n.class_a_in_class_n.d, var8);
         if(var8 == 0) {
            throw new class_bz("commands.clear.failure", new Object[]{var3.getName()});
         } else {
            if(var6 == 0) {
               var1.a(new ChatMessage("commands.clear.testing", new Object[]{var3.getName(), Integer.valueOf(var8)}));
            } else {
               a(var1, this, "commands.clear.success", new Object[]{var3.getName(), Integer.valueOf(var8)});
            }

         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, this.d()):(var2.length == 2?a(var2, Item.ITEM_REGISTRY.getKeys()):null);
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
