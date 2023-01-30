package com.crm.prototype.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String country;

    private String address;

    private String phoneNumber;

    private String email;

    public CustomerDTO(String firstName, String lastName, String country, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
