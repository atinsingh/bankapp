package co.pragra.banking.rest.simplebankapi.service;

import co.pragra.banking.rest.simplebankapi.domain.Customer;
import co.pragra.banking.rest.simplebankapi.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    public Customer createCustomer(Customer customer){
        return  this.customerRepo.save(customer);
    }

    public Optional<Customer> getCustomerByID(Long id){
         return this.customerRepo.findById(id);
    }
}
