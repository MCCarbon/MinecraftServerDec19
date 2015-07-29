package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_zv;

public class class_zd extends class_zv {
   private static final Set c;

   protected class_zd(class_aar.class_a_in_class_aar var1) {
      super(3.0F, var1, c);
   }

   public float a(class_aas var1, Block var2) {
      return var2.v() != class_atk.d && var2.v() != class_atk.k && var2.v() != class_atk.l?super.a(var1, var2):this.a;
   }

   static {
      c = Sets.newHashSet((Object[])(new Block[]{class_agk.f, class_agk.X, class_agk.r, class_agk.s, class_agk.ae, class_agk.aU, class_agk.aZ, class_agk.bk, class_agk.au}));
   }
}
