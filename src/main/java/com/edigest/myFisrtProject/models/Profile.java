package com.edigest.myFisrtProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "bio")
    private String bio;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "date_Of_Birth")
    private LocalDate dateOfBirth;
    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;
}
