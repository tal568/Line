package def;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Diff extends JFrame  {
	
	private JButton med = new JButton("meduim");
	 private JButton hard = new JButton("hard");
	

	public Diff() {
		setTitle("Line of Action");
		setSize(500, 500);
		getContentPane().setLayout(null);
		
		
		
		
		med.setBackground(new Color(255, 255, 255));
	
		
		med.setBounds(146, 150, 116, 53);
		getContentPane().add(med);
		hard.setForeground(new Color(255, 255, 255));
		
		
		hard.setBackground(Color.black);
	
		
		hard.setBounds(146, 251, 116, 42);
		getContentPane().add(hard);
		
		
		JLabel lblNewLabel = new JLabel("select diffilulty ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(134, 45, 149, 53);
		getContentPane().add(lblNewLabel);
		Font font = new Font("Serif", Font.BOLD, 18);
		 lblNewLabel.setFont(new Font("Serif", Font.BOLD, 23));
		
		 
		 JLabel lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setIcon(new ImageIcon(Diff.class.getResource("/def/chess.png")));
		 lblNewLabel_1.setBounds(0, 0, 486, 463);
		 getContentPane().add(lblNewLabel_1);
	}
	public JButton GetMed() 
	{
		return med;
	}
	public JButton GetHard() 
	{
		return hard;
	}


}
