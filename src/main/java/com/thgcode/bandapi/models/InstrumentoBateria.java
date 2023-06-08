package com.thgcode.bandapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

// HTTPS://www.cs.cmu.edu/~music/cmsip/readings/GMSpecs_PercMap.htm
@AllArgsConstructor
@Getter
public enum InstrumentoBateria {
    BUMBO(36),
    ARO(37),
    CAIXA(38),
    PALMA(39),
    CAIXA_2(40),
    CHIMBAL_FECHADO(42),
    PEDAL_CHIMBAL(44),
    CHIMBAL_ABERTO(46),
    PRATO(49);

    private final int numeroTecla;
}
