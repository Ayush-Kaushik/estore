package com.crm.prototype.customer;

public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String address;
    private String phonenumber;
    private String email;

    public CustomerDTO() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }
}
