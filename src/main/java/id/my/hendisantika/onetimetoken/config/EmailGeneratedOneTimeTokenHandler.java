package id.my.hendisantika.onetimetoken.config;

import id.my.hendisantika.onetimetoken.service.CustomUserDetailsService;
import id.my.hendisantika.onetimetoken.service.EmailService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

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

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       OneTimeToken oneTimeToken) throws IOException, ServletException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(UrlUtils.buildFullRequestUrl(request))
                .replacePath(request.getContextPath())
                .replaceQuery(null)
                .fragment(null)
                .path("/login/ott")
                .queryParam("token", oneTimeToken.getTokenValue());
        String magicLink = builder.toUriString();
        String email = getUserEmail(oneTimeToken.getUsername());
        this.emailService.sendEmail(email, "One Time Token for the Spring Security Demo App",
                "Use the following link to sign in into the application: " + magicLink);
        this.redirectHandler.handle(request, response, oneTimeToken);
    }
}
