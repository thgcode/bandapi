package com.thgcode.bandapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class BatidaDto {
    @JsonProperty("batidas")
    private Map<Double, List<Instrucao>> instrucoes;
}
