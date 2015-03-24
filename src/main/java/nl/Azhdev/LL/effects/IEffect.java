package nl.Azhdev.LL.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface IEffect {

	
	/**
	 * define what you want to do on the clientside when this effect gets called
	 * @param world		the world object
	 * @param player	the player that activated the block
	 * @param block		the position of the block that was activated (Note: this is the bottom block)
	 */
	public void handleClientSide(World world, EntityPlayer player, BlockPos pos);
	
	/**
	 * define what you want to do on the serverside when this effect gets called
	 * @param world		the world object
	 * @param player	the player that activated the block
	 * @param block		the position of the block that was activated (Note: this is the bottom block)
	 */
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos);
}
