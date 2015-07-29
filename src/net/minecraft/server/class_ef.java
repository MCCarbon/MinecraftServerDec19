package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

public class class_ef {
   private final Cipher a;
   private byte[] b = new byte[0];
   private byte[] c = new byte[0];

   protected class_ef(Cipher var1) {
      this.a = var1;
   }

   private byte[] a(ByteBuf var1) {
      int var2 = var1.readableBytes();
      if(this.b.length < var2) {
         this.b = new byte[var2];
      }

      var1.readBytes((byte[])this.b, 0, var2);
      return this.b;
   }

   protected ByteBuf a(ChannelHandlerContext var1, ByteBuf var2) throws ShortBufferException {
      int var3 = var2.readableBytes();
      byte[] var4 = this.a(var2);
      ByteBuf var5 = var1.alloc().heapBuffer(this.a.getOutputSize(var3));
      var5.writerIndex(this.a.update(var4, 0, var3, var5.array(), var5.arrayOffset()));
      return var5;
   }

   protected void a(ByteBuf var1, ByteBuf var2) throws ShortBufferException {
      int var3 = var1.readableBytes();
      byte[] var4 = this.a(var1);
      int var5 = this.a.getOutputSize(var3);
      if(this.c.length < var5) {
         this.c = new byte[var5];
      }

      var2.writeBytes((byte[])this.c, 0, this.a.update(var4, 0, var3, this.c));
   }
}
