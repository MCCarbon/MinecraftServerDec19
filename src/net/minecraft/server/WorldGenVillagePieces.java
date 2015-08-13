package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WorldGenVillagePieces {
   public static void a() {
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageLibrary.class, "ViBH");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageFarm2.class, "ViDF");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageFarm.class, "ViF");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageLight.class, "ViL");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageButcher.class, "ViPH");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageHouse.class, "ViSH");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageHut.class, "ViSmH");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageTemple.class, "ViST");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageBlacksmith.class, "ViS");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageStart.class, "ViStart");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageRoad.class, "ViSR");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageHouse2.class, "ViTRH");
      WorldGenFactory.a(WorldGenVillagePieces.WorldGenVillageWell.class, "ViW");
   }

   public static List a(Random var0, int var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageHouse.class, 4, MathHelper.getRandomIntInRange(var0, 2 + var1, 4 + var1 * 2)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageTemple.class, 20, MathHelper.getRandomIntInRange(var0, 0 + var1, 1 + var1)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageLibrary.class, 20, MathHelper.getRandomIntInRange(var0, 0 + var1, 2 + var1)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageHut.class, 3, MathHelper.getRandomIntInRange(var0, 2 + var1, 5 + var1 * 3)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageButcher.class, 15, MathHelper.getRandomIntInRange(var0, 0 + var1, 2 + var1)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageFarm2.class, 3, MathHelper.getRandomIntInRange(var0, 1 + var1, 4 + var1)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageFarm.class, 3, MathHelper.getRandomIntInRange(var0, 2 + var1, 4 + var1 * 2)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageBlacksmith.class, 15, MathHelper.getRandomIntInRange((Random)var0, 0, 1 + var1)));
      var2.add(new WorldGenVillagePieces.class_e_in_class_asr(WorldGenVillagePieces.WorldGenVillageHouse2.class, 8, MathHelper.getRandomIntInRange(var0, 0 + var1, 3 + var1 * 2)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         if(((WorldGenVillagePieces.class_e_in_class_asr)var3.next()).d == 0) {
            var3.remove();
         }
      }

      return var2;
   }

   private static int a(List var0) {
      boolean var1 = false;
      int var2 = 0;

      WorldGenVillagePieces.class_e_in_class_asr var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var2 += var4.b) {
         var4 = (WorldGenVillagePieces.class_e_in_class_asr)var3.next();
         if(var4.d > 0 && var4.c < var4.d) {
            var1 = true;
         }
      }

      return var1?var2:-1;
   }

   private static WorldGenVillagePieces.class_n_in_class_asr a(WorldGenVillagePieces.WorldGenVillageStart var0, WorldGenVillagePieces.class_e_in_class_asr var1, List var2, Random var3, int var4, int var5, int var6, EnumDirection var7, int var8) {
      Class var9 = var1.a;
      Object var10 = null;
      if(var9 == WorldGenVillagePieces.WorldGenVillageHouse.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageHouse.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageTemple.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageTemple.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageLibrary.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageLibrary.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageHut.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageHut.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageButcher.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageButcher.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageFarm2.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageFarm2.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageFarm.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageFarm.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageBlacksmith.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageBlacksmith.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if(var9 == WorldGenVillagePieces.WorldGenVillageHouse2.class) {
         var10 = WorldGenVillagePieces.WorldGenVillageHouse2.a(var0, var2, var3, var4, var5, var6, var7, var8);
      }

      return (WorldGenVillagePieces.class_n_in_class_asr)var10;
   }

   private static WorldGenVillagePieces.class_n_in_class_asr c(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      int var8 = a(var0.e);
      if(var8 <= 0) {
         return null;
      } else {
         int var9 = 0;

         while(var9 < 5) {
            ++var9;
            int var10 = var2.nextInt(var8);
            Iterator var11 = var0.e.iterator();

            while(var11.hasNext()) {
               WorldGenVillagePieces.class_e_in_class_asr var12 = (WorldGenVillagePieces.class_e_in_class_asr)var11.next();
               var10 -= var12.b;
               if(var10 < 0) {
                  if(!var12.a(var7) || var12 == var0.d && var0.e.size() > 1) {
                     break;
                  }

                  WorldGenVillagePieces.class_n_in_class_asr var13 = a(var0, var12, var1, var2, var3, var4, var5, var6, var7);
                  if(var13 != null) {
                     ++var12.c;
                     var0.d = var12;
                     if(!var12.a()) {
                        var0.e.remove(var12);
                     }

                     return var13;
                  }
               }
            }
         }

         StructureBoundingBox var14 = WorldGenVillagePieces.WorldGenVillageLight.a(var0, var1, var2, var3, var4, var5, var6);
         if(var14 != null) {
            return new WorldGenVillagePieces.WorldGenVillageLight(var0, var7, var2, var14, var6);
         } else {
            return null;
         }
      }
   }

   private static StructurePiece d(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      if(var7 > 50) {
         return null;
      } else if(Math.abs(var3 - var0.c().minX) <= 112 && Math.abs(var5 - var0.c().minZ) <= 112) {
         WorldGenVillagePieces.class_n_in_class_asr var8 = c(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
         if(var8 != null) {
            int var9 = (var8.l.minX + var8.l.maxX) / 2;
            int var10 = (var8.l.minZ + var8.l.maxZ) / 2;
            int var11 = var8.l.maxX - var8.l.minX;
            int var12 = var8.l.maxZ - var8.l.minZ;
            int var13 = var11 > var12?var11:var12;
            if(var0.h().a(var9, var10, var13 / 2 + 4, WorldGenVillage.d)) {
               var1.add(var8);
               var0.f.add(var8);
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static StructurePiece e(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
      if(var7 > 3 + var0.c) {
         return null;
      } else if(Math.abs(var3 - var0.c().minX) <= 112 && Math.abs(var5 - var0.c().minZ) <= 112) {
         StructureBoundingBox var8 = WorldGenVillagePieces.WorldGenVillageRoad.a(var0, var1, var2, var3, var4, var5, var6);
         if(var8 != null && var8.minY > 10) {
            WorldGenVillagePieces.WorldGenVillageRoad var9 = new WorldGenVillagePieces.WorldGenVillageRoad(var0, var7, var2, var8, var6);
            int var10 = (var9.l.minX + var9.l.maxX) / 2;
            int var11 = (var9.l.minZ + var9.l.maxZ) / 2;
            int var12 = var9.l.maxX - var9.l.minX;
            int var13 = var9.l.maxZ - var9.l.minZ;
            int var14 = var12 > var13?var12:var13;
            if(var0.h().a(var10, var11, var14 / 2 + 4, WorldGenVillage.d)) {
               var1.add(var9);
               var0.g.add(var9);
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class WorldGenVillageLight extends WorldGenVillagePieces.class_n_in_class_asr {
      public WorldGenVillageLight() {
      }

      public WorldGenVillageLight(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static StructureBoundingBox a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6) {
         StructureBoundingBox var7 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 3, 4, 2, var6);
         return StructurePiece.a(var1, var7) != null?null:var7;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 0, 0, 2, 3, 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 0, 0, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 1, 0, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 2, 0, var3);
         this.a(var1, Blocks.WOOL.fromLegacyData(EnumColor.a.b()), 1, 3, 0, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.EAST), 2, 3, 0, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.NORTH), 1, 3, 1, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.WEST), 0, 3, 0, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.SOUTH), 1, 3, -1, var3);
         return true;
      }
   }

   public static class WorldGenVillageFarm2 extends WorldGenVillagePieces.class_n_in_class_asr {
      private Block a;
      private Block b;
      private Block c;
      private Block d;

      public WorldGenVillageFarm2() {
      }

      public WorldGenVillageFarm2(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a((EnumDirection)var5);
         this.l = var4;
         this.a = this.a(var3);
         this.b = this.a(var3);
         this.c = this.a(var3);
         this.d = this.a(var3);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("CA", Block.BLOCK_REGISTRY.getId(this.a));
         var1.put("CB", Block.BLOCK_REGISTRY.getId(this.b));
         var1.put("CC", Block.BLOCK_REGISTRY.getId(this.c));
         var1.put("CD", Block.BLOCK_REGISTRY.getId(this.d));
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = Block.getById(var1.getInt("CA"));
         this.b = Block.getById(var1.getInt("CB"));
         this.c = Block.getById(var1.getInt("CC"));
         this.d = Block.getById(var1.getInt("CD"));
      }

      private Block a(Random var1) {
         switch(var1.nextInt(10)) {
         case 0:
         case 1:
            return Blocks.CARROTS;
         case 2:
         case 3:
            return Blocks.POTATOES;
         case 4:
            return Blocks.BEETROOTS;
         default:
            return Blocks.WHEAT;
         }
      }

      public static WorldGenVillagePieces.WorldGenVillageFarm2 a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
         return a((StructureBoundingBox)var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageFarm2(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 12, 4, 8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getBlockData(), Blocks.FARMLAND.getBlockData(), false);
         this.a(var1, var3, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getBlockData(), Blocks.FARMLAND.getBlockData(), false);
         this.a(var1, var3, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND.getBlockData(), Blocks.FARMLAND.getBlockData(), false);
         this.a(var1, var3, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND.getBlockData(), Blocks.FARMLAND.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 6, 0, 0, 6, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 12, 0, 0, 12, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 1, 0, 0, 11, 0, 0, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 1, 0, 8, 11, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 3, 0, 1, 3, 0, 7, Blocks.WATER.getBlockData(), Blocks.WATER.getBlockData(), false);
         this.a(var1, var3, 9, 0, 1, 9, 0, 7, Blocks.WATER.getBlockData(), Blocks.WATER.getBlockData(), false);

         int var4;
         int var5;
         for(var4 = 1; var4 <= 7; ++var4) {
            var5 = ((BlockCrops)this.a).n();
            int var6 = var5 / 3;
            this.a(var1, this.a.fromLegacyData(MathHelper.getRandomIntInRange(var2, var6, var5)), 1, 1, var4, var3);
            this.a(var1, this.a.fromLegacyData(MathHelper.getRandomIntInRange(var2, var6, var5)), 2, 1, var4, var3);
            int var7 = ((BlockCrops)this.b).n();
            int var8 = var7 / 3;
            this.a(var1, this.b.fromLegacyData(MathHelper.getRandomIntInRange(var2, var8, var7)), 4, 1, var4, var3);
            this.a(var1, this.b.fromLegacyData(MathHelper.getRandomIntInRange(var2, var8, var7)), 5, 1, var4, var3);
            int var9 = ((BlockCrops)this.c).n();
            int var10 = var9 / 3;
            this.a(var1, this.c.fromLegacyData(MathHelper.getRandomIntInRange(var2, var10, var9)), 7, 1, var4, var3);
            this.a(var1, this.c.fromLegacyData(MathHelper.getRandomIntInRange(var2, var10, var9)), 8, 1, var4, var3);
            int var11 = ((BlockCrops)this.d).n();
            int var12 = var11 / 3;
            this.a(var1, this.d.fromLegacyData(MathHelper.getRandomIntInRange(var2, var12, var11)), 10, 1, var4, var3);
            this.a(var1, this.d.fromLegacyData(MathHelper.getRandomIntInRange(var2, var12, var11)), 11, 1, var4, var3);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               this.b(var1, var5, 4, var4, var3);
               this.b(var1, Blocks.DIRT.getBlockData(), var5, -1, var4, var3);
            }
         }

         return true;
      }
   }

   public static class WorldGenVillageFarm extends WorldGenVillagePieces.class_n_in_class_asr {
      private Block a;
      private Block b;

      public WorldGenVillageFarm() {
      }

      public WorldGenVillageFarm(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a((EnumDirection)var5);
         this.l = var4;
         this.a = this.a(var3);
         this.b = this.a(var3);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("CA", Block.BLOCK_REGISTRY.getId(this.a));
         var1.put("CB", Block.BLOCK_REGISTRY.getId(this.b));
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = Block.getById(var1.getInt("CA"));
         this.b = Block.getById(var1.getInt("CB"));
      }

      private Block a(Random var1) {
         switch(var1.nextInt(10)) {
         case 0:
         case 1:
            return Blocks.CARROTS;
         case 2:
         case 3:
            return Blocks.POTATOES;
         case 4:
            return Blocks.BEETROOTS;
         default:
            return Blocks.WHEAT;
         }
      }

      public static WorldGenVillagePieces.WorldGenVillageFarm a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 7, 4, 9, var6);
         return a((StructureBoundingBox)var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageFarm(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 6, 4, 8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getBlockData(), Blocks.FARMLAND.getBlockData(), false);
         this.a(var1, var3, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getBlockData(), Blocks.FARMLAND.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 6, 0, 0, 6, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 1, 0, 0, 5, 0, 0, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 1, 0, 8, 5, 0, 8, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 3, 0, 1, 3, 0, 7, Blocks.WATER.getBlockData(), Blocks.WATER.getBlockData(), false);

         int var4;
         int var5;
         for(var4 = 1; var4 <= 7; ++var4) {
            var5 = ((BlockCrops)this.a).n();
            int var6 = var5 / 3;
            this.a(var1, this.a.fromLegacyData(MathHelper.getRandomIntInRange(var2, var6, var5)), 1, 1, var4, var3);
            this.a(var1, this.a.fromLegacyData(MathHelper.getRandomIntInRange(var2, var6, var5)), 2, 1, var4, var3);
            int var7 = ((BlockCrops)this.b).n();
            int var8 = var7 / 3;
            this.a(var1, this.b.fromLegacyData(MathHelper.getRandomIntInRange(var2, var8, var7)), 4, 1, var4, var3);
            this.a(var1, this.b.fromLegacyData(MathHelper.getRandomIntInRange(var2, var8, var7)), 5, 1, var4, var3);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(var5 = 0; var5 < 7; ++var5) {
               this.b(var1, var5, 4, var4, var3);
               this.b(var1, Blocks.DIRT.getBlockData(), var5, -1, var4, var3);
            }
         }

         return true;
      }
   }

   public static class WorldGenVillageBlacksmith extends WorldGenVillagePieces.class_n_in_class_asr {
      private static final List a;
      private boolean b;

      public WorldGenVillageBlacksmith() {
      }

      public WorldGenVillageBlacksmith(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static WorldGenVillagePieces.WorldGenVillageBlacksmith a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 10, 6, 7, var6);
         return a(var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageBlacksmith(var0, var7, var2, var8, var6):null;
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Chest", this.b);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getBoolean("Chest");
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 6 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 9, 4, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 9, 0, 6, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 4, 0, 9, 4, 6, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 9, 5, 6, Blocks.STONE_SLAB.getBlockData(), Blocks.STONE_SLAB.getBlockData(), false);
         this.a(var1, var3, 1, 5, 1, 8, 5, 5, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 1, 0, 0, 4, 0, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 3, 1, 0, 3, 4, 0, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 0, 1, 6, 0, 4, 6, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, Blocks.PLANKS.getBlockData(), 3, 3, 1, var3);
         this.a(var1, var3, 3, 1, 2, 3, 3, 2, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 4, 1, 3, 5, 3, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 1, 1, 0, 3, 5, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 1, 6, 5, 3, 6, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 5, 1, 0, 5, 3, 0, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
         this.a(var1, var3, 9, 1, 0, 9, 3, 0, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
         this.a(var1, var3, 6, 1, 4, 9, 4, 6, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, Blocks.FLOWING_LAVA.getBlockData(), 7, 1, 5, var3);
         this.a(var1, Blocks.FLOWING_LAVA.getBlockData(), 8, 1, 5, var3);
         this.a(var1, Blocks.IRON_BARS.getBlockData(), 9, 2, 5, var3);
         this.a(var1, Blocks.IRON_BARS.getBlockData(), 9, 2, 4, var3);
         this.a(var1, var3, 7, 2, 4, 8, 2, 5, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 6, 1, 3, var3);
         this.a(var1, Blocks.FURNACE.getBlockData(), 6, 2, 3, var3);
         this.a(var1, Blocks.FURNACE.getBlockData(), 6, 3, 3, var3);
         this.a(var1, Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), 8, 1, 1, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 4, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 2, 6, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 2, 6, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 2, 1, 4, var3);
         this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.getBlockData(), 2, 2, 4, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 1, 1, 5, var3);
         this.a(var1, Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH), 2, 1, 5, var3);
         this.a(var1, Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST), 1, 1, 4, var3);
         if(!this.b && var3.b((BaseBlockPosition)(new BlockPosition(this.a(5, 5), this.d(1), this.b(5, 5))))) {
            this.b = true;
            this.a(var1, var3, var2, 5, 1, 5, a, 3 + var2.nextInt(6));
         }

         int var4;
         for(var4 = 6; var4 <= 8; ++var4) {
            if(this.a(var1, var4, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, var4, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
               this.a(var1, Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH), var4, 0, -1, var3);
            }
         }

         for(var4 = 0; var4 < 7; ++var4) {
            for(int var5 = 0; var5 < 10; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 7, 1, 1, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 3;
      }

      static {
         a = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.DIAMOND, 0, 1, 3, 3), new class_od(Items.IRON_INGOT, 0, 1, 5, 10), new class_od(Items.GOLD_INGOT, 0, 1, 3, 5), new class_od(Items.BREAD, 0, 1, 3, 15), new class_od(Items.APPLE, 0, 1, 3, 15), new class_od(Items.IRON_PICKAXE, 0, 1, 1, 5), new class_od(Items.IRON_SWORD, 0, 1, 1, 5), new class_od(Items.IRON_CHESTPLATE, 0, 1, 1, 5), new class_od(Items.IRON_HELMET, 0, 1, 1, 5), new class_od(Items.IRON_LEGGINGS, 0, 1, 1, 5), new class_od(Items.IRON_BOOTS, 0, 1, 1, 5), new class_od(Item.getItemOf(Blocks.OBSIDIAN), 0, 3, 7, 5), new class_od(Item.getItemOf(Blocks.SAPLING), 0, 3, 7, 5), new class_od(Items.SADDLE, 0, 1, 1, 3), new class_od(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1)}));
      }
   }

   public static class WorldGenVillageHouse2 extends WorldGenVillagePieces.class_n_in_class_asr {
      public WorldGenVillageHouse2() {
      }

      public WorldGenVillageHouse2(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static WorldGenVillagePieces.WorldGenVillageHouse2 a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 9, 7, 12, var6);
         return a(var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageHouse2(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 7 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 4, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 2, 1, 6, 8, 4, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 2, 0, 5, 8, 0, 10, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 0, 1, 7, 0, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 8, 0, 0, 8, 3, 10, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 0, 0, 7, 2, 0, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 0, 5, 2, 1, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 2, 0, 6, 2, 3, 10, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 3, 0, 10, 7, 3, 10, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 2, 0, 7, 3, 0, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 2, 5, 2, 3, 5, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 4, 1, 8, 4, 1, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 4, 4, 3, 4, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 5, 2, 8, 5, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, Blocks.PLANKS.getBlockData(), 0, 4, 2, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 0, 4, 3, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 8, 4, 2, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 8, 4, 3, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 8, 4, 4, var3);
         IBlockData var4 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
         IBlockData var5 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);
         IBlockData var6 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST);
         IBlockData var7 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.EAST);

         int var8;
         int var9;
         for(var8 = -1; var8 <= 2; ++var8) {
            for(var9 = 0; var9 <= 8; ++var9) {
               this.a(var1, var4, var9, 4 + var8, var8, var3);
               if((var8 > -1 || var9 <= 1) && (var8 > 0 || var9 <= 3) && (var8 > 1 || var9 <= 4 || var9 >= 6)) {
                  this.a(var1, var5, var9, 4 + var8, 5 - var8, var3);
               }
            }
         }

         this.a(var1, var3, 3, 4, 5, 3, 4, 10, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 7, 4, 2, 7, 4, 10, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 4, 5, 4, 4, 5, 10, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 6, 5, 4, 6, 5, 10, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 5, 6, 3, 5, 6, 10, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);

         for(var8 = 4; var8 >= 1; --var8) {
            this.a(var1, Blocks.PLANKS.getBlockData(), var8, 2 + var8, 7 - var8, var3);

            for(var9 = 8 - var8; var9 <= 10; ++var9) {
               this.a(var1, var7, var8, 2 + var8, var9, var3);
            }
         }

         this.a(var1, Blocks.PLANKS.getBlockData(), 6, 6, 3, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 7, 5, 4, var3);
         this.a(var1, var6, 6, 6, 4, var3);

         for(var8 = 6; var8 <= 8; ++var8) {
            for(var9 = 5; var9 <= 10; ++var9) {
               this.a(var1, var6, var8, 12 - var8, var9, var3);
            }
         }

         this.a(var1, Blocks.LOG.getBlockData(), 0, 2, 1, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 0, 2, 4, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 3, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 4, 2, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 5, 2, 0, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 6, 2, 0, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 8, 2, 1, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 3, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 8, 2, 4, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 8, 2, 5, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 8, 2, 6, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 7, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 8, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 8, 2, 9, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 2, 2, 6, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 2, 7, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 2, 8, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 2, 2, 9, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 4, 4, 10, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 5, 4, 10, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 6, 4, 10, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 5, 5, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 1, 0, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 2, 0, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.NORTH), 2, 3, 1, var3);
         this.a(var1, var3, var2, 2, 1, 0, EnumDirection.NORTH);
         this.a(var1, var3, 1, 0, -1, 3, 2, -1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         if(this.a(var1, 2, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
            this.a(var1, var4, 2, 0, -1, var3);
         }

         for(var8 = 0; var8 < 5; ++var8) {
            for(var9 = 0; var9 < 9; ++var9) {
               this.b(var1, var9, 7, var8, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var9, -1, var8, var3);
            }
         }

         for(var8 = 5; var8 < 11; ++var8) {
            for(var9 = 2; var9 < 9; ++var9) {
               this.b(var1, var9, 7, var8, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var9, -1, var8, var3);
            }
         }

         this.a(var1, var3, 4, 1, 2, 2);
         return true;
      }
   }

   public static class WorldGenVillageButcher extends WorldGenVillagePieces.class_n_in_class_asr {
      public WorldGenVillageButcher() {
      }

      public WorldGenVillageButcher(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static WorldGenVillagePieces.WorldGenVillageButcher a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 9, 7, 11, var6);
         return a(var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageButcher(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 7 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 4, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 2, 1, 6, 8, 4, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 2, 0, 6, 8, 0, 10, Blocks.DIRT.getBlockData(), Blocks.DIRT.getBlockData(), false);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 6, 0, 6, var3);
         this.a(var1, var3, 2, 1, 6, 2, 1, 10, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
         this.a(var1, var3, 8, 1, 6, 8, 1, 10, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
         this.a(var1, var3, 3, 1, 10, 7, 1, 10, Blocks.FENCE.getBlockData(), Blocks.FENCE.getBlockData(), false);
         this.a(var1, var3, 1, 0, 1, 7, 0, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 8, 0, 0, 8, 3, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 0, 0, 7, 1, 0, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 0, 5, 7, 1, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 2, 0, 7, 3, 0, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 2, 5, 7, 3, 5, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 4, 1, 8, 4, 1, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 4, 4, 8, 4, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 0, 5, 2, 8, 5, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, Blocks.PLANKS.getBlockData(), 0, 4, 2, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 0, 4, 3, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 8, 4, 2, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 8, 4, 3, var3);
         IBlockData var4 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
         IBlockData var5 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);
         IBlockData var6 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST);

         int var7;
         int var8;
         for(var7 = -1; var7 <= 2; ++var7) {
            for(var8 = 0; var8 <= 8; ++var8) {
               this.a(var1, var4, var8, 4 + var7, var7, var3);
               this.a(var1, var5, var8, 4 + var7, 5 - var7, var3);
            }
         }

         this.a(var1, Blocks.LOG.getBlockData(), 0, 2, 1, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 0, 2, 4, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 8, 2, 1, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 8, 2, 4, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 3, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 3, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 2, 5, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 3, 2, 5, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 5, 2, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 6, 2, 5, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 2, 1, 3, var3);
         this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.getBlockData(), 2, 2, 3, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 1, 1, 4, var3);
         this.a(var1, var4, 2, 1, 4, var3);
         this.a(var1, var6, 1, 1, 3, var3);
         this.a(var1, var3, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), false);
         this.a(var1, Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), 6, 1, 1, var3);
         this.a(var1, Blocks.DOUBLE_SANDSTONE_SLAB.getBlockData(), 6, 1, 2, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 1, 0, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 2, 0, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.NORTH), 2, 3, 1, var3);
         this.a(var1, var3, var2, 2, 1, 0, EnumDirection.NORTH);
         if(this.a(var1, 2, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
            this.a(var1, var4, 2, 0, -1, var3);
         }

         this.a(var1, Blocks.AIR.getBlockData(), 6, 1, 5, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 6, 2, 5, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.SOUTH), 6, 3, 4, var3);
         this.a(var1, var3, var2, 6, 1, 5, EnumDirection.SOUTH);

         for(var7 = 0; var7 < 5; ++var7) {
            for(var8 = 0; var8 < 9; ++var8) {
               this.b(var1, var8, 7, var7, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var8, -1, var7, var3);
            }
         }

         this.a(var1, var3, 4, 1, 2, 2);
         return true;
      }

      protected int c(int var1, int var2) {
         return var1 == 0?4:super.c(var1, var2);
      }
   }

   public static class WorldGenVillageHut extends WorldGenVillagePieces.class_n_in_class_asr {
      private boolean a;
      private int b;

      public WorldGenVillageHut() {
      }

      public WorldGenVillageHut(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
         this.a = var3.nextBoolean();
         this.b = var3.nextInt(3);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("T", this.b);
         var1.put("C", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.b = var1.getInt("T");
         this.a = var1.getBoolean("C");
      }

      public static WorldGenVillagePieces.WorldGenVillageHut a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 4, 6, 5, var6);
         return a(var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageHut(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 6 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 3, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 3, 0, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 3, Blocks.DIRT.getBlockData(), Blocks.DIRT.getBlockData(), false);
         if(this.a) {
            this.a(var1, var3, 1, 4, 1, 2, 4, 3, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         } else {
            this.a(var1, var3, 1, 5, 1, 2, 5, 3, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         }

         this.a(var1, Blocks.LOG.getBlockData(), 1, 4, 0, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 2, 4, 0, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 1, 4, 4, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 2, 4, 4, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 0, 4, 1, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 0, 4, 2, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 0, 4, 3, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 3, 4, 1, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 3, 4, 2, var3);
         this.a(var1, Blocks.LOG.getBlockData(), 3, 4, 3, var3);
         this.a(var1, var3, 0, 1, 0, 0, 3, 0, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 3, 1, 0, 3, 3, 0, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 0, 1, 4, 0, 3, 4, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 3, 1, 4, 3, 3, 4, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 3, 1, 1, 3, 3, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 1, 4, 2, 3, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 3, 2, 2, var3);
         if(this.b > 0) {
            this.a(var1, Blocks.FENCE.getBlockData(), this.b, 1, 3, var3);
            this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.getBlockData(), this.b, 2, 3, var3);
         }

         this.a(var1, Blocks.AIR.getBlockData(), 1, 1, 0, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 1, 2, 0, var3);
         this.a(var1, var3, var2, 1, 1, 0, EnumDirection.NORTH);
         if(this.a(var1, 1, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 1, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
            this.a(var1, Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH), 1, 0, -1, var3);
         }

         for(int var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 4; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 1, 1, 2, 1);
         return true;
      }
   }

   public static class WorldGenVillageLibrary extends WorldGenVillagePieces.class_n_in_class_asr {
      public WorldGenVillageLibrary() {
      }

      public WorldGenVillageLibrary(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static WorldGenVillagePieces.WorldGenVillageLibrary a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 9, 9, 6, var6);
         return a(var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageLibrary(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 9 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 0, 0, 0, 8, 0, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 5, 0, 8, 5, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 6, 1, 8, 6, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 7, 2, 8, 7, 3, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);

         int var5;
         for(int var4 = -1; var4 <= 2; ++var4) {
            for(var5 = 0; var5 <= 8; ++var5) {
               this.a(var1, Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH), var5, 6 + var4, var4, var3);
               this.a(var1, Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH), var5, 6 + var4, 5 - var4, var3);
            }
         }

         this.a(var1, var3, 0, 1, 0, 0, 1, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 1, 5, 8, 1, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 8, 1, 0, 8, 1, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 2, 1, 0, 7, 1, 0, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 2, 0, 0, 4, 0, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 2, 5, 0, 4, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 8, 2, 5, 8, 4, 5, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 8, 2, 0, 8, 4, 0, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 2, 1, 0, 4, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 2, 5, 7, 4, 5, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 8, 2, 1, 8, 4, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 2, 0, 7, 4, 0, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 2, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 5, 2, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 6, 2, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 3, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 5, 3, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 6, 3, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 3, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 3, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 3, 3, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 2, 3, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 3, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 8, 3, 3, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 2, 5, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 3, 2, 5, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 5, 2, 5, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 6, 2, 5, var3);
         this.a(var1, var3, 1, 4, 1, 7, 4, 1, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 4, 4, 7, 4, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF.getBlockData(), Blocks.BOOKSHELF.getBlockData(), false);
         this.a(var1, Blocks.PLANKS.getBlockData(), 7, 1, 4, var3);
         this.a(var1, Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.EAST), 7, 1, 3, var3);
         IBlockData var7 = Blocks.OAK_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
         this.a(var1, var7, 6, 1, 4, var3);
         this.a(var1, var7, 5, 1, 4, var3);
         this.a(var1, var7, 4, 1, 4, var3);
         this.a(var1, var7, 3, 1, 4, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 6, 1, 3, var3);
         this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.getBlockData(), 6, 2, 3, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 4, 1, 3, var3);
         this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.getBlockData(), 4, 2, 3, var3);
         this.a(var1, Blocks.CRAFTING_TABLE.getBlockData(), 7, 1, 1, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 1, 1, 0, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 1, 2, 0, var3);
         this.a(var1, var3, var2, 1, 1, 0, EnumDirection.NORTH);
         if(this.a(var1, 1, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 1, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
            this.a(var1, Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH), 1, 0, -1, var3);
         }

         for(var5 = 0; var5 < 6; ++var5) {
            for(int var6 = 0; var6 < 9; ++var6) {
               this.b(var1, var6, 9, var5, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var6, -1, var5, var3);
            }
         }

         this.a(var1, var3, 2, 1, 2, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 1;
      }
   }

   public static class WorldGenVillageTemple extends WorldGenVillagePieces.class_n_in_class_asr {
      public WorldGenVillageTemple() {
      }

      public WorldGenVillageTemple(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
      }

      public static WorldGenVillagePieces.WorldGenVillageTemple a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 5, 12, 9, var6);
         return a(var8) && StructurePiece.a(var1, var8) == null?new WorldGenVillagePieces.WorldGenVillageTemple(var0, var7, var2, var8, var6):null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 12 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 3, 3, 7, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 5, 1, 3, 9, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 0, 0, 3, 0, 8, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 1, 0, 3, 10, 0, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 1, 1, 0, 10, 3, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 4, 1, 1, 4, 10, 3, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 0, 4, 0, 4, 7, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 4, 0, 4, 4, 4, 7, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 1, 8, 3, 4, 8, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 5, 4, 3, 10, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 1, 5, 5, 3, 5, 7, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 9, 0, 4, 9, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 4, 0, 4, 4, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 11, 2, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 11, 2, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 2, 11, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 2, 11, 4, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 1, 1, 6, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 1, 1, 7, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 2, 1, 7, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 3, 1, 6, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 3, 1, 7, var3);
         IBlockData var4 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
         IBlockData var5 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST);
         IBlockData var6 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.EAST);
         this.a(var1, var4, 1, 1, 5, var3);
         this.a(var1, var4, 2, 1, 6, var3);
         this.a(var1, var4, 3, 1, 5, var3);
         this.a(var1, var5, 1, 2, 7, var3);
         this.a(var1, var6, 3, 2, 7, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 3, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 3, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 6, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 7, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 6, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 7, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 6, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 7, 0, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 6, 4, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 7, 4, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 3, 6, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 3, 6, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 3, 8, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.SOUTH), 2, 4, 7, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.EAST), 1, 4, 6, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.WEST), 3, 4, 6, var3);
         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.NORTH), 2, 4, 5, var3);
         IBlockData var7 = Blocks.LADDER.getBlockData().set(BlockLadder.a, EnumDirection.WEST);

         int var8;
         for(var8 = 1; var8 <= 9; ++var8) {
            this.a(var1, var7, 3, var8, 3, var3);
         }

         this.a(var1, Blocks.AIR.getBlockData(), 2, 1, 0, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 2, 0, var3);
         this.a(var1, var3, var2, 2, 1, 0, EnumDirection.NORTH);
         if(this.a(var1, 2, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
            this.a(var1, var4, 2, 0, -1, var3);
         }

         for(var8 = 0; var8 < 9; ++var8) {
            for(int var9 = 0; var9 < 5; ++var9) {
               this.b(var1, var9, 12, var8, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var9, -1, var8, var3);
            }
         }

         this.a(var1, var3, 2, 1, 2, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 2;
      }
   }

   public static class WorldGenVillageHouse extends WorldGenVillagePieces.class_n_in_class_asr {
      private boolean a;

      public WorldGenVillageHouse() {
      }

      public WorldGenVillageHouse(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
         this.a = var3.nextBoolean();
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Terrace", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getBoolean("Terrace");
      }

      public static WorldGenVillagePieces.WorldGenVillageHouse a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6, int var7) {
         StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 5, 6, 5, var6);
         return StructurePiece.a(var1, var8) != null?null:new WorldGenVillagePieces.WorldGenVillageHouse(var0, var7, var2, var8, var6);
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 6 - 1, 0);
         }

         this.a(var1, var3, 0, 0, 0, 4, 0, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);
         this.a(var1, var3, 0, 4, 0, 4, 4, 4, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
         this.a(var1, var3, 1, 4, 1, 3, 4, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 1, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 2, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 3, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 1, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 2, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 3, 0, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 1, 4, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 2, 4, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 0, 3, 4, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 1, 4, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 2, 4, var3);
         this.a(var1, Blocks.COBBLESTONE.getBlockData(), 4, 3, 4, var3);
         this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, var3, 1, 1, 4, 3, 3, 4, Blocks.PLANKS.getBlockData(), Blocks.PLANKS.getBlockData(), false);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 0, 2, 2, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 2, 2, 4, var3);
         this.a(var1, Blocks.GLASS_PANE.getBlockData(), 4, 2, 2, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 1, 1, 0, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 1, 2, 0, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 1, 3, 0, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 2, 3, 0, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 3, 3, 0, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 3, 2, 0, var3);
         this.a(var1, Blocks.PLANKS.getBlockData(), 3, 1, 0, var3);
         if(this.a(var1, 2, 0, -1, var3).getBlock().getMaterial() == Material.AIR && this.a(var1, 2, -1, -1, var3).getBlock().getMaterial() != Material.AIR) {
            this.a(var1, Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH), 2, 0, -1, var3);
         }

         this.a(var1, var3, 1, 1, 1, 3, 3, 3, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         if(this.a) {
            this.a(var1, Blocks.FENCE.getBlockData(), 0, 5, 0, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 1, 5, 0, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 2, 5, 0, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 3, 5, 0, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 4, 5, 0, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 0, 5, 4, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 1, 5, 4, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 2, 5, 4, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 3, 5, 4, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 4, 5, 4, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 4, 5, 1, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 4, 5, 2, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 4, 5, 3, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 0, 5, 1, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 0, 5, 2, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 0, 5, 3, var3);
         }

         if(this.a) {
            IBlockData var4 = Blocks.LADDER.getBlockData().set(BlockLadder.a, EnumDirection.SOUTH);
            this.a(var1, var4, 3, 1, 3, var3);
            this.a(var1, var4, 3, 2, 3, var3);
            this.a(var1, var4, 3, 3, 3, var3);
            this.a(var1, var4, 3, 4, 3, var3);
         }

         this.a(var1, Blocks.TORCH.getBlockData().set(BlockTorch.a, EnumDirection.NORTH), 2, 3, 1, var3);

         for(int var6 = 0; var6 < 5; ++var6) {
            for(int var5 = 0; var5 < 5; ++var5) {
               this.b(var1, var5, 6, var6, var3);
               this.b(var1, Blocks.COBBLESTONE.getBlockData(), var5, -1, var6, var3);
            }
         }

         this.a(var1, var3, 1, 1, 2, 1);
         return true;
      }
   }

   public static class WorldGenVillageRoad extends WorldGenVillagePieces.class_o_in_class_asr {
      private int a;

      public WorldGenVillageRoad() {
      }

      public WorldGenVillageRoad(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, StructureBoundingBox var4, EnumDirection var5) {
         super(var1, var2);
         this.a(var5);
         this.l = var4;
         this.a = Math.max(var4.getXLength(), var4.getZLength());
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Length", this.a);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.a = var1.getInt("Length");
      }

      public void a(StructurePiece var1, List var2, Random var3) {
         boolean var4 = false;

         int var5;
         StructurePiece var6;
         for(var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
            var6 = this.a((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, 0, var5);
            if(var6 != null) {
               var5 += Math.max(var6.l.getXLength(), var6.l.getZLength());
               var4 = true;
            }
         }

         for(var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
            var6 = this.b((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, 0, var5);
            if(var6 != null) {
               var5 += Math.max(var6.l.getXLength(), var6.l.getZLength());
               var4 = true;
            }
         }

         EnumDirection var7 = this.e();
         if(var4 && var3.nextInt(3) > 0 && var7 != null) {
            switch(WorldGenVillagePieces.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX - 1, this.l.minY, this.l.minZ, EnumDirection.WEST, this.d());
               break;
            case 2:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX - 1, this.l.minY, this.l.maxZ - 2, EnumDirection.WEST, this.d());
               break;
            case 3:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX, this.l.minY, this.l.minZ - 1, EnumDirection.NORTH, this.d());
               break;
            case 4:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.maxX - 2, this.l.minY, this.l.minZ - 1, EnumDirection.NORTH, this.d());
            }
         }

         if(var4 && var3.nextInt(3) > 0 && var7 != null) {
            switch(WorldGenVillagePieces.SyntheticClass_1.a[var7.ordinal()]) {
            case 1:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.maxX + 1, this.l.minY, this.l.minZ, EnumDirection.EAST, this.d());
               break;
            case 2:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.maxX + 1, this.l.minY, this.l.maxZ - 2, EnumDirection.EAST, this.d());
               break;
            case 3:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX, this.l.minY, this.l.maxZ + 1, EnumDirection.SOUTH, this.d());
               break;
            case 4:
               WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.maxX - 2, this.l.minY, this.l.maxZ + 1, EnumDirection.SOUTH, this.d());
            }
         }

      }

      public static StructureBoundingBox a(WorldGenVillagePieces.WorldGenVillageStart var0, List var1, Random var2, int var3, int var4, int var5, EnumDirection var6) {
         for(int var7 = 7 * MathHelper.getRandomIntInRange((Random)var2, 3, 5); var7 >= 7; var7 -= 7) {
            StructureBoundingBox var8 = StructureBoundingBox.a(var3, var4, var5, 0, 0, 0, 3, 3, var7, var6);
            if(StructurePiece.a(var1, var8) == null) {
               return var8;
            }
         }

         return null;
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         IBlockData var4 = this.a(Blocks.GRAVEL.getBlockData());
         IBlockData var5 = this.a(Blocks.COBBLESTONE.getBlockData());

         for(int var6 = this.l.minX; var6 <= this.l.maxX; ++var6) {
            for(int var7 = this.l.minZ; var7 <= this.l.maxZ; ++var7) {
               BlockPosition var8 = new BlockPosition(var6, 64, var7);
               if(var3.b((BaseBlockPosition)var8)) {
                  var8 = var1.r(var8).down();
                  var1.setTypeAndData((BlockPosition)var8, (IBlockData)var4, 2);
                  var1.setTypeAndData((BlockPosition)var8.down(), (IBlockData)var5, 2);
               }
            }
         }

         return true;
      }
   }

   public abstract static class class_o_in_class_asr extends WorldGenVillagePieces.class_n_in_class_asr {
      public class_o_in_class_asr() {
      }

      protected class_o_in_class_asr(WorldGenVillagePieces.WorldGenVillageStart var1, int var2) {
         super(var1, var2);
      }
   }

   public static class WorldGenVillageStart extends WorldGenVillagePieces.WorldGenVillageWell {
      public WorldChunkManager a;
      public boolean b;
      public int c;
      public WorldGenVillagePieces.class_e_in_class_asr d;
      public List e;
      public List f = Lists.newArrayList();
      public List g = Lists.newArrayList();

      public WorldGenVillageStart() {
      }

      public WorldGenVillageStart(WorldChunkManager var1, int var2, Random var3, int var4, int var5, List var6, int var7) {
         super((WorldGenVillagePieces.WorldGenVillageStart)null, 0, var3, var4, var5);
         this.a = var1;
         this.e = var6;
         this.c = var7;
         BiomeBase var8 = var1.a(new BlockPosition(var4, 0, var5), BiomeBase.ad);
         this.b = var8 == BiomeBase.DESERT || var8 == BiomeBase.DESERT_HILLS;
         this.a(this.b);
      }

      public WorldChunkManager h() {
         return this.a;
      }
   }

   public static class WorldGenVillageWell extends WorldGenVillagePieces.class_n_in_class_asr {
      public WorldGenVillageWell() {
      }

      public WorldGenVillageWell(WorldGenVillagePieces.WorldGenVillageStart var1, int var2, Random var3, int var4, int var5) {
         super(var1, var2);
         this.a(EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var3));
         if(this.e().getAxis() == EnumDirection.EnumAxis.Z) {
            this.l = new StructureBoundingBox(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
         } else {
            this.l = new StructureBoundingBox(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
         }

      }

      public void a(StructurePiece var1, List var2, Random var3) {
         WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX - 1, this.l.maxY - 4, this.l.minZ + 1, EnumDirection.WEST, this.d());
         WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.maxX + 1, this.l.maxY - 4, this.l.minZ + 1, EnumDirection.EAST, this.d());
         WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX + 1, this.l.maxY - 4, this.l.minZ - 1, EnumDirection.NORTH, this.d());
         WorldGenVillagePieces.e((WorldGenVillagePieces.WorldGenVillageStart)var1, var2, var3, this.l.minX + 1, this.l.maxY - 4, this.l.maxZ + 1, EnumDirection.SOUTH, this.d());
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(this.h < 0) {
            this.h = this.b(var1, var3);
            if(this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.maxY + 3, 0);
         }

         this.a(var1, var3, 1, 0, 1, 4, 12, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.FLOWING_WATER.getBlockData(), false);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 12, 2, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 3, 12, 2, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 2, 12, 3, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 3, 12, 3, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 13, 1, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 14, 1, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 4, 13, 1, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 4, 14, 1, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 13, 4, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 1, 14, 4, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 4, 13, 4, var3);
         this.a(var1, Blocks.FENCE.getBlockData(), 4, 14, 4, var3);
         this.a(var1, var3, 1, 15, 1, 4, 15, 4, Blocks.COBBLESTONE.getBlockData(), Blocks.COBBLESTONE.getBlockData(), false);

         for(int var4 = 0; var4 <= 5; ++var4) {
            for(int var5 = 0; var5 <= 5; ++var5) {
               if(var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
                  this.a(var1, Blocks.GRAVEL.getBlockData(), var5, 11, var4, var3);
                  this.b(var1, var5, 12, var4, var3);
               }
            }
         }

         return true;
      }
   }

   abstract static class class_n_in_class_asr extends StructurePiece {
      protected int h = -1;
      private int a;
      private boolean b;

      public class_n_in_class_asr() {
      }

      protected class_n_in_class_asr(WorldGenVillagePieces.WorldGenVillageStart var1, int var2) {
         super(var2);
         if(var1 != null) {
            this.b = var1.b;
         }

      }

      protected void a(NBTTagCompound var1) {
         var1.put("HPos", this.h);
         var1.put("VCount", this.a);
         var1.put("Desert", this.b);
      }

      protected void b(NBTTagCompound var1) {
         this.h = var1.getInt("HPos");
         this.a = var1.getInt("VCount");
         this.b = var1.getBoolean("Desert");
      }

      protected StructurePiece a(WorldGenVillagePieces.WorldGenVillageStart var1, List var2, Random var3, int var4, int var5) {
         EnumDirection var6 = this.e();
         if(var6 != null) {
            switch(WorldGenVillagePieces.SyntheticClass_1.a[var6.ordinal()]) {
            case 1:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.minX - 1, this.l.minY + var4, this.l.minZ + var5, EnumDirection.WEST, this.d());
            case 2:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.minX - 1, this.l.minY + var4, this.l.minZ + var5, EnumDirection.WEST, this.d());
            case 3:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.minZ - 1, EnumDirection.NORTH, this.d());
            case 4:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.minZ - 1, EnumDirection.NORTH, this.d());
            }
         }

         return null;
      }

      protected StructurePiece b(WorldGenVillagePieces.WorldGenVillageStart var1, List var2, Random var3, int var4, int var5) {
         EnumDirection var6 = this.e();
         if(var6 != null) {
            switch(WorldGenVillagePieces.SyntheticClass_1.a[var6.ordinal()]) {
            case 1:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.maxX + 1, this.l.minY + var4, this.l.minZ + var5, EnumDirection.EAST, this.d());
            case 2:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.maxX + 1, this.l.minY + var4, this.l.minZ + var5, EnumDirection.EAST, this.d());
            case 3:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.maxZ + 1, EnumDirection.SOUTH, this.d());
            case 4:
               return WorldGenVillagePieces.d(var1, var2, var3, this.l.minX + var5, this.l.minY + var4, this.l.maxZ + 1, EnumDirection.SOUTH, this.d());
            }
         }

         return null;
      }

      protected int b(World var1, StructureBoundingBox var2) {
         int var3 = 0;
         int var4 = 0;
         BlockPosition.MutableBlockPosition var5 = new BlockPosition.MutableBlockPosition();

         for(int var6 = this.l.minZ; var6 <= this.l.maxZ; ++var6) {
            for(int var7 = this.l.minX; var7 <= this.l.maxX; ++var7) {
               var5.setPosition(var7, 64, var6);
               if(var2.b((BaseBlockPosition)var5)) {
                  var3 += Math.max(var1.r(var5).getY(), var1.worldProvider.i());
                  ++var4;
               }
            }
         }

         if(var4 == 0) {
            return -1;
         } else {
            return var3 / var4;
         }
      }

      protected static boolean a(StructureBoundingBox var0) {
         return var0 != null && var0.minY > 10;
      }

      protected void a(World var1, StructureBoundingBox var2, int var3, int var4, int var5, int var6) {
         if(this.a < var6) {
            for(int var7 = this.a; var7 < var6; ++var7) {
               int var8 = this.a(var3 + var7, var5);
               int var9 = this.d(var4);
               int var10 = this.b(var3 + var7, var5);
               if(!var2.b((BaseBlockPosition)(new BlockPosition(var8, var9, var10)))) {
                  break;
               }

               ++this.a;
               EntityVillager var11 = new EntityVillager(var1);
               var11.setPositionRotation((double) var8 + 0.5D, (double) var9, (double) var10 + 0.5D, 0.0F, 0.0F);
               var11.a(var1.E(new BlockPosition(var11)), (class_qd)null);
               var11.setProfession(this.c(var7, var11.getProfession()));
               var1.addEntity((Entity)var11);
            }

         }
      }

      protected int c(int var1, int var2) {
         return var2;
      }

      protected IBlockData a(IBlockData var1) {
         if(this.b) {
            if(var1.getBlock() == Blocks.LOG || var1.getBlock() == Blocks.LOG2) {
               return Blocks.SANDSTONE.getBlockData();
            }

            if(var1.getBlock() == Blocks.COBBLESTONE) {
               return Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.DEFAULT.getId());
            }

            if(var1.getBlock() == Blocks.PLANKS) {
               return Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId());
            }

            if(var1.getBlock() == Blocks.OAK_STAIRS) {
               return Blocks.SANDSTONE_STAIRS.getBlockData().set(BlockStairs.a, var1.get(BlockStairs.a));
            }

            if(var1.getBlock() == Blocks.STONE_STAIRS) {
               return Blocks.SANDSTONE_STAIRS.getBlockData().set(BlockStairs.a, var1.get(BlockStairs.a));
            }

            if(var1.getBlock() == Blocks.GRAVEL) {
               return Blocks.SANDSTONE.getBlockData();
            }
         }

         return var1;
      }

      protected void a(World var1, IBlockData var2, int var3, int var4, int var5, StructureBoundingBox var6) {
         IBlockData var7 = this.a(var2);
         super.a(var1, var7, var3, var4, var5, var6);
      }

      protected void a(World var1, StructureBoundingBox var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockData var9, IBlockData var10, boolean var11) {
         IBlockData var12 = this.a(var9);
         IBlockData var13 = this.a(var10);
         super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
      }

      protected void b(World var1, IBlockData var2, int var3, int var4, int var5, StructureBoundingBox var6) {
         IBlockData var7 = this.a(var2);
         super.b(var1, var7, var3, var4, var5, var6);
      }

      protected void a(boolean var1) {
         this.b = var1;
      }
   }

   public static class class_e_in_class_asr {
      public Class a;
      public final int b;
      public int c;
      public int d;

      public class_e_in_class_asr(Class var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
      }

      public boolean a(int var1) {
         return this.d == 0 || this.c < this.d;
      }

      public boolean a() {
         return this.d == 0 || this.c < this.d;
      }
   }
}
