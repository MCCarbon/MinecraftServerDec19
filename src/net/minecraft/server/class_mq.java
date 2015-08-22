package net.minecraft.server;


public class class_mq implements ICommandListener {
	private static final class_mq a = new class_mq();
	private StringBuffer b = new StringBuffer();

	public static class_mq h() {
		return a;
	}

	public void i() {
		b.setLength(0);
	}

	public String j() {
		return b.toString();
	}

	@Override
	public String e_() {
		return "Rcon";
	}

	@Override
	public class_eu f_() {
		return new class_fa(e_());
	}

	@Override
	public void a(class_eu var1) {
		b.append(var1.c());
	}

	@Override
	public boolean a(int var1, String var2) {
		return true;
	}

	@Override
	public class_cj c() {
		return new class_cj(0, 0, 0);
	}

	@Override
	public class_aym d() {
		return new class_aym(0.0D, 0.0D, 0.0D);
	}

	@Override
	public class_ago e() {
		return MinecraftServer.P().e();
	}

	@Override
	public Entity f() {
		return null;
	}

	@Override
	public boolean s_() {
		return true;
	}

	@Override
	public void a(class_n.class_a_in_class_n var1, int var2) {
	}
}
