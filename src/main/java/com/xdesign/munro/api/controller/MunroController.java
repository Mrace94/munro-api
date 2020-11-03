package com.xdesign.munro.api.controller;

import com.xdesign.munro.api.entities.Munro;
import com.xdesign.munro.api.enums.MunroCategory;
import com.xdesign.munro.api.service.MunroService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@Slf4j
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
@RestController
@RequestMapping( value = "/munro" )
public class MunroController {

    @NonNull
    private final MunroService munroService;

    /**
     * Represents an endpoint for listing all munros
     *
     * @param pageable  pageable to specify page number, page size, sorting etc
     * @param category  category of munro to limit results to
     * @param minHeight the minimum height of munros to search
     * @param maxHeight the max height height of munros to search
     * @return <code>Page</code> of munros that meet the search criteria
     */
    @GetMapping( path = "/search" )
    public Page<Munro> fetchMunros( @PageableDefault( sort = {"runningNo"} ) Pageable pageable,
                                    @RequestParam( required = false, defaultValue = "EITHER" ) MunroCategory category,
                                    @RequestParam( required = false, defaultValue = "0" ) Integer minHeight,
                                    @RequestParam( required = false, defaultValue = "1000000" ) Integer maxHeight ) throws ValidationException {
        log.info( "Received munro search request" );

        return munroService.fetchMunros( pageable, category, minHeight, maxHeight );
    }
}