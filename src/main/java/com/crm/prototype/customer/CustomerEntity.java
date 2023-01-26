package com.crm.prototype.customer;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
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
}