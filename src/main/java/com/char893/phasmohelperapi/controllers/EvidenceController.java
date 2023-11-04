/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.controllers;

import com.char893.phasmohelperapi.models.Evidence;
import com.char893.phasmohelperapi.services.EvidenceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author papar
 */
@RestController
@RequestMapping("/evidences")
public class EvidenceController {
    
    @Autowired
    private EvidenceService evidenceService;
    
    @GetMapping
    public List<Evidence> getAll(){
        return evidenceService.getAll();
    }
    
    @GetMapping("/{name}")
    public Evidence getByName(@PathVariable String evidenceName){
        return evidenceService.getByNameOrThrow(evidenceName);
    }
    
}
