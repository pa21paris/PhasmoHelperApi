/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.char893.phasmohelperapi.repositories;

import com.char893.phasmohelperapi.models.Evidence;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author papar
 */
@Repository
public interface EvidenceRepository extends ListCrudRepository<Evidence, String>{
    
    public Optional<Evidence> findByNameIgnoreCase(String name);
    public void deleteByNameIgnoreCase(String name);
    
}
