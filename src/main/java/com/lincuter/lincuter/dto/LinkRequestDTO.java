package com.lincuter.lincuter.dto;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public record LinkRequestDTO(@URL
                             @NotEmpty(message = "URL não pode ser vazia")
                             String original_url) {
}
