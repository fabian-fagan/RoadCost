package frontend;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import backend.Calculator;
import backend.Vehicle;

/**
* The ResultsPanel provides the user with results of their vehicle cost calculations.
*
* @author  Fabian Fagan
*/

public class ResultsPanel extends JPanel {
	private Calculator calculator; 

	public ResultsPanel(Vehicle vehicle) {
		super(); 
		setPreferredSize(new Dimension(600, 600));
		this.calculator = new Calculator(vehicle);
		System.out.println("Fuel cost: $" + this.calculator.calculateFuelCost()); 
		System.out.println("RUC cost: $" + this.calculator.calculateRUCRateCost()); 
		System.out.println("Rego cost: $" + this.calculator.calculateRegoCost()); 
		System.out.println("Total cost: $" + this.calculator.calculateTotalCost()); 
		System.out.println("You will need a Warrant of Fitness every " + this.calculator.calculateWOFFrequency() + " months."); 
		

	}

	@Override
	protected void paintComponent(Graphics g) {

	}
}