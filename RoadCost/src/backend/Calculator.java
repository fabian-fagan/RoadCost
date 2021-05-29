package backend;

/**
 * The Calculator class performs calculations based on vehicle attributes.
 *
 * @author Fabian Fagan
 */ 

public class Calculator {
	private Vehicle vehicle;

	public Calculator(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Calculates estimated fuel cost per year based on engine size and kilometers
	 * driven per week.
	 * These numbers are just estimates as the make/model of the car are also important
	 * for fuel consumption.
	 * 
	 * @return double estimated fuel cost.
	 */
	public double calculateFuelCost() {
		double cost = 0;
		double kmPerLitre = 0;
		double oneLitrePetrolCost = 2; //assume petrol is $2 per litre
		double oneLitreDieselCost = 1.4; //assume diesel is $1.4 per litre
		double engineSize = this.vehicle.getEngineSize();
		if (this.vehicle.getType().equals("motorbike")) {
			kmPerLitre = 45; //average rate for motorbikes	
		}
		else if (engineSize < 1500) {
			kmPerLitre = 15;
		}
		else if ((engineSize > 1500) && (engineSize < 2000)) {
			kmPerLitre = 12;
		}
		else if ((engineSize > 2000) && (engineSize < 3000)) {
			kmPerLitre = 10;
		}
		else {
			kmPerLitre = 8; //over 3000cc, worst case 
		}
		double kmsPerWeek = vehicle.getKms();
		double kmsPerYear = kmsPerWeek * 52;
		double litresPerYear = kmsPerYear / kmPerLitre; 
		if (this.vehicle.isDiesel()) {
			cost = oneLitreDieselCost * litresPerYear; 
		}
		else {
			cost = oneLitrePetrolCost * litresPerYear; 
		}

		return Math.round(cost * 100.0) / 100.0; //2dp
	}

	/**
	 * Calculates RUC rate for diesel vehicle road use charges in New Zealand.
	 * Standard rate is as follows: Sedan (or motorbike) = $72 p/1000km Van = $78
	 * p/1000km Truck = $159 p/1000km
	 * 
	 * Calculations based on vehicle type and kilometers driven per week
	 * 
	 * @return double estimated RUC rate per year.
	 */
	public double calculateRUCRateCost() {
		if (!this.vehicle.isDiesel()) {
			return 0; // No cost for petrol vehicles
		}
		String type = this.vehicle.getType();
		double cost = 0;
		double kmsPerWeek = vehicle.getKms();
		double kmsPerYear = kmsPerWeek * 52;
		double setsOf1000km = kmsPerYear / 1000;
		if (type.equals("standard") || type.equals("motorbike")) {
			cost = 72 * setsOf1000km;
		} 
		else if (type.equals("van")) {
			cost = 78 * setsOf1000km;
		} 
		else { // truck
			cost = 159 * setsOf1000km;
		}

		return Math.round(cost * 100.0) / 100.0; //2dp
	}

	/**
	 * Calculates estimated registration cost per year based on vehicle type and
	 * type of gas used
	 * 
	 * For information about values used, visit:
	 * https://www.nzta.govt.nz/vehicles/licensing-rego/vehicle-fees/licensing-fees/
	 * 
	 * @return double estimated rego cost.
	 */
	public double calculateRegoCost() {
		String type = this.vehicle.getType();
		boolean isDiesel = this.vehicle.isDiesel();
		double cost = 0;
		if (type.equals("standard")) {
			if (isDiesel) {
				cost = 176;
			} 
			else {
				cost = 109;
			}
		} 
		else if (type.equals("van")) {
			if (isDiesel) {
				cost = 195;
			} 
			else {
				cost = 127;
			}
		}
		else if (type.equals("motorbike")) { //cost is based on engine size for motorbike
			int engineSize = this.vehicle.getEngineSize();
			
            if (engineSize < 60)  {
            	cost = 394;
            }
            else if ((engineSize > 60) && (engineSize < 600))  {
            	cost = 405;
            }
            else {
            	cost = 519;
            }
		}
		else  { //truck
			if (isDiesel) {
				cost = 335;
			} 
			else {
				cost = 195;
			}
		}

		return Math.round(cost * 100.0) / 100.0; //2dp
	}
	
	/**
	 * Calculates whether the vehicle needs a WOF every 6 months or 12 months based on age
	 * 
	 * @return int number of months each WOF lasts
	 */
	public int calculateWOFFrequency() {
		int yearMade = vehicle.getAge(); 
		if (yearMade < 2001) {
			return 6; 
		}
		else {
			return 12; 
		}
	}

	/**
	 * Calculates total estimated cost per year based on all calculations
	 * 
	 * @return int estimated total yearly cost.
	 */
	public double calculateTotalCost() {
		double totalCost = 0;
		totalCost = calculateFuelCost() + calculateRUCRateCost() + calculateRegoCost();
		return Math.round(totalCost * 100.0) / 100.0; //2dp
	}

}
