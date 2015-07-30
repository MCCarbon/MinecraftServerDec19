package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_nc;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oi;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uc;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.CreativeTab;

public class class_agu extends class_agd {
   public static final class_anx a;
   public final int b;

   protected class_agu(int var1) {
      super(Material.WOOD);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH));
      this.b = var1;
      this.a(CreativeTab.c);
      this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int getRenderType() {
      return 2;
   }

   public void a(class_aer var1, BlockPosition var2) {
      if(var1.p(var2.shiftNorth()).getBlock() == this) {
         this.setSizes(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.p(var2.shiftSouth()).getBlock() == this) {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(var1.p(var2.shiftWest()).getBlock() == this) {
         this.setSizes(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.p(var2.shiftEast()).getBlock() == this) {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3);
      Iterator var4 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var4.hasNext()) {
         EnumDirection var5 = (EnumDirection)var4.next();
         BlockPosition var6 = var2.shift(var5);
         IBlockData var7 = var1.p(var6);
         if(var7.getBlock() == this) {
            this.e(var1, var6, var7);
         }
      }

   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, var8.aR());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, class_aas var5) {
      EnumDirection var6 = EnumDirection.getByHorizontalId(MathHelper.floor((double)(var4.y * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
      var3 = var3.set(a, var6);
      BlockPosition var7 = var2.shiftNorth();
      BlockPosition var8 = var2.shiftSouth();
      BlockPosition var9 = var2.shiftWest();
      BlockPosition var10 = var2.shiftEast();
      boolean var11 = this == var1.p(var7).getBlock();
      boolean var12 = this == var1.p(var8).getBlock();
      boolean var13 = this == var1.p(var9).getBlock();
      boolean var14 = this == var1.p(var10).getBlock();
      if(!var11 && !var12 && !var13 && !var14) {
         var1.a((BlockPosition)var2, (IBlockData)var3, 3);
      } else if(var6.getAxis() == EnumDirection.EnumAxis.X && (var11 || var12)) {
         if(var11) {
            var1.a((BlockPosition)var7, (IBlockData)var3, 3);
         } else {
            var1.a((BlockPosition)var8, (IBlockData)var3, 3);
         }

         var1.a((BlockPosition)var2, (IBlockData)var3, 3);
      } else if(var6.getAxis() == EnumDirection.EnumAxis.Z && (var13 || var14)) {
         if(var13) {
            var1.a((BlockPosition)var9, (IBlockData)var3, 3);
         } else {
            var1.a((BlockPosition)var10, (IBlockData)var3, 3);
         }

         var1.a((BlockPosition)var2, (IBlockData)var3, 3);
      }

      if(var5.s()) {
         class_amg var15 = var1.s(var2);
         if(var15 instanceof class_ami) {
            ((class_ami)var15).a(var5.q());
         }
      }

   }

   public IBlockData e(World var1, BlockPosition var2, IBlockData var3) {
      if(var1.D) {
         return var3;
      } else {
         IBlockData var4 = var1.p(var2.shiftNorth());
         IBlockData var5 = var1.p(var2.shiftSouth());
         IBlockData var6 = var1.p(var2.shiftWest());
         IBlockData var7 = var1.p(var2.shiftEast());
         EnumDirection var8 = (EnumDirection)var3.get(a);
         Block var9 = var4.getBlock();
         Block var10 = var5.getBlock();
         Block var11 = var6.getBlock();
         Block var12 = var7.getBlock();
         if(var9 != this && var10 != this) {
            boolean var21 = var9.isFullBlock();
            boolean var22 = var10.isFullBlock();
            if(var11 == this || var12 == this) {
               BlockPosition var23 = var11 == this?var2.shiftWest():var2.shiftEast();
               IBlockData var24 = var1.p(var23.shiftNorth());
               IBlockData var25 = var1.p(var23.shiftSouth());
               var8 = EnumDirection.SOUTH;
               EnumDirection var26;
               if(var11 == this) {
                  var26 = (EnumDirection)var6.get(a);
               } else {
                  var26 = (EnumDirection)var7.get(a);
               }

               if(var26 == EnumDirection.NORTH) {
                  var8 = EnumDirection.NORTH;
               }

               Block var19 = var24.getBlock();
               Block var20 = var25.getBlock();
               if((var21 || var19.isFullBlock()) && !var22 && !var20.isFullBlock()) {
                  var8 = EnumDirection.SOUTH;
               }

               if((var22 || var20.isFullBlock()) && !var21 && !var19.isFullBlock()) {
                  var8 = EnumDirection.NORTH;
               }
            }
         } else {
            BlockPosition var13 = var9 == this?var2.shiftNorth():var2.shiftSouth();
            IBlockData var14 = var1.p(var13.shiftWest());
            IBlockData var15 = var1.p(var13.shiftEast());
            var8 = EnumDirection.EAST;
            EnumDirection var16;
            if(var9 == this) {
               var16 = (EnumDirection)var4.get(a);
            } else {
               var16 = (EnumDirection)var5.get(a);
            }

            if(var16 == EnumDirection.WEST) {
               var8 = EnumDirection.WEST;
            }

            Block var17 = var14.getBlock();
            Block var18 = var15.getBlock();
            if((var11.isFullBlock() || var17.isFullBlock()) && !var12.isFullBlock() && !var18.isFullBlock()) {
               var8 = EnumDirection.EAST;
            }

            if((var12.isFullBlock() || var18.isFullBlock()) && !var11.isFullBlock() && !var17.isFullBlock()) {
               var8 = EnumDirection.WEST;
            }
         }

         var3 = var3.set(a, var8);
         var1.a((BlockPosition)var2, (IBlockData)var3, 3);
         return var3;
      }
   }

   public IBlockData f(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = null;
      Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var5.hasNext()) {
         EnumDirection var6 = (EnumDirection)var5.next();
         IBlockData var7 = var1.p(var2.shift(var6));
         if(var7.getBlock() == this) {
            return var3;
         }

         if(var7.getBlock().isFullBlock()) {
            if(var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if(var4 != null) {
         return var3.set(a, var4.getOpposite());
      } else {
         EnumDirection var8 = (EnumDirection)var3.get(a);
         if(var1.p(var2.shift(var8)).getBlock().isFullBlock()) {
            var8 = var8.getOpposite();
         }

         if(var1.p(var2.shift(var8)).getBlock().isFullBlock()) {
            var8 = var8.rotateY();
         }

         if(var1.p(var2.shift(var8)).getBlock().isFullBlock()) {
            var8 = var8.getOpposite();
         }

         return var3.set(a, var8);
      }
   }

   public boolean d(World var1, BlockPosition var2) {
      int var3 = 0;
      BlockPosition var4 = var2.shiftWest();
      BlockPosition var5 = var2.shiftEast();
      BlockPosition var6 = var2.shiftNorth();
      BlockPosition var7 = var2.shiftSouth();
      if(var1.p(var4).getBlock() == this) {
         if(this.m(var1, var4)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var5).getBlock() == this) {
         if(this.m(var1, var5)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var6).getBlock() == this) {
         if(this.m(var1, var6)) {
            return false;
         }

         ++var3;
      }

      if(var1.p(var7).getBlock() == this) {
         if(this.m(var1, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   private boolean m(World var1, BlockPosition var2) {
      if(var1.p(var2).getBlock() != this) {
         return false;
      } else {
         Iterator var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         EnumDirection var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (EnumDirection)var3.next();
         } while(var1.p(var2.shift(var4)).getBlock() != this);

         return true;
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_ami) {
         var5.E();
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_oj) {
         class_ol.a(var1, var2, (class_oj)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_ou var11 = this.f(var1, var2);
         if(var11 != null) {
            var4.a((class_oj)var11);
            if(this.b == 0) {
               var4.b(class_nc.aa);
            } else if(this.b == 1) {
               var4.b(class_nc.U);
            }
         }

         return true;
      }
   }

   public class_ou f(World var1, BlockPosition var2) {
      class_amg var3 = var1.s(var2);
      if(!(var3 instanceof class_ami)) {
         return null;
      } else {
         Object var4 = (class_ami)var3;
         if(this.n(var1, var2)) {
            return null;
         } else {
            Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while(true) {
               while(true) {
                  EnumDirection var6;
                  class_amg var9;
                  do {
                     BlockPosition var7;
                     Block var8;
                     do {
                        if(!var5.hasNext()) {
                           return (class_ou)var4;
                        }

                        var6 = (EnumDirection)var5.next();
                        var7 = var2.shift(var6);
                        var8 = var1.p(var7).getBlock();
                     } while(var8 != this);

                     if(this.n(var1, var7)) {
                        return null;
                     }

                     var9 = var1.s(var7);
                  } while(!(var9 instanceof class_ami));

                  if(var6 != EnumDirection.WEST && var6 != EnumDirection.NORTH) {
                     var4 = new class_oi("container.chestDouble", (class_ou)var4, (class_ami)var9);
                  } else {
                     var4 = new class_oi("container.chestDouble", (class_ami)var9, (class_ou)var4);
                  }
               }
            }
         }
      }
   }

   public class_amg a(World var1, int var2) {
      return new class_ami();
   }

   public boolean isPowerSource() {
      return this.b == 1;
   }

   public int a(class_aer var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      if(!this.isPowerSource()) {
         return 0;
      } else {
         int var5 = 0;
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_ami) {
            var5 = ((class_ami)var6).l;
         }

         return MathHelper.clamp(var5, 0, 15);
      }
   }

   public int b(class_aer var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return var4 == EnumDirection.UP?this.a(var1, var2, var3, var4):0;
   }

   private boolean n(World var1, BlockPosition var2) {
      return this.o(var1, var2) || this.p(var1, var2);
   }

   private boolean o(World var1, BlockPosition var2) {
      return var1.p(var2.shiftUp()).getBlock().isOccluding();
   }

   private boolean p(World var1, BlockPosition var2) {
      Iterator var3 = var1.a(class_uc.class, new class_awf((double)var2.getX(), (double)(var2.getY() + 1), (double)var2.getZ(), (double)(var2.getX() + 1), (double)(var2.getY() + 2), (double)(var2.getZ() + 1))).iterator();

      class_uc var5;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         class_pr var4 = (class_pr)var3.next();
         var5 = (class_uc)var4;
      } while(!var5.cC());

      return true;
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, BlockPosition var2) {
      return class_xz.b((class_oj)this.f(var1, var2));
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection var2 = EnumDirection.getById(var1);
      if(var2.getAxis() == EnumDirection.EnumAxis.Y) {
         var2 = EnumDirection.NORTH;
      }

      return this.getBlockData().set(a, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(a)).getId();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      a = class_aiv.O;
   }
}
