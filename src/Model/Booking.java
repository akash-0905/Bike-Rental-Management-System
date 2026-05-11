package Model;

import java.time.LocalDate;

public class Booking {
    private int bookingId;

    private Customer customer;

    private Bike bike;

    private LocalDate bookingDate;

    public Booking(int bookingId,
                   Customer customer,
                   Bike bike,
                   LocalDate bookingDate) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.bike = bike;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bike getBike() {
        return bike;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {

        return "Booking{" +
                "bookingId=" + bookingId +
                ", customer=" + customer.getCustomerName() +
                ", bike=" + bike.getBrand() +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
