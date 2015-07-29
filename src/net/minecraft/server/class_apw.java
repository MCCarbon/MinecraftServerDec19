package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public abstract class class_apw extends class_aql {
   public class_apw(boolean var1) {
      super(var1);
   }

   protected boolean a(Block var1) {
      class_atk var2 = var1.v();
      return var2 == class_atk.a || var2 == class_atk.j || var1 == class_agk.c || var1 == class_agk.d || var1 == class_agk.r || var1 == class_agk.s || var1 == class_agk.g || var1 == class_agk.bn;
   }

   public void a(class_aen var1, Random var2, class_cj var3) {
   }

   protected void a(class_aen var1, class_cj var2) {
      if(var1.p(var2).getBlock() != class_agk.d) {
         this.a(var1, var2, class_agk.d.S());
      }

   }
}
