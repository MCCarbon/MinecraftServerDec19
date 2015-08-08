package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class ItemSkull extends Item {
   private static final String[] a = new String[]{"skeleton", "wither", "zombie", "char", "creeper", "dragon"};

   public ItemSkull() {
      this.setCreativeTab((CreativeTab) CreativeTab.DECORATIONS);
      this.setMaxDurability(0);
      this.setUsesData(true);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return UseResult.CANT_USE;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         boolean var12 = var11.isReplaceable(var3, var4);
         if(!var12) {
            if(!var3.getType(var4).getBlock().getMaterial().isBuildable()) {
               return UseResult.CANT_USE;
            }

            var4 = var4.shift(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return UseResult.CANT_USE;
         } else if(!Blocks.SKULL.canPlace(var3, var4)) {
            return UseResult.CANT_USE;
         } else {
            if(!var3.isClientSide) {
               var3.setTypeAndData((BlockPosition)var4, (IBlockData)Blocks.SKULL.getBlockData().set(BlockSkull.a, var6), 3);
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
                  Blocks.SKULL.a(var3, var4, var15);
               }

               --var1.count;
            }

            return UseResult.SUCCESS;
         }
      }
   }

   public int filterData(int var1) {
      return var1;
   }

   public String getName(ItemStack var1) {
      int var2 = var1.i();
      if(var2 < 0 || var2 >= a.length) {
         var2 = 0;
      }

      return super.getName() + "." + a[var2];
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

   public boolean updateNBT(NBTTagCompound var1) {
      super.updateNBT(var1);
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
