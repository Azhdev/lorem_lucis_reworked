package nl.Azhdev.LL.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.Azhdev.LL.blocks.TileEntities.TileEntitySpinny;
import nl.Azhdev.LL.init.LLBlocks;
import nl.Azhdev.LL.init.LLItems;
import nl.Azhdev.core.api.packet.NetworkHandler;
import nl.Azhdev.core.api.packet.PacketPlaySound;

import java.util.Random;

public class blockSpinny extends SourceBlock implements ITileEntityProvider{

	public blockSpinny(Material mat) {
		super(mat);
		setUnlocalizedName("spinny");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySpinny();
	}
	
	@Override
	public boolean isNormalCube(){
		return false;
	}
	
	
	public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), LLBlocks.invisiBlock.getDefaultState());
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		return true;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity ent){
		if(ent instanceof EntityArrow){
			if(ent.isBurning()){
				world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4F, true);
			}
		}
	}
	 
	@Override
	public Item getItemDropped(IBlockState state, Random random, int j){
		return null;
	}
	
	@Override
	public boolean isOpaqueCube(){
        return false;
    }

    @Override
	public int getRenderType(){
        return -1;
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(World world, BlockPos pos, net.minecraft.client.particle.EffectRenderer effectRenderer){
		NetworkHandler.INSTANCE.sendToAll(new PacketPlaySound(this.stepSound.getBreakSound(), pos.getX(), pos.getY(), pos.getZ(), 1, 1, world));
		return true;
    }
}
