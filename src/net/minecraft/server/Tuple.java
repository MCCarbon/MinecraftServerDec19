package net.minecraft.server;

public class Tuple {

	private Object obj1;
	private Object obj2;

	public Tuple(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public Object getObject1() {
		return this.obj1;
	}

	public Object getObject2() {
		return this.obj2;
	}

}
