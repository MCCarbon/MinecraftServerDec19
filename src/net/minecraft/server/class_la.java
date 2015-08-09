package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.class_aoc;
import net.minecraft.server.class_aoe;
import net.minecraft.server.PersistentBase;
import net.minecraft.server.class_avk;
import net.minecraft.server.IDataManager;
import net.minecraft.server.WorldServer;
import net.minecraft.server.MethodProfiler;
import net.minecraft.server.PersistentVillage;

public class class_la extends WorldServer {
   private WorldServer a;

   public class_la(MinecraftServer var1, IDataManager var2, int var3, WorldServer var4, MethodProfiler var5) {
      super(var1, var2, new class_avk(var4.Q()), var3, var5);
      this.a = var4;
      var4.ag().a(new class_aoc() {
         public void a(class_aoe var1, double var2) {
            class_la.this.ag().a(var2);
         }

         public void a(class_aoe var1, double var2, double var4, long var6) {
            class_la.this.ag().a(var2, var4, var6);
         }

         public void a(class_aoe var1, double var2, double var4) {
            class_la.this.ag().c(var2, var4);
         }

         public void a(class_aoe var1, int var2) {
            class_la.this.ag().b(var2);
         }

         public void b(class_aoe var1, int var2) {
            class_la.this.ag().c(var2);
         }

         public void b(class_aoe var1, double var2) {
            class_la.this.ag().c(var2);
         }

         public void c(class_aoe var1, double var2) {
            class_la.this.ag().b(var2);
         }
      });
   }

   protected void a() {
   }

   public World b() {
      this.z = this.a.U();
      this.C = this.a.aa();
      String var1 = PersistentVillage.a(this.worldProvider);
      PersistentVillage var2 = (PersistentVillage)this.z.a(PersistentVillage.class, var1);
      if(var2 == null) {
         this.A = new PersistentVillage(this);
         this.z.a((String)var1, (PersistentBase)this.A);
      } else {
         this.A = var2;
         this.A.a((World)this);
      }

      return this;
   }

   public void c() {
      this.worldProvider.q();
   }
}
