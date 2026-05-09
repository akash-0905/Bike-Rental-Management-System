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
import Service.CustomerService;


public class MainIndex {
    static void main(String[] args) throws BikesnotAvailableException {

        BikeService bikeService = new BikeService();
        CustomerService customerService = new CustomerService();

        System.out.println("Adding Bike:");
        Bike bike1 = new Bike(101, "Royal GT", "GT650", 650, true);
        Bike bike2 = new Bike(102, "Duke", "Duke350Ktm", 1500, true);
        Bike bike3 = new Bike(103, "HeroHonda", "Splendor", 500, false);

        Customer customer1 = new Customer(1, "Akash", "9876543210");
        Customer customer2 = new Customer(2, "Vijay", "9876543211");

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
    }
}




