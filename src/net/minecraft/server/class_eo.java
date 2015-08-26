package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class class_eo extends MessageToByteEncoder {
	private static final Logger a = LogManager.getLogger();
	private static final Marker b;
	private final class_fg c;

	public class_eo(class_fg var1) {
		c = var1;
	}

	protected void a(ChannelHandlerContext var1, Packet var2, ByteBuf var3) throws Exception {
		Integer var4 = ((class_el) var1.channel().attr(class_ek.c).get()).a(c, var2);
		if (a.isDebugEnabled()) {
			a.debug(b, "OUT: [{}:{}] {}", new Object[] { var1.channel().attr(class_ek.c).get(), var4, var2.getClass().getName() });
		}

		if (var4 == null) {
			throw new IOException("Can\'t serialize unregistered packet");
		} else {
			PacketDataSerializer var5 = new PacketDataSerializer(var3);
			var5.b(var4.intValue());

			try {
				if (var2 instanceof class_fp) {
					var2 = var2;
				}

				var2.encode(var5);
			} catch (Throwable var7) {
				a.error(var7);
			}

		}
	}

	// $FF: synthetic method
	@Override
	protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws Exception {
		a(var1, (Packet) var2, var3);
	}

	static {
		b = MarkerManager.getMarker("PACKET_SENT", class_ek.b);
	}
}
