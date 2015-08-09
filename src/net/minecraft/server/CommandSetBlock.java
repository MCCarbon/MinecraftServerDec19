package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.CommandObjectiveExecutor;
import net.minecraft.server.IInventory;

public class CommandSetBlock extends CommandAbstract {
   public String getCommand() {
      return "setblock";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.setblock.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 4) {
         throw new class_cf("commands.setblock.usage", new Object[0]);
      } else {
         var1.a(CommandObjectiveExecutor.class_a_in_class_n.b, 0);
         BlockPosition var3 = a(var1, var2, 0, false);
         Block var4 = CommandAbstract.g(var1, var2[3]);
         int var5 = 0;
         if(var2.length >= 5) {
            var5 = a(var2[4], 0, 15);
         }

         World var6 = var1.e();
         if(!var6.isLoaded(var3)) {
            throw new class_bz("commands.setblock.outOfWorld", new Object[0]);
         } else {
            NBTTagCompound var7 = new NBTTagCompound();
            boolean var8 = false;
            if(var2.length >= 7 && var4.isTileEntity()) {
               String var9 = a(var1, var2, 6).c();

               try {
                  var7 = class_ed.a(var9);
                  var8 = true;
               } catch (class_ec var12) {
                  throw new class_bz("commands.setblock.tagError", new Object[]{var12.getMessage()});
               }
            }

            if(var2.length >= 6) {
               if(var2[5].equals("destroy")) {
                  var6.setAir(var3, true);
                  if(var4 == Blocks.AIR) {
                     a(var1, this, "commands.setblock.success", new Object[0]);
                     return;
                  }
               } else if(var2[5].equals("keep") && !var6.isEmpty(var3)) {
                  throw new class_bz("commands.setblock.noChange", new Object[0]);
               }
            }

            TileEntity var13 = var6.getTileEntity(var3);
            if(var13 != null) {
               if(var13 instanceof IInventory) {
                  ((IInventory)var13).remove();
               }

               var6.setTypeAndData(var3, Blocks.AIR.getBlockData(), var4 == Blocks.AIR?2:4);
            }

            IBlockData var10 = var4.fromLegacyData(var5);
            if(!var6.setTypeAndData((BlockPosition)var3, (IBlockData)var10, 2)) {
               throw new class_bz("commands.setblock.noChange", new Object[0]);
            } else {
               if(var8) {
                  TileEntity var11 = var6.getTileEntity(var3);
                  if(var11 != null) {
                     var7.put("x", var3.getX());
                     var7.put("y", var3.getY());
                     var7.put("z", var3.getZ());
                     var11.read(var7);
                  }
               }

               var6.update(var3, var10.getBlock());
               var1.a(CommandObjectiveExecutor.class_a_in_class_n.b, 1);
               a(var1, this, "commands.setblock.success", new Object[0]);
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, Block.BLOCK_REGISTRY.getKeys()):(var2.length == 6?a(var2, new String[]{"replace", "destroy", "keep"}):null));
   }
}
