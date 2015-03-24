package nl.Azhdev.LL.effects.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectReduceHealth extends GEffect implements IEffect {
	
	private int reduc;
	
	public EffectReduceHealth(int reduction, String name) {
		super();
		setName("ReduceHealth " + name);
		reduc = reduction;
	}
	
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		if(player.getHealth() >= reduc){
			player.setHealth(player.getHealth() - reduc);
		}else{
			player.setHealth(0);
		}
	}
}
