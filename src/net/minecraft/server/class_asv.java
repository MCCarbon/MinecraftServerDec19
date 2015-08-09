package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class class_asv {
   private final List a = Lists.newArrayList();
   private final List b = Lists.newArrayList();
   private BlockPosition c = new BlockPosition(0, 0, 0);
   private String d = "?";

   public BlockPosition a() {
      return this.c;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public String b() {
      return this.d;
   }

   public void a(World var1, BlockPosition var2, BlockPosition var3, boolean var4) {
      if(var3.getX() >= 1 && var3.getY() >= 1 && var3.getZ() >= 1) {
         BlockPosition var5 = var2.add((BaseBlockPosition)var3).add(-1, -1, -1);
         ArrayList var6 = Lists.newArrayList();
         ArrayList var7 = Lists.newArrayList();
         ArrayList var8 = Lists.newArrayList();
         BlockPosition var9 = new BlockPosition(Math.min(var2.getX(), var5.getX()), Math.min(var2.getY(), var5.getY()), Math.min(var2.getZ(), var5.getZ()));
         BlockPosition var10 = new BlockPosition(Math.max(var2.getX(), var5.getX()), Math.max(var2.getY(), var5.getY()), Math.max(var2.getZ(), var5.getZ()));
         this.c = var3;
         Iterator var11 = BlockPosition.allInCubeM(var9, var10).iterator();

         while(true) {
            while(var11.hasNext()) {
               BlockPosition.MutableBlockPosition var12 = (BlockPosition.MutableBlockPosition)var11.next();
               BlockPosition var13 = var12.substract(var9);
               IBlockData var14 = var1.getType(var12);
               TileEntity var15 = var1.getTileEntity(var12);
               if(var15 != null) {
                  NBTTagCompound var16 = new NBTTagCompound();
                  var15.write(var16);
                  var16.remove("x");
                  var16.remove("y");
                  var16.remove("z");
                  var7.add(new class_asv.class_a_in_class_asv(var13, var14, var16, null));
               } else if(!var14.getBlock().isFullBlock() && !var14.getBlock().isFullCube()) {
                  var8.add(new class_asv.class_a_in_class_asv(var13, var14, (NBTTagCompound)null, null));
               } else {
                  var6.add(new class_asv.class_a_in_class_asv(var13, var14, (NBTTagCompound)null, null));
               }
            }

            this.a.clear();
            this.a.addAll(var6);
            this.a.addAll(var7);
            this.a.addAll(var8);
            if(var4) {
               this.a(var1, var9, var10.add(1, 1, 1));
            } else {
               this.b.clear();
            }

            return;
         }
      }
   }

   private void a(World var1, BlockPosition var2, BlockPosition var3) {
      List var4 = var1.a(Entity.class, new AxisAlignedBB(var2, var3), new Predicate() {
         public boolean a(Entity var1) {
            return !(var1 instanceof EntityHuman);
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((Entity)var1);
         }
      });
      this.b.clear();

      Vec3D var7;
      NBTTagCompound var8;
      BlockPosition var9;
      for(Iterator var5 = var4.iterator(); var5.hasNext(); this.b.add(new class_asv.class_b_in_class_asv(var7, var9, var8, null))) {
         Entity var6 = (Entity)var5.next();
         var7 = new Vec3D(var6.locX - (double)var2.getX(), var6.locY - (double)var2.getY(), var6.locZ - (double)var2.getZ());
         var8 = new NBTTagCompound();
         var6.d(var8);
         if(var6 instanceof EntityPainting) {
            var9 = ((EntityPainting)var6).n().substract(var2);
         } else {
            var9 = new BlockPosition(var7);
         }
      }

   }

   public Map a(BlockPosition var1, class_asu var2) {
      HashMap var3 = Maps.newHashMap();
      StructureBoundingBox var4 = var2.g();
      Iterator var5 = this.a.iterator();

      while(true) {
         class_asv.class_a_in_class_asv var6;
         BlockPosition var7;
         do {
            if(!var5.hasNext()) {
               return var3;
            }

            var6 = (class_asv.class_a_in_class_asv)var5.next();
            var7 = this.a(var2, var6.a).add((BaseBlockPosition)var1);
         } while(var4 != null && !var4.b((BaseBlockPosition)var7));

         IBlockData var8 = var6.b;
         if(var8.getBlock() == Blocks.STRUCTURE_BLOCK && var6.c != null) {
            TileEntityStructure.EnumMode var9 = TileEntityStructure.EnumMode.valueOf(var6.c.getString("mode"));
            if(var9 == TileEntityStructure.EnumMode.DATA) {
               var3.put(var7, var6.c.getString("metadata"));
            }
         }
      }
   }

   public BlockPosition a(class_asu var1, BlockPosition var2, class_asv var3, class_asu var4, BlockPosition var5) {
      BlockPosition var6 = this.a(var1, var2);
      BlockPosition var7 = var3.a(var4, var5);
      return var6.substract(var7);
   }

   public BlockPosition a(class_asu var1, BlockPosition var2) {
      return this.a(var2, var1.b(), var1.c());
   }

   public void a(World var1, BlockPosition var2, class_asu var3) {
      var3.i();
      this.b(var1, var2, var3);
   }

   public void b(World var1, BlockPosition var2, class_asu var3) {
      if(!this.a.isEmpty() && this.c.getX() >= 1 && this.c.getY() >= 1 && this.c.getZ() >= 1) {
         StructureBoundingBox var4 = var3.g();
         Iterator var5 = this.a.iterator();

         while(true) {
            class_asv.class_a_in_class_asv var6;
            Block var7;
            BlockPosition var8;
            do {
               do {
                  do {
                     if(!var5.hasNext()) {
                        var5 = this.a.iterator();

                        while(true) {
                           BlockPosition var12;
                           do {
                              do {
                                 if(!var5.hasNext()) {
                                    if(!var3.e()) {
                                       this.a(var1, var2, var3.b(), var3.c(), var4);
                                    }

                                    return;
                                 }

                                 var6 = (class_asv.class_a_in_class_asv)var5.next();
                              } while(var3.f() && var6.b.getBlock() == Blocks.AIR);

                              var12 = this.a(var3, var6.a).add((BaseBlockPosition)var2);
                           } while(var4 != null && !var4.b((BaseBlockPosition)var12));

                           var1.update(var12, var6.b.getBlock());
                           if(var6.c != null) {
                              TileEntity var13 = var1.getTileEntity(var12);
                              if(var13 != null) {
                                 var13.update();
                              }
                           }
                        }
                     }

                     var6 = (class_asv.class_a_in_class_asv)var5.next();
                     var7 = var6.b.getBlock();
                  } while(var3.f() && var7 == Blocks.AIR);
               } while(var3.h() && var7 == Blocks.STRUCTURE_BLOCK);

               var8 = this.a(var3, var6.a).add((BaseBlockPosition)var2);
            } while(var4 != null && !var4.b((BaseBlockPosition)var8));

            IBlockData var9 = var7.a(var6.b, var3.b());
            IBlockData var10 = var7.a(var9, var3.c());
            TileEntity var11;
            if(var6.c != null) {
               var11 = var1.getTileEntity(var8);
               if(var11 != null) {
                  if(var11 instanceof IInventory) {
                     ((IInventory)var11).remove();
                  }

                  var1.setTypeAndData((BlockPosition)var8, (IBlockData)Blocks.BARRIER.getBlockData(), 4);
               }
            }

            if(var1.setTypeAndData((BlockPosition)var8, (IBlockData)var10, 2) && var6.c != null) {
               var11 = var1.getTileEntity(var8);
               if(var11 != null) {
                  var6.c.put("x", var8.getX());
                  var6.c.put("y", var8.getY());
                  var6.c.put("z", var8.getZ());
                  var11.read(var6.c);
               }
            }
         }
      }
   }

   private void a(World var1, BlockPosition var2, Block.class_a_in_class_agj var3, Block.EnumRotation var4, StructureBoundingBox var5) {
      Iterator var6 = this.b.iterator();

      while(true) {
         class_asv.class_b_in_class_asv var7;
         BlockPosition var8;
         do {
            if(!var6.hasNext()) {
               return;
            }

            var7 = (class_asv.class_b_in_class_asv)var6.next();
            var8 = this.a(var7.b, var3, var4).add((BaseBlockPosition)var2);
         } while(var5 != null && !var5.b((BaseBlockPosition)var8));

         NBTTagCompound var9 = var7.c;
         Vec3D var10 = this.a(var7.a, var3, var4);
         Vec3D var11 = var10.add((double)var2.getX(), (double)var2.getY(), (double)var2.getZ());
         NBTTagList var12 = new NBTTagList();
         var12.add((NBTTag)(new NBTTagDouble(var11.x)));
         var12.add((NBTTag)(new NBTTagDouble(var11.y)));
         var12.add((NBTTag)(new NBTTagDouble(var11.z)));
         var9.put((String)"Pos", (NBTTag)var12);
         UUID var13 = UUID.randomUUID();
         var9.put("UUIDMost", var13.getMostSignificantBits());
         var9.put("UUIDLeast", var13.getLeastSignificantBits());

         Entity var14;
         try {
            var14 = EntityTypes.a(var9, var1);
         } catch (Exception var16) {
            var14 = null;
         }

         if(var14 != null) {
            if(var14 instanceof EntityPainting) {
               var14.a(var3);
               var14.a(var4);
               var14.b((double)var8.getX(), (double)var8.getY(), (double)var8.getZ());
               var14.b(var11.x, var11.y, var11.z, var14.yaw, var14.pitch);
            } else {
               float var15 = var14.a(var3);
               var15 += var14.yaw - var14.a(var4);
               var14.b(var11.x, var11.y, var11.z, var15, var14.pitch);
            }

            var1.addEntity(var14);
         }
      }
   }

   public BlockPosition a(Block.EnumRotation var1) {
      switch(class_asv.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
      case 2:
         return new BlockPosition(this.c.getZ(), this.c.getY(), this.c.getX());
      default:
         return this.c;
      }
   }

   private BlockPosition a(BlockPosition var1, Block.class_a_in_class_agj var2, Block.EnumRotation var3) {
      int var4 = var1.getX();
      int var5 = var1.getY();
      int var6 = var1.getZ();
      boolean var7 = true;
      switch(class_asv.SyntheticClass_1.b[var2.ordinal()]) {
      case 1:
         var6 = -var6;
         break;
      case 2:
         var4 = -var4;
         break;
      default:
         var7 = false;
      }

      switch(class_asv.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return new BlockPosition(var6, var5, -var4);
      case 2:
         return new BlockPosition(-var6, var5, var4);
      case 3:
         return new BlockPosition(-var4, var5, -var6);
      default:
         return var7?new BlockPosition(var4, var5, var6):var1;
      }
   }

   private Vec3D a(Vec3D var1, Block.class_a_in_class_agj var2, Block.EnumRotation var3) {
      double var4 = var1.x;
      double var6 = var1.y;
      double var8 = var1.z;
      boolean var10 = true;
      switch(class_asv.SyntheticClass_1.b[var2.ordinal()]) {
      case 1:
         var8 = 1.0D - var8;
         break;
      case 2:
         var4 = 1.0D - var4;
         break;
      default:
         var10 = false;
      }

      switch(class_asv.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return new Vec3D(var8, var6, 1.0D - var4);
      case 2:
         return new Vec3D(1.0D - var8, var6, var4);
      case 3:
         return new Vec3D(1.0D - var4, var6, 1.0D - var8);
      default:
         return var10?new Vec3D(var4, var6, var8):var1;
      }
   }

   public void a(NBTTagCompound var1) {
      NBTTagList var2 = new NBTTagList();

      NBTTagCompound var5;
      for(Iterator var3 = this.a.iterator(); var3.hasNext(); var2.add((NBTTag)var5)) {
         class_asv.class_a_in_class_asv var4 = (class_asv.class_a_in_class_asv)var3.next();
         var5 = new NBTTagCompound();
         var5.put((String)"pos", (NBTTag)this.a(new int[]{var4.a.getX(), var4.a.getY(), var4.a.getZ()}));
         var5.put("state", Block.getCombinedId(var4.b));
         if(var4.c != null) {
            var5.put((String)"nbt", (NBTTag)var4.c);
         }
      }

      NBTTagList var7 = new NBTTagList();

      NBTTagCompound var6;
      for(Iterator var8 = this.b.iterator(); var8.hasNext(); var7.add((NBTTag)var6)) {
         class_asv.class_b_in_class_asv var9 = (class_asv.class_b_in_class_asv)var8.next();
         var6 = new NBTTagCompound();
         var6.put((String)"pos", (NBTTag)this.a(new double[]{var9.a.x, var9.a.y, var9.a.z}));
         var6.put((String)"blockPos", (NBTTag)this.a(new int[]{var9.b.getX(), var9.b.getY(), var9.b.getZ()}));
         if(var9.c != null) {
            var6.put((String)"nbt", (NBTTag)var9.c);
         }
      }

      var1.put((String)"blocks", (NBTTag)var2);
      var1.put((String)"entities", (NBTTag)var7);
      var1.put((String)"size", (NBTTag)this.a(new int[]{this.c.getX(), this.c.getY(), this.c.getZ()}));
      var1.put("version", (int)1);
      var1.put("author", this.d);
   }

   public void b(NBTTagCompound var1) {
      this.a.clear();
      this.b.clear();
      NBTTagList var2 = var1.getList("size", 3);
      this.c = new BlockPosition(var2.getInt(0), var2.getInt(1), var2.getInt(2));
      this.d = var1.getString("author");
      NBTTagList var3 = var1.getList("blocks", 10);

      for(int var4 = 0; var4 < var3.getSize(); ++var4) {
         NBTTagCompound var5 = var3.getCompound(var4);
         NBTTagList var6 = var5.getList("pos", 3);
         BlockPosition var7 = new BlockPosition(var6.getInt(0), var6.getInt(1), var6.getInt(2));
         int var8 = var5.getInt("state");
         IBlockData var9 = Block.getByCombinedId(var8);
         NBTTagCompound var10;
         if(var5.has("nbt")) {
            var10 = var5.getCompound("nbt");
         } else {
            var10 = null;
         }

         this.a.add(new class_asv.class_a_in_class_asv(var7, var9, var10, null));
      }

      NBTTagList var12 = var1.getList("entities", 10);

      for(int var13 = 0; var13 < var12.getSize(); ++var13) {
         NBTTagCompound var14 = var12.getCompound(var13);
         NBTTagList var15 = var14.getList("pos", 6);
         Vec3D var16 = new Vec3D(var15.getDouble(0), var15.getDouble(1), var15.getDouble(2));
         NBTTagList var17 = var14.getList("blockPos", 3);
         BlockPosition var18 = new BlockPosition(var17.getInt(0), var17.getInt(1), var17.getInt(2));
         if(var14.has("nbt")) {
            NBTTagCompound var11 = var14.getCompound("nbt");
            this.b.add(new class_asv.class_b_in_class_asv(var16, var18, var11, null));
         }
      }

   }

   private NBTTagList a(int... var1) {
      NBTTagList var2 = new NBTTagList();
      int[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         var2.add((NBTTag)(new NBTTagInt(var6)));
      }

      return var2;
   }

   private NBTTagList a(double... var1) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.add((NBTTag)(new NBTTagDouble(var6)));
      }

      return var2;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.EnumRotation.values().length];

         try {
            a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static class class_b_in_class_asv {
      public final Vec3D a;
      public final BlockPosition b;
      public final NBTTagCompound c;

      private class_b_in_class_asv(Vec3D var1, BlockPosition var2, NBTTagCompound var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      class_b_in_class_asv(Vec3D var1, BlockPosition var2, NBTTagCompound var3, Object var4) {
         this(var1, var2, var3);
      }
   }

   static class class_a_in_class_asv {
      public final BlockPosition a;
      public final IBlockData b;
      public final NBTTagCompound c;

      private class_a_in_class_asv(BlockPosition var1, IBlockData var2, NBTTagCompound var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      class_a_in_class_asv(BlockPosition var1, IBlockData var2, NBTTagCompound var3, Object var4) {
         this(var1, var2, var3);
      }
   }
}
