<%-- 
    Document   : JspCentroAsesoriaSocial
    Created on : 29/07/2015, 08:54:33 AM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String contex = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="<%=contex%>/Img/faviconDos.ico" />
        <link type="text/css" rel="stylesheet" href="<%=contex%>/Css/cespastylecss.css" />
        <link type="text/css" rel="stylesheet" href="<%=contex%>/Css/cespastyletablacentrosGreen.css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="<%=contex%>/Js/Ajax/AjaxCentrosDeAsesoria.js"></script>
        <title>Centro de Asesoria Social</title>
    </head>
    <body onload="CentrosSociales('P', '<%=contex%>')">

        <div id="Regresar">
            <a title="Actualizar Grafica" href="#">
                <img id="recargaPagina" onclick="ArchivoJson('P','<%=contex%>')" style="max-width: 50px; max-height: 50px;" src="<%=contex%>/Img/actualizarDos.png"/>
            </a>
        </div>

        <div id="Menu">
            <a title="Menú" href="<%=contex%>/Jsp/JspMenuRegulacion.jsp">
                <img style="max-width: 50px; max-height: 50px;" src="<%=contex%>/Img/iconDos.png"/>
            </a>
        </div>

        <div id="mensage"><img id="imgMensage" src="<%=contex%>/Img/cloud.ico" />¡La información no se encuntra actualizada!</div>    

        <div id="divTablaJson">
            <div id="labelTable">Centro de Asesoria Particular</div>
            <table id="tablaJson">
                <tr>
                    <th><strong>Particular Plan / 22</strong></th>
                    <th><strong>Ene</strong></th>
                    <th><strong>Feb</strong></th>
                    <th><strong>Mar</strong></th>
                    <th><strong>Abr</strong></th>
                    <th><strong>May</strong></th>
                    <th><strong>Jun</strong></th>
                    <th><strong>Jul</strong></th>
                    <th><strong>Ago</strong></th>
                    <th><strong>Sep</strong></th>
                    <th><strong>Oct</strong></th>
                    <th><strong>Nov</strong></th>
                    <th><strong>Dic</strong></th>
                    <th><strong>Total</strong></th>
                </tr>
                <tbody id="idTablaJSON">
                </tbody>
            </table>	   
        </div>

        <div id="boxLoad">
            <a href="#">
                <img style="max-width: 130px; max-height: 130px;" src="<%=contex%>/Img/gears.gif"/>
            </a>
        </div>

        <div id="mesLoad"><img id="imgMensage" src="<%=contex%>/Img/tools.ico" />¡Generando la información, espere porfavor!</div>

    </body>
</html>
