package frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import backend.Vehicle;

/**
* The GUI class controls the front-end and is the entry point of the program.
*
* @author  Fabian Fagan
*/

public class GUI extends JFrame {
	private ResultsPanel resultsPanel;
	private DataEntryPanel dataPanel;

	/**
	 * Construct a GUI with inital data entry panel.
	 */
	public GUI() {	
		super("Road Cost");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createDataEntryPanel();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Creates the DataEntryPanel and menu items (confirm/reset). 
	 */
	private void createDataEntryPanel() {
		this.dataPanel = new DataEntryPanel();
		JMenuBar menu = new JMenuBar();
		final JMenuItem reset = new JMenuItem("Reset");
		JButton confirm = new JButton("Confirm");
		confirm.setPreferredSize(new Dimension(320, 50));
		this.dataPanel.add(confirm);
		add(this.dataPanel);
		menu.add(reset);
		setJMenuBar(menu);
		
		// Add listeners to menu items.
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(dataPanel);
				createDataEntryPanel();
				pack();
				setVisible(true);
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Save text field responses
				Boolean validAnswers = dataPanel.confirmInput();
				
				//Construct a vehicle based on responses
				if (validAnswers) {
					String type = dataPanel.getVehicleType();
					int age = dataPanel.getAge();
					boolean isDiesel = dataPanel.getIsDiesel();
					int kms = dataPanel.getKmsDriven();
					int engineSize = dataPanel.getEngineSize();
					Vehicle vehicle = new Vehicle(type, age, isDiesel, kms, engineSize);
					
					//Create results panel based on vehicle
					resultsPanel = new ResultsPanel(vehicle);
					remove(dataPanel);
					setVisible(false);
					add(resultsPanel);
					setVisible(true);
				}				
			}
		});
	}

	public static void main(String[] args) {
		new GUI();
	}
}
