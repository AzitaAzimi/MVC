package calculator;


public class Model {

	private double result;
	public double add(double firstNum,double secoundNum){
		return result= firstNum+secoundNum;
	}
	public double subtract(double firstNum,double secoundNum){
		return result=firstNum - secoundNum;
	}
	public double multiply(double firstNum,double secoundNum){
		return result=firstNum *secoundNum;
	}
	public double divide(double firstNum,double secoundNum){
		return result=firstNum/secoundNum;
	}
	public double getresult(){
		return result;
	}
}
