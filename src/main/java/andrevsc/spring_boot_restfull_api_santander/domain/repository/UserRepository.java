package andrevsc.spring_boot_restfull_api_santander.domain.repository;

import andrevsc.spring_boot_restfull_api_santander.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}