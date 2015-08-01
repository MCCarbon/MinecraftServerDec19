package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockFragilePlantElement;
import net.minecraft.server.BlockPlant;
import net.minecraft.server.BlockDirectional;
import net.minecraft.server.BlockLongGrass;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.StatisticList;
import net.minecraft.server.INamable;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;

public class class_ahm extends BlockPlant implements IBlockFragilePlantElement {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", class_ahm.class_b_in_class_ahm.class);
   public static final BlockStateEnum b = BlockStateEnum.of("half", class_ahm.class_a_in_class_ahm.class);
   public static final BlockStateEnum N;

   public class_ahm() {
      super(Material.REPLACEABLE_PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_ahm.class_b_in_class_ahm.a).set(b, class_ahm.class_a_in_class_ahm.b).set(N, EnumDirection.NORTH));
      this.setStrength(0.0F);
      this.setStepSound(STEP_SOUND_GRASS);
      this.setName("doublePlant");
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public class_ahm.class_b_in_class_ahm e(IBlockAccess var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      if(var3.getBlock() == this) {
         var3 = this.updateState(var3, var1, var2);
         return (class_ahm.class_b_in_class_ahm)var3.get(a);
      } else {
         return class_ahm.class_b_in_class_ahm.d;
      }
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return super.canPlace(var1, var2) && var1.isEmpty(var2.up());
   }

   public boolean isReplaceable(World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      if(var3.getBlock() != this) {
         return true;
      } else {
         class_ahm.class_b_in_class_ahm var4 = (class_ahm.class_b_in_class_ahm)this.updateState(var3, var1, var2).get(a);
         return var4 == class_ahm.class_b_in_class_ahm.d || var4 == class_ahm.class_b_in_class_ahm.c;
      }
   }

   protected void e(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         boolean var4 = var3.get(b) == class_ahm.class_a_in_class_ahm.a;
         BlockPosition var5 = var4?var2:var2.up();
         BlockPosition var6 = var4?var2.down():var2;
         Object var7 = var4?this:var1.getType(var5).getBlock();
         Object var8 = var4?var1.getType(var6).getBlock():this;
         if(var7 == this) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)Blocks.AIR.getBlockData(), 2);
         }

         if(var8 == this) {
            var1.setTypeAndData((BlockPosition)var6, (IBlockData)Blocks.AIR.getBlockData(), 3);
            if(!var4) {
               this.dropNaturallyForSure(var1, var6, var3, 0);
            }
         }

      }
   }

   public boolean f(World var1, BlockPosition var2, IBlockData var3) {
      if(var3.get(b) == class_ahm.class_a_in_class_ahm.a) {
         return var1.getType(var2.down()).getBlock() == this;
      } else {
         IBlockData var4 = var1.getType(var2.up());
         return var4.getBlock() == this && super.f(var1, var2, var4);
      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      if(var1.get(b) == class_ahm.class_a_in_class_ahm.a) {
         return null;
      } else {
         class_ahm.class_b_in_class_ahm var4 = (class_ahm.class_b_in_class_ahm)var1.get(a);
         return var4 == class_ahm.class_b_in_class_ahm.d?null:(var4 == class_ahm.class_b_in_class_ahm.c?(var2.nextInt(8) == 0?Items.P:null):Item.getByBlock((Block)this));
      }
   }

   public int getDropData(IBlockData var1) {
      return var1.get(b) != class_ahm.class_a_in_class_ahm.a && var1.get(a) != class_ahm.class_b_in_class_ahm.c?((class_ahm.class_b_in_class_ahm)var1.get(a)).a():0;
   }

   public void a(World var1, BlockPosition var2, class_ahm.class_b_in_class_ahm var3, int var4) {
      var1.setTypeAndData(var2, this.getBlockData().set(b, class_ahm.class_a_in_class_ahm.b).set(a, var3), var4);
      var1.setTypeAndData(var2.up(), this.getBlockData().set(b, class_ahm.class_a_in_class_ahm.a), var4);
   }

   public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      var1.setTypeAndData((BlockPosition)var2.up(), (IBlockData)this.getBlockData().set(b, class_ahm.class_a_in_class_ahm.a), 2);
   }

   public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
      if(var1.isClientSide || var6 == null || var6.getItem() != Items.bg || var4.get(b) != class_ahm.class_a_in_class_ahm.b || !this.b(var1, var3, var4, var2)) {
         super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
      if(var3.get(b) == class_ahm.class_a_in_class_ahm.a) {
         if(var1.getType(var2.down()).getBlock() == this) {
            if(!var4.bH.instabuild) {
               IBlockData var5 = var1.getType(var2.down());
               class_ahm.class_b_in_class_ahm var6 = (class_ahm.class_b_in_class_ahm)var5.get(a);
               if(var6 != class_ahm.class_b_in_class_ahm.d && var6 != class_ahm.class_b_in_class_ahm.c) {
                  var1.setAir(var2.down(), true);
               } else if(!var1.isClientSide) {
                  if(var4.bA() != null && var4.bA().getItem() == Items.bg) {
                     this.b(var1, var2, var5, var4);
                     var1.setAir(var2.down());
                  } else {
                     var1.setAir(var2.down(), true);
                  }
               } else {
                  var1.setAir(var2.down());
               }
            } else {
               var1.setAir(var2.down());
            }
         }
      } else if(var4.bH.instabuild && var1.getType(var2.up()).getBlock() == this) {
         var1.setTypeAndData((BlockPosition)var2.up(), (IBlockData)Blocks.AIR.getBlockData(), 2);
      }

      super.a(var1, var2, var3, var4);
   }

   private boolean b(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
      class_ahm.class_b_in_class_ahm var5 = (class_ahm.class_b_in_class_ahm)var3.get(a);
      if(var5 != class_ahm.class_b_in_class_ahm.d && var5 != class_ahm.class_b_in_class_ahm.c) {
         return false;
      } else {
         var4.b(StatisticList.ab[Block.getId((Block)this)]);
         int var6 = (var5 == class_ahm.class_b_in_class_ahm.c?BlockLongGrass.EnumTallGrassType.GRASS:BlockLongGrass.EnumTallGrassType.FERN).getId();
         dropItem(var1, var2, new ItemStack(Blocks.TALLGRASS, 2, var6));
         return true;
      }
   }

   public int getDropData(World var1, BlockPosition var2) {
      return this.e(var1, var2).a();
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
      class_ahm.class_b_in_class_ahm var5 = this.e(var1, var2);
      return var5 != class_ahm.class_b_in_class_ahm.c && var5 != class_ahm.class_b_in_class_ahm.d;
   }

   public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      dropItem(var1, var3, new ItemStack(this, 1, this.e(var1, var3).a()));
   }

   public IBlockData fromLegacyData(int var1) {
      return (var1 & 8) > 0?this.getBlockData().set(b, class_ahm.class_a_in_class_ahm.a):this.getBlockData().set(b, class_ahm.class_a_in_class_ahm.b).set(a, class_ahm.class_b_in_class_ahm.a(var1 & 7));
   }

   public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
      if(var1.get(b) == class_ahm.class_a_in_class_ahm.a) {
         IBlockData var4 = var2.getType(var3.down());
         if(var4.getBlock() == this) {
            var1 = var1.set(a, var4.get(a));
         }
      }

      return var1;
   }

   public int toLegacyData(IBlockData var1) {
      return var1.get(b) == class_ahm.class_a_in_class_ahm.a?8 | ((EnumDirection)var1.get(N)).getHorizontalId():((class_ahm.class_b_in_class_ahm)var1.get(a)).a();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a, N});
   }

   static {
      N = BlockDirectional.FACING;
   }

   public static enum class_a_in_class_ahm implements INamable {
      a,
      b;

      public String toString() {
         return this.getName();
      }

      public String getName() {
         return this == a?"upper":"lower";
      }
   }

   public static enum class_b_in_class_ahm implements INamable {
      a(0, "sunflower"),
      b(1, "syringa"),
      c(2, "double_grass", "grass"),
      d(3, "double_fern", "fern"),
      e(4, "double_rose", "rose"),
      f(5, "paeonia");

      private static final class_ahm.class_b_in_class_ahm[] g;
      private final int h;
      private final String i;
      private final String j;

      private class_b_in_class_ahm(int var3, String var4) {
         this(var3, var4, var4);
      }

      private class_b_in_class_ahm(int var3, String var4, String var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }

      public int a() {
         return this.h;
      }

      public String toString() {
         return this.i;
      }

      public static class_ahm.class_b_in_class_ahm a(int var0) {
         if(var0 < 0 || var0 >= g.length) {
            var0 = 0;
         }

         return g[var0];
      }

      public String getName() {
         return this.i;
      }

      public String c() {
         return this.j;
      }

      static {
         g = new class_ahm.class_b_in_class_ahm[values().length];
         class_ahm.class_b_in_class_ahm[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_ahm.class_b_in_class_ahm var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }
   }
}
