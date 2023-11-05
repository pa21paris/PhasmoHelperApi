/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.models;

import com.char893.phasmohelperapi.Utils.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author papar
 */
@Entity
public class Evidence {
    
    @Id @NotBlank(groups = ValidationGroups.onCreate.class)
    private String name;
    
    @Size(max = 255, message = "max lenght is 255 characters")
    private String howToUse;
    
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnoreProperties("evidences")
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
