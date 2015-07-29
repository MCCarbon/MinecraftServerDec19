package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xd;
import net.minecraft.server.CreativeTab;

public class class_zc extends Item {
   public class_zc() {
      this.a(CreativeTab.j);
   }

   public class_xd a(World var1, class_aas var2, class_qa var3) {
      return new class_xd(var1, var3);
   }
}
