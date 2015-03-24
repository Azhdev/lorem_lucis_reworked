package nl.Azhdev.LL.effects.worldInteract;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectSpawnCreeper extends GEffect implements IEffect {

	public EffectSpawnCreeper(){
		super();
		setName("World Spawn creeper");
	}
		
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		EntityCreeper creeper = new EntityCreeper(world);
		creeper.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		world.spawnEntityInWorld(creeper);
	}
}
