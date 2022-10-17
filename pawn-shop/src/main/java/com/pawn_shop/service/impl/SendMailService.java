package com.pawn_shop.service.impl;

import com.pawn_shop.config.MailConfig;
import com.pawn_shop.model.login.AppUser;
import com.pawn_shop.service.ISendMailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Service
public class SendMailService implements ISendMailService {

    @Override
    public void sendResetPasswordMail(AppUser user, String email, String jwt) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", MailConfig.SSL_PORT);

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
            }
        });

        Multipart multipart = new MimeMultipart();
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(MailConfig.APP_EMAIL));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("[C04-PawnShop] - Quên mật khẩu");
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Quên mật khẩu</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>Chào " + user.getEmployee().getName() + "</h3>\n" +
                "<p>Đây là email đặt lại mật khẩu của bạn, bấm vào link bên dưới để đặt lại mật khẩu:</p>\n" +
                "<a href=\"http://localhost:4200/login/reset-pasword/" + jwt + "\">Reset password link</a>\n" +
                "<p style=\"color: red\"><i>Lưu ý: Không chia sẻ link này cho người khác</i></p>\n" +
                "<hr>\n" +
                "<h4>C04 - PawnShop</h4>\n" +
                "<p>SĐT: 0123456789</p>\n" +
                "<p>Email: pawnshopc04@gmail.com</p>\n" +
                "</body>\n" +
                "</html>\n";
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setContent(htmlContent, "text/html; charset=UTF-8");
        multipart.addBodyPart(textBodyPart);
        message.setContent(multipart, "UTF-8");
        Transport.send(message);

    }
}
