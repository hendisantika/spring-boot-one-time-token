package id.my.hendisantika.onetimetoken.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.18
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequestMapping("/ott")
public class OttPageController {

    @GetMapping("/sent")
    String ottSent() {
        log.info("OTT sent");
        return "ott-sent";
    }
}
