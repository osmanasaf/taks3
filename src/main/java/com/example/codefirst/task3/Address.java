package com.example.codefirst.task3;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customer_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="AdressLine")
    private String address;

    @Column(name="PostCode")
    private int postCode;

    @Enumerated
    private AddressType addresType;

    @ManyToOne
    @JoinColumn(name = "customer_address_id")
    private Customer customer;



    enum AddressType{
        EvAdresi,
        IsAdresi,
        Diger

    }


}

