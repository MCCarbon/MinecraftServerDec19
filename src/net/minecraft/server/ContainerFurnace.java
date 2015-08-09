package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aco;
import net.minecraft.server.TileEntityFurnace;
import net.minecraft.server.IInventory;
import net.minecraft.server.PlayerInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.ICrafting;
import net.minecraft.server.SlotFurnaceFuel;
import net.minecraft.server.SlotFurnaceResult;
import net.minecraft.server.Slot;

public class ContainerFurnace extends Container {
   private final IInventory a;
   private int f;
   private int g;
   private int h;
   private int i;

   public ContainerFurnace(PlayerInventory var1, IInventory var2) {
      this.a = var2;
      this.a((Slot)(new Slot(var2, 0, 56, 17)));
      this.a((Slot)(new SlotFurnaceFuel(var2, 1, 56, 53)));
      this.a((Slot)(new SlotFurnaceResult(var1.e, var2, 2, 116, 35)));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.a((Slot)(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18)));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.a((Slot)(new Slot(var1, var3, 8 + var3 * 18, 142)));
      }

   }

   public void a(ICrafting var1) {
      super.a(var1);
      var1.a(this, (IInventory)this.a);
   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.e.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.e.get(var1);
         if(this.f != this.a.getProperty(2)) {
            var2.a(this, 2, this.a.getProperty(2));
         }

         if(this.h != this.a.getProperty(0)) {
            var2.a(this, 0, this.a.getProperty(0));
         }

         if(this.i != this.a.getProperty(1)) {
            var2.a(this, 1, this.a.getProperty(1));
         }

         if(this.g != this.a.getProperty(3)) {
            var2.a(this, 3, this.a.getProperty(3));
         }
      }

      this.f = this.a.getProperty(2);
      this.h = this.a.getProperty(0);
      this.i = this.a.getProperty(1);
      this.g = this.a.getProperty(3);
   }

   public boolean a(EntityHuman var1) {
      return this.a.isReachable(var1);
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 == 2) {
            if(!this.a(var5, 3, 39, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 != 1 && var2 != 0) {
            if(class_aco.a().a(var5) != null) {
               if(!this.a(var5, 0, 1, false)) {
                  return null;
               }
            } else if(TileEntityFurnace.c(var5)) {
               if(!this.a(var5, 1, 2, false)) {
                  return null;
               }
            } else if(var2 >= 3 && var2 < 30) {
               if(!this.a(var5, 30, 39, false)) {
                  return null;
               }
            } else if(var2 >= 30 && var2 < 39 && !this.a(var5, 3, 30, false)) {
               return null;
            }
         } else if(!this.a(var5, 3, 39, false)) {
            return null;
         }

         if(var5.count == 0) {
            var4.d((ItemStack)null);
         } else {
            var4.f();
         }

         if(var5.count == var3.count) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }
}
