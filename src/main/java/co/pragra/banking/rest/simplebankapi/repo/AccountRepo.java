package co.pragra.banking.rest.simplebankapi.repo;

import co.pragra.banking.rest.simplebankapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
}
