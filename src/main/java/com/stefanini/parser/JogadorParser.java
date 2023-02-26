package com.stefanini.parser;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;

public class JogadorParser {

    public static Jogador dtoEntity(JogadorDTO dto) {
        return new Jogador(dto.getId(), dto.getNickname(), dto.getPassword(), dto.getSaldo(), dto.getStefamons());
    }

    public static JogadorDTO jogadorEntity(Jogador entity) {
        return new JogadorDTO(entity.getId(), entity.getNickname(), entity.getPassword(), entity.getSaldo(), entity.getStefamons());
    }

}
