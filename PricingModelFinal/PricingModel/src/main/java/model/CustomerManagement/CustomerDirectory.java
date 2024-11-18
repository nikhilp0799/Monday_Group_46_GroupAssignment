/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.Map;

import model.Business.Business;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */

public class CustomerDirectory {

    private Business business;
    private ArrayList<CustomerProfile> customerList;

    public CustomerDirectory(Business business) {
        this.business = business;
        this.customerList = new ArrayList<>();
    }

    public CustomerProfile newCustomerProfile(Person p) {
        CustomerProfile customerProfile = new CustomerProfile(p);
        customerList.add(customerProfile);
        return customerProfile;
    }

    public ArrayList<CustomerProfile> getCustomers() {
        return customerList;
    }

    public CustomerProfile findCustomer(String id) {
        for (CustomerProfile customerProfile : customerList) {
            if (customerProfile.isMatch(id)) {
                return customerProfile;
            }
        }
        return null; // Not found after going through the whole list
    }

    public CustomersReport generateCustomerPerformanceReport() {
        CustomersReport customersReport = new CustomersReport();

        for (CustomerProfile customerProfile : customerList) {
            CustomerSummary customerSummary = new CustomerSummary(customerProfile);
            customersReport.addCustomerSummary(customerSummary);
        }
        return customersReport;
    }

    public void generateCustomers(String[][] customersData) {
        for (String[] customerData : customersData) {
            // Assuming customerData contains: [id, name]
            String id = customerData[0]; // Assuming the first index is ID
            String name = customerData[1]; // Assuming the second index is Name

            // Create a Person instance with only ID
            Person person = new Person(id);
            newCustomerProfile(person);
        }
    }

    public static void main(String[] args) {
        Business business = new Business("Example Business");
        CustomerDirectory customerDirectory = new CustomerDirectory(business);

        // Sample customer data
        String[][] sampleCustomerData = {
            {"C001", "Alice Smith"},
            {"C002", "Bob Johnson"},
            {"C003", "Charlie Brown"}
        };

        // Generate customers from sample data
        customerDirectory.generateCustomers(sampleCustomerData);

        // Print generated customers
        System.out.println("Generated Customers:");
        for (CustomerProfile cp : customerDirectory.getCustomers()) {
            System.out.println(cp);
        }
    }
}