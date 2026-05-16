package Main;

import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
import Exception.BikeNotFoundException;
import Exception.BikeReturnedAvaialbleException;
import Exception.CustomerAlreadyExistedException;
import Exception.CustomerNotFoundException;

import Model.Bike;
import Model.Customer;

import Service.BikeService;
import Service.BookingService;
import Service.CustomerService;

import java.util.Scanner;

public class MainIndex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BikeService bikeService = new BikeService();
        CustomerService customerService = new CustomerService();
        BookingService bookingService = new BookingService();

        while (true) {

            System.out.println(
                    "\n Bike Rental System"
            );

            System.out.println("1. Add Bike");
            System.out.println("2. View Bikes");
            System.out.println("3. Rent Bike");
            System.out.println("4. Return Bike");
            System.out.println("5. Search Bike By ID");
            System.out.println("6. Search Bike By Brand");
            System.out.println("7. Remove Bike");
            System.out.println("8. Update Bike Rent");
            System.out.println("9. View Available Bikes");
            System.out.println("10. View Rented Bikes");

            System.out.println("11. Add Customer");
            System.out.println("12. View Customers");

            System.out.println("13. View Booking History");

            System.out.println("14. Total Bikes Count");
            System.out.println("15. Estimated Revenue");
            System.out.println("16. Most Expensive Bike");
            System.out.println("17. Cheapest Bike");

            System.out.println("18. Exit");

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

                    try {
                        System.out.println("\nEnter Bike ID to Return:");
                        int bikeId = sc.nextInt();

                        bikeService.returnBike(bikeId);
                    }

                    catch (BikeReturnedAvaialbleException | BikesnotAvailableException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:

                    try {
                        System.out.println("\nEnter Bike ID to Search:");
                        int bikeId = sc.nextInt();

                        bikeService.searchBikeById(bikeId);
                    }

                    catch (BikeNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 6:

                    try {
                        System.out.println("\nEnter Brand Name:");
                        String brand = sc.next();

                        bikeService.searchBikeByBrand(brand);
                    }

                    catch (BikeNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 7:

                    try {
                        System.out.println("\nEnter Bike ID to Remove:");
                        int bikeId = sc.nextInt();

                        bikeService.removeBike(bikeId);
                    }

                    catch (BikeNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 8:

                    try {
                        System.out.println("\nEnter Bike ID:");
                        int bikeId = sc.nextInt();

                        System.out.println("Enter New Rent:");
                        double newRent = sc.nextDouble();

                        bikeService.updateBikeRent(bikeId, newRent);
                    }

                    catch (BikeNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 9:

                    bikeService.viewAvailableBikes();

                    break;

                case 10:

                    bikeService.viewRentedBikes();

                    break;

                case 11:

                    try {

                        System.out.println("\nEnter Customer ID:");
                        int customerId = sc.nextInt();

                        System.out.println("Enter Customer Name:");
                        String customerName = sc.next();

                        System.out.println("Enter Phone Number:");
                        String phone = sc.next();

                        Customer customer = new Customer(customerId, customerName, phone);

                        customerService.addCustomer(customer);
                    }

                    catch (CustomerAlreadyExistedException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 12:

                    try {
                        customerService.viewCustomer();
                    }

                    catch (CustomerNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 13:

                    bookingService.viewBookings();

                    break;

                case 14:

                    bikeService.totalBikesCount();

                    break;

                case 15:

                    bikeService.estimatedRevenue();

                    break;

                case 16:

                    try {

                        bikeService.mostExpensiveBike();

                    }

                    catch (BikeNotFoundException e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }

                    break;

                case 17:

                    try {
                        bikeService.cheapestBike();
                    }

                    catch (BikeNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 18:

                    System.out.println("Exiting Application");

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}