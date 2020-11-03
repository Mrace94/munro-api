package com.xdesign.munro.api.service;

import com.xdesign.munro.api.entities.Munro;
import com.xdesign.munro.api.enums.MunroCategory;
import com.xdesign.munro.api.repository.MunroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.ValidationException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
public class MunroServiceTest {

    @Mock
    private MunroRepository munroRepository;

    private MunroService munroService;

    private Munro mockMunro;

    @BeforeEach
    void setup() {
        this.munroService = new MunroService( munroRepository );
        this.mockMunro = new Munro( "1", "Test", 1000, "MUN", "XXXXXX" );

    }

    @Test
    void testFetchMunros() {
        // Given
        when( munroRepository.findAllByCategoryMinAndMaxHeight( any( Pageable.class ),
                any( String.class ),
                any( Integer.class ),
                any( Integer.class ) ) )
                .thenReturn( new PageImpl<>( Collections.singletonList( mockMunro ) ) );

        // When
        Page<Munro> result = munroService.fetchMunros( PageRequest.of( 1, 10 ),
                MunroCategory.EITHER,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE );

        // Then
        Munro munroResult = result.getContent().get( 0 );
        assertEquals( 1, result.getTotalElements() );
        assertEquals( "Test", munroResult.getName() );
        assertEquals( 1000, munroResult.getHeight().intValue() );
        assertEquals( "MUN", munroResult.getCategory() );
        assertEquals( "XXXXXX", munroResult.getGridRef() );
    }

    @Test
    void testFetchMunrosValidationError() {
        // Given
        when( munroRepository.findAllByCategoryMinAndMaxHeight( any( Pageable.class ),
                any( String.class ),
                any( Integer.class ),
                any( Integer.class ) ) )
                .thenThrow( new ValidationException( "Validation error" ) );

        // When
        // Then
        assertThrows( ValidationException.class, () -> munroService.fetchMunros( PageRequest.of( 1, 1 ),
                MunroCategory.EITHER,
                1000,
                10000 ) );

    }

}
