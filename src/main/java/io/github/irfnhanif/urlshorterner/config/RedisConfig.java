package io.github.irfnhanif.urlshorterner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(basePackages = "io.github.irfnhanif.urlshorterner.urlshortener.repository")
public class RedisConfig {
    
}
