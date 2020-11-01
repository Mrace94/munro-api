package com.xdesign.munro.api.model;

import com.xdesign.munro.api.entities.Munro;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MunroResponse {
    private List<Munro> munros;
}
