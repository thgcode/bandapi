package com.thgcode.bandapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Instrucao {
    @NotBlank
    @JsonProperty("instrumento")
    private InstrumentoBateria instrumento;

    @JsonProperty("forca")
    private int forca;
}
