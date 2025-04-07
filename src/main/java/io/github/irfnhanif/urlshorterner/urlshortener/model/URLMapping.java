package io.github.irfnhanif.urlshorterner.urlshortener.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("URLMapping")
public class URLMapping {
    @Id
    private String shortURL;
    private String originalURL;
    private Instant createdAt;
    private Instant expirationTime;
}
