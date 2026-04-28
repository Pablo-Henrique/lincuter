package com.lincuter.lincuter.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "TB_LINK")
public class Link {

    @Serial
    private static final long serialVersionUID = 3629607082460736645L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String original_url;

    @Column
    private String short_code;

    @Column
    private LocalDateTime created_at;

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
