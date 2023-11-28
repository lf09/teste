package com.example.teste.repository;

import com.example.teste.entity.AutorizacaoProcedimentoEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
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

    public void insertProcedimento(AutorizacaoProcedimentoEntity autorizacaoProcedimento) {
        entityManager.persist(autorizacaoProcedimento);
    }
}
