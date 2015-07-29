package net.minecraft.server;

import net.minecraft.server.class_adj;

public abstract class class_zu {
   public static final class_zu[] a = new class_zu[12];
   public static final class_zu b = new class_zu(0, "buildingBlocks") {
   };
   public static final class_zu c = new class_zu(1, "decorations") {
   };
   public static final class_zu d = new class_zu(2, "redstone") {
   };
   public static final class_zu e = new class_zu(3, "transportation") {
   };
   public static final class_zu f;
   public static final class_zu g;
   public static final class_zu h;
   public static final class_zu i;
   public static final class_zu j;
   public static final class_zu k;
   public static final class_zu l;
   public static final class_zu m;
   private final int n;
   private final String o;
   private String p = "items.png";
   private boolean q = true;
   private boolean r = true;
   private class_adj[] s;

   public class_zu(int var1, String var2) {
      this.n = var1;
      this.o = var2;
      a[var1] = this;
   }

   public class_zu a(String var1) {
      this.p = var1;
      return this;
   }

   public class_zu i() {
      this.r = false;
      return this;
   }

   public class_zu k() {
      this.q = false;
      return this;
   }

   public class_zu a(class_adj... var1) {
      this.s = var1;
      return this;
   }

   static {
      f = (new class_zu(4, "misc") {
      }).a(new class_adj[]{class_adj.a});
      g = (new class_zu(5, "search") {
      }).a("item_search.png");
      h = new class_zu(6, "food") {
      };
      i = (new class_zu(7, "tools") {
      }).a(new class_adj[]{class_adj.h, class_adj.i, class_adj.j});
      j = (new class_zu(8, "combat") {
      }).a(new class_adj[]{class_adj.b, class_adj.c, class_adj.f, class_adj.d, class_adj.e, class_adj.k, class_adj.g});
      k = new class_zu(9, "brewing") {
      };
      l = new class_zu(10, "materials") {
      };
      m = (new class_zu(11, "inventory") {
      }).a("inventory.png").k().i();
   }
}
