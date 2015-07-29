package net.minecraft.server;

import net.minecraft.server.class_adj;

public abstract class CreativeTab {
   public static final CreativeTab[] a = new CreativeTab[12];
   public static final CreativeTab b = new CreativeTab(0, "buildingBlocks") {
   };
   public static final CreativeTab c = new CreativeTab(1, "decorations") {
   };
   public static final CreativeTab d = new CreativeTab(2, "redstone") {
   };
   public static final CreativeTab e = new CreativeTab(3, "transportation") {
   };
   public static final CreativeTab f;
   public static final CreativeTab g;
   public static final CreativeTab h;
   public static final CreativeTab i;
   public static final CreativeTab j;
   public static final CreativeTab k;
   public static final CreativeTab l;
   public static final CreativeTab m;
   private final int n;
   private final String o;
   private String p = "items.png";
   private boolean q = true;
   private boolean r = true;
   private class_adj[] s;

   public CreativeTab(int var1, String var2) {
      this.n = var1;
      this.o = var2;
      a[var1] = this;
   }

   public CreativeTab a(String var1) {
      this.p = var1;
      return this;
   }

   public CreativeTab i() {
      this.r = false;
      return this;
   }

   public CreativeTab k() {
      this.q = false;
      return this;
   }

   public CreativeTab a(class_adj... var1) {
      this.s = var1;
      return this;
   }

   static {
      f = (new CreativeTab(4, "misc") {
      }).a(new class_adj[]{class_adj.a});
      g = (new CreativeTab(5, "search") {
      }).a("item_search.png");
      h = new CreativeTab(6, "food") {
      };
      i = (new CreativeTab(7, "tools") {
      }).a(new class_adj[]{class_adj.h, class_adj.i, class_adj.j});
      j = (new CreativeTab(8, "combat") {
      }).a(new class_adj[]{class_adj.b, class_adj.c, class_adj.f, class_adj.d, class_adj.e, class_adj.k, class_adj.g});
      k = new CreativeTab(9, "brewing") {
      };
      l = new CreativeTab(10, "materials") {
      };
      m = (new CreativeTab(11, "inventory") {
      }).a("inventory.png").k().i();
   }
}
