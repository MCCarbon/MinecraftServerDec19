package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahw;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public abstract class class_agd extends Block implements class_ahw {
   protected class_agd(class_atk var1) {
      this(var1, var1.r());
   }

   protected class_agd(class_atk var1, class_atl var2) {
      super(var1, var2);
      this.A = true;
   }

   protected boolean a(class_aen var1, class_cj var2, class_cq var3) {
      return var1.p(var2.a(var3)).getBlock().v() == class_atk.A;
   }

   protected boolean e(class_aen var1, class_cj var2) {
      return this.a(var1, var2, class_cq.c) || this.a(var1, var2, class_cq.d) || this.a(var1, var2, class_cq.e) || this.a(var1, var2, class_cq.f);
   }

   public int b() {
      return -1;
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      super.b(var1, var2, var3);
      var1.t(var2);
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      class_amg var6 = var1.s(var2);
      return var6 == null?false:var6.c(var4, var5);
   }
}
