package nl.Azhdev.LL.effects.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectHealPlayer extends GEffect implements IEffect {
	
	public EffectHealPlayer() {
		super();
		setName("Player heal player");
	}
	
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		if(player.getHealth() <= 15){
			player.setHealth(16);
		}else if(player.getHealth() >= 16){
			player.setHealth(20);
		}
	}
}
