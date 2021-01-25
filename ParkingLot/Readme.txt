Design a parking lot:

1. we need to analyze what's the use case and the APIs : 

In this project, we consider the vehicle have the different sizes, the parking lot have several levels, the parking lot have the different sizes for different cars.

And for the APIs, we consider to implement the folllowing APIs:
boolean hasSpot(): the input should be a vehicle, and output should be a boolean array;
boolean park(): the input should be a vehicle, and output should be a boolean array;
boolean leave():the input should be a vehicle, and output should be a boolean array;

2. We need to design our class, and for each class, we should define the fields and methods:

enum VehicleSize: because the vehicle sizes are a set of constants, so we can use enum to represent them;

Abstract Class Vehicle: define an abstract method: VehicleSize getSize();

Class car and Class Truck: both of them extends the Vehicle class and need to override the abstract method.

Class ParkingSpot: Fields : final VehicleSize size; Vehicle currentVehicle; 
                   Methods: boolean fit(Vehicle v)
                            void park()
                            void leave()
                            Vehicle getVehicle()
                   constructor: ParkingSpot (VehicleSize size)

Class Level: Fields: final List<ParkingSpot> spots
             Methods: boolean hasSpot(Vehicle v)
                      boolean park(Vehicle v)
                      boolean leanve(Vehicle v)
             constructor: Level(int numOfSpots)

Class ParkingLot: Fields: final Level[] levels
                  Methods: boolean hasSpot(Vehicle v)
                           boolean park(Vehicle v)
                           boolean leave(Vehicle v)

3. Test
We can simulate the whole process in this parking lot: leave, park, hasSpot. If it's not true, return assertException.
                   




