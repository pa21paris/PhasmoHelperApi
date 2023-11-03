/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.controllers;

import com.char893.phasmohelperapi.Exceptions.NotFoundException;
import com.char893.phasmohelperapi.models.Ghost;
import com.char893.phasmohelperapi.services.GhostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping
    public List<Ghost> getAll(@RequestParam(required = false) List<String> evidences) {
        if(evidences != null) return ghostService.getGhostsByEvidences(evidences);
        return ghostService.getAll();
    }
    
    @GetMapping("/{name}")
    public Ghost getById(@PathVariable String name){
        return ghostService.getByName(name)
                .orElseThrow(() -> new NotFoundException("Ghost not found"));
    }
    
}
