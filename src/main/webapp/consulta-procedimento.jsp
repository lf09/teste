<%@ page import="com.example.teste.entity.dto.AutorizacaoProcedimentoDto" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<html>

<head>
    <title>Consulta Procedimentos</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="stylesheet/reset.css">
    <link rel="stylesheet" type="text/css" href="stylesheet/style.css">
</head>

<body>

<jsp:include page="/html-default/header.html"/>

<form action="" method="post">
    <table>
        <tr>
            <th><label form="id_procedimento">Procedimento</label></th>
            <th><label form="idade">Idade</label></th>
            <th>
                <legend>Sexo</legend>
            </th>
            <th></th>
        </tr>

        <tr>
            <td>
                <input id="procedimento" name="procedimento" class="input" type="text" required=""
                       oninput="this.value=this.value.replace(/(?![0-9])./gmi,'')">
            </td>

            <td>
                <input id="idade" name="idade" class="input" type="text" required=""
                       oninput="this.value=this.value.replace(/(?![0-9])./gmi,'')">
            </td>

            <td>
                <fieldset>
                    <select name="sexo">
                        <option>M</option>
                        <option>F</option>
                    </select>
                </fieldset>
            </td>

            <td>
                <input class="submit" type="submit" value="Consultar">
            </td>

        </tr>
    </table>
</form>

<%
    try {

        if (request.getAttribute("autorizacaoProcedimentoDto") != null) {
            AutorizacaoProcedimentoDto autorizacaoProcedimentoDto = (AutorizacaoProcedimentoDto) request.getAttribute("autorizacaoProcedimentoDto");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append("<resultbody>")
                    .append("<table>")
                    .append("<tr>")
                    .append("<th>").append("<h3>PROCEDIMENTO</h3>").append("</th>")
                    .append("<th>").append("<h3>IDADE</h3>").append("</th>")
                    .append("<th>").append("<h3>SEXO</h3>").append("</th>")
                    .append("<th>").append("<h3>PERMITIDO</h3>").append("</th>")
                    .append("</tr>");

            stringBuilder.append("<tr>")
                    .append("<td>").append(autorizacaoProcedimentoDto.idProcedimento()).append("</td>")
                    .append("<td>").append(autorizacaoProcedimentoDto.idade()).append("</td>")
                    .append("<td>").append(autorizacaoProcedimentoDto.getEnumSexoPaciente()).append("</td>")
                    .append("<td>").append(autorizacaoProcedimentoDto.getPermitido()).append("</td>")
                    .append("</tr>");

            stringBuilder.append("</table>")
                    .append("</resultbody>");
            response.getWriter().println(stringBuilder);
        }
    } catch (Exception exception) {
        response.getWriter()
                .format(new StringBuilder()
                        .append("<div class=\"procedimentonaopermitido\">")
                        .append("Procedimento não permitido:")
                        .append("<div class=\"motivoprocedimentonaopermitido\">")
                        .append("<ul><li>Nao cadastrado!</li></ul>")
                        .append("</div>")
                        .append("</div>")
                        .toString(), StandardCharsets.UTF_8)
                .println();
    } finally {
        request.setAttribute("autorizacaoProcedimentoDto", null);
    }

%>

</body>
</html>
