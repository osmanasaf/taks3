package com.example.codefirst.task3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired private com.example.codefirst.task3.CustomerRepository customerRepository;

    @PostMapping("/addcustomer")
    public Customer addcustomer(@RequestBody Customer client){
        Customer create=customerRepository.save(client);
        return create;
    }
    @GetMapping("hello")
    public String HelloW(){
        return "Hello World";
    }
    
}
