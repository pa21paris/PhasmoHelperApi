/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.controllers;

import com.char893.phasmohelperapi.Utils.UniqueTraitBody;
import com.char893.phasmohelperapi.models.Evidence;
import com.char893.phasmohelperapi.models.Ghost;
import com.char893.phasmohelperapi.services.EvidenceService;
import com.char893.phasmohelperapi.services.GhostService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author papar
 */
@RestController
@RequestMapping("/ghosts")
public class GhostController {
    
    @Autowired
    private GhostService ghostService;
    
    @Autowired
    private EvidenceService evidenceService;
    
    @GetMapping
    public List<Ghost> getAll(@RequestParam(required = false) List<String> evidences) {
        if(evidences != null) return ghostService.getGhostsByEvidences(evidences);
        return ghostService.getAll();
    }
    
    @GetMapping("/{name}")
    public Ghost getById(@PathVariable String name){
        return ghostService.getByNameOrThrow(name);
    }
    
    @PostMapping
    public Ghost create(@Valid @RequestBody Ghost ghost){
        return ghostService.save(ghost);
    }
    
    @PostMapping("/{ghost}/{evidence}")
    public Ghost addEvidence(
            @PathVariable(name = "ghost") String ghostName,
            @PathVariable(name = "evidence") String evidenceName){
        Ghost ghost = ghostService.getByNameOrThrow(ghostName);
        Evidence evidence = evidenceService.getByNameOrThrow(evidenceName);
        ghost.addEvidence(evidence);
        ghostService.save(ghost);
        return ghost;
    }
    
    @PostMapping("/{ghostName}/unique-traits")
    public Ghost addUniqueTrait(@PathVariable String ghostName, @Valid @RequestBody UniqueTraitBody trait){
        Ghost ghost = ghostService.getByNameOrThrow(ghostName);
        ghost.addUniqueTrait(trait.getName(), trait.getExplanation());
        return ghostService.save(ghost);
    }
}
