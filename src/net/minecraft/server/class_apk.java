package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apn;
import net.minecraft.server.class_aqu;
import net.minecraft.server.class_ara;
import net.minecraft.server.class_arr;
import net.minecraft.server.class_ars;
import net.minecraft.server.class_arz;
import net.minecraft.server.class_ase;
import net.minecraft.server.class_asg;
import net.minecraft.server.class_asi;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_asq;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nw;
import net.minecraft.server.class_qc;

public class class_apk implements class_aoh {
   private World a;
   private Random b;
   private final IBlockData[] c = new IBlockData[256];
   private final class_arr d;
   private final List e = Lists.newArrayList();
   private final boolean f;
   private final boolean g;
   private class_aqu h;
   private class_aqu i;

   public class_apk(World var1, long var2, boolean var4, String var5) {
      this.a = var1;
      this.b = new Random(var2);
      this.d = class_arr.a(var5);
      if(var4) {
         Map var6 = this.d.b();
         if(var6.containsKey("village")) {
            Map var7 = (Map)var6.get("village");
            if(!var7.containsKey("size")) {
               var7.put("size", "1");
            }

            this.e.add(new class_asq(var7));
         }

         if(var6.containsKey("biome_1")) {
            this.e.add(new class_asg((Map)var6.get("biome_1")));
         }

         if(var6.containsKey("mineshaft")) {
            this.e.add(new class_arz((Map)var6.get("mineshaft")));
         }

         if(var6.containsKey("stronghold")) {
            this.e.add(new class_asi((Map)var6.get("stronghold")));
         }

         if(var6.containsKey("oceanmonument")) {
            this.e.add(new class_ase((Map)var6.get("oceanmonument")));
         }
      }

      if(this.d.b().containsKey("lake")) {
         this.h = new class_aqu(Blocks.WATER);
      }

      if(this.d.b().containsKey("lava_lake")) {
         this.i = new class_aqu(Blocks.LAVA);
      }

      this.g = this.d.b().containsKey("dungeon");
      int var13 = 0;
      int var14 = 0;
      boolean var8 = true;
      Iterator var9 = this.d.c().iterator();

      while(var9.hasNext()) {
         class_ars var10 = (class_ars)var9.next();

         for(int var11 = var10.d(); var11 < var10.d() + var10.b(); ++var11) {
            IBlockData var12 = var10.c();
            if(var12.getBlock() != Blocks.AIR) {
               var8 = false;
               this.c[var11] = var12;
            }
         }

         if(var10.c().getBlock() == Blocks.AIR) {
            var14 += var10.b();
         } else {
            var13 += var10.b() + var14;
            var14 = 0;
         }
      }

      var1.b(var13);
      this.f = var8?false:this.d.b().containsKey("decoration");
   }

   public class_aok d(int var1, int var2) {
      class_aph var3 = new class_aph();

      int var7;
      for(int var4 = 0; var4 < this.c.length; ++var4) {
         IBlockData var5 = this.c[var4];
         if(var5 != null) {
            for(int var6 = 0; var6 < 16; ++var6) {
               for(var7 = 0; var7 < 16; ++var7) {
                  var3.a(var6, var4, var7, var5);
               }
            }
         }
      }

      Iterator var8 = this.e.iterator();

      while(var8.hasNext()) {
         class_apn var10 = (class_apn)var8.next();
         var10.a(this, this.a, var1, var2, var3);
      }

      class_aok var9 = new class_aok(this.a, var3, var1, var2);
      class_aez[] var11 = this.a.w().b((class_aez[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var12 = var9.k();

      for(var7 = 0; var7 < var12.length; ++var7) {
         var12[var7] = (byte)var11[var7].az;
      }

      var9.b();
      return var9;
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public void a(class_aoh var1, int var2, int var3) {
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      class_cj var6 = new class_cj(var4, 0, var5);
      class_aez var7 = this.a.b(new class_cj(var4 + 16, 0, var5 + 16));
      boolean var8 = false;
      this.b.setSeed(this.a.K());
      long var9 = this.b.nextLong() / 2L * 2L + 1L;
      long var11 = this.b.nextLong() / 2L * 2L + 1L;
      this.b.setSeed((long)var2 * var9 + (long)var3 * var11 ^ this.a.K());
      class_aeh var13 = new class_aeh(var2, var3);
      Iterator var14 = this.e.iterator();

      while(var14.hasNext()) {
         class_ask var15 = (class_ask)var14.next();
         boolean var16 = var15.a(this.a, this.b, var13);
         if(var15 instanceof class_asq) {
            var8 |= var16;
         }
      }

      if(this.h != null && !var8 && this.b.nextInt(4) == 0) {
         this.h.b(this.a, this.b, var6.a(this.b.nextInt(16) + 8, this.b.nextInt(256), this.b.nextInt(16) + 8));
      }

      if(this.i != null && !var8 && this.b.nextInt(8) == 0) {
         class_cj var17 = var6.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(248) + 8), this.b.nextInt(16) + 8);
         if(var17.o() < this.a.G() || this.b.nextInt(10) == 0) {
            this.i.b(this.a, this.b, var17);
         }
      }

      if(this.g) {
         for(int var18 = 0; var18 < 8; ++var18) {
            (new class_ara()).b(this.a, this.b, var6.a(this.b.nextInt(16) + 8, this.b.nextInt(256), this.b.nextInt(16) + 8));
         }
      }

      if(this.f) {
         var7.a(this.a, this.b, var6);
      }

   }

   public boolean a(class_aoh var1, class_aok var2, int var3, int var4) {
      return false;
   }

   public boolean a(boolean var1, class_nw var2) {
      return true;
   }

   public void c() {
   }

   public boolean d() {
      return false;
   }

   public boolean e() {
      return true;
   }

   public String f() {
      return "FlatLevelSource";
   }

   public List a(class_qc var1, class_cj var2) {
      class_aez var3 = this.a.b(var2);
      return var3.a(var1);
   }

   public class_cj a(World var1, String var2, class_cj var3) {
      if("Stronghold".equals(var2)) {
         Iterator var4 = this.e.iterator();

         while(var4.hasNext()) {
            class_ask var5 = (class_ask)var4.next();
            if(var5 instanceof class_asi) {
               return var5.b(var1, var3);
            }
         }
      }

      return null;
   }

   public int g() {
      return 0;
   }

   public void a(class_aok var1, int var2, int var3) {
      Iterator var4 = this.e.iterator();

      while(var4.hasNext()) {
         class_ask var5 = (class_ask)var4.next();
         var5.a(this, this.a, var2, var3, (class_aph)null);
      }

   }

   public class_aok a(class_cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }
}
