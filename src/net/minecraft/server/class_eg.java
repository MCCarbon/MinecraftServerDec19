package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

import javax.crypto.Cipher;

public class class_eg extends MessageToMessageDecoder {
	private final class_ef a;

	public class_eg(Cipher var1) {
		a = new class_ef(var1);
	}

	protected void a(ChannelHandlerContext var1, ByteBuf var2, List var3) throws Exception {
		var3.add(a.a(var1, var2));
	}

	// $FF: synthetic method
	@Override
	protected void decode(ChannelHandlerContext var1, Object var2, List var3) throws Exception {
		a(var1, (ByteBuf) var2, var3);
	}
}
