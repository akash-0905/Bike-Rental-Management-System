package Service;

import Model.Bike;
import Exception.BikeAlreadyExistedException;
import Exception.BikesnotAvailableException;
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
}
