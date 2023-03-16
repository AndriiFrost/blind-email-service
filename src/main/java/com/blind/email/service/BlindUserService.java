package com.blind.email.service;

import com.blind.email.entity.BlindUser;

public interface BlindUserService {

    BlindUser findBlindUserById(Long blindUserId);

    void confirmBlindUser(BlindUser blindUser);
}
