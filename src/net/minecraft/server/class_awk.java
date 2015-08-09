package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.Scoreboard;
import net.minecraft.server.class_awp;

public class class_awk extends class_awp {
   private final Scoreboard a;
   private final String b;
   private final Set c = Sets.newHashSet();
   private String d;
   private String e = "";
   private String f = "";
   private boolean g = true;
   private boolean h = true;
   private class_awp.class_a_in_class_awp i;
   private class_awp.class_a_in_class_awp j;
   private EnumChatFormat k;

   public class_awk(Scoreboard var1, String var2) {
      this.i = class_awp.class_a_in_class_awp.a;
      this.j = class_awp.class_a_in_class_awp.a;
      this.k = EnumChatFormat.RESET;
      this.a = var1;
      this.b = var2;
      this.d = var2;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.d;
   }

   public void a(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Name cannot be null");
      } else {
         this.d = var1;
         this.a.b(this);
      }
   }

   public Collection d() {
      return this.c;
   }

   public String e() {
      return this.e;
   }

   public void b(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Prefix cannot be null");
      } else {
         this.e = var1;
         this.a.b(this);
      }
   }

   public String f() {
      return this.f;
   }

   public void c(String var1) {
      this.f = var1;
      this.a.b(this);
   }

   public String d(String var1) {
      return this.e() + var1 + this.f();
   }

   public static String a(class_awp var0, String var1) {
      return var0 == null?var1:var0.d(var1);
   }

   public boolean g() {
      return this.g;
   }

   public void a(boolean var1) {
      this.g = var1;
      this.a.b(this);
   }

   public boolean h() {
      return this.h;
   }

   public void b(boolean var1) {
      this.h = var1;
      this.a.b(this);
   }

   public class_awp.class_a_in_class_awp i() {
      return this.i;
   }

   public class_awp.class_a_in_class_awp j() {
      return this.j;
   }

   public void a(class_awp.class_a_in_class_awp var1) {
      this.i = var1;
      this.a.b(this);
   }

   public void b(class_awp.class_a_in_class_awp var1) {
      this.j = var1;
      this.a.b(this);
   }

   public int k() {
      int var1 = 0;
      if(this.g()) {
         var1 |= 1;
      }

      if(this.h()) {
         var1 |= 2;
      }

      return var1;
   }

   public void a(EnumChatFormat var1) {
      this.k = var1;
   }

   public EnumChatFormat l() {
      return this.k;
   }
}
