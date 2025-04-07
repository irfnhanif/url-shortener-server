package io.github.irfnhanif.urlshorterner.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.irfnhanif.urlshorterner.urlshortener.model.URLMapping;

public interface URLMappingRepository extends CrudRepository<URLMapping, String> {
    
}
