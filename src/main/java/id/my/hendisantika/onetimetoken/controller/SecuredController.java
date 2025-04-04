package id.my.hendisantika.onetimetoken.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.19
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
public class SecuredController {

    @GetMapping("/")
    String hello(Authentication authentication, Model model) {
        model.addAttribute("principal", authentication.getPrincipal());
        log.info("Hello secured page for user: {}", authentication.getPrincipal());
        return "principal-info";
    }
}
