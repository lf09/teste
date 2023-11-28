package com.example.teste.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "autorizacaoprocedimento")
public class AutorizacaoProcedimentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "id_procedimento")
    private int idProcedimento;
    @NotNull
    private int idade;
    @NotNull
    @Column(name = "sexo")
    private int sexoPaciente;
    @NotNull
    private boolean permitido;

    public AutorizacaoProcedimentoEntity() {

    }

    public AutorizacaoProcedimentoEntity(int idProcedimento, int idade, int sexoPaciente, boolean permitido) {
        this.id = id;
        this.idProcedimento = idProcedimento;
        this.idade = idade;
        this.sexoPaciente = sexoPaciente;
        this.permitido = permitido;
    }

    public AutorizacaoProcedimentoEntity(long id, int idProcedimento, int idade, int sexoPaciente, boolean permitido) {
        this.id = id;
        this.idProcedimento = idProcedimento;
        this.idade = idade;
        this.sexoPaciente = sexoPaciente;
        this.permitido = permitido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(int sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public boolean isPermitido() {
        return permitido;
    }

    public void setPermitido(boolean permitido) {
        this.permitido = permitido;
    }
}
