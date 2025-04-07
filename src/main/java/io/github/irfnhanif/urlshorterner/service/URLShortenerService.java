package io.github.irfnhanif.urlshorterner.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.irfnhanif.urlshorterner.model.URLMapping;
import io.github.irfnhanif.urlshorterner.repository.URLMappingRepository;

@Service
public class URLShortenerService {
    private final URLMappingRepository urlMappingRepository;
    private final ShortCodeGeneratorService shortCodeGeneratorService;

    public URLShortenerService(URLMappingRepository urlMappingRepository,
            ShortCodeGeneratorService shortCodeGeneratorService) {
        this.urlMappingRepository = urlMappingRepository;
        this.shortCodeGeneratorService = shortCodeGeneratorService;
    }

    public URLMapping createShortURL(String originalURL) {
        String shortCode = shortCodeGeneratorService.generateShortCode();

        return saveURLMapping(shortCode, originalURL);
    }

    public URLMapping createCustomShortURL(String originalURL, String customCode) {
        if (!shortCodeGeneratorService.isCustomShortCodeAvailable(customCode)) {
            throw new IllegalArgumentException("Custom short code already exists");
        }

        return saveURLMapping(customCode, originalURL);
    }

    private URLMapping saveURLMapping(String shortCode, String originalURL) {
        URLMapping mapping = new URLMapping();
        mapping.setShortURL(shortCode);
        mapping.setOriginalURL(originalURL);
        mapping.setCreatedAt(Instant.now());
        mapping.setExpirationTime(Instant.now().plus(7, ChronoUnit.DAYS));

        return urlMappingRepository.save(mapping);
    }

    private Optional<URLMapping> getURLMapping(String shortCode) {
        return urlMappingRepository.findById(shortCode);
    }
}
