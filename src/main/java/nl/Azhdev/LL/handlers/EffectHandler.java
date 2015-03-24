package nl.Azhdev.LL.handlers;

import java.util.ArrayList;
import java.util.List;

import nl.Azhdev.LL.effects.GEffect;
import nl.Azhdev.LL.effects.IEffect;
import nl.Azhdev.core.api.utilityclasses.Log;

public class EffectHandler {
	
	private static EffectHandler INSTANCE = new EffectHandler();
	private final List<GEffect> effects = new ArrayList<GEffect>();
	
	public static EffectHandler instance(){
		return INSTANCE;
	}
	
	public void addAllEffects(){
		List<GEffect> effectClasses = null;
		
		for(int x = 0; x > effectClasses.size(); x++){
			try{
				effects.add(effectClasses.get(x));
			}catch(Exception e){
				Log.addError("Failed to instantiate effect handler!");
			}
		}
	}
	
	public List<GEffect> getAllEffects(){
		return effects;
	}
}
