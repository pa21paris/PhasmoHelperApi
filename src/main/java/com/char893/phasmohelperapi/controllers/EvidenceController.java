/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.controllers;

import com.char893.phasmohelperapi.Utils.ValidationGroups;
import com.char893.phasmohelperapi.models.Evidence;
import com.char893.phasmohelperapi.services.EvidenceService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Evidence getByName(@PathVariable(name = "name") String evidenceName){
        return evidenceService.getByNameOrThrow(evidenceName);
    }
    
    @PostMapping
    @Validated(ValidationGroups.onCreate.class)
    public Evidence create(@Valid @RequestBody Evidence evidence){
        return evidenceService.save(evidence);
    }
    
    @PutMapping("/{name}")
    @Validated(ValidationGroups.onUpdate.class)
    public Evidence update(
            @PathVariable(name = "name") String evidenceName, 
            @Valid @RequestBody Evidence evidenceDetails
    ){
        Evidence evidence = evidenceService.getByNameOrThrow(evidenceName);
        evidence.setHowToUse(evidenceDetails.getHowToUse());
        return evidenceService.save(evidence);
    }
    
    @DeleteMapping("/{name}")
    public ResponseEntity delete(@PathVariable String name){
        evidenceService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
