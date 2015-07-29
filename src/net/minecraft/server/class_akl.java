package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;

public class class_akl extends Block {
   private final boolean a;

   public class_akl(boolean var1) {
      super(Material.t);
      this.a = var1;
      if(var1) {
         this.setLightLevel(1.0F);
      }

   }

   public void c(World var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)Blocks.REDSTONE_LAMP.getBlockData(), 2);
         } else if(!this.a && var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)Blocks.LIT_REDSTONE_LAMP.getBlockData(), 2);
         }

      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a((class_cj)var2, (Block)this, 4);
         } else if(!this.a && var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)Blocks.LIT_REDSTONE_LAMP.getBlockData(), 2);
         }

      }
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a((class_cj)var2, (IBlockData)Blocks.REDSTONE_LAMP.getBlockData(), 2);
         }

      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock(Blocks.REDSTONE_LAMP);
   }

   protected class_aas i(IBlockData var1) {
      return new class_aas(Blocks.REDSTONE_LAMP);
   }
}
