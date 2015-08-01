package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_my;
import net.minecraft.server.StatisticList;

public class PacketPlayOutStatistic implements Packet {
   private Map a;

   public PacketPlayOutStatistic() {
   }

   public PacketPlayOutStatistic(Map var1) {
      this.a = var1;
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      int var2 = var1.readVarInt();
      this.a = Maps.newHashMap();

      for(int var3 = 0; var3 < var2; ++var3) {
         class_my var4 = StatisticList.a(var1.readString(32767));
         int var5 = var1.readVarInt();
         if(var4 != null) {
            this.a.put(var4, Integer.valueOf(var5));
         }
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a.size());
      Iterator var2 = this.a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeString(((class_my)var3.getKey()).e);
         var1.writeVarInt(((Integer)var3.getValue()).intValue());
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
