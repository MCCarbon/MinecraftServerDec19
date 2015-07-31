package net.minecraft.server;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aeq;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_lh;

public class class_gz implements Packet {
   private class_gz.class_a_in_class_gz a;
   private final List b = Lists.newArrayList();

   public class_gz() {
   }

   public class_gz(class_gz.class_a_in_class_gz var1, class_lh... var2) {
      this.a = var1;
      class_lh[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_lh var6 = var3[var5];
         this.b.add(new class_gz.class_b_in_class_gz(var6.cf(), var6.h, var6.c.b(), var6.E()));
      }

   }

   public class_gz(class_gz.class_a_in_class_gz var1, Iterable var2) {
      this.a = var1;
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         class_lh var4 = (class_lh)var3.next();
         this.b.add(new class_gz.class_b_in_class_gz(var4.cf(), var4.h, var4.c.b(), var4.E()));
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = (class_gz.class_a_in_class_gz)var1.readEnum(class_gz.class_a_in_class_gz.class);
      int var2 = var1.readVarInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         GameProfile var4 = null;
         int var5 = 0;
         class_aeq.class_a_in_class_aeq var6 = null;
         IChatBaseComponent var7 = null;
         switch(class_gz.SyntheticClass_1.a[this.a.ordinal()]) {
         case 1:
            var4 = new GameProfile(var1.readUUID(), var1.readString(16));
            int var8 = var1.readVarInt();
            int var9 = 0;

            for(; var9 < var8; ++var9) {
               String var10 = var1.readString(32767);
               String var11 = var1.readString(32767);
               if(var1.readBoolean()) {
                  var4.getProperties().put(var10, new Property(var10, var11, var1.readString(32767)));
               } else {
                  var4.getProperties().put(var10, new Property(var10, var11));
               }
            }

            var6 = class_aeq.class_a_in_class_aeq.a(var1.readVarInt());
            var5 = var1.readVarInt();
            if(var1.readBoolean()) {
               var7 = var1.readChat();
            }
            break;
         case 2:
            var4 = new GameProfile(var1.readUUID(), (String)null);
            var6 = class_aeq.class_a_in_class_aeq.a(var1.readVarInt());
            break;
         case 3:
            var4 = new GameProfile(var1.readUUID(), (String)null);
            var5 = var1.readVarInt();
            break;
         case 4:
            var4 = new GameProfile(var1.readUUID(), (String)null);
            if(var1.readBoolean()) {
               var7 = var1.readChat();
            }
            break;
         case 5:
            var4 = new GameProfile(var1.readUUID(), (String)null);
         }

         this.b.add(new class_gz.class_b_in_class_gz(var4, var5, var6, var7));
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeEnum((Enum)this.a);
      var1.writeVarInt(this.b.size());
      Iterator var2 = this.b.iterator();

      while(true) {
         while(var2.hasNext()) {
            class_gz.class_b_in_class_gz var3 = (class_gz.class_b_in_class_gz)var2.next();
            switch(class_gz.SyntheticClass_1.a[this.a.ordinal()]) {
            case 1:
               var1.writeUUID(var3.a().getId());
               var1.writeString(var3.a().getName());
               var1.writeVarInt(var3.a().getProperties().size());
               Iterator var4 = var3.a().getProperties().values().iterator();

               while(var4.hasNext()) {
                  Property var5 = (Property)var4.next();
                  var1.writeString(var5.getName());
                  var1.writeString(var5.getValue());
                  if(var5.hasSignature()) {
                     var1.writeBoolean(true);
                     var1.writeString(var5.getSignature());
                  } else {
                     var1.writeBoolean(false);
                  }
               }

               var1.writeVarInt(var3.c().a());
               var1.writeVarInt(var3.b());
               if(var3.d() == null) {
                  var1.writeBoolean(false);
               } else {
                  var1.writeBoolean(true);
                  var1.writeChat(var3.d());
               }
               break;
            case 2:
               var1.writeUUID(var3.a().getId());
               var1.writeVarInt(var3.c().a());
               break;
            case 3:
               var1.writeUUID(var3.a().getId());
               var1.writeVarInt(var3.b());
               break;
            case 4:
               var1.writeUUID(var3.a().getId());
               if(var3.d() == null) {
                  var1.writeBoolean(false);
               } else {
                  var1.writeBoolean(true);
                  var1.writeChat(var3.d());
               }
               break;
            case 5:
               var1.writeUUID(var3.a().getId());
            }
         }

         return;
      }
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("action", this.a).add("entries", this.b).toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_gz.class_a_in_class_gz.values().length];

      static {
         try {
            a[class_gz.class_a_in_class_gz.a.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_gz.class_a_in_class_gz.b.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_gz.class_a_in_class_gz.c.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_gz.class_a_in_class_gz.d.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_gz.class_a_in_class_gz.e.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public class class_b_in_class_gz {
      private final int b;
      private final class_aeq.class_a_in_class_aeq c;
      private final GameProfile d;
      private final IChatBaseComponent e;

      public class_b_in_class_gz(GameProfile var2, int var3, class_aeq.class_a_in_class_aeq var4, IChatBaseComponent var5) {
         this.d = var2;
         this.b = var3;
         this.c = var4;
         this.e = var5;
      }

      public GameProfile a() {
         return this.d;
      }

      public int b() {
         return this.b;
      }

      public class_aeq.class_a_in_class_aeq c() {
         return this.c;
      }

      public IChatBaseComponent d() {
         return this.e;
      }

      public String toString() {
         return Objects.toStringHelper((Object)this).add("latency", this.b).add("gameMode", this.c).add("profile", this.d).add("displayName", this.e == null?null:IChatBaseComponent.ChatSerializer.toJson(this.e)).toString();
      }
   }

   public static enum class_a_in_class_gz {
      a,
      b,
      c,
      d,
      e;
   }
}
