package com.web_project.aau_laundry_system.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
public class User implements UserDetails {
    @Id
    @NotNull(message = "Username can not be blank")
    private String username; // student ID
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;
    @NotBlank(message = "Field can not be blank")
    private String firstName;
    @NotBlank(message = "Field can not be blank")
    private String lastName;
    @Email(regexp = "^(.+)@(.+)\\.([a-z]{2,3})$",message = "Invalid Email")
    private String email;
    private String campus;
    @Pattern(regexp = "^[0][9][0-9]{8}" ,message="Invalid Phone number")
    private String phoneNumber;
    private String role;
    
    public User() {
    }

    public User(String username, String firstName, String lastName, String email, String campus, String role,
            String password, String phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.campus = campus;
        this.password = password;
        this.role=role;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+this.role.toUpperCase()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
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

    



    
}
