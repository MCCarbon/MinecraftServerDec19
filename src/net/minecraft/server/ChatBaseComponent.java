package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatModifier;
import net.minecraft.server.ChatComponentText;

public abstract class ChatBaseComponent implements IChatBaseComponent {

	protected List<IChatBaseComponent> a = Lists.newArrayList();
	private ChatModifier b;

	public IChatBaseComponent addSibling(IChatBaseComponent var1) {
		var1.getChatModifier().setChatModifier(this.getChatModifier());
		this.a.add(var1);
		return this;
	}

	public List<IChatBaseComponent> a() {
		return this.a;
	}

	public IChatBaseComponent a(String var1) {
		return this.addSibling((IChatBaseComponent) (new ChatComponentText(var1)));
	}

	public IChatBaseComponent setChatModifier(ChatModifier var1) {
		this.b = var1;
		Iterator var2 = this.a.iterator();

		while (var2.hasNext()) {
			IChatBaseComponent var3 = (IChatBaseComponent) var2.next();
			var3.getChatModifier().setChatModifier(this.getChatModifier());
		}

		return this;
	}

	public ChatModifier getChatModifier() {
		if (this.b == null) {
			this.b = new ChatModifier();
			Iterator var1 = this.a.iterator();

			while (var1.hasNext()) {
				IChatBaseComponent var2 = (IChatBaseComponent) var1.next();
				var2.getChatModifier().setChatModifier(this.b);
			}
		}

		return this.b;
	}

	public Iterator<IChatBaseComponent> iterator() {
		return Iterators.concat(Iterators.forArray(new ChatBaseComponent[] { this }), a((Iterable) this.a));
	}

	public final String c() {
		StringBuilder var1 = new StringBuilder();
		Iterator var2 = this.iterator();

		while (var2.hasNext()) {
			IChatBaseComponent var3 = (IChatBaseComponent) var2.next();
			var1.append(var3.getText());
		}

		return var1.toString();
	}

	public static Iterator<IChatBaseComponent> a(Iterable var0) {
		Iterator var1 = Iterators.concat(Iterators.transform(var0.iterator(), new Function() {
			public Iterator a(IChatBaseComponent var1) {
				return var1.iterator();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((IChatBaseComponent) var1);
			}
		}));
		var1 = Iterators.transform(var1, new Function() {
			public IChatBaseComponent a(IChatBaseComponent var1) {
				IChatBaseComponent var2 = var1.f();
				var2.setChatModifier(var2.getChatModifier().n());
				return var2;
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((IChatBaseComponent) var1);
			}
		});
		return var1;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof ChatBaseComponent)) {
			return false;
		} else {
			ChatBaseComponent var2 = (ChatBaseComponent) var1;
			return this.a.equals(var2.a) && this.getChatModifier().equals(var2.getChatModifier());
		}
	}

	public int hashCode() {
		return 31 * this.b.hashCode() + this.a.hashCode();
	}

	public String toString() {
		return "BaseComponent{style=" + this.b + ", siblings=" + this.a + '}';
	}
}
