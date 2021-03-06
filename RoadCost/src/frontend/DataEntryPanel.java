package frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
* The DataEntryPanel presents the user with fields to fill out about vehicle attributes.
* The GUI then uses these values to construct a ResultsPanel.
*
* @author  Fabian Fagan
*/

public class DataEntryPanel extends JPanel {
	private String vehicleType;
	private boolean isDiesel; 
	private int engineSize;
	private int kmsDriven;
	private int age;
	private JTextField kmTextField;
	private JTextField sizeTextField;
	private JTextField ageTextField; 
	private boolean typeSelected;
	private boolean dieselSelected;
	
	/**
	 * Construct a DataEntryPanel with fields for user input
	 */
	public DataEntryPanel() {
		super();
		setPreferredSize(new Dimension(600, 600));
		ImageComponent titleImage = new ImageComponent("assets/data_image.png");
		titleImage.setPreferredSize(new Dimension(500, 250));
		add(titleImage);
		createFields();
	}
     
	/**
	 * Creates fields for user input which are stored as individual panels
	 * and then added to the parent DataEntryPanel.
	 */
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
		q2.setText("<html><h3>What year was the vehicle made?</h3></html>");
		age.add(q2);
		this.ageTextField = new JTextField(5);
		this.ageTextField.setFont(this.ageTextField.getFont().deriveFont(25f));
		age.add(this.ageTextField);

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
		this.sizeTextField = new JTextField(5);
		this.sizeTextField.setFont(this.sizeTextField.getFont().deriveFont(25f));
		size.add(this.sizeTextField);

		// Question 5
		JPanel distance = new JPanel();
		JLabel q5 = new JLabel();
		q5.setText("<html><h3>How many KMs do you drive per week?</h3></html>");
		distance.add(q5);
		this.kmTextField = new JTextField(5);
		this.kmTextField.setFont(this.kmTextField.getFont().deriveFont(25f));
		distance.add(this.kmTextField);

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
				typeSelected = true; 
				setVehicleType("standard");
			}
		});
		van.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sedan.setSelected(false);
				motorbike.setSelected(false);
				truck.setSelected(false);
				typeSelected = true; 
				setVehicleType("van");
			}
		});
		truck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				van.setSelected(false);
				motorbike.setSelected(false);
				sedan.setSelected(false);
				typeSelected = true; 
				setVehicleType("truck");
			}
		});
		motorbike.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				van.setSelected(false);
				sedan.setSelected(false);
				truck.setSelected(false);
				typeSelected = true; 
				setVehicleType("motorbike");
			}
		});
		isDiesel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isNotDiesel.setSelected(false);
				dieselSelected = true;
				setIsDiesel(true);
			}
		});
		isNotDiesel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isDiesel.setSelected(false);
				dieselSelected = true;
				setIsDiesel(false);
			}
		});

	}
	 
	/**
	 * Confirms/saves the current values given in the field
	 * 
	 * @return true/false based on whether the inputs are valid
	 * and completed
	 */
	public boolean confirmInput() {
		if (this.typeSelected && this.dieselSelected) {
			try {
				setKmsDriven(Integer.parseInt(this.kmTextField.getText()));
				setEngineSize(Integer.parseInt(this.sizeTextField.getText()));
				setAge(Integer.parseInt(this.ageTextField.getText()));
				return true;
		        
		    } catch (NumberFormatException nfe) {
		    	JOptionPane.showMessageDialog(null, "Please enter valid numbers");
		    	return false;
		    }
		}
		else {
			JOptionPane.showMessageDialog(null, "Please answer every question");
			return false;
		}
	}
	
	/**
	 * Getter and setter methods for vehicle information
	 */
	
	public String getVehicleType() {
		return this.vehicleType;
	}
	
	public boolean getIsDiesel() {
		return this.isDiesel;
	}
	
	public int getEngineSize() {
		return this.engineSize;
	}
	
	public int getKmsDriven() {
		return this.kmsDriven;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setVehicleType(String type) {
		this.vehicleType = type;
	}
	
	public void setIsDiesel(Boolean value) {
		this.isDiesel = value;
	}
	
	public void setEngineSize(int value) {
		this.engineSize = value;
	}
	
	public void setKmsDriven(int value) {
		this.kmsDriven = value;
	}
	
	public void setAge(int value) {
		this.age = value;
	}

}
