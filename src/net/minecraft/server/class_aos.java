package net.minecraft.server;


public class class_aos extends TileEntity {
	private Item a;
	private int f;

	public class_aos() {
	}

	public class_aos(Item var1, int var2) {
		a = var1;
		f = var2;
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		class_ke var2 = (class_ke) Item.e.b(a);
		var1.a("Item", var2 == null ? "" : var2.toString());
		var1.a("Data", f);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("Item", 8)) {
			a = Item.d(var1.l("Item"));
		} else {
			a = Item.c(var1.h("Item"));
		}

		f = var1.h("Data");
	}

	@Override
	public Packet x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		var1.q("Item");
		var1.a("Item", Item.b(a));
		return new PacketPlayOutTileEntityData(c, 5, var1);
	}

	public void a(Item var1, int var2) {
		a = var1;
		f = var2;
	}

	public class_aco b() {
		return a == null ? null : new class_aco(a, 1, f);
	}

	public Item c() {
		return a;
	}

	public int d() {
		return f;
	}
}
