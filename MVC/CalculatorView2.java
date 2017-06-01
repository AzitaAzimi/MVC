package calculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CalculatorView2 extends JFrame{
	int i;
	protected JTextField txtResult;
	private JPanel pnlbuttons;
	private JButton btns[]=new JButton[17];
	private String captions[] = { "7", "8", "9", "/", "4", "5", "6", "*", "1",
			"2", "3", "-", "0", ".", "=", "+" };
	
	public CalculatorView2(){
		setTitle("Software engineering MVC Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(2, 2));
		
		pnlbuttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		txtResult = new JTextField(20);
		txtResult.setEditable(true);
		txtResult.setPreferredSize(new Dimension(200, 40));
		txtResult.setFont(new Font("Arial", Font.PLAIN, 18));
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setEditable(false);
		pnlbuttons.add(txtResult);
		add(pnlbuttons, BorderLayout.NORTH);
		
		pnlbuttons = new JPanel(new GridLayout(4, 4, 5, 5));
		for (i = 0; i < captions.length; i++) {
			btns[i] = new JButton(captions[i]);
			btns[i].setForeground(Color.BLACK);
			pnlbuttons.add(btns[i]);				
		}

		add(pnlbuttons);

		pack();
	setResizable(false);
	}
	void addCalculateListener(ActionListener calculateListener) {
		// TODO Auto-generated method stub
		for (int i = 0; i < captions.length; i++) {
			btns[i].addActionListener(calculateListener);
		}


	}
}
