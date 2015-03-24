package nl.Azhdev.LL.effects.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectAddXP extends GEffect implements IEffect {

	int amount;
	String type;
	
	/**
	 * 
	 * @param lvlorloose	add levels or loose xp? ("lvl" for levels, "loose" for loose xp)
	 * @param amount		the amount of xp or levels to add
	 * @param name			the name of the effect
	 */
	public EffectAddXP(String lvlorloose, int amountn, String name) {
		super();
		setName("Experience " + name);
		this.amount = amountn;
	}
	
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		if(type == "lvl"){
			player.addExperienceLevel(amount);
		}else if(type == "loose"){
			player.addExperience(amount);
		}
	}
}
