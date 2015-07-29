package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.class_aak;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ali;
import net.minecraft.server.class_zy;

public class class_aco {
   private static final class_aco a = new class_aco();
   private Map b = Maps.newHashMap();
   private Map c = Maps.newHashMap();

   public static class_aco a() {
      return a;
   }

   private class_aco() {
      this.a(class_agk.p, new class_aas(class_aau.l), 0.7F);
      this.a(class_agk.o, new class_aas(class_aau.m), 1.0F);
      this.a(class_agk.ag, new class_aas(class_aau.k), 1.0F);
      this.a((Block)class_agk.m, new class_aas(class_agk.w), 0.1F);
      this.a(class_aau.an, new class_aas(class_aau.ao), 0.35F);
      this.a(class_aau.bk, new class_aas(class_aau.bl), 0.35F);
      this.a(class_aau.bm, new class_aas(class_aau.bn), 0.35F);
      this.a(class_aau.bq, new class_aas(class_aau.br), 0.35F);
      this.a(class_aau.bo, new class_aas(class_aau.bp), 0.35F);
      this.a(class_agk.e, new class_aas(class_agk.b), 0.1F);
      this.a(new class_aas(class_agk.bf, 1, class_ali.b), new class_aas(class_agk.bf, 1, class_ali.O), 0.1F);
      this.a(class_aau.aK, new class_aas(class_aau.aJ), 0.3F);
      this.a(class_agk.aL, new class_aas(class_agk.cz), 0.35F);
      this.a((Block)class_agk.aK, new class_aas(class_aau.aY, 1, class_zy.n.b()), 0.2F);
      this.a(class_agk.r, new class_aas(class_aau.j, 1, 1), 0.15F);
      this.a(class_agk.s, new class_aas(class_aau.j, 1, 1), 0.15F);
      this.a(class_agk.bP, new class_aas(class_aau.bR), 1.0F);
      this.a(class_aau.bV, new class_aas(class_aau.bW), 0.35F);
      this.a(class_agk.aV, new class_aas(class_aau.ci), 0.1F);
      this.a(new class_aas(class_agk.v, 1, 1), new class_aas(class_agk.v, 1, 0), 0.15F);
      this.a(class_aau.cI, new class_aas(class_aau.cJ), 0.1F);
      class_aak.class_a_in_class_aak[] var1 = class_aak.class_a_in_class_aak.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aak.class_a_in_class_aak var4 = var1[var3];
         if(var4.g()) {
            this.a(new class_aas(class_aau.aW, 1, var4.a()), new class_aas(class_aau.aX, 1, var4.a()), 0.35F);
         }
      }

      this.a(class_agk.q, new class_aas(class_aau.j), 0.1F);
      this.a(class_agk.aC, new class_aas(class_aau.aE), 0.7F);
      this.a(class_agk.x, new class_aas(class_aau.aY, 1, class_zy.l.b()), 0.2F);
      this.a(class_agk.co, new class_aas(class_aau.cj), 0.2F);
   }

   public void a(Block var1, class_aas var2, float var3) {
      this.a(class_aar.a(var1), var2, var3);
   }

   public void a(class_aar var1, class_aas var2, float var3) {
      this.a(new class_aas(var1, 1, 32767), var2, var3);
   }

   public void a(class_aas var1, class_aas var2, float var3) {
      this.b.put(var1, var2);
      this.c.put(var2, Float.valueOf(var3));
   }

   public class_aas a(class_aas var1) {
      Iterator var2 = this.b.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (class_aas)var3.getKey()));

      return (class_aas)var3.getValue();
   }

   private boolean a(class_aas var1, class_aas var2) {
      return var2.b() == var1.b() && (var2.i() == 32767 || var2.i() == var1.i());
   }

   public Map b() {
      return this.b;
   }

   public float b(class_aas var1) {
      Iterator var2 = this.c.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return 0.0F;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (class_aas)var3.getKey()));

      return ((Float)var3.getValue()).floatValue();
   }
}
