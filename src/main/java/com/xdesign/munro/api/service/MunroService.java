package com.xdesign.munro.api.service;

import com.xdesign.munro.api.entities.Munro;
import com.xdesign.munro.api.enums.MunroCategory;
import com.xdesign.munro.api.repository.MunroRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
@Service
public class MunroService {

    @NonNull
    private final MunroRepository munroRepository;

    public Page<Munro> fetchMunros( Pageable pageable,
                                    MunroCategory category,
                                    Integer minHeight,
                                    Integer maxHeight ) {
        log.info( "Fetching munros from the database" );

        return munroRepository.findAllByCategoryMinAndMaxHeight( pageable, category.getValue(), minHeight, maxHeight );
    }
}
