package Service;

import Model.Booking;

import java.util.ArrayList;

public class BookingService {

    private ArrayList<Booking> bookings =  new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booking Added Successfully");
    }

    public void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No Bookings Available");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
