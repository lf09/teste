<%@ page import="java.util.List" %>
<%@ page import="com.example.teste.entity.dto.AutorizacaoProcedimentoDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Procedimento</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="stylesheet/reset.css">
    <link rel="stylesheet" type="text/css" href="stylesheet/style.css">
</head>
<body>
<tbody>
    <jsp:include page="/html-default/header.html"/>
</tbody>

<mbody>
    <%
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("<mbody>")
                .append("<table>")
                .append("<tr>")
                .append("<th>").append("<h3>PROCEDIMENTO</h3>").append("</th>")
                .append("<th>").append("<h3>IDADE</h3>").append("</th>")
                .append("<th>").append("<h3>SEXO</h3>").append("</th>")
                .append("<th>").append("<h3>PERMITIDO</h3>").append("</th>")
                .append("</tr>");

        try {
            List<AutorizacaoProcedimentoDto> autorizacaoProcedimentoList = (List<AutorizacaoProcedimentoDto>) request.getAttribute("autorizacaoProcedimentoList");

            for (AutorizacaoProcedimentoDto oAutorizacao : autorizacaoProcedimentoList) {
                stringBuilder.append("<tr>")
                        .append("<td>").append(oAutorizacao.idProcedimento()).append("</td>")
                        .append("<td>").append(oAutorizacao.idade()).append("</td>")
                        .append("<td>").append(oAutorizacao.getEnumSexoPaciente()).append("</td>")
                        .append("<td>").append(oAutorizacao.getPermitido()).append("</td>")
                        .append("</tr>");
            }
        } catch (Exception ex) {
        }

        stringBuilder.append("</table>");
        stringBuilder.append("</mbody>");

        response.getWriter().println(stringBuilder);
    %>
</mbody>

</body>
</html>
