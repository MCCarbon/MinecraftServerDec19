package net.minecraft.server;

public class BlockWorkbench extends Block {
   protected BlockWorkbench() {
      super(Material.WOOD);
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         var4.a((ITileEntityContainer)(new BlockWorkbench.class_a_in_class_ahc(var1, var2)));
         var4.b(StatisticList.Z);
         return true;
      }
   }

   public static class class_a_in_class_ahc implements ITileEntityContainer {
      private final World a;
      private final BlockPosition b;

      public class_a_in_class_ahc(World var1, BlockPosition var2) {
         this.a = var1;
         this.b = var2;
      }

      public String getName() {
         return null;
      }

      public boolean hasCustomName() {
         return false;
      }

      public IChatBaseComponent getScoreboardDisplayName() {
         return new ChatMessage(Blocks.CRAFTING_TABLE.getInternalName() + ".name", new Object[0]);
      }

      public Container createContainer(PlayerInventory var1, EntityHuman var2) {
         return new class_yh(var1, this.a, this.b);
      }

      public String getContainerName() {
         return "minecraft:crafting_table";
      }
   }
}
