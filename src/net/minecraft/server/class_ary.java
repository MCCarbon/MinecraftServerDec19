package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_ary {
   public static final class_ast a = new class_ast();
   private static final class_asu b = (new class_asu()).a(true);
   private static final class_asu c = (new class_asu()).a(true).b(true);
   private static final List d;
   private static final List e;
   private static final class_ary.class_b_in_class_ary f;
   private static final List g;
   private static final class_ary.class_b_in_class_ary h;
   private static final class_ary.class_b_in_class_ary i;
   private static final List j;
   private static final class_ary.class_b_in_class_ary k;

   public static void a() {
      class_asl.a(class_ary.class_a_in_class_ary.class, "ECP");
   }

   private static class_ary.class_a_in_class_ary b(class_ary.class_a_in_class_ary var0, BlockPosition var1, String var2, Block.EnumRotation var3, boolean var4) {
      class_ary.class_a_in_class_ary var5 = new class_ary.class_a_in_class_ary(var2, var0.c, var3, var4);
      BlockPosition var6 = var0.a.a(var0.b, var1, var5.a, var5.b, BlockPosition.ZERO);
      var5.a(var6.getX(), var6.getY(), var6.getZ());
      return var5;
   }

   public static void a(BlockPosition var0, Block.EnumRotation var1, List var2, Random var3) {
      k.a();
      f.a();
      i.a();
      h.a();
      class_ary.class_a_in_class_ary var4 = new class_ary.class_a_in_class_ary("base_floor", var0, var1, true);
      var2.add(var4);
      byte var5 = 0;
      class_ary.class_a_in_class_ary var6;
      var2.add(var6 = b(var4, new BlockPosition(-1, 0, -1), "second_floor", var1, false));
      var2.add(var6 = b(var6, new BlockPosition(-1, 4, -1), "third_floor", var1, false));
      var2.add(var6 = b(var6, new BlockPosition(-1, 8, -1), "third_roof", var1, true));
      b(h, var5 + 1, var6, (BlockPosition)null, var2, var3);
   }

   private static boolean b(class_ary.class_b_in_class_ary var0, int var1, class_ary.class_a_in_class_ary var2, BlockPosition var3, List var4, Random var5) {
      if(var1 > 8) {
         return false;
      } else {
         ArrayList var6 = new ArrayList();
         if(var0.a(var1, var2, var3, var6, var5)) {
            boolean var7 = false;
            int var8 = var5.nextInt();
            Iterator var9 = var6.iterator();

            while(var9.hasNext()) {
               StructurePiece var10 = (StructurePiece)var9.next();
               var10.m = var8;
               StructurePiece var11 = StructurePiece.a(var4, var10.c());
               if(var11 != null && var11.m != var2.m) {
                  var7 = true;
                  break;
               }
            }

            if(!var7) {
               var4.addAll(var6);
               return true;
            }
         }

         return false;
      }
   }

   static {
      d = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.DIAMOND, 0, 2, 7, 5), new class_od(Items.IRON_INGOT, 0, 4, 8, 10), new class_od(Items.GOLD_INGOT, 0, 2, 7, 15), new class_od(Items.EMERALD, 0, 2, 6, 2), new class_od(Items.BEETROOT_SEEDS, 0, 1, 10, 5), new class_od(Items.SADDLE, 0, 1, 1, 3), new class_od(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new class_od(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1)}));
      e = Lists.newArrayList((Object[])(new Item[]{Items.DIAMOND_SWORD, Items.DIAMOND_BOOTS, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_HELMET, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.IRON_SWORD, Items.IRON_BOOTS, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_HELMET, Items.IRON_PICKAXE, Items.IRON_SHOVEL}));
      f = new class_ary.class_b_in_class_ary() {
         public void a() {
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, BlockPosition var3, List var4, Random var5) {
            if(var1 > 8) {
               return false;
            } else {
               Block.EnumRotation var6 = var2.b.c();
               class_ary.class_a_in_class_ary var7;
               var4.add(var7 = class_ary.b(var2, var3, "base_floor", var6, true));
               int var8 = var5.nextInt(3);
               if(var8 == 0) {
                  var4.add(class_ary.b(var7, new BlockPosition(-1, 4, -1), "base_roof", var6, true));
               } else if(var8 == 1) {
                  var4.add(var7 = class_ary.b(var7, new BlockPosition(-1, 0, -1), "second_floor_2", var6, false));
                  var4.add(var7 = class_ary.b(var7, new BlockPosition(-1, 8, -1), "second_roof", var6, false));
                  class_ary.b(class_ary.h, var1 + 1, var7, (BlockPosition)null, var4, var5);
               } else if(var8 == 2) {
                  var4.add(var7 = class_ary.b(var7, new BlockPosition(-1, 0, -1), "second_floor_2", var6, false));
                  var4.add(var7 = class_ary.b(var7, new BlockPosition(-1, 4, -1), "third_floor_c", var6, false));
                  var4.add(var7 = class_ary.b(var7, new BlockPosition(-1, 8, -1), "third_roof", var6, true));
                  class_ary.b(class_ary.h, var1 + 1, var7, (BlockPosition)null, var4, var5);
               }

               return true;
            }
         }
      };
      g = new ArrayList();
      g.add(new Tuple(Block.EnumRotation.NONE, new BlockPosition(1, -1, 0)));
      g.add(new Tuple(Block.EnumRotation.CLOCKWISE_90, new BlockPosition(6, -1, 1)));
      g.add(new Tuple(Block.EnumRotation.COUNTERCLOCKWISE_90, new BlockPosition(0, -1, 5)));
      g.add(new Tuple(Block.EnumRotation.CLOCKWISE_180, new BlockPosition(5, -1, 6)));
      h = new class_ary.class_b_in_class_ary() {
         public void a() {
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, BlockPosition var3, List var4, Random var5) {
            Block.EnumRotation var6 = var2.b.c();
            class_ary.class_a_in_class_ary var7;
            var4.add(var7 = class_ary.b(var2, new BlockPosition(3 + var5.nextInt(2), -3, 3 + var5.nextInt(2)), "tower_base", var6, true));
            var4.add(var7 = class_ary.b(var7, new BlockPosition(0, 7, 0), "tower_piece", var6, true));
            class_ary.class_a_in_class_ary var8 = var5.nextInt(3) == 0?var7:null;
            int var9 = 1 + var5.nextInt(3);

            for(int var10 = 0; var10 < var9; ++var10) {
               var4.add(var7 = class_ary.b(var7, new BlockPosition(0, 4, 0), "tower_piece", var6, true));
               if(var10 < var9 - 1 && var5.nextBoolean()) {
                  var8 = var7;
               }
            }

            if(var8 != null) {
               Iterator var13 = class_ary.g.iterator();

               while(var13.hasNext()) {
                  Tuple var11 = (Tuple)var13.next();
                  if(var5.nextBoolean()) {
                     class_ary.class_a_in_class_ary var12;
                     var4.add(var12 = class_ary.b(var8, (BlockPosition)var11.getObject2(), "bridge_end", var6.a((Block.EnumRotation)var11.getObject1()), true));
                     class_ary.b(class_ary.i, var1 + 1, var12, (BlockPosition)null, var4, var5);
                  }
               }

               var4.add(class_ary.b(var7, new BlockPosition(-1, 4, -1), "tower_top", var6, true));
            } else {
               if(var1 != 7) {
                  return class_ary.b(class_ary.k, var1 + 1, var7, (BlockPosition)null, var4, var5);
               }

               var4.add(class_ary.b(var7, new BlockPosition(-1, 4, -1), "tower_top", var6, true));
            }

            return true;
         }
      };
      i = new class_ary.class_b_in_class_ary() {
         public boolean a;

         public void a() {
            this.a = false;
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, BlockPosition var3, List var4, Random var5) {
            Block.EnumRotation var7 = var2.b.c();
            int var8 = var5.nextInt(4) + 1;
            byte var9 = 0;
            class_ary.class_a_in_class_ary var6;
            var4.add(var6 = class_ary.b(var2, new BlockPosition(0, 0, -4), "bridge_piece", var7, true));
            var6.m = -1;

            for(int var10 = 0; var10 < var8; ++var10) {
               if(var5.nextBoolean()) {
                  var4.add(var6 = class_ary.b(var6, new BlockPosition(0, var9, -4), "bridge_piece", var7, true));
                  var9 = 0;
               } else {
                  if(var5.nextBoolean()) {
                     var4.add(var6 = class_ary.b(var6, new BlockPosition(0, var9, -4), "bridge_steep_stairs", var7, true));
                  } else {
                     var4.add(var6 = class_ary.b(var6, new BlockPosition(0, var9, -8), "bridge_gentle_stairs", var7, true));
                  }

                  var9 = 4;
               }
            }

            if(!this.a && var5.nextInt(10 - var1) == 0) {
               var4.add(class_ary.b(var6, new BlockPosition(-8 + var5.nextInt(8), var9, -70 + var5.nextInt(10)), "ship", var7, true));
               this.a = true;
            } else if(!class_ary.b(class_ary.f, var1 + 1, var6, new BlockPosition(-3, var9 + 1, -11), var4, var5)) {
               return false;
            }

            var4.add(var6 = class_ary.b(var6, new BlockPosition(4, var9, 0), "bridge_end", var7.a(Block.EnumRotation.CLOCKWISE_180), true));
            var6.m = -1;
            return true;
         }
      };
      j = new ArrayList();
      j.add(new Tuple(Block.EnumRotation.NONE, new BlockPosition(4, -1, 0)));
      j.add(new Tuple(Block.EnumRotation.CLOCKWISE_90, new BlockPosition(12, -1, 4)));
      j.add(new Tuple(Block.EnumRotation.COUNTERCLOCKWISE_90, new BlockPosition(0, -1, 8)));
      j.add(new Tuple(Block.EnumRotation.CLOCKWISE_180, new BlockPosition(8, -1, 12)));
      k = new class_ary.class_b_in_class_ary() {
         public void a() {
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, BlockPosition var3, List var4, Random var5) {
            Block.EnumRotation var7 = var2.b.c();
            class_ary.class_a_in_class_ary var6;
            var4.add(var6 = class_ary.b(var2, new BlockPosition(-3, 4, -3), "fat_tower_base", var7, true));
            var4.add(var6 = class_ary.b(var6, new BlockPosition(0, 4, 0), "fat_tower_middle", var7, true));

            for(int var8 = 0; var8 < 2 && var5.nextInt(3) != 0; ++var8) {
               var4.add(var6 = class_ary.b(var6, new BlockPosition(0, 8, 0), "fat_tower_middle", var7, true));
               Iterator var9 = class_ary.j.iterator();

               while(var9.hasNext()) {
                  Tuple var10 = (Tuple)var9.next();
                  if(var5.nextBoolean()) {
                     class_ary.class_a_in_class_ary var11;
                     var4.add(var11 = class_ary.b(var6, (BlockPosition)var10.getObject2(), "bridge_end", var7.a((Block.EnumRotation)var10.getObject1()), true));
                     class_ary.b(class_ary.i, var1 + 1, var11, (BlockPosition)null, var4, var5);
                  }
               }
            }

            var4.add(class_ary.b(var6, new BlockPosition(-2, 8, -2), "fat_tower_top", var7, true));
            return true;
         }
      };
   }

   interface class_b_in_class_ary {
      void a();

      boolean a(int var1, class_ary.class_a_in_class_ary var2, BlockPosition var3, List var4, Random var5);
   }

   public static class class_a_in_class_ary extends class_asp {
      private String d;
      private Block.EnumRotation e;
      private boolean f;

      public class_a_in_class_ary() {
      }

      public class_a_in_class_ary(String var1, BlockPosition var2, Block.EnumRotation var3, boolean var4) {
         super(0);
         this.d = var1;
         this.e = var3;
         this.f = var4;
         this.a(var2);
      }

      private void a(BlockPosition var1) {
         class_asv var2 = class_ary.a.a(new MinecraftKey("endcity/" + this.d));
         class_asu var3 = null;
         if(this.f) {
            var3 = class_ary.b.a().a(this.e);
         } else {
            var3 = class_ary.c.a().a(this.e);
         }

         this.a(var2, var1, var3);
      }

      protected void a(NBTTagCompound var1) {
         super.a(var1);
         var1.put("Template", this.d);
         var1.put("Rot", this.e.name());
         var1.put("OW", this.f);
      }

      protected void b(NBTTagCompound var1) {
         super.b(var1);
         this.d = var1.getString("Template");
         this.e = Block.EnumRotation.valueOf(var1.getString("Rot"));
         this.f = var1.getBoolean("OW");
         this.a(this.c);
      }

      protected void a(String var1, BlockPosition var2, World var3, Random var4, StructureBoundingBox var5) {
         if(var1.startsWith("Chest")) {
            BlockPosition var6 = var2.down();
            if(var5.b((BaseBlockPosition)var6)) {
               TileEntity var7 = var3.getTileEntity(var6);
               if(var7 instanceof TileEntityChest) {
                  ArrayList var8 = Lists.newArrayList((Iterable)class_ary.d);
                  Iterator var9 = class_ary.e.iterator();

                  while(var9.hasNext()) {
                     Item var10 = (Item)var9.next();
                     var8.add(new class_od(EnchantmentManager.a(var4, new ItemStack(var10), 20 + var4.nextInt(20)), 1, 1, 3));
                  }

                  class_od.a(var4, var8, (IInventory)((TileEntityChest)var7), 2 + var4.nextInt(5));
               }
            }
         } else if(var1.startsWith("Sentry")) {
            EntityShulker var11 = new EntityShulker(var3);
            var11.b((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D);
            var11.f(var2);
            var3.addEntity((Entity)var11);
         }

      }
   }
}
