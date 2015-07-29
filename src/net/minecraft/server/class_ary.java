package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_adk;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_asp;
import net.minecraft.server.class_ast;
import net.minecraft.server.class_asu;
import net.minecraft.server.class_asv;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_df;
import net.minecraft.server.class_dn;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_ob;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_ug;

public class class_ary {
   public static class_ast a = new class_ast();
   private static final class_asu b = (new class_asu()).a(true);
   private static final class_asu c = (new class_asu()).a(true).b(true);
   private static final List d;
   private static final List e;
   private static final class_ary.class_b_in_class_ary f;
   private static final List g;
   private static final class_ary.class_b_in_class_ary h;
   private static final class_ary.class_b_in_class_ary i;
   private static final List j;
   private static final class_ary.class_b_in_class_ary k;

   public static void a() {
      class_asl.a(class_ary.class_a_in_class_ary.class, "ECP");
   }

   private static class_ary.class_a_in_class_ary b(class_ary.class_a_in_class_ary var0, class_cj var1, String var2, Block.class_c_in_class_agj var3, boolean var4) {
      class_ary.class_a_in_class_ary var5 = new class_ary.class_a_in_class_ary(var2, var0.c, var3, var4);
      class_cj var6 = var0.a.a(var0.b, var1, var5.a, var5.b, class_cj.a);
      var5.a(var6.n(), var6.o(), var6.p());
      return var5;
   }

   public static void a(class_cj var0, Block.class_c_in_class_agj var1, List var2, Random var3) {
      k.a();
      f.a();
      i.a();
      h.a();
      class_ary.class_a_in_class_ary var4 = new class_ary.class_a_in_class_ary("base_floor", var0, var1, true);
      var2.add(var4);
      byte var5 = 0;
      class_ary.class_a_in_class_ary var6;
      var2.add(var6 = b(var4, new class_cj(-1, 0, -1), "second_floor", var1, false));
      var2.add(var6 = b(var6, new class_cj(-1, 4, -1), "third_floor", var1, false));
      var2.add(var6 = b(var6, new class_cj(-1, 8, -1), "third_roof", var1, true));
      b(h, var5 + 1, var6, (class_cj)null, var2, var3);
   }

   private static boolean b(class_ary.class_b_in_class_ary var0, int var1, class_ary.class_a_in_class_ary var2, class_cj var3, List var4, Random var5) {
      if(var1 > 8) {
         return false;
      } else {
         ArrayList var6 = new ArrayList();
         if(var0.a(var1, var2, var3, var6, var5)) {
            boolean var7 = false;
            int var8 = var5.nextInt();
            Iterator var9 = var6.iterator();

            while(var9.hasNext()) {
               class_asn var10 = (class_asn)var9.next();
               var10.m = var8;
               class_asn var11 = class_asn.a(var4, var10.c());
               if(var11 != null && var11.m != var2.m) {
                  var7 = true;
                  System.out.println("collision");
                  break;
               }
            }

            if(!var7) {
               var4.addAll(var6);
               return true;
            }
         }

         return false;
      }
   }

   static {
      d = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.k, 0, 2, 7, 5), new class_od(Items.l, 0, 4, 8, 10), new class_od(Items.m, 0, 2, 7, 15), new class_od(Items.bR, 0, 2, 6, 2), new class_od(Items.cK, 0, 1, 10, 5), new class_od(Items.aC, 0, 1, 1, 3), new class_od(Items.cn, 0, 1, 1, 1), new class_od(Items.co, 0, 1, 1, 1), new class_od(Items.cp, 0, 1, 1, 1)}));
      e = Lists.newArrayList((Object[])(new Item[]{Items.w, Items.ah, Items.af, Items.ag, Items.ae, Items.y, Items.x, Items.n, Items.ad, Items.ab, Items.ac, Items.aa, Items.b, Items.a}));
      f = new class_ary.class_b_in_class_ary() {
         public void a() {
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, class_cj var3, List var4, Random var5) {
            if(var1 > 8) {
               return false;
            } else {
               Block.class_c_in_class_agj var6 = var2.b.c();
               class_ary.class_a_in_class_ary var7;
               var4.add(var7 = class_ary.b(var2, var3, "base_floor", var6, true));
               int var8 = var5.nextInt(3);
               if(var8 == 0) {
                  var4.add(class_ary.b(var7, new class_cj(-1, 4, -1), "base_roof", var6, true));
               } else if(var8 == 1) {
                  var4.add(var7 = class_ary.b(var7, new class_cj(-1, 0, -1), "second_floor_2", var6, false));
                  var4.add(var7 = class_ary.b(var7, new class_cj(-1, 8, -1), "second_roof", var6, false));
                  class_ary.b(class_ary.h, var1 + 1, var7, (class_cj)null, var4, var5);
               } else if(var8 == 2) {
                  var4.add(var7 = class_ary.b(var7, new class_cj(-1, 0, -1), "second_floor_2", var6, false));
                  var4.add(var7 = class_ary.b(var7, new class_cj(-1, 4, -1), "third_floor_c", var6, false));
                  var4.add(var7 = class_ary.b(var7, new class_cj(-1, 8, -1), "third_roof", var6, true));
                  class_ary.b(class_ary.h, var1 + 1, var7, (class_cj)null, var4, var5);
               }

               return true;
            }
         }
      };
      g = new ArrayList();
      g.add(new class_ob(Block.class_c_in_class_agj.a, new class_cj(1, -1, 0)));
      g.add(new class_ob(Block.class_c_in_class_agj.b, new class_cj(6, -1, 1)));
      g.add(new class_ob(Block.class_c_in_class_agj.d, new class_cj(0, -1, 5)));
      g.add(new class_ob(Block.class_c_in_class_agj.c, new class_cj(5, -1, 6)));
      h = new class_ary.class_b_in_class_ary() {
         public void a() {
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, class_cj var3, List var4, Random var5) {
            Block.class_c_in_class_agj var6 = var2.b.c();
            class_ary.class_a_in_class_ary var7;
            var4.add(var7 = class_ary.b(var2, new class_cj(3 + var5.nextInt(2), -3, 3 + var5.nextInt(2)), "tower_base", var6, true));
            var4.add(var7 = class_ary.b(var7, new class_cj(0, 7, 0), "tower_piece", var6, true));
            class_ary.class_a_in_class_ary var8 = var5.nextInt(3) == 0?var7:null;
            int var9 = 1 + var5.nextInt(3);

            for(int var10 = 0; var10 < var9; ++var10) {
               var4.add(var7 = class_ary.b(var7, new class_cj(0, 4, 0), "tower_piece", var6, true));
               if(var10 < var9 - 1 && var5.nextBoolean()) {
                  var8 = var7;
               }
            }

            if(var8 != null) {
               Iterator var13 = class_ary.g.iterator();

               while(var13.hasNext()) {
                  class_ob var11 = (class_ob)var13.next();
                  if(var5.nextBoolean()) {
                     class_ary.class_a_in_class_ary var12;
                     var4.add(var12 = class_ary.b(var8, (class_cj)var11.b(), "bridge_end", var6.a((Block.class_c_in_class_agj)var11.a()), true));
                     class_ary.b(class_ary.i, var1 + 1, var12, (class_cj)null, var4, var5);
                  }
               }

               var4.add(class_ary.b(var7, new class_cj(-1, 4, -1), "tower_top", var6, true));
            } else {
               if(var1 != 7) {
                  return class_ary.b(class_ary.k, var1 + 1, var7, (class_cj)null, var4, var5);
               }

               var4.add(class_ary.b(var7, new class_cj(-1, 4, -1), "tower_top", var6, true));
            }

            return true;
         }
      };
      i = new class_ary.class_b_in_class_ary() {
         public boolean a;

         public void a() {
            this.a = false;
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, class_cj var3, List var4, Random var5) {
            Block.class_c_in_class_agj var7 = var2.b.c();
            int var8 = var5.nextInt(4) + 1;
            byte var9 = 0;
            class_ary.class_a_in_class_ary var6;
            var4.add(var6 = class_ary.b(var2, new class_cj(0, 0, -4), "bridge_piece", var7, true));
            var6.m = -1;

            for(int var10 = 0; var10 < var8; ++var10) {
               if(var5.nextBoolean()) {
                  var4.add(var6 = class_ary.b(var6, new class_cj(0, var9, -4), "bridge_piece", var7, true));
                  var9 = 0;
               } else {
                  if(var5.nextBoolean()) {
                     var4.add(var6 = class_ary.b(var6, new class_cj(0, var9, -4), "bridge_steep_stairs", var7, true));
                  } else {
                     var4.add(var6 = class_ary.b(var6, new class_cj(0, var9, -8), "bridge_gentle_stairs", var7, true));
                  }

                  var9 = 4;
               }
            }

            if(!this.a && var5.nextInt(10 - var1) == 0) {
               var4.add(class_ary.b(var6, new class_cj(-8 + var5.nextInt(8), var9, -70 + var5.nextInt(10)), "ship", var7, true));
               this.a = true;
            } else if(!class_ary.b(class_ary.f, var1 + 1, var6, new class_cj(-3, var9 + 1, -11), var4, var5)) {
               return false;
            }

            var4.add(var6 = class_ary.b(var6, new class_cj(4, var9, 0), "bridge_end", var7.a(Block.class_c_in_class_agj.c), true));
            var6.m = -1;
            return true;
         }
      };
      j = new ArrayList();
      j.add(new class_ob(Block.class_c_in_class_agj.a, new class_cj(4, -1, 0)));
      j.add(new class_ob(Block.class_c_in_class_agj.b, new class_cj(12, -1, 4)));
      j.add(new class_ob(Block.class_c_in_class_agj.d, new class_cj(0, -1, 8)));
      j.add(new class_ob(Block.class_c_in_class_agj.c, new class_cj(8, -1, 12)));
      k = new class_ary.class_b_in_class_ary() {
         public void a() {
         }

         public boolean a(int var1, class_ary.class_a_in_class_ary var2, class_cj var3, List var4, Random var5) {
            Block.class_c_in_class_agj var7 = var2.b.c();
            class_ary.class_a_in_class_ary var6;
            var4.add(var6 = class_ary.b(var2, new class_cj(-3, 4, -3), "fat_tower_base", var7, true));
            var4.add(var6 = class_ary.b(var6, new class_cj(0, 4, 0), "fat_tower_middle", var7, true));

            for(int var8 = 0; var8 < 2 && var5.nextInt(3) != 0; ++var8) {
               var4.add(var6 = class_ary.b(var6, new class_cj(0, 8, 0), "fat_tower_middle", var7, true));
               Iterator var9 = class_ary.j.iterator();

               while(var9.hasNext()) {
                  class_ob var10 = (class_ob)var9.next();
                  if(var5.nextBoolean()) {
                     class_ary.class_a_in_class_ary var11;
                     var4.add(var11 = class_ary.b(var6, (class_cj)var10.b(), "bridge_end", var7.a((Block.class_c_in_class_agj)var10.a()), true));
                     class_ary.b(class_ary.i, var1 + 1, var11, (class_cj)null, var4, var5);
                  }
               }
            }

            var4.add(class_ary.b(var6, new class_cj(-2, 8, -2), "fat_tower_top", var7, true));
            return true;
         }
      };
   }

   interface class_b_in_class_ary {
      void a();

      boolean a(int var1, class_ary.class_a_in_class_ary var2, class_cj var3, List var4, Random var5);
   }

   public static class class_a_in_class_ary extends class_asp {
      private String d;
      private Block.class_c_in_class_agj e;
      private boolean f;

      public class_a_in_class_ary() {
      }

      public class_a_in_class_ary(String var1, class_cj var2, Block.class_c_in_class_agj var3, boolean var4) {
         super(0);
         this.d = var1;
         this.e = var3;
         this.f = var4;
         this.a(var2);
      }

      private void a(class_cj var1) {
         class_asv var2 = class_ary.a.a(new MinecraftKey("endcity/" + this.d));
         class_asu var3 = null;
         if(this.f) {
            var3 = class_ary.b.a().a(this.e);
         } else {
            var3 = class_ary.c.a().a(this.e);
         }

         this.a(var2, var1, var3);
      }

      protected void a(class_dn var1) {
         super.a(var1);
         var1.a("Template", this.d);
         var1.a("Rot", this.e.name());
         var1.a("OW", this.f);
      }

      protected void b(class_dn var1) {
         super.b(var1);
         this.d = var1.k("Template");
         this.e = Block.class_c_in_class_agj.valueOf(var1.k("Rot"));
         this.f = var1.o("OW");
         this.a(this.c);
      }

      protected void a(String var1, class_cj var2, World var3, Random var4, class_arw var5) {
         if(var1.startsWith("Chest")) {
            class_cj var6 = var2.b();
            if(var5.b((class_df)var6)) {
               class_amg var7 = var3.s(var6);
               if(var7 instanceof class_ami) {
                  ArrayList var8 = Lists.newArrayList((Iterable)class_ary.d);
                  Iterator var9 = class_ary.e.iterator();

                  while(var9.hasNext()) {
                     Item var10 = (Item)var9.next();
                     var8.add(new class_od(class_adk.a(var4, new class_aas(var10), 20 + var4.nextInt(20)), 1, 1, 3));
                  }

                  class_od.a(var4, var8, (class_oj)((class_ami)var7), 2 + var4.nextInt(5));
               }
            }
         } else if(var1.startsWith("Sentry")) {
            class_ug var11 = new class_ug(var3);
            var11.b((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D);
            var11.f(var2);
            var3.a((class_pr)var11);
         }

      }
   }
}
