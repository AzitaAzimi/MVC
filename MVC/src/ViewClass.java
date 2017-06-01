import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewClass {
	JFrame frame = new JFrame();
	JLabel nameQuery, lnameQuery, FNameQuery, ageQuery, idQuery, genderQuery;
	JLabel lbl_name, lbl_lname, lbl_fathername, lbl_age, lbl_gender, lbl_id,
			lbl_photo, lbl_search, lbl_header, lbl_header2, lbl_searchName,
			lbl_searchLname, lbl_searchFather, lbl_searchAge, lbl_SearchId,
			lbl_searchGender;
	JTextField name, lname, fathername, age, id, search;
	JRadioButton gender_male, gender_female;
	JButton insert_button, search_button;
	private static JTabbedPane jtp1;

	public ViewClass() {

		JFrame frame = new JFrame("Software MVC Exercise");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(660, 600);
		frame.setLocation(200, 10);

		// JPanel panel = new JPanel();
		jtp1 = new JTabbedPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		jtp1.addTab("Register Student", jp1);
		jtp1.addTab("Search Student", jp2);

		JLabel register_header = new JLabel(new ImageIcon(getClass()
				.getResource("banner.jpg")));
		jp1.add(register_header).setBounds(-2, 2, 645, 140);

		JLabel register_header2 = new JLabel(new ImageIcon(getClass()
				.getResource("banner.jpg")));
		jp2.add(register_header2).setBounds(-2, 2, 645, 140);

		register_header.setBorder(BorderFactory.createLineBorder(Color.blue));
		register_header2.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel register_body = new JLabel(new ImageIcon(getClass().getResource(
				"b3.jpg")));
		jp1.add(register_body).setBounds(-10, 128, 660, 420);

		JLabel search_body = new JLabel(new ImageIcon(getClass().getResource(
				"b3.jpg")));
		jp2.add(search_body).setBounds(-10, 128, 660, 420);

		JLabel b4 = new JLabel(new ImageIcon(getClass().getResource("b4.jpg")));
		register_body.add(b4).setBounds(60, 25, 215, 30);

		JLabel b44 = new JLabel(new ImageIcon(getClass().getResource("b4.jpg")));
		search_body.add(b44).setBounds(60, 25, 165, 30);
		// search_body.add(b4).setBounds(60, 25, 215, 30);

		JLabel border = new JLabel();
		register_body.add(border).setBounds(25, 35, 610, 350);
		border.setBorder(BorderFactory.createLineBorder(Color.blue));

		JLabel border2 = new JLabel();
		search_body.add(border2).setBounds(25, 35, 610, 350);
		border2.setBorder(BorderFactory.createLineBorder(Color.blue));

		// lbl for search tap

		lbl_header = new JLabel("Please Insert Students Information");
		b4.add(lbl_header).setBounds(10, -6, 250, 30);

		lbl_header2 = new JLabel("Please Select the Student");
		b44.add(lbl_header2).setBounds(10, -6, 250, 30);

		lbl_name = new JLabel("Name:");
		name = new JTextField(20);
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);

		lbl_lname = new JLabel("last Name:");
		lbl_lname.setHorizontalAlignment(SwingConstants.RIGHT);
		lname = new JTextField(20);

		lbl_fathername = new JLabel("Father Name:");
		lbl_fathername.setHorizontalAlignment(SwingConstants.RIGHT);
		fathername = new JTextField(20);

		lbl_age = new JLabel("Age:");
		lbl_age.setHorizontalAlignment(SwingConstants.RIGHT);
		age = new JTextField(20);

		lbl_gender = new JLabel("Gender:");
		lbl_gender.setHorizontalAlignment(SwingConstants.RIGHT);

		gender_male = new JRadioButton("Male");
		gender_male.setMnemonic(KeyEvent.VK_N);
		gender_male.setActionCommand("male");
		gender_male.setOpaque(false);

		gender_female = new JRadioButton("Female");
		gender_female.setMnemonic(KeyEvent.VK_N);
		gender_female.setActionCommand("female");
		gender_female.setOpaque(false);

		ButtonGroup group = new ButtonGroup();
		group.add(gender_male);
		group.add(gender_female);

		lbl_id = new JLabel("ID:");
		id = new JTextField(20);
		lbl_id.setHorizontalAlignment(SwingConstants.RIGHT);

		insert_button = new JButton("Record");
		search_button = new JButton("Search");
		// frame.add(panel).setBounds(-11,-3,745, 600);

		register_body.add(lbl_name).setBounds(20, 70, 150, 30);
		register_body.add(name).setBounds(190, 70, 220, 30);

		register_body.add(lbl_lname).setBounds(20, 110, 150, 30);
		register_body.add(lname).setBounds(190, 110, 220, 30);

		register_body.add(lbl_fathername).setBounds(20, 150, 150, 30);
		register_body.add(fathername).setBounds(190, 150, 220, 30);

		register_body.add(lbl_age).setBounds(20, 190, 150, 30);
		register_body.add(age).setBounds(190, 190, 220, 30);

		register_body.add(lbl_id).setBounds(20, 230, 150, 30);
		register_body.add(id).setBounds(190, 230, 220, 30);

		register_body.add(lbl_gender).setBounds(20, 275, 150, 30);
		register_body.add(gender_male).setBounds(185, 275, 100, 30);
		register_body.add(gender_female).setBounds(185, 295, 100, 30);

		register_body.add(insert_button).setBounds(520, 345, 90, 30);

		search = new JTextField(20);
		search_body.add(search_button).setBounds(50, 70, 90, 30);
		search_body.add(search).setBounds(150, 70, 300, 30);

		lbl_searchName = new JLabel("Name:");
		lbl_searchLname = new JLabel("Last Name:");
		lbl_searchFather = new JLabel("Father Name:");
		lbl_searchAge = new JLabel("Age:");
		lbl_SearchId = new JLabel("Id:");
		lbl_searchGender = new JLabel("Gender:");

		lbl_searchName.setVisible(false);
		lbl_searchLname.setVisible(false);
		lbl_searchFather.setVisible(false);
		lbl_searchAge.setVisible(false);
		lbl_SearchId.setVisible(false);
		lbl_searchGender.setVisible(false);

		search_body.add(lbl_searchName).setBounds(80, 120, 100, 30);
		search_body.add(lbl_searchLname).setBounds(80, 155, 100, 30);
		search_body.add(lbl_searchFather).setBounds(80, 195, 100, 30);
		search_body.add(lbl_searchAge).setBounds(80, 230, 100, 30);
		search_body.add(lbl_SearchId).setBounds(80, 265, 100, 30);
		search_body.add(lbl_searchGender).setBounds(80, 300, 100, 30);


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
		frame.add(jtp1).setBounds(10, -132, 740, 40);
		frame.setBackground(Color.blue);
		frame.setVisible(true);

	}

	public static void main(String args[]) {
		new ViewClass();

		JTabbedPane tabbedPane = new JTabbedPane();

		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged1(ChangeEvent changeEvent) {
				jtp1 = (JTabbedPane) changeEvent.getSource();
				int index = jtp1.getSelectedIndex();
				System.out.println("Tab changed to: " + jtp1.getTitleAt(index));
			}

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub

			}
		};
		tabbedPane.addChangeListener(changeListener);

	}
	void addQueryListener(ActionListener query){
		insert_button.addActionListener(query);
		search_button.addActionListener(query);
	}
	
}
