package com.digitaltolk.service;

import com.digitaltolk.dto.TranslationDTO;

import java.util.List;
import java.util.Map;

public interface TranslationService {
    TranslationDTO create(TranslationDTO dto);
    TranslationDTO update(Long id, TranslationDTO dto);
    List<TranslationDTO> search(String tag, String key, String content);
    List<TranslationDTO> getAllByLocale(String locale);
    Map<String, String> exportJson(String locale);
}