package net.minecraft.server;


public abstract class class_vq extends class_rh implements class_qw {
	public class_vq(class_ago var1) {
		super(var1);
	}

	@Override
	public boolean bf() {
		return true;
	}

	@Override
	public boolean cj() {
		return true;
	}

	@Override
	public boolean ck() {
		return o.a(aX(), this);
	}

	@Override
	public int y() {
		return 120;
	}

	@Override
	protected boolean E() {
		return true;
	}

	@Override
	protected int b(class_yu var1) {
		return 1 + o.s.nextInt(3);
	}

	@Override
	public void M() {
		int var1 = aF();
		super.M();
		if (al() && !Y()) {
			--var1;
			this.h(var1);
			if (aF() == -20) {
				this.h(0);
				this.a(class_qi.f, 2.0F);
			}
		} else {
			this.h(300);
		}

	}

	@Override
	public boolean aR() {
		return false;
	}
}
