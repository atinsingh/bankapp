package co.pragra.banking.rest.simplebankapi.rest;

import co.pragra.banking.rest.simplebankapi.domain.Account;
import co.pragra.banking.rest.simplebankapi.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }


    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account){
        return this.service.createAccount(account);
    }

    @GetMapping("/account/{accountId}/withdraw")
    public ResponseEntity<Account> widthdraw(@PathVariable("accountId") Long accountId, @RequestParam("amount") double amount ){
        return ResponseEntity.status(201).body(service.withDrawMoney(accountId,amount));
    }
}
