package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exintermediate.model.Fashion;
import com.example.exintermediate.repository.FashionRepository;

@Service
public class FashionService {
    @Autowired
    private FashionRepository fashionRepository;

    public List<Fashion> showFashionList(String color, Integer gender) {
        return fashionRepository.findFashionList(color, gender);
    }
}
