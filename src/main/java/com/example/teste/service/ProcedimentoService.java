package com.example.teste.service;

import com.example.teste.domainenum.SexoPaciente;
import com.example.teste.entity.AutorizacaoProcedimentoEntity;
import com.example.teste.entity.dto.AutorizacaoProcedimentoDto;
import com.example.teste.entity.dto.ConsultaProcedimentoDto;
import com.example.teste.exception.ResultadoNaoEncontradoException;
import com.example.teste.repository.AutorizacaoProcedimentoRepository;
import jakarta.ejb.EJBTransactionRolledbackException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProcedimentoService {

    @Inject
    private AutorizacaoProcedimentoRepository autorizacaoProcedimentoRepository;

    public List<AutorizacaoProcedimentoDto> getAutorizacaoProcedimento() {
        List<AutorizacaoProcedimentoDto> autorizacaoProcedimentoDtoList = new ArrayList<>();

        for (AutorizacaoProcedimentoEntity autorizacaoProcedimento : autorizacaoProcedimentoRepository.findAll()) {
            autorizacaoProcedimentoDtoList.add(AutorizacaoProcedimentoDto.getDtoByEntity(autorizacaoProcedimento));
        }

        return autorizacaoProcedimentoDtoList;
    }

    public AutorizacaoProcedimentoDto getProcedimentoAutorizado(ConsultaProcedimentoDto consultaProcedimentoDto) throws NoResultException, Exception {
        try {
            AutorizacaoProcedimentoEntity autorizacaoProcedimento = autorizacaoProcedimentoRepository.getProcedimentoAutorizado(
                    consultaProcedimentoDto.idProcedimento(), consultaProcedimentoDto.idade(), SexoPaciente.getIndexByValue(consultaProcedimentoDto.sexo().toUpperCase())
            );

            return new AutorizacaoProcedimentoDto(
                    autorizacaoProcedimento.getId(), autorizacaoProcedimento.getIdProcedimento(), autorizacaoProcedimento.getIdade(), autorizacaoProcedimento.getSexoPaciente(), autorizacaoProcedimento.isPermitido());

        } catch (NoResultException | EJBTransactionRolledbackException ex) {
            throw new ResultadoNaoEncontradoException(ex.getMessage());
        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    @Transactional
    public void insertAutorizacaoProcedimento(AutorizacaoProcedimentoEntity autorizacaoProcedimento) {
        autorizacaoProcedimentoRepository.insertProcedimento(autorizacaoProcedimento);
    }
}
