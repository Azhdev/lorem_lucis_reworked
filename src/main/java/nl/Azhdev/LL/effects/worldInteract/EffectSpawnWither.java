package nl.Azhdev.LL.effects.worldInteract;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectSpawnWither extends GEffect implements IEffect {
	
	public EffectSpawnWither(){
		super();
		setName("Spawn wither");
	}
	
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		EntityWither wither = new EntityWither(world);
		wither.setPosition(pos.getX(), pos.getY() + 5, pos.getZ());
		world.spawnEntityInWorld(wither);
	}
}
