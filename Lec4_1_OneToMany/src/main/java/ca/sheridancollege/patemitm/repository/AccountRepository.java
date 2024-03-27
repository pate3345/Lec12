package ca.sheridancollege.patemitm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.patemitm.beans.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
