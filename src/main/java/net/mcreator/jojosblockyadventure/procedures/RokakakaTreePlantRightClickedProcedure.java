package net.mcreator.jojosblockyadventure.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.jojosblockyadventure.item.RokakakaFruitItem;
import net.mcreator.jojosblockyadventure.block.RokakakaTreeBlock;
import net.mcreator.jojosblockyadventure.JojosblockyadventureModElements;
import net.mcreator.jojosblockyadventure.JojosblockyadventureMod;

import java.util.Map;
import java.util.HashMap;

@JojosblockyadventureModElements.ModElement.Tag
public class RokakakaTreePlantRightClickedProcedure extends JojosblockyadventureModElements.ModElement {
	public RokakakaTreePlantRightClickedProcedure(JojosblockyadventureModElements instance) {
		super(instance, 12);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency x for procedure RokakakaTreePlantRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency y for procedure RokakakaTreePlantRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency z for procedure RokakakaTreePlantRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JojosblockyadventureMod.LOGGER.warn("Failed to load dependency world for procedure RokakakaTreePlantRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean when_right_clicked_drop_RokakakaFruit = false;
		double randomDrop = 0;
		randomDrop = (double) Math.random();
		if ((((randomDrop) >= 0.5) && ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RokakakaTreeBlock.block
				.getDefaultState().getBlock()))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
						new ItemStack(RokakakaFruitItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("direction", event.getFace());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
