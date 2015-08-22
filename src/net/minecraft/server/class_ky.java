package net.minecraft.server;

import java.util.Vector;

import javax.swing.JList;

public class class_ky extends JList implements class_ks {
	private MinecraftServer a;
	private int b;

	public class_ky(MinecraftServer var1) {
		a = var1;
		var1.a(this);
	}

	@Override
	public void c() {
		if ((b++ % 20) == 0) {
			Vector var1 = new Vector();

			for (int var2 = 0; var2 < a.ar().v().size(); ++var2) {
				var1.add(((class_lm) a.ar().v().get(var2)).e_());
			}

			this.setListData(var1);
		}

	}
}
