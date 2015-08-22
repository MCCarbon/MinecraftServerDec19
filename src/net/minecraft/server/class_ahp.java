package net.minecraft.server;

import java.util.Random;

import com.google.common.collect.Lists;

public class class_ahp extends class_ahb {
	protected class_ahb aE;

	public class_ahp(int var1, class_ahb var2) {
		super(var1);
		aE = var2;
		this.a(var2.ai, true);
		ah = var2.ah + " M";
		ak = var2.ak;
		al = var2.al;
		am = var2.am;
		an = var2.an;
		ao = var2.ao;
		ap = var2.ap;
		aq = var2.aq;
		ar = var2.ar;
		ax = var2.ax;
		ay = var2.ay;
		au = Lists.newArrayList((Iterable) var2.au);
		at = Lists.newArrayList((Iterable) var2.at);
		aw = Lists.newArrayList((Iterable) var2.aw);
		av = Lists.newArrayList((Iterable) var2.av);
		ap = var2.ap;
		aq = var2.aq;
		an = var2.an + 0.1F;
		ao = var2.ao + 0.2F;
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		aE.as.a(var1, var2, this, var3);
	}

	@Override
	public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		aE.a(var1, var2, var3, var4, var5, var6);
	}

	@Override
	public float g() {
		return aE.g();
	}

	@Override
	public class_asa a(Random var1) {
		return aE.a(var1);
	}

	@Override
	public Class l() {
		return aE.l();
	}

	@Override
	public boolean a(class_ahb var1) {
		return aE.a(var1);
	}

	@Override
	public class_ahb.class_b_in_class_ahb m() {
		return aE.m();
	}
}
