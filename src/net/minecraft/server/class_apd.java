package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afg;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_aoz;
import net.minecraft.server.class_apc;
import net.minecraft.server.class_apq;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTag;
import net.minecraft.server.WorldServer;

public class class_apd extends class_aoy {
   private class_apc g = null;

   public void b() {
      this.c = new class_afg(BiomeBase.y, 0.0F);
      this.e = true;
      NBTTagCompound var1 = this.b.Q().a(class_aoz.c);
      this.g = this.b instanceof WorldServer?new class_apc((WorldServer)this.b, var1.getCompound("DragonFight")):null;
   }

   public class_aoh c() {
      return new class_apq(this.b, this.b.K());
   }

   public float a(long var1, float var3) {
      return 0.0F;
   }

   public boolean e() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean a(int var1, int var2) {
      return this.b.c(new BlockPosition(var1, 0, var2)).getMaterial().isSolid();
   }

   public BlockPosition h() {
      return new BlockPosition(100, 50, 0);
   }

   public int i() {
      return 50;
   }

   public class_aoz p() {
      return class_aoz.c;
   }

   public void q() {
      NBTTagCompound var1 = new NBTTagCompound();
      if(this.g != null) {
         var1.put((String)"DragonFight", (NBTTag)this.g.a());
      }

      this.b.Q().a(class_aoz.c, var1);
   }

   public void r() {
      if(this.g != null) {
         this.g.b();
      }

   }

   public class_apc s() {
      return this.g;
   }
}
