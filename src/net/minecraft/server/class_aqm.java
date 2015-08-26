package net.minecraft.server;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

public class class_aqm extends class_aqn {
	public class_aqm(class_ago var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	@Override
	public boolean a(int var1, int var2) {
		return (var1 == b) && (var2 == c);
	}

	@Override
	public int b(int var1, int var2) {
		return 0;
	}

	@Override
	public void b() {
	}

	@Override
	public Block a(class_cj var1) {
		return Blocks.AIR;
	}

	@Override
	public int b(class_cj var1) {
		return 255;
	}

	@Override
	public int c(class_cj var1) {
		return 0;
	}

	@Override
	public int a(class_agu var1, class_cj var2) {
		return var1.c;
	}

	@Override
	public void a(class_agu var1, class_cj var2, int var3) {
	}

	@Override
	public int a(class_cj var1, int var2) {
		return 0;
	}

	@Override
	public void a(Entity var1) {
	}

	@Override
	public void b(Entity var1) {
	}

	@Override
	public void a(Entity var1, int var2) {
	}

	@Override
	public boolean d(class_cj var1) {
		return false;
	}

	@Override
	public TileEntity a(class_cj var1, class_aqn.class_a_in_class_aqn var2) {
		return null;
	}

	@Override
	public void a(TileEntity var1) {
	}

	@Override
	public void a(class_cj var1, TileEntity var2) {
	}

	@Override
	public void e(class_cj var1) {
	}

	@Override
	public void c() {
	}

	@Override
	public void d() {
	}

	@Override
	public void e() {
	}

	@Override
	public void a(Entity var1, class_ayk var2, List var3, Predicate var4) {
	}

	@Override
	public void a(Class var1, class_ayk var2, List var3, Predicate var4) {
	}

	@Override
	public boolean a(boolean var1) {
		return false;
	}

	@Override
	public Random a(long var1) {
		return new Random((q().L() + b * b * 4987142 + b * 5947611 + (c * c * 4392871L) + c * 389711) ^ var1);
	}

	@Override
	public boolean f() {
		return true;
	}

	@Override
	public boolean c(int var1, int var2) {
		return true;
	}
}
