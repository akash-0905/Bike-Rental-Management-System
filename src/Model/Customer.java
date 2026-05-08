package Model;

public class Customer {
    private int customerId;
    private String customerName;
    private String phoneNumber;

    public Customer(int customerId,
                    String customerName,
                    String phoneNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {

        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
