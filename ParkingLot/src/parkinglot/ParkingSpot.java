package parkinglot;

public class ParkingSpot {
	//Fields
	private final VehicleSize size;
	private Vehicle currentVehicle;
	
	//Constructor
	ParkingSpot (VehicleSize size) {
		this.size = size;
	}
	
	//method
	boolean fit(Vehicle v) {
		//when there is no vehicle in this 
		//spot and the spot size equal or larger than the vehicle size
		return currentVehicle == null && v.getSize().getSize() <= size.getSize();
	}
	
	void park(Vehicle v) {
		currentVehicle = v;
	}
	
	void leave(Vehicle v) {
		currentVehicle = null;
	}
	
	Vehicle getVehicle() {
		return currentVehicle; 
	}

}