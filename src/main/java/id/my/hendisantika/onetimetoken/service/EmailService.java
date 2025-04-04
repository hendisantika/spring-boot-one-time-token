package id.my.hendisantika.onetimetoken.service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.14
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

}
