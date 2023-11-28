package com.example.teste.service;

import com.example.teste.entity.AutorizacaoProcedimentoEntity;
import com.example.teste.entity.dto.AutorizacaoProcedimentoDto;
import com.example.teste.repository.AutorizacaoProcedimentoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProcedimentoService {

    @Inject
    private AutorizacaoProcedimentoRepository autorizacaoProcedimentoRepository;

    @Transactional
    public List<AutorizacaoProcedimentoDto> getAutorizacaoProcedimento() {
        List<AutorizacaoProcedimentoDto> autorizacaoProcedimentoDtoList = new ArrayList<>();

        for (AutorizacaoProcedimentoEntity autorizacaoProcedimento : autorizacaoProcedimentoRepository.findAll()) {
            autorizacaoProcedimentoDtoList.add(AutorizacaoProcedimentoDto.getDtoByEntity(autorizacaoProcedimento));
        }

        return autorizacaoProcedimentoDtoList;
    }

    @Transactional
    public void insertAutorizacaoProcedimento(AutorizacaoProcedimentoEntity autorizacaoProcedimento) {
        autorizacaoProcedimentoRepository.insertProcedimento(autorizacaoProcedimento);
    }
}
