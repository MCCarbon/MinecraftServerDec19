package net.minecraft.server;

import java.util.Random;

import net.minecraft.server.BlockPosition.MutableBlockPosition;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;

public class EndGatewayGenerator extends WorldGenerator {

	public boolean generate(World world, Random rnd, BlockPosition position) {
		for (MutableBlockPosition mpos : BlockPosition.allInCubeM(position.add(-1, -2, -1), position.add(1, 2, 1))) {
			boolean sameX = mpos.getX() == position.getX();
			boolean sameY = mpos.getY() == position.getY();
			boolean sameZ = mpos.getZ() == position.getZ();
			boolean yDist2 = Math.abs(mpos.getY() - position.getY()) == 2;
			if (sameX && sameY && sameZ) {
				this.setTypeAndData(world, new BlockPosition(mpos), Blocks.END_GATEWAY.getBlockData());
			} else if (sameY) {
				this.setTypeAndData(world, mpos, Blocks.AIR.getBlockData());
			} else if (yDist2 && sameX && sameZ) {
				this.setTypeAndData(world, mpos, Blocks.BEDROCK.getBlockData());
			} else if ((sameX || sameZ) && !yDist2) {
				this.setTypeAndData(world, mpos, Blocks.BEDROCK.getBlockData());
			} else {
				this.setTypeAndData(world, mpos, Blocks.AIR.getBlockData());
			}
		}
		return true;
	}

}
