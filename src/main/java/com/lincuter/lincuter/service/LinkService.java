package com.lincuter.lincuter.service;

import com.lincuter.lincuter.dto.LinkRequestDTO;
import com.lincuter.lincuter.dto.LinkResponseDTO;
import com.lincuter.lincuter.model.Link;
import com.lincuter.lincuter.repository.LinkRepository;
import com.lincuter.lincuter.util.LinkUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    private final String DOMAIN = "https://lincu.ter/";

    public LinkResponseDTO shortenUrl(LinkRequestDTO linkRequestDTO) {
        String code = UUID.randomUUID().toString().substring(0, 6);
        String shorten_url = DOMAIN + code;

        Link link = new Link();
        link.setOriginalUrl(linkRequestDTO.original_url());
        link.setShortCode(code);
        link.setCreatedAt(LocalDateTime.now());

        linkRepository.save(link);
        return new LinkResponseDTO(linkRequestDTO.original_url(), shorten_url);
    }

    public String getShortUrlRedirect(String shortCode) {
        Link link = linkRepository.findByShortCode(shortCode).orElseThrow(EntityNotFoundException::new);
        return link.getOriginalUrl();
    }
}
