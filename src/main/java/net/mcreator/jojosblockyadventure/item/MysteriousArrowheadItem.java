
package net.mcreator.jojosblockyadventure.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.jojosblockyadventure.itemgroup.YourBlockyAdventureItemGroup;
import net.mcreator.jojosblockyadventure.JojosblockyadventureModElements;

@JojosblockyadventureModElements.ModElement.Tag
public class MysteriousArrowheadItem extends JojosblockyadventureModElements.ModElement {
	@ObjectHolder("jojosblockyadventure:mysterious_arrowhead")
	public static final Item block = null;
	public MysteriousArrowheadItem(JojosblockyadventureModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(YourBlockyAdventureItemGroup.tab).maxStackSize(16).isImmuneToFire().rarity(Rarity.UNCOMMON));
			setRegistryName("mysterious_arrowhead");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
