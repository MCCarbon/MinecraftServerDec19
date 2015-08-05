package net.minecraft.server;

import java.util.List;

public class class_af extends CommandAbstract {
	
   public String getCommand() {
      return "fill";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.fill.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 7) {
         throw new class_cf("commands.fill.usage", new Object[0]);
      } else {
         var1.a(class_n.class_a_in_class_n.b, 0);
         BlockPosition var3 = a(var1, var2, 0, false);
         BlockPosition var4 = a(var1, var2, 3, false);
         Block var5 = class_i.g(var1, var2[6]);
         int var6 = 0;
         if(var2.length >= 8) {
            var6 = a(var2[7], 0, 15);
         }

         BlockPosition var7 = new BlockPosition(Math.min(var3.getX(), var4.getX()), Math.min(var3.getY(), var4.getY()), Math.min(var3.getZ(), var4.getZ()));
         BlockPosition var8 = new BlockPosition(Math.max(var3.getX(), var4.getX()), Math.max(var3.getY(), var4.getY()), Math.max(var3.getZ(), var4.getZ()));
         int var9 = (var8.getX() - var7.getX() + 1) * (var8.getY() - var7.getY() + 1) * (var8.getZ() - var7.getZ() + 1);
         if(var9 > '耀') {
            throw new class_bz("commands.fill.tooManyBlocks", new Object[]{Integer.valueOf(var9), Integer.valueOf('耀')});
         } else if(var7.getY() >= 0 && var8.getY() < 256) {
            World var10 = var1.e();

            for(int var11 = var7.getZ(); var11 < var8.getZ() + 16; var11 += 16) {
               for(int var12 = var7.getX(); var12 < var8.getX() + 16; var12 += 16) {
                  if(!var10.e(new BlockPosition(var12, var8.getY() - var7.getY(), var11))) {
                     throw new class_bz("commands.fill.outOfWorld", new Object[0]);
                  }
               }
            }

            NBTTagCompound var22 = new NBTTagCompound();
            boolean var23 = false;
            if(var2.length >= 10 && var5.isTileEntity()) {
               String var13 = a(var1, var2, 9).c();

               try {
                  var22 = class_ed.a(var13);
                  var23 = true;
               } catch (class_ec var21) {
                  throw new class_bz("commands.fill.tagError", new Object[]{var21.getMessage()});
               }
            }

            ArrayList var24 = Lists.newArrayList();
            var9 = 0;

            for(int var14 = var7.getZ(); var14 <= var8.getZ(); ++var14) {
               for(int var15 = var7.getY(); var15 <= var8.getY(); ++var15) {
                  for(int var16 = var7.getX(); var16 <= var8.getX(); ++var16) {
                     BlockPosition var17 = new BlockPosition(var16, var15, var14);
                     IBlockData var19;
                     if(var2.length >= 9) {
                        if(!var2[8].equals("outline") && !var2[8].equals("hollow")) {
                           if(var2[8].equals("destroy")) {
                              var10.setAir(var17, true);
                           } else if(var2[8].equals("keep")) {
                              if(!var10.isEmpty(var17)) {
                                 continue;
                              }
                           } else if(var2[8].equals("replace") && !var5.isTileEntity()) {
                              if(var2.length > 9) {
                                 Block var18 = class_i.g(var1, var2[9]);
                                 if(var10.getType(var17).getBlock() != var18) {
                                    continue;
                                 }
                              }

                              if(var2.length > 10) {
                                 int var28 = class_i.a(var2[10]);
                                 var19 = var10.getType(var17);
                                 if(var19.getBlock().toLegacyData(var19) != var28) {
                                    continue;
                                 }
                              }
                           }
                        } else if(var16 != var7.getX() && var16 != var8.getX() && var15 != var7.getY() && var15 != var8.getY() && var14 != var7.getZ() && var14 != var8.getZ()) {
                           if(var2[8].equals("hollow")) {
                              var10.setTypeAndData((BlockPosition)var17, (IBlockData)Blocks.AIR.getBlockData(), 2);
                              var24.add(var17);
                           }
                           continue;
                        }
                     }

                     TileEntity var29 = var10.getTileEntity(var17);
                     if(var29 != null) {
                        if(var29 instanceof IInventory) {
                           ((IInventory)var29).remove();
                        }

                        var10.setTypeAndData(var17, Blocks.BARRIER.getBlockData(), var5 == Blocks.BARRIER?2:4);
                     }

                     var19 = var5.fromLegacyData(var6);
                     if(var10.setTypeAndData((BlockPosition)var17, (IBlockData)var19, 2)) {
                        var24.add(var17);
                        ++var9;
                        if(var23) {
                           TileEntity var20 = var10.getTileEntity(var17);
                           if(var20 != null) {
                              var22.put("x", var17.getX());
                              var22.put("y", var17.getY());
                              var22.put("z", var17.getZ());
                              var20.read(var22);
                           }
                        }
                     }
                  }
               }
            }

            Iterator var25 = var24.iterator();

            while(var25.hasNext()) {
               BlockPosition var26 = (BlockPosition)var25.next();
               Block var27 = var10.getType(var26).getBlock();
               var10.update(var26, var27);
            }

            if(var9 <= 0) {
               throw new class_bz("commands.fill.failed", new Object[0]);
            } else {
               var1.a(class_n.class_a_in_class_n.b, var9);
               a(var1, this, "commands.fill.success", new Object[]{Integer.valueOf(var9)});
            }
         } else {
            throw new class_bz("commands.fill.outOfWorld", new Object[0]);
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length == 7?a(var2, Block.BLOCK_REGISTRY.getKeys()):(var2.length == 9?a(var2, new String[]{"replace", "destroy", "keep", "hollow", "outline"}):(var2.length == 10 && "replace".equals(var2[8])?a(var2, Block.BLOCK_REGISTRY.getKeys()):null))));
   }
}
