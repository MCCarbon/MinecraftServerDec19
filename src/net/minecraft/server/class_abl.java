package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_abl extends class_aar {
   public class_abl() {
      this.d(1);
      this.e(238);
      this.a(CreativeTab.i);
   }

   public boolean a(class_aas var1, class_aen var2, Block var3, class_cj var4, class_qa var5) {
      if(var3.v() != class_atk.j && var3 != class_agk.G && var3 != class_agk.H && var3 != class_agk.bn && var3 != class_agk.bS && var3 != class_agk.L) {
         return super.a(var1, var2, var3, var4, var5);
      } else {
         var1.a(1, (class_qa)var5);
         return true;
      }
   }

   public boolean b(Block var1) {
      return var1 == class_agk.G || var1 == class_agk.af || var1 == class_agk.bS;
   }

   public float a(class_aas var1, Block var2) {
      return var2 != class_agk.G && var2.v() != class_atk.j?(var2 == class_agk.L?5.0F:super.a(var1, var2)):15.0F;
   }
}
