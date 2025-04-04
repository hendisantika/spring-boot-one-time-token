package id.my.hendisantika.onetimetoken.config;

import id.my.hendisantika.onetimetoken.service.CustomUserDetailsService;
import id.my.hendisantika.onetimetoken.service.EmailService;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.15
 * To change this template use File | Settings | File Templates.
 */
@Component
public class EmailGeneratedOneTimeTokenHandler implements OneTimeTokenGenerationSuccessHandler {

    private final EmailService emailService;
    private final CustomUserDetailsService userDetailsService;
    private final OneTimeTokenGenerationSuccessHandler redirectHandler
            = new RedirectOneTimeTokenGenerationSuccessHandler("/ott/sent");

    public EmailGeneratedOneTimeTokenHandler(EmailService emailService,
                                             CustomUserDetailsService userDetailsService) {

        this.emailService = emailService;
        this.userDetailsService = userDetailsService;
    }

}
