package com.thgcode.bandapi.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

@Service
public class SynthService {
    private Synthesizer synthesizer;

    @PostConstruct
    public void setup() throws Exception {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
    }

    public MidiChannel getCanal(int numeroCanal) {
        return synthesizer.getChannels()[numeroCanal];
    }
}
