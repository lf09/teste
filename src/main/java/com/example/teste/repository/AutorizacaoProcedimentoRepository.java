package com.example.teste.repository;

import com.example.teste.entity.AutorizacaoProcedimentoEntity;
import com.example.teste.entity.dto.AutorizacaoProcedimentoDto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class AutorizacaoProcedimentoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AutorizacaoProcedimentoEntity> findAll() {
        return entityManager
                .createQuery("SELECT ap FROM AutorizacaoProcedimentoEntity ap", AutorizacaoProcedimentoEntity.class)
                .getResultList();
    }

    public <T extends AutorizacaoProcedimentoEntity> T getProcedimentoAutorizado(int idProcedimento, int idade, int idSexo) throws NoResultException {
        return (T) entityManager
                .createQuery("SELECT ap FROM AutorizacaoProcedimentoEntity ap " +
                        "WHERE ap.idProcedimento = " + idProcedimento + " AND" +
                        " ap.idade = " + idade + " AND" +
                        " ap.sexoPaciente = " + idSexo, AutorizacaoProcedimentoEntity.class)
                .getSingleResult();
    }

    public void insertProcedimento(AutorizacaoProcedimentoEntity autorizacaoProcedimento) {
        entityManager.persist(autorizacaoProcedimento);
    }
}
