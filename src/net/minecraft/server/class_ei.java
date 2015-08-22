package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;

import java.util.List;
import java.util.zip.Inflater;

public class class_ei extends ByteToMessageDecoder {
	private final Inflater a;
	private int b;

	public class_ei(int var1) {
		b = var1;
		a = new Inflater();
	}

	@Override
	protected void decode(ChannelHandlerContext var1, ByteBuf var2, List var3) throws Exception {
		if (var2.readableBytes() != 0) {
			PacketDataSerializer var4 = new PacketDataSerializer(var2);
			int var5 = var4.g();
			if (var5 == 0) {
				var3.add(var4.readBytes(var4.readableBytes()));
			} else {
				if (var5 < b) {
					throw new DecoderException("Badly compressed packet - size of " + var5 + " is below server threshold of " + b);
				}

				if (var5 > 2097152) {
					throw new DecoderException("Badly compressed packet - size of " + var5 + " is larger than protocol maximum of " + 2097152);
				}

				byte[] var6 = new byte[var4.readableBytes()];
				var4.readBytes(var6);
				a.setInput(var6);
				byte[] var7 = new byte[var5];
				a.inflate(var7);
				var3.add(Unpooled.wrappedBuffer(var7));
				a.reset();
			}

		}
	}

	public void a(int var1) {
		b = var1;
	}
}
