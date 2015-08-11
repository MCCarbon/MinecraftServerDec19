package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WorldGenRegistration {
   public static void a() {
      WorldGenFactory.a(WorldGenRegistration.WorldGenPyramidPiece.class, "TeDP");
      WorldGenFactory.a(WorldGenRegistration.WorldGenJungleTemple.class, "TeJP");
      WorldGenFactory.a(WorldGenRegistration.WorldGenWitchHut.class, "TeSH");
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   public static class WorldGenWitchHut extends WorldGenRegistration.WorldGenScatteredPiece {
      private boolean e;

      public WorldGenWitchHut() {
      }

      public WorldGenWitchHut(Random var1, int var2, int var3) {
         super(var1, var2, 64, var3, 7, 7, 9);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Witch", this.e);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.e = var1.getBoolean("Witch");
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(!this.a(var1, var3, 0)) {
            return false;
         } else {
            this.a(var1, var3, 1, 1, 1, 5, 1, 7, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 1, 4, 2, 5, 4, 7, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 2, 1, 0, 4, 1, 0, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 2, 2, 2, 3, 3, 2, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 1, 2, 3, 1, 3, 6, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 5, 2, 3, 5, 3, 6, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 2, 2, 7, 4, 3, 7, Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), Blocks.PLANKS.fromLegacyData(BlockWood.EnumLogVariant.SPRUCE.getId()), false);
            this.a(var1, var3, 1, 0, 2, 1, 3, 2, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
            this.a(var1, var3, 5, 0, 2, 5, 3, 2, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
            this.a(var1, var3, 1, 0, 7, 1, 3, 7, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
            this.a(var1, var3, 5, 0, 7, 5, 3, 7, Blocks.LOG.getBlockData(), Blocks.LOG.getBlockData(), false);
            this.a(var1, Blocks.FENCE.getBlockData(), 2, 3, 2, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 3, 3, 7, var3);
            this.a(var1, Blocks.AIR.getBlockData(), 1, 3, 4, var3);
            this.a(var1, Blocks.AIR.getBlockData(), 5, 3, 4, var3);
            this.a(var1, Blocks.AIR.getBlockData(), 5, 3, 5, var3);
            this.a(var1, Blocks.FLOWER_POT.getBlockData().set(BlockFlowerPot.b, BlockFlowerPot.class_a_in_class_aid.r), 1, 3, 5, var3);
            this.a(var1, Blocks.CRAFTING_TABLE.getBlockData(), 3, 2, 6, var3);
            this.a(var1, Blocks.CAULDRON.getBlockData(), 4, 2, 6, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 1, 2, 1, var3);
            this.a(var1, Blocks.FENCE.getBlockData(), 5, 2, 1, var3);
            IBlockData var4 = Blocks.SPRUCE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
            IBlockData var5 = Blocks.SPRUCE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.EAST);
            IBlockData var6 = Blocks.SPRUCE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST);
            IBlockData var7 = Blocks.SPRUCE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);
            this.a(var1, var3, 0, 4, 1, 6, 4, 1, var4, var4, false);
            this.a(var1, var3, 0, 4, 2, 0, 4, 7, var5, var5, false);
            this.a(var1, var3, 6, 4, 2, 6, 4, 7, var6, var6, false);
            this.a(var1, var3, 0, 4, 8, 6, 4, 8, var7, var7, false);

            int var8;
            int var9;
            for(var8 = 2; var8 <= 7; var8 += 5) {
               for(var9 = 1; var9 <= 5; var9 += 4) {
                  this.b(var1, Blocks.LOG.getBlockData(), var9, -1, var8, var3);
               }
            }

            if(!this.e) {
               var8 = this.a(2, 5);
               var9 = this.d(2);
               int var10 = this.b(2, 5);
               if(var3.b((BaseBlockPosition)(new BlockPosition(var8, var9, var10)))) {
                  this.e = true;
                  EntityWitch var11 = new EntityWitch(var1);
                  var11.b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
                  var11.a(var1.E(new BlockPosition(var8, var9, var10)), (class_qd)null);
                  var1.addEntity((Entity)var11);
               }
            }

            return true;
         }
      }
   }

   public static class WorldGenJungleTemple extends WorldGenRegistration.WorldGenScatteredPiece {
      private boolean e;
      private boolean f;
      private boolean g;
      private boolean h;
      private static final List i;
      private static final List j;
      private static WorldGenRegistration.WorldGenJungleTemple.class_b_in_class_ash$class_a_in_class_b_in_class_ash k;

      public WorldGenJungleTemple() {
      }

      public WorldGenJungleTemple(Random var1, int var2, int var3) {
         super(var1, var2, 64, var3, 12, 10, 15);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("placedMainChest", this.e);
         var1.put("placedHiddenChest", this.f);
         var1.put("placedTrap1", this.g);
         var1.put("placedTrap2", this.h);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.e = var1.getBoolean("placedMainChest");
         this.f = var1.getBoolean("placedHiddenChest");
         this.g = var1.getBoolean("placedTrap1");
         this.h = var1.getBoolean("placedTrap2");
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         if(!this.a(var1, var3, 0)) {
            return false;
         } else {
            this.a(var1, var3, 0, -4, 0, this.a - 1, 0, this.c - 1, false, var2, k);
            this.a(var1, var3, 2, 1, 2, 9, 2, 2, false, var2, k);
            this.a(var1, var3, 2, 1, 12, 9, 2, 12, false, var2, k);
            this.a(var1, var3, 2, 1, 3, 2, 2, 11, false, var2, k);
            this.a(var1, var3, 9, 1, 3, 9, 2, 11, false, var2, k);
            this.a(var1, var3, 1, 3, 1, 10, 6, 1, false, var2, k);
            this.a(var1, var3, 1, 3, 13, 10, 6, 13, false, var2, k);
            this.a(var1, var3, 1, 3, 2, 1, 6, 12, false, var2, k);
            this.a(var1, var3, 10, 3, 2, 10, 6, 12, false, var2, k);
            this.a(var1, var3, 2, 3, 2, 9, 3, 12, false, var2, k);
            this.a(var1, var3, 2, 6, 2, 9, 6, 12, false, var2, k);
            this.a(var1, var3, 3, 7, 3, 8, 7, 11, false, var2, k);
            this.a(var1, var3, 4, 8, 4, 7, 8, 10, false, var2, k);
            this.a(var1, var3, 3, 1, 3, 8, 2, 11);
            this.a(var1, var3, 4, 3, 6, 7, 3, 9);
            this.a(var1, var3, 2, 4, 2, 9, 5, 12);
            this.a(var1, var3, 4, 6, 5, 7, 6, 9);
            this.a(var1, var3, 5, 7, 6, 6, 7, 8);
            this.a(var1, var3, 5, 1, 2, 6, 2, 2);
            this.a(var1, var3, 5, 2, 12, 6, 2, 12);
            this.a(var1, var3, 5, 5, 1, 6, 5, 1);
            this.a(var1, var3, 5, 5, 13, 6, 5, 13);
            this.a(var1, Blocks.AIR.getBlockData(), 1, 5, 5, var3);
            this.a(var1, Blocks.AIR.getBlockData(), 10, 5, 5, var3);
            this.a(var1, Blocks.AIR.getBlockData(), 1, 5, 9, var3);
            this.a(var1, Blocks.AIR.getBlockData(), 10, 5, 9, var3);

            int var4;
            for(var4 = 0; var4 <= 14; var4 += 14) {
               this.a(var1, var3, 2, 4, var4, 2, 5, var4, false, var2, k);
               this.a(var1, var3, 4, 4, var4, 4, 5, var4, false, var2, k);
               this.a(var1, var3, 7, 4, var4, 7, 5, var4, false, var2, k);
               this.a(var1, var3, 9, 4, var4, 9, 5, var4, false, var2, k);
            }

            this.a(var1, var3, 5, 6, 0, 6, 6, 0, false, var2, k);

            for(var4 = 0; var4 <= 11; var4 += 11) {
               for(int var5 = 2; var5 <= 12; var5 += 2) {
                  this.a(var1, var3, var4, 4, var5, var4, 5, var5, false, var2, k);
               }

               this.a(var1, var3, var4, 6, 5, var4, 6, 5, false, var2, k);
               this.a(var1, var3, var4, 6, 9, var4, 6, 9, false, var2, k);
            }

            this.a(var1, var3, 2, 7, 2, 2, 9, 2, false, var2, k);
            this.a(var1, var3, 9, 7, 2, 9, 9, 2, false, var2, k);
            this.a(var1, var3, 2, 7, 12, 2, 9, 12, false, var2, k);
            this.a(var1, var3, 9, 7, 12, 9, 9, 12, false, var2, k);
            this.a(var1, var3, 4, 9, 4, 4, 9, 4, false, var2, k);
            this.a(var1, var3, 7, 9, 4, 7, 9, 4, false, var2, k);
            this.a(var1, var3, 4, 9, 10, 4, 9, 10, false, var2, k);
            this.a(var1, var3, 7, 9, 10, 7, 9, 10, false, var2, k);
            this.a(var1, var3, 5, 9, 7, 6, 9, 7, false, var2, k);
            IBlockData var9 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.EAST);
            IBlockData var10 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST);
            IBlockData var6 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);
            IBlockData var7 = Blocks.STONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
            this.a(var1, var7, 5, 9, 6, var3);
            this.a(var1, var7, 6, 9, 6, var3);
            this.a(var1, var6, 5, 9, 8, var3);
            this.a(var1, var6, 6, 9, 8, var3);
            this.a(var1, var7, 4, 0, 0, var3);
            this.a(var1, var7, 5, 0, 0, var3);
            this.a(var1, var7, 6, 0, 0, var3);
            this.a(var1, var7, 7, 0, 0, var3);
            this.a(var1, var7, 4, 1, 8, var3);
            this.a(var1, var7, 4, 2, 9, var3);
            this.a(var1, var7, 4, 3, 10, var3);
            this.a(var1, var7, 7, 1, 8, var3);
            this.a(var1, var7, 7, 2, 9, var3);
            this.a(var1, var7, 7, 3, 10, var3);
            this.a(var1, var3, 4, 1, 9, 4, 1, 9, false, var2, k);
            this.a(var1, var3, 7, 1, 9, 7, 1, 9, false, var2, k);
            this.a(var1, var3, 4, 1, 10, 7, 2, 10, false, var2, k);
            this.a(var1, var3, 5, 4, 5, 6, 4, 5, false, var2, k);
            this.a(var1, var9, 4, 4, 5, var3);
            this.a(var1, var10, 7, 4, 5, var3);

            int var8;
            for(var8 = 0; var8 < 4; ++var8) {
               this.a(var1, var6, 5, 0 - var8, 6 + var8, var3);
               this.a(var1, var6, 6, 0 - var8, 6 + var8, var3);
               this.a(var1, var3, 5, 0 - var8, 7 + var8, 6, 0 - var8, 9 + var8);
            }

            this.a(var1, var3, 1, -3, 12, 10, -1, 13);
            this.a(var1, var3, 1, -3, 1, 3, -1, 13);
            this.a(var1, var3, 1, -3, 1, 9, -1, 5);

            for(var8 = 1; var8 <= 13; var8 += 2) {
               this.a(var1, var3, 1, -3, var8, 1, -2, var8, false, var2, k);
            }

            for(var8 = 2; var8 <= 12; var8 += 2) {
               this.a(var1, var3, 1, -1, var8, 3, -1, var8, false, var2, k);
            }

            this.a(var1, var3, 2, -2, 1, 5, -2, 1, false, var2, k);
            this.a(var1, var3, 7, -2, 1, 9, -2, 1, false, var2, k);
            this.a(var1, var3, 6, -3, 1, 6, -3, 1, false, var2, k);
            this.a(var1, var3, 6, -1, 1, 6, -1, 1, false, var2, k);
            this.a(var1, Blocks.TRIPWIRE_HOOK.getBlockData().set(BlockTripwireHook.a, EnumDirection.EAST).set(BlockTripwireHook.N, Boolean.valueOf(true)), 1, -3, 8, var3);
            this.a(var1, Blocks.TRIPWIRE_HOOK.getBlockData().set(BlockTripwireHook.a, EnumDirection.WEST).set(BlockTripwireHook.N, Boolean.valueOf(true)), 4, -3, 8, var3);
            this.a(var1, Blocks.TRIPWIRE.getBlockData().set(BlockTripwire.N, Boolean.valueOf(true)), 2, -3, 8, var3);
            this.a(var1, Blocks.TRIPWIRE.getBlockData().set(BlockTripwire.N, Boolean.valueOf(true)), 3, -3, 8, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 7, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 6, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 5, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 4, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 3, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 2, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 5, -3, 1, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 4, -3, 1, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 3, -3, 1, var3);
            if(!this.g) {
               this.g = this.a(var1, var3, var2, 3, -2, 1, EnumDirection.NORTH, j, 2);
            }

            this.a(var1, Blocks.VINE.getBlockData().set(BlockVine.O, Boolean.valueOf(true)), 3, -2, 2, var3);
            this.a(var1, Blocks.TRIPWIRE_HOOK.getBlockData().set(BlockTripwireHook.a, EnumDirection.NORTH).set(BlockTripwireHook.N, Boolean.valueOf(true)), 7, -3, 1, var3);
            this.a(var1, Blocks.TRIPWIRE_HOOK.getBlockData().set(BlockTripwireHook.a, EnumDirection.SOUTH).set(BlockTripwireHook.N, Boolean.valueOf(true)), 7, -3, 5, var3);
            this.a(var1, Blocks.TRIPWIRE.getBlockData().set(BlockTripwire.N, Boolean.valueOf(true)), 7, -3, 2, var3);
            this.a(var1, Blocks.TRIPWIRE.getBlockData().set(BlockTripwire.N, Boolean.valueOf(true)), 7, -3, 3, var3);
            this.a(var1, Blocks.TRIPWIRE.getBlockData().set(BlockTripwire.N, Boolean.valueOf(true)), 7, -3, 4, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 8, -3, 6, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 9, -3, 6, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 9, -3, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 9, -3, 4, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 9, -2, 4, var3);
            if(!this.h) {
               this.h = this.a(var1, var3, var2, 9, -2, 3, EnumDirection.WEST, j, 2);
            }

            this.a(var1, Blocks.VINE.getBlockData().set(BlockVine.N, Boolean.valueOf(true)), 8, -1, 3, var3);
            this.a(var1, Blocks.VINE.getBlockData().set(BlockVine.N, Boolean.valueOf(true)), 8, -2, 3, var3);
            if(!this.e) {
               this.e = this.a(var1, var3, var2, 8, -3, 3, class_od.a(i, new class_od[]{Items.ENCHANTED_BOOK.b(var2)}), 2 + var2.nextInt(5));
            }

            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 9, -3, 2, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 8, -3, 1, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 4, -3, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 5, -2, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 5, -1, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 6, -3, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 7, -2, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 7, -1, 5, var3);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 8, -3, 5, var3);
            this.a(var1, var3, 9, -1, 1, 9, -1, 5, false, var2, k);
            this.a(var1, var3, 8, -3, 8, 10, -1, 10);
            this.a(var1, Blocks.STONEBRICK.fromLegacyData(BlockSmoothBrick.P), 8, -2, 11, var3);
            this.a(var1, Blocks.STONEBRICK.fromLegacyData(BlockSmoothBrick.P), 9, -2, 11, var3);
            this.a(var1, Blocks.STONEBRICK.fromLegacyData(BlockSmoothBrick.P), 10, -2, 11, var3);
            IBlockData var11 = Blocks.LEVER.getBlockData().set(BlockLever.a, BlockLever.class_a_in_class_ajc.e);
            this.a(var1, var11, 8, -2, 12, var3);
            this.a(var1, var11, 9, -2, 12, var3);
            this.a(var1, var11, 10, -2, 12, var3);
            this.a(var1, var3, 8, -3, 8, 8, -3, 10, false, var2, k);
            this.a(var1, var3, 10, -3, 8, 10, -3, 10, false, var2, k);
            this.a(var1, Blocks.MOSSY_COBBLESTONE.getBlockData(), 10, -2, 9, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 8, -2, 9, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 8, -2, 10, var3);
            this.a(var1, Blocks.REDSTONE_WIRE.getBlockData(), 10, -1, 9, var3);
            this.a(var1, Blocks.STICKY_PISTON.getBlockData().set(BlockPiston.FACING, EnumDirection.UP), 9, -2, 8, var3);
            this.a(var1, Blocks.STICKY_PISTON.getBlockData().set(BlockPiston.FACING, EnumDirection.WEST), 10, -2, 8, var3);
            this.a(var1, Blocks.STICKY_PISTON.getBlockData().set(BlockPiston.FACING, EnumDirection.WEST), 10, -1, 8, var3);
            this.a(var1, Blocks.UNPOWERED_REPEATER.getBlockData().set(BlockRedstoneRepeater.FACING, EnumDirection.NORTH), 10, -2, 10, var3);
            if(!this.f) {
               this.f = this.a(var1, var3, var2, 9, -3, 10, class_od.a(i, new class_od[]{Items.ENCHANTED_BOOK.b(var2)}), 2 + var2.nextInt(5));
            }

            return true;
         }
      }

      static {
         i = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.DIAMOND, 0, 1, 3, 3), new class_od(Items.IRON_INGOT, 0, 1, 5, 10), new class_od(Items.GOLD_INGOT, 0, 2, 7, 15), new class_od(Items.EMERALD, 0, 1, 3, 2), new class_od(Items.BONE, 0, 4, 6, 20), new class_od(Items.ROTTEN_FLESH, 0, 3, 7, 16), new class_od(Items.SADDLE, 0, 1, 1, 3), new class_od(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1)}));
         j = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.ARROW, 0, 2, 7, 30)}));
         k = new WorldGenRegistration.WorldGenJungleTemple.class_b_in_class_ash$class_a_in_class_b_in_class_ash();
      }

      static class class_b_in_class_ash$class_a_in_class_b_in_class_ash extends StructurePiece.class_a_in_class_asn {
         private class_b_in_class_ash$class_a_in_class_b_in_class_ash() {
         }

         public void a(Random var1, int var2, int var3, int var4, boolean var5) {
            if(var1.nextFloat() < 0.4F) {
               this.a = Blocks.COBBLESTONE.getBlockData();
            } else {
               this.a = Blocks.MOSSY_COBBLESTONE.getBlockData();
            }

         }

         // $FF: synthetic method
         class_b_in_class_ash$class_a_in_class_b_in_class_ash(WorldGenRegistration.SyntheticClass_1 var1) {
            this();
         }
      }
   }

   public static class WorldGenPyramidPiece extends WorldGenRegistration.WorldGenScatteredPiece {
      private boolean[] e = new boolean[4];
      private static final List f;

      public WorldGenPyramidPiece() {
      }

      public WorldGenPyramidPiece(Random var1, int var2, int var3) {
         super(var1, var2, 64, var3, 21, 15, 21);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("hasPlacedChest0", this.e[0]);
         var1.put("hasPlacedChest1", this.e[1]);
         var1.put("hasPlacedChest2", this.e[2]);
         var1.put("hasPlacedChest3", this.e[3]);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.e[0] = var1.getBoolean("hasPlacedChest0");
         this.e[1] = var1.getBoolean("hasPlacedChest1");
         this.e[2] = var1.getBoolean("hasPlacedChest2");
         this.e[3] = var1.getBoolean("hasPlacedChest3");
      }

      public boolean a(World var1, Random var2, StructureBoundingBox var3) {
         this.a(var1, var3, 0, -4, 0, this.a - 1, 0, this.c - 1, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);

         int var4;
         for(var4 = 1; var4 <= 9; ++var4) {
            this.a(var1, var3, var4, var4, var4, this.a - 1 - var4, var4, this.c - 1 - var4, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
            this.a(var1, var3, var4 + 1, var4, var4 + 1, this.a - 2 - var4, var4, this.c - 2 - var4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         }

         for(var4 = 0; var4 < this.a; ++var4) {
            for(int var5 = 0; var5 < this.c; ++var5) {
               byte var6 = -5;
               this.b(var1, Blocks.SANDSTONE.getBlockData(), var4, var6, var5, var3);
            }
         }

         IBlockData var14 = Blocks.SANDSTONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.NORTH);
         IBlockData var15 = Blocks.SANDSTONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.SOUTH);
         IBlockData var16 = Blocks.SANDSTONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.EAST);
         IBlockData var7 = Blocks.SANDSTONE_STAIRS.getBlockData().set(BlockStairs.a, EnumDirection.WEST);
         int var8 = ~EnumColor.b.b() & 15;
         int var9 = ~EnumColor.l.b() & 15;
         this.a(var1, var3, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var14, 2, 10, 0, var3);
         this.a(var1, var15, 2, 10, 4, var3);
         this.a(var1, var16, 0, 10, 2, var3);
         this.a(var1, var7, 4, 10, 2, var3);
         this.a(var1, var3, this.a - 5, 0, 0, this.a - 1, 9, 4, Blocks.SANDSTONE.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, this.a - 4, 10, 1, this.a - 2, 10, 3, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var14, this.a - 3, 10, 0, var3);
         this.a(var1, var15, this.a - 3, 10, 4, var3);
         this.a(var1, var16, this.a - 5, 10, 2, var3);
         this.a(var1, var7, this.a - 1, 10, 2, var3);
         this.a(var1, var3, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 9, 1, 0, 11, 3, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 9, 1, 1, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 9, 2, 1, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 9, 3, 1, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 10, 3, 1, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 11, 3, 1, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 11, 2, 1, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 11, 1, 1, var3);
         this.a(var1, var3, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 4, 1, 2, 8, 2, 2, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 12, 1, 2, 16, 2, 2, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 5, 4, 5, this.a - 6, 4, this.c - 6, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, 9, 4, 9, 11, 4, 11, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, 8, 1, 8, 8, 3, 8, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, 12, 1, 8, 12, 3, 8, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, 8, 1, 12, 8, 3, 12, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, 12, 1, 12, 12, 3, 12, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, this.a - 5, 1, 5, this.a - 2, 4, 11, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, this.a - 7, 7, 9, this.a - 7, 7, 11, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, 5, 5, 9, 5, 7, 11, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, this.a - 6, 5, 9, this.a - 6, 7, 11, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, Blocks.AIR.getBlockData(), 5, 5, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 5, 6, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 6, 6, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), this.a - 6, 5, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), this.a - 6, 6, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), this.a - 7, 6, 10, var3);
         this.a(var1, var3, 2, 4, 4, 2, 6, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, this.a - 3, 4, 4, this.a - 3, 6, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var14, 2, 4, 5, var3);
         this.a(var1, var14, 2, 3, 4, var3);
         this.a(var1, var14, this.a - 3, 4, 5, var3);
         this.a(var1, var14, this.a - 3, 3, 4, var3);
         this.a(var1, var3, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, this.a - 3, 1, 3, this.a - 2, 2, 3, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, Blocks.SANDSTONE.getBlockData(), 1, 1, 2, var3);
         this.a(var1, Blocks.SANDSTONE.getBlockData(), this.a - 2, 1, 2, var3);
         this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId()), 1, 2, 2, var3);
         this.a(var1, Blocks.STONE_SLAB.fromLegacyData(BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId()), this.a - 2, 2, 2, var3);
         this.a(var1, var7, 2, 1, 2, var3);
         this.a(var1, var16, this.a - 3, 1, 2, var3);
         this.a(var1, var3, 4, 3, 5, 4, 3, 18, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, this.a - 5, 3, 5, this.a - 5, 3, 17, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, 3, 1, 5, 4, 2, 16, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, var3, this.a - 6, 1, 5, this.a - 5, 2, 16, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);

         int var10;
         for(var10 = 5; var10 <= 17; var10 += 2) {
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 4, 1, var10, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), 4, 2, var10, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), this.a - 5, 1, var10, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), this.a - 5, 2, var10, var3);
         }

         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 10, 0, 7, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 10, 0, 8, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 9, 0, 9, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 11, 0, 9, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 8, 0, 10, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 12, 0, 10, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 7, 0, 10, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 13, 0, 10, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 9, 0, 11, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 11, 0, 11, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 10, 0, 12, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 10, 0, 13, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var9), 10, 0, 10, var3);

         for(var10 = 0; var10 <= this.a - 1; var10 += this.a - 1) {
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 2, 1, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 2, 2, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 2, 3, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 3, 1, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 3, 2, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 3, 3, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 4, 1, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), var10, 4, 2, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 4, 3, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 5, 1, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 5, 2, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 5, 3, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 6, 1, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), var10, 6, 2, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 6, 3, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 7, 1, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 7, 2, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 7, 3, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 8, 1, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 8, 2, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 8, 3, var3);
         }

         for(var10 = 2; var10 <= this.a - 3; var10 += this.a - 3 - 2) {
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 - 1, 2, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 2, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 + 1, 2, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 - 1, 3, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 3, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 + 1, 3, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10 - 1, 4, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), var10, 4, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10 + 1, 4, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 - 1, 5, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 5, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 + 1, 5, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10 - 1, 6, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), var10, 6, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10 + 1, 6, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10 - 1, 7, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10, 7, 0, var3);
            this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), var10 + 1, 7, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 - 1, 8, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10, 8, 0, var3);
            this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), var10 + 1, 8, 0, var3);
         }

         this.a(var1, var3, 8, 4, 0, 12, 6, 0, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, Blocks.AIR.getBlockData(), 8, 6, 0, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 12, 6, 0, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 9, 5, 0, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), 10, 5, 0, var3);
         this.a(var1, Blocks.STAINED_HARDENED_CLAY.fromLegacyData(var8), 11, 5, 0, var3);
         this.a(var1, var3, 8, -14, 8, 12, -11, 12, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, 8, -10, 8, 12, -10, 12, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), false);
         this.a(var1, var3, 8, -9, 8, 12, -9, 12, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), false);
         this.a(var1, var3, 8, -8, 8, 12, -1, 12, Blocks.SANDSTONE.getBlockData(), Blocks.SANDSTONE.getBlockData(), false);
         this.a(var1, var3, 9, -11, 9, 11, -1, 11, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, Blocks.STONE_PRESSURE_PLATE.getBlockData(), 10, -11, 10, var3);
         this.a(var1, var3, 9, -13, 9, 11, -13, 11, Blocks.TNT.getBlockData(), Blocks.AIR.getBlockData(), false);
         this.a(var1, Blocks.AIR.getBlockData(), 8, -11, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 8, -10, 10, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), 7, -10, 10, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 7, -11, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 12, -11, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 12, -10, 10, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), 13, -10, 10, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 13, -11, 10, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 10, -11, 8, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 10, -10, 8, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), 10, -10, 7, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 10, -11, 7, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 10, -11, 12, var3);
         this.a(var1, Blocks.AIR.getBlockData(), 10, -10, 12, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), 10, -10, 13, var3);
         this.a(var1, Blocks.SANDSTONE.fromLegacyData(BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), 10, -11, 13, var3);
         Iterator var17 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         while(var17.hasNext()) {
            EnumDirection var11 = (EnumDirection)var17.next();
            if(!this.e[var11.getHorizontalId()]) {
               int var12 = var11.getAdjacentX() * 2;
               int var13 = var11.getAdjacentZ() * 2;
               this.e[var11.getHorizontalId()] = this.a(var1, var3, var2, 10 + var12, -11, 10 + var13, class_od.a(f, new class_od[]{Items.ENCHANTED_BOOK.b(var2)}), 2 + var2.nextInt(5));
            }
         }

         return true;
      }

      static {
         f = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.DIAMOND, 0, 1, 3, 3), new class_od(Items.IRON_INGOT, 0, 1, 5, 10), new class_od(Items.GOLD_INGOT, 0, 2, 7, 15), new class_od(Items.EMERALD, 0, 1, 3, 2), new class_od(Items.BONE, 0, 4, 6, 20), new class_od(Items.ROTTEN_FLESH, 0, 3, 7, 16), new class_od(Items.SADDLE, 0, 1, 1, 3), new class_od(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1)}));
      }
   }

   abstract static class WorldGenScatteredPiece extends StructurePiece {
      protected int a;
      protected int b;
      protected int c;
      protected int d = -1;

      public WorldGenScatteredPiece() {
      }

      protected WorldGenScatteredPiece(Random var1, int var2, int var3, int var4, int var5, int var6, int var7) {
         super(0);
         this.a = var5;
         this.b = var6;
         this.c = var7;
         this.a(EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var1));
         if(this.e().getAxis() == EnumDirection.EnumAxis.Z) {
            this.l = new StructureBoundingBox(var2, var3, var4, var2 + var5 - 1, var3 + var6 - 1, var4 + var7 - 1);
         } else {
            this.l = new StructureBoundingBox(var2, var3, var4, var2 + var7 - 1, var3 + var6 - 1, var4 + var5 - 1);
         }

      }

      protected void a(NBTTagCompound var1) {
         var1.put("Width", this.a);
         var1.put("Height", this.b);
         var1.put("Depth", this.c);
         var1.put("HPos", this.d);
      }

      protected void b(NBTTagCompound var1) {
         this.a = var1.getInt("Width");
         this.b = var1.getInt("Height");
         this.c = var1.getInt("Depth");
         this.d = var1.getInt("HPos");
      }

      protected boolean a(World var1, StructureBoundingBox var2, int var3) {
         if(this.d >= 0) {
            return true;
         } else {
            int var4 = 0;
            int var5 = 0;
            BlockPosition.MutableBlockPosition var6 = new BlockPosition.MutableBlockPosition();

            for(int var7 = this.l.minZ; var7 <= this.l.maxZ; ++var7) {
               for(int var8 = this.l.minX; var8 <= this.l.maxX; ++var8) {
                  var6.setPosition(var8, 64, var7);
                  if(var2.b((BaseBlockPosition)var6)) {
                     var4 += Math.max(var1.r(var6).getY(), var1.worldProvider.i());
                     ++var5;
                  }
               }
            }

            if(var5 == 0) {
               return false;
            } else {
               this.d = var4 / var5;
               this.l.a(0, this.d - this.l.minY + var3, 0);
               return true;
            }
         }
      }
   }
}
