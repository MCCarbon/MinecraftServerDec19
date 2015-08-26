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
		this.a(new class_aco(Items.aM, 3), new Object[] { "###", Character.valueOf('#'), Items.aL });
		this.b(new class_aco(Items.aN, 1), new Object[] { Items.aM, Items.aM, Items.aM, Items.aH });
		this.b(new class_aco(Items.bR, 1), new Object[] { Items.aN, new class_aco(Items.aY, 1, class_abt.p.b()), Items.I });
		this.a(new class_aco(Blocks.aO, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(Blocks.aQ, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(Blocks.aP, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(Blocks.aR, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(Blocks.aT, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(Blocks.aS, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(Blocks.bZ, 6, class_anx.class_a_in_class_anx.a.a()), new Object[] { "###", "###", Character.valueOf('#'), Blocks.COBBLESTONE });
		this.a(new class_aco(Blocks.bZ, 6, class_anx.class_a_in_class_anx.b.a()), new Object[] { "###", "###", Character.valueOf('#'), Blocks.Y });
		this.a(new class_aco(Blocks.bz, 6), new Object[] { "###", "###", Character.valueOf('#'), Blocks.by });
		this.a(new class_aco(Blocks.bo, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(Blocks.bq, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(Blocks.bp, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(Blocks.br, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(Blocks.bt, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(Blocks.bs, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(Blocks.aN, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.k });
		this.a(new class_aco(Items.cs, 2), new Object[] { "~~ ", "~O ", "  ~", Character.valueOf('~'), Items.H, Character.valueOf('O'), Items.aO });
		this.a(new class_aco(Blocks.NOTEBLOCK, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.aE });
		this.a(new class_aco(Blocks.X, 1), new Object[] { "###", "XXX", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.aN });
		this.a(new class_aco(Blocks.aJ, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.aF });
		this.a(new class_aco(Blocks.aH, 6), new Object[] { "###", Character.valueOf('#'), Blocks.aJ });
		this.a(new class_aco(Blocks.aL, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.aK });
		this.a(new class_aco(Blocks.V, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.aJ });
		this.a(new class_aco(Blocks.aX, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.aV });
		this.a(new class_aco(Blocks.cq, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.cl });
		this.a(new class_aco(Blocks.L, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.H });
		this.a(new class_aco(Blocks.W, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), Items.J, Character.valueOf('#'), Blocks.SAND });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.d.a()), new Object[] { "###", Character.valueOf('#'), Blocks.COBBLESTONE });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.a.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.STONE, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.b.a()), new Object[] { "###", Character.valueOf('#'), Blocks.SANDSTONE });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.e.a()), new Object[] { "###", Character.valueOf('#'), Blocks.V });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.f.a()), new Object[] { "###", Character.valueOf('#'), Blocks.bf });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.g.a()), new Object[] { "###", Character.valueOf('#'), Blocks.by });
		this.a(new class_aco(Blocks.U, 6, class_anm.class_a_in_class_anm.h.a()), new Object[] { "###", Character.valueOf('#'), Blocks.cq });
		this.a(new class_aco(Blocks.cP, 6, class_alr.class_a_in_class_alr.a.a()), new Object[] { "###", Character.valueOf('#'), Blocks.cM });
		this.a(new class_aco(Blocks.cX, 6, 0), new Object[] { "###", Character.valueOf('#'), Blocks.cT });
		this.a(new class_aco(Blocks.bM, 6, 0), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(Blocks.bM, 6, class_aly.class_a_in_class_aly.c.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(Blocks.bM, 6, class_aly.class_a_in_class_aly.b.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(Blocks.bM, 6, class_aly.class_a_in_class_aly.d.a()), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(Blocks.bM, 6, (4 + class_aly.class_a_in_class_aly.e.a()) - 4), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(Blocks.bM, 6, (4 + class_aly.class_a_in_class_aly.f.a()) - 4), new Object[] { "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(Blocks.au, 3), new Object[] { "# #", "###", "# #", Character.valueOf('#'), Items.A });
		this.a(new class_aco(Items.as, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(Items.at, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(Items.au, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(Items.av, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(Items.aw, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.e.a()) });
		this.a(new class_aco(Items.ax, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.f.a()) });
		this.a(new class_aco(Blocks.bd, 2), new Object[] { "###", "###", Character.valueOf('#'), Blocks.PLANKS });
		this.a(new class_aco(Items.aD, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), Items.l });
		this.a(new class_aco(Blocks.cw, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.l });
		this.a(new class_aco(Items.ar, 3), new Object[] { "###", "###", " X ", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.A });
		this.a(new class_aco(Items.bb, 1), new Object[] { "AAA", "BEB", "CCC", Character.valueOf('A'), Items.aI, Character.valueOf('B'), Items.ba, Character.valueOf('C'), Items.Q, Character.valueOf('E'), Items.aR });
		this.a(new class_aco(Items.ba, 1), new Object[] { "#", Character.valueOf('#'), Items.aL });
		this.a(new class_aco(Blocks.PLANKS, 4, class_aly.class_a_in_class_aly.a.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.LOG, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(Blocks.PLANKS, 4, class_aly.class_a_in_class_aly.b.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.LOG, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(Blocks.PLANKS, 4, class_aly.class_a_in_class_aly.c.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.LOG, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(Blocks.PLANKS, 4, class_aly.class_a_in_class_aly.d.a()), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.LOG, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(Blocks.PLANKS, 4, (4 + class_aly.class_a_in_class_aly.e.a()) - 4), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.LOG2, 1, class_aly.class_a_in_class_aly.e.a() - 4) });
		this.a(new class_aco(Blocks.PLANKS, 4, (4 + class_aly.class_a_in_class_aly.f.a()) - 4), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.LOG2, 1, class_aly.class_a_in_class_aly.f.a() - 4) });
		this.a(new class_aco(Items.A, 4), new Object[] { "#", "#", Character.valueOf('#'), Blocks.PLANKS });
		this.a(new class_aco(Blocks.aa, 4), new Object[] { "X", "#", Character.valueOf('X'), Items.j, Character.valueOf('#'), Items.A });
		this.a(new class_aco(Blocks.aa, 4), new Object[] { "X", "#", Character.valueOf('X'), new class_aco(Items.j, 1, 1), Character.valueOf('#'), Items.A });
		this.a(new class_aco(Items.B, 4), new Object[] { "# #", " # ", Character.valueOf('#'), Blocks.PLANKS });
		this.a(new class_aco(Items.bE, 3), new Object[] { "# #", " # ", Character.valueOf('#'), Blocks.GLASS });
		this.a(new class_aco(Blocks.av, 16), new Object[] { "X X", "X#X", "X X", Character.valueOf('X'), Items.l, Character.valueOf('#'), Items.A });
		this.a(new class_aco(Blocks.GOLDEN_RAIL, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), Items.m, Character.valueOf('R'), Items.aE, Character.valueOf('#'), Items.A });
		this.a(new class_aco(Blocks.cs, 6), new Object[] { "XSX", "X#X", "XSX", Character.valueOf('X'), Items.l, Character.valueOf('#'), Blocks.aF, Character.valueOf('S'), Items.A });
		this.a(new class_aco(Blocks.DETECTOR_RAIL, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), Items.l, Character.valueOf('R'), Items.aE, Character.valueOf('#'), Blocks.az });
		this.a(new class_aco(Items.aB, 1), new Object[] { "# #", "###", Character.valueOf('#'), Items.l });
		this.a(new class_aco(Items.bL, 1), new Object[] { "# #", "# #", "###", Character.valueOf('#'), Items.l });
		this.a(new class_aco(Items.bK, 1), new Object[] { " B ", "###", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('B'), Items.bx });
		this.a(new class_aco(Blocks.aZ, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.aU, Character.valueOf('B'), Blocks.aa });
		this.a(new class_aco(Items.aP, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.ae, Character.valueOf('B'), Items.aB });
		this.a(new class_aco(Items.aQ, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.al, Character.valueOf('B'), Items.aB });
		this.a(new class_aco(Items.cm, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.W, Character.valueOf('B'), Items.aB });
		this.a(new class_aco(Items.cn, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.cp, Character.valueOf('B'), Items.aB });
		this.a(new class_aco(Items.aG, 1), new Object[] { "# #", "###", Character.valueOf('#'), Blocks.PLANKS });
		this.a(new class_aco(Items.ay, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Items.l });
		this.a(new class_aco(Items.bV, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Items.aJ });
		this.b(new class_aco(Items.d, 1), new Object[] { new class_aco(Items.l, 1), new class_aco(Items.am, 1) });
		this.a(new class_aco(Items.R, 1), new Object[] { "###", Character.valueOf('#'), Items.Q });
		this.a(new class_aco(Blocks.ad, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.a.a()) });
		this.a(new class_aco(Blocks.bV, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.c.a()) });
		this.a(new class_aco(Blocks.bU, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.b.a()) });
		this.a(new class_aco(Blocks.bW, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, class_aly.class_a_in_class_aly.d.a()) });
		this.a(new class_aco(Blocks.cC, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.e.a()) - 4) });
		this.a(new class_aco(Blocks.cD, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new class_aco(Blocks.PLANKS, 1, (4 + class_aly.class_a_in_class_aly.f.a()) - 4) });
		this.a(new class_aco(Items.aT, 1), new Object[] { "  #", " #X", "# X", Character.valueOf('#'), Items.A, Character.valueOf('X'), Items.H });
		this.a(new class_aco(Items.cd, 1), new Object[] { "# ", " X", Character.valueOf('#'), Items.aT, Character.valueOf('X'), Items.bW });
		this.a(new class_aco(Blocks.aw, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.COBBLESTONE });
		this.a(new class_aco(Blocks.bu, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.V });
		this.a(new class_aco(Blocks.bv, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.bf });
		this.a(new class_aco(Blocks.bA, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.by });
		this.a(new class_aco(Blocks.bO, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.SANDSTONE });
		this.a(new class_aco(Blocks.cN, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.cM });
		this.a(new class_aco(Blocks.cr, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.cq });
		this.a(new class_aco(Items.ap, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.A, Character.valueOf('X'), Blocks.L });
		this.a(new class_aco(Items.bU, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.A, Character.valueOf('X'), Items.aH });
		this.a(new class_aco(Items.aq), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.m, Character.valueOf('X'), Items.e });
		this.a(new class_aco(Items.aq, 1, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.R, Character.valueOf('X'), Items.e });
		this.a(new class_aco(Items.cb), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.bz, Character.valueOf('X'), Items.bW });
		this.a(new class_aco(Items.bN, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.bz, Character.valueOf('X'), Items.bh });
		this.a(new class_aco(Blocks.ay, 1), new Object[] { "X", "#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.A });
		this.a(new class_aco(Blocks.bR, 2), new Object[] { "I", "S", "#", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('S'), Items.A, Character.valueOf('I'), Items.l });
		this.a(new class_aco(Blocks.aF, 1), new Object[] { "X", "#", Character.valueOf('#'), Items.A, Character.valueOf('X'), Items.aE });
		this.a(new class_aco(Items.bd, 1), new Object[] { "#X#", "III", Character.valueOf('#'), Blocks.aF, Character.valueOf('X'), Items.aE, Character.valueOf('I'), new class_aco(Blocks.STONE, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(Items.cj, 1), new Object[] { " # ", "#X#", "III", Character.valueOf('#'), Blocks.aF, Character.valueOf('X'), Items.cl, Character.valueOf('I'), new class_aco(Blocks.STONE, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(Items.aU, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Items.m, Character.valueOf('X'), Items.aE });
		this.a(new class_aco(Items.aS, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Items.l, Character.valueOf('X'), Items.aE });
		this.a(new class_aco(Items.ca, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.aM, Character.valueOf('X'), Items.aS });
		this.a(new class_aco(Blocks.aG, 1), new Object[] { "#", Character.valueOf('#'), new class_aco(Blocks.STONE, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(Blocks.cd, 1), new Object[] { "#", Character.valueOf('#'), Blocks.PLANKS });
		this.a(new class_aco(Blocks.az, 1), new Object[] { "##", Character.valueOf('#'), new class_aco(Blocks.STONE, 1, class_anj.class_a_in_class_anj.a.a()) });
		this.a(new class_aco(Blocks.aB, 1), new Object[] { "##", Character.valueOf('#'), Blocks.PLANKS });
		this.a(new class_aco(Blocks.ci, 1), new Object[] { "##", Character.valueOf('#'), Items.l });
		this.a(new class_aco(Blocks.ch, 1), new Object[] { "##", Character.valueOf('#'), Items.m });
		this.a(new class_aco(Blocks.DISPENSER, 1), new Object[] { "###", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.f, Character.valueOf('R'), Items.aE });
		this.a(new class_aco(Blocks.ct, 1), new Object[] { "###", "# #", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('R'), Items.aE });
		this.a(new class_aco(Blocks.J, 1), new Object[] { "TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.l, Character.valueOf('R'), Items.aE, Character.valueOf('T'), Blocks.PLANKS });
		this.a(new class_aco(Blocks.F, 1), new Object[] { "S", "P", Character.valueOf('S'), Items.aO, Character.valueOf('P'), Blocks.J });
		this.a(new class_aco(Items.bc, 1), new Object[] { "###", "XXX", Character.valueOf('#'), Blocks.L, Character.valueOf('X'), Blocks.PLANKS });
		this.a(new class_aco(Blocks.bC, 1), new Object[] { " B ", "D#D", "###", Character.valueOf('#'), Blocks.Z, Character.valueOf('B'), Items.aN, Character.valueOf('D'), Items.k });
		this.a(new class_aco(Blocks.cf, 1), new Object[] { "III", " i ", "iii", Character.valueOf('I'), Blocks.S, Character.valueOf('i'), Items.l });
		this.a(new class_aco(Items.aH), new Object[] { "##", "##", Character.valueOf('#'), Items.bu });
		this.b(new class_aco(Items.bM, 1), new Object[] { Items.bw, Items.bI });
		this.b(new class_aco(Items.bQ, 3), new Object[] { Items.J, Items.bI, Items.j });
		this.b(new class_aco(Items.bQ, 3), new Object[] { Items.J, Items.bI, new class_aco(Items.j, 1, 1) });
		this.a(new class_aco(Blocks.cl), new Object[] { "GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('Q'), Items.cl, Character.valueOf('W'), Blocks.bM });
		this.a(new class_aco(Blocks.cp), new Object[] { "I I", "ICI", " I ", Character.valueOf('I'), Items.l, Character.valueOf('C'), Blocks.ae });
		this.a(new class_aco(Items.co, 1), new Object[] { "///", " / ", "/_/", Character.valueOf('/'), Items.A, Character.valueOf('_'), new class_aco(Blocks.U, 1, class_anm.class_a_in_class_anm.a.a()) });
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
			if (var2[var4 + 1] instanceof Item) {
				var15 = new class_aco((Item) var2[var4 + 1]);
			} else if (var2[var4 + 1] instanceof Block) {
				var15 = new class_aco((Block) var2[var4 + 1], 1, 32767);
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
			} else if (var7 instanceof Item) {
				var3.add(new class_aco((Item) var7));
			} else {
				if (!(var7 instanceof Block)) {
					throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + var7.getClass().getName() + "!");
				}

				var3.add(new class_aco((Block) var7));
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
