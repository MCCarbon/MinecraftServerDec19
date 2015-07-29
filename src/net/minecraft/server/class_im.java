package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ic;

public class class_im implements class_ff {
   private String a;
   private class_em b;

   public void a(class_em var1) throws IOException {
      this.a = var1.c(20);
      int var2 = var1.readableBytes();
      if(var2 >= 0 && var2 <= 32767) {
         this.b = new class_em(var1.readBytes(var2));
      } else {
         throw new IOException("Payload may not be larger than 32767 bytes");
      }
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a);
      var1.writeBytes((ByteBuf)this.b);
   }

   public void a(class_ic var1) {
      var1.a(this);
   }

   public String a() {
      return this.a;
   }

   public class_em b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_ic)var1);
   }
}
