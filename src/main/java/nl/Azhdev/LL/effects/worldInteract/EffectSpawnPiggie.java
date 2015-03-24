package nl.Azhdev.LL.effects.worldInteract;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectSpawnPiggie extends GEffect implements IEffect {
	
	
	public EffectSpawnPiggie(){
		super();
		setName("World Spawn pig");
	}
	
	@Override
	public void handleClientSide(World world, EntityPlayer player, BlockPos pos) {}
	
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		EntityPig pig = new EntityPig(world);
		pig.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
		world.spawnEntityInWorld(pig);
	}
}
