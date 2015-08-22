package net.minecraft.server;


public class class_jz {
	private final int a;
	private final class_ka b;

	public class_jz(int var1, class_ka var2) {
		a = var1;
		b = var2;
	}

	public int a() {
		return a;
	}

	public class_ka b() {
		return b;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 != null) && (this.getClass() == var1.getClass())) {
			class_jz var2 = (class_jz) var1;
			return a == var2.a;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return a;
	}
}
