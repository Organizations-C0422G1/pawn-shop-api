package com.pawn_shop.service;

import com.pawn_shop.model.login.AppUser;

import javax.mail.internet.AddressException;

public interface ISendMailService {
    void sendResetPasswordMail(AppUser user, String email, String jwt) throws AddressException, Exception;
}
