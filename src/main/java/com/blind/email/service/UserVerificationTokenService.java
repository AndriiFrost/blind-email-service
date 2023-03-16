package com.blind.email.service;

import com.blind.email.entity.UserVerificationToken;

public interface UserVerificationTokenService {

    UserVerificationToken createUserVerificationToken(Long blindUserId);

    void confirmToken(String token);
}
