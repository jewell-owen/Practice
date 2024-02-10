package Game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
	//Buttons are defined here by X,Y for simplicity
	JButton button00;
	JButton button01;
	JButton button02;
	JButton button03;
	JButton button04;
	JButton button05;
	JButton button06;
	JButton button07;
	
	
	GameWindow() {
		//once one button clicked change a boolean firstSquareSelected to true then next button press attempt to call move piece
		//images were cropped to 55by55
		ImageIcon bRWS = new ImageIcon("blackRookWhiteSquare.png");
		
		button00 = new JButton();
		button00.setBounds(0, 0, 55, 55);
		button00.addActionListener(e -> System.out.println("Clicked"));
		button00.setIcon(bRWS);
		
		this.setTitle("Chess Game");
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.add(button00);
		
		//ImageIcon chessLogo = new ImageIcon("chesslogo.jpeg");
		//this.setIconImage(chessLogo.getImage());
		//JFrame window  = new JFrame();
		//window.setResizable(false);
		//window.setLayout(new GridLayout());
		
		
		
		//button00.addActionListener(e -> System.out.println("Button 00"));
		
		
	}

	public static void main(String[] args) {
		GameWindow test = new GameWindow();
	}
	
//	@Override	(Class must implement ActionListener to use)
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == button00) {
//			System.out.println("Button Clicked");
//		}
//		
//	}
}
