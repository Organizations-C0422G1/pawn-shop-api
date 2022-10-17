package com.pawn_shop.controller;

import com.pawn_shop.config.MailConfig;
import com.pawn_shop.jwt.JwtUtility;
import com.pawn_shop.model.login.AppUser;
import com.pawn_shop.model.login.LoginRequest;
import com.pawn_shop.model.login.LoginResponse;
import com.pawn_shop.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("*")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetailService = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long employeeId = this.appUserService.findByUsername(loginRequest.getUsername()).getEmployee().getId();

        List<String> roles = userDetailService.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        return new ResponseEntity<>(new LoginResponse(jwt, roles, loginRequest.getUsername(), employeeId), HttpStatus.OK);
    }

    @GetMapping("/forgot-password/{email}")
    public ResponseEntity<?> getResetEmail(@PathVariable String email) {
        AppUser user = this.appUserService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String jwt = jwtUtility.generateJwtToken(user.getUsername());

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

        try {
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
                    "<a href=\"http://localhost:4200/login/reset-pasword/" + jwt + "/" + user.getUsername() + "\">Reset password link</a>\n" +
                    "<p style=\"color: red\"><i>Lưu ý: Không chia sẻ link này cho người khác</i></p>\n" +
                    "<hr>\n" +
                    "<p>C04 - PawnShop</p>\n" +
                    "<p>SĐT: 0123456789</p>\n" +
                    "<p>Email: pawnshopc04@gmail.com</p>\n" +
                    "</body>\n" +
                    "</html>\n";
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(htmlContent, "text/html; charset=UTF-8");
            multipart.addBodyPart(textBodyPart);
            message.setContent(multipart, "UTF-8");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}
