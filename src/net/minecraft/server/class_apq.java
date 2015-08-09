package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockChorusFlower;
import net.minecraft.server.BlockFalling;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.Chunk;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_aqj;
import net.minecraft.server.WorldGenEndCity;
import net.minecraft.server.NoiseGeneratorOctaves;
import net.minecraft.server.class_ate;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.IProgressUpdate;
import net.minecraft.server.EnumCreatureType;

public class class_apq implements IChunkProvider {
   private Random f;
   private NoiseGeneratorOctaves g;
   private NoiseGeneratorOctaves h;
   private NoiseGeneratorOctaves i;
   public NoiseGeneratorOctaves a;
   public NoiseGeneratorOctaves b;
   private World j;
   private WorldGenEndCity k = new WorldGenEndCity(this);
   private class_ate l;
   private double[] m;
   private BiomeBase[] n;
   double[] c;
   double[] d;
   double[] e;
   private class_aqj o = new class_aqj();

   public class_apq(World var1, long var2) {
      this.j = var1;
      this.f = new Random(var2);
      this.g = new NoiseGeneratorOctaves(this.f, 16);
      this.h = new NoiseGeneratorOctaves(this.f, 16);
      this.i = new NoiseGeneratorOctaves(this.f, 8);
      this.a = new NoiseGeneratorOctaves(this.f, 10);
      this.b = new NoiseGeneratorOctaves(this.f, 16);
      this.l = new class_ate(this.f);
   }

   public void a(int var1, int var2, class_aph var3) {
      byte var4 = 2;
      int var5 = var4 + 1;
      byte var6 = 33;
      int var7 = var4 + 1;
      this.m = this.a(this.m, var1 * var4, 0, var2 * var4, var5, var6, var7);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var4; ++var9) {
            for(int var10 = 0; var10 < 32; ++var10) {
               double var11 = 0.25D;
               double var13 = this.m[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 0];
               double var15 = this.m[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 0];
               double var17 = this.m[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 0];
               double var19 = this.m[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 0];
               double var21 = (this.m[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 1] - var13) * var11;
               double var23 = (this.m[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 1] - var15) * var11;
               double var25 = (this.m[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 1] - var17) * var11;
               double var27 = (this.m[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 1] - var19) * var11;

               for(int var29 = 0; var29 < 4; ++var29) {
                  double var30 = 0.125D;
                  double var32 = var13;
                  double var34 = var15;
                  double var36 = (var17 - var13) * var30;
                  double var38 = (var19 - var15) * var30;

                  for(int var40 = 0; var40 < 8; ++var40) {
                     double var41 = 0.125D;
                     double var43 = var32;
                     double var45 = (var34 - var32) * var41;

                     for(int var47 = 0; var47 < 8; ++var47) {
                        IBlockData var48 = null;
                        if(var43 > 0.0D) {
                           var48 = Blocks.END_STONE.getBlockData();
                        }

                        int var49 = var40 + var8 * 8;
                        int var50 = var29 + var10 * 4;
                        int var51 = var47 + var9 * 8;
                        var3.a(var49, var50, var51, var48);
                        var43 += var45;
                     }

                     var32 += var36;
                     var34 += var38;
                  }

                  var13 += var21;
                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
               }
            }
         }
      }

   }

   public void a(class_aph var1) {
      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            byte var4 = 1;
            int var5 = -1;
            IBlockData var6 = Blocks.END_STONE.getBlockData();
            IBlockData var7 = Blocks.END_STONE.getBlockData();

            for(int var8 = 127; var8 >= 0; --var8) {
               IBlockData var9 = var1.a(var2, var8, var3);
               if(var9.getBlock().getMaterial() == Material.AIR) {
                  var5 = -1;
               } else if(var9.getBlock() == Blocks.STONE) {
                  if(var5 == -1) {
                     if(var4 <= 0) {
                        var6 = Blocks.AIR.getBlockData();
                        var7 = Blocks.END_STONE.getBlockData();
                     }

                     var5 = var4;
                     if(var8 >= 0) {
                        var1.a(var2, var8, var3, var6);
                     } else {
                        var1.a(var2, var8, var3, var7);
                     }
                  } else if(var5 > 0) {
                     --var5;
                     var1.a(var2, var8, var3, var7);
                  }
               }
            }
         }
      }

   }

   public Chunk getOrCreateChunk(int var1, int var2) {
      this.f.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      class_aph var3 = new class_aph();
      this.n = this.j.w().b(this.n, var1 * 16, var2 * 16, 16, 16);
      this.a(var1, var2, var3);
      this.a(var3);
      this.k.a(this, this.j, var1, var2, var3);
      Chunk var4 = new Chunk(this.j, var3, var1, var2);
      byte[] var5 = var4.k();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.n[var6].az;
      }

      var4.b();
      return var4;
   }

   private float a(int var1, int var2, int var3, int var4) {
      float var5 = (float)(var1 * 2 + var3);
      float var6 = (float)(var2 * 2 + var4);
      float var7 = 100.0F - MathHelper.sqrt(var5 * var5 + var6 * var6) * 8.0F;
      if(var7 > 80.0F) {
         var7 = 80.0F;
      }

      if(var7 < -100.0F) {
         var7 = -100.0F;
      }

      for(int var8 = -12; var8 <= 12; ++var8) {
         for(int var9 = -12; var9 <= 12; ++var9) {
            int var10 = var1 + var8;
            int var11 = var2 + var9;
            if(var10 * var10 + var11 * var11 > 4096 && this.l.a((double)var10, (double)var11) < -0.8999999761581421D) {
               float var12 = (float)((MathHelper.abs(var10) * 3439 + MathHelper.abs(var11) * 147) % 13 + 9);
               var5 = (float)(var3 - var8 * 2);
               var6 = (float)(var4 - var9 * 2);
               float var13 = 100.0F - MathHelper.sqrt(var5 * var5 + var6 * var6) * var12;
               if(var13 > 80.0F) {
                  var13 = 80.0F;
               }

               if(var13 < -100.0F) {
                  var13 = -100.0F;
               }

               if(var13 > var7) {
                  var7 = var13;
               }
            }
         }
      }

      return var7;
   }

   public boolean b(int var1, int var2) {
      return var1 * var1 + var2 * var2 > 4096 && this.a(var1, var2, 1, 1) >= 0.0F;
   }

   private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      var8 *= 2.0D;
      this.c = this.i.a(this.c, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.d = this.g.a(this.d, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.e = this.h.a(this.e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = var2 / 2;
      int var13 = var4 / 2;
      int var14 = 0;

      for(int var15 = 0; var15 < var5; ++var15) {
         for(int var16 = 0; var16 < var7; ++var16) {
            float var17 = this.a(var12, var13, var15, var16);

            for(int var18 = 0; var18 < var6; ++var18) {
               double var19 = 0.0D;
               double var21 = this.d[var14] / 512.0D;
               double var23 = this.e[var14] / 512.0D;
               double var25 = (this.c[var14] / 10.0D + 1.0D) / 2.0D;
               if(var25 < 0.0D) {
                  var19 = var21;
               } else if(var25 > 1.0D) {
                  var19 = var23;
               } else {
                  var19 = var21 + (var23 - var21) * var25;
               }

               var19 -= 8.0D;
               var19 += (double)var17;
               byte var27 = 2;
               double var28;
               if(var18 > var6 / 2 - var27) {
                  var28 = (double)((float)(var18 - (var6 / 2 - var27)) / 64.0F);
                  var28 = MathHelper.clamp(var28, 0.0D, 1.0D);
                  var19 = var19 * (1.0D - var28) + -3000.0D * var28;
               }

               var27 = 8;
               if(var18 < var27) {
                  var28 = (double)((float)(var27 - var18) / ((float)var27 - 1.0F));
                  var19 = var19 * (1.0D - var28) + -30.0D * var28;
               }

               var1[var14] = var19;
               ++var14;
            }
         }
      }

      return var1;
   }

   public boolean isChunkLoaded(int var1, int var2) {
      return true;
   }

   public void a(IChunkProvider var1, int var2, int var3) {
      BlockFalling.instaFall = true;
      BlockPosition var4 = new BlockPosition(var2 * 16, 0, var3 * 16);
      this.k.a(this.j, this.f, new class_aeh(var2, var3));
      this.j.b(var4.add(16, 0, 16)).a(this.j, this.j.random, var4);
      if(var2 * var2 + var3 * var3 > 4096) {
         float var5 = this.a(var2, var3, 1, 1);
         if(var5 < -20.0F && this.f.nextInt(14) == 0) {
            this.o.generate(this.j, this.f, var4.add(this.f.nextInt(16) + 8, 55 + this.f.nextInt(16), this.f.nextInt(16) + 8));
            if(this.f.nextInt(4) == 0) {
               this.o.generate(this.j, this.f, var4.add(this.f.nextInt(16) + 8, 55 + this.f.nextInt(16), this.f.nextInt(16) + 8));
            }
         }

         int var6 = this.f.nextInt(5);

         for(int var7 = 0; var7 < var6; ++var7) {
            int var8 = this.f.nextInt(16) + 8;
            int var9 = this.f.nextInt(16) + 8;
            int var10 = this.j.m(var4.add(var8, 0, var9)).getY();
            if(var10 > 0) {
               int var11 = var10 - 1;
               if(this.j.isEmpty(var4.add(var8, var11 + 1, var9)) && this.j.getType(var4.add(var8, var11, var9)).getBlock() == Blocks.END_STONE) {
                  BlockChorusFlower.a(this.j, var4.add(var8, var11 + 1, var9), this.f, 8);
               }
            }
         }
      }

      BlockFalling.instaFall = false;
   }

   public boolean a(IChunkProvider var1, Chunk var2, int var3, int var4) {
      return false;
   }

   public boolean saveChunks(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public void c() {
   }

   public boolean unloadChunks() {
      return false;
   }

   public boolean canSave() {
      return true;
   }

   public String getName() {
      return "RandomLevelSource";
   }

   public List getMobsFor(EnumCreatureType var1, BlockPosition var2) {
      return this.j.b(var2).a(var1);
   }

   public BlockPosition a(World var1, String var2, BlockPosition var3) {
      return null;
   }

   public int getLoadedChunks() {
      return 0;
   }

   public void recreateStructures(Chunk var1, int var2, int var3) {
   }

   public Chunk getChunkAt(BlockPosition var1) {
      return this.getOrCreateChunk(var1.getX() >> 4, var1.getZ() >> 4);
   }
}
