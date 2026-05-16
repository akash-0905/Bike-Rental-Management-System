package Main;

import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
import Exception.BikeNotFoundException;
import Exception.BikesnotAvailableException;
import Model.Bike;
import Service.BikeService;

import java.util.Scanner;

public class MainIndex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BikeService bikeService = new BikeService();

        while (true) {

            System.out.println("\n===== Bike Rental System =====");

            System.out.println("1. Add Bike");
            System.out.println("2. View Bikes");
            System.out.println("3. Rent Bike");
            System.out.println("4. Exit");

            System.out.println("\nEnter Your Choice:");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    try {

                        System.out.println("\nEnter Bike ID:");
                        int id = sc.nextInt();

                        System.out.println("Enter Brand:");
                        String brand = sc.next();

                        System.out.println("Enter Model:");
                        String model = sc.next();

                        System.out.println("Enter Rent Per Day:");
                        double rent = sc.nextDouble();

                        Bike bike = new Bike(id, brand, model, rent, true);

                        bikeService.addBike(bike);
                    }

                    catch (BikeAlreadyExistedException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    try {
                        bikeService.viewBike();
                    }
                    catch (BikesnotAvailableException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:

                    try {
                        System.out.println("\nEnter Bike ID to Rent:");

                        int bikeId = sc.nextInt();
                        bikeService.rentBike(bikeId);
                    }

                    catch (BikeNotFoundException | BikesnotAvailableException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    System.out.println("Exiting Application");

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}