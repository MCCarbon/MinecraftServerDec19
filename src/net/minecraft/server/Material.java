package net.minecraft.server;

import net.minecraft.server.class_ath;
import net.minecraft.server.class_ati;
import net.minecraft.server.class_atj;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_atm;

public class Material {

	public static final Material a;
	public static final Material b;
	public static final Material c;
	public static final Material d;
	public static final Material e;
	public static final Material f;
	public static final Material g;
	public static final Material h;
	public static final Material i;
	public static final Material j;
	public static final Material k;
	public static final Material l;
	public static final Material m;
	public static final Material n;
	public static final Material o;
	public static final Material p;
	public static final Material q;
	public static final Material r;
	public static final Material s;
	public static final Material t;
	public static final Material u;
	public static final Material v;
	public static final Material w;
	public static final Material x;
	public static final Material y;
	public static final Material z;
	public static final Material A;
	public static final Material B;
	public static final Material C;
	public static final Material D;
	public static final Material E;
	public static final Material F;
	public static final Material G;
	public static final Material H;
	public static final Material I;
	private boolean J;
	private boolean K;
	private boolean L;
	private final MaterialMapColor mapcolor;
	private boolean N = true;
	private int O;
	private boolean P;

	public Material(MaterialMapColor var1) {
		this.mapcolor = var1;
	}

	public boolean d() {
		return false;
	}

	public boolean a() {
		return true;
	}

	public boolean blocksLight() {
		return true;
	}

	public boolean isSolid() {
		return true;
	}

	private Material s() {
		this.L = true;
		return this;
	}

	protected Material f() {
		this.N = false;
		return this;
	}

	protected Material g() {
		this.J = true;
		return this;
	}

	public boolean h() {
		return this.J;
	}

	public Material i() {
		this.K = true;
		return this;
	}

	public boolean j() {
		return this.K;
	}

	public boolean k() {
		return this.L ? false : this.isSolid();
	}

	public boolean l() {
		return this.N;
	}

	public int m() {
		return this.O;
	}

	protected Material n() {
		this.O = 1;
		return this;
	}

	protected Material o() {
		this.O = 2;
		return this;
	}

	protected Material p() {
		this.P = true;
		return this;
	}

	public MaterialMapColor getMapColor() {
		return this.mapcolor;
	}

	static {
		a = new class_ati(MaterialMapColor.b);
		b = new Material(MaterialMapColor.c);
		c = new Material(MaterialMapColor.l);
		d = (new Material(MaterialMapColor.o)).g();
		e = (new Material(MaterialMapColor.m)).f();
		f = (new Material(MaterialMapColor.h)).f();
		g = (new Material(MaterialMapColor.h)).f().o();
		h = (new class_atj(MaterialMapColor.n)).n();
		i = (new class_atj(MaterialMapColor.f)).n();
		j = (new Material(MaterialMapColor.i)).g().s().n();
		k = (new class_ath(MaterialMapColor.i)).n();
		l = (new class_ath(MaterialMapColor.i)).g().n().i();
		m = new Material(MaterialMapColor.t);
		n = (new Material(MaterialMapColor.e)).g();
		o = (new class_ati(MaterialMapColor.b)).n();
		p = new Material(MaterialMapColor.d);
		q = (new class_ath(MaterialMapColor.b)).n();
		r = (new class_ath(MaterialMapColor.e)).g();
		s = (new Material(MaterialMapColor.b)).s().p();
		t = (new Material(MaterialMapColor.b)).p();
		u = (new Material(MaterialMapColor.f)).g().s();
		v = (new Material(MaterialMapColor.i)).n();
		w = (new Material(MaterialMapColor.g)).s().p();
		x = (new Material(MaterialMapColor.g)).p();
		y = (new class_ath(MaterialMapColor.j)).i().s().f().n();
		z = (new Material(MaterialMapColor.j)).f();
		A = (new Material(MaterialMapColor.i)).s().n();
		B = new Material(MaterialMapColor.k);
		C = (new Material(MaterialMapColor.i)).n();
		D = (new Material(MaterialMapColor.i)).n();
		E = (new class_atm(MaterialMapColor.b)).o();
		F = (new Material(MaterialMapColor.b)).n();
		G = (new Material(MaterialMapColor.e) {
			public boolean isSolid() {
				return false;
			}
		}).f().n();
		H = (new Material(MaterialMapColor.m)).o();
		I = (new Material(MaterialMapColor.b)).f().o();
	}

}
