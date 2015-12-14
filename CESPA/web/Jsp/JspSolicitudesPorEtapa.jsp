<%-- 
    Document   : JspSolicitudesSemanales
    Created on : 15/07/2015, 02:59:27 PM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String contex = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitudes Etapa</title>
        <link rel="icon" type="image/png" href="<%=contex%>/Img/faviconDos.ico" />
        <link type="text/css" rel="stylesheet" href="<%=contex%>/Css/cespastylecss.css" />
        <link type="text/css" rel="stylesheet" href="<%=contex%>/Css/cespastyletablaetapa.css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="<%=contex%>/Js/Ajax/AjaxSolicitudesPorEtapa.js"></script>
        <style type="text/css">
            ${demo.css}
        </style>
    </head>
    <body onload="solicitudesSemanales('<%=contex%>')">

        <script src="<%=contex%>/Js/highcharts.js"></script>
        <script src="<%=contex%>/Js/modules/exporting.js"></script>
        <script src="<%=contex%>/Js/themes/grid-etapa.js"></script>

        <div id="Regresar">
            <a title="Actualizar Grafica" href="#">
                <img id="recargaPagina" style="max-width: 50px; max-height: 50px;" src="<%=contex%>/Img/actualizarDos.png"/>
            </a>
        </div>

        <div id="Menu">
            <a title="Menú" href="<%=contex%>/Jsp/JspMenuDireccion.jsp">
                <img style="max-width: 50px; max-height: 50px;" src="<%=contex%>/Img/iconDos.png"/>
            </a>
        </div>


        <div id="divTablaJson">
            <table id="tablaJson">
                <tr>
                    <td><b>#</b></td>
                    <td><b>Plan 33</b></td>
                    <td><b>Plan 22</b></td>
                    <td><b>Total</b></td>
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

        <div id="container" style="width:  650px; height: 370px;float: left; margin: 6% auto"></div>

    </body>
</html>
