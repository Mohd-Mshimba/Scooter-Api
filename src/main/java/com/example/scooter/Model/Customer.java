package com.example.scooter.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    @Column(name = "f_name")
    private  String fName;

    @Column(name = "l_name")
    private  String lName;

    @Column(name = "m_phone")
    private  String mPhone;

    @Column(name = "e_mail")
    private  String email;
}