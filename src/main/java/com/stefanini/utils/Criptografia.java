package com.stefanini.utils;

import com.stefanini.exceptions.RegraDeNegocioException;

import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Criptografia {

    public static String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao criptografar"+e.getMessage());
            throw new RegraDeNegocioException("Erro ao criptografar senha", Response.Status.BAD_REQUEST);
        }
    }
}
