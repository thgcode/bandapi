package com.thgcode.bandapi.controllers;

import com.thgcode.bandapi.models.BatidaDto;
import com.thgcode.bandapi.services.BateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/bateria/v1")
@RequiredArgsConstructor
public class BateriaController {
    private final BateriaService bateriaService;

    @PutMapping("/batida")
    public void tocaBatida(@Valid @RequestBody BatidaDto batida) {
        bateriaService.setBatida(batida);
    }

    @PutMapping("/bpm")
    public void configuraBpm(@RequestBody double tempoBpm) {
        bateriaService.setTempoBpm(tempoBpm);
    }
}
