package net.minecraft.server;

public class ItemCompass extends Item {
   public ItemCompass() {
      this.registerItemState(new MinecraftKey("angle"), new ItemState() {
      });
   }
}
