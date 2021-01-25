package parkinglot;

public class ParkingLot {
	//Fields
	private final Level[] levels;
	
	//constructors
	ParkingLot(int numLevels, int numOfSpotsPerLevel) {
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels; i++) {
			levels[i] = new Level(numOfSpotsPerLevel);
		}
	}
	
	//Methods
	public boolean hasSpot(Vehicle v) {
		for (Level l : levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean park(Vehicle v) {
		for (Level l : levels) {
			if (l.park(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leave(Vehicle v) {
		for (Level l : levels) {
			if (l.leave(v)) {
				return true;
			}
		}
		return false;
	}

}
