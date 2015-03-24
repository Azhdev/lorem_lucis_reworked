package nl.Azhdev.LL.blocks.TileEntities;

import java.util.Random;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import nl.Azhdev.core.api.packet.NetworkHandler;
import nl.Azhdev.core.api.packet.PacketPlaySound;

public class TileEntitySpinny extends TileEntity implements IUpdatePlayerListBox{

	private float rotation;
	private float bobpos;

	@Override
	public void update(){
		if(worldObj.isRemote){
			rotation += 0.01F;
			bobpos += 0.02F;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
	}
	
	public float getRotation() {
		return rotation;
	}

	public float getBobPos() {
		return -4 -Math.abs((float)Math.sin(bobpos) * 5.5F);
	}
}
