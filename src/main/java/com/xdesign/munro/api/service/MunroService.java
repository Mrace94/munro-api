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

import javax.validation.ValidationException;

@Slf4j
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
@Service
public class MunroService {

    @NonNull
    private final MunroRepository munroRepository;

    /**
     * Fetch a list of munros based on the provided criteria
     *
     * @param pageable  pageable to specify page size, sorting etc
     * @param category  category to limit search results to
     * @param minHeight minimum height of munros to include
     * @param maxHeight maximum height of munros to include
     * @return <code>Page</code> of Munros
     * @throws ValidationException thrown if a search parameter is invalid
     */
    public Page<Munro> fetchMunros( Pageable pageable,
                                    MunroCategory category,
                                    Integer minHeight,
                                    Integer maxHeight ) throws ValidationException {
        log.info( "Fetching munros from the database" );

        if ( minHeight > maxHeight ) {
            throw new ValidationException( "Minimum height can't be greater than max height" );
        }

        return munroRepository.findAllByCategoryMinAndMaxHeight( pageable, category.getValue(), minHeight, maxHeight );
    }
}
