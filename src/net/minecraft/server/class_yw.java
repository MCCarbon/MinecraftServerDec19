package net.minecraft.server;

public class class_yw extends class_yx {
   private final class_yg a;
   private final EntityHuman b;
   private int c;

   public class_yw(EntityHuman var1, class_yg var2, IInventory var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.b = var1;
      this.a = var2;
   }

   public boolean a(ItemStack var1) {
      return false;
   }

   public ItemStack a(int var1) {
      if(this.e()) {
         this.c += Math.min(var1, this.d().count);
      }

      return super.a(var1);
   }

   protected void a(ItemStack var1, int var2) {
      this.c += var2;
      this.c(var1);
   }

   protected void c(ItemStack var1) {
      if(this.c > 0) {
         var1.a(this.b.o, this.b, this.c);
      }

      this.c = 0;
      if(var1.getItem() == Item.getItemOf(Blocks.CRAFTING_TABLE)) {
         this.b.b((class_my)class_mt.h);
      }

      if(var1.getItem() instanceof ItemPickaxe) {
         this.b.b((class_my)class_mt.i);
      }

      if(var1.getItem() == Item.getItemOf(Blocks.FURNACE)) {
         this.b.b((class_my)class_mt.j);
      }

      if(var1.getItem() instanceof class_aaq) {
         this.b.b((class_my)class_mt.l);
      }

      if(var1.getItem() == Items.BREAD) {
         this.b.b((class_my)class_mt.m);
      }

      if(var1.getItem() == Items.bb) {
         this.b.b((class_my)class_mt.n);
      }

      if(var1.getItem() instanceof ItemPickaxe && ((ItemPickaxe)var1.getItem()).g() != Item.EnumToolMaterial.WOOD) {
         this.b.b((class_my)class_mt.o);
      }

      if(var1.getItem() instanceof class_abw) {
         this.b.b((class_my)class_mt.r);
      }

      if(var1.getItem() == Item.getItemOf(Blocks.ENCHANTING_TABLE)) {
         this.b.b((class_my)class_mt.E);
      }

      if(var1.getItem() == Item.getItemOf(Blocks.BOOKSHELF)) {
         this.b.b((class_my)class_mt.G);
      }

      if(var1.getItem() == Items.GOLDEN_APPLE && var1.i() == 1) {
         this.b.b((class_my)class_mt.M);
      }

   }

   public void a(EntityHuman var1, ItemStack var2) {
      this.c(var2);
      ItemStack[] var3 = RecipeManager.a().b(this.a, var1.o);

      for(int var4 = 0; var4 < var3.length; ++var4) {
         ItemStack var5 = this.a.getItem(var4);
         ItemStack var6 = var3[var4];
         if(var5 != null) {
            this.a.splitStack(var4, 1);
         }

         if(var6 != null) {
            if(this.a.getItem(var4) == null) {
               this.a.setItem(var4, var6);
            } else if(!this.b.inventory.a(var6)) {
               this.b.a(var6, false);
            }
         }
      }

   }
}
