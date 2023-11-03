/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class Evidence {
    
    @Id
    private String name;
    
    private String howToUse;
    
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Ghost> ghosts = new HashSet<>();

    public Evidence(String name, String howToUse) {
        this.name = name;
        this.howToUse = howToUse;
    }
    
    private Evidence() {}

    public String getName() {
        return name;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public Set<Ghost> getGhosts() {
        return Set.copyOf(ghosts);
    }
    
    boolean addGhost(Ghost ghost) {
        return this.ghosts.add(ghost);
    }
    
    boolean removeGhost(Ghost ghost) {
        return this.ghosts.remove(ghost);
    }
    
}
