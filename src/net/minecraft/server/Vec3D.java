package net.minecraft.server;

import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.MathHelper;

public class Vec3D {

	public final double x;
	public final double y;
	public final double z;

	public Vec3D(double x, double y, double z) {
		if (x == -0.0D) {
			x = 0.0D;
		}
		if (y == -0.0D) {
			y = 0.0D;
		}
		if (z == -0.0D) {
			z = 0.0D;
		}
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vec3D(BaseBlockPosition position) {
		this((double) position.getX(), (double) position.getY(), (double) position.getZ());
	}

	public Vec3D normalize() {
		double var1 = (double) MathHelper.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		return var1 < 1.0E-4D ? new Vec3D(0.0D, 0.0D, 0.0D) : new Vec3D(this.x / var1, this.y / var1, this.z / var1);
	}

	public double dotProduct(Vec3D other) {
		return this.x * other.x + this.y * other.y + this.z * other.z;
	}

	public Vec3D d(Vec3D var1) {
		return this.substract(var1.x, var1.y, var1.z);
	}

	public Vec3D substract(double x, double y, double z) {
		return this.add(-x, -y, -z);
	}

	public Vec3D add(Vec3D vec) {
		return this.add(vec.x, vec.y, vec.z);
	}

	public Vec3D add(double x, double y, double z) {
		return new Vec3D(this.x + x, this.y + y, this.z + z);
	}

	public double distanceSquared(Vec3D other) {
		double diffX = other.x - this.x;
		double diffY = other.y - this.y;
		double diffZ = other.z - this.z;
		return diffX * diffX + diffY * diffY + diffZ * diffZ;
	}

	public Vec3D multiply(double mul) {
		return new Vec3D(this.x * mul, this.y * mul, this.z * mul);
	}

	public double length() {
		return (double) MathHelper.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	public Vec3D getIntermediateWithXValue(Vec3D other, double x) {
		double diffX = other.x - this.x;
		double diffY = other.y - this.y;
		double diffZ = other.z - this.z;
		if (diffX * diffX < 1.0000000116860974E-7D) {
			return null;
		} else {
			double mX = (x - this.x) / diffX;
			return mX >= 0.0D && mX <= 1.0D ? new Vec3D(this.x + diffX * mX, this.y + diffY * mX, this.z + diffZ * mX) : null;
		}
	}

	public Vec3D getIntermediateWithYValue(Vec3D other, double y) {
		double diffX = other.x - this.x;
		double diffY = other.y - this.y;
		double diffZ = other.z - this.z;
		if (diffY * diffY < 1.0000000116860974E-7D) {
			return null;
		} else {
			double mY = (y - this.y) / diffY;
			return mY >= 0.0D && mY <= 1.0D ? new Vec3D(this.x + diffX * mY, this.y + diffY * mY, this.z + diffZ * mY) : null;
		}
	}

	public Vec3D getIntermediateWithZValue(Vec3D other, double z) {
		double diffX = other.x - this.x;
		double diffY = other.y - this.y;
		double diffZ = other.z - this.z;
		if (diffZ * diffZ < 1.0000000116860974E-7D) {
			return null;
		} else {
			double mZ = (z - this.z) / diffZ;
			return mZ >= 0.0D && mZ <= 1.0D ? new Vec3D(this.x + diffX * mZ, this.y + diffY * mZ, this.z + diffZ * mZ) : null;
		}
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}

	public Vec3D rotatePitch(float pitch) {
		float cos = MathHelper.cos(pitch);
		float sin = MathHelper.sin(pitch);
		double x = this.x;
		double y = this.y * (double) cos + this.z * (double) sin;
		double z = this.z * (double) cos - this.y * (double) sin;
		return new Vec3D(x, y, z);
	}

	public Vec3D rotateYaw(float yaw) {
		float cos = MathHelper.cos(yaw);
		float sin = MathHelper.sin(yaw);
		double x = this.x * (double) cos + this.z * (double) sin;
		double y = this.y;
		double z = this.z * (double) cos - this.x * (double) sin;
		return new Vec3D(x, y, z);
	}

}
