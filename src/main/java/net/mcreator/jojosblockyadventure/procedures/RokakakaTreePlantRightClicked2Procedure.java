package net.mcreator.jojosblockyadventure.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.jojosblockyadventure.JojosblockyadventureModElements;

import java.util.Map;
import java.util.HashMap;

@JojosblockyadventureModElements.ModElement.Tag
public class RokakakaTreePlantRightClicked2Procedure extends JojosblockyadventureModElements.ModElement {
	public RokakakaTreePlantRightClicked2Procedure(JojosblockyadventureModElements instance) {
		super(instance, 13);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		boolean DestroyBlock = false;
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
