package com.blind.email.repository;

import com.blind.email.entity.UserVerificationToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVerificationTokenRepository extends JpaRepository<UserVerificationToken, Long> {

    Optional<UserVerificationToken> findByToken(String token);
}
