package com.lincuter.lincuter.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record LinkRequestDTO(@URL
                             @NotBlank(message = "URL não deve estár vazia.")
                             String original_url) {
}
