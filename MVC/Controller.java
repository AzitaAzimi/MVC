package calculator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller {
	private double num1 = 0.0, num2 = 0.0, result = 0.0;
	private char op = ' ';
	private CalculatorView2 theView;
	private Model theModel;
	
	public Controller(CalculatorView2 theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		// Tell the View that when ever button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char ch = ((JButton) e.getSource()).getText().charAt(0);
				String value = theView.txtResult.getText();
			
				if (Character.isDigit(ch)) {
					if (ch == '0' && value.length() > 0)
						theView.txtResult.setText(value + ch);
					else if (ch != '0') {
						theView.txtResult.setText(value + ch);
					}
				} else if (ch == '.' && !value.contains(".")) {
					theView.txtResult.setText(value + ch);
				} else if (ch == '=') {
					 num2 = Double.parseDouble(value);
					
					switch (op) {
					case '+':
						result=theModel.add(num1, num2);
						break;
					case '-':
						result=theModel.subtract(num1, num2);
						break;
					case '*':
						result=theModel.multiply(num1, num2);
						break;
					case '/':
						result=theModel.divide(num1, num2);
						break;
					default:
						result = 0.0;
						break;
					}
					theView.txtResult.setText("" + result);
					
					num1 = 0.0;
					num2 = 0.0;
					op = ' ';

				} else {
					op = ch;
					num1 = Double.parseDouble(value);
					theView.txtResult.setText("");
				}
				
				
			}
		}
	}

