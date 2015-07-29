package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.Block;
import net.minecraft.server.class_anx;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cq;

public abstract class class_aiv extends Block {
   public static final class_anx O;

   protected class_aiv(Material var1) {
      super(var1);
   }

   protected class_aiv(Material var1, MaterialMapColor var2) {
      super(var1, var2);
   }

   static {
      O = class_anx.a("facing", (Predicate)class_cq.class_c_in_class_cq.a);
   }
}
