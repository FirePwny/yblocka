package net.mcreator.jojosblockyadventure.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.jojosblockyadventure.block.RokakakaTreeBlock;
import net.mcreator.jojosblockyadventure.JojosblockyadventureModElements;
import net.mcreator.jojosblockyadventure.JojosblockyadventureMod;

import java.util.Map;

@JojosblockyadventureModElements.ModElement.Tag
public class RokakakaFruitspawnProcedure extends JojosblockyadventureModElements.ModElement {
	public RokakakaFruitspawnProcedure(JojosblockyadventureModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency x for procedure RokakakaFruitspawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency y for procedure RokakakaFruitspawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency z for procedure RokakakaFruitspawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency world for procedure RokakakaFruitspawn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Blocks.GRASS_BLOCK.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 0), (int) z), RokakakaTreeBlock.block.getDefaultState(), 3);
		}
	}
}
