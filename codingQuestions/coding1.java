``` 
public enum VehicleSize {
	Compact, Large, Regular
}




public class ParkingSpot{
	private final VehicleSize size;
	private Vehicle currentVehicle;
	
	ParkingSpot(VehicleSize size){
		this.size = size;
	}
	
	boolean fit(Vehicle v) {
    if(currentVehicle == null {
	    this.size.getSize() >= v.getSize().getSize();
    }
    return false;
 	}
	private Level[ ] levels;

	public boolean hasSpot(Vehicle v) {
		…
	}
}




public abstract class Vehicle {
	private final String plate;
	public abstract VehicleSize getSize();
}



public class Car extends Vehicle {
	@Override 
	public VehicleSize getSize() {
		return VehicleSize.Compact;
	}
}



public class Truck extends Vehicle {
@Override 
	public VehicleSize getSize() {
		return VehicleSize.Large;
	}

}



public class ParkingLot {
	private final Level[ ] levels;
	  public boolean hasSpot(Vehicle v){
	}

}



public class Level {
	private final List<ParkingSpot> spots;

	Level(int numOfSpots) {
		spots = new ArrayList<>(numOfSpots);
	}
	ParkingSpot[ ] parkingSpot;
	boolean hasSpot(Vehicle v);
  boolean park(Vehicle v);
  boolean leave(Vehicle v);

}
``` 
