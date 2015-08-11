package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class class_aeu {
   private static final int a = (int)Math.pow(17.0D, 2.0D);
   private final Set b = Sets.newHashSet();

   public int a(WorldServer var1, boolean var2, boolean var3, boolean var4) {
      if(!var2 && !var3) {
         return 0;
      } else {
         this.b.clear();
         int var5 = 0;
         Iterator var6 = var1.players.iterator();

         while(true) {
            EntityHuman var7;
            int var9;
            int var12;
            do {
               if(!var6.hasNext()) {
                  int var36 = 0;
                  BlockPosition var37 = var1.N();
                  EnumCreatureType[] var38 = EnumCreatureType.values();
                  var9 = var38.length;

                  label132:
                  for(int var39 = 0; var39 < var9; ++var39) {
                     EnumCreatureType var40 = var38[var39];
                     if((!var40.d() || var3) && (var40.d() || var2) && (!var40.e() || var4)) {
                        var12 = var1.a((Class)var40.a());
                        int var41 = var40.b() * var5 / a;
                        if(var12 <= var41) {
                           Iterator var42 = this.b.iterator();

                           label129:
                           while(true) {
                              int var17;
                              int var18;
                              int var19;
                              Block var20;
                              do {
                                 if(!var42.hasNext()) {
                                    continue label132;
                                 }

                                 class_aeh var15 = (class_aeh)var42.next();
                                 BlockPosition var16 = a(var1, var15.a, var15.b);
                                 var17 = var16.getX();
                                 var18 = var16.getY();
                                 var19 = var16.getZ();
                                 var20 = var1.getType(var16).getBlock();
                              } while(var20.isOccluding());

                              int var21 = 0;

                              for(int var22 = 0; var22 < 3; ++var22) {
                                 int var23 = var17;
                                 int var24 = var18;
                                 int var25 = var19;
                                 byte var26 = 6;
                                 BiomeBase.BiomeMeta var27 = null;
                                 class_qd var28 = null;

                                 for(int var29 = 0; var29 < 4; ++var29) {
                                    var23 += var1.random.nextInt(var26) - var1.random.nextInt(var26);
                                    var24 += var1.random.nextInt(1) - var1.random.nextInt(1);
                                    var25 += var1.random.nextInt(var26) - var1.random.nextInt(var26);
                                    BlockPosition var30 = new BlockPosition(var23, var24, var25);
                                    float var31 = (float)var23 + 0.5F;
                                    float var32 = (float)var25 + 0.5F;
                                    if(!var1.b((double)var31, (double)var24, (double)var32, 24.0D) && var37.distanceSquared((double)var31, (double)var24, (double)var32) >= 576.0D) {
                                       if(var27 == null) {
                                          var27 = var1.a(var40, var30);
                                          if(var27 == null) {
                                             break;
                                          }
                                       }

                                       if(var1.a(var40, var27, var30) && a(class_qe.a(var27.b), var1, var30)) {
                                          EntityInsentient var33;
                                          try {
                                             var33 = (EntityInsentient)var27.b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
                                          } catch (Exception var35) {
                                             var35.printStackTrace();
                                             return var36;
                                          }

                                          var33.b((double)var31, (double)var24, (double)var32, var1.random.nextFloat() * 360.0F, 0.0F);
                                          if(var33.cf() && var33.cg()) {
                                             var28 = var33.a(var1.E(new BlockPosition(var33)), var28);
                                             if(var33.cg()) {
                                                ++var21;
                                                var1.addEntity((Entity)var33);
                                             }

                                             if(var21 >= var33.cj()) {
                                                continue label129;
                                             }
                                          }

                                          var36 += var21;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  return var36;
               }

               var7 = (EntityHuman)var6.next();
            } while(var7.isSpectator());

            int var8 = MathHelper.floor(var7.locX / 16.0D);
            var9 = MathHelper.floor(var7.locZ / 16.0D);
            byte var10 = 8;

            for(int var11 = -var10; var11 <= var10; ++var11) {
               for(var12 = -var10; var12 <= var10; ++var12) {
                  boolean var13 = var11 == -var10 || var11 == var10 || var12 == -var10 || var12 == var10;
                  class_aeh var14 = new class_aeh(var11 + var8, var12 + var9);
                  if(!this.b.contains(var14)) {
                     ++var5;
                     if(!var13 && var1.ag().a(var14)) {
                        this.b.add(var14);
                     }
                  }
               }
            }
         }
      }
   }

   protected static BlockPosition a(World var0, int var1, int var2) {
      Chunk var3 = var0.getChunkAt(var1, var2);
      int var4 = var1 * 16 + var0.random.nextInt(16);
      int var5 = var2 * 16 + var0.random.nextInt(16);
      int var6 = MathHelper.ceilByBase(var3.f(new BlockPosition(var4, 0, var5)) + 1, 16);
      int var7 = var0.random.nextInt(var6 > 0?var6:var3.getHighestChunkSectionY() + 16 - 1);
      return new BlockPosition(var4, var7, var5);
   }

   public static boolean a(EntityInsentient.class_a_in_class_qb var0, World var1, BlockPosition var2) {
      if(!var1.ag().a(var2)) {
         return false;
      } else {
         Block var3 = var1.getType(var2).getBlock();
         if(var0 == EntityInsentient.class_a_in_class_qb.c) {
            return var3.getMaterial().isLiquid() && var1.getType(var2.down()).getBlock().getMaterial().isLiquid() && !var1.getType(var2.up()).getBlock().isOccluding();
         } else {
            BlockPosition var4 = var2.down();
            if(!World.a((IBlockAccess)var1, (BlockPosition)var4)) {
               return false;
            } else {
               Block var5 = var1.getType(var4).getBlock();
               boolean var6 = var5 != Blocks.BEDROCK && var5 != Blocks.BARRIER;
               return var6 && !var3.isOccluding() && !var3.getMaterial().isLiquid() && !var1.getType(var2.up()).getBlock().isOccluding();
            }
         }
      }
   }

   public static void a(World var0, BiomeBase var1, int var2, int var3, int var4, int var5, Random var6) {
      List var7 = var1.a(EnumCreatureType.b);
      if(!var7.isEmpty()) {
         while(var6.nextFloat() < var1.g()) {
            BiomeBase.BiomeMeta var8 = (BiomeBase.BiomeMeta)class_oc.a(var0.random, var7);
            int var9 = var8.c + var6.nextInt(1 + var8.d - var8.c);
            class_qd var10 = null;
            int var11 = var2 + var6.nextInt(var4);
            int var12 = var3 + var6.nextInt(var5);
            int var13 = var11;
            int var14 = var12;

            for(int var15 = 0; var15 < var9; ++var15) {
               boolean var16 = false;

               for(int var17 = 0; !var16 && var17 < 4; ++var17) {
                  BlockPosition var18 = var0.r(new BlockPosition(var11, 0, var12));
                  if(a(EntityInsentient.class_a_in_class_qb.a, var0, var18)) {
                     EntityInsentient var19;
                     try {
                        var19 = (EntityInsentient)var8.b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var0});
                     } catch (Exception var21) {
                        var21.printStackTrace();
                        continue;
                     }

                     var19.b((double)((float)var11 + 0.5F), (double)var18.getY(), (double)((float)var12 + 0.5F), var6.nextFloat() * 360.0F, 0.0F);
                     var0.addEntity((Entity)var19);
                     var10 = var19.a(var0.E(new BlockPosition(var19)), var10);
                     var16 = true;
                  }

                  var11 += var6.nextInt(5) - var6.nextInt(5);

                  for(var12 += var6.nextInt(5) - var6.nextInt(5); var11 < var2 || var11 >= var2 + var4 || var12 < var3 || var12 >= var3 + var4; var12 = var14 + var6.nextInt(5) - var6.nextInt(5)) {
                     var11 = var13 + var6.nextInt(5) - var6.nextInt(5);
                  }
               }
            }
         }

      }
   }
}
