package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Deflater;
import net.minecraft.server.PacketDataSerializer;

public class class_ej extends MessageToByteEncoder {
   private final byte[] a = new byte[8192];
   private final Deflater b;
   private int c;

   public class_ej(int var1) {
      this.c = var1;
      this.b = new Deflater();
   }

   protected void a(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) throws Exception {
      int var4 = var2.readableBytes();
      PacketDataSerializer var5 = new PacketDataSerializer(var3);
      if(var4 < this.c) {
         var5.writeVarInt(0);
         var5.writeBytes(var2);
      } else {
         byte[] var6 = new byte[var4];
         var2.readBytes(var6);
         var5.writeVarInt(var6.length);
         this.b.setInput(var6, 0, var4);
         this.b.finish();

         while(!this.b.finished()) {
            int var7 = this.b.deflate(this.a);
            var5.writeBytes((byte[])this.a, 0, var7);
         }

         this.b.reset();
      }

   }

   public void a(int var1) {
      this.c = var1;
   }

   // $FF: synthetic method
   protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws Exception {
      this.a(var1, (ByteBuf)var2, var3);
   }
}
