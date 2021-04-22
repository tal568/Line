package def;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

class RulseC extends JFrame {
	private JButton back;
	private JTextField textField;

	public RulseC() {
		setTitle("rulse");
		getContentPane().setLayout(null);

		JTextArea txt = new JTextArea();
		txt.setEditable(false);
		txt.setBounds(0, 0, 490, 450);
		getContentPane().add(txt);
		txt.setColumns(10);
		Font f = new Font("serif", Font.PLAIN, 16);
		txt.setFont(f);
		txt.setText("Rules of the game The game begins with all the circles in the\r\n"
				+ " two most extreme columns\r\n"
				+ "The whites and in the most extreme rows \r\n"
				+ "Usually the first move is of the black.\r\n"
				+ "  Each circle can move in a row, column, and diagonally\r\n."
				+ " The number of steps of a circle \r\n"
				+ "is according to the number of pices that are in the same way\r\n"
				+ " for example \r\n"
				+ " if there is a white circle in row number 2 and there are 2 black\r\n"
				+ " circles in the same row \r\n"
				+ " the same circle will have 3 steps if it moves in a row as long as they\r\n"
				+ " are not blocked.\r\n"
				+ "Each circle will be able to pass over a circle that has the same color.\r\n"
				+ " A circle will not be able to pass over the circle with a different color,\r\n"
				+ " the circle will come out "
				+ "(if there is one circle left  it mean avictory for the"
				+ " same color.because all its circles are connected).");
				
		back = new JButton("go back");
		back.setBounds(0, 449, 89, 23);
		getContentPane().add(back);
		setSize(500, 510);
	}

	public JButton GetBack() {
		return back;
	}

	public void SetBack(JButton back) {
		this.back = back;
	}

}
