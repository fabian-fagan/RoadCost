package frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DataEntryPanel extends JPanel {

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
		JPanel type = new JPanel();
		JLabel q1 = new JLabel();
		q1.setText("<html><h3>Type of vehicle:</h3></html>");
		type.add(q1);
		JRadioButton sedan = new JRadioButton("Sedan/SUV/Hatchback");
		JRadioButton van = new JRadioButton("Van");
		JRadioButton truck = new JRadioButton("Truck");
		JRadioButton motorbike = new JRadioButton("Motorbike");
		type.add(sedan);
		type.add(van);
		type.add(truck);
		type.add(motorbike);

		// Question 2
		JPanel age = new JPanel();
		JLabel q2 = new JLabel();
		q2.setText("<html><h3>Age of vehicle (years)</h3></html>");
		age.add(q2);
		JTextField textField2 = new JTextField(5);
		textField2.setFont(textField2.getFont().deriveFont(25f));
		age.add(textField2);

		// Question 3
		JPanel diesel = new JPanel();
		JLabel q3 = new JLabel();
		q3.setText("<html><h3>Does this vehicle have a diesel engine?</h3></html>");
		diesel.add(q3);
		JRadioButton isDiesel = new JRadioButton("Yes");
		JRadioButton isNotDiesel = new JRadioButton("No");
		diesel.add(isDiesel);
		diesel.add(isNotDiesel);

		// Question 4
		JPanel size = new JPanel();
		JLabel q4 = new JLabel();
		q4.setText("<html><h3>What size engine does the vehicle have? (cc)</h3></html>");
		size.add(q4);
		JTextField textField4 = new JTextField(5);
		textField4.setFont(textField4.getFont().deriveFont(25f));
		size.add(textField4);

		// Question 5
		JPanel distance = new JPanel();
		JLabel q5 = new JLabel();
		q5.setText("<html><h3>How many KMs do you drive per week?</h3></html>");
		distance.add(q5);
		JTextField textField5 = new JTextField(5);
		textField5.setFont(textField5.getFont().deriveFont(25f));
		distance.add(textField5);

		add(type);
		add(diesel);
		add(size);
		add(distance);
		add(age);
		setVisible(true);

		// Add listeners to RadioButtons
		sedan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				van.setSelected(false);
				motorbike.setSelected(false);
				truck.setSelected(false);
			}
		});
		van.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sedan.setSelected(false);
				motorbike.setSelected(false);
				truck.setSelected(false);
			}
		});
		truck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				van.setSelected(false);
				motorbike.setSelected(false);
				sedan.setSelected(false);
			}
		});
		motorbike.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				van.setSelected(false);
				sedan.setSelected(false);
				truck.setSelected(false);
			}
		});
		isDiesel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isNotDiesel.setSelected(false);
			}
		});
		isNotDiesel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isDiesel.setSelected(false);
			}
		});

	}

}
