package HotelManagementSystem;

import javax.swing.JFrame;

public class Application extends JFrame {
	public static void main(String[] args) {
		
	InterfaceClass v=new InterfaceClass();
	ModelClass m=new ModelClass();
	new ControllerClass(v, m);
	
}

}