
package net.mcreator.jojosblockyadventure.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.jojosblockyadventure.itemgroup.YourBlockyAdventureItemGroup;
import net.mcreator.jojosblockyadventure.JojosblockyadventureModElements;

@JojosblockyadventureModElements.ModElement.Tag
public class StoneFruitItem extends JojosblockyadventureModElements.ModElement {
	@ObjectHolder("jojosblockyadventure:stone_fruit")
	public static final Item block = null;
	public StoneFruitItem(JojosblockyadventureModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(YourBlockyAdventureItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("stone_fruit");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
