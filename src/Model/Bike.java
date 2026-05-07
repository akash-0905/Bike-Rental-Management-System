package Model;

public class Bike {

    private int bikeId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean available;

    public Bike(int bikeId, String brand, String model, double rentPerDay, boolean available) {
        this.bikeId = bikeId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = available;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getBikeId() {
        return bikeId;
    }

    public boolean isAvailable(){
        return available;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + getBikeId() +
                ", brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", rentPerDay=" + getRentPerDay() +
                ", available=" + isAvailable() +
                '}';
    }
}
