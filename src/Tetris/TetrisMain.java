package Tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.renderable.RenderableImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Contrl+Shif+O imports the classes

public class TetrisMain extends Canvas implements Runnable, KeyListener {

	
	public static final int WIDTH = 400, HEIGHT = 565;
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Swati's Tetris Game");
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		
		KeyGetter.loadkeys();
		
		
		JMenuBar bar = new JMenuBar();
		bar.setBounds(0, 0, WIDTH, 25);
		
		JMenu file = new JMenu("File");
		file.setBounds(0, 0, 45, 24);
		
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Starting new game");
			}
		});
		
		JMenuItem highScore = new JMenuItem("HighScore");
		highScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int highcore = 0; // repalce this with getHihjscore method
				final JFrame alert = new JFrame("High Score");
				alert.setSize(200, 150);
				alert.setLayout(null);
				alert.setLocationRelativeTo(null);
				alert.setAlwaysOnTop(true);
								
				JLabel score = new JLabel("The Highest Score is: " + highcore);
				score.setBounds(0, 0, 200, 50);
				JButton okayButton = new JButton("okay");
				okayButton.setBounds(50, 80, 100, 30);
				okayButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						alert.dispose();
					}
				});
				alert.add(score);
				alert.add(okayButton);
				alert.setResizable(false);
				alert.setVisible(true);
				
			}
		});
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Closing");
				System.exit(0);
			}
		});
		
		
		JMenuItem options = new JMenuItem("Options");
		options.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Config.openConfig(frame);
			}
			
		});
		
		TetrisMain tm = new TetrisMain();
		tm.setBounds(0, 25, WIDTH, HEIGHT - 25);
		
		
		frame.add(tm);
		file.add(newGame);
		file.add(highScore);
		file.add(options);
		file.add(exit);
		frame.add(bar);
		bar.add(file);
		frame.setVisible(true);
		tm.start();

	}

	public void start(){
		Thread t = new Thread(this);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		
	}
	
	
	public void run(){
		boolean running = true;
		while(running){
			update();
			BufferStrategy buf = getBufferStrategy();
			if(buf == null){
				createBufferStrategy(3);
				continue;
			}
			Graphics2D g = (Graphics2D) buf.getDrawGraphics();
			render(g);
			buf.show();
		}
		
		
	}
	
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Calibri", Font.BOLD, 21));
		g.drawString("Max", 170, 100);
	}

	
	public void init(){
		
	}
	
	
	public void update(){
		
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	
	public void keyReleased(KeyEvent e){
		
	}
	
}
