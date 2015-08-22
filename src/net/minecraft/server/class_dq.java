package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_dq extends class_eb {
	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(64L);
	}

	@Override
	void a(DataOutput var1) throws IOException {
	}

	@Override
	public byte a() {
		return (byte) 0;
	}

	@Override
	public String toString() {
		return "END";
	}

	@Override
	public class_eb b() {
		return new class_dq();
	}
}
