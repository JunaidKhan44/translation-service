package com.digitaltolk.service;

import com.digitaltolk.dto.TranslationDTO;
import com.digitaltolk.entity.Translation;
import com.digitaltolk.repo.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final TranslationRepository repo;
    private final ModelMapper mapper;

    @Override
    public TranslationDTO create(TranslationDTO dto) {
        return mapper.map(repo.save(mapper.map(dto, Translation.class)), TranslationDTO.class);
    }

    @Override
    public TranslationDTO update(Long id, TranslationDTO dto) {
        Translation t = repo.findById(id).orElseThrow();
        t.setKey(dto.getKey());
        t.setContent(dto.getContent());
        t.setLocale(dto.getLocale());
        t.setTags(dto.getTags());
        return mapper.map(repo.save(t), TranslationDTO.class);
    }

    @Override
    public List<TranslationDTO> search(String tag, String key, String content) {
        if (tag != null) return repo.findByTagsContaining(tag).stream().map(t -> mapper.map(t, TranslationDTO.class)).toList();
        if (key != null) return repo.findByKeyContainingIgnoreCase(key).stream().map(t -> mapper.map(t, TranslationDTO.class)).toList();
        if (content != null) return repo.findByContentContainingIgnoreCase(content).stream().map(t -> mapper.map(t, TranslationDTO.class)).toList();
        return List.of();
    }

    @Override
    public List<TranslationDTO> getAllByLocale(String locale) {
        return repo.findByLocale(locale).stream().map(t -> mapper.map(t, TranslationDTO.class)).toList();
    }

    @Override
    public Map<String, String> exportJson(String locale) {
        return repo.findByLocale(locale).stream().collect(Collectors.toMap(Translation::getKey, Translation::getContent));
    }
}