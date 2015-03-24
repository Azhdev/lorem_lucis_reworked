package nl.Azhdev.LL.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * the generic potioneffect class
 * 
 * @author Azhdev
 *
 */
public class GPotionEffect extends GEffect implements IEffect {

	private int[] potionNumber;
	private int[] time;
	
	/**
	 * 
	 * @param pn the number of the potion effect you want in an integer array
	 * @param t  the amount of ticks you want the potion to last in an integer array
	 */
	public GPotionEffect(int[] pn, int[] t){
		potionNumber = pn;
		time = t;
	}
	
	/**
	 * 
	 * @param pn1 the number of the potion effect you want
	 * @param t1  the number of ticks you want the potion to last
	 */
	public GPotionEffect(int pn1, int t1){
		potionNumber[0] = pn1;
		time[0] = t1;
	}
	
	@Override
	public void handleClientSide(World world, EntityPlayer player, BlockPos pos) {

	}

	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		if(potionNumber.length == time.length){
			for(int i = 0; i > time.length; i++){
				player.addPotionEffect(new PotionEffect(potionNumber[i], time[i]));
			}
		}
	}

}
