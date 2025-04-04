package id.my.hendisantika.onetimetoken.config;

import id.my.hendisantika.onetimetoken.repository.OttTokenRepository;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.16
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OttCleanUpJob {

    private final OttTokenRepository tokenRepository;

    public OttCleanUpJob(OttTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}
