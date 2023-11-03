/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.char893.phasmohelperapi.repositories;

import com.char893.phasmohelperapi.models.Ghost;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author papar
 */
@Repository
public interface GhostRepository extends ListCrudRepository<Ghost, String>{
    
    @Query(value = """
                   select ghosts_name as name
                   from Evidence_Ghosts
                   group by ghosts_name
                   having LISTAGG(evidences_name) REGEXP ?1""",
            nativeQuery = true)
    public List<Ghost> getGhostsByEvidenceRegex(String regex);
    
}
