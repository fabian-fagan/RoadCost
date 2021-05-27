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
		System.out.println("total cost: " + this.calculator.calculateTotalCost()); 

	}

	@Override
	protected void paintComponent(Graphics g) {

	}
}