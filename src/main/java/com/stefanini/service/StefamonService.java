package com.stefanini.service;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.StefamonParser;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestScoped
public class StefamonService {

    @Inject
    StefamonRepository repository;

    public List<StefamonDTO> listarTodos(){
        List<Stefamon> stefamons = repository.listAll();
        return stefamons.stream().map(StefamonParser::stefamonEntity).collect(Collectors.toList());
    }

    public StefamonDTO pegarPorId(Long id) {
        Stefamon stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return StefamonParser.stefamonEntity(stefamon);
    }

 }
