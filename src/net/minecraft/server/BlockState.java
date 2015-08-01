package net.minecraft.server;

import com.google.common.base.Objects;
import net.minecraft.server.IBlockState;

public abstract class BlockState<T extends Comparable<T>> implements IBlockState<T> {

	private final Class<T> clazz;
	private final String name;

	protected BlockState(String name, Class<T> clazz) {
		this.clazz = clazz;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Class<T> getStateClass() {
		return this.clazz;
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("name", this.name).add("clazz", this.clazz).add("values", this.getValues()).toString();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof BlockState)) {
			return false;
		} else {
			BlockState<?> other = (BlockState<?>) obj;
			return this.clazz.equals(other.clazz) && this.name.equals(other.name);
		}
	}

	public int hashCode() {
		return 31 * this.clazz.hashCode() + this.name.hashCode();
	}

}
