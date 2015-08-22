package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_aet {
	private static final class_aet a = new class_aet();
	private final List b = Lists.newArrayList();

	public static class_aet a() {
		return a;
	}

	private class_aet() {
		(new class_aez()).a(this);
		(new class_afa()).a(this);
		(new class_aer()).a(this);
		(new class_aem()).a(this);
		(new class_aey()).a(this);
		(new class_aeh()).a(this);
		(new class_aek()).a(this);
		b.add(new class_aeg());
		b.add(new class_aej());
		b.add(new class_aeo());
		b.add(new class_aep());
		b.add(new class_aeq());
		b.add(new class_ael());
		b.add(new class_aeu());
		(new class_aei()).a(this);
		(new class_aex()).a(this);
		this.a(new class_aco(class_acq.aM, 3), new Object[] { "###", Character.valueOf('#'), class_acq.aL });
		this.b(new class_aco(class_acq.aN, 1), new Object[] { class_acq.aM, class_acq.aM, class_acq.aM, class_acq.aH });
		this.b(new class_aco(class_acq.bR, 1), new Object[] { class_acq.aN, new class_aco(class_acq.aY, 1, class_abt.p.b()), class_acq.I });
		this.a(new class_aco(class_aim.aO, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(class_aim.aQ, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(class_aim.aP, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(class_aim.aR, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(class_aim.aT, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(class_aim.aS, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(class_aim.bZ, 6, class_anx.class_a_in_class_anx.a.a()), new Object[] { "###", "###", Character.valueOf('#'), class_aim.e });
		this.a(new class_aco(class_aim.bZ, 6, class_anx.class_a_in_class_anx.b.a()), new Object[] { "###", "###", Character.valueOf('#'), class_aim.Y });
		this.a(new class_aco(class_aim.bz, 6), new Object[] { "###", "###", Character.valueOf('#'), class_aim.by });
		this.a(new class_aco(class_aim.bo, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(class_aim.bq, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(class_aim.bp, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(class_aim.br, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(class_aim.bt, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(class_aim.bs, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), class_acq.A, Character.valueOf('W'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(class_aim.aN, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_aim.f, Character.valueOf('X'), class_acq.k });
		this.a(new class_aco(class_acq.cs, 2), new Object[] { "~~ ", "~O ", "  ~", Character.valueOf('~'), class_acq.H, Character.valueOf('O'), class_acq.aO });
		this.a(new class_aco(class_aim.B, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_aim.f, Character.valueOf('X'), class_acq.aE });
		this.a(new class_aco(class_aim.X, 1), new Object[] { "###", "XXX", "###", Character.valueOf('#'), class_aim.f, Character.valueOf('X'), class_acq.aN });
		this.a(new class_aco(class_aim.aJ, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.aF });
		this.a(new class_aco(class_aim.aH, 6), new Object[] { "###", Character.valueOf('#'), class_aim.aJ });
		this.a(new class_aco(class_aim.aL, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.aK });
		this.a(new class_aco(class_aim.V, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.aJ });
		this.a(new class_aco(class_aim.aX, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.aV });
		this.a(new class_aco(class_aim.cq, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.cl });
		this.a(new class_aco(class_aim.L, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.H });
		this.a(new class_aco(class_aim.W, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), class_acq.J, Character.valueOf('#'), class_aim.m });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.d.a()), new Object[] { "###", Character.valueOf('#'), class_aim.e });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.a.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.b, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.b.a()), new Object[] { "###", Character.valueOf('#'), class_aim.A });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.e.a()), new Object[] { "###", Character.valueOf('#'), class_aim.V });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.f.a()), new Object[] { "###", Character.valueOf('#'), class_aim.bf });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.g.a()), new Object[] { "###", Character.valueOf('#'), class_aim.by });
		this.a(new class_aco(class_aim.U, 6, class_anm.class_a_in_class_anm.h.a()), new Object[] { "###", Character.valueOf('#'), class_aim.cq });
		this.a(new class_aco(class_aim.cP, 6, class_alr.class_a_in_class_alr.a.a()), new Object[] { "###", Character.valueOf('#'), class_aim.cM });
		this.a(new class_aco(class_aim.cX, 6, 0), new Object[] { "###", Character.valueOf('#'), class_aim.cT });
		this.a(new class_aco(class_aim.bM, 6, 0), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(class_aim.bM, 6, class_aly.class_a_in_class_aly.c.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(class_aim.bM, 6, class_aly.class_a_in_class_aly.b.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(class_aim.bM, 6, class_aly.class_a_in_class_aly.d.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(class_aim.bM, 6, (4 + class_aly.class_a_in_class_aly.e.a()) - 4), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(class_aim.bM, 6, (4 + class_aly.class_a_in_class_aly.f.a()) - 4), new Object[] { "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(class_aim.au, 3), new Object[] { "# #", "###", "# #", Character.valueOf('#'), class_acq.A });
		this.a(new class_aco(class_acq.as, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(class_acq.at, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(class_acq.au, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(class_acq.av, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(class_acq.aw, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.e.a()) });
		this.a(new class_aco(class_acq.ax, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.f.a()) });
		this.a(new class_aco(class_aim.bd, 2), new Object[] { "###", "###", Character.valueOf('#'), class_aim.f });
		this.a(new class_aco(class_acq.aD, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), class_acq.l });
		this.a(new class_aco(class_aim.cw, 1), new Object[] { "##", "##", Character.valueOf('#'), class_acq.l });
		this.a(new class_aco(class_acq.ar, 3), new Object[] { "###", "###", " X ", Character.valueOf('#'), class_aim.f, Character.valueOf('X'), class_acq.A });
		this.a(new class_aco(class_acq.bb, 1), new Object[] { "AAA", "BEB", "CCC", Character.valueOf('A'), class_acq.aI, Character.valueOf('B'), class_acq.ba, Character.valueOf('C'), class_acq.Q, Character.valueOf('E'), class_acq.aR });
		this.a(new class_aco(class_acq.ba, 1), new Object[] { "#", Character.valueOf('#'), class_acq.aL });
		this.a(new class_aco(class_aim.f, 4, class_aly.class_a_in_class_aly.a.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.r, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(class_aim.f, 4, class_aly.class_a_in_class_aly.b.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.r, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(class_aim.f, 4, class_aly.class_a_in_class_aly.c.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.r, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(class_aim.f, 4, class_aly.class_a_in_class_aly.d.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.r, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(class_aim.f, 4, (4 + class_aly.class_a_in_class_aly.e.a()) - 4), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.s, 1, class_aly.class_a_in_class_aly.e.a() - 4) });
		this.a(new class_aco(class_aim.f, 4, (4 + class_aly.class_a_in_class_aly.f.a()) - 4), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.s, 1, class_aly.class_a_in_class_aly.f.a() - 4) });
		this.a(new class_aco(class_acq.A, 4), new Object[] { "#", "#", Character.valueOf('#'), class_aim.f });
		this.a(new class_aco(class_aim.aa, 4), new Object[] { "X", "#", Character.valueOf('X'), class_acq.j, Character.valueOf('#'), class_acq.A });
		this.a(new class_aco(class_aim.aa, 4), new Object[] { "X", "#", Character.valueOf('X'), new class_aco(class_acq.j, 1, 1), Character.valueOf('#'), class_acq.A });
		this.a(new class_aco(class_acq.B, 4), new Object[] { "# #", " # ", Character.valueOf('#'), class_aim.f });
		this.a(new class_aco(class_acq.bE, 3), new Object[] { "# #", " # ", Character.valueOf('#'), class_aim.w });
		this.a(new class_aco(class_aim.av, 16), new Object[] { "X X", "X#X", "X X", Character.valueOf('X'), class_acq.l, Character.valueOf('#'), class_acq.A });
		this.a(new class_aco(class_aim.D, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), class_acq.m, Character.valueOf('R'), class_acq.aE, Character.valueOf('#'), class_acq.A });
		this.a(new class_aco(class_aim.cs, 6), new Object[] { "XSX", "X#X", "XSX", Character.valueOf('X'), class_acq.l, Character.valueOf('#'), class_aim.aF, Character.valueOf('S'), class_acq.A });
		this.a(new class_aco(class_aim.E, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), class_acq.l, Character.valueOf('R'), class_acq.aE, Character.valueOf('#'), class_aim.az });
		this.a(new class_aco(class_acq.aB, 1), new Object[] { "# #", "###", Character.valueOf('#'), class_acq.l });
		this.a(new class_aco(class_acq.bL, 1), new Object[] { "# #", "# #", "###", Character.valueOf('#'), class_acq.l });
		this.a(new class_aco(class_acq.bK, 1), new Object[] { " B ", "###", Character.valueOf('#'), class_aim.e, Character.valueOf('B'), class_acq.bx });
		this.a(new class_aco(class_aim.aZ, 1), new Object[] { "A", "B", Character.valueOf('A'), class_aim.aU, Character.valueOf('B'), class_aim.aa });
		this.a(new class_aco(class_acq.aP, 1), new Object[] { "A", "B", Character.valueOf('A'), class_aim.ae, Character.valueOf('B'), class_acq.aB });
		this.a(new class_aco(class_acq.aQ, 1), new Object[] { "A", "B", Character.valueOf('A'), class_aim.al, Character.valueOf('B'), class_acq.aB });
		this.a(new class_aco(class_acq.cm, 1), new Object[] { "A", "B", Character.valueOf('A'), class_aim.W, Character.valueOf('B'), class_acq.aB });
		this.a(new class_aco(class_acq.cn, 1), new Object[] { "A", "B", Character.valueOf('A'), class_aim.cp, Character.valueOf('B'), class_acq.aB });
		this.a(new class_aco(class_acq.aG, 1), new Object[] { "# #", "###", Character.valueOf('#'), class_aim.f });
		this.a(new class_aco(class_acq.ay, 1), new Object[] { "# #", " # ", Character.valueOf('#'), class_acq.l });
		this.a(new class_aco(class_acq.bV, 1), new Object[] { "# #", " # ", Character.valueOf('#'), class_acq.aJ });
		this.b(new class_aco(class_acq.d, 1), new Object[] { new class_aco(class_acq.l, 1), new class_aco(class_acq.am, 1) });
		this.a(new class_aco(class_acq.R, 1), new Object[] { "###", Character.valueOf('#'), class_acq.Q });
		this.a(new class_aco(class_aim.ad, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(class_aim.bV, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(class_aim.bU, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(class_aim.bW, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(class_aim.cC, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(class_aim.cD, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(class_aim.f, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(class_acq.aT, 1), new Object[] { "  #", " #X", "# X", Character.valueOf('#'), class_acq.A, Character.valueOf('X'), class_acq.H });
		this.a(new class_aco(class_acq.cd, 1), new Object[] { "# ", " X", Character.valueOf('#'), class_acq.aT, Character.valueOf('X'), class_acq.bW });
		this.a(new class_aco(class_aim.aw, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.e });
		this.a(new class_aco(class_aim.bu, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.V });
		this.a(new class_aco(class_aim.bv, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.bf });
		this.a(new class_aco(class_aim.bA, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.by });
		this.a(new class_aco(class_aim.bO, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.A });
		this.a(new class_aco(class_aim.cN, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.cM });
		this.a(new class_aco(class_aim.cr, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), class_aim.cq });
		this.a(new class_aco(class_acq.ap, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_acq.A, Character.valueOf('X'), class_aim.L });
		this.a(new class_aco(class_acq.bU, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_acq.A, Character.valueOf('X'), class_acq.aH });
		this.a(new class_aco(class_acq.aq), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_acq.m, Character.valueOf('X'), class_acq.e });
		this.a(new class_aco(class_acq.aq, 1, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_aim.R, Character.valueOf('X'), class_acq.e });
		this.a(new class_aco(class_acq.cb), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_acq.bz, Character.valueOf('X'), class_acq.bW });
		this.a(new class_aco(class_acq.bN, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_acq.bz, Character.valueOf('X'), class_acq.bh });
		this.a(new class_aco(class_aim.ay, 1), new Object[] { "X", "#", Character.valueOf('#'), class_aim.e, Character.valueOf('X'), class_acq.A });
		this.a(new class_aco(class_aim.bR, 2), new Object[] { "I", "S", "#", Character.valueOf('#'), class_aim.f, Character.valueOf('S'), class_acq.A, Character.valueOf('I'), class_acq.l });
		this.a(new class_aco(class_aim.aF, 1), new Object[] { "X", "#", Character.valueOf('#'), class_acq.A, Character.valueOf('X'), class_acq.aE });
		this.a(new class_aco(class_acq.bd, 1), new Object[] { "#X#", "III", Character.valueOf('#'), class_aim.aF, Character.valueOf('X'), class_acq.aE, Character.valueOf('I'), new class_aco(class_aim.b, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(class_acq.cj, 1), new Object[] { " # ", "#X#", "III", Character.valueOf('#'), class_aim.aF, Character.valueOf('X'), class_acq.cl, Character.valueOf('I'), new class_aco(class_aim.b, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(class_acq.aU, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), class_acq.m, Character.valueOf('X'), class_acq.aE });
		this.a(new class_aco(class_acq.aS, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), class_acq.l, Character.valueOf('X'), class_acq.aE });
		this.a(new class_aco(class_acq.ca, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), class_acq.aM, Character.valueOf('X'), class_acq.aS });
		this.a(new class_aco(class_aim.aG, 1), new Object[] { "#", Character.valueOf('#'), new class_aco(class_aim.b, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(class_aim.cd, 1), new Object[] { "#", Character.valueOf('#'), class_aim.f });
		this.a(new class_aco(class_aim.az, 1), new Object[] { "##", Character.valueOf('#'), new class_aco(class_aim.b, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(class_aim.aB, 1), new Object[] { "##", Character.valueOf('#'), class_aim.f });
		this.a(new class_aco(class_aim.ci, 1), new Object[] { "##", Character.valueOf('#'), class_acq.l });
		this.a(new class_aco(class_aim.ch, 1), new Object[] { "##", Character.valueOf('#'), class_acq.m });
		this.a(new class_aco(class_aim.z, 1), new Object[] { "###", "#X#", "#R#", Character.valueOf('#'), class_aim.e, Character.valueOf('X'), class_acq.f, Character.valueOf('R'), class_acq.aE });
		this.a(new class_aco(class_aim.ct, 1), new Object[] { "###", "# #", "#R#", Character.valueOf('#'), class_aim.e, Character.valueOf('R'), class_acq.aE });
		this.a(new class_aco(class_aim.J, 1), new Object[] { "TTT", "#X#", "#R#", Character.valueOf('#'), class_aim.e, Character.valueOf('X'), class_acq.l, Character.valueOf('R'), class_acq.aE, Character.valueOf('T'), class_aim.f });
		this.a(new class_aco(class_aim.F, 1), new Object[] { "S", "P", Character.valueOf('S'), class_acq.aO, Character.valueOf('P'), class_aim.J });
		this.a(new class_aco(class_acq.bc, 1), new Object[] { "###", "XXX", Character.valueOf('#'), class_aim.L, Character.valueOf('X'), class_aim.f });
		this.a(new class_aco(class_aim.bC, 1), new Object[] { " B ", "D#D", "###", Character.valueOf('#'), class_aim.Z, Character.valueOf('B'), class_acq.aN, Character.valueOf('D'), class_acq.k });
		this.a(new class_aco(class_aim.cf, 1), new Object[] { "III", " i ", "iii", Character.valueOf('I'), class_aim.S, Character.valueOf('i'), class_acq.l });
		this.a(new class_aco(class_acq.aH), new Object[] { "##", "##", Character.valueOf('#'), class_acq.bu });
		this.b(new class_aco(class_acq.bM, 1), new Object[] { class_acq.bw, class_acq.bI });
		this.b(new class_aco(class_acq.bQ, 3), new Object[] { class_acq.J, class_acq.bI, class_acq.j });
		this.b(new class_aco(class_acq.bQ, 3), new Object[] { class_acq.J, class_acq.bI, new class_aco(class_acq.j, 1, 1) });
		this.a(new class_aco(class_aim.cl), new Object[] { "GGG", "QQQ", "WWW", Character.valueOf('G'), class_aim.w, Character.valueOf('Q'), class_acq.cl, Character.valueOf('W'), class_aim.bM });
		this.a(new class_aco(class_aim.cp), new Object[] { "I I", "ICI", " I ", Character.valueOf('I'), class_acq.l, Character.valueOf('C'), class_aim.ae });
		this.a(new class_aco(class_acq.co, 1), new Object[] { "///", " / ", "/_/", Character.valueOf('/'), class_acq.A, Character.valueOf('_'), new class_aco(class_aim.U, 1, class_anm.class_a_in_class_anm.a.a()) });
		Collections.sort(b, new Comparator() {
			public int a(class_aes var1, class_aes var2) {
				return (var1 instanceof class_aew) && (var2 instanceof class_aev) ? 1 : ((var2 instanceof class_aew) && (var1 instanceof class_aev) ? -1 : (var2.a() < var1.a() ? -1 : (var2.a() > var1.a() ? 1 : 0)));
			}

			// $FF: synthetic method
			@Override
			public int compare(Object var1, Object var2) {
				return this.a((class_aes) var1, (class_aes) var2);
			}
		});
	}

	public class_aev a(class_aco var1, Object... var2) {
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		if (var2[var4] instanceof String[]) {
			String[] var11 = ((String[]) var2[var4++]);

			for (int var8 = 0; var8 < var11.length; ++var8) {
				String var9 = var11[var8];
				++var6;
				var5 = var9.length();
				var3 = var3 + var9;
			}
		} else {
			while (var2[var4] instanceof String) {
				String var7 = (String) var2[var4++];
				++var6;
				var5 = var7.length();
				var3 = var3 + var7;
			}
		}

		HashMap var12;
		for (var12 = Maps.newHashMap(); var4 < var2.length; var4 += 2) {
			Character var13 = (Character) var2[var4];
			class_aco var15 = null;
			if (var2[var4 + 1] instanceof class_acm) {
				var15 = new class_aco((class_acm) var2[var4 + 1]);
			} else if (var2[var4 + 1] instanceof class_ail) {
				var15 = new class_aco((class_ail) var2[var4 + 1], 1, 32767);
			} else if (var2[var4 + 1] instanceof class_aco) {
				var15 = (class_aco) var2[var4 + 1];
			}

			var12.put(var13, var15);
		}

		class_aco[] var14 = new class_aco[var5 * var6];

		for (int var16 = 0; var16 < (var5 * var6); ++var16) {
			char var10 = var3.charAt(var16);
			if (var12.containsKey(Character.valueOf(var10))) {
				var14[var16] = ((class_aco) var12.get(Character.valueOf(var10))).k();
			} else {
				var14[var16] = null;
			}
		}

		class_aev var17 = new class_aev(var5, var6, var14, var1);
		b.add(var17);
		return var17;
	}

	public void b(class_aco var1, Object... var2) {
		ArrayList var3 = Lists.newArrayList();
		Object[] var4 = var2;
		int var5 = var2.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			Object var7 = var4[var6];
			if (var7 instanceof class_aco) {
				var3.add(((class_aco) var7).k());
			} else if (var7 instanceof class_acm) {
				var3.add(new class_aco((class_acm) var7));
			} else {
				if (!(var7 instanceof class_ail)) {
					throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + var7.getClass().getName() + "!");
				}

				var3.add(new class_aco((class_ail) var7));
			}
		}

		b.add(new class_aew(var1, var3));
	}

	public void a(class_aes var1) {
		b.add(var1);
	}

	public class_aco a(class_aab var1, class_ago var2) {
		Iterator var3 = b.iterator();

		class_aes var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (class_aes) var3.next();
		} while (!var4.a(var1, var2));

		return var4.a(var1);
	}

	public class_aco[] b(class_aab var1, class_ago var2) {
		Iterator var3 = b.iterator();

		while (var3.hasNext()) {
			class_aes var4 = (class_aes) var3.next();
			if (var4.a(var1, var2)) {
				return var4.b(var1);
			}
		}

		class_aco[] var5 = new class_aco[var1.n_()];

		for (int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = var1.a(var6);
		}

		return var5;
	}

	public List b() {
		return b;
	}
}
