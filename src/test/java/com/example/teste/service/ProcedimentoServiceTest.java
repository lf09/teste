package com.example.teste.service;

import com.example.teste.entity.AutorizacaoProcedimentoEntity;
import com.example.teste.entity.dto.AutorizacaoProcedimentoDto;
import com.example.teste.repository.AutorizacaoProcedimentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProcedimentoServiceTest {

    @InjectMocks
    private ProcedimentoService procedimentoService;

    @Mock
    private AutorizacaoProcedimentoRepository autorizacaoProcedimentoRepository;

    @Test
    void getAutorizacaoProcedimento() throws Exception {
        when(autorizacaoProcedimentoRepository.findAll()).thenReturn(autorizacaoProcedimentoEntities());

        List<AutorizacaoProcedimentoDto> autorizacaoProcedimentoDtoEsperado = new ArrayList<>();

        for (AutorizacaoProcedimentoEntity autorizacaoProcedimento : autorizacaoProcedimentoEntities()) {
            autorizacaoProcedimentoDtoEsperado.add(AutorizacaoProcedimentoDto.getDtoByEntity(autorizacaoProcedimento));
        }

        List<AutorizacaoProcedimentoDto> result = procedimentoService.getAutorizacaoProcedimento();

        for (AutorizacaoProcedimentoDto autorizacaoProcedimentoConsulta : result) {
            assertEquals(autorizacaoProcedimentoConsulta.getPermitido(),
                    autorizacaoProcedimentoDtoEsperado.stream()
                            .filter(procedimento ->
                                    procedimento.idProcedimento() == autorizacaoProcedimentoConsulta.idProcedimento() &&
                                            procedimento.idade() == autorizacaoProcedimentoConsulta.idade() &&
                                            procedimento.getEnumSexoPaciente().equals(autorizacaoProcedimentoConsulta.getEnumSexoPaciente()))
                            .findFirst().get().getPermitido()
            );
        }
    }

    @Test
    void getProcedimentoAutorizado() {

    }

    @Test
    void insertAutorizacaoProcedimento() {

    }

    private List<AutorizacaoProcedimentoEntity> autorizacaoProcedimentoEntities() {
        List<AutorizacaoProcedimentoEntity> autorizacaoProcedimentoEntities = new LinkedList<>();

        autorizacaoProcedimentoEntities.add(new AutorizacaoProcedimentoEntity(1234, 10, 1, false));
        autorizacaoProcedimentoEntities.add(new AutorizacaoProcedimentoEntity(4567, 20, 1, true));
        autorizacaoProcedimentoEntities.add(new AutorizacaoProcedimentoEntity(6789, 10, 2, false));
        autorizacaoProcedimentoEntities.add(new AutorizacaoProcedimentoEntity(6789, 10, 1, true));
        autorizacaoProcedimentoEntities.add(new AutorizacaoProcedimentoEntity(1234, 20, 1, true));
        autorizacaoProcedimentoEntities.add(new AutorizacaoProcedimentoEntity(4567, 30, 2, true));

        return autorizacaoProcedimentoEntities;
    }
}