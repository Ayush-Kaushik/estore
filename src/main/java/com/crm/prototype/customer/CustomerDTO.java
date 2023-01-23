package com.crm.prototype.customer;

import lombok.Getter;
import lombok.Setter;

public class CustomerDTO {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private String email;

    public CustomerDTO() {

    }
}
