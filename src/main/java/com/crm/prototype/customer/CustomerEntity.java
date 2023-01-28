package com.crm.prototype.customer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor // this is added for unit test case: canMapCustomerCreateDTOToCustomerEntity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

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

    @Column(name = "email")
    private String email;

    public CustomerEntity(String firstName, String lastName, String country, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}