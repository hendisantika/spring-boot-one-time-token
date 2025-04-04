package id.my.hendisantika.onetimetoken.service;

import id.my.hendisantika.onetimetoken.repository.OttTokenRepository;
import org.springframework.security.authentication.ott.OneTimeTokenService;
import org.springframework.stereotype.Service;

import java.time.Clock;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.10
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CustomOneTimeTokenService implements OneTimeTokenService {

    private final Clock clock = Clock.systemUTC();
    private final OttTokenRepository tokenRepository;

    public CustomOneTimeTokenService(OttTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}
