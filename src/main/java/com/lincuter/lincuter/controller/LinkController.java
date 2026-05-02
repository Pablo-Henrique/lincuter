package com.lincuter.lincuter.controller;

import com.lincuter.lincuter.dto.LinkRequestDTO;
import com.lincuter.lincuter.dto.LinkResponseDTO;
import com.lincuter.lincuter.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/shorten")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> createShortLink(@RequestBody @Valid LinkRequestDTO url) {
        LinkResponseDTO response = linkService.shortenUrl(url);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{short_code}")
    public ResponseEntity<Void> getShortLink(@PathVariable String short_code) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(linkService.getShortUrlRedirect(short_code)))
                .build();
    }
}
