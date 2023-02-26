package com.stefanini.parser;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;

public class StefamonParser {

    public static StefamonDTO stefamonEntity(Stefamon entity) {
        return new StefamonDTO(entity.getId(),
                entity.getNome(), entity.getVida(),
                entity.getAtaque(), entity.getDefesa(),
                entity.getInteligencia(), entity.getPoder(),
                entity.getVelocidade(), entity.getUrlFoto());
    }
}
