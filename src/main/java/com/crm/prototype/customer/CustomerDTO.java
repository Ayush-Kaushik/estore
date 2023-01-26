package com.crm.prototype.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String country;

    private String address;

    private String phoneNumber;

    private String email;
}
