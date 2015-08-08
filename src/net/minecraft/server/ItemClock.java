package net.minecraft.server;

public class ItemClock extends Item {
   public ItemClock() {
      this.registerItemState(new MinecraftKey("time"), new ItemState() {
      });
   }
}
