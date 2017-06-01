
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InterfaceClass{
	
//----------- connect to Database ------------------------------------------------------------------------------
	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/hotel_management_system";
		String username = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
//----------- end connect to Database ----------------------------------------------------------------------------	
	
	
	private ModelClass model;
	JFrame frame = new JFrame();
	JLabel nameQuery, lnameQuery, FNameQuery, ageQuery, idQuery, genderQuery;
	JLabel lbl_name, lbl_lname, lbl_fathername, lbl_age, lbl_gender, lbl_id,
			lbl_photo, lbl_search, lbl_header, lbl_header2,lbl_header3, lbl_searchName,
			lbl_searchLname, lbl_searchFather, lbl_searchAge, lbl_SearchId,
			lbl_searchGender, lbl_accept, lbl_deAccept, search_body, report_body;
	JTextField id, name, location, salary, search;
	JRadioButton receptionist, housekeeper, chef;
	JButton insert_button, search_button, accept_button;
	private static JTabbedPane jtp1;
	ButtonGroup group;
	
	JList list;
	JScrollPane scroll, sc;
	QueryListener query ;
	Connection conn;
	
	public InterfaceClass() {

		JFrame frame = new JFrame("Software MVC Exercise");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(660, 600);
		frame.setLocation(200, 10);

		jtp1 = new JTabbedPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jtp1.addTab("Staff Registeration", jp1);
		jtp1.addTab("Accept staff", jp2);
		jtp1.addTab("Staff Report", jp3);

		JLabel register_header = new JLabel(new ImageIcon(getClass()
				.getResource("banner.jpg")));
		jp1.add(register_header).setBounds(-2, 2, 645, 140);

		JLabel register_header2 = new JLabel(new ImageIcon(getClass()
				.getResource("banner.jpg")));
		jp2.add(register_header2).setBounds(-2, 2, 645, 140);
		
		JLabel register_header3 = new JLabel(new ImageIcon(getClass()
				.getResource("banner.jpg")));
		jp3.add(register_header3).setBounds(-2, 2, 645, 140);

		register_header.setBorder(BorderFactory.createLineBorder(Color.blue));
		register_header2.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel register_body = new JLabel(new ImageIcon(getClass().getResource(
				"b3.jpg")));
		jp1.add(register_body).setBounds(-10, 128, 660, 420);

		 search_body = new JLabel(new ImageIcon(getClass().getResource(
				"b3.jpg")));
		jp2.add(search_body).setBounds(-10, 128, 660, 420);
		
		report_body = new JLabel(new ImageIcon(getClass().getResource(
				"b3.jpg")));
		jp3.add(report_body).setBounds(-10, 128, 660, 420);

		

		JLabel b4 = new JLabel(new ImageIcon(getClass().getResource("b4.jpg")));
		register_body.add(b4).setBounds(60, 25, 215, 30);

		JLabel b44 = new JLabel(new ImageIcon(getClass().getResource("b4.jpg")));
		search_body.add(b44).setBounds(60, 25, 175, 30);
		
		JLabel b444 = new JLabel(new ImageIcon(getClass().getResource("b4.jpg")));
		report_body.add(b444).setBounds(60, 25, 175, 30);

		JLabel border = new JLabel();
		register_body.add(border).setBounds(25, 35, 610, 350);
		border.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel border2 = new JLabel();
		search_body.add(border2).setBounds(25, 35, 610, 350);
		border2.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel border3 = new JLabel();
		report_body.add(border3).setBounds(25, 35, 610, 350);
		border3.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		// lbl for search tap

		lbl_header = new JLabel("Please Insert Students Information");
		b4.add(lbl_header).setBounds(10, -6, 250, 30);

		lbl_header2 = new JLabel("list of people that requested ");
		lbl_accept = new JLabel("Manager add successfully !");
		lbl_deAccept = new JLabel("Manager don't add");
		
		b44.add(lbl_header2).setBounds(10, -6, 360, 30);
		
		lbl_header3 = new JLabel("  List of accepeted Staffs");
		b444.add(lbl_header3).setBounds(10, -6, 260, 30);
		
		lbl_name = new JLabel("Id:");
		id = new JTextField(20);
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);

		lbl_lname = new JLabel("Name:");
		lbl_lname.setHorizontalAlignment(SwingConstants.RIGHT);
		name = new JTextField(20);

		lbl_fathername = new JLabel("Location:");
		lbl_fathername.setHorizontalAlignment(SwingConstants.RIGHT);
		location = new JTextField(20);

		lbl_age = new JLabel("Salary:");
		lbl_age.setHorizontalAlignment(SwingConstants.RIGHT);
		salary = new JTextField(20);

		lbl_gender = new JLabel("Type:");
		lbl_gender.setHorizontalAlignment(SwingConstants.RIGHT);

		receptionist = new JRadioButton("Receptionist");
		receptionist.setActionCommand("receptionist");
		receptionist.setOpaque(false);

		housekeeper = new JRadioButton("Housekeeper");
		housekeeper.setActionCommand("housekeeper");
		housekeeper.setOpaque(false);
		
		chef = new JRadioButton("Chef");
		chef.setActionCommand("chef");
		chef.setOpaque(false);

		group = new ButtonGroup();
		group.add(receptionist);
		group.add(housekeeper);		
		group.add(chef);
		
		insert_button = new JButton("Insert");
		query = new QueryListener();
		insert_button.addActionListener(query);
		search_button = new JButton("Search");
		accept_button = new JButton("Accept");
		accept_button.addActionListener(query);;

		register_body.add(lbl_name).setBounds(20, 70, 150, 30);
		register_body.add(id).setBounds(190, 70, 220, 30);

		register_body.add(lbl_lname).setBounds(20, 110, 150, 30);
		register_body.add(name).setBounds(190, 110, 220, 30);

		register_body.add(lbl_fathername).setBounds(20, 150, 150, 30);
		register_body.add(location).setBounds(190, 150, 220, 30);

		register_body.add(lbl_age).setBounds(20, 190, 150, 30);
		register_body.add(salary).setBounds(190, 190, 220, 30);

		//register_body.add(lbl_id).setBounds(20, 230, 150, 30);
//		register_body.add(id).setBounds(190, 230, 220, 30);

		register_body.add(lbl_gender).setBounds(20, 275, 150, 30);
		register_body.add(receptionist).setBounds(185, 275, 150, 30);
		register_body.add(housekeeper).setBounds(185, 295, 150, 30);
		register_body.add(chef).setBounds(185, 315, 150, 30);

		register_body.add(insert_button).setBounds(520, 345, 90, 30);

		search = new JTextField(20);
//		search_body.add(search_button).setBounds(50, 70, 90, 30);
//		search_body.add(search).setBounds(150, 70, 300, 30);
		
		search_body.add(accept_button).setBounds(50, 280, 90, 30);
		lbl_accept.setVisible(false);
		search_body.add(lbl_accept).setBounds(50, 300, 290, 30);
		lbl_deAccept.setVisible(false);
		search_body.add(lbl_deAccept).setBounds(50, 300, 290, 30);
	
		
		
		jtp1.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent change) {
				int x = jtp1.getSelectedIndex();
				if(x==1){
					System.out.println(1);
					
//--------------- Select Query for tab accept staff  ----------------------------------------------------------------------------------------					
					try {
						list = new JList();
						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/hotel_management_system", "root", "");
						 DefaultListModel mod = new DefaultListModel(); //create a new list model
						 DefaultListModel m = new DefaultListModel(); //create a new list model
						     Statement statement = conn.createStatement();
						    ResultSet resultSet = statement.executeQuery("select * from staff"); //run your query
						    
						    while (resultSet.next()) //go through each row that your query returns
						    {
						        String name = resultSet.getString("name"); //get the element in column "name"
						        String id = resultSet.getString("staff_id"); //get the element in column "id"
						        String location = resultSet.getString("location"); //get the element in column "location"

						        String row = id + "              " + name + "            "+location;
						        mod.addElement(row); //add each item to the model
						    }
						    list.setModel(mod);
						    list.setVisibleRowCount(5);
							list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
							scroll = new JScrollPane(list);
							search_body.add(scroll).setBounds(50, 70, 560, 200);
						    
					} catch (SQLException e) {
						e.printStackTrace();
					}
//----------- End Select Query ------------------------------------------------------------------------------------------
					

				}
				else if(x==2){
					System.out.println(2);
					
					
					try {
						
						String r ="";
						String array[] = new String [10];
						int i = 0;
						
						 Statement st = conn.createStatement();
						ResultSet res = st.executeQuery("select * from staff where manager_id = 1");
						
					    while (res.next()) //go through each row that your query returns
					    {
					        
					        String name = res.getString("name"); //get the element in column "name"
					        String id = res.getString("staff_id"); //get the element in column "id"
					        String location = res.getString("location"); //get the element in column "location"

					         r = id + "              " + name + "            "+location;
					        
							array[i] = r;
							i++;	
					    }
					   
						JList l = new JList();
						l.setListData(array);
						l.setVisibleRowCount(5);
						l.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
						sc = new JScrollPane(l);
						report_body.add(sc).setBounds(50, 100, 560, 200);
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				
			}
		});

		

		

		lbl_searchName = new JLabel("ID");
		lbl_searchLname = new JLabel("Name:");
		lbl_searchFather = new JLabel("Location:");
		lbl_searchAge = new JLabel("Salary:");
		lbl_SearchId = new JLabel("Type:");

		lbl_searchName.setVisible(false);
		lbl_searchLname.setVisible(false);
		lbl_searchFather.setVisible(false);
		lbl_searchAge.setVisible(false);
		lbl_SearchId.setVisible(false);

		search_body.add(lbl_searchName).setBounds(80, 120, 100, 30);
		search_body.add(lbl_searchLname).setBounds(80, 155, 100, 30);
		search_body.add(lbl_searchFather).setBounds(80, 195, 100, 30);
		search_body.add(lbl_searchAge).setBounds(80, 230, 100, 30);
		search_body.add(lbl_SearchId).setBounds(80, 265, 100, 30);


		nameQuery = new JLabel();
		lnameQuery = new JLabel();
		FNameQuery = new JLabel();
		ageQuery = new JLabel();
		idQuery = new JLabel();
		genderQuery = new JLabel();

		search_body.add(nameQuery).setBounds(200, 120, 250, 30);
		search_body.add(lnameQuery).setBounds(200, 155, 250, 30);
		search_body.add(FNameQuery).setBounds(200, 195, 250, 30);
		search_body.add(ageQuery).setBounds(200, 230, 250, 30);
		search_body.add(idQuery).setBounds(200, 265, 250, 30);
		search_body.add(genderQuery).setBounds(200, 300, 250, 30);

		jp1.setLayout(null);
		jp2.setLayout(null);
		jp3.setLayout(null);
		frame.add(jtp1).setBounds(10, -132, 740, 40);
		frame.setBackground(Color.blue);
		frame.setVisible(true);
		

	}

		JTabbedPane tabbedPane = new JTabbedPane();

		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jtp1 = (JTabbedPane) e.getSource();
			}
		};

	
	private class QueryListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource()==insert_button){
				String dbName=id.getText();
				id.setText("");
				String dbLname=name.getText();
				name.setText("");
				String dbFname=location.getText();
				location.setText("");
				String dbAge=salary.getText();
				salary.setText("");
				String dbGender=group.getSelection().getActionCommand();
				group.clearSelection();
				
				
//----------------------------------- Insert Query -----------------------------------------------------------------------	
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = getConnection();
					String query = "insert into staff (staff_id, name, location, salary, type_staff, manager_id) values(?, ?, ?, ?, ?, 0)";

					pstmt = conn.prepareStatement(query); // create a statement

					pstmt.setString(1, dbName); // set input parameter 2
					pstmt.setString(2, dbLname); // set input parameter 2
					pstmt.setString(3, dbFname); // set input parameter 2
					pstmt.setString(4, dbAge); // set input parameter 2
					pstmt.setString(5, dbGender); // set input parameter 2
				

					pstmt.executeUpdate(); // execute insert statement
					System.out.println("run");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
//------------- end Insert Query ------------------------------------------------------------------------------------------
			
			
			else if (event.getSource()==search_button){
				
				model.setId(search.getText());

				lbl_searchName.setVisible(true);
				System.out.println(model.getName());
				nameQuery.setText(model.getId());
				
				lbl_searchLname.setVisible(true);
				lnameQuery.setText(model.getName());
				
				lbl_searchFather.setVisible(true);
				FNameQuery.setText(model.getLocation());
				
				lbl_searchAge.setVisible(true);
				ageQuery.setText(model.getSalary());

				lbl_SearchId.setVisible(true);
				idQuery.setText(model.getType());
				
				
			}
		
			
//--------- Update Query -----------------------------------------------------------------------------------------------			
			if(event.getSource() == accept_button){
				int index = list.getSelectedIndex()+1;
				System.out.println(index);
				
				try {
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hotel_management_system", "root", "");
		
				      // create the java mysql update preparedstatement
				      String query = "update staff set manager_id = ? where id = ?";
				      PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setInt   (1, 1);
				      preparedStmt.setInt(2, index);
				      
				      Statement st = conn.createStatement();
					  ResultSet r = st.executeQuery("select manager_id from staff where id='"+index+"'"); //run your query
					int managerId = 0;
					  while(r.next()){
					  managerId = r.getInt("manager_id");
					}
					  if(managerId == 0){
				      // execute the java preparedstatement
				      preparedStmt.executeUpdate();
				      lbl_deAccept.setVisible(false);
				      lbl_accept.setVisible(true);
				     }
					  else{
						  System.out.println("not accept");
						  lbl_accept.setVisible(false);
						  lbl_deAccept.setVisible(true);
					  }
					  
					  
					  
						
						list = new JList();
					
						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/hotel_management_system", "root", "");
						 DefaultListModel mod = new DefaultListModel(); //create a new list model
						     Statement statement = conn.createStatement();
						    ResultSet resultSet = statement.executeQuery("select * from staff"); //run your query

						    while (resultSet.next()) //go through each row that your query returns
						    {
						        String name = resultSet.getString("name"); //get the element in column "name"
						        String id = resultSet.getString("staff_id"); //get the element in column "id"
						        String location = resultSet.getString("location"); //get the element in column "location"

						        String row = id + "              " + name + "            "+location;
						        
						        mod.addElement(row); //add each item to the model
						    }
						    list.setModel(mod);
						    list.setVisibleRowCount(5);
							list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
							scroll = new JScrollPane(list);
							search_body.add(scroll).setBounds(50, 70, 560, 200);

					  
				      
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//------------ end Update Query ----------------------------------------------------------------------------------------
			
			
		}
		
	}
	
	
	
	}



