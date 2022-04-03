package com.example.scooter.Controller;

import com.example.scooter.Exception.ResourceNotFoundException;
import com.example.scooter.Model.Customer;
import com.example.scooter.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
@Controller
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // GET ALL CUSTOMER
    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    // CREATE CUSTOMER
    @PostMapping("/post")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    // GET BY ID CUSTOMER
    @GetMapping("{customer_id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long customer_id){
        Customer customer = customerRepository.findById(customer_id).
                orElseThrow(()-> new ResolutionException("Customer with this Id doest not Exist!"+customer_id));
        return ResponseEntity.ok(customer);
    }

    // UPDATE CUSTOMER
    @PutMapping("{customer_id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long customer_id, @RequestBody Customer customerDetails){
        Customer updateCustomer = customerRepository.findById(customer_id).
                orElseThrow(()-> new ResourceNotFoundException("Customer with this Id doest not Exist!"+customer_id));
        updateCustomer.setFName(customerDetails.getFName());
        updateCustomer.setLName(customerDetails.getLName());
        updateCustomer.setMPhone(customerDetails.getMPhone());
        updateCustomer.setEmail(customerDetails.getEmail());

        customerRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }


    // DELETE CUSTOMER
    @DeleteMapping("{customer_id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long customer_id){
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer with this Id doest not Exist!"+customer_id));
        customerRepository.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
