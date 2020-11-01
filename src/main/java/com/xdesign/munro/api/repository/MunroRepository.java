package com.xdesign.munro.api.repository;

import com.xdesign.munro.api.entities.Munro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunroRepository extends JpaRepository<Munro, String> {
}
