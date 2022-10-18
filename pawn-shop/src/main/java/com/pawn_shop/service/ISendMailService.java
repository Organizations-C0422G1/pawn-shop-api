package com.pawn_shop.service;

import com.pawn_shop.dto.projection.MailAutoProjection;

import javax.mail.Session;
import java.util.List;

public interface ISendMailService {
    List<MailAutoProjection> listEmail();

    void sendMailAuto(Session session);

    void sendMailReturnItem(Session session, String email, String customerName);

}
