package com.example.teste.controller;

import com.example.teste.entity.dto.AutorizacaoProcedimentoDto;
import com.example.teste.entity.dto.ConsultaProcedimentoDto;
import com.example.teste.exception.ResultadoNaoEncontradoException;
import com.example.teste.service.ProcedimentoService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "consultaProcedimentoController", value = "/consulta-procedimento")
public class ConsultaProcedimentoController extends HttpServlet {

    @Inject
    private ProcedimentoService procedimentoService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("consulta-procedimento.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultaProcedimentoDto consultaProcedimentoDto = new ConsultaProcedimentoDto(
                Integer.parseInt(request.getParameter("procedimento")),
                Integer.parseInt(request.getParameter("idade")),
                request.getParameter("sexo").toUpperCase()
        );

        try {
            AutorizacaoProcedimentoDto autorizacaoProcedimentoDto = procedimentoService.getProcedimentoAutorizado(consultaProcedimentoDto);

            request.setAttribute("autorizacaoProcedimentoDto", autorizacaoProcedimentoDto);

        } catch (ResultadoNaoEncontradoException noResultException) {
            request.setAttribute("autorizacaoProcedimentoDto", noResultException);

        } catch (Exception exception) {
            request.setAttribute("autorizacaoProcedimentoDto", exception);

        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("consulta-procedimento.jsp");
            dispatcher.forward(request, response);
        }
    }

}
