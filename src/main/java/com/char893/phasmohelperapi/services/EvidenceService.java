/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.char893.phasmohelperapi.services;

import com.char893.phasmohelperapi.Exceptions.NotFoundException;
import com.char893.phasmohelperapi.models.Evidence;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author papar
 */

public interface EvidenceService {
    
    public List<Evidence> getAll();
    public Optional<Evidence> getByName(String name);
    public Evidence getByNameOrThrow(String name) throws NotFoundException;
    public Evidence save(Evidence evidence);
    public void delete(String name);
            
}
