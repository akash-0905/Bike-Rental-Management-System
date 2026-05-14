package Main;

import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
import Exception.BikeNotFoundException;
import Exception.BikeReturnedAvaialbleException;
import Exception.CustomerAlreadyExistedException;
import Exception.CustomerNotFoundException;
import Model.Bike;
import Model.Booking;
import Model.Customer;
import Service.BikeService;
import Service.BookingService;
import Service.CustomerService;

import java.time.LocalDate;


public class MainIndex {
    static void main(String[] args) throws BikesnotAvailableException, BikeNotFoundException {

        BikeService bikeService = new BikeService();
        CustomerService customerService = new CustomerService();
        BookingService bookingService = new BookingService();

        System.out.println("Adding Bike:");
        Bike bike1 = new Bike(101, "Royal GT", "GT650", 650, true);
        Bike bike2 = new Bike(102, "Duke", "Duke350Ktm", 1500, true);
        Bike bike3 = new Bike(103, "HeroHonda", "Splendor", 500, false);

        Customer customer1 = new Customer(1, "Akash", "9876543210");
        Customer customer2 = new Customer(2, "Vijay", "9876543211");
        Customer customer3 = new Customer(3, "Vishnu", "9632581470");


        Booking booking1 = new Booking(1, customer1, bike1, LocalDate.now());
        Booking booking2 = new Booking(2, customer2, bike2, LocalDate.now());
        Booking booking3 = new Booking(3, customer3, bike3, LocalDate.now());

        bookingService.addBooking(booking1);
        bookingService.addBooking(booking2);
        bookingService.addBooking(booking3);
        bookingService.viewBookings();

        try {
            bikeService.addBike(bike1);
            bikeService.addBike(bike2);
//            bikeService.addBike(bike1);
            bikeService.addBike(bike3);
            bikeService.rentBike(115);
        }
        catch (BikeAlreadyExistedException | BikesnotAvailableException | BikeNotFoundException e){
            System.out.println(e.getMessage());
        }

       try{
           bikeService.viewBike();
       }
       catch (BikesnotAvailableException e){
           System.out.println(e.getMessage());
       }

       try{
           bikeService.returnBike(101);
           bikeService.returnBike(101);
       } catch (BikeReturnedAvaialbleException e) {
           System.out.println(e.getMessage());
       }

        try {
            customerService.addCustomer(customer1);
            customerService.addCustomer(customer2);
            customerService.addCustomer(customer1);
            customerService.viewCustomer();
        } catch (CustomerAlreadyExistedException | CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        bikeService.removeBike(103);

        bikeService.updateBikeRent(101, 2000);

        bikeService.viewBike();

    }
}




