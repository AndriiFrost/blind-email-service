package com.blind.email.service.impl;

import com.blind.email.entity.BlindUser;
import com.blind.email.repository.BlindUserRepository;
import com.blind.email.service.BlindUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlindUserServiceImpl implements BlindUserService {

    private final BlindUserRepository blindUserRepository;

    @Override
    public BlindUser findBlindUserById(Long blindUserId) {
        return blindUserRepository.findById(blindUserId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void confirmBlindUser(BlindUser blindUser) {
        blindUser.setConfirmed(true);
        blindUserRepository.saveAndFlush(blindUser);
    }
}
