package net.minecraft.server;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.authlib.GameProfile;

public class class_kt extends class_me {
	private static final Logger f = LogManager.getLogger();

	public class_kt(class_ku var1) {
		super(var1);
		this.a(var1.a("view-distance", 10));
		e = var1.a("max-players", 20);
		this.a(var1.a("white-list", false));
		if (!var1.V()) {
			this.h().a(true);
			i().a(true);
		}

		z();
		x();
		y();
		w();
		A();
		C();
		B();
		if (!k().c().exists()) {
			D();
		}

	}

	@Override
	public void a(boolean var1) {
		super.a(var1);
		this.b().a("white-list", Boolean.valueOf(var1));
		this.b().a();
	}

	@Override
	public void a(GameProfile var1) {
		super.a(var1);
		B();
	}

	@Override
	public void b(GameProfile var1) {
		super.b(var1);
		B();
	}

	@Override
	public void c(GameProfile var1) {
		super.c(var1);
		D();
	}

	@Override
	public void d(GameProfile var1) {
		super.d(var1);
		D();
	}

	@Override
	public void a() {
		C();
	}

	private void w() {
		try {
			i().f();
		} catch (IOException var2) {
			f.warn("Failed to save ip banlist: ", var2);
		}

	}

	private void x() {
		try {
			this.h().f();
		} catch (IOException var2) {
			f.warn("Failed to save user banlist: ", var2);
		}

	}

	private void y() {
		try {
			i().g();
		} catch (IOException var2) {
			f.warn("Failed to load ip banlist: ", var2);
		}

	}

	private void z() {
		try {
			this.h().g();
		} catch (IOException var2) {
			f.warn("Failed to load user banlist: ", var2);
		}

	}

	private void A() {
		try {
			m().g();
		} catch (Exception var2) {
			f.warn("Failed to load operators list: ", var2);
		}

	}

	private void B() {
		try {
			m().f();
		} catch (Exception var2) {
			f.warn("Failed to save operators list: ", var2);
		}

	}

	private void C() {
		try {
			k().g();
		} catch (Exception var2) {
			f.warn("Failed to load white-list: ", var2);
		}

	}

	private void D() {
		try {
			k().f();
		} catch (Exception var2) {
			f.warn("Failed to save white-list: ", var2);
		}

	}

	@Override
	public boolean e(GameProfile var1) {
		return !r() || this.h(var1) || k().a(var1);
	}

	public class_ku b() {
		return (class_ku) super.c();
	}

	@Override
	public boolean f(GameProfile var1) {
		return m().b(var1);
	}

	// $FF: synthetic method
	@Override
	public MinecraftServer c() {
		return this.b();
	}
}
