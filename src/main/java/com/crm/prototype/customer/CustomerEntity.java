package com.crm.prototype.customer;

import jakarta.persistence.*;

@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="country")
    private String country;

    @Column(name="address")
    private String address;

    @Column(name = "phonenumber")
    private String phoneNumber;

    public CustomerEntity(int id, String firstName, String lastName, String country, String address, String phonenumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.address = address;
        this.phoneNumber = phonenumber;
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

    public String getNumber() {
        return phoneNumber;
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
        address = address;
    }

    public void setNumber(String number) {
        phoneNumber = number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", Address='" + address + '\'' +
                ", Number='" + phoneNumber + '\'' +
                '}';
    }
}