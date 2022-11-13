package easy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 1603. Design Parking System
 */
public class DesignParkingSystem {
    public static void main(String[] args) {
        // ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
        // [[1, 1, 0], [1], [2], [3], [1]]
        // Output
        // [null, true, true, false, false]
        //
        // Explanation
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        assertTrue(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        assertTrue(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        assertFalse(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
        assertFalse(parkingSystem.addCar(1)); // return false because there is no available slot for a big car. It is already occupied.
    }
}

class ParkingSystem {
    private int[] parking;

    public ParkingSystem(int big, int medium, int small) {
        parking = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        int remaining = parking[carType - 1];
        if (remaining > 0) {
            parking[carType - 1] = remaining - 1;
//            --parking[carType - 1];
            return true;
        }
        return false;
    }
}