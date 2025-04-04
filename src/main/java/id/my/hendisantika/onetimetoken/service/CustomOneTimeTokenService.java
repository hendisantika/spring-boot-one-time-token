package id.my.hendisantika.onetimetoken.service;

import id.my.hendisantika.onetimetoken.model.OttToken;
import id.my.hendisantika.onetimetoken.repository.OttTokenRepository;
import lombok.NonNull;
import org.springframework.security.authentication.ott.GenerateOneTimeTokenRequest;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.authentication.ott.OneTimeTokenService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

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

    @NonNull
    @Override
    public OneTimeToken generate(GenerateOneTimeTokenRequest request) {
        String token = UUID.randomUUID().toString();
        Instant eightHoursFromNow = this.clock.instant().plus(8, ChronoUnit.HOURS);
        OttToken ott = new OttToken(token, request.getUsername(), eightHoursFromNow);
        tokenRepository.save(ott);
        return ott;
    }
}
