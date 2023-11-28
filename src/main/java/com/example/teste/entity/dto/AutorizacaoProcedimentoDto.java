package com.example.teste.entity.dto;

import com.example.teste.domainenum.SexoPaciente;
import com.example.teste.entity.AutorizacaoProcedimentoEntity;

public record AutorizacaoProcedimentoDto(
        long id,
        int idProcedimento,
        int idade,
        int sexoPaciente,
        boolean permitido
) {
    @Override
    public long id() {
        return id;
    }

    @Override
    public int idProcedimento() {
        return idProcedimento;
    }

    @Override
    public int idade() {
        return idade;
    }

    public String getEnumSexoPaciente() {
        return SexoPaciente.getValueByIndex(this.sexoPaciente);
    }

    public String getPermitido() {
        return this.permitido ? "SIM" : "NÃO";
    }

    public static AutorizacaoProcedimentoDto getDtoByEntity(AutorizacaoProcedimentoEntity autorizacaoProcedimento) {
        return new AutorizacaoProcedimentoDto(
                autorizacaoProcedimento.getId(), autorizacaoProcedimento.getIdProcedimento(), autorizacaoProcedimento.getIdade(), autorizacaoProcedimento.getSexoPaciente(), autorizacaoProcedimento.isPermitido()
        );
    }
}