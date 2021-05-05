package def;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import def.project.Window;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.DropMode;

public class MainGame extends JFrame
{ 
	
	private JButton[][] action=new JButton[8][8];
	 private JMenuItem surnder;
	 private JMenuItem undo;
	 private JLabel condison ;
	 private JLabel enemy;
	 private JLabel playerp;
	 private JMenuItem player = new JMenuItem("Player");
	 private JMenuItem ai = new JMenuItem("Ai");
	 JMenuItem normal = new JMenuItem("normal");
		JMenuItem hard = new JMenuItem("hard");
		JTextField con= new JTextField("player connections:6 enemy connections:6");
		JTextField wins= new JTextField("player win amount:0   enemy win amount:0");
	
 public MainGame() 
 {

	setSize(1200, 1000);
	getContentPane().setLayout(null);
	
	JPanel bord = new JPanel();
	bord.setBounds(0,0,800,800);
	getContentPane().add(bord);
	bord.setLayout(new GridLayout(8, 8));
	SetAction(bord);
	JPanel panel = new JPanel();
	getContentPane().add(panel);
	panel.setBounds(800,0,400,800);
	
	panel.setBackground(Color.white);
	
	con.setEnabled(false);
	con.setEditable(false);
	con.setFont(new Font("serif", Font.PLAIN, 20));

	wins.setEnabled(false);
	wins.setEditable(false);
	wins.setFont(new Font("serif", Font.PLAIN, 20));
	panel.add(con);
	con.setBackground(Color.black);
	wins.setBackground(Color.black);

	panel.add(wins);
	int x=800;
	int y=800;

	 enemy = new JLabel("Enemy solders:12");
	enemy.setBounds((200),(y),(200),(50));
	getContentPane().add(enemy);
	

	 playerp = new JLabel("player solders:12");
	playerp.setBounds((0),(y),(200),(50));
    getContentPane().add(playerp);
    
    condison = new JLabel("");
    
    condison.setBounds((int)(105*x),(int)(767*y),(int)(421*x),(int)(83*y));
    getContentPane().add(condison);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("option");
	menuBar.add(mnNewMenu);
	
	 undo = new JMenuItem("undo");
	mnNewMenu.add(undo);
	
	 surnder = new JMenuItem("surender");
	mnNewMenu.add(surnder);
	
	JMenu mnNewMenu_1 = new JMenu("play against");
	menuBar.add(mnNewMenu_1);
	mnNewMenu_1.add(ai);
	mnNewMenu_1.add(player);
	
	JMenu mnSelect = new JMenu("select difficulty");
	menuBar.add(mnSelect);
	
	
	mnSelect.add(normal);
	
	mnSelect.add(hard);
	 
		
					}
 public void SetAction(JPanel bord) {
	for(int i=0;i<action[0].length;i++) 		
		for(int j=0;j<action.length;j++) 
		{
			action[i][j]=new JButton();
			bord.add(action[i][j]);

				
			
			if((i+j)%2==0) 
			{
				action[i][j].setBackground(Color.white);
			}
			else
				action[i][j].setBackground(Color.DARK_GRAY);
			if(j==0)
			{
				action[i][j].setText(String.valueOf(8-i));
				action[i][j].setHorizontalTextPosition(SwingConstants.LEFT);
				action[i][j].setVerticalTextPosition(SwingConstants.BOTTOM);

				
			}
			if(i==7) 
			{
				String[] help = {"1A","B","C","D","E","F","G","H"};
				action[i][j].setText(help[j]);
				action[i][j].setHorizontalTextPosition(SwingConstants.LEFT);
				action[i][j].setVerticalTextPosition(SwingConstants.BOTTOM);
				}
			if((i+j)%2==1) 
			{
				action[i][j].setForeground(Color.white);
			}
			else
				action[i][j].setForeground(Color.DARK_GRAY);
				  
				
		}
 }
			

			
			
	
	
 
 public void SetEnemy(int num) 
 {
	 this.enemy.setText("Enemy solders:"+String.valueOf(num));
 }
 public void Setplayer(int num) 
 {
	 this.playerp.setText("player solders:"+String.valueOf(num));
 }
 

public JMenuItem GetUndo() 
{
	return undo;
	}
public JMenuItem GetSurnder() 
{
	return surnder;
	}
public JMenuItem GetAi() 
{return ai;
	}
public JMenuItem GetPlayer() 
{return player;
	}
public void SetStateTxt(String x) 
{
	this.condison.setText(x);
	
	}
public JButton SetIcon(int y,int x)
{
	return action[y][x];
}
public void SetIcon(int y,int x,ImageIcon t) 
{
	action[y][x].setIcon(t);
	}
public JButton[][] GetAction()
{
	return action;
	}
public void SetAction(JButton[][] x) 
{
	action=x;
	}
public JMenuItem GetNormal() 
{
	return normal;
	}
public JMenuItem GetHard() 
{
	return hard;
	}

public void SetCon(int player,int enemy) 
{ con.setText("player connections:"+player+" enemy connections:"+ enemy);

	}
public void SetWins(int player,int enemy) {
	
	wins.setText("player win amount:"+player+"   enemy win amount:"+enemy);;
}
}