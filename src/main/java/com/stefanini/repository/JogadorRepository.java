package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@RequestScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {
    public Jogador verificarCredenciais(@QueryParam("nickname") String nickname, @QueryParam("password") String password) {
        try {
            return getEntityManager().createQuery(
                            "SELECT j FROM Jogador j WHERE j.nickname = :nickname AND j.password = :password",
                            Jogador.class
                    ).setParameter("nickname", nickname)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
