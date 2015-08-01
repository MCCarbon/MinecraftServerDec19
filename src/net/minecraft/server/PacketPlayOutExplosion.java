package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutExplosion implements Packet {
   private double a;
   private double b;
   private double c;
   private float d;
   private List e;
   private float f;
   private float g;
   private float h;

   public PacketPlayOutExplosion() {
   }

   public PacketPlayOutExplosion(double var1, double var3, double var5, float var7, List var8, Vec3D var9) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
      this.e = Lists.newArrayList((Iterable)var8);
      if(var9 != null) {
         this.f = (float)var9.x;
         this.g = (float)var9.y;
         this.h = (float)var9.z;
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = (double)var1.readFloat();
      this.b = (double)var1.readFloat();
      this.c = (double)var1.readFloat();
      this.d = var1.readFloat();
      int var2 = var1.readInt();
      this.e = Lists.newArrayListWithCapacity(var2);
      int var3 = (int)this.a;
      int var4 = (int)this.b;
      int var5 = (int)this.c;

      for(int var6 = 0; var6 < var2; ++var6) {
         int var7 = var1.readByte() + var3;
         int var8 = var1.readByte() + var4;
         int var9 = var1.readByte() + var5;
         this.e.add(new BlockPosition(var7, var8, var9));
      }

      this.f = var1.readFloat();
      this.g = var1.readFloat();
      this.h = var1.readFloat();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeFloat((float)this.a);
      var1.writeFloat((float)this.b);
      var1.writeFloat((float)this.c);
      var1.writeFloat(this.d);
      var1.writeInt(this.e.size());
      int var2 = (int)this.a;
      int var3 = (int)this.b;
      int var4 = (int)this.c;
      Iterator var5 = this.e.iterator();

      while(var5.hasNext()) {
         BlockPosition var6 = (BlockPosition)var5.next();
         int var7 = var6.getX() - var2;
         int var8 = var6.getY() - var3;
         int var9 = var6.getZ() - var4;
         var1.writeByte(var7);
         var1.writeByte(var8);
         var1.writeByte(var9);
      }

      var1.writeFloat(this.f);
      var1.writeFloat(this.g);
      var1.writeFloat(this.h);
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
