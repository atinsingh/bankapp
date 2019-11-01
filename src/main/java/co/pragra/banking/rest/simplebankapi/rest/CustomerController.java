package co.pragra.banking.rest.simplebankapi.rest;

import co.pragra.banking.rest.simplebankapi.domain.Customer;
import co.pragra.banking.rest.simplebankapi.domain.Error;
import co.pragra.banking.rest.simplebankapi.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
@Api(value = "Customer Controller", tags = {"customer","account"})
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

    @ApiOperation(value = "/customer/{id}", response = Customer.class)
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Successfully Found", response = Customer.class),
                    @ApiResponse(code = 404, message = "Customer not Found", response = Error.class),
                    @ApiResponse(code = 500, message = "Oops something went wrong", response = Error.class)

            }
    )
    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
        try {
            if(service.getCustomerByID(id).isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(service.getCustomerByID(id).get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Error(400,String.format("No cutomer found for %d as ID",id)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Error(500, "Oops something went wrong, can't fullfill ur wish"));
        }


    }
}
