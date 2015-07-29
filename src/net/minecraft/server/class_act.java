package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_ach;
import net.minecraft.server.class_aci;
import net.minecraft.server.class_acj;
import net.minecraft.server.class_ack;
import net.minecraft.server.class_acl;
import net.minecraft.server.class_acm;
import net.minecraft.server.class_acn;
import net.minecraft.server.class_acp;
import net.minecraft.server.class_acq;
import net.minecraft.server.class_acr;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_acu;
import net.minecraft.server.class_acv;
import net.minecraft.server.class_acw;
import net.minecraft.server.class_acx;
import net.minecraft.server.class_acy;
import net.minecraft.server.class_acz;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajp;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_alh;
import net.minecraft.server.class_alk;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_yg;
import net.minecraft.server.class_zy;

public class class_act {
   private static final class_act a = new class_act();
   private final List b = Lists.newArrayList();

   public static class_act a() {
      return a;
   }

   private class_act() {
      (new class_acy()).a(this);
      (new class_acz()).a(this);
      (new class_acr()).a(this);
      (new class_acn()).a(this);
      (new class_acx()).a(this);
      (new class_aci()).a(this);
      (new class_acl()).a(this);
      this.b.add(new class_ach());
      this.b.add(new class_ack());
      this.b.add(new class_acp());
      this.b.add(new class_acq());
      this.b.add(new class_acm());
      this.b.add(new class_acu());
      (new class_acj()).a(this);
      this.a(new class_aas(class_aau.aM, 3), new Object[]{"###", Character.valueOf('#'), class_aau.aL});
      this.b(new class_aas(class_aau.aN, 1), new Object[]{class_aau.aM, class_aau.aM, class_aau.aM, class_aau.aH});
      this.b(new class_aas(class_aau.bP, 1), new Object[]{class_aau.aN, new class_aas(class_aau.aY, 1, class_zy.p.b()), class_aau.I});
      this.a(new class_aas(class_agk.aO, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new class_aas(class_agk.aQ, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new class_aas(class_agk.aP, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new class_aas(class_agk.aR, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new class_aas(class_agk.aT, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new class_aas(class_agk.aS, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new class_aas(class_agk.bZ, 6, class_alv.class_a_in_class_alv.a.a()), new Object[]{"###", "###", Character.valueOf('#'), class_agk.e});
      this.a(new class_aas(class_agk.bZ, 6, class_alv.class_a_in_class_alv.b.a()), new Object[]{"###", "###", Character.valueOf('#'), class_agk.Y});
      this.a(new class_aas(class_agk.bz, 6), new Object[]{"###", "###", Character.valueOf('#'), class_agk.by});
      this.a(new class_aas(class_agk.bo, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new class_aas(class_agk.bq, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new class_aas(class_agk.bp, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new class_aas(class_agk.br, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new class_aas(class_agk.bt, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new class_aas(class_agk.bs, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), class_aau.A, Character.valueOf('W'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new class_aas(class_agk.aN, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_agk.f, Character.valueOf('X'), class_aau.k});
      this.a(new class_aas(class_aau.cq, 2), new Object[]{"~~ ", "~O ", "  ~", Character.valueOf('~'), class_aau.H, Character.valueOf('O'), class_aau.aO});
      this.a(new class_aas(class_agk.B, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_agk.f, Character.valueOf('X'), class_aau.aE});
      this.a(new class_aas(class_agk.X, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), class_agk.f, Character.valueOf('X'), class_aau.aN});
      this.a(new class_aas(class_agk.aJ, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.aF});
      this.a(new class_aas(class_agk.aH, 6), new Object[]{"###", Character.valueOf('#'), class_agk.aJ});
      this.a(new class_aas(class_agk.aL, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.aK});
      this.a(new class_aas(class_agk.V, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.aJ});
      this.a(new class_aas(class_agk.aX, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.aV});
      this.a(new class_aas(class_agk.cq, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.cj});
      this.a(new class_aas(class_agk.L, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.H});
      this.a(new class_aas(class_agk.W, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), class_aau.J, Character.valueOf('#'), class_agk.m});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.d.a()), new Object[]{"###", Character.valueOf('#'), class_agk.e});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.a.a()), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.b, 1, class_alh.class_a_in_class_alh.a.a())});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.b.a()), new Object[]{"###", Character.valueOf('#'), class_agk.A});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.e.a()), new Object[]{"###", Character.valueOf('#'), class_agk.V});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.f.a()), new Object[]{"###", Character.valueOf('#'), class_agk.bf});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.g.a()), new Object[]{"###", Character.valueOf('#'), class_agk.by});
      this.a(new class_aas(class_agk.U, 6, class_alk.class_a_in_class_alk.h.a()), new Object[]{"###", Character.valueOf('#'), class_agk.cq});
      this.a(new class_aas(class_agk.cP, 6, class_ajp.class_a_in_class_ajp.a.a()), new Object[]{"###", Character.valueOf('#'), class_agk.cM});
      this.a(new class_aas(class_agk.cX, 6, 0), new Object[]{"###", Character.valueOf('#'), class_agk.cT});
      this.a(new class_aas(class_agk.bM, 6, 0), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new class_aas(class_agk.bM, 6, class_ajw.class_a_in_class_ajw.c.a()), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new class_aas(class_agk.bM, 6, class_ajw.class_a_in_class_ajw.b.a()), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new class_aas(class_agk.bM, 6, class_ajw.class_a_in_class_ajw.d.a()), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new class_aas(class_agk.bM, 6, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new class_aas(class_agk.bM, 6, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4), new Object[]{"###", Character.valueOf('#'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new class_aas(class_agk.au, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), class_aau.A});
      this.a(new class_aas(class_aau.as, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new class_aas(class_aau.at, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new class_aas(class_aau.au, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new class_aas(class_aau.av, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new class_aas(class_aau.aw, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.e.a())});
      this.a(new class_aas(class_aau.ax, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.f.a())});
      this.a(new class_aas(class_agk.bd, 2), new Object[]{"###", "###", Character.valueOf('#'), class_agk.f});
      this.a(new class_aas(class_aau.aD, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), class_aau.l});
      this.a(new class_aas(class_agk.cw, 1), new Object[]{"##", "##", Character.valueOf('#'), class_aau.l});
      this.a(new class_aas(class_aau.ar, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), class_agk.f, Character.valueOf('X'), class_aau.A});
      this.a(new class_aas(class_aau.bb, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), class_aau.aI, Character.valueOf('B'), class_aau.ba, Character.valueOf('C'), class_aau.Q, Character.valueOf('E'), class_aau.aR});
      this.a(new class_aas(class_aau.ba, 1), new Object[]{"#", Character.valueOf('#'), class_aau.aL});
      this.a(new class_aas(class_agk.f, 4, class_ajw.class_a_in_class_ajw.a.a()), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.r, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new class_aas(class_agk.f, 4, class_ajw.class_a_in_class_ajw.b.a()), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.r, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new class_aas(class_agk.f, 4, class_ajw.class_a_in_class_ajw.c.a()), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.r, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new class_aas(class_agk.f, 4, class_ajw.class_a_in_class_ajw.d.a()), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.r, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new class_aas(class_agk.f, 4, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.s, 1, class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new class_aas(class_agk.f, 4, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.s, 1, class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new class_aas(class_aau.A, 4), new Object[]{"#", "#", Character.valueOf('#'), class_agk.f});
      this.a(new class_aas(class_agk.aa, 4), new Object[]{"X", "#", Character.valueOf('X'), class_aau.j, Character.valueOf('#'), class_aau.A});
      this.a(new class_aas(class_agk.aa, 4), new Object[]{"X", "#", Character.valueOf('X'), new class_aas(class_aau.j, 1, 1), Character.valueOf('#'), class_aau.A});
      this.a(new class_aas(class_aau.B, 4), new Object[]{"# #", " # ", Character.valueOf('#'), class_agk.f});
      this.a(new class_aas(class_aau.bD, 3), new Object[]{"# #", " # ", Character.valueOf('#'), class_agk.w});
      this.a(new class_aas(class_agk.av, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), class_aau.l, Character.valueOf('#'), class_aau.A});
      this.a(new class_aas(class_agk.D, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), class_aau.m, Character.valueOf('R'), class_aau.aE, Character.valueOf('#'), class_aau.A});
      this.a(new class_aas(class_agk.cs, 6), new Object[]{"XSX", "X#X", "XSX", Character.valueOf('X'), class_aau.l, Character.valueOf('#'), class_agk.aF, Character.valueOf('S'), class_aau.A});
      this.a(new class_aas(class_agk.E, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), class_aau.l, Character.valueOf('R'), class_aau.aE, Character.valueOf('#'), class_agk.az});
      this.a(new class_aas(class_aau.aB, 1), new Object[]{"# #", "###", Character.valueOf('#'), class_aau.l});
      this.a(new class_aas(class_aau.bJ, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), class_aau.l});
      this.a(new class_aas(class_aau.bI, 1), new Object[]{" B ", "###", Character.valueOf('#'), class_agk.e, Character.valueOf('B'), class_aau.bx});
      this.a(new class_aas(class_agk.aZ, 1), new Object[]{"A", "B", Character.valueOf('A'), class_agk.aU, Character.valueOf('B'), class_agk.aa});
      this.a(new class_aas(class_aau.aP, 1), new Object[]{"A", "B", Character.valueOf('A'), class_agk.ae, Character.valueOf('B'), class_aau.aB});
      this.a(new class_aas(class_aau.aQ, 1), new Object[]{"A", "B", Character.valueOf('A'), class_agk.al, Character.valueOf('B'), class_aau.aB});
      this.a(new class_aas(class_aau.ck, 1), new Object[]{"A", "B", Character.valueOf('A'), class_agk.W, Character.valueOf('B'), class_aau.aB});
      this.a(new class_aas(class_aau.cl, 1), new Object[]{"A", "B", Character.valueOf('A'), class_agk.cp, Character.valueOf('B'), class_aau.aB});
      this.a(new class_aas(class_aau.aG, 1), new Object[]{"# #", "###", Character.valueOf('#'), class_agk.f});
      this.a(new class_aas(class_aau.ay, 1), new Object[]{"# #", " # ", Character.valueOf('#'), class_aau.l});
      this.a(new class_aas(class_aau.bT, 1), new Object[]{"# #", " # ", Character.valueOf('#'), class_aau.aJ});
      this.b(new class_aas(class_aau.d, 1), new Object[]{new class_aas(class_aau.l, 1), new class_aas(class_aau.am, 1)});
      this.a(new class_aas(class_aau.R, 1), new Object[]{"###", Character.valueOf('#'), class_aau.Q});
      this.a(new class_aas(class_agk.ad, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new class_aas(class_agk.bV, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new class_aas(class_agk.bU, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new class_aas(class_agk.bW, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new class_aas(class_agk.f, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new class_aas(class_agk.cC, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new class_aas(class_agk.cD, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new class_aas(class_agk.f, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new class_aas(class_aau.aT, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), class_aau.A, Character.valueOf('X'), class_aau.H});
      this.a(new class_aas(class_aau.cb, 1), new Object[]{"# ", " X", Character.valueOf('#'), class_aau.aT, Character.valueOf('X'), class_aau.bU});
      this.a(new class_aas(class_agk.aw, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.e});
      this.a(new class_aas(class_agk.bu, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.V});
      this.a(new class_aas(class_agk.bv, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.bf});
      this.a(new class_aas(class_agk.bA, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.by});
      this.a(new class_aas(class_agk.bO, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.A});
      this.a(new class_aas(class_agk.cN, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.cM});
      this.a(new class_aas(class_agk.cr, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), class_agk.cq});
      this.a(new class_aas(class_aau.ap, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_aau.A, Character.valueOf('X'), class_agk.L});
      this.a(new class_aas(class_aau.bS, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_aau.A, Character.valueOf('X'), class_aau.aH});
      this.a(new class_aas(class_aau.aq), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_aau.m, Character.valueOf('X'), class_aau.e});
      this.a(new class_aas(class_aau.aq, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_agk.R, Character.valueOf('X'), class_aau.e});
      this.a(new class_aas(class_aau.bZ), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_aau.bz, Character.valueOf('X'), class_aau.bU});
      this.a(new class_aas(class_aau.bL, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_aau.bz, Character.valueOf('X'), class_aau.bh});
      this.a(new class_aas(class_agk.ay, 1), new Object[]{"X", "#", Character.valueOf('#'), class_agk.e, Character.valueOf('X'), class_aau.A});
      this.a(new class_aas(class_agk.bR, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), class_agk.f, Character.valueOf('S'), class_aau.A, Character.valueOf('I'), class_aau.l});
      this.a(new class_aas(class_agk.aF, 1), new Object[]{"X", "#", Character.valueOf('#'), class_aau.A, Character.valueOf('X'), class_aau.aE});
      this.a(new class_aas(class_aau.bd, 1), new Object[]{"#X#", "III", Character.valueOf('#'), class_agk.aF, Character.valueOf('X'), class_aau.aE, Character.valueOf('I'), new class_aas(class_agk.b, 1, class_alh.class_a_in_class_alh.a.a())});
      this.a(new class_aas(class_aau.ch, 1), new Object[]{" # ", "#X#", "III", Character.valueOf('#'), class_agk.aF, Character.valueOf('X'), class_aau.cj, Character.valueOf('I'), new class_aas(class_agk.b, 1, class_alh.class_a_in_class_alh.a.a())});
      this.a(new class_aas(class_aau.aU, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), class_aau.m, Character.valueOf('X'), class_aau.aE});
      this.a(new class_aas(class_aau.aS, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), class_aau.l, Character.valueOf('X'), class_aau.aE});
      this.a(new class_aas(class_aau.bY, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), class_aau.aM, Character.valueOf('X'), class_aau.aS});
      this.a(new class_aas(class_agk.aG, 1), new Object[]{"#", Character.valueOf('#'), new class_aas(class_agk.b, 1, class_alh.class_a_in_class_alh.a.a())});
      this.a(new class_aas(class_agk.cd, 1), new Object[]{"#", Character.valueOf('#'), class_agk.f});
      this.a(new class_aas(class_agk.az, 1), new Object[]{"##", Character.valueOf('#'), new class_aas(class_agk.b, 1, class_alh.class_a_in_class_alh.a.a())});
      this.a(new class_aas(class_agk.aB, 1), new Object[]{"##", Character.valueOf('#'), class_agk.f});
      this.a(new class_aas(class_agk.ci, 1), new Object[]{"##", Character.valueOf('#'), class_aau.l});
      this.a(new class_aas(class_agk.ch, 1), new Object[]{"##", Character.valueOf('#'), class_aau.m});
      this.a(new class_aas(class_agk.z, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), class_agk.e, Character.valueOf('X'), class_aau.f, Character.valueOf('R'), class_aau.aE});
      this.a(new class_aas(class_agk.ct, 1), new Object[]{"###", "# #", "#R#", Character.valueOf('#'), class_agk.e, Character.valueOf('R'), class_aau.aE});
      this.a(new class_aas(class_agk.J, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), class_agk.e, Character.valueOf('X'), class_aau.l, Character.valueOf('R'), class_aau.aE, Character.valueOf('T'), class_agk.f});
      this.a(new class_aas(class_agk.F, 1), new Object[]{"S", "P", Character.valueOf('S'), class_aau.aO, Character.valueOf('P'), class_agk.J});
      this.a(new class_aas(class_aau.bc, 1), new Object[]{"###", "XXX", Character.valueOf('#'), class_agk.L, Character.valueOf('X'), class_agk.f});
      this.a(new class_aas(class_agk.bC, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), class_agk.Z, Character.valueOf('B'), class_aau.aN, Character.valueOf('D'), class_aau.k});
      this.a(new class_aas(class_agk.cf, 1), new Object[]{"III", " i ", "iii", Character.valueOf('I'), class_agk.S, Character.valueOf('i'), class_aau.l});
      this.a(new class_aas(class_aau.aH), new Object[]{"##", "##", Character.valueOf('#'), class_aau.bu});
      this.b(new class_aas(class_aau.bK, 1), new Object[]{class_aau.bw, class_aau.bG});
      this.b(new class_aas(class_aau.bO, 3), new Object[]{class_aau.J, class_aau.bG, class_aau.j});
      this.b(new class_aas(class_aau.bO, 3), new Object[]{class_aau.J, class_aau.bG, new class_aas(class_aau.j, 1, 1)});
      this.a(new class_aas(class_agk.cl), new Object[]{"GGG", "QQQ", "WWW", Character.valueOf('G'), class_agk.w, Character.valueOf('Q'), class_aau.cj, Character.valueOf('W'), class_agk.bM});
      this.a(new class_aas(class_agk.cp), new Object[]{"I I", "ICI", " I ", Character.valueOf('I'), class_aau.l, Character.valueOf('C'), class_agk.ae});
      this.a(new class_aas(class_aau.cm, 1), new Object[]{"///", " / ", "/_/", Character.valueOf('/'), class_aau.A, Character.valueOf('_'), new class_aas(class_agk.U, 1, class_alk.class_a_in_class_alk.a.a())});
      Collections.sort(this.b, new Comparator() {
         public int a(class_acs var1, class_acs var2) {
            return var1 instanceof class_acw && var2 instanceof class_acv?1:(var2 instanceof class_acw && var1 instanceof class_acv?-1:(var2.a() < var1.a()?-1:(var2.a() > var1.a()?1:0)));
         }

         // $FF: synthetic method
         public int compare(Object var1, Object var2) {
            return this.a((class_acs)var1, (class_acs)var2);
         }
      });
   }

   public class_acv a(class_aas var1, Object... var2) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if(var2[var4] instanceof String[]) {
         String[] var11 = (String[])((String[])var2[var4++]);

         for(int var8 = 0; var8 < var11.length; ++var8) {
            String var9 = var11[var8];
            ++var6;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while(var2[var4] instanceof String) {
            String var7 = (String)var2[var4++];
            ++var6;
            var5 = var7.length();
            var3 = var3 + var7;
         }
      }

      HashMap var12;
      for(var12 = Maps.newHashMap(); var4 < var2.length; var4 += 2) {
         Character var13 = (Character)var2[var4];
         class_aas var15 = null;
         if(var2[var4 + 1] instanceof class_aar) {
            var15 = new class_aas((class_aar)var2[var4 + 1]);
         } else if(var2[var4 + 1] instanceof Block) {
            var15 = new class_aas((Block)var2[var4 + 1], 1, 32767);
         } else if(var2[var4 + 1] instanceof class_aas) {
            var15 = (class_aas)var2[var4 + 1];
         }

         var12.put(var13, var15);
      }

      class_aas[] var14 = new class_aas[var5 * var6];

      for(int var16 = 0; var16 < var5 * var6; ++var16) {
         char var10 = var3.charAt(var16);
         if(var12.containsKey(Character.valueOf(var10))) {
            var14[var16] = ((class_aas)var12.get(Character.valueOf(var10))).k();
         } else {
            var14[var16] = null;
         }
      }

      class_acv var17 = new class_acv(var5, var6, var14, var1);
      this.b.add(var17);
      return var17;
   }

   public void b(class_aas var1, Object... var2) {
      ArrayList var3 = Lists.newArrayList();
      Object[] var4 = var2;
      int var5 = var2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof class_aas) {
            var3.add(((class_aas)var7).k());
         } else if(var7 instanceof class_aar) {
            var3.add(new class_aas((class_aar)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + var7.getClass().getName() + "!");
            }

            var3.add(new class_aas((Block)var7));
         }
      }

      this.b.add(new class_acw(var1, var3));
   }

   public void a(class_acs var1) {
      this.b.add(var1);
   }

   public class_aas a(class_yg var1, class_aen var2) {
      Iterator var3 = this.b.iterator();

      class_acs var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (class_acs)var3.next();
      } while(!var4.a(var1, var2));

      return var4.a(var1);
   }

   public class_aas[] b(class_yg var1, class_aen var2) {
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         class_acs var4 = (class_acs)var3.next();
         if(var4.a(var1, var2)) {
            return var4.b(var1);
         }
      }

      class_aas[] var5 = new class_aas[var1.o_()];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = var1.a(var6);
      }

      return var5;
   }

   public List b() {
      return this.b;
   }
}
