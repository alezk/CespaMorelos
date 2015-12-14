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

        <div id="menu">
            <a title="Menú Inicio" href="<%=contex%>/Jsp/JspMenu.jsp">
                <img id="recargaPagina"  style="max-width: 190px; max-height: 50px;" src="<%=contex%>/Img/menuInicio.png"/>
            </a>
        </div>

        <div id="boxUno">
            <a href="<%=contex%>/Jsp/JspCentroAsesoriaSocial.jsp">
                <img style="max-width: 130px; max-height: 130px;" src="<%=contex%>/Img/CentroSocial.png"/>
            </a>
            <div class="semanal">Centro Social</div>
        </div>

        <div id="boxDos" >
            <a href="<%=contex%>/Jsp/JspCentroAsesoriaParticular.jsp">
                <img style="max-width: 130px; max-height: 130px;" src="<%=contex%>/Img/CentroPrivado.png"/>
            </a>
            <div class="etapas">Centro Particular</div>
        </div>

        <div id="boxTres" >
            <a href="<%=contex%>/Jsp/JspCentroAsesoriaSocialDetalle.jsp">
                <img style="width: 128px; height: 128px;" src="<%=contex%>/Img/DetalleSocila.png"/>         
            </a>
            <div class="servicios">Detalle Social</div>
        </div>

        <div id="boxCuatro" >
            <a href="<%=contex%>/Jsp/JspCentroAsesoriaParticularDetalle.jsp">
                <img style="width: 128px; height: 128px;" src="<%=contex%>/Img/DetallePrivado.png"/>
            </a>
            <div class="contable">Detalle Particular</div>
        </div>


    </body>
</html>
