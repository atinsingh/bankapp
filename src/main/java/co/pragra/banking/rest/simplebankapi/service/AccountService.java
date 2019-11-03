package co.pragra.banking.rest.simplebankapi.service;

import co.pragra.banking.rest.simplebankapi.domain.Account;
import co.pragra.banking.rest.simplebankapi.exceptions.InsufficientBalanceException;
import co.pragra.banking.rest.simplebankapi.exceptions.NotFoundException;
import co.pragra.banking.rest.simplebankapi.repo.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private AccountRepo repo;

    public AccountService(AccountRepo repo) {
        this.repo = repo;
    }

    public Account createAccount(Account account){
        return  this.repo.saveAndFlush(account);
    }


    public Account withDrawMoney(Long accountId, double amount){
        Optional<Account> byId = this.repo.findById(accountId);
        if(!byId.isPresent()){
            throw new NotFoundException("There is not such account");
        }
        Account account = byId.get();
        if(account.getAmount()<amount){
            throw new InsufficientBalanceException("Not Enough fund Available");
        }
        account.setAmount(account.getAmount()-amount);
        return account;

    }
}
