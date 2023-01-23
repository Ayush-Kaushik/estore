package com.crm.prototype.customer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CustomerUpdateDTO {
    @Getter
    @Setter
    @NotNull
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
    @NotEmpty
    private String address;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private String email;

    public CustomerUpdateDTO() {

    }

    public CustomerUpdateDTO(int id, String firstName, String lastName, String country, String address, String phonenumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.address = address;
        this.phoneNumber = phonenumber;
        this.email = email;
    }
}
