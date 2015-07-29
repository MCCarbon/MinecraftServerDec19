package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aex;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_aoi;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_aol;
import net.minecraft.server.class_aop;
import net.minecraft.server.class_aou;
import net.minecraft.server.class_awb;
import net.minecraft.server.class_awc;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_dx;
import net.minecraft.server.class_eb;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_aov implements class_aop, class_awc {
   private static final Logger a = LogManager.getLogger();
   private Map b = new ConcurrentHashMap();
   private Set c = Collections.newSetFromMap(new ConcurrentHashMap());
   private final File d;
   private boolean e = false;

   public class_aov(File var1) {
      this.d = var1;
   }

   public class_aok a(class_aen var1, int var2, int var3) throws IOException {
      class_aeh var4 = new class_aeh(var2, var3);
      class_dn var5 = (class_dn)this.b.get(var4);
      if(var5 == null) {
         DataInputStream var6 = class_aou.c(this.d, var2, var3);
         if(var6 == null) {
            return null;
         }

         var5 = class_dx.a(var6);
      }

      return this.a(var1, var2, var3, var5);
   }

   protected class_aok a(class_aen var1, int var2, int var3, class_dn var4) {
      if(!var4.b("Level", 10)) {
         a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
         return null;
      } else {
         class_dn var5 = var4.n("Level");
         if(!var5.b("Sections", 9)) {
            a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
            return null;
         } else {
            class_aok var6 = this.a(var1, var5);
            if(!var6.a(var2, var3)) {
               a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.a + ", " + var6.b + ")");
               var5.a("xPos", var2);
               var5.a("zPos", var3);
               var6 = this.a(var1, var5);
            }

            return var6;
         }
      }
   }

   public void a(class_aen var1, class_aok var2) throws IOException, class_aeo {
      var1.J();

      try {
         class_dn var3 = new class_dn();
         class_dn var4 = new class_dn();
         var3.a((String)"Level", (class_eb)var4);
         this.a(var2, var1, var4);
         this.a(var2.j(), var3);
      } catch (Exception var5) {
         a.error((String)"Failed to save chunk", (Throwable)var5);
      }

   }

   protected void a(class_aeh var1, class_dn var2) {
      if(!this.c.contains(var1)) {
         this.b.put(var1, var2);
      }

      class_awb.a().a(this);
   }

   public boolean c() {
      if(this.b.isEmpty()) {
         if(this.e) {
            a.info("ThreadedAnvilChunkStorage ({}): All chunks are saved", new Object[]{this.d.getName()});
         }

         return false;
      } else {
         class_aeh var1 = (class_aeh)this.b.keySet().iterator().next();

         boolean var3;
         try {
            this.c.add(var1);
            class_dn var2 = (class_dn)this.b.remove(var1);
            if(var2 != null) {
               try {
                  this.b(var1, var2);
               } catch (Exception var7) {
                  a.error((String)"Failed to save chunk", (Throwable)var7);
               }
            }

            var3 = true;
         } finally {
            this.c.remove(var1);
         }

         return var3;
      }
   }

   private void b(class_aeh var1, class_dn var2) throws IOException {
      DataOutputStream var3 = class_aou.d(this.d, var1.a, var1.b);
      class_dx.a((class_dn)var2, (DataOutput)var3);
      var3.close();
   }

   public void b(class_aen var1, class_aok var2) throws IOException {
   }

   public void a() {
   }

   public void b() {
      try {
         this.e = true;

         while(true) {
            if(this.c()) {
               continue;
            }
         }
      } finally {
         this.e = false;
      }

   }

   private void a(class_aok var1, class_aen var2, class_dn var3) {
      var3.a("V", (byte)1);
      var3.a("xPos", var1.a);
      var3.a("zPos", var1.b);
      var3.a("LastUpdate", var2.L());
      var3.a("HeightMap", var1.q());
      var3.a("TerrainPopulated", var1.t());
      var3.a("LightPopulated", var1.u());
      var3.a("InhabitedTime", var1.w());
      class_aol[] var4 = var1.h();
      class_du var5 = new class_du();
      boolean var6 = !var2.t.m();
      class_aol[] var7 = var4;
      int var8 = var4.length;

      class_dn var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         class_aol var10 = var7[var9];
         if(var10 != null) {
            var11 = new class_dn();
            var11.a("Y", (byte)(var10.d() >> 4 & 255));
            byte[] var12 = new byte[var10.g().length];
            class_aoi var13 = new class_aoi();
            class_aoi var14 = null;

            for(int var15 = 0; var15 < var10.g().length; ++var15) {
               char var16 = var10.g()[var15];
               int var17 = var15 & 15;
               int var18 = var15 >> 8 & 15;
               int var19 = var15 >> 4 & 15;
               if(var16 >> 12 != 0) {
                  if(var14 == null) {
                     var14 = new class_aoi();
                  }

                  var14.a(var17, var18, var19, var16 >> 12);
               }

               var12[var15] = (byte)(var16 >> 4 & 255);
               var13.a(var17, var18, var19, var16 & 15);
            }

            var11.a("Blocks", var12);
            var11.a("Data", var13.a());
            if(var14 != null) {
               var11.a("Add", var14.a());
            }

            var11.a("BlockLight", var10.h().a());
            if(var6) {
               var11.a("SkyLight", var10.i().a());
            } else {
               var11.a("SkyLight", new byte[var10.h().a().length]);
            }

            var5.a((class_eb)var11);
         }
      }

      var3.a((String)"Sections", (class_eb)var5);
      var3.a("Biomes", var1.k());
      var1.g(false);
      class_du var20 = new class_du();

      Iterator var22;
      for(var8 = 0; var8 < var1.s().length; ++var8) {
         var22 = var1.s()[var8].iterator();

         while(var22.hasNext()) {
            class_pr var24 = (class_pr)var22.next();
            var11 = new class_dn();
            if(var24.d(var11)) {
               var1.g(true);
               var20.a((class_eb)var11);
            }
         }
      }

      var3.a((String)"Entities", (class_eb)var20);
      class_du var21 = new class_du();
      var22 = var1.r().values().iterator();

      while(var22.hasNext()) {
         class_amg var25 = (class_amg)var22.next();
         var11 = new class_dn();
         var25.b(var11);
         var21.a((class_eb)var11);
      }

      var3.a((String)"TileEntities", (class_eb)var21);
      List var23 = var2.a(var1, false);
      if(var23 != null) {
         long var26 = var2.L();
         class_du var27 = new class_du();
         Iterator var28 = var23.iterator();

         while(var28.hasNext()) {
            class_aex var29 = (class_aex)var28.next();
            class_dn var30 = new class_dn();
            MinecraftKey var31 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(var29.a());
            var30.a("i", var31 == null?"":var31.toString());
            var30.a("x", var29.a.n());
            var30.a("y", var29.a.o());
            var30.a("z", var29.a.p());
            var30.a("t", (int)(var29.b - var26));
            var30.a("p", var29.c);
            var27.a((class_eb)var30);
         }

         var3.a((String)"TileTicks", (class_eb)var27);
      }

   }

   private class_aok a(class_aen var1, class_dn var2) {
      int var3 = var2.g("xPos");
      int var4 = var2.g("zPos");
      class_aok var5 = new class_aok(var1, var3, var4);
      var5.a(var2.m("HeightMap"));
      var5.d(var2.o("TerrainPopulated"));
      var5.e(var2.o("LightPopulated"));
      var5.c(var2.h("InhabitedTime"));
      class_du var6 = var2.c("Sections", 10);
      byte var7 = 16;
      class_aol[] var8 = new class_aol[var7];
      boolean var9 = !var1.t.m();

      for(int var10 = 0; var10 < var6.c(); ++var10) {
         class_dn var11 = var6.b(var10);
         byte var12 = var11.e("Y");
         class_aol var13 = new class_aol(var12 << 4, var9);
         byte[] var14 = var11.l("Blocks");
         class_aoi var15 = new class_aoi(var11.l("Data"));
         class_aoi var16 = var11.b("Add", 7)?new class_aoi(var11.l("Add")):null;
         char[] var17 = new char[var14.length];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            int var19 = var18 & 15;
            int var20 = var18 >> 8 & 15;
            int var21 = var18 >> 4 & 15;
            int var22 = var16 != null?var16.a(var19, var20, var21):0;
            var17[var18] = (char)(var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
         }

         var13.a(var17);
         var13.a(new class_aoi(var11.l("BlockLight")));
         if(var9) {
            var13.b(new class_aoi(var11.l("SkyLight")));
         }

         var13.e();
         var8[var12] = var13;
      }

      var5.a(var8);
      if(var2.b("Biomes", 7)) {
         var5.a(var2.l("Biomes"));
      }

      class_du var23 = var2.c("Entities", 10);
      if(var23 != null) {
         for(int var24 = 0; var24 < var23.c(); ++var24) {
            class_dn var26 = var23.b(var24);
            class_pr var28 = class_pt.a(var26, var1);
            var5.g(true);
            if(var28 != null) {
               var5.a(var28);
               class_pr var32 = var28;

               for(class_dn var34 = var26; var34.b("Riding", 10); var34 = var34.n("Riding")) {
                  class_pr var37 = class_pt.a(var34.n("Riding"), var1);
                  if(var37 != null) {
                     var5.a(var37);
                     var32.a(var37);
                  }

                  var32 = var37;
               }
            }
         }
      }

      class_du var25 = var2.c("TileEntities", 10);
      if(var25 != null) {
         for(int var27 = 0; var27 < var25.c(); ++var27) {
            class_dn var30 = var25.b(var27);
            class_amg var33 = class_amg.c(var30);
            if(var33 != null) {
               var5.a(var33);
            }
         }
      }

      if(var2.b("TileTicks", 9)) {
         class_du var29 = var2.c("TileTicks", 10);
         if(var29 != null) {
            for(int var31 = 0; var31 < var29.c(); ++var31) {
               class_dn var35 = var29.b(var31);
               Block var36;
               if(var35.b("i", 8)) {
                  var36 = Block.getByName(var35.k("i"));
               } else {
                  var36 = Block.getById(var35.g("i"));
               }

               var1.b(new class_cj(var35.g("x"), var35.g("y"), var35.g("z")), var36, var35.g("t"), var35.g("p"));
            }
         }
      }

      return var5;
   }
}
