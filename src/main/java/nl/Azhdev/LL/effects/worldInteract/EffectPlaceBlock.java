package nl.Azhdev.LL.effects.worldInteract;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;

public class EffectPlaceBlock extends GEffect implements IEffect {
	
	private Block[] block;
	private BlockPos[] position;
	private BlockState[] state;
	
	
	/**
	 * 
	 * @param block		the block you want to spawn (it will grab the default state, if you want to use different states see bottom constructor)
	 * @param name		the name of the effect
	 */
	public EffectPlaceBlock(Block block, String name){
		super();
		setName("placeBlock " + name);
		this.block = new Block[1];
		this.block[0] = block;
		this.position = new BlockPos[1];
		position[0] = new BlockPos(0, 2, 0);
	}
	
	/**
	 * 
	 * @param block 	the block you want to spawn (it will grab the default state, if you want to use different states see constructor below)
	 * @param pos		the position you want the block to spawn RELATIVE to the spinny block (that's the bottom one) 
	 * @param name		the name of the effect
	 */
	public EffectPlaceBlock(Block block, BlockPos pos, String name) {
		super();
		setName("placeBlock " + name);
		this.block = new Block[1];
		this.block[0] = block;
		this.position = new BlockPos[1];
		this.position[0] = pos;
	}
	/**
	 * 
	 * @param state		the blockstate you want to place (MUST IMPLEMENT IBlockState!!!)
	 * @param pos		the position you want the block to spawn RELATIVE to the spinny block (that's the bottom one) 
	 * @param name		the name of the effect
	 */
	public EffectPlaceBlock(BlockState state, BlockPos pos, String name){
		super();
		setName("placeBlock " + name);
		this.state = new BlockState[1];
		this.state[0] = state;
		this.position = new BlockPos[1];
		this.position[0] = pos;
	}
	
	
	/**
	 * 
	 * @param blocks	the arraylist of the blocks you want to place (it will grab the default state)
	 * @param pos		the arraylist of positions you want want the blocks to spawn RELATIVE to the spinny block (that's the bottom one) 
	 * @param name		the name of the effect
	 */
	public EffectPlaceBlock(Block[] blocks, BlockPos[] pos, String name){
		if(blocks.length == pos.length){
			this.block = blocks;
			this.position = pos;
		}
	}
	
	@Override
	public void handleServerSide(World world, EntityPlayer player, BlockPos pos){
		if(state != null){
			for(int i = 0; i > position.length; i++){
				world.setBlockState(new BlockPos(pos.getX() + position[i].getX(), pos.getY() + position[i].getY(), pos.getZ() + position[i].getZ()), (IBlockState) state[i]);
			}
			
		}else{
			for(int x = 0; x > position.length; x++){
				world.setBlockState(new BlockPos(pos.getX() + position[x].getX(), pos.getY() + position[x].getY(), pos.getZ() + position[x].getZ()), block[x].getDefaultState());
			}
			
		}
	}
}
