package com.stefanini.service;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.JogadorParser;
import com.stefanini.repository.JogadorRepository;
import com.stefanini.utils.Criptografia;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@RequestScoped
public class JogadorService {

    @Inject
    JogadorRepository jogadorRepository;

    public JogadorDTO salvar(JogadorDTO jogadorDTO) {
        Jogador jogador = JogadorParser.dtoEntity(jogadorDTO);
        jogador.setPassword(Criptografia.criptografarSenha(jogador.getPassword()));
        jogadorRepository.save(jogador);
        return JogadorParser.jogadorEntity(jogador);
    }

    public JogadorDTO pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return JogadorParser.jogadorEntity(jogador);
    }

    public void alterar(Jogador jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }

    public JogadorDTO verificarCredenciais(String nickname, String senha) {
        senha = Criptografia.criptografarSenha(senha);
        Jogador jogador = jogadorRepository.verificarCredenciais(nickname, senha);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Credenciais incorretas.", Response.Status.NOT_FOUND);
        }

        return JogadorParser.jogadorEntity(jogador);
    }
}
