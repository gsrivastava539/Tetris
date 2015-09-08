package Tetris;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class KeyGetter {

	public static HashMap<String, Integer> keys;
	
	public static void loadkeys(){
		keys = new HashMap<String, Integer>();
		Field[] fields = KeyEvent.class.getFields();
		for(Field f: fields){
			if(Modifier.isStatic(f.getModifiers())){
				if(f.getName().startsWith("VK")){
					try {
						int num = f.getInt(null);
						String name = KeyEvent.getKeyText(num);
						keys.put(name, num);
						System.out.println(name);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	
}
