/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class Ghost {
    
    @Id
    private String name;
    
    @ManyToMany(mappedBy = "ghosts") 
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<Evidence> evidences = new HashSet<>();
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "explanation")
    private Map<String, String> uniqueTraits = new HashMap<>();

    public Ghost(String name) {
        this.name = name;
    }
    
    private Ghost() {}

    public String getName() {
        return name;
    }

    public Set<Evidence> getEvidences() {
        return Set.copyOf(evidences);
    }
    
    public boolean addEvidence(Evidence evidence) {
        return evidence.addGhost(this) && this.evidences.add(evidence);
    }
    
    public boolean removeEvidence(Evidence evidence) {
        return evidence.removeGhost(this) 
                && this.evidences.remove(evidence);
    }

    public Map<String, String> getUniqueTraits() {
        return Map.copyOf(uniqueTraits);
    }
    
    public boolean addUniqueTrait(String name, String explanation) {
        return this.uniqueTraits.putIfAbsent(name, explanation) == null;
    }
    
    public boolean removeUniqueTrait(String name) {
        return this.uniqueTraits.remove(name) != null;
    }
    
}
