package Game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
	//Buttons are defined here by Y, X
	JButton button00;
	JButton button01;
	JButton button02;
	JButton button03;
	JButton button04;
	JButton button05;
	JButton button06;
	JButton button07;
	
	JButton button10;
	JButton button11;
	JButton button12;
	JButton button13;
	JButton button14;
	JButton button15;
	JButton button16;
	JButton button17;
	
	JButton button20;
	JButton button21;
	JButton button22;
	JButton button23;
	JButton button24;
	JButton button25;
	JButton button26;
	JButton button27;
	
	JButton button30;
	JButton button31;
	JButton button32;
	JButton button33;
	JButton button34;
	JButton button35;
	JButton button36;
	JButton button37;
	
	JButton button40;
	JButton button41;
	JButton button42;
	JButton button43;
	JButton button44;
	JButton button45;
	JButton button46;
	JButton button47;
	
	JButton button50;
	JButton button51;
	JButton button52;
	JButton button53;
	JButton button54;
	JButton button55;
	JButton button56;
	JButton button57;
	
	JButton button60;
	JButton button61;
	JButton button62;
	JButton button63;
	JButton button64;
	JButton button65;
	JButton button66;
	JButton button67;
	
	JButton button70;
	JButton button71;
	JButton button72;
	JButton button73;
	JButton button74;
	JButton button75;
	JButton button76;
	JButton button77;
	
	
	
	
	GameWindow() {
		//once one button clicked change a boolean firstSquareSelected to true then next button press attempt to call move piece
		//images were cropped to 55by55
		
		//Set icons
		ImageIcon bRWS = new ImageIcon("blackRookWhiteSquare.png");
		ImageIcon bNBS = new ImageIcon("blackKnightBlackSquare.png");
		ImageIcon bBWS = new ImageIcon("blackBishopWhiteSquare.png");
		ImageIcon bQBS = new ImageIcon("blackQueenBlackSquare.png");
		
		//Set Window size
		this.setLayout(new GridLayout(8,8));
		this.setResizable(false);
		this.setTitle("Chess Game");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialize Buttons
		button00 = new JButton();
		button01 = new JButton();
		button02 = new JButton();
		button03 = new JButton();
		button04 = new JButton();
		button05 = new JButton();
		button06 = new JButton();
		button07 = new JButton();
		
		button10 = new JButton();
		button11 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		button14 = new JButton();
		button15 = new JButton();
		button16 = new JButton();
		button17 = new JButton();
		
		button20 = new JButton();
		button21 = new JButton();
		button22 = new JButton();
		button23 = new JButton();
		button24 = new JButton();
		button25 = new JButton();
		button26 = new JButton();
		button27 = new JButton();
		
		button30 = new JButton();
		button31 = new JButton();
		button32 = new JButton();
		button33 = new JButton();
		button34 = new JButton();
		button35 = new JButton();
		button36 = new JButton();
		button37 = new JButton();
		
		button40 = new JButton();
		button41 = new JButton();
		button42 = new JButton();
		button43 = new JButton();
		button44 = new JButton();
		button45 = new JButton();
		button46 = new JButton();
		button47 = new JButton();
		
		button50 = new JButton();
		button51 = new JButton();
		button52 = new JButton();
		button53 = new JButton();
		button54 = new JButton();
		button55 = new JButton();
		button56 = new JButton();
		button57 = new JButton();
		
		button60 = new JButton();
		button61 = new JButton();
		button62 = new JButton();
		button63 = new JButton();
		button64 = new JButton();
		button65 = new JButton();
		button66 = new JButton();
		button67 = new JButton();
		
		button70 = new JButton();
		button71 = new JButton();
		button72 = new JButton();
		button73 = new JButton();
		button74 = new JButton();
		button75 = new JButton();
		button76 = new JButton();
		button77 = new JButton();
		
		//button00.setBounds(0, 0, 55, 55);
		button00.addActionListener(e -> System.out.println("Clicked 00"));
		
		//Set initial icons
		button00.setIcon(bRWS);
		button01.setIcon(bNBS);
		button02.setIcon(bBWS);
		
		//Add all Buttons to JFrame
		this.add(button00);
		this.add(button01);
		this.add(button02);
		this.add(button03);
		this.add(button04);
		this.add(button05);
		this.add(button06);
		this.add(button07);
		
		this.add(button10);
		this.add(button11);
		this.add(button12);
		this.add(button13);
		this.add(button14);
		this.add(button15);
		this.add(button16);
		this.add(button17);
		
		this.add(button20);
		this.add(button21);
		this.add(button22);
		this.add(button23);
		this.add(button24);
		this.add(button25);
		this.add(button26);
		this.add(button27);
		
		this.add(button30);
		this.add(button31);
		this.add(button32);
		this.add(button33);
		this.add(button34);
		this.add(button35);
		this.add(button36);
		this.add(button37);
		
		this.add(button40);
		this.add(button41);
		this.add(button42);
		this.add(button43);
		this.add(button44);
		this.add(button45);
		this.add(button46);
		this.add(button47);
		
		this.add(button50);
		this.add(button51);
		this.add(button52);
		this.add(button53);
		this.add(button54);
		this.add(button55);
		this.add(button56);
		this.add(button57);
		
		this.add(button60);
		this.add(button61);
		this.add(button62);
		this.add(button63);
		this.add(button64);
		this.add(button65);
		this.add(button66);
		this.add(button67);
		
		this.add(button70);
		this.add(button71);
		this.add(button72);
		this.add(button73);
		this.add(button74);
		this.add(button75);
		this.add(button76);
		this.add(button77);
		
		//ImageIcon chessLogo = new ImageIcon("chesslogo.jpeg");
		//this.setIconImage(chessLogo.getImage());
		//JFrame window  = new JFrame();
		//window.setResizable(false);
		//window.setLayout(new GridLayout());
		//this.setLayout(null);
		//button00.addActionListener(e -> System.out.println("Button 00"));
		
		//Visualize completed JFrame window
		this.setVisible(true);
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
