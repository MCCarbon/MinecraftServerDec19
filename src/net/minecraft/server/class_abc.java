package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_zv;

public class class_abc extends class_zv {
   private static final Set c;

   protected class_abc(class_aar.class_a_in_class_aar var1) {
      super(2.0F, var1, c);
   }

   public boolean b(class_agj var1) {
      return var1 == class_agk.Z?this.b.d() == 3:(var1 != class_agk.ah && var1 != class_agk.ag?(var1 != class_agk.bP && var1 != class_agk.bT?(var1 != class_agk.R && var1 != class_agk.o?(var1 != class_agk.S && var1 != class_agk.p?(var1 != class_agk.y && var1 != class_agk.x?(var1 != class_agk.aC && var1 != class_agk.aD?(var1.v() == class_atk.e?true:(var1.v() == class_atk.f?true:var1.v() == class_atk.g)):this.b.d() >= 2):this.b.d() >= 1):this.b.d() >= 1):this.b.d() >= 2):this.b.d() >= 2):this.b.d() >= 2);
   }

   public float a(class_aas var1, class_agj var2) {
      return var2.v() != class_atk.f && var2.v() != class_atk.g && var2.v() != class_atk.e?super.a(var1, var2):this.a;
   }

   static {
      c = Sets.newHashSet((Object[])(new class_agj[]{class_agk.cs, class_agk.q, class_agk.e, class_agk.E, class_agk.ah, class_agk.ag, class_agk.T, class_agk.D, class_agk.R, class_agk.o, class_agk.aI, class_agk.S, class_agk.p, class_agk.y, class_agk.x, class_agk.aD, class_agk.Y, class_agk.aV, class_agk.cB, class_agk.av, class_agk.aC, class_agk.A, class_agk.cM, class_agk.b, class_agk.U}));
   }
}
