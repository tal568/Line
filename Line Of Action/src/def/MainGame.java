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
import javax.swing.SwingConstants;

import def.project.Window;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainGame extends JFrame
{ 
	private JTextArea textArea;
	private JButton[][] action=new JButton[8][8];
	 private JMenuItem surnder;
	 private JMenuItem undo;
	 private JLabel condison ;
	 private JLabel enemy;
	 private JLabel player;
	
 public MainGame() 
 {
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	 int width = screenSize.width;
	 int height = screenSize.height;

	 if (width>1000)
		 width=1000;
	 if (height>1000)
		 height=1000;
	 double x=(double)width/1000;
	 double y=(double)height/1000;
	setSize(width, height);
	getContentPane().setLayout(null);
	
	JPanel bord = new JPanel();
	bord.setBounds((int)(10*x),(int)(0*y),(int)(682*x),(int)(653*y));
	getContentPane().add(bord);
	bord.setLayout(new GridLayout(8, 8));
	SetAction(bord);
	JPanel panel = new JPanel();
	panel.setBounds((int)(702*x),(int)(11*y),(int)(274*x),(int)(653*y));
	getContentPane().add(panel);
	panel.setBackground(Color.white);
	
	JTextArea textArea = new JTextArea();
	textArea.setEditable(false);
	panel.add(textArea);
	
	 enemy = new JLabel("Enemy solders:12");
	enemy.setBounds((int)(5*x),(int)(659*y),(int)(117*x),(int)(62*y));
	getContentPane().add(enemy);
	

	 player = new JLabel("player solders:12");
	player.setBounds((int)(127*x),(int)(657*y),(int)(140*x),(int)(61*y));
    getContentPane().add(player);
    
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
	 this.player.setText("player solders:"+String.valueOf(num));
 }
 
public JTextArea GetTextArea() {
	return textArea;
}
public void SetTextArea(JTextArea textArea) {
	this.textArea = textArea;
}
public JMenuItem GetUndo() 
{
	return undo;
	}
public JMenuItem GetSurnder() 
{
	return surnder;
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
}
