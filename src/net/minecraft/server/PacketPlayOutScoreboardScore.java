package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutScoreboardScore implements Packet {
   private String a = "";
   private String b = "";
   private int c;
   private PacketPlayOutScoreboardScore.class_a_in_class_hs d;

   public PacketPlayOutScoreboardScore() {
   }

   public PacketPlayOutScoreboardScore(class_awl var1) {
      this.a = var1.e();
      this.b = var1.d().b();
      this.c = var1.c();
      this.d = PacketPlayOutScoreboardScore.class_a_in_class_hs.a;
   }

   public PacketPlayOutScoreboardScore(String var1) {
      this.a = var1;
      this.b = "";
      this.c = 0;
      this.d = PacketPlayOutScoreboardScore.class_a_in_class_hs.b;
   }

   public PacketPlayOutScoreboardScore(String var1, class_awj var2) {
      this.a = var1;
      this.b = var2.b();
      this.c = 0;
      this.d = PacketPlayOutScoreboardScore.class_a_in_class_hs.b;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(40);
      this.d = (PacketPlayOutScoreboardScore.class_a_in_class_hs)var1.readEnum(PacketPlayOutScoreboardScore.class_a_in_class_hs.class);
      this.b = var1.readString(16);
      if(this.d != PacketPlayOutScoreboardScore.class_a_in_class_hs.b) {
         this.c = var1.readVarInt();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeEnum((Enum)this.d);
      var1.writeString(this.b);
      if(this.d != PacketPlayOutScoreboardScore.class_a_in_class_hs.b) {
         var1.writeVarInt(this.c);
      }

   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }

   public static enum class_a_in_class_hs {
      a,
      b;
   }
}
