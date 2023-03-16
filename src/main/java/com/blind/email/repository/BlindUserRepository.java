package com.blind.email.repository;

import com.blind.email.entity.BlindUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlindUserRepository extends JpaRepository<BlindUser, Long> {

}
