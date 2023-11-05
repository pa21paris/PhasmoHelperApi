/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.services.Impl;

import com.char893.phasmohelperapi.Exceptions.NotFoundException;
import com.char893.phasmohelperapi.models.Evidence;
import com.char893.phasmohelperapi.repositories.EvidenceRepository;
import com.char893.phasmohelperapi.services.EvidenceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author papar
 */
@Service
public class EvidenceServiceImpl implements EvidenceService{
    
    @Autowired
    private EvidenceRepository evidenceRepository;

    @Override
    public List<Evidence> getAll() {
        return evidenceRepository.findAll();
    }

    @Override
    public Optional<Evidence> getByName(String name) {
        return evidenceRepository.findByNameIgnoreCase(name);
    }
    
    @Override
    public Evidence getByNameOrThrow(String name) throws NotFoundException{
        return this.getByName(name)
                    .orElseThrow(() ->
                        new NotFoundException("Evidence with name "+ name +" was not found")
                    );
    }

    @Override
    public Evidence save(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override @Transactional
    public void delete(String name) {
        evidenceRepository.deleteByNameIgnoreCase(name);
    }
    
}
