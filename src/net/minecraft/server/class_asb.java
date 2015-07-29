package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_asa;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;

public class class_asb extends class_aso {
   public class_asb() {
   }

   public class_asb(class_aen var1, Random var2, int var3, int var4) {
      super(var3, var4);
      class_asa.class_c_in_class_asa var5 = new class_asa.class_c_in_class_asa(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
      this.a.add(var5);
      var5.a((class_asn)var5, (List)this.a, (Random)var2);
      this.d();
      this.a(var1, var2, 10);
   }
}
