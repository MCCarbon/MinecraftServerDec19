package net.minecraft.server;

import net.minecraft.server.class_aaq;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_abw;
import net.minecraft.server.class_aco;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aih;
import net.minecraft.server.class_amu;
import net.minecraft.server.Material;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_kn;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_oz;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yk;
import net.minecraft.server.class_yl;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.class_zv;

public class class_amr extends class_amu implements class_kn, class_oz {
   private static final int[] a = new int[]{0};
   private static final int[] f = new int[]{2, 1};
   private static final int[] g = new int[]{1};
   private ItemStack[] h = new ItemStack[3];
   private int i;
   private int j;
   private int k;
   private int l;
   private String m;

   public int o_() {
      return this.h.length;
   }

   public ItemStack a(int var1) {
      return this.h[var1];
   }

   public ItemStack a(int var1, int var2) {
      if(this.h[var1] != null) {
         ItemStack var3;
         if(this.h[var1].count <= var2) {
            var3 = this.h[var1];
            this.h[var1] = null;
            return var3;
         } else {
            var3 = this.h[var1].a(var2);
            if(this.h[var1].count == 0) {
               this.h[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(this.h[var1] != null) {
         ItemStack var2 = this.h[var1];
         this.h[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      boolean var3 = var2 != null && var2.a(this.h[var1]) && ItemStack.a(var2, this.h[var1]);
      this.h[var1] = var2;
      if(var2 != null && var2.count > this.q_()) {
         var2.count = this.q_();
      }

      if(var1 == 0 && !var3) {
         this.l = this.a(var2);
         this.k = 0;
         this.p_();
      }

   }

   public String e_() {
      return this.l_()?this.m:"container.furnace";
   }

   public boolean l_() {
      return this.m != null && !this.m.isEmpty();
   }

   public void a(String var1) {
      this.m = var1;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      NBTTagList var2 = var1.getList("Items", 10);
      this.h = new ItemStack[this.o_()];

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         byte var5 = var4.getByte("Slot");
         if(var5 >= 0 && var5 < this.h.length) {
            this.h[var5] = ItemStack.a(var4);
         }
      }

      this.i = var1.getShort("BurnTime");
      this.k = var1.getShort("CookTime");
      this.l = var1.getShort("CookTimeTotal");
      this.j = b(this.h[1]);
      if(var1.hasOfType("CustomName", 8)) {
         this.m = var1.getString("CustomName");
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("BurnTime", (short)this.i);
      var1.put("CookTime", (short)this.k);
      var1.put("CookTimeTotal", (short)this.l);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.h.length; ++var3) {
         if(this.h[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.put("Slot", (byte)var3);
            this.h[var3].write(var4);
            var2.add((NBTTag)var4);
         }
      }

      var1.put((String)"Items", (NBTTag)var2);
      if(this.l_()) {
         var1.put("CustomName", this.m);
      }

   }

   public int q_() {
      return 64;
   }

   public boolean m() {
      return this.i > 0;
   }

   public void c() {
      boolean var1 = this.m();
      boolean var2 = false;
      if(this.m()) {
         --this.i;
      }

      if(!this.b.D) {
         if(!this.m() && (this.h[1] == null || this.h[0] == null)) {
            if(!this.m() && this.k > 0) {
               this.k = MathHelper.clamp(this.k - 2, 0, this.l);
            }
         } else {
            if(!this.m() && this.o()) {
               this.j = this.i = b(this.h[1]);
               if(this.m()) {
                  var2 = true;
                  if(this.h[1] != null) {
                     --this.h[1].count;
                     if(this.h[1].count == 0) {
                        Item var3 = this.h[1].getItem().q();
                        this.h[1] = var3 != null?new ItemStack(var3):null;
                     }
                  }
               }
            }

            if(this.m() && this.o()) {
               ++this.k;
               if(this.k == this.l) {
                  this.k = 0;
                  this.l = this.a(this.h[0]);
                  this.n();
                  var2 = true;
               }
            } else {
               this.k = 0;
            }
         }

         if(var1 != this.m()) {
            var2 = true;
            class_aih.a(this.m(), this.b, this.c);
         }
      }

      if(var2) {
         this.p_();
      }

   }

   public int a(ItemStack var1) {
      return 200;
   }

   private boolean o() {
      if(this.h[0] == null) {
         return false;
      } else {
         ItemStack var1 = class_aco.a().a(this.h[0]);
         return var1 == null?false:(this.h[2] == null?true:(!this.h[2].a(var1)?false:(this.h[2].count < this.q_() && this.h[2].count < this.h[2].c()?true:this.h[2].count < var1.c())));
      }
   }

   public void n() {
      if(this.o()) {
         ItemStack var1 = class_aco.a().a(this.h[0]);
         if(this.h[2] == null) {
            this.h[2] = var1.clone();
         } else if(this.h[2].getItem() == var1.getItem()) {
            ++this.h[2].count;
         }

         if(this.h[0].getItem() == Item.getByBlock(Blocks.SPONGE) && this.h[0].i() == 1 && this.h[1] != null && this.h[1].getItem() == Items.ay) {
            this.h[1] = new ItemStack(Items.az);
         }

         --this.h[0].count;
         if(this.h[0].count <= 0) {
            this.h[0] = null;
         }

      }
   }

   public static int b(ItemStack var0) {
      if(var0 == null) {
         return 0;
      } else {
         Item var1 = var0.getItem();
         if(var1 instanceof ItemBlock && Block.getByItem(var1) != Blocks.AIR) {
            Block var2 = Block.getByItem(var1);
            if(var2 == Blocks.WOODEN_SLAB) {
               return 150;
            }

            if(var2.getMaterial() == Material.WOOD) {
               return 300;
            }

            if(var2 == Blocks.COAL_BLOCK) {
               return 16000;
            }
         }

         return var1 instanceof class_zv && ((class_zv)var1).h().equals("WOOD")?200:(var1 instanceof class_abw && ((class_abw)var1).h().equals("WOOD")?200:(var1 instanceof class_aaq && ((class_aaq)var1).g().equals("WOOD")?200:(var1 == Items.A?100:(var1 == Items.j?1600:(var1 == Items.aA?20000:(var1 == Item.getByBlock(Blocks.SAPLING)?100:(var1 == Items.bx?2400:0)))))));
      }
   }

   public static boolean c(ItemStack var0) {
      return b(var0) > 0;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.getX() + 0.5D, (double)this.c.getY() + 0.5D, (double)this.c.getZ() + 0.5D) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, ItemStack var2) {
      return var1 == 2?false:(var1 != 1?true:c(var2) || class_yk.c_(var2));
   }

   public int[] a(EnumDirection var1) {
      return var1 == EnumDirection.DOWN?f:(var1 == EnumDirection.UP?a:g);
   }

   public boolean a(int var1, ItemStack var2, EnumDirection var3) {
      return this.b(var1, var2);
   }

   public boolean b(int var1, ItemStack var2, EnumDirection var3) {
      if(var3 == EnumDirection.DOWN && var1 == 1) {
         Item var4 = var2.getItem();
         if(var4 != Items.az && var4 != Items.ay) {
            return false;
         }
      }

      return true;
   }

   public String k() {
      return "minecraft:furnace";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yl(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.i;
      case 1:
         return this.j;
      case 2:
         return this.k;
      case 3:
         return this.l;
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.i = var2;
         break;
      case 1:
         this.j = var2;
         break;
      case 2:
         this.k = var2;
         break;
      case 3:
         this.l = var2;
      }

   }

   public int g() {
      return 4;
   }

   public void l() {
      for(int var1 = 0; var1 < this.h.length; ++var1) {
         this.h[var1] = null;
      }

   }
}
