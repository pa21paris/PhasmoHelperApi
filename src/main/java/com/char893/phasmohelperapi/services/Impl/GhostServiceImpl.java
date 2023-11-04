/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.services.Impl;

import com.char893.phasmohelperapi.Exceptions.NotFoundException;
import com.char893.phasmohelperapi.models.Ghost;
import com.char893.phasmohelperapi.repositories.GhostRepository;
import com.char893.phasmohelperapi.services.GhostService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author papar
 */
@Service
public class GhostServiceImpl implements GhostService{
    
    @Autowired
    private GhostRepository ghostRepository;

    @Override
    public List<Ghost> getGhostsByEvidences(List<String> evidences) {
        if(evidences.isEmpty()) return new ArrayList<>();
        String evidenceRegex = "";
        for(var evidence : evidences) evidenceRegex+="(?=.*"+evidence+".*)";
        return ghostRepository.getGhostsByEvidenceRegex(evidenceRegex);
    }

    @Override
    public List<Ghost> getAll() {
        return ghostRepository.findAll();
    }

    @Override
    public Optional<Ghost> getByName(String name) {
        return ghostRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Ghost save(Ghost ghost) {
        return ghostRepository.save(ghost);
    }
    
    @Override
    public Ghost getByNameOrThrow(String name) throws NotFoundException{
        return this.getByName(name)
                .orElseThrow(() -> 
                        new NotFoundException("Ghost with name "+ name +" was not found")
                );
    }

    @Override
    public void delete(String name) {
        ghostRepository.deleteByNameIgnoreCase(name);
    }
    
}
