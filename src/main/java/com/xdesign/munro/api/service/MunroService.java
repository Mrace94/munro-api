package com.xdesign.munro.api.service;

import com.xdesign.munro.api.model.MunroResponse;
import com.xdesign.munro.api.repository.MunroRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
@Service
public class MunroService {

    @NonNull
    private final MunroRepository munroRepository;

    public MunroResponse fetchAll() {
        log.debug( "Fetching munros from database" );
        return new MunroResponse();
    }
}
