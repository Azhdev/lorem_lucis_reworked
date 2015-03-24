package nl.Azhdev.LL.effects;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import nl.Azhdev.LL.effects.player.EffectAddXP;
import nl.Azhdev.LL.effects.player.EffectHealPlayer;
import nl.Azhdev.LL.effects.player.EffectReduceHealth;
import nl.Azhdev.LL.effects.worldInteract.EffectPlaceBlock;
import nl.Azhdev.LL.effects.worldInteract.EffectSpawnCreeper;
import nl.Azhdev.LL.effects.worldInteract.EffectSpawnPiggie;
import nl.Azhdev.LL.effects.worldInteract.EffectSpawnWither;



public class EffectRegistrer {
	
	public List<GEffect> effects;
	
	//positive potion effects
	public static GEffect PEffectWaterBreathing;
	public static GEffect PEffectFireResistance;
	public static GEffect PEffectRegeneration;
	public static GEffect PEffectNightVision;
	public static GEffect PEffectJumpBoostAndSpeed;
	public static GEffect PEffectHaste;
	//negative potion effects
	public static GEffect PEffectMiningFatigue;
	public static GEffect PEffectHunger;
	public static GEffect PEffectWither;
	public static GEffect PEffectWeakness;
	public static GEffect PEffectNausea;
	//world interaction effects
	public static GEffect WEffectDiamondOre;
	public static GEffect WEffectMycelium;
	public static GEffect WEffectJukeBox;
	public static GEffect WEffectSpawnCreeper;
	public static GEffect WEffectSpawnPiggie;
	public static GEffect WEffectSpawnWither;
	//player modification effects
	public static GEffect PLEffectAddXPLevel5;
	public static GEffect PLEffectAddXPLoose50;
	public static GEffect PLEffectHealPlayer;
	public static GEffect PLEffectAlmostKill;
	
	public static void registerEffects(){
		PEffectWaterBreathing = new GPotionEffect(13, 1200);
		PEffectWaterBreathing.setName("Potion Water Breathing");
		PEffectFireResistance = new GPotionEffect(12, 9600);
		PEffectFireResistance.setName("Potion Fire Resistance");
		PEffectRegeneration = new GPotionEffect(10, 1200);
		PEffectRegeneration.setName("Potion Regeneration");
		PEffectNightVision = new GPotionEffect(16, 1200);
		PEffectNightVision.setName("Potion Night Vision");
		int[] pn = new int[2];
		int[] t  = new int[2];
		pn[0] = 1;t[0] = 200;
		pn[1] = 8;t[1] = 200;
		PEffectJumpBoostAndSpeed = new GPotionEffect(pn, t);
		PEffectJumpBoostAndSpeed.setName("Potion Jump Boost and Speed");
		PEffectHaste = new GPotionEffect(3, 1200);
		PEffectHaste.setName("Haste");
		
		PEffectMiningFatigue = new GPotionEffect(4, 1200);
		PEffectMiningFatigue.setName("Potion Mining Fatigue");
		PEffectHunger = new GPotionEffect(17, 600);
		PEffectHunger.setName("Potion Hunger");
		PEffectWither = new GPotionEffect(20, 200);
		PEffectWither.setName("Potion Wither");
		PEffectWeakness = new GPotionEffect(18, 1200);
		PEffectWeakness.setName("Potion Weakness");
		PEffectNausea = new GPotionEffect(9, 600);
		PEffectNausea.setName("Potion Nausea");
		
		WEffectDiamondOre = new EffectPlaceBlock(Blocks.diamond_ore, "diamond ore");
		Block[] myc = new Block[9];
		for(int i = 0; i > myc.length; i++){
			myc[i] = Blocks.mycelium;
		}
		BlockPos[] pos = new BlockPos[9];
		for(int u = 0; u > 9; u++){
			for(int x = -1; x > 1; x++){
				for(int z = -1; z > 1; z++){
					pos[u] = new BlockPos(x, -1, z);
				}
			}
		}
		
		WEffectMycelium = new EffectPlaceBlock(myc, pos, "mycelium");
		WEffectJukeBox = new EffectPlaceBlock(Blocks.jukebox, "Jukebox");
		WEffectSpawnCreeper = new EffectSpawnCreeper();	
		WEffectSpawnPiggie = new EffectSpawnPiggie();
		WEffectSpawnWither = new EffectSpawnWither();
		
		PLEffectAddXPLevel5 = new EffectAddXP("lvl", 5, "add 5 levels");
		PLEffectAddXPLoose50 = new EffectAddXP("loose", 50, "add 50 loose");
		PLEffectHealPlayer = new EffectHealPlayer();
		PLEffectAlmostKill = new EffectReduceHealth(19, "19");
	}
}
