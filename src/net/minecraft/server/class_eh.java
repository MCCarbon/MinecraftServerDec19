package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import javax.crypto.Cipher;

public class class_eh extends MessageToByteEncoder {
	private final class_ef a;

	public class_eh(Cipher var1) {
		a = new class_ef(var1);
	}

	protected void a(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) throws Exception {
		a.a(var2, var3);
	}

	// $FF: synthetic method
	@Override
	protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws Exception {
		a(var1, (ByteBuf) var2, var3);
	}
}
