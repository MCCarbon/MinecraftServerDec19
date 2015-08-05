package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class CommandTestForBlock extends CommandAbstract {
   public String getCommand() {
      return "testforblock";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.testforblock.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 4) {
         throw new class_cf("commands.testforblock.usage", new Object[0]);
      } else {
         var1.a(class_n.class_a_in_class_n.b, 0);
         BlockPosition var3 = a(var1, var2, 0, false);
         Block var4 = Block.getByName(var2[3]);
         if(var4 == null) {
            throw new class_cb("commands.setblock.notFound", new Object[]{var2[3]});
         } else {
            int var5 = -1;
            if(var2.length >= 5) {
               var5 = a(var2[4], -1, 15);
            }

            World var6 = var1.e();
            if(!var6.e(var3)) {
               throw new class_bz("commands.testforblock.outOfWorld", new Object[0]);
            } else {
               NBTTagCompound var7 = new NBTTagCompound();
               boolean var8 = false;
               if(var2.length >= 6 && var4.isTileEntity()) {
                  String var9 = a(var1, var2, 5).c();

                  try {
                     var7 = class_ed.a(var9);
                     var8 = true;
                  } catch (class_ec var13) {
                     throw new class_bz("commands.setblock.tagError", new Object[]{var13.getMessage()});
                  }
               }

               IBlockData var14 = var6.getType(var3);
               Block var10 = var14.getBlock();
               if(var10 != var4) {
                  throw new class_bz("commands.testforblock.failed.tile", new Object[]{Integer.valueOf(var3.getX()), Integer.valueOf(var3.getY()), Integer.valueOf(var3.getZ()), var10.getName(), var4.getName()});
               } else {
                  if(var5 > -1) {
                     int var11 = var14.getBlock().toLegacyData(var14);
                     if(var11 != var5) {
                        throw new class_bz("commands.testforblock.failed.data", new Object[]{Integer.valueOf(var3.getX()), Integer.valueOf(var3.getY()), Integer.valueOf(var3.getZ()), Integer.valueOf(var11), Integer.valueOf(var5)});
                     }
                  }

                  if(var8) {
                     TileEntity var15 = var6.getTileEntity(var3);
                     if(var15 == null) {
                        throw new class_bz("commands.testforblock.failed.tileEntity", new Object[]{Integer.valueOf(var3.getX()), Integer.valueOf(var3.getY()), Integer.valueOf(var3.getZ())});
                     }

                     NBTTagCompound var12 = new NBTTagCompound();
                     var15.write(var12);
                     if(!class_dy.a(var7, var12, true)) {
                        throw new class_bz("commands.testforblock.failed.nbt", new Object[]{Integer.valueOf(var3.getX()), Integer.valueOf(var3.getY()), Integer.valueOf(var3.getZ())});
                     }
                  }

                  var1.a(class_n.class_a_in_class_n.b, 1);
                  a(var1, this, "commands.testforblock.success", new Object[]{Integer.valueOf(var3.getX()), Integer.valueOf(var3.getY()), Integer.valueOf(var3.getZ())});
               }
            }
         }
      }
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, Block.BLOCK_REGISTRY.getKeys()):null);
   }
}
