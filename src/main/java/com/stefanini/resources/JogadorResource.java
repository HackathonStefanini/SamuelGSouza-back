package com.stefanini.resources;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.LoginDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jogador")
public class JogadorResource {

    @Inject
    JogadorService jogadorService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).entity(jogadorService.pegarPorId(id)).build();
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos(){
        return Response.status(Response.Status.OK).entity(jogadorService.listarTodos()).build();
    }

    @POST
    @Path("/login")
    public Response login(@Valid LoginDTO loginDTO) {
        return Response.status(Response.Status.OK).entity(jogadorService.verificarCredenciais(loginDTO.getNickname(), loginDTO.getPassword())).build();
    }

    @POST
    public Response salvar(@Valid JogadorDTO jogadorDTO) {
        return Response.status(Response.Status.CREATED).entity(jogadorService.salvar(jogadorDTO)).build();
    }

    @POST
    public Response alterar(@Valid Jogador jogador) {
        jogadorService.alterar(jogador);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
