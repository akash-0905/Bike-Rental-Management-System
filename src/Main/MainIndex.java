package Main;

import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
import Exception.BikeNotFoundException;
import Model.Bike;
import Service.BikeService;


public class MainIndex {
    static void main(String[] args) {

        BikeService bikeService = new BikeService();
        System.out.println("Adding Bike:");
        Bike bike1 = new Bike(101, "Royal GT", "GT650", 650, true);
        Bike bike2 = new Bike(102, "Duke", "Duke350Ktm", 1500, true);
        Bike bike3 = new Bike(103, "HeroHonda", "Splendor", 500, false);

        try {
            bikeService.addBike(bike1);
            bikeService.addBike(bike2);
//            bikeService.addBike(bike1);
            bikeService.addBike(bike3);

            bikeService.rentBike(102);

            bikeService.viewBike();
        }
        catch (BikeAlreadyExistedException | BikesnotAvailableException | BikeNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}




