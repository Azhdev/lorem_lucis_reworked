package nl.Azhdev.LL.effects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class GEffect implements IEffect {

	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void handleClientSide(World world, EntityPlayer player, BlockPos pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos) {
		// TODO Auto-generated method stub

	}

}
