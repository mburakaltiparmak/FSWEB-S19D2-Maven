package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer",schema = "fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    @NotNull(message = "Firstname field cannot be null!")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Lastname field cannot be null!")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "Email field cannot be null!")
    @Email
    private String email;

    @Column(name = "salary")
    @NotNull(message = "Salary field cannot be null!")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();
}
