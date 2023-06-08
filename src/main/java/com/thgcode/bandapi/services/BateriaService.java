package com.thgcode.bandapi.services;

import com.thgcode.bandapi.models.Instrucao;
import com.thgcode.bandapi.models.BatidaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sound.midi.MidiChannel;
import java.util.Date;

@RequiredArgsConstructor
@Service
@Slf4j
public class BateriaService {
    private final SynthService synthService;

    @Value("${bandapi.bateria.tempo-inicial}")
    private double tempoBpm;

    @Value("${bandapi.bateria.canal}")
    private int canalBateria;

    private MidiChannel saida;

    private final TaskScheduler taskScheduler;

    @PostConstruct
    public void setup() {
        saida = synthService.getCanal(canalBateria);
    }

    public void setTempoBpm(double tempoBpm) {
        this.tempoBpm = tempoBpm;
    }

    private void tocaInstrucao(Instrucao instrucao) {
        var instrumento = instrucao.getInstrumento();
        saida.noteOff(instrumento.getNumeroTecla());
        saida.noteOn(instrumento.getNumeroTecla(), instrucao.getForca());
    }

    public void setBatida(BatidaDto batida) {
        saida.allNotesOff();
        saida.allSoundOff();

        double passoBpm = (1.0 / tempoBpm) * 60.0;

        log.info("Tocando a batida em " + tempoBpm + " BPM");
        for (var entrada: batida.getInstrucoes().entrySet()) {
            double tempoBatida = (entrada.getKey() - 1.0) * passoBpm;

            for (final var instrumento: entrada.getValue()) {
                taskScheduler.schedule(() -> tocaInstrucao(instrumento), new Date((long)(System.currentTimeMillis() + (tempoBatida * 1000.0))));
            }
        }
    }
}
