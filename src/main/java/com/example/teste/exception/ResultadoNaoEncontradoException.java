package com.example.teste.exception;

public class ResultadoNaoEncontradoException extends Exception {

    private String message;

    public ResultadoNaoEncontradoException(String message) {
        super(message);
    }
}
