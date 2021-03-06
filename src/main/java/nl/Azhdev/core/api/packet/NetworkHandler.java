package nl.Azhdev.core.api.packet;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("AzhdevCore");
	private static int variable;
	
	public static void init(){
		INSTANCE.registerMessage(PacketPlaySound.class, PacketPlaySound.class, variable++, Side.CLIENT);
		INSTANCE.registerMessage(MessageKeyPressed.class, MessageKeyPressed.class, variable++, Side.SERVER);
	}
	
	public static void sendToAll(IMessage message){
		INSTANCE.sendToAll(message);
	}
	
	public static void sendTo(IMessage message, EntityPlayerMP player){
		INSTANCE.sendTo(message, player);
	}
	
	public static void sendToAllAround(@SuppressWarnings("rawtypes") LocationIntPacket message, World world, double distance){
		sendToAllAround(message, message.getTargetPoint(world, distance));
	}
	
	public static void sendToAllAround(@SuppressWarnings("rawtypes") LocationIntPacket message, World world){
		sendToAllAround(message, message.getTargetPoint(world));
	}
	
	public static void sendToAllAround(@SuppressWarnings("rawtypes") LocationDoublePacket message, World world){
		sendToAllAround(message, message.getTargetPoint(world));
	}
	
	public static void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point){
        INSTANCE.sendToAllAround(message, point);
    }
	
	public static void sendToDimension(IMessage message, int dimensionId){
        INSTANCE.sendToDimension(message, dimensionId);
    }
	
	public static void sendToServer(IMessage message){
        INSTANCE.sendToServer(message);
    }
}
