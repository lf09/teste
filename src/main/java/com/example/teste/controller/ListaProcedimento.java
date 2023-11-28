package com.example.teste.controller;

import com.example.teste.entity.dto.AutorizacaoProcedimentoDto;
import com.example.teste.service.ProcedimentoService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listaProcedimento", value = "/lista-procedimento")
public class ListaProcedimento extends HttpServlet {

    @Inject
    private ProcedimentoService procedimentoService;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AutorizacaoProcedimentoDto> autorizacaoProcedimentoList = new ArrayList<>();
        autorizacaoProcedimentoList.addAll(procedimentoService.getAutorizacaoProcedimento());

        request.setAttribute("autorizacaoProcedimentoList", autorizacaoProcedimentoList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-cadastro.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
