package co.pragra.banking.rest.simplebankapi.rest;

import co.pragra.banking.rest.simplebankapi.domain.Customer;
import co.pragra.banking.rest.simplebankapi.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class CustomerController {
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        Customer cus = this.service.createCustomer(customer);
        if(cus!=null){
            URI uri = URI.create("https://localhost/customer/"+ customer.getId());
            return ResponseEntity.created(uri).body(cus);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.of(service.getCustomerByID(id));
    }
}
