package io.github.irfnhanif.urlshorterner.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShortCodeGeneratorService {
    private static final String COUNTER_KEY = "url:counter";
    private static final char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final int SHORT_CODE_LENGTH = 6;

    private final RedisTemplate<String, String> redisTemplate;

    public ShortCodeGeneratorService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String generateShortCode() {
        Long uniqueId = redisTemplate.opsForValue().increment(COUNTER_KEY);
        return toFixedLengthBase62(uniqueId);
    }

    private String toFixedLengthBase62(Long number) {
        StringBuilder sb = new StringBuilder();
        
        if (number == 0) {
            sb.append(BASE62[0]);
        } else {
            long temp = number;
            while (temp > 0) {
                sb.append(BASE62[(int)(temp % 62)]);
                temp /= 62;
            }
            sb.reverse();
        }
        
        if (sb.length() < SHORT_CODE_LENGTH) {
            java.util.Random random = new java.util.Random();
            while (sb.length() < SHORT_CODE_LENGTH) {
                sb.append(BASE62[random.nextInt(BASE62.length)]);
            }
        } else if (sb.length() > SHORT_CODE_LENGTH) {
            sb.setLength(SHORT_CODE_LENGTH);
        }
        
        return sb.toString();
    }

    public boolean isCustomShortCodeAvailable(String customShortCode) {
        return !redisTemplate.hasKey("URLMapping:" + customShortCode);
    }
}
