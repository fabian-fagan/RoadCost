package frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import backend.Vehicle;

public class GUI extends JFrame {

	private ResultsPanel resultsPanel;
	private DataEntryPanel dataPanel;

	public GUI() {	
		//Create GUI with inital data entry panel
		super("Road Cost");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createDataEntryPanel();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createDataEntryPanel() {
		this.dataPanel = new DataEntryPanel();
		JMenuBar menu = new JMenuBar();
		final JMenuItem reset = new JMenuItem("Reset");
		JMenuItem quit = new JMenuItem("Quit");
		JButton confirm = new JButton("Confirm");
		confirm.setPreferredSize(new Dimension(320, 50));
		this.dataPanel.add(confirm);
		add(this.dataPanel);
		menu.add(reset);
		menu.add(quit);
		setJMenuBar(menu);
		
		// Add listeners to menu items.
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(dataPanel);
				dataPanel = new DataEntryPanel();
				JButton confirm = new JButton("Confirm");
				confirm.setPreferredSize(new Dimension(320, 50));
				dataPanel.add(confirm);
				add(dataPanel);
				createDataEntryPanel();
				pack();
				setVisible(true);
			}
		});

		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Save text field responses
				dataPanel.confirmTextInput();
				
				//Construct a vehicle based on responses
				String type = dataPanel.getVehicleType();
				int age = dataPanel.getAge();
				boolean isDiesel = dataPanel.getIsDiesel();
				int kms = dataPanel.getKmsDriven();
				int engineSize = dataPanel.getEngineSize();
				Vehicle vehicle = new Vehicle(type, age, isDiesel, kms, engineSize);
				
				//Create results panel based on vehicle
				resultsPanel = new ResultsPanel(vehicle);
			}
		});

	}

	public static void main(String[] args) {
		new GUI();
	}
}
