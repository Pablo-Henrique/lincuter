package com.lincuter.lincuter.service;

import com.lincuter.lincuter.dto.LinkRequestDTO;
import com.lincuter.lincuter.dto.LinkResponseDTO;
import com.lincuter.lincuter.model.Link;
import com.lincuter.lincuter.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        link.setOriginal_url(linkRequestDTO.original_url());
        link.setShort_code(code);
        link.setCreated_at(LocalDateTime.now());

        linkRepository.save(link);
        return new LinkResponseDTO(linkRequestDTO.original_url(), shorten_url);
    }

}
