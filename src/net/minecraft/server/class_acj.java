package net.minecraft.server;

public class class_acj {
   void a(RecipeManager var1) {
      EnumColor[] var2 = EnumColor.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         EnumColor var5 = var2[var4];
         var1.a(new ItemStack(Items.BANNER, 1, var5.b()), new Object[]{"###", "###", " | ", Character.valueOf('#'), new ItemStack(Blocks.WOOL, 1, var5.a()), Character.valueOf('|'), Items.STICK});
      }

      var1.a(new class_acj.class_b_in_class_acj());
      var1.a(new class_acj.class_a_in_class_acj());
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
   }

   static class class_a_in_class_acj implements class_acs {
      private class_a_in_class_acj() {
      }

      public boolean a(class_yg var1, World var2) {
         boolean var3 = false;

         for(int var4 = 0; var4 < var1.getSize(); ++var4) {
            ItemStack var5 = var1.getItem(var4);
            if(var5 != null && var5.getItem() == Items.BANNER) {
               if(var3) {
                  return false;
               }

               if(TileEntityBanner.c(var5) >= 6) {
                  return false;
               }

               var3 = true;
            }
         }

         if(!var3) {
            return false;
         } else {
            return this.c(var1) != null;
         }
      }

      public ItemStack a(class_yg var1) {
         ItemStack var2 = null;

         for(int var3 = 0; var3 < var1.getSize(); ++var3) {
            ItemStack var4 = var1.getItem(var3);
            if(var4 != null && var4.getItem() == Items.BANNER) {
               var2 = var4.clone();
               var2.count = 1;
               break;
            }
         }

         TileEntityBanner.EnumBannerPattern var8 = this.c(var1);
         if(var8 != null) {
            int var9 = 0;

            ItemStack var6;
            for(int var5 = 0; var5 < var1.getSize(); ++var5) {
               var6 = var1.getItem(var5);
               if(var6 != null && var6.getItem() == Items.DYE) {
                  var9 = var6.i();
                  break;
               }
            }

            NBTTagCompound var10 = var2.getCompound("BlockEntityTag", true);
            var6 = null;
            NBTTagList var11;
            if(var10.hasOfType("Patterns", 9)) {
               var11 = var10.getList("Patterns", 10);
            } else {
               var11 = new NBTTagList();
               var10.put((String)"Patterns", (NBTTag)var11);
            }

            NBTTagCompound var7 = new NBTTagCompound();
            var7.put("Pattern", var8.b());
            var7.put("Color", var9);
            var11.add((NBTTag)var7);
         }

         return var2;
      }

      public int a() {
         return 10;
      }

      public ItemStack b() {
         return null;
      }

      public ItemStack[] b(class_yg var1) {
         ItemStack[] var2 = new ItemStack[var1.getSize()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            ItemStack var4 = var1.getItem(var3);
            if(var4 != null && var4.getItem().hasCraftingResult()) {
               var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
            }
         }

         return var2;
      }

      private TileEntityBanner.EnumBannerPattern c(class_yg var1) {
         TileEntityBanner.EnumBannerPattern[] var2 = TileEntityBanner.EnumBannerPattern.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            TileEntityBanner.EnumBannerPattern var5 = var2[var4];
            if(var5.d()) {
               boolean var6 = true;
               int var9;
               if(var5.e()) {
                  boolean var7 = false;
                  boolean var8 = false;

                  for(var9 = 0; var9 < var1.getSize() && var6; ++var9) {
                     ItemStack var10 = var1.getItem(var9);
                     if(var10 != null && var10.getItem() != Items.BANNER) {
                        if(var10.getItem() == Items.DYE) {
                           if(var8) {
                              var6 = false;
                              break;
                           }

                           var8 = true;
                        } else {
                           if(var7 || !var10.a(var5.f())) {
                              var6 = false;
                              break;
                           }

                           var7 = true;
                        }
                     }
                  }

                  if(!var7) {
                     var6 = false;
                  }
               } else if(var1.getSize() == var5.c().length * var5.c()[0].length()) {
                  int var12 = -1;

                  for(int var13 = 0; var13 < var1.getSize() && var6; ++var13) {
                     var9 = var13 / 3;
                     int var14 = var13 % 3;
                     ItemStack var11 = var1.getItem(var13);
                     if(var11 != null && var11.getItem() != Items.BANNER) {
                        if(var11.getItem() != Items.DYE) {
                           var6 = false;
                           break;
                        }

                        if(var12 != -1 && var12 != var11.i()) {
                           var6 = false;
                           break;
                        }

                        if(var5.c()[var9].charAt(var14) == 32) {
                           var6 = false;
                           break;
                        }

                        var12 = var11.i();
                     } else if(var5.c()[var9].charAt(var14) != 32) {
                        var6 = false;
                        break;
                     }
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  return var5;
               }
            }
         }

         return null;
      }

      // $FF: synthetic method
      class_a_in_class_acj(class_acj.SyntheticClass_1 var1) {
         this();
      }
   }

   static class class_b_in_class_acj implements class_acs {
      private class_b_in_class_acj() {
      }

      public boolean a(class_yg var1, World var2) {
         ItemStack var3 = null;
         ItemStack var4 = null;

         for(int var5 = 0; var5 < var1.getSize(); ++var5) {
            ItemStack var6 = var1.getItem(var5);
            if(var6 != null) {
               if(var6.getItem() != Items.BANNER) {
                  return false;
               }

               if(var3 != null && var4 != null) {
                  return false;
               }

               int var7 = TileEntityBanner.b(var6);
               boolean var8 = TileEntityBanner.c(var6) > 0;
               if(var3 != null) {
                  if(var8) {
                     return false;
                  }

                  if(var7 != TileEntityBanner.b(var3)) {
                     return false;
                  }

                  var4 = var6;
               } else if(var4 != null) {
                  if(!var8) {
                     return false;
                  }

                  if(var7 != TileEntityBanner.b(var4)) {
                     return false;
                  }

                  var3 = var6;
               } else if(var8) {
                  var3 = var6;
               } else {
                  var4 = var6;
               }
            }
         }

         return var3 != null && var4 != null;
      }

      public ItemStack a(class_yg var1) {
         for(int var2 = 0; var2 < var1.getSize(); ++var2) {
            ItemStack var3 = var1.getItem(var2);
            if(var3 != null && TileEntityBanner.c(var3) > 0) {
               ItemStack var4 = var3.clone();
               var4.count = 1;
               return var4;
            }
         }

         return null;
      }

      public int a() {
         return 2;
      }

      public ItemStack b() {
         return null;
      }

      public ItemStack[] b(class_yg var1) {
         ItemStack[] var2 = new ItemStack[var1.getSize()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            ItemStack var4 = var1.getItem(var3);
            if(var4 != null) {
               if(var4.getItem().hasCraftingResult()) {
                  var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
               } else if(var4.hasTag() && TileEntityBanner.c(var4) > 0) {
                  var2[var3] = var4.clone();
                  var2[var3].count = 1;
               }
            }
         }

         return var2;
      }

      // $FF: synthetic method
      class_b_in_class_acj(class_acj.SyntheticClass_1 var1) {
         this();
      }
   }
}
