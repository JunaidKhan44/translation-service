package com.digitaltolk.repo;

import com.digitaltolk.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
    List<Translation> findByTagsContaining(String tag);
    List<Translation> findByKeyContainingIgnoreCase(String key);
    List<Translation> findByContentContainingIgnoreCase(String content);
    List<Translation> findByLocale(String locale);
}