package Service;

import Model.Customer;
import Exception.CustomerAlreadyExistedException;
import Exception.CustomerNotFoundException;

import java.util.ArrayList;

public class CustomerService {

        private ArrayList<Customer> customers = new ArrayList<>();

        public void addCustomer(Customer customer) throws CustomerAlreadyExistedException {

            for(Customer existingCustomer : customers){

                if (existingCustomer.getCustomerId() == customer.getCustomerId()) {

                    throw new CustomerAlreadyExistedException("Customer Already Exists");
                }
            }
            customers.add(customer);
            System.out.println("Customer Added Successfully");
        }

        public void viewCustomer() throws CustomerNotFoundException{

            if (customers.isEmpty()) {
                throw new CustomerNotFoundException("No Customers Found");
            }

            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }

    }

