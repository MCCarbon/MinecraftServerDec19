package net.minecraft.server;

import com.google.common.base.Objects;
import net.minecraft.server.MathHelper;

public class BaseBlockPosition implements Comparable<BaseBlockPosition> {

	public static final BaseBlockPosition ZERO = new BaseBlockPosition(0, 0, 0);

	private final int x;
	private final int y;
	private final int z;

	public BaseBlockPosition(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public BaseBlockPosition(double x, double y, double z) {
		this(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z));
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof BaseBlockPosition)) {
			return false;
		} else {
			BaseBlockPosition otherBBP = (BaseBlockPosition) other;
			return this.getX() != otherBBP.getX() ? false : (this.getY() != otherBBP.getY() ? false : this.getZ() == otherBBP.getZ());
		}
	}

	public int hashCode() {
		return (this.getY() + this.getZ() * 31) * 31 + this.getX();
	}

	public int compareTo(BaseBlockPosition other) {
		return this.getY() == other.getY() ? (this.getZ() == other.getZ() ? this.getX() - other.getX() : this.getZ() - other.getZ()) : this.getY() - other.getY();
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getZ() {
		return this.z;
	}

	public BaseBlockPosition crossProduct(BaseBlockPosition position) {
		return new BaseBlockPosition(
			this.getY() * position.getZ() - this.getZ() * position.getY(),
			this.getZ() * position.getX() - this.getX() * position.getZ(),
			this.getX() * position.getY() - this.getY() * position.getX()
		);
	}

	public double distance(int x, int y, int z) {
		double diffX = (double) (this.getX() - x);
		double diffY = (double) (this.getY() - y);
		double diffZ = (double) (this.getZ() - z);
		return Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
	}

	public double distanceSquared(double x, double y, double z) {
		double diffX = (double) this.getX() - x;
		double diffY = (double) this.getY() - y;
		double diffZ = (double) this.getZ() - z;
		return diffX * diffX + diffY * diffY + diffZ * diffZ;
	}

	public double distanceSquaredFromCenter(double x, double y, double z) {
		double diffX = (double) this.getX() + 0.5D - x;
		double diffY = (double) this.getY() + 0.5D - y;
		double diffZ = (double) this.getZ() + 0.5D - z;
		return diffX * diffX + diffY * diffY + diffZ * diffZ;
	}

	public double distanceSquared(BaseBlockPosition position) {
		return this.distanceSquared((double) position.getX(), (double) position.getY(), (double) position.getZ());
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("x", this.getX()).add("y", this.getY()).add("z", this.getZ()).toString();
	}

}
