package net.minecraft.server;

import java.text.DecimalFormat;
import java.util.Random;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public final class ItemStack {

	public static final DecimalFormat format = new DecimalFormat("#.###");

	public int count;
	public int c;
	private Item item;
	private NBTTagCompound tag;
	private int data;
	private class_va itemFrame;
	private Block h;
	private boolean i;
	private Block j;
	private boolean k;

	public ItemStack(Block block) {
		this(block, 1);
	}

	public ItemStack(Block block, int count) {
		this(block, count, 0);
	}

	public ItemStack(Block block, int count, int data) {
		this(Item.getItemOf(block), count, data);
	}

	public ItemStack(Item item) {
		this(item, 1);
	}

	public ItemStack(Item item, int count) {
		this(item, count, 0);
	}

	public ItemStack(Item item, int count, int data) {
		h = null;
		i = false;
		j = null;
		k = false;
		this.item = item;
		this.count = count;
		this.data = data;
		if (this.data < 0) {
			this.data = 0;
		}
	}

	public static ItemStack a(NBTTagCompound var0) {
		ItemStack var1 = new ItemStack();
		var1.read(var0);
		return var1.getItem() != null ? var1 : null;
	}

	private ItemStack() {
		h = null;
		i = false;
		j = null;
		k = false;
	}

	public ItemStack a(int var1) {
		ItemStack var2 = new ItemStack(item, var1, data);
		if (tag != null) {
			var2.tag = (NBTTagCompound) tag.clone();
		}

		count -= var1;
		return var2;
	}

	public Item getItem() {
		return item;
	}

	public class_oq a(EntityHuman var1, World var2, BlockPosition var3, EnumUsedHand var4, EnumDirection var5, float var6, float var7, float var8) {
		class_oq var9 = getItem().a(this, var1, var2, var3, var4, var5, var6, var7, var8);
		if (var9 == class_oq.a) {
			var1.b(StatisticList.ad[Item.getId(item)]);
		}

		return var9;
	}

	public float a(Block var1) {
		return getItem().a(this, var1);
	}

	public class_or a(World var1, EntityHuman var2, EnumUsedHand var3) {
		return getItem().a(this, var1, var2, var3);
	}

	public ItemStack a(World var1, EntityLiving var2) {
		return getItem().a(this, var1, var2);
	}

	public NBTTagCompound write(NBTTagCompound compound) {
		MinecraftKey var2 = Item.ITEM_REGISTRY.getKey(item);
		compound.put("id", var2 == null ? "minecraft:air" : var2.toString());
		compound.put("Count", (byte) count);
		compound.put("Damage", (short) data);
		if (tag != null) {
			compound.put("tag", tag);
		}

		return compound;
	}

	public void read(NBTTagCompound compound) {
		if (compound.hasOfType("id", 8)) {
			item = Item.getByName(compound.getString("id"));
		} else {
			item = Item.getById(compound.getShort("id"));
		}

		count = compound.getByte("Count");
		data = compound.getShort("Damage");
		if (data < 0) {
			data = 0;
		}

		if (compound.hasOfType("tag", 10)) {
			tag = compound.getCompound("tag");
			if (item != null) {
				item.a(tag);
			}
		}
	}

	public int c() {
		return getItem().j();
	}

	public boolean d() {
		return (this.c() > 1) && (!e() || !g());
	}

	public boolean e() {
		return item == null ? false : (item.l() <= 0 ? false : !hasTag() || !getTag().getBoolean("Unbreakable"));
	}

	public boolean f() {
		return item.k();
	}

	public boolean g() {
		return e() && (data > 0);
	}

	public int h() {
		return data;
	}

	public int i() {
		return data;
	}

	public void setData(int newdata) {
		data = newdata;
		if (data < 0) {
			data = 0;
		}
	}

	public int j() {
		return item.l();
	}

	public boolean a(int var1, Random var2) {
		if (!e()) {
			return false;
		} else {
			if (var1 > 0) {
				int var3 = EnchantmentManager.getLevel(Enchantment.r, this);
				int var4 = 0;

				for (int var5 = 0; (var3 > 0) && (var5 < var1); ++var5) {
					if (class_adg.a(this, var3, var2)) {
						++var4;
					}
				}

				var1 -= var4;
				if (var1 <= 0) {
					return false;
				}
			}

			data += var1;
			return data > j();
		}
	}

	public void a(int var1, EntityLiving var2) {
		if (!(var2 instanceof EntityHuman) || !((EntityHuman) var2).bH.instabuild) {
			if (e()) {
				if (this.a(var1, var2.bd())) {
					var2.b(this);
					--count;
					if (var2 instanceof EntityHuman) {
						EntityHuman var3 = (EntityHuman) var2;
						var3.b(StatisticList.ae[Item.getId(item)]);
					}

					if (count < 0) {
						count = 0;
					}

					data = 0;
				}

			}
		}
	}

	public void a(EntityLiving var1, EntityHuman var2) {
		boolean var3 = item.a(this, var1, var2);
		if (var3) {
			var2.b(StatisticList.ad[Item.getId(item)]);
		}

	}

	public void a(World var1, Block var2, BlockPosition var3, EntityHuman var4) {
		boolean var5 = item.a(this, var1, var2, var3, var4);
		if (var5) {
			var4.b(StatisticList.ad[Item.getId(item)]);
		}

	}

	public boolean b(Block var1) {
		return item.b(var1);
	}

	public boolean a(EntityHuman var1, EntityLiving var2, EnumUsedHand var3) {
		return item.a(this, var1, var2, var3);
	}

	public ItemStack clone() {
		ItemStack itemstack = new ItemStack(item, count, data);
		if (tag != null) {
			itemstack.tag = (NBTTagCompound) tag.clone();
		}
		return itemstack;
	}

	public static boolean a(ItemStack var0, ItemStack var1) {
		return (var0 == null) && (var1 == null) ? true : ((var0 != null) && (var1 != null) ? ((var0.tag == null) && (var1.tag != null) ? false : (var0.tag == null) || var0.tag.equals(var1.tag)) : false);
	}

	public static boolean b(ItemStack var0, ItemStack var1) {
		return (var0 == null) && (var1 == null) ? true : ((var0 != null) && (var1 != null) ? var0.d(var1) : false);
	}

	private boolean d(ItemStack var1) {
		return count != var1.count ? false : (item != var1.item ? false : (data != var1.data ? false : ((tag == null) && (var1.tag != null) ? false : (tag == null) || tag.equals(var1.tag))));
	}

	public static boolean c(ItemStack var0, ItemStack var1) {
		return (var0 == null) && (var1 == null) ? true : ((var0 != null) && (var1 != null) ? var0.a(var1) : false);
	}

	public boolean a(ItemStack var1) {
		return (var1 != null) && (item == var1.item) && (data == var1.data);
	}

	public String a() {
		return item.e_(this);
	}

	public static ItemStack b(ItemStack var0) {
		return var0 == null ? null : var0.clone();
	}

	@Override
	public String toString() {
		return count + "x" + item.a() + "@" + data;
	}

	public void a(World var1, Entity var2, int var3, boolean var4) {
		if (c > 0) {
			--c;
		}

		item.a(this, var1, var2, var3, var4);
	}

	public void a(World var1, EntityHuman var2, int var3) {
		var2.a(StatisticList.ac[Item.getId(item)], var3);
		item.b(this, var1, var2);
	}

	public int l() {
		return getItem().e(this);
	}

	public class_abz m() {
		return getItem().f(this);
	}

	public void a(World var1, EntityLiving var2, int var3) {
		getItem().a(this, var1, var2, var3);
	}

	public boolean hasTag() {
		return tag != null;
	}

	public NBTTagCompound getTag() {
		return tag;
	}

	public NBTTagCompound getCompound(String key, boolean create) {
		if ((tag != null) && tag.hasOfType(key, 10)) {
			return tag.getCompound(key);
		} else if (create) {
			NBTTagCompound compound = new NBTTagCompound();
			this.addTag(key, compound);
			return compound;
		} else {
			return null;
		}
	}

	public NBTTagList getEnchantments() {
		return tag == null ? null : tag.getList("ench", 10);
	}

	public void setTag(NBTTagCompound tag) {
		this.tag = tag;
	}

	public String getDisplayName() {
		String displayName = getItem().getLocalizedName(this);
		if ((tag != null) && tag.hasOfType("display", 10)) {
			NBTTagCompound display = tag.getCompound("display");
			if (display.hasOfType("Name", 8)) {
				displayName = display.getString("Name");
			}
		}
		return displayName;
	}

	public ItemStack setDisplayName(String displayName) {
		if (tag == null) {
			tag = new NBTTagCompound();
		}

		if (!tag.hasOfType("display", 10)) {
			tag.put("display", (new NBTTagCompound()));
		}

		tag.getCompound("display").put("Name", displayName);
		return this;
	}

	public void removeDisplayName() {
		if (tag != null) {
			if (tag.hasOfType("display", 10)) {
				NBTTagCompound display = tag.getCompound("display");
				display.remove("Name");
				if (display.isEmpty()) {
					tag.remove("display");
					if (tag.isEmpty()) {
						setTag((NBTTagCompound) null);
					}
				}
			}
		}
	}

	public boolean hasDisplayName() {
		return tag == null ? false : (!tag.hasOfType("display", 10) ? false : tag.getCompound("display").hasOfType("Name", 8));
	}

	public class_abf u() {
		return getItem().g(this);
	}

	public boolean v() {
		return !getItem().f_(this) ? false : !hasEnchantments();
	}

	public void addEnchantment(class_adi enchantment, int level) {
		if (tag == null) {
			setTag(new NBTTagCompound());
		}

		if (!tag.hasOfType("ench", 9)) {
			tag.put("ench", (new NBTTagList()));
		}

		NBTTagList enchList = tag.getList("ench", 10);
		NBTTagCompound enchCompound = new NBTTagCompound();
		enchCompound.put("id", (short) class_adi.b(enchantment));
		enchCompound.put("lvl", (short) ((byte) level));
		enchList.add(enchCompound);
	}

	public boolean hasEnchantments() {
		return (tag != null) && tag.hasOfType("ench", 9);
	}

	public void addTag(String key, NBTTag newtag) {
		if (tag == null) {
			setTag(new NBTTagCompound());
		}
		tag.put(key, newtag);
	}

	public boolean x() {
		return getItem().s();
	}

	public boolean isInItemFrame() {
		return itemFrame != null;
	}

	public void setItemFrame(class_va var1) {
		itemFrame = var1;
	}

	public class_va getItemFrame() {
		return itemFrame;
	}

	public int getRepairCost() {
		return hasTag() && tag.hasOfType("RepairCost", 3) ? tag.getInt("RepairCost") : 0;
	}

	public void setRepairCost(int repaircost) {
		if (!hasTag()) {
			tag = new NBTTagCompound();
		}

		tag.put("RepairCost", repaircost);
	}

	public Multimap a(class_pw var1) {
		Object var2;
		if (hasTag() && tag.hasOfType("AttributeModifiers", 9)) {
			var2 = HashMultimap.create();
			NBTTagList var3 = tag.getList("AttributeModifiers", 10);

			for (int var4 = 0; var4 < var3.getSize(); ++var4) {
				NBTTagCompound var5 = var3.getCompound(var4);
				class_qm var6 = class_wl.a(var5);
				if ((var6 != null) && (var6.a().getLeastSignificantBits() != 0L) && (var6.a().getMostSignificantBits() != 0L)) {
					((Multimap) var2).put(var5.getString("AttributeName"), var6);
				}
			}
		} else {
			var2 = getItem().a(var1);
		}

		return (Multimap) var2;
	}

	public void a(Item var1) {
		item = var1;
	}

	public IChatBaseComponent B() {
		ChatComponentText var1 = new ChatComponentText(getDisplayName());
		if (hasDisplayName()) {
			var1.b().b(Boolean.valueOf(true));
		}

		IChatBaseComponent var2 = (new ChatComponentText("[")).a(var1).a("]");
		if (item != null) {
			NBTTagCompound var3 = new NBTTagCompound();
			this.write(var3);
			var2.b().a(new class_ew(class_ew.class_a_in_class_ew.c, new ChatComponentText(var3.toString())));
			var2.b().a(u().e);
		}

		return var2;
	}

	public boolean c(Block var1) {
		if (var1 == h) {
			return i;
		} else {
			h = var1;
			if (hasTag() && tag.hasOfType("CanDestroy", 9)) {
				NBTTagList var2 = tag.getList("CanDestroy", 8);

				for (int var3 = 0; var3 < var2.getSize(); ++var3) {
					Block var4 = Block.getByName(var2.getString(var3));
					if (var4 == var1) {
						i = true;
						return true;
					}
				}
			}

			i = false;
			return false;
		}
	}

	public boolean d(Block var1) {
		if (var1 == j) {
			return k;
		} else {
			j = var1;
			if (hasTag() && tag.hasOfType("CanPlaceOn", 9)) {
				NBTTagList var2 = tag.getList("CanPlaceOn", 8);

				for (int var3 = 0; var3 < var2.getSize(); ++var3) {
					Block var4 = Block.getByName(var2.getString(var3));
					if (var4 == var1) {
						k = true;
						return true;
					}
				}
			}

			k = false;
			return false;
		}
	}
}
