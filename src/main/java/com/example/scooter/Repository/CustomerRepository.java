package com.example.scooter.Repository;

import com.example.scooter.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //    all crud databases methods
}
