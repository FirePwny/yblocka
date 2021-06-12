
package net.mcreator.jojosblockyadventure.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.jojosblockyadventure.item.MysteriousArrowheadItem;
import net.mcreator.jojosblockyadventure.JojosblockyadventureModElements;

@JojosblockyadventureModElements.ModElement.Tag
public class YourBlockyAdventureItemGroup extends JojosblockyadventureModElements.ModElement {
	public YourBlockyAdventureItemGroup(JojosblockyadventureModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabyour_blocky_adventure") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MysteriousArrowheadItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
