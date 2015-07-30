package net.minecraft.server;

public abstract class LazyInitVar<T> {

	private T var;
	private boolean init = false;

	public T get() {
		if (!this.init) {
			this.init = true;
			this.var = this.init();
		}
		return this.var;
	}

	protected abstract T init();

}
