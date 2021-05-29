package backend;

/**
 * A Vehicle object stores information about a described vehicle based on values
 * from the DataEntryPanel.
 *
 * @author Fabian Fagan
 */

public class Vehicle {
	private String type;
	private int age;
	private boolean isDiesel;
	private int kms;
	private int engineSize;
	
	/**
	 * Construct a Vehicle based on attributes given from the DataEntryPanel
	 */
	public Vehicle(String type, int age, boolean isDiesel, int kms, int engineSize) {
		this.type = type;
		this.age = age;
		this.isDiesel = isDiesel;
		this.kms = kms;
		this.engineSize = engineSize;

	}

	/**
	 * Getter methods for vehicle attributes
	 */
	public boolean isDiesel() {
		return isDiesel;
	}

	public String getType() {
		return type;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public int getKms() {
		return kms;
	}

	public int getAge() {
		return age;
	}

}
