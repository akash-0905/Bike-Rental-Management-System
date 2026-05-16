package Main;

import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
import Model.Bike;
import Service.BikeService;

import java.util.Scanner;

public class MainIndex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BikeService bikeService = new BikeService();

        try {
            System.out.println("Enter Bike ID:");

            int id = sc.nextInt();

            System.out.println("Enter Brand:");
            String brand = sc.next();

            System.out.println("Enter Model:");

            String model = sc.next();

            System.out.println(
                    "Enter Rent Per Day:"
            );

            double rent = sc.nextDouble();

            Bike bike = new Bike(id, brand, model, rent, true);

            bikeService.addBike(bike);

            bikeService.viewBike();
        }

        catch (BikeAlreadyExistedException | BikesnotAvailableException e) {

            System.out.println(e.getMessage());
        }
    }
}