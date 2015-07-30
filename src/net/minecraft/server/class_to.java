package net.minecraft.server;

import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_to {
   private final BlockPosition a;
   private final BlockPosition b;
   private final EnumDirection c;
   private int d;
   private boolean e;
   private int f;

   public class_to(BlockPosition var1, int var2, int var3, int var4) {
      this(var1, a(var2, var3), var4);
   }

   private static EnumDirection a(int var0, int var1) {
      return var0 < 0?EnumDirection.WEST:(var0 > 0?EnumDirection.EAST:(var1 < 0?EnumDirection.NORTH:EnumDirection.SOUTH));
   }

   public class_to(BlockPosition var1, EnumDirection var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.b = var1.shift(var2, 2);
      this.d = var3;
   }

   public int b(int var1, int var2, int var3) {
      return (int)this.a.distanceSquared((double)var1, (double)var2, (double)var3);
   }

   public int a(BlockPosition var1) {
      return (int)var1.distanceSquared(this.d());
   }

   public int b(BlockPosition var1) {
      return (int)this.b.distanceSquared(var1);
   }

   public boolean c(BlockPosition var1) {
      int var2 = var1.getX() - this.a.getX();
      int var3 = var1.getZ() - this.a.getY();
      return var2 * this.c.getAdjacentX() + var3 * this.c.getAdjacentZ() >= 0;
   }

   public void a() {
      this.f = 0;
   }

   public void b() {
      ++this.f;
   }

   public int c() {
      return this.f;
   }

   public BlockPosition d() {
      return this.a;
   }

   public BlockPosition e() {
      return this.b;
   }

   public int f() {
      return this.c.getAdjacentX() * 2;
   }

   public int g() {
      return this.c.getAdjacentZ() * 2;
   }

   public int h() {
      return this.d;
   }

   public void a(int var1) {
      this.d = var1;
   }

   public boolean i() {
      return this.e;
   }

   public void a(boolean var1) {
      this.e = var1;
   }
}
