package com.xdesign.munro.api.controller;

import com.xdesign.munro.api.model.MunroResponse;
import com.xdesign.munro.api.service.MunroService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
@RestController( "/munro" )
public class MunroController {

    @NonNull
    private final MunroService munroService;

    @GetMapping( path = "/search" )
    public MunroResponse fetchAll() {
        log.info( "Received munro search request" );
        return munroService.fetchAll();
    }
}
