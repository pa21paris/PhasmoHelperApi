/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.char893.phasmohelperapi.services;

import com.char893.phasmohelperapi.models.Ghost;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author papar
 */
public interface GhostService {
    
    public List<Ghost> getGhostsByEvidences(List<String> evidences);
    
    public List<Ghost> getAll();
    
    public Optional<Ghost> getByName(String name);
    
}
