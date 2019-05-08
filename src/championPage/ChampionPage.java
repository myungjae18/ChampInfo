package championPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import infoPage.InfoMain;
import javafx.scene.input.ScrollEvent.VerticalTextScrollUnits;
import main.Main;
import util.ChampionsList;

public class ChampionPage extends JPanel{
	Main main;
	ChampionsList list;
	InfoMain infoMain;
	
	private JPanel p_title, p_con; //구역 구분 배열
	private JScrollPane scroll;
	private JPanel p_center; //JLabel을 담을 패널
	private JPanel p_emptyTop, p_emptyBottom, p_emptyLeft, p_emptyRight; //빈 공간 패널
	private JLabel title; //제목
	
	private static final int CHAMPEA=134;
	private ImageIcon[] icon=new ImageIcon[CHAMPEA];
		
	public ChampionPage() {		
		//인스턴스 생성
		p_title=new JPanel();
		p_con=new JPanel();
		//-----------------------------------------------
		p_center=new JPanel();
		//-----------------------------------------------
		p_emptyTop=new JPanel();
		p_emptyBottom=new JPanel();
		p_emptyLeft=new JPanel();
		p_emptyRight=new JPanel();
		//-----------------------------------------------
		title=new JLabel("Select Champion");
		scroll=new JScrollPane(p_con, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				
		//title 설정
		title.setForeground(Color.YELLOW); //글씨 색 설정		
		
		//구역 구분 패널 설정
		p_title.setBackground(Color.BLACK);
		p_title.add(title);
		//-----------------------------------------------
		p_con.setLayout(new BorderLayout());
		p_con.add(p_emptyLeft, BorderLayout.WEST);
		p_con.add(p_center, BorderLayout.CENTER);
		p_con.add(p_emptyTop, BorderLayout.NORTH);
		p_con.add(p_emptyRight, BorderLayout.EAST);
		p_con.add(p_emptyBottom, BorderLayout.SOUTH);
		
		//나머지 패널 설정
		p_emptyLeft.setBackground(Color.BLACK);
		p_center.setBackground(Color.BLACK);
		p_center.setPreferredSize(new Dimension(scroll.getWidth(), 2850));
		p_emptyTop.setBackground(Color.BLACK);
		p_emptyRight.setBackground(Color.BLACK);
		p_emptyBottom.setBackground(Color.BLACK);
		
		for (int i = 0; i < CHAMPEA; i++) {
			JLabel label=new JLabel();
			list=new ChampionsList();
			String[] champName=list.getName();
			label.setName(champName[i]);
			//labelName[i]=label[i].getName();
			icon[i]=new ImageIcon("D:/Java_developer/javaSE/MyProject/res/champion"+(i+1)+".png");
			label.setIcon(icon[i]);
			label.setPreferredSize(new Dimension(100, 100));
			label.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int count=e.getClickCount();
					System.out.println(label.getName()+"클릭한 라벨은");
					if(label.getName()!=null) {
						showPage(label.getName(), count);
					}else {
						return;
					}	
				}
			});
			p_center.add(label);
		}
		
		//Container 패널 설정
		setLayout(new BorderLayout());
		add(p_title, BorderLayout.NORTH);
		add(scroll);

		setVisible(true);
	}
	
	public void showPage(String labelName, int clickCount) {
		System.out.println(labelName+"showPage");
		System.out.println(clickCount);
		infoMain=new InfoMain(labelName, clickCount);
	}
}
