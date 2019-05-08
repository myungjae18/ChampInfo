package infoPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import util.ChampionsList;

public class InfoPage extends JPanel{
	private int width=600;
	private int height=400;
	
	ChampionsList list;
	String labelName;
	int clickCount;
	
	private JPanel p_left, p_right; //��ü�� �¿�� �����ϴ� �г�
	private JPanel p_left_profile, p_left_txt; //���� �г��� ��ɿ� ���� �ٽ� ����
	private JPanel p_left_txt_left, p_left_txt_right; //������ �ؽ�Ʈ �κ� �г��� �¿�� ����
	private JPanel p_right_top, p_right_mid, p_right_bottom, p_right_left, p_right_right; //���� �г��� ��ɿ� ���� ���� �� �Ʒ� �г��� �¿�� ����
	private JLabel la_profile; //è�Ǿ� �ʻ�ȭ�� ���� ��
	private JLabel la_name, la_title, la_type; //�ؽ�Ʈ �κ� �г��� ���� ��
	private JLabel la_jsonName, la_jsonTag, la_jsonTitle; //�ؽ�Ʈ �κ� �г��� ������ ��
	private JLabel la_stat; //
	private JLabel la_JsonEx;
	private JLabel la_hp, la_hpperlevel, la_mp, la_mpperlevel;
	private JLabel la_mpregen, la_movespeed, la_armor, la_armorperlevel;
	private JLabel la_spellblock, la_spellblockperlevel, la_attackdamage;
	private JLabel la_jsonhp, la_jsonhpperlevel, la_jsonmp, la_jsonmpperlevel;
	private JLabel la_jsonmpregen, la_jsonmovespeed, la_jsonarmor, la_jsonarmorperlevel;
	private JLabel la_jsonspellblock, la_jsonspellblockperlevel, la_jsonattackdamage;
	
	public InfoPage(String labelName, int clickCount) {
		this.labelName=labelName;
		this.clickCount=clickCount;
		
		//�ν��Ͻ� ����
		p_left=new JPanel();
		p_right=new JPanel();
		//-----------------------------------------------
		p_left_profile=new JPanel();
		p_left_txt=new JPanel();
		p_left_txt_left=new JPanel();
		p_left_txt_right=new JPanel();
		//-----------------------------------------------
		p_right_top=new JPanel();
		p_right_mid=new JPanel();
		p_right_bottom=new JPanel();
		p_right_left=new JPanel();
		p_right_right=new JPanel();
		//-----------------------------------------------
		la_profile=new JLabel();
		la_name=new JLabel("Name");
		la_type=new JLabel("Type");
		la_title=new JLabel("Title");
		la_jsonName=new JLabel();
		la_jsonTag=new JLabel();
		la_jsonTitle=new JLabel();
		//-----------------------------------------------
		la_stat=new JLabel();
		la_JsonEx=new JLabel();
		//-----------------------------------------------
		la_hp=new JLabel("ü��");
		la_hpperlevel=new JLabel("lvl�� ü�� ��");
		la_mp=new JLabel("MP");
		la_mpperlevel=new JLabel("lvl�� MP ��");
		la_mpregen=new JLabel("MPȸ����");
		la_movespeed=new JLabel("�̵� �ӵ�");
		la_armor=new JLabel("����");
		la_armorperlevel=new JLabel("lvl�� ���� ��");
		la_spellblock=new JLabel("�������׷�");
		la_spellblockperlevel=new JLabel("lvl�� �������׷� ��");
		la_attackdamage=new JLabel("AD");
		//-----------------------------------------------
		la_jsonhp=new JLabel();
		la_jsonhpperlevel=new JLabel();
		la_jsonmp=new JLabel();
		la_jsonmpperlevel=new JLabel();
		la_jsonmpregen=new JLabel();
		la_jsonmovespeed=new JLabel();
		la_jsonarmor=new JLabel();
		la_jsonarmorperlevel=new JLabel();
		la_jsonspellblock=new JLabel();
		la_jsonspellblockperlevel=new JLabel();
		la_jsonattackdamage=new JLabel();		
		
		//�� ���� �� ����
		la_profile.setPreferredSize(new Dimension(150, 150));
		//-----------------------------------------------
		la_name.setPreferredSize(new Dimension(50, 15));
		la_name.setForeground(Color.YELLOW);
		la_name.setHorizontalAlignment(SwingConstants.CENTER);
		//-----------------------------------------------
		la_type.setPreferredSize(new Dimension(50, 15));
		la_type.setForeground(Color.YELLOW);
		la_type.setHorizontalAlignment(SwingConstants.CENTER);
		//-----------------------------------------------
		la_title.setPreferredSize(new Dimension(50, 30));
		la_title.setForeground(Color.YELLOW);
		la_title.setHorizontalAlignment(SwingConstants.CENTER);
		//-----------------------------------------------
		la_jsonName.setPreferredSize(new Dimension(100, 15));
		la_jsonTag.setPreferredSize(new Dimension(100, 15));
		la_jsonTitle.setPreferredSize(new Dimension(100, 30));
		la_jsonName.setForeground(Color.WHITE);
		la_jsonTag.setForeground(Color.WHITE);
		la_jsonTitle.setForeground(Color.WHITE);
		//-----------------------------------------------
		la_JsonEx.setPreferredSize(new Dimension(430, 100));
		la_JsonEx.setFont(new Font("Default", Font.PLAIN, 14));
		la_JsonEx.setHorizontalAlignment(JLabel.CENTER);
		la_JsonEx.setBackground(Color.BLACK);
		la_JsonEx.setForeground(Color.LIGHT_GRAY);
		//-----------------------------------------------
		la_stat.setPreferredSize(new Dimension(450, 30));
		la_stat.setBackground(Color.GRAY);
		la_stat.setForeground(Color.YELLOW);
		la_stat.setText("champions Status");
		la_stat.setFont(new Font("Serif", Font.BOLD, 30));
		la_stat.setHorizontalAlignment(JLabel.CENTER);
		//-----------------------------------------------
		la_hp.setBackground(Color.BLACK);
		la_hpperlevel.setBackground(Color.BLACK);
		la_mp.setBackground(Color.BLACK);
		la_mpperlevel.setBackground(Color.BLACK);
		la_mpregen.setBackground(Color.BLACK);
		la_movespeed.setBackground(Color.BLACK);
		la_armor.setBackground(Color.BLACK);
		la_armorperlevel.setBackground(Color.BLACK);
		la_spellblock.setBackground(Color.BLACK);
		la_spellblockperlevel.setBackground(Color.BLACK);
		la_attackdamage.setBackground(Color.BLACK);
		//-----------------------------------------------
		la_hp.setHorizontalAlignment(JLabel.CENTER);
		la_hpperlevel.setHorizontalAlignment(JLabel.CENTER);
		la_mp.setHorizontalAlignment(JLabel.CENTER);
		la_mpperlevel.setHorizontalAlignment(JLabel.CENTER);
		la_mpregen.setHorizontalAlignment(JLabel.CENTER);
		la_movespeed.setHorizontalAlignment(JLabel.CENTER);
		la_armor.setHorizontalAlignment(JLabel.CENTER);
		la_armorperlevel.setHorizontalAlignment(JLabel.CENTER);
		la_spellblock.setHorizontalAlignment(JLabel.CENTER);
		la_spellblockperlevel.setHorizontalAlignment(JLabel.CENTER);
		la_attackdamage.setHorizontalAlignment(JLabel.CENTER);
		//-----------------------------------------------
		la_hp.setForeground(Color.YELLOW);
		la_hpperlevel.setForeground(Color.YELLOW);
		la_mp.setForeground(Color.YELLOW);
		la_mpperlevel.setForeground(Color.YELLOW);
		la_mpregen.setForeground(Color.YELLOW);
		la_movespeed.setForeground(Color.YELLOW);
		la_armor.setForeground(Color.YELLOW);
		la_armorperlevel.setForeground(Color.YELLOW);
		la_spellblock.setForeground(Color.YELLOW);
		la_spellblockperlevel.setForeground(Color.YELLOW);
		la_attackdamage.setForeground(Color.YELLOW);
		//-----------------------------------------------
		la_jsonhp.setForeground(Color.WHITE);
		la_jsonhpperlevel.setForeground(Color.WHITE);
		la_jsonmp.setForeground(Color.WHITE);
		la_jsonmpperlevel.setForeground(Color.WHITE);
		la_jsonmpregen.setForeground(Color.WHITE);
		la_jsonmovespeed.setForeground(Color.WHITE);
		la_jsonarmor.setForeground(Color.WHITE);
		la_jsonarmorperlevel.setForeground(Color.WHITE);
		la_jsonspellblock.setForeground(Color.WHITE);
		la_jsonspellblockperlevel.setForeground(Color.WHITE);
		la_jsonattackdamage.setForeground(Color.WHITE);
		
		BufferedReader reader=null;
		try {
			//json ������ text ������  filereader�� ���� jsonParser���� �Ѱ��ش�
			reader=new BufferedReader(new FileReader("D:/Java_developer/javaSE/MyProject/res/champName.txt"));
			JSONParser parser=new JSONParser();
			JSONObject obj=(JSONObject)parser.parse(reader);
			JSONObject jObj=(JSONObject)obj;
			list=new ChampionsList();
			String[] champName=list.getName();
			for (int i = 0; i < champName.length; i++) {
				if(labelName==champName[i]) {
					//json �޾ƿ���
					JSONObject inObj=(JSONObject)jObj.get(labelName);
					JSONObject inInObj=(JSONObject)inObj.get("image");
					JSONObject stObj=(JSONObject)inObj.get("stats");
					List<JSONObject> tagObj=(List<JSONObject>)inObj.get("tags");
					
					//������ ����
					String tag=tagObj.toString();
					System.out.println(tag);
					String title=(String)inObj.get("title");
					String fileName=(String)inInObj.get("sprite");
					String cut=fileName.substring(0, 8);
					String realName=cut+(i+1)+".png";
					String blurb=(String)inObj.get("blurb");
					
					//stat ������ ��������
					Object hp=stObj.get("hp");
					Object hpperlevel=stObj.get("hpperlevel");
					Object mp=stObj.get("mp");
					Object mpperlevel=stObj.get("mpperlevel");
					Object mpregen=stObj.get("mpregen");
					Object movespeed=stObj.get("movespeed");
					Object armor=stObj.get("armor");
					Object armorperlevel=stObj.get("armorperlevel");
					Object spellblock=stObj.get("spellblock");
					Object spellblockperlevel=stObj.get("spellblockperlevel");
					Object attackdamage=stObj.get("attackdamage");
					
					//���� �����͸� string���� ��ȯ
					String t_hp=hp.toString();
					String t_hpperlevel=hpperlevel.toString();
					String t_mp=mp.toString();
					String t_mpperlevel=mpperlevel.toString();
					String t_mpregen=mpregen.toString();
					String t_movespeed=movespeed.toString();
					String t_armor=armor.toString();
					String t_armorperlevel=armorperlevel.toString();
					String t_spellblock=spellblock.toString();
					String t_spellblockperlevel=spellblockperlevel.toString();
					String t_attackdamage=attackdamage.toString();
					
					//�󺧿� ������ �ٿ��ֱ�
					la_jsonhp.setText(t_hp);
					la_jsonhpperlevel.setText(t_hpperlevel);
					la_jsonmp.setText(t_mp);
					la_jsonmpperlevel.setText(t_mpperlevel);
					la_jsonmpregen.setText(t_mpregen);
					la_jsonmovespeed.setText(t_movespeed);
					la_jsonarmor.setText(t_armor);
					la_jsonarmorperlevel.setText(t_armorperlevel);
					la_jsonspellblock.setText(t_spellblock);
					la_jsonspellblockperlevel.setText(t_spellblockperlevel);
					la_jsonattackdamage.setText(t_attackdamage);
					la_jsonName.setText(labelName);
					if(tag.length()>12) { //tag�� ��� �ڸ���
						String cutTag=tag.substring(0, tag.indexOf(",")-1);
						cutTag+="\"]";
						la_jsonTag.setText(cutTag);
					}else {
						la_jsonTag.setText(tag);							
					}
					//<html></html> ��� �� ��ġ�� �ؽ�Ʈ�� �ڵ����� ���� �ٷ� �Ѱ��ش�
					la_jsonTitle.setText("<html>"+title+"</html>"); 	
					la_JsonEx.setText("<html>"+blurb+"</html>");
					
					//�󺧿� �̹��� ����
					ImageIcon icon=new ImageIcon("D:/Java_developer/javaSE/MyProject/res/"+realName);
					Image img=icon.getImage();
					Image changeImg=img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					ImageIcon changeIcon=new ImageIcon(changeImg);
					System.out.println("D:/Java_developer/javaSE/MyProject/res/"+realName);
					la_profile.setIcon(changeIcon);
				}
			}			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		la_profile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					String changedName=labelName.toLowerCase(); //��� �ҹ��ڷ�
					System.out.println("http://gameinfo.leagueoflegends.co.kr/ko/game-info/champions/"+changedName);
					//������Ʈ ����
					Desktop.getDesktop().browse(new URL("http://gameinfo.leagueoflegends.co.kr/ko/game-info/champions/"+changedName+"/").toURI());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		});
			
		//�� ���� �г� ����
		p_left.setLayout(new BorderLayout());
		p_left.add(p_left_profile, BorderLayout.NORTH);
		p_left.add(p_left_txt);
		//-----------------------------------------------
		p_right.setLayout(new BorderLayout());
		p_right.add(p_right_top, BorderLayout.NORTH);
		p_right.add(p_right_bottom);
		//-----------------------------------------------
		p_left_profile.setLayout(new BorderLayout());
		p_left_profile.setPreferredSize(new Dimension(150, 150));
		p_left_profile.add(la_profile);
		//-----------------------------------------------
		p_left_txt.setLayout(new BorderLayout());
		p_left_txt.setPreferredSize(new Dimension(150, 350));
		p_left_txt.add(p_left_txt_left, BorderLayout.WEST);
		p_left_txt.add(p_left_txt_right);
		//-----------------------------------------------
		p_left_txt_left.setPreferredSize(new Dimension(50, 350));
		p_left_txt_left.setBackground(Color.BLACK);
		p_left_txt_left.add(la_name);
		p_left_txt_left.add(la_type);
		p_left_txt_left.add(la_title);
		//-----------------------------------------------
		p_left_txt_right.setPreferredSize(new Dimension(100, 350));
		p_left_txt_right.setBackground(Color.BLACK);
		p_left_txt_right.add(la_jsonName);
		p_left_txt_right.add(la_jsonTag);
		p_left_txt_right.add(la_jsonTitle);
		//-----------------------------------------------
		p_right_top.setBackground(Color.BLACK);
		p_right_top.setPreferredSize(new Dimension(450, 100));
		p_right_top.add(la_JsonEx);
		//-----------------------------------------------
		p_right_mid.setLayout(new BorderLayout());
		p_right_mid.setBackground(Color.BLACK);
		p_right_mid.setPreferredSize(new Dimension(450, 30));
		p_right_mid.add(la_stat);
		//-----------------------------------------------
		p_right_bottom.setLayout(new BorderLayout());
		p_right_bottom.setPreferredSize(new Dimension(450, height-130));
		p_right_bottom.add(p_right_mid, BorderLayout.NORTH);
		p_right_bottom.add(p_right_left, BorderLayout.WEST);
		p_right_bottom.add(p_right_right, BorderLayout.EAST);
		//-----------------------------------------------
		p_right_left.setLayout(new GridLayout(11, 1));
		p_right_left.setPreferredSize(new Dimension(150, height-130));
		p_right_left.setBackground(Color.BLACK);
		p_right_left.add(la_hp);
		p_right_left.add(la_hpperlevel);
		p_right_left.add(la_mp);
		p_right_left.add(la_mpperlevel);
		p_right_left.add(la_mpregen);
		p_right_left.add(la_movespeed);
		p_right_left.add(la_armor);
		p_right_left.add(la_armorperlevel);
		p_right_left.add(la_spellblock);
		p_right_left.add(la_spellblockperlevel);
		p_right_left.add(la_attackdamage);
		//-----------------------------------------------
		p_right_right.setLayout(new GridLayout(11, 1));
		p_right_right.setPreferredSize(new Dimension(300, height-130));
		p_right_right.setBackground(Color.BLACK);
		p_right_right.add(la_jsonhp);
		p_right_right.add(la_jsonhpperlevel);
		p_right_right.add(la_jsonmp);
		p_right_right.add(la_jsonmpperlevel);
		p_right_right.add(la_jsonmpregen);
		p_right_right.add(la_jsonmovespeed);
		p_right_right.add(la_jsonarmor);
		p_right_right.add(la_jsonarmorperlevel);
		p_right_right.add(la_jsonspellblock);
		p_right_right.add(la_jsonspellblockperlevel);
		p_right_right.add(la_jsonattackdamage);
		
		//Container ���� ����
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(width, height));
		add(p_left, BorderLayout.WEST);
		add(p_right, BorderLayout.EAST);
	}
}
