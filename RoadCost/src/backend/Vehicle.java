package backend;

public class Vehicle {
	private String type;
	private int age; 
	private boolean isDiesel;
	private int kms;
	private int engineSize;
	
	public Vehicle(String type, int age, boolean isDiesel, int kms, int engineSize) {
		this.type = type;
		this.age = age;
		this.isDiesel = isDiesel; 
		this.kms = kms;
		this.engineSize = engineSize;
				
	}

}
