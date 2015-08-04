package net.minecraft.server;

public class class_sb extends class_rx {
   private final EntityOcelot c;

   public class_sb(EntityOcelot var1, double var2) {
      super(var1, var2, 8);
      this.c = var1;
   }

   public boolean a() {
      return this.c.cA() && !this.c.cC() && super.a();
   }

   public boolean b() {
      return super.b();
   }

   public void c() {
      super.c();
      this.c.cE().a(false);
   }

   public void d() {
      super.d();
      this.c.o(false);
   }

   public void e() {
      super.e();
      this.c.cE().a(false);
      if(!this.f()) {
         this.c.o(false);
      } else if(!this.c.cC()) {
         this.c.o(true);
      }

   }

   protected boolean a(World var1, BlockPosition var2) {
      if(!var1.isEmpty(var2.up())) {
         return false;
      } else {
         IBlockData var3 = var1.getType(var2);
         Block var4 = var3.getBlock();
         if(var4 == Blocks.CHEST) {
            TileEntity var5 = var1.getTileEntity(var2);
            if(var5 instanceof TileEntityChest && ((TileEntityChest)var5).l < 1) {
               return true;
            }
         } else {
            if(var4 == Blocks.LIT_FURNACE) {
               return true;
            }

            if(var4 == Blocks.BED && var3.get(BlockBed.PART) != BlockBed.EnumBedPart.HEAD) {
               return true;
            }
         }

         return false;
      }
   }
}
