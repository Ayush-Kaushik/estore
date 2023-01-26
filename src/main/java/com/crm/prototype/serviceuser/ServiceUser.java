package com.crm.prototype.serviceuser;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



@Data // generates getters and setters for all fields
@Builder // helps to easily build object using Builder design pattern
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "serviceuser") // if we do not provide the table name via this annotation then class name will be used as one
public class ServiceUser implements UserDetails {

    @Id // tells that this field is a unique identifier for the ServiceUser entity - primary key
    @GeneratedValue(strategy = GenerationType.UUID) // this will make the ID auto-generated if the value is null
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    // EnumType.ORDINAL = 0,1,2,3,4.....
    // EnumType.STRING = takes string value
    @Enumerated(EnumType.STRING) // tells spring
    private Role role;

    // should return a list of roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())); // role.name gets string value of role enum
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // we will not be able to connect our users
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // by default when we implemented the interface, it has getPassword() method but
    // it was not overridden, that is because we already have an attribute defined with
    // lombock attribute assigned to it so we have to override our lombok getter here which also
    // overrides the interface's method
    @Override
    public String getPassword() {
        return password;
    }
}
