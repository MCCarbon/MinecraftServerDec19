package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;

public class EndGatewayPlatformGenerator extends WorldGenerator {

	public boolean generate(World world, Random random, BlockPosition position) {
		float f = random.nextInt(3) + 4;

		for (int y = 0; f > 0.5F; --y) {
			for (int x = MathHelper.floor(-f); x <= MathHelper.ceil(f); ++x) {
				for (int z = MathHelper.floor(-f); z <= MathHelper.ceil(f); ++z) {
					if ((float) (x * x + z * z) <= (f + 1.0F) * (f + 1.0F)) {
						this.setTypeAndData(world, position.add(x, y, z), Blocks.END_STONE.getBlockData());
					}
				}
			}

			f = (float) ((double) f - ((double) random.nextInt(2) + 0.5D));
		}

		return true;
	}

}
