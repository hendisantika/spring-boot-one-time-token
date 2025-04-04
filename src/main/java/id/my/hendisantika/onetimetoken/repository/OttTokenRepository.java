package id.my.hendisantika.onetimetoken.repository;

import id.my.hendisantika.onetimetoken.model.OttToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.09
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface OttTokenRepository extends JpaRepository<OttToken, Long> {

    Optional<OttToken> findByTokenValue(String tokenValue);

    @Modifying
    @Transactional
    @Query("DELETE FROM ott e WHERE e.expiresAt < :currentTimestamp")
    int deleteExpiredTokens(Instant currentTimestamp);
}
