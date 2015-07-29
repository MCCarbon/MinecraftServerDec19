package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_abl extends Item {
   public class_abl() {
      this.d(1);
      this.e(238);
      this.a(CreativeTab.i);
   }

   public boolean a(class_aas var1, World var2, Block var3, class_cj var4, class_qa var5) {
      if(var3.getMaterial() != Material.j && var3 != Blocks.WEB && var3 != Blocks.TALLGRASS && var3 != Blocks.VINE && var3 != Blocks.TRIPWIRE && var3 != Blocks.WOOL) {
         return super.a(var1, var2, var3, var4, var5);
      } else {
         var1.a(1, (class_qa)var5);
         return true;
      }
   }

   public boolean b(Block var1) {
      return var1 == Blocks.WEB || var1 == Blocks.REDSTONE_WIRE || var1 == Blocks.TRIPWIRE;
   }

   public float a(class_aas var1, Block var2) {
      return var2 != Blocks.WEB && var2.getMaterial() != Material.j?(var2 == Blocks.WOOL?5.0F:super.a(var1, var2)):15.0F;
   }
}
