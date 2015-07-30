package net.minecraft.server;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_eb;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ft;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_nz;

public class class_amy extends class_amg implements class_kn {
   private int a;
   private int f;
   private GameProfile g = null;
   private int h;
   private boolean i;

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("SkullType", (byte)(this.a & 255));
      var1.a("Rot", (byte)(this.f & 255));
      if(this.g != null) {
         class_dn var2 = new class_dn();
         class_dy.a(var2, this.g);
         var1.a((String)"Owner", (class_eb)var2);
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = var1.e("SkullType");
      this.f = var1.e("Rot");
      if(this.a == 3) {
         if(var1.b("Owner", 10)) {
            this.g = class_dy.a(var1.n("Owner"));
         } else if(var1.b("ExtraType", 8)) {
            String var2 = var1.k("ExtraType");
            if(!class_nz.b(var2)) {
               this.g = new GameProfile((UUID)null, var2);
               this.g();
            }
         }
      }

   }

   public void c() {
      if(this.a == 5) {
         if(this.b.z(this.c)) {
            this.i = true;
            ++this.h;
         } else {
            this.i = false;
         }
      }

   }

   public GameProfile b() {
      return this.g;
   }

   public Packet z_() {
      class_dn var1 = new class_dn();
      this.b(var1);
      return new class_ft(this.c, 4, var1);
   }

   public void a(int var1) {
      this.a = var1;
      this.g = null;
   }

   public void a(GameProfile var1) {
      this.a = 3;
      this.g = var1;
      this.g();
   }

   private void g() {
      this.g = b(this.g);
      this.p_();
   }

   public static GameProfile b(GameProfile var0) {
      if(var0 != null && !class_nz.b(var0.getName())) {
         if(var0.isComplete() && var0.getProperties().containsKey("textures")) {
            return var0;
         } else if(MinecraftServer.N() == null) {
            return var0;
         } else {
            GameProfile var1 = MinecraftServer.N().aF().a(var0.getName());
            if(var1 == null) {
               return var0;
            } else {
               Property var2 = (Property)Iterables.getFirst(var1.getProperties().get("textures"), (Object)null);
               if(var2 == null) {
                  var1 = MinecraftServer.N().aD().fillProfileProperties(var1, true);
               }

               return var1;
            }
         }
      } else {
         return var0;
      }
   }

   public int d() {
      return this.a;
   }

   public void b(int var1) {
      this.f = var1;
   }
}
