package net.minecraft.server;


public class EntityGiant extends EntityMonster {
	public EntityGiant(class_ago var1) {
		super(var1);
		this.a(J * 6.0F, K * 6.0F);
	}

	@Override
	public float aY() {
		return 10.440001F;
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(100.0D);
		this.a(class_yf.d).a(0.5D);
		this.a(class_yf.e).a(50.0D);
	}

	@Override
	public float a(class_cj var1) {
		return o.o(var1) - 0.5F;
	}
}
