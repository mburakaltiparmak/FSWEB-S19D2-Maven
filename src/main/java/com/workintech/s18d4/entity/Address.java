package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "fsweb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    @NotNull(message = "Street field cannot be null!")
    private String street;

    @Column(name = "no")
    @NotNull(message = "No field cannot be null!")
    @Min(1)
    private int no;

    @Column(name = "city")
    @NotNull(message = "City field cannot be null!")
    private String city;

    @Column(name = "country")
    @NotNull(message = "Country field cannot be null!")
    private String country;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Customer customer;
}
