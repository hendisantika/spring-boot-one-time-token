package id.my.hendisantika.onetimetoken.config;

import id.my.hendisantika.onetimetoken.repository.OttTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

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
@Slf4j
@Component
@RequiredArgsConstructor
public class OttCleanUpJob {

    private final OttTokenRepository tokenRepository;

    @Transactional
    @Scheduled(fixedRate = 3600000) // 3600000 ms = 1 hour
    public void cleanUpOldRecords() {
        log.info("Deleting expired tokens");
        int deleted = tokenRepository.deleteExpiredTokens(Instant.now());
        log.info("Deleted {} expired tokens", deleted);
    }
}
