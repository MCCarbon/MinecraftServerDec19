package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Entity;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;
import net.minecraft.server.EntityHuman;

public class class_sr extends class_rm {
   private class_qh a;
   private double b;
   private double c;
   private double d;
   private double e;
   private double f;
   private double g;
   private EntityHuman h;
   private int i;
   private boolean j;
   private Set k;
   private boolean l;
   private boolean m;

   public class_sr(class_qh var1, double var2, Item var4, boolean var5) {
      this(var1, var2, var5, Sets.newHashSet((Object[])(new Item[]{var4})));
   }

   public class_sr(class_qh var1, double var2, boolean var4, Set var5) {
      this.a = var1;
      this.b = var2;
      this.k = var5;
      this.l = var4;
      this.a(3);
      if(!(var1.u() instanceof class_tf)) {
         throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
      }
   }

   public boolean a() {
      if(this.i > 0) {
         --this.i;
         return false;
      } else {
         this.h = this.a.o.a(this.a, 10.0D);
         return this.h == null?false:this.a(this.h.bA()) || this.a(this.h.bB());
      }
   }

   protected boolean a(ItemStack var1) {
      return var1 == null?false:this.k.contains(var1.getItem());
   }

   public boolean b() {
      if(this.l) {
         if(this.a.h(this.h) < 36.0D) {
            if(this.h.e(this.c, this.d, this.e) > 0.010000000000000002D) {
               return false;
            }

            if(Math.abs((double)this.h.z - this.f) > 5.0D || Math.abs((double)this.h.y - this.g) > 5.0D) {
               return false;
            }
         } else {
            this.c = this.h.s;
            this.d = this.h.t;
            this.e = this.h.u;
         }

         this.f = (double)this.h.z;
         this.g = (double)this.h.y;
      }

      return this.a();
   }

   public void c() {
      this.c = this.h.s;
      this.d = this.h.t;
      this.e = this.h.u;
      this.j = true;
      this.m = ((class_tf)this.a.u()).e();
      ((class_tf)this.a.u()).a(false);
   }

   public void d() {
      this.h = null;
      this.a.u().n();
      this.i = 100;
      this.j = false;
      ((class_tf)this.a.u()).a(this.m);
   }

   public void e() {
      this.a.q().a(this.h, (float)(this.a.ce() + 20), (float)this.a.cd());
      if(this.a.h(this.h) < 6.25D) {
         this.a.u().n();
      } else {
         this.a.u().a((Entity)this.h, this.b);
      }

   }

   public boolean f() {
      return this.j;
   }
}
