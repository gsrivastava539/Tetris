package Tetris;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class KeyGetter {

	private static HashMap<Integer, String> keys;
	
	public static void loadkeys(){
		keys = new HashMap<Integer, String>();
		Field[] fields = KeyEvent.class.getFields();
		for(Field f: fields){
			if(Modifier.isStatic(f.getModifiers())){
				if(f.getName().startsWith("VK"));
				System.out.println(f);
			}
		}
	}
	
}
