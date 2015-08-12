package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Enchantment;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.CommandObjectiveExecutor;

public class CommandEnchant extends CommandAbstract {
   public String getCommand() {
      return "enchant";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.enchant.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.enchant.usage", new Object[0]);
      } else {
         EntityPlayer var3 = a(var1, var2[0]);
         var1.a(CommandObjectiveExecutor.class_a_in_class_n.d, 0);

         Enchantment var4;
         try {
            var4 = Enchantment.c(a(var2[1], 0));
         } catch (class_cb var11) {
            var4 = Enchantment.b(var2[1]);
         }

         if(var4 == null) {
            throw new class_cb("commands.enchant.notFound", new Object[]{Integer.valueOf(Enchantment.b(var4))});
         } else {
            int var5 = 1;
            ItemStack var6 = var3.bA();
            if(var6 == null) {
               throw new class_bz("commands.enchant.noItem", new Object[0]);
            } else if(!var4.a(var6)) {
               throw new class_bz("commands.enchant.cantEnchant", new Object[0]);
            } else {
               if(var2.length >= 3) {
                  var5 = a(var2[2], var4.d(), var4.b());
               }

               if(var6.hasTag()) {
                  NBTTagList var7 = var6.getEnchantments();
                  if(var7 != null) {
                     for(int var8 = 0; var8 < var7.getSize(); ++var8) {
                        short var9 = var7.getCompound(var8).getShort("id");
                        if(Enchantment.c(var9) != null) {
                           Enchantment var10 = Enchantment.c(var9);
                           if(!var4.a(var10)) {
                              throw new class_bz("commands.enchant.cantCombine", new Object[]{var4.d(var5), var10.d(var7.getCompound(var8).getShort("lvl"))});
                           }
                        }
                     }
                  }
               }

               var6.addEnchantment(var4, var5);
               a(var1, this, "commands.enchant.success", new Object[0]);
               var1.a(CommandObjectiveExecutor.class_a_in_class_n.d, 1);
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, this.d()):(var2.length == 2?a(var2, Enchantment.b.getKeys()):null);
   }

   protected String[] d() {
      return MinecraftServer.getServer().getPlayers();
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
