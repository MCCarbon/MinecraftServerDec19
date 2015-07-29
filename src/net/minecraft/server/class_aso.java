package net.minecraft.server;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;

public abstract class class_aso {
   protected LinkedList a = new LinkedList();
   protected class_arw b;
   private int c;
   private int d;

   public class_aso() {
   }

   public class_aso(int var1, int var2) {
      this.c = var1;
      this.d = var2;
   }

   public class_arw b() {
      return this.b;
   }

   public LinkedList c() {
      return this.a;
   }

   public void a(World var1, Random var2, class_arw var3) {
      Iterator var4 = this.a.iterator();

      while(var4.hasNext()) {
         class_asn var5 = (class_asn)var4.next();
         if(var5.c().a(var3) && !var5.a(var1, var2, var3)) {
            var4.remove();
         }
      }

   }

   protected void d() {
      this.b = class_arw.a();
      Iterator var1 = this.a.iterator();

      while(var1.hasNext()) {
         class_asn var2 = (class_asn)var1.next();
         this.b.b(var2.c());
      }

   }

   public class_dn a(int var1, int var2) {
      class_dn var3 = new class_dn();
      var3.a("id", class_asl.a(this));
      var3.a("ChunkX", var1);
      var3.a("ChunkZ", var2);
      var3.a((String)"BB", (class_eb)this.b.g());
      class_du var4 = new class_du();
      Iterator var5 = this.a.iterator();

      while(var5.hasNext()) {
         class_asn var6 = (class_asn)var5.next();
         var4.a((class_eb)var6.b());
      }

      var3.a((String)"Children", (class_eb)var4);
      this.a(var3);
      return var3;
   }

   public void a(class_dn var1) {
   }

   public void a(World var1, class_dn var2) {
      this.c = var2.g("ChunkX");
      this.d = var2.g("ChunkZ");
      if(var2.d("BB")) {
         this.b = new class_arw(var2.m("BB"));
      }

      class_du var3 = var2.c("Children", 10);

      for(int var4 = 0; var4 < var3.c(); ++var4) {
         this.a.add(class_asl.b(var3.b(var4), var1));
      }

      this.b(var2);
   }

   public void b(class_dn var1) {
   }

   protected void a(World var1, Random var2, int var3) {
      int var4 = var1.G() - var3;
      int var5 = this.b.d() + 1;
      if(var5 < var4) {
         var5 += var2.nextInt(var4 - var5);
      }

      int var6 = var5 - this.b.e;
      this.b.a(0, var6, 0);
      Iterator var7 = this.a.iterator();

      while(var7.hasNext()) {
         class_asn var8 = (class_asn)var7.next();
         var8.a(0, var6, 0);
      }

   }

   protected void a(World var1, Random var2, int var3, int var4) {
      int var5 = var4 - var3 + 1 - this.b.d();
      boolean var6 = true;
      int var10;
      if(var5 > 1) {
         var10 = var3 + var2.nextInt(var5);
      } else {
         var10 = var3;
      }

      int var7 = var10 - this.b.b;
      this.b.a(0, var7, 0);
      Iterator var8 = this.a.iterator();

      while(var8.hasNext()) {
         class_asn var9 = (class_asn)var8.next();
         var9.a(0, var7, 0);
      }

   }

   public boolean a() {
      return true;
   }

   public boolean a(class_aeh var1) {
      return true;
   }

   public void b(class_aeh var1) {
   }

   public int e() {
      return this.c;
   }

   public int f() {
      return this.d;
   }
}
