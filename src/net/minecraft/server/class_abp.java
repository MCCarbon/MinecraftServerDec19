package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockSkull;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntitySkull;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_dy;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_abp extends Item {
   private static final String[] a = new String[]{"skeleton", "wither", "zombie", "char", "creeper", "dragon"};

   public class_abp() {
      this.a((CreativeTab)CreativeTab.DECORATIONS);
      this.e(0);
      this.a(true);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         boolean var12 = var11.isReplaceable(var3, var4);
         if(!var12) {
            if(!var3.getType(var4).getBlock().getMaterial().isBuildable()) {
               return class_oq.b;
            }

            var4 = var4.shift(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!BlockStainedGlassPane.SKULL.canPlace(var3, var4)) {
            return class_oq.b;
         } else {
            if(!var3.isClientSide) {
               var3.setTypeAndData((BlockPosition)var4, (IBlockData)BlockStainedGlassPane.SKULL.getBlockData().set(BlockSkull.a, var6), 3);
               int var13 = 0;
               if(var6 == EnumDirection.UP) {
                  var13 = MathHelper.floor((double)(var2.y * 16.0F / 360.0F) + 0.5D) & 15;
               }

               TileEntity var14 = var3.getTileEntity(var4);
               if(var14 instanceof TileEntitySkull) {
                  TileEntitySkull var15 = (TileEntitySkull)var14;
                  if(var1.i() == 3) {
                     GameProfile var16 = null;
                     if(var1.hasTag()) {
                        NBTTagCompound var17 = var1.getTag();
                        if(var17.hasOfType("SkullOwner", 10)) {
                           var16 = class_dy.a(var17.getCompound("SkullOwner"));
                        } else if(var17.hasOfType("SkullOwner", 8) && !var17.getString("SkullOwner").isEmpty()) {
                           var16 = new GameProfile((UUID)null, var17.getString("SkullOwner"));
                        }
                     }

                     var15.a(var16);
                  } else {
                     var15.a(var1.i());
                  }

                  var15.b(var13);
                  BlockStainedGlassPane.SKULL.a(var3, var4, var15);
               }

               --var1.count;
            }

            return class_oq.a;
         }
      }
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      int var2 = var1.i();
      if(var2 < 0 || var2 >= a.length) {
         var2 = 0;
      }

      return super.a() + "." + a[var2];
   }

   public String getLocalizedName(ItemStack var1) {
      if(var1.i() == 3 && var1.hasTag()) {
         if(var1.getTag().hasOfType("SkullOwner", 8)) {
            return LocaleI18n.a("item.skull.player.name", new Object[]{var1.getTag().getString("SkullOwner")});
         }

         if(var1.getTag().hasOfType("SkullOwner", 10)) {
            NBTTagCompound var2 = var1.getTag().getCompound("SkullOwner");
            if(var2.hasOfType("Name", 8)) {
               return LocaleI18n.a("item.skull.player.name", new Object[]{var2.getString("Name")});
            }
         }
      }

      return super.getLocalizedName(var1);
   }

   public boolean a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasOfType("SkullOwner", 8) && !var1.getString("SkullOwner").isEmpty()) {
         GameProfile var2 = new GameProfile((UUID)null, var1.getString("SkullOwner"));
         var2 = TileEntitySkull.b(var2);
         var1.put((String)"SkullOwner", (NBTTag)class_dy.a(new NBTTagCompound(), var2));
         return true;
      } else {
         return false;
      }
   }
}
