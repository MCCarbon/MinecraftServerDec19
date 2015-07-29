package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.io.IOException;
import java.util.List;
import net.minecraft.server.class_ek;
import net.minecraft.server.class_el;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class class_en extends ByteToMessageDecoder {
   private static final Logger a = LogManager.getLogger();
   private static final Marker b;
   private final class_fg c;

   public class_en(class_fg var1) {
      this.c = var1;
   }

   protected void decode(ChannelHandlerContext var1, ByteBuf var2, List var3) throws Exception {
      if(var2.readableBytes() != 0) {
         class_em var4 = new class_em(var2);
         int var5 = var4.e();
         class_ff var6 = ((class_el)var1.channel().attr(class_ek.c).get()).a(this.c, var5);
         if(var6 == null) {
            throw new IOException("Bad packet id " + var5);
         } else {
            var6.a(var4);
            if(var4.readableBytes() > 0) {
               throw new IOException("Packet " + ((class_el)var1.channel().attr(class_ek.c).get()).a() + "/" + var5 + " (" + var6.getClass().getSimpleName() + ") was larger than I expected, found " + var4.readableBytes() + " bytes extra whilst reading packet " + var5);
            } else {
               var3.add(var6);
               if(a.isDebugEnabled()) {
                  a.debug(b, " IN: [{}:{}] {}", new Object[]{var1.channel().attr(class_ek.c).get(), Integer.valueOf(var5), var6.getClass().getName()});
               }

            }
         }
      }
   }

   static {
      b = MarkerManager.getMarker("PACKET_RECEIVED", class_ek.b);
   }
}
