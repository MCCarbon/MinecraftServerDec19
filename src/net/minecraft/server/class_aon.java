package net.minecraft.server;


public class class_aon extends TileEntity implements class_ks {
	@Override
	public void c() {
		if ((b != null) && !b.D && ((b.M() % 20L) == 0L)) {
			e = w();
			if (e instanceof BlockRedstoneDetector) {
				((BlockRedstoneDetector) e).e(b, c);
			}
		}

	}
}
