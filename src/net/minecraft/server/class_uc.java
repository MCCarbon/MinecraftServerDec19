package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_uc extends class_uj {
	private boolean a;
	private int b;
	private final Class[] c;

	public class_uc(EntityCreature var1, boolean var2, Class... var3) {
		super(var1, false);
		a = var2;
		c = var3;
		this.a(1);
	}

	@Override
	public boolean a() {
		int var1 = e.bl();
		return (var1 != b) && this.a(e.bk(), false);
	}

	@Override
	public void c() {
		e.c(e.bk());
		b = e.bl();
		if (a) {
			double var1 = f();
			List var3 = e.o.a(e.getClass(), (new class_ayk(e.s, e.t, e.u, e.s + 1.0D, e.t + 1.0D, e.u + 1.0D)).b(var1, 10.0D, var1));
			Iterator var4 = var3.iterator();

			label46: while (true) {
				EntityCreature var5;
				do {
					do {
						do {
							if (!var4.hasNext()) {
								break label46;
							}

							var5 = (EntityCreature) var4.next();
						} while (e == var5);
					} while (var5.w() != null);
				} while (var5.k(e.bk()));

				boolean var6 = false;
				Class[] var7 = c;
				int var8 = var7.length;

				for (int var9 = 0; var9 < var8; ++var9) {
					Class var10 = var7[var9];
					if (var5.getClass() == var10) {
						var6 = true;
						break;
					}
				}

				if (!var6) {
					this.a(var5, e.bk());
				}
			}
		}

		super.c();
	}

	protected void a(EntityCreature var1, EntityLiving var2) {
		var1.c(var2);
	}
}
