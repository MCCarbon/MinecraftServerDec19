package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutOpenWindow implements Packet {
   private int a;
   private String b;
   private IChatBaseComponent c;
   private int d;
   private int e;

   public PacketPlayOutOpenWindow() {
   }

   public PacketPlayOutOpenWindow(int var1, String var2, IChatBaseComponent var3) {
      this(var1, var2, var3, 0);
   }

   public PacketPlayOutOpenWindow(int var1, String var2, IChatBaseComponent var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public PacketPlayOutOpenWindow(int var1, String var2, IChatBaseComponent var3, int var4, int var5) {
      this(var1, var2, var3, var4);
      this.e = var5;
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.readString(32);
      this.c = var1.readChat();
      this.d = var1.readUnsignedByte();
      if(this.b.equals("EntityHorse")) {
         this.e = var1.readInt();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeString(this.b);
      var1.writeChat(this.c);
      var1.writeByte(this.d);
      if(this.b.equals("EntityHorse")) {
         var1.writeInt(this.e);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
