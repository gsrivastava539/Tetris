package Tetris;

import java.awt.Choice;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Config {

	public static String rotate, left, right, down, pause;
	private static ArrayList<Choice> choices;
	
	public static void openConfig(JFrame frame){
		choices = new ArrayList<Choice>();
		JFrame options = new JFrame("Options");
		options.setSize(400, 300);
		options.setResizable(false);
		options.setLocationRelativeTo(frame);
		options.setVisible(true);
		addChoice(left, options, 30, 10);
		options.setLayout(null);
	}
	
	public static void addChoice(String name, JFrame options, int x, int y){
		JLabel label = new JLabel();
		label.setBounds(x, y-20, 100, 20);
		Choice key = new Choice();
		for(String s: getKeyNames()){
			key.add(s);
		}
		key.setBounds(x, y, 100, 20);
		options.add(key);
		options.add(label);
		choices.add(key);
	}
	
	public static ArrayList<String> getKeyNames(){
		ArrayList<String> results = new ArrayList<String>();
		for(String s: KeyGetter.keys.keySet()){
			results.add(s);
			if (s.equalsIgnoreCase("RIGHT")) {
				break;
			}
		}
		return results;
	}
}
