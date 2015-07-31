package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahk;
import net.minecraft.server.class_ahl;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_amm;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;

public abstract class class_asn {
   protected class_arw l;
   private EnumDirection a;
   private Block.class_a_in_class_agj b;
   private Block.class_c_in_class_agj c;
   protected int m;

   public class_asn() {
   }

   protected class_asn(int var1) {
      this.m = var1;
   }

   public final NBTTagCompound b() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.put("id", class_asl.a(this));
      var1.put((String)"BB", (NBTTag)this.l.g());
      EnumDirection var2 = this.e();
      var1.put("O", var2 == null?-1:var2.getHorizontalId());
      var1.put("GD", this.m);
      this.a(var1);
      return var1;
   }

   protected abstract void a(NBTTagCompound var1);

   public void a(World var1, NBTTagCompound var2) {
      if(var2.has("BB")) {
         this.l = new class_arw(var2.getIntArray("BB"));
      }

      int var3 = var2.getInt("O");
      this.a(var3 == -1?null:EnumDirection.getByHorizontalId(var3));
      this.m = var2.getInt("GD");
      this.b(var2);
   }

   protected abstract void b(NBTTagCompound var1);

   public void a(class_asn var1, List var2, Random var3) {
   }

   public abstract boolean a(World var1, Random var2, class_arw var3);

   public class_arw c() {
      return this.l;
   }

   public int d() {
      return this.m;
   }

   public static class_asn a(List var0, class_arw var1) {
      Iterator var2 = var0.iterator();

      class_asn var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (class_asn)var2.next();
      } while(var3.c() == null || !var3.c().a(var1));

      return var3;
   }

   public BlockPosition a() {
      return new BlockPosition(this.l.f());
   }

   protected boolean a(World var1, class_arw var2) {
      int var3 = Math.max(this.l.a - 1, var2.a);
      int var4 = Math.max(this.l.b - 1, var2.b);
      int var5 = Math.max(this.l.c - 1, var2.c);
      int var6 = Math.min(this.l.d + 1, var2.d);
      int var7 = Math.min(this.l.e + 1, var2.e);
      int var8 = Math.min(this.l.f + 1, var2.f);
      BlockPosition.MutableBlockPosition var9 = new BlockPosition.MutableBlockPosition();

      int var10;
      int var11;
      for(var10 = var3; var10 <= var6; ++var10) {
         for(var11 = var5; var11 <= var8; ++var11) {
            if(var1.p(var9.setPosition(var10, var4, var11)).getBlock().getMaterial().isLiquid()) {
               return true;
            }

            if(var1.p(var9.setPosition(var10, var7, var11)).getBlock().getMaterial().isLiquid()) {
               return true;
            }
         }
      }

      for(var10 = var3; var10 <= var6; ++var10) {
         for(var11 = var4; var11 <= var7; ++var11) {
            if(var1.p(var9.setPosition(var10, var11, var5)).getBlock().getMaterial().isLiquid()) {
               return true;
            }

            if(var1.p(var9.setPosition(var10, var11, var8)).getBlock().getMaterial().isLiquid()) {
               return true;
            }
         }
      }

      for(var10 = var5; var10 <= var8; ++var10) {
         for(var11 = var4; var11 <= var7; ++var11) {
            if(var1.p(var9.setPosition(var3, var11, var10)).getBlock().getMaterial().isLiquid()) {
               return true;
            }

            if(var1.p(var9.setPosition(var6, var11, var10)).getBlock().getMaterial().isLiquid()) {
               return true;
            }
         }
      }

      return false;
   }

   protected int a(int var1, int var2) {
      EnumDirection var3 = this.e();
      if(var3 == null) {
         return var1;
      } else {
         switch(class_asn.SyntheticClass_1.a[var3.ordinal()]) {
         case 1:
         case 2:
            return this.l.a + var1;
         case 3:
            return this.l.d - var2;
         case 4:
            return this.l.a + var2;
         default:
            return var1;
         }
      }
   }

   protected int d(int var1) {
      return this.e() == null?var1:var1 + this.l.b;
   }

   protected int b(int var1, int var2) {
      EnumDirection var3 = this.e();
      if(var3 == null) {
         return var2;
      } else {
         switch(class_asn.SyntheticClass_1.a[var3.ordinal()]) {
         case 1:
            return this.l.f - var2;
         case 2:
            return this.l.c + var2;
         case 3:
         case 4:
            return this.l.c + var1;
         default:
            return var2;
         }
      }
   }

   protected void a(World var1, IBlockData var2, int var3, int var4, int var5, class_arw var6) {
      BlockPosition var7 = new BlockPosition(this.a(var3, var5), this.d(var4), this.b(var3, var5));
      if(var6.b((BaseBlockPosition)var7)) {
         if(this.b != Block.class_a_in_class_agj.a) {
            var2 = var2.getBlock().a(var2, this.b);
         }

         if(this.c != Block.class_c_in_class_agj.a) {
            var2 = var2.getBlock().a(var2, this.c);
         }

         var1.a((BlockPosition)var7, (IBlockData)var2, 2);
      }
   }

   protected IBlockData a(World var1, int var2, int var3, int var4, class_arw var5) {
      int var6 = this.a(var2, var4);
      int var7 = this.d(var3);
      int var8 = this.b(var2, var4);
      BlockPosition var9 = new BlockPosition(var6, var7, var8);
      return !var5.b((BaseBlockPosition)var9)?Blocks.AIR.getBlockData():var1.p(var9);
   }

   protected void a(World var1, class_arw var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      for(int var9 = var4; var9 <= var7; ++var9) {
         for(int var10 = var3; var10 <= var6; ++var10) {
            for(int var11 = var5; var11 <= var8; ++var11) {
               this.a(var1, Blocks.AIR.getBlockData(), var10, var9, var11, var2);
            }
         }
      }

   }

   protected void a(World var1, class_arw var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockData var9, IBlockData var10, boolean var11) {
      for(int var12 = var4; var12 <= var7; ++var12) {
         for(int var13 = var3; var13 <= var6; ++var13) {
            for(int var14 = var5; var14 <= var8; ++var14) {
               if(!var11 || this.a(var1, var13, var12, var14, var2).getBlock().getMaterial() != Material.AIR) {
                  if(var12 != var4 && var12 != var7 && var13 != var3 && var13 != var6 && var14 != var5 && var14 != var8) {
                     this.a(var1, var10, var13, var12, var14, var2);
                  } else {
                     this.a(var1, var9, var13, var12, var14, var2);
                  }
               }
            }
         }
      }

   }

   protected void a(World var1, class_arw var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, Random var10, class_asn.class_a_in_class_asn var11) {
      for(int var12 = var4; var12 <= var7; ++var12) {
         for(int var13 = var3; var13 <= var6; ++var13) {
            for(int var14 = var5; var14 <= var8; ++var14) {
               if(!var9 || this.a(var1, var13, var12, var14, var2).getBlock().getMaterial() != Material.AIR) {
                  var11.a(var10, var13, var12, var14, var12 == var4 || var12 == var7 || var13 == var3 || var13 == var6 || var14 == var5 || var14 == var8);
                  this.a(var1, var11.a(), var13, var12, var14, var2);
               }
            }
         }
      }

   }

   protected void a(World var1, class_arw var2, Random var3, float var4, int var5, int var6, int var7, int var8, int var9, int var10, IBlockData var11, IBlockData var12, boolean var13) {
      for(int var14 = var6; var14 <= var9; ++var14) {
         for(int var15 = var5; var15 <= var8; ++var15) {
            for(int var16 = var7; var16 <= var10; ++var16) {
               if(var3.nextFloat() <= var4 && (!var13 || this.a(var1, var15, var14, var16, var2).getBlock().getMaterial() != Material.AIR)) {
                  if(var14 != var6 && var14 != var9 && var15 != var5 && var15 != var8 && var16 != var7 && var16 != var10) {
                     this.a(var1, var12, var15, var14, var16, var2);
                  } else {
                     this.a(var1, var11, var15, var14, var16, var2);
                  }
               }
            }
         }
      }

   }

   protected void a(World var1, class_arw var2, Random var3, float var4, int var5, int var6, int var7, IBlockData var8) {
      if(var3.nextFloat() < var4) {
         this.a(var1, var8, var5, var6, var7, var2);
      }

   }

   protected void a(World var1, class_arw var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockData var9, boolean var10) {
      float var11 = (float)(var6 - var3 + 1);
      float var12 = (float)(var7 - var4 + 1);
      float var13 = (float)(var8 - var5 + 1);
      float var14 = (float)var3 + var11 / 2.0F;
      float var15 = (float)var5 + var13 / 2.0F;

      for(int var16 = var4; var16 <= var7; ++var16) {
         float var17 = (float)(var16 - var4) / var12;

         for(int var18 = var3; var18 <= var6; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = var5; var20 <= var8; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if(!var10 || this.a(var1, var18, var16, var20, var2).getBlock().getMaterial() != Material.AIR) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if(var22 <= 1.05F) {
                     this.a(var1, var9, var18, var16, var20, var2);
                  }
               }
            }
         }
      }

   }

   protected void b(World var1, int var2, int var3, int var4, class_arw var5) {
      BlockPosition var6 = new BlockPosition(this.a(var2, var4), this.d(var3), this.b(var2, var4));
      if(var5.b((BaseBlockPosition)var6)) {
         while(!var1.d(var6) && var6.getY() < 255) {
            var1.a((BlockPosition)var6, (IBlockData)Blocks.AIR.getBlockData(), 2);
            var6 = var6.shiftUp();
         }

      }
   }

   protected void b(World var1, IBlockData var2, int var3, int var4, int var5, class_arw var6) {
      int var7 = this.a(var3, var5);
      int var8 = this.d(var4);
      int var9 = this.b(var3, var5);
      if(var6.b((BaseBlockPosition)(new BlockPosition(var7, var8, var9)))) {
         while((var1.d(new BlockPosition(var7, var8, var9)) || var1.p(new BlockPosition(var7, var8, var9)).getBlock().getMaterial().isLiquid()) && var8 > 1) {
            var1.a((BlockPosition)(new BlockPosition(var7, var8, var9)), (IBlockData)var2, 2);
            --var8;
         }

      }
   }

   protected boolean a(World var1, class_arw var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
      BlockPosition var9 = new BlockPosition(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if(var2.b((BaseBlockPosition)var9) && var1.p(var9).getBlock() != Blocks.CHEST) {
         IBlockData var10 = Blocks.CHEST.getBlockData();
         var1.a((BlockPosition)var9, (IBlockData)Blocks.CHEST.f(var1, var9, var10), 2);
         class_amg var11 = var1.s(var9);
         if(var11 instanceof class_ami) {
            class_od.a(var3, var7, (class_oj)((class_ami)var11), var8);
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean a(World var1, class_arw var2, Random var3, int var4, int var5, int var6, EnumDirection var7, List var8, int var9) {
      BlockPosition var10 = new BlockPosition(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if(var2.b((BaseBlockPosition)var10) && var1.p(var10).getBlock() != Blocks.DISPENSER) {
         this.a(var1, Blocks.DISPENSER.getBlockData().set(class_ahk.a, var7), var4, var5, var6, var2);
         class_amg var11 = var1.s(var10);
         if(var11 instanceof class_amm) {
            class_od.a(var3, var8, (class_amm)var11, var9);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void a(World var1, class_arw var2, Random var3, int var4, int var5, int var6, EnumDirection var7) {
      this.a(var1, Blocks.WOODEN_DOOR.getBlockData().set(class_ahl.a, var7), var4, var5, var6, var2);
      this.a(var1, Blocks.WOODEN_DOOR.getBlockData().set(class_ahl.a, var7).set(class_ahl.P, class_ahl.class_a_in_class_ahl.a), var4, var5 + 1, var6, var2);
   }

   public void a(int var1, int var2, int var3) {
      this.l.a(var1, var2, var3);
   }

   public EnumDirection e() {
      return this.a;
   }

   public void a(EnumDirection var1) {
      this.a = var1;
      if(var1 == null) {
         this.c = Block.class_c_in_class_agj.a;
         this.b = Block.class_a_in_class_agj.a;
      } else {
         switch(class_asn.SyntheticClass_1.a[var1.ordinal()]) {
         case 2:
            this.b = Block.class_a_in_class_agj.b;
            this.c = Block.class_c_in_class_agj.a;
            break;
         case 3:
            this.b = Block.class_a_in_class_agj.b;
            this.c = Block.class_c_in_class_agj.b;
            break;
         case 4:
            this.b = Block.class_a_in_class_agj.a;
            this.c = Block.class_c_in_class_agj.b;
            break;
         default:
            this.b = Block.class_a_in_class_agj.a;
            this.c = Block.class_c_in_class_agj.a;
         }
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

   public abstract static class class_a_in_class_asn {
      protected IBlockData a;

      protected class_a_in_class_asn() {
         this.a = Blocks.AIR.getBlockData();
      }

      public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

      public IBlockData a() {
         return this.a;
      }
   }
}
