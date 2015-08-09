package net.minecraft.server;

import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.Entity;

public class MovingObjectPosition {

	private BlockPosition e;
	public MovingObjectPosition.EnumMovingObjectType type;
	public EnumDirection direction;
	public Vec3D pos;
	public Entity entity;

	public MovingObjectPosition(Vec3D pos, EnumDirection direction, BlockPosition var3) {
		this(MovingObjectPosition.EnumMovingObjectType.BLOCK, pos, direction, var3);
	}

	public MovingObjectPosition(Vec3D pos, EnumDirection direction) {
		this(MovingObjectPosition.EnumMovingObjectType.BLOCK, pos, direction, BlockPosition.ZERO);
	}

	public MovingObjectPosition(Entity entity) {
		this(entity, new Vec3D(entity.locX, entity.locY, entity.locZ));
	}

	public MovingObjectPosition(MovingObjectPosition.EnumMovingObjectType var1, Vec3D var2, EnumDirection var3, BlockPosition var4) {
		this.type = var1;
		this.e = var4;
		this.direction = var3;
		this.pos = new Vec3D(var2.x, var2.y, var2.z);
	}

	public MovingObjectPosition(Entity var1, Vec3D var2) {
		this.type = MovingObjectPosition.EnumMovingObjectType.ENTITY;
		this.entity = var1;
		this.pos = var2;
	}

	public BlockPosition a() {
		return this.e;
	}

	public String toString() {
		return "HitResult{type=" + this.type + ", blockpos=" + this.e + ", f=" + this.direction + ", pos=" + this.pos + ", entity=" + this.entity + '}';
	}

	public static enum EnumMovingObjectType {
		MISS, BLOCK, ENTITY;
	}

}
