package def;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

 class Menu extends JFrame {
	 private  Menu menu;
	  
	private  JButton htp;
	private JButton start ;
	
		
	public Menu() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Line of action");
		getContentPane().setLayout(null);
		htp = new JButton("how to play");
		htp.setBackground(new Color(255, 218, 185));
		 
		 JLabel name = new JLabel("LINE OF ACTION ");
		 name.setForeground(Color.BLUE);
		 name.setFont(new Font("David", Font.PLAIN, 30));
		 name.setBounds(93, 23, 266, 70);
		 getContentPane().add(name);
		 start = new JButton("start");
		 start.setIcon(null);
		
		 start.setBackground(Color.white);
		start.setBounds(179, 105, 89, 29);
		getContentPane().add(start);
	
	    		        
				
	
		htp.setBounds(166, 172, 112, 23);
		getContentPane().add(htp);
		 htp.setBackground(Color.black);
		 htp.setForeground(Color.white);
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/def/chess.png")));
		lblNewLabel.setBounds(0, 0, 500, 500);
		getContentPane().add(lblNewLabel);
		setSize(500,500);
	}



public JButton GetHtp() 
{
	return this.htp;
}
public void SetHtp(JButton htp) 
{  this.htp=htp;
	}

	public Menu GetMenu() {
		return this.menu;
	}


	public void SetMenu(Menu menu) {
		this.menu = menu;
	}@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return super.getFont();
	}
	public JButton GetStart() 
	{
		return start;
	}  
	public void SetStart(JButton start) 
	{
		start=start;
	}
}


 
