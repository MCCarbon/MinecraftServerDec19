package net.minecraft.server;

import net.minecraft.server.UseResult;

public class UseResultWithValue {

	private final UseResult useresult;
	private final Object b;

	public UseResultWithValue(UseResult var1, Object var2) {
		this.useresult = var1;
		this.b = var2;
	}

	public UseResult getResult() {
		return this.useresult;
	}

	public Object getValue() {
		return this.b;
	}

}
