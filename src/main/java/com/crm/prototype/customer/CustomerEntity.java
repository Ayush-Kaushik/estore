package com.crm.prototype.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CustomerEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstname")
    @Getter
    @Setter
    private String firstName;

    @Column(name="lastname")
    @Getter
    @Setter
    private String lastName;

    @Column(name="country")
    @Getter
    @Setter
    private String country;

    @Column(name="address")
    @Getter
    @Setter
    private String address;

    @Column(name = "phonenumber")
    @Getter
    @Setter
    private String phoneNumber;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;
}