package id.my.hendisantika.onetimetoken.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.util.Assert;

import java.time.Instant;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-one-time-token
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/04/25
 * Time: 09.08
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity(name = "ott")
@Table(name = "tbl_ott_token")
@AllArgsConstructor
@NoArgsConstructor
public class OttToken implements OneTimeToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String tokenValue;
    @Column
    private Instant expiresAt;

    public OttToken(String token, String username, Instant expireAt) {
        Assert.hasText(token, "token cannot be empty");
        Assert.hasText(username, "username cannot be empty");
        Assert.notNull(expireAt, "expireAt cannot be null");
        this.tokenValue = token;
        this.username = username;
        this.expiresAt = expireAt;
    }
}
