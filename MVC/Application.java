package calculator;

public class Application {

	  public static void main(String[] args) {
	    	
	    	CalculatorView2 theView = new CalculatorView2();
	        
	    	Model theModel = new Model();
	        
	       Controller theController = new Controller(theView,theModel);
	        
	        theView.setVisible(true);
	        
	    }
}
