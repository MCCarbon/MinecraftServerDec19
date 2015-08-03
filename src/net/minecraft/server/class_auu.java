package net.minecraft.server;

import net.minecraft.server.IBlockAccess;
import net.minecraft.server.class_aut;
import net.minecraft.server.IntHashMap;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Entity;

public abstract class class_auu {
   protected IBlockAccess a;
   protected IntHashMap b = new IntHashMap();
   protected int c;
   protected int d;
   protected int e;

   public void a(IBlockAccess var1, Entity var2) {
      this.a = var1;
      this.b.c();
      this.c = MathHelper.floor(var2.J + 1.0F);
      this.d = MathHelper.floor(var2.K + 1.0F);
      this.e = MathHelper.floor(var2.J + 1.0F);
   }

   public void a() {
   }

   protected class_aut a(int var1, int var2, int var3) {
      int var4 = class_aut.a(var1, var2, var3);
      class_aut var5 = (class_aut)this.b.a(var4);
      if(var5 == null) {
         var5 = new class_aut(var1, var2, var3);
         this.b.a(var4, var5);
      }

      return var5;
   }

   public abstract class_aut a(Entity var1);

   public abstract class_aut a(Entity var1, double var2, double var4, double var6);

   public abstract int a(class_aut[] var1, Entity var2, class_aut var3, class_aut var4, float var5);
}
