package net.minecraft.server;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class MinecraftKey {

	protected final String namespace;
	protected final String name;

	protected MinecraftKey(int id, String... nameArray) {
		this.namespace = StringUtils.isEmpty(nameArray[0]) ? "minecraft" : nameArray[0].toLowerCase();
		this.name = nameArray[1];
		Validate.notNull(this.name);
	}

	public MinecraftKey(String name) {
		this(0, getNameArray(name));
	}

	protected static String[] getNameArray(String name) {
		String[] namearr = new String[] { "minecraft", name };
		int colonPos = name.indexOf(58);
		if (colonPos >= 0) {
			namearr[1] = name.substring(colonPos + 1, name.length());
			if (colonPos > 1) {
				namearr[0] = name.substring(0, colonPos);
			}
		}

		return namearr;
	}

	public String getName() {
		return this.name;
	}

	public String getNamespace() {
		return this.namespace;
	}

	public String toString() {
		return this.namespace + ':' + this.name;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof MinecraftKey)) {
			return false;
		} else {
			MinecraftKey var2 = (MinecraftKey) other;
			return this.namespace.equals(var2.namespace) && this.name.equals(var2.name);
		}
	}

	public int hashCode() {
		return 31 * this.namespace.hashCode() + this.name.hashCode();
	}
}
