package com.crm.prototype.customer;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String Address;
    private String Number;

    public Customer(int id, String firstName, String lastName, String country, String address, String number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        Address = address;
        Number = number;
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
        return Address;
    }

    public String getNumber() {
        return Number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setNumber(String number) {
        Number = number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", Address='" + Address + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}