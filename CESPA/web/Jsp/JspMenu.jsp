<%-- 
    Document   : JspEstadisticas
    Created on : 17/07/2015, 03:00:11 PM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String contex = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estadisticas Cespa Morelos</title>
        <link rel="icon" type="image/png" href="<%=contex%>/Img/faviconDos.ico" />
        <link type="text/css" rel="stylesheet" href="<%=contex%>/Css/cespastylecssregulacion.css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="<%=contex%>/Js/Ajax/AjaxSolicitudesSemanales.js"></script>

    </head>
    <body >

        <div id="boxUno">
            <a href="<%=contex%>/Jsp/JspMenuDireccion.jsp">
                <img style="max-width: 130px; max-height: 130px;" src="<%=contex%>/Img/direcion.png"/>
            </a>
            <div class="semanal">Dirección</div>
        </div>

        <div id="boxDos" >
            <a href="<%=contex%>/Jsp/JspMenuPlaneacion.jsp">
                <img style="max-width: 130px; max-height: 130px;" src="<%=contex%>/Img/planeacion.png"/>
            </a>
            <div class="etapas">Planeación</div>
        </div>

        <div id="boxTres" >
            <a href="<%=contex%>/Jsp/JspMenuRegulacion.jsp">
                <img style="width: 130px; height: 130px;" src="<%=contex%>/Img/regulacion.png"/>         
            </a>
            <div class="servicios">Regulación</div>
        </div>

        <div id="boxCuatro" >
            <a href="#">
                <img style="width: 130px; height: 130px;" src="<%=contex%>/Img/usuario.png"/>
            </a>
            <div class="contable"> </div>
        </div>


    </body>
</html>
