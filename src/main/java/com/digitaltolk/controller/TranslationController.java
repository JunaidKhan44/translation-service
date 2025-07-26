package com.digitaltolk.controller;

import com.digitaltolk.dto.TranslationDTO;
import com.digitaltolk.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/translations")
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService service;

    @PostMapping
    public TranslationDTO create(@RequestBody TranslationDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public TranslationDTO update(@PathVariable Long id, @RequestBody TranslationDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/search")
    public List<TranslationDTO> search(
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String key,
            @RequestParam(required = false) String content
    ) {
        return service.search(tag, key, content);
    }

    @GetMapping("/locale/{locale}")
    public List<TranslationDTO> getByLocale(@PathVariable String locale) {
        return service.getAllByLocale(locale);
    }

    @GetMapping("/export/{locale}")
    public Map<String, String> export(@PathVariable String locale) {
        return service.exportJson(locale);
    }
}