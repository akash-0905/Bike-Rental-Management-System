package Service;

import Model.Bike;
import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
import Exception.BikeNotFoundException;
import Exception.BikeReturnedAvaialbleException;
import java.util.ArrayList;

public class BikeService {

        ArrayList<Bike> bikes = new ArrayList<>();

        public void addBike(Bike bike) throws BikeAlreadyExistedException {
            if(bikes.contains(bike)){
                throw new BikeAlreadyExistedException("Bike is Already Existed");
            }else{
                bikes.add(bike);
                System.out.println("new bikes Added Successfully");
            }
        }

        public void viewBike() throws BikesnotAvailableException {
        if(bikes.isEmpty()){
            throw new BikesnotAvailableException("Bike not Available");
        }
            for(Bike bike : bikes){
                System.out.println(bike);
            }
        }

        public void rentBike(int bikeId) throws BikesnotAvailableException,
                BikeNotFoundException {
            boolean found = false;

            for(Bike bike : bikes){
                if(bike.getBikeId() == bikeId){
                    found = true;

                    if(bike.isAvailable()){
                        bike.setAvailable(false);
                        System.out.println("Bike rented Successfully");
                    }
                    else{
                        throw new BikesnotAvailableException("Bike already rented");
                    }
                }
            }

            if(!found){
                throw new BikesnotAvailableException("Bike Id not Found");
            }
    }

    public void returnBike(int bikeId) throws BikeReturnedAvaialbleException, BikesnotAvailableException {
            boolean returned = false;
            for(Bike bike : bikes ){

                if(bike.getBikeId() == bikeId){
                    returned = true;

                    if(!bike.isAvailable()){
                        bike.setAvailable(true);
                        System.out.println("Bike Returned Successfully");
                    }else{
                        throw new BikeReturnedAvaialbleException("Bike Returned, so Bike is Available");
                    }
                }
            }
            if(!returned){
                throw new BikesnotAvailableException("Bike is not returned");
            }

    }

    public void searchBikeById(int bikeId) throws BikeNotFoundException {
        boolean found = false;
        for (Bike bike : bikes) {
            if (bike.getBikeId() == bikeId) {
                found = true;
                System.out.println(bike);
            }
        }
        if (!found) {
            throw new BikeNotFoundException(
                    "Bike ID Not Found"
            );
        }
    }
    public void searchBikeByBrand(String brand) throws BikeNotFoundException {
        boolean found = false;
        for (Bike bike : bikes) {
            if (bike.getBrand().equalsIgnoreCase(brand)) {
                found = true;
                System.out.println(bike);
            }
        }
        if (!found) {
            throw new BikeNotFoundException("Bike Brand Not Found");
        }
    }
    public void viewAvailableBikes() {
        boolean found = false;
        for (Bike bike : bikes) {

            if (bike.isAvailable()) {
                found = true;
                System.out.println(bike);
            }
        }
        if (!found) {
            System.out.println("No Available Bikes");
        }
    }
    public void viewRentedBikes() {
        boolean found = false;
        for (Bike bike : bikes) {
            if (!bike.isAvailable()) {
                found = true;
                System.out.println(bike);
            }
        }
        if (!found) {
            System.out.println("No Rented Bikes");
        }
    }
    public void removeBike(int bikeId) throws BikeNotFoundException {

        boolean found = false;

        for (Bike bike : bikes) {
            if (bike.getBikeId() == bikeId) {
                found = true;
                if (!bike.isAvailable()) {
                    System.out.println("Cannot Remove Rented Bike");
                    return;
                }
                bikes.remove(bike);
                System.out.println("Bike Removed Successfully");
                return;
            }
        }
        if (!found) {
            throw new BikeNotFoundException("Bike ID Not Found");
        }
    }
    public void updateBikeRent(int bikeId, double newRentPerDay) throws BikeNotFoundException {
        boolean found = false;
        for (Bike bike : bikes) {
            if (bike.getBikeId() == bikeId) {
                found = true;
                bike.setRentPerDay(newRentPerDay);
                System.out.println("Bike Rent Updated");
            }
        }
        if (!found) {
            throw new BikeNotFoundException("Bike ID Not Found");
        }
    }

    public void totalBikesCount() {

        System.out.println("Total Bikes : " + bikes.size());
    }

    public void estimatedRevenue() {

        double revenue = 0;

        for (Bike bike : bikes) {

            if (!bike.isAvailable()) {

                revenue += bike.getRentPerDay();
            }
        }

        System.out.println(
                "Estimated Revenue : ₹" + revenue
        );
    }

    public void mostExpensiveBike()
            throws BikeNotFoundException {

        if (bikes.isEmpty()) {

            throw new BikeNotFoundException(
                    "No Bikes Available"
            );
        }

        Bike expensiveBike = bikes.get(0);

        for (Bike bike : bikes) {

            if (bike.getRentPerDay() >
                    expensiveBike.getRentPerDay()) {

                expensiveBike = bike;
            }
        }

        System.out.println("\nMost Expensive Bike:");

        System.out.println(expensiveBike);
    }

    public void cheapestBike() throws BikeNotFoundException {

        if (bikes.isEmpty()) {
            throw new BikeNotFoundException("No Bikes Available");
        }

        Bike cheapestBike = bikes.get(0);

        for (Bike bike : bikes) {

            if (bike.getRentPerDay() < cheapestBike.getRentPerDay()) {
                cheapestBike = bike;
            }
        }

        System.out.println("\nCheapest Bike:");

        System.out.println(cheapestBike);
    }

}
