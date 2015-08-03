package net.minecraft.server;

public class class_auz extends class_auu {
   private boolean f;
   private boolean g;
   private boolean h;
   private boolean i;
   private boolean j;

   public void a(IBlockAccess var1, Entity var2) {
      super.a(var1, var2);
      this.j = this.h;
   }

   public void a() {
      super.a();
      this.h = this.j;
   }

   public class_aut a(Entity var1) {
      int var2;
      if(this.i && var1.V()) {
         var2 = (int)var1.aT().yMin;
         BlockPosition.MutableBlockPosition var3 = new BlockPosition.MutableBlockPosition(MathHelper.floor(var1.s), var2, MathHelper.floor(var1.u));

         for(Block var4 = this.a.getType(var3).getBlock(); var4 == Blocks.FLOWING_WATER || var4 == Blocks.WATER; var4 = this.a.getType(var3).getBlock()) {
            ++var2;
            var3.setPosition(MathHelper.floor(var1.s), var2, MathHelper.floor(var1.u));
         }

         this.h = false;
      } else {
         var2 = MathHelper.floor(var1.aT().yMin + 0.5D);
      }

      return this.a(MathHelper.floor(var1.aT().xMin), var2, MathHelper.floor(var1.aT().zMin));
   }

   public class_aut a(Entity var1, double var2, double var4, double var6) {
      return this.a(MathHelper.floor(var2 - (double)(var1.J / 2.0F)), MathHelper.floor(var4), MathHelper.floor(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(class_aut[] var1, Entity var2, class_aut var3, class_aut var4, float var5) {
      int var6 = 0;
      byte var7 = 0;
      if(this.a(var2, var3.a, var3.b + 1, var3.c) == 1) {
         var7 = 1;
      }

      class_aut var8 = this.a(var2, var3.a, var3.b, var3.c + 1, var7);
      class_aut var9 = this.a(var2, var3.a - 1, var3.b, var3.c, var7);
      class_aut var10 = this.a(var2, var3.a + 1, var3.b, var3.c, var7);
      class_aut var11 = this.a(var2, var3.a, var3.b, var3.c - 1, var7);
      if(var8 != null && !var8.i && var8.a(var4) < var5) {
         var1[var6++] = var8;
      }

      if(var9 != null && !var9.i && var9.a(var4) < var5) {
         var1[var6++] = var9;
      }

      if(var10 != null && !var10.i && var10.a(var4) < var5) {
         var1[var6++] = var10;
      }

      if(var11 != null && !var11.i && var11.a(var4) < var5) {
         var1[var6++] = var11;
      }

      return var6;
   }

   private class_aut a(Entity var1, int var2, int var3, int var4, int var5) {
      class_aut var6 = null;
      int var7 = this.a(var1, var2, var3, var4);
      if(var7 == 2) {
         return this.a(var2, var3, var4);
      } else {
         if(var7 == 1) {
            var6 = this.a(var2, var3, var4);
         }

         if(var6 == null && var5 > 0 && var7 != -3 && var7 != -4 && this.a(var1, var2, var3 + var5, var4) == 1) {
            var6 = this.a(var2, var3 + var5, var4);
            var3 += var5;
         }

         if(var6 != null) {
            int var8 = 0;

            int var9;
            for(var9 = 0; var3 > 0; var6 = this.a(var2, var3, var4)) {
               var9 = this.a(var1, var2, var3 - 1, var4);
               if(this.h && var9 == -1) {
                  return null;
               }

               if(var9 != 1) {
                  break;
               }

               if(var8++ >= var1.aG()) {
                  return null;
               }

               --var3;
               if(var3 <= 0) {
                  return null;
               }
            }

            if(var9 == -2) {
               return null;
            }
         }

         return var6;
      }
   }

   private int a(Entity var1, int var2, int var3, int var4) {
      return a(this.a, var1, var2, var3, var4, this.c, this.d, this.e, this.h, this.g, this.f);
   }

   public static int a(IBlockAccess var0, Entity var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10) {
      boolean var11 = false;
      BlockPosition var12 = new BlockPosition(var1);
      BlockPosition.MutableBlockPosition var13 = new BlockPosition.MutableBlockPosition();

      for(int var14 = var2; var14 < var2 + var5; ++var14) {
         for(int var15 = var3; var15 < var3 + var6; ++var15) {
            for(int var16 = var4; var16 < var4 + var7; ++var16) {
               var13.setPosition(var14, var15, var16);
               Block var17 = var0.getType(var13).getBlock();
               if(var17.getMaterial() != Material.AIR) {
                  if(var17 != Blocks.TRAPDOOR && var17 != Blocks.IRON_TRAPDOOR) {
                     if(var17 != Blocks.FLOWING_WATER && var17 != Blocks.WATER) {
                        if(!var10 && var17 instanceof BlockDoor && var17.getMaterial() == Material.WOOD) {
                           return 0;
                        }
                     } else {
                        if(var8) {
                           return -1;
                        }

                        var11 = true;
                     }
                  } else {
                     var11 = true;
                  }

                  if(var1.o.getType(var13).getBlock() instanceof BlockMinecartTrackAbstract) {
                     if(!(var1.o.getType(var12).getBlock() instanceof BlockMinecartTrackAbstract) && !(var1.o.getType(var12.down()).getBlock() instanceof BlockMinecartTrackAbstract)) {
                        return -3;
                     }
                  } else if(!var17.isPassable(var0, var13) && (!var9 || !(var17 instanceof BlockDoor) || var17.getMaterial() != Material.WOOD)) {
                     if(var17 instanceof BlockFence || var17 instanceof BlockFenceGate || var17 instanceof BlockCobbleWall) {
                        return -3;
                     }

                     if(var17 == Blocks.TRAPDOOR || var17 == Blocks.IRON_TRAPDOOR) {
                        return -4;
                     }

                     Material var18 = var17.getMaterial();
                     if(var18 != Material.LAVA) {
                        return 0;
                     }

                     if(!var1.ab()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return var11?2:1;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void b(boolean var1) {
      this.g = var1;
   }

   public void c(boolean var1) {
      this.h = var1;
   }

   public void d(boolean var1) {
      this.i = var1;
   }

   public boolean b() {
      return this.f;
   }

   public boolean d() {
      return this.i;
   }

   public boolean e() {
      return this.h;
   }
}
