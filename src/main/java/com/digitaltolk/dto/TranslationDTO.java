package com.digitaltolk.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TranslationDTO {
    private Long id;
    private String locale;
    private String key;
    private String content;
    private Set<String> tags;
}
