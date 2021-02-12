package com.example.codefirst.task3;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastname;

    @OneToMany
    @JoinColumn(name = "customer_address_id")
    List<Address> addresses;
}
