/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.char893.phasmohelperapi.Utils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author papar
 */
public class UniqueTraitBody {
    
    @NotBlank(message = "Name of the unique trait shouldn't be blank")
    private String name;
    
    @Size(max = 255, message = "Explanation shouldn't be longer than 255 characters")
    private String explanation;
    
    public UniqueTraitBody(String name, String explanation){
        this.name = name;
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }
    
}
