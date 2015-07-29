package net.minecraft.server;

import net.minecraft.server.class_aan;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_qa;

public class class_zm extends class_aan {
   public class_zm(int var1) {
      super(var1, false);
      this.d(1);
   }

   public class_aas a(class_aas var1, World var2, class_qa var3) {
      super.a(var1, var2, var3);
      return new class_aas(Items.B);
   }
}
