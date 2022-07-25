
package com.backendargprog.backendargprog.repository;

import com.backendargprog.backendargprog.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajoRepo extends JpaRepository <Trabajo, Long>  {
    
}
