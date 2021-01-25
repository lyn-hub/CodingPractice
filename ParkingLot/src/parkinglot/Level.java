package parkinglot;

import java.util.*;

public class Level {
	//Fields
	//the final only means the reference to the list is final
	//it doesn't mean the list cannot change
	//so we can use the Collections.unmodifiableList() to get a view.
	private final List<ParkingSpot> spots;
	
	
	//Constructors
	Level (int numOfSpots) {
		List<ParkingSpot> list = new ArrayList<>(numOfSpots);
		int i = 0;
		for (; i < numOfSpots / 2; i++) {
			list.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (; i < numOfSpots; i++) {
			list.add(new ParkingSpot(VehicleSize.Large));
		}
		spots = Collections.unmodifiableList(list);
	}
	
	
	//Methods
	boolean hasSpot(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(v)) {
				return true;
			}
		}
		return false;
	}
	
	boolean park (Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(v)) {
				spot.park(v);
				return true;
			}
		}
		return false;
	}
	
	boolean leave(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.getVehicle() == v) {
				spot.leave(v);
				return true;
			}
		}
		return false;
		
	}

}

