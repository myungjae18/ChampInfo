package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import championPage.ChampionPage;

public class Main extends JFrame{
	ChampionPage championPage;
	
	public Main() {
		super("LOL Champions List");
		championPage=new ChampionPage();
		//Mainframe ¼³Á¤
		add(championPage);
		
		ImageIcon icon=new ImageIcon("D:/Java_developer/javaSE/MyProject/res/icon.png");
		Image imgIcon=icon.getImage();
		setIconImage(imgIcon);
		
		setBounds(300, 100, 600, 900);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
