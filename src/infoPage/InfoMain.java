package infoPage;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class InfoMain extends JFrame{
	InfoPage infoPage;
	
	int clickCount;
	
	public InfoMain(String labelName, int clickCount) {
		super("LOL Champion Information");
		this.clickCount=clickCount;
		
		infoPage=new InfoPage(labelName, clickCount);
		if(clickCount==1) {
			System.out.println("ÇÑ¹ø ´­·¶¾î");
			add(infoPage);
		}else {
			infoPage.repaint();
		}		
		
		ImageIcon icon=new ImageIcon("D:/Java_developer/javaSE/MyProject/res/icon.png");
		Image imgIcon=icon.getImage();
		setIconImage(imgIcon);
		
		setResizable(false);
		setVisible(true);
		setBounds(900, 100, 600, 500);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
}
