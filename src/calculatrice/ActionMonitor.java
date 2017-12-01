package calculatrice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


public class ActionMonitor implements ActionListener {

	private JLabel screen;

	public  ActionMonitor(JLabel screen) {
		this.screen = screen;
	}


	public void actionPerformed(ActionEvent e) {

		// get which button was clicked
		String cmd = e.getActionCommand();

		// get the content of the screen
		String screenText = screen.getText();


		// The screen is initialized to 0
		if (screenText.equals("0")) {
			if (isOperator(cmd) || cmd.equals("."))
				screen.setText(screenText.concat(cmd));
			else {
				// Ignore c and . if the screen is initialized
				if (!cmd.equals("C")) {
					screen.setText(cmd);
				}
			}
		}
		else {
			// Reinitialize screen
			if (cmd.equals("C")) {
				screen.setText("0");
			}
			else if (cmd.equals(".")) {
				screen.setText(verifyFloat(screenText));

			}
			else if (cmd.equals("=")) {
				screen.setText(equal(screenText));
			}
			else {
				if (screenText.charAt(screenText.length() - 1) == '.' && isOperator(cmd))
					screen.setText(screenText.concat("0").concat(cmd));
				else
					screen.setText(screenText.concat(cmd));
			}
		}



	}


	/**
	 * Given an expression the function return true if it is one of {+, -, *, /}.
	 * @param expression the string that the function will check
	 * @return true if the expression is an operator.
	 */
	private boolean isOperator(String expression) {


		// Return false if the length of expression is bigger than 1
		if (expression.length() > 1)
			return false;

		// if it is one of the operators
		if (expression.equals("+") ||
				expression.equals("-") || 
				expression.equals("*") || 
				expression.equals("/"))
			return true;


		// else return false
		return false;
	}

	/**
	 * Given an expression the private method returns the operator of that expression if founded.
	 * @param expression the expression will contain only one operator.
	 * @return the operator in the given expression if founded, else a space ' '.
	 */
	private char whichOperator(String expression) {

		// test for the operators
		if (expression.indexOf('+') != -1) {
			return '+';
		}
		else if (expression.indexOf('-') != -1) {
			return '-';
		}
		else if (expression.indexOf('*') != -1) {
			return '*';
		}
		else if (expression.indexOf('/') != -1) {
			return '/';
		}

		// Nothing found
		return ' ';
	}


	/**
	 * Given an expression this private method will check if the . of float will be added or not. 
	 * @param expression the string that will get checked.
	 * @return the expression after checking.
	 */
	private String verifyFloat(String expression) {


		// if the expression does not contain any operator
		if (expression.indexOf('+') == -1 && 
				expression.indexOf('-') == -1 &&
				expression.indexOf('*') == -1 &&
				expression.indexOf('/') == -1) {

			// add . if the expression does not contain already one
			if (expression.indexOf('.') == -1) {
				return expression.concat(".");
			}
			else 
				return expression;
		}
		else {
			// if the last character of the screen is an operator
			if (isOperator(Character.toString(expression.charAt(expression.length() - 1))))
				return expression.concat("0.");
			// the operator in in the middle
			else {
				String secondNumber = expression.substring(expression.indexOf(whichOperator(expression)) + 1, expression.length());
				// check if the secondNumber contains a .
				if (secondNumber.indexOf('.') == -1)
				{
					return expression.concat(".");
				}
			}

		}

		// return the given expression in case of error
		return expression;
	}


	/**
	 * Given an expression this private method will check if the given expression can be calculated or not
	 * if so, it will print the result into the screen else, it won't change anything.
	 * @param expression the given mathematical expression.
	 * @return the result if possible, else the given expression without any modification.
	 */
	private String equal(String expression) {


		// the expression contains an operator
		char operator = whichOperator(expression);
		if (operator != ' ') {
			
			// get the index of the operator
			int indexOpera = expression.indexOf(operator);
			
			// get the values
			double x = Double.parseDouble(expression.substring(0, indexOpera));
			double y = Double.parseDouble(expression.substring(indexOpera + 1, expression.length()));;
			
			String result = "OOPS";
			
			switch (operator) {

			case '+': {
				
				result = add(x, y);
				break;
			}
			
			case '-': {
				result = sub(x, y);
				break;
			}
			
			case '*': {
				result = mul(x, y);
				break;
			}
			
			case '/': {
				result = div(x, y);
				break;
			}


			}
			
			
			return ignoreP0(result);
		}


		return expression;
	}

	/**
	 * Given an expression, this private method will get rid of .0 at the end of the string.
	 * @param expression the string that you want to make it look better.
	 * @return a string without .0 at the end.
	 */
	private String ignoreP0(String expression) {
		
		if (expression.endsWith(".0")) {
			return expression.substring(0, expression.length() - 2);
		}
		
		
		return expression;
		
	}
	
	/**
	 * Add the given values and return the result as a String.
	 * @param x first value.
	 * @param y second value.
	 * @return the result as a String.
	 */
	private String add(double x, double y) {
		return Double.toString(x + y);
	}
	
	/**
	 * Subtract the given values and return the result as a String.
	 * @param x first value.
	 * @param y second value.
	 * @return the result as a String.
	 */
	private String sub(double x, double y) {
		return Double.toString(x - y);
	}
	
	/**
	 * Multiplication of the given values and return the result as a String.
	 * @param x first value.
	 * @param y second value.
	 * @return the result as a String.
	 */
	private String mul(double x, double y) {
		return Double.toString(x * y);
	}
	
	/**
	 * Divide the given values and return the result as a String.
	 * @param x first value.
	 * @param y second value.
	 * @return the result as a String.
	 */
	private String div(double x, double y) {
		// TODO: x must not be 0
		return Double.toString(x / y);
	}

}
