package frontend;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import backend.Calculator;
import backend.Vehicle;

/**
 * The ResultsPanel provides the user with results of their vehicle cost
 * calculations.
 *
 * @author Fabian Fagan
 */

public class ResultsPanel extends JPanel {
	private Calculator calculator;
     
	/**
	 * Construct a ResultsPanel based on results from Vehicle.
	 */
	public ResultsPanel(Vehicle vehicle) {
		super();
		setPreferredSize(new Dimension(600, 600));
		this.calculator = new Calculator(vehicle);
		ImageComponent titleImage = new ImageComponent("assets/brrr.png");
		titleImage.setPreferredSize(new Dimension(500, 150));
		add(titleImage);
		createResults();
	}
	
	/**
	 * Creates results as individual panels and adds labels to them. 
	 * Individual panels are then added to the parent ResultsPanel.
	 */
	private void createResults() {
		// Fuel
		JPanel fuel = new JPanel();
		JLabel fuelData = new JLabel();
		fuelData.setText("Estimated yearly fuel cost: $" + this.calculator.calculateFuelCost() + "\n");
		fuelData.setFont(fuelData.getFont().deriveFont(18f));
		fuel.add(fuelData);

		// RUC
		JPanel RUC = new JPanel();
		JLabel RUCData = new JLabel();
		if (this.calculator.calculateRUCRateCost() == 0) {
			RUCData.setText("Because your car doesn't use diesel, there are no RUC charges." + "\n");
		} 
		else {
			RUCData.setText("Estimated yearly diesel road use cost: $" + this.calculator.calculateRUCRateCost() + "\n");
		}
		RUCData.setFont(RUCData.getFont().deriveFont(18f));
		RUC.add(RUCData);

		// Rego
		JPanel rego = new JPanel();
		JLabel regoData = new JLabel();
		regoData.setText("Estimated yearly registration cost: $" + this.calculator.calculateRegoCost() + "\n");
		regoData.setFont(regoData.getFont().deriveFont(18f));
		rego.add(regoData);

		// Total
		JPanel total = new JPanel();
		JLabel totalData = new JLabel();
		totalData.setText("Estimated TOTAL cost: $" + this.calculator.calculateTotalCost() + "\n");
		totalData.setFont(totalData.getFont().deriveFont(18f));
		total.add(totalData);

		// WOF
		JPanel wof = new JPanel();
		JLabel wofData = new JLabel();
		wofData.setText("You will need a Warrant of Fitness every " + this.calculator.calculateWOFFrequency() + " months.\n");
		wofData.setFont(wofData.getFont().deriveFont(18f));
		wof.add(wofData);

		
		add(fuel);
		add(RUC);
		add(rego);
		add(total);
		add(wof);

	}
}