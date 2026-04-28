package com.lincuter.lincuter.controller;

import com.lincuter.lincuter.dto.LinkRequestDTO;
import com.lincuter.lincuter.dto.LinkResponseDTO;
import com.lincuter.lincuter.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shorten")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> createShortLink(@RequestBody LinkRequestDTO url) {
        LinkResponseDTO response = linkService.shortenUrl(url);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
