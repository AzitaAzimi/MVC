import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerClass implements ActionListener{
	    //private StuModel model;
		public ViewClass viewClass;
		
		public ControllerClass( ViewClass view){
			//this.model=model;
			this.viewClass=view;
		}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewClass.insert_button){
			String dbName=viewClass.name.getText();
			modelClass.setName(dbName);
			String dbLname=viewClass.lname.getText();
			modelClass.setLname(dbLname);
			String dbFname=viewClass.fathername.getText();
			modelClass.setFname(dbFname);
			int dbAge=Integer.parseInt(viewClass.age.getText());
			modelClass.setAge(dbAge);
			String dbFemale=viewClass.gender_female.getText();
			modelClass.setFemale(dbFemale);
			String dbMale=viewClass.gender_male.getText();
			modelClass.setMale(dbMale);
			//System.out.println(dbName+""+dbLname+""+dbFname+""+dbAge+""+dbFemale+""+dbMale);

		}
		else{
			modelClass.getName();
			viewClass.nameQuery.setText(getName);
		}
	}
	
}


