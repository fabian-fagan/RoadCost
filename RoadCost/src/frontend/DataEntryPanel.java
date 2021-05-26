package frontend;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DataEntryPanel extends JPanel {
	public static final int GRID_SIZE = 50;

	public DataEntryPanel() {
		super();
		setPreferredSize(new Dimension(600, 600));
		ImageComponent titleImage = new ImageComponent("assets/brrr.png");
		titleImage.setPreferredSize(new Dimension(500, 250));
		add(titleImage);
		createFields();

	}

	public void createFields() {
		// Question 1
		JPanel one = new JPanel();
		JLabel q1 = new JLabel();
		q1.setText("<html><h2>Type of vehicle:</h2></html>");
		one.add(q1);
		JRadioButton sedan = new JRadioButton("Sedan");
		JRadioButton SUV = new JRadioButton("SUV");
		JRadioButton truck = new JRadioButton("Truck");
		JRadioButton motorbike = new JRadioButton("Motorbike");
		one.add(sedan);
		one.add(SUV);
		one.add(truck);
		one.add(motorbike);
		add(one);

		// Question 2
		JPanel two = new JPanel();
		JLabel q2 = new JLabel();
		q2.setText("<html><h2>Age of vehicle</h2></html>");
		q2.setBounds(10, 20, 50, 50);
		two.add(q2);
		JTextField textField2 = new JTextField(5);
		textField2.setBounds(5, 5, 280, 50);
		textField2.setFont(textField2.getFont().deriveFont(25f));
		two.add(textField2);
		add(two);

		// Question 3
		JPanel three = new JPanel();
		JLabel q3 = new JLabel();
		q3.setText("<html><h2>Does this vehicle have a diesel engine?</h2></html>");
		q3.setBounds(10, 20, 280, 50);
		three.add(q3);
		JRadioButton isDiesel = new JRadioButton("Yes");
		JRadioButton isNotDiesel = new JRadioButton("No");
		three.add(isDiesel);
		three.add(isNotDiesel);
		add(three);

		// Question 4
		JPanel four = new JPanel();
		JLabel q4 = new JLabel();
		q4.setText("<html><h2>SHmeeeeeeel?</h2></html>");
		q4.setBounds(10, 20, 280, 50);
		four.add(q4);
		JTextField textField4 = new JTextField(5);
		textField4.setBounds(5, 5, 280, 50);
		textField4.setFont(textField4.getFont().deriveFont(25f));
		four.add(textField4);
		add(four);

		setVisible(true);
	}
}
