package com.xdesign.munro.api.repository;

import com.xdesign.munro.api.entities.Munro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MunroRepository extends JpaRepository<Munro, String> {

    @Query( "SELECT m FROM Munro m " +
            "WHERE m.category IS NOT NULL " +
            "AND (:category IS NULL OR :category = 'EITHER' OR m.category = :category) " +
            "AND (:minHeight IS NULL OR m.height >= :minHeight)" +
            "AND (:maxHeight IS NULL OR m.height <= :maxHeight )" )
    Page<Munro> findAllByCategoryMinAndMaxHeight( Pageable pageable,
                                                  String category,
                                                  Integer minHeight,
                                                  Integer maxHeight );

}
