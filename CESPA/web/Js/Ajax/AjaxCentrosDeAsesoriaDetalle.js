/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    $('#divTablaJson').hide();
    $('#Regresar').hide();
    $('#mensage').hide();
    $('#Menu').hide();
    $('#mesLoad').hide();

    CentrosSociales = function(tipo, contex) {

        if (tipo === 'S') {
            url = contex + "/Json/JsonCentroAsesoriaSocial.json";
        } else {
            url = contex + "/Json/JsonCentroAsesoriaParticular.json";
        }

        $.ajax(
                {
                    type: "GET",
                    url: url,
//                    data: 'tipo=' + tipo,
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    error: errorAjax,
                    success: respuestaJson,
                    complete: cargadoGrafica
                });
    };

    errorAjax = function(a, e) {
//        alert('Error en la carga'+a.status+" "+e);
        $('#Regresar').show();
        $('#Menu').show();
        $('#mensage').fadeIn(2000);
    };

    respuestaJson = function(json) {

        tablaSemanalJson(json);

    };

    cargadoGrafica = function() {
        $('#boxLoad').hide();
    };

    tablaSemanalJson = function(json) {
        $('#tablaJson').remove();
        var tabla = '<table id="tablaJson"><tr><th><strong> Plan / 22 </strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr><tbody id="idTablaJSON"></tbody></table>';
        $('#divTablaJson').append(tabla);
        var es33 = "<tr><td>Estudiantes que solicitan exámenes</td> <td id='E33-01'>0</td> <td id='E33-02'>0</td> <td id='E33-03'>0</td> <td id='E33-04'>0</td> <td id='E33-05'>0</td> <td id='E33-06'>0</td> <td id='E33-07'>0</td> <td id='E33-08'>0</td> <td id='E33-09'>0</td> <td id='E33-10'>0</td> <td id='E33-11'>0</td> <td id='E33-12'>0</td>";
        var es22 = "<tr><td>Estudiantes que solicitan exámenes</td> <td id='E22-01'>0</td> <td id='E22-02'>0</td> <td id='E22-03'>0</td> <td id='E22-04'>0</td> <td id='E22-05'>0</td> <td id='E22-06'>0</td> <td id='E22-07'>0</td> <td id='E22-08'>0</td> <td id='E22-09'>0</td> <td id='E22-10'>0</td> <td id='E22-11'>0</td> <td id='E22-12'>0</td>";
        var sol22 = "<tr><td>Solicitados</td> <td id='S22-01'>0</td> <td id='S22-02'>0</td> <td id='S22-03'>0</td> <td id='S22-04'>0</td> <td id='S22-05'>0</td> <td id='S22-06'>0</td> <td id='S22-07'>0</td> <td id='S22-08'>0</td> <td id='S22-09'>0</td> <td id='S22-10'>0</td> <td id='S22-11'>0</td> <td id='S22-12'>0</td>";
        var sol33 = "<tr><td>Solicitados</td> <td id='S33-01'>0</td> <td id='S33-02'>0</td> <td id='S33-03'>0</td> <td id='S33-04'>0</td> <td id='S33-05'>0</td> <td id='S33-06'>0</td> <td id='S33-07'>0</td> <td id='S33-08'>0</td> <td id='S33-09'>0</td> <td id='S33-10'>0</td> <td id='S33-11'>0</td> <td id='S33-12'>0</td>";
        var pre22 = "<tr><td>Presentados</td> <td id='P22-01'>0</td> <td id='P22-02'>0</td> <td id='P22-03'>0</td> <td id='P22-04'>0</td> <td id='P22-05'>0</td> <td id='P22-06'>0</td> <td id='P22-07'>0</td> <td id='P22-08'>0</td> <td id='P22-09'>0</td> <td id='P22-10'>0</td> <td id='P22-11'>0</td> <td id='P22-12'>0</td>";
        var pre33 = "<tr><td>Presentados</td> <td id='P33-01'>0</td> <td id='P33-02'>0</td> <td id='P33-03'>0</td> <td id='P33-04'>0</td> <td id='P33-05'>0</td> <td id='P33-06'>0</td> <td id='P33-07'>0</td> <td id='P33-08'>0</td> <td id='P33-09'>0</td> <td id='P33-10'>0</td> <td id='P33-11'>0</td> <td id='P33-12'>0</td>";
        var ac22 = "<tr><td>Acreditados</td> <td id='A22-01'>0</td> <td id='A22-02'>0</td> <td id='A22-03'>0</td> <td id='A22-04'>0</td> <td id='A22-05'>0</td> <td id='A22-06'>0</td> <td id='A22-07'>0</td> <td id='A22-08'>0</td> <td id='A22-09'>0</td> <td id='A22-10'>0</td> <td id='A22-11'>0</td> <td id='A22-12'>0</td>";
        var ac33 = "<tr><td>Acreditados</td> <td id='A33-01'>0</td> <td id='A33-02'>0</td> <td id='A33-03'>0</td> <td id='A33-04'>0</td> <td id='A33-05'>0</td> <td id='A33-06'>0</td> <td id='A33-07'>0</td> <td id='A33-08'>0</td> <td id='A33-09'>0</td> <td id='A33-10'>0</td> <td id='A33-11'>0</td> <td id='A33-12'>0</td>";

        $('#idTablaJSON').append(es22 + "<td>" + json.Totales[0] + "</td></tr>");
        $('#idTablaJSON').append(sol22 + "<td>" + json.Totales[1] + "</td></tr>");
        $('#idTablaJSON').append(pre22 + "<td>" + json.Totales[2] + "</td></tr>");
        $('#idTablaJSON').append(ac22 + "<td>" + json.Totales[3] + "</td></tr>");
        $('#idTablaJSON').append("<tr><th><strong> Plan / 33</strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr>");
        $('#idTablaJSON').append(es33 + "<td>" + json.Totales[4] + "</td></tr>");
        $('#idTablaJSON').append(sol33 + "<td>" + json.Totales[5] + "</td></tr>");
        $('#idTablaJSON').append(pre33 + "<td>" + json.Totales[6] + "</td></tr>");
        $('#idTablaJSON').append(ac33 + "<td>" + json.Totales[7] + "</td></tr>");


        for (var x = 0; x < 12; x++) {

            if (json.listEstudiantes22[x] !== undefined) {
                var e2 = json.listEstudiantes22[x].etapa + "";
                $('#E22-' + e2.substring(4, 6)).text(json.listEstudiantes22[x].total);
            }

            if (json.listEstudiantes33[x] !== undefined) {
                var e3 = json.listEstudiantes33[x].etapa + "";
                $('#E33-' + e3.substring(4, 6)).text(json.listEstudiantes33[x].total);
            }

            if (json.listSolicitados22[x] !== undefined) {
                var s2 = json.listSolicitados22[x].etapa + "";
                $('#S22-' + s2.substring(4, 6)).text(json.listSolicitados22[x].total);
            }

            if (json.listSolicitados33[x] !== undefined) {
                var s3 = json.listSolicitados33[x].etapa + "";
                $('#S33-' + s3.substring(4, 6)).text(json.listSolicitados33[x].total);
            }

            if (json.listPresentados22[x] !== undefined) {
                var p2 = json.listPresentados22[x].etapa + "";
                $('#P22-' + p2.substring(4, 6)).text(json.listPresentados22[x].total);
            }

            if (json.listPresentados33[x] !== undefined) {
                var p3 = json.listPresentados33[x].etapa + "";
                $('#P33-' + p3.substring(4, 6)).text(json.listPresentados33[x].total);
            }

            if (json.listAcreditados22[x] !== undefined) {
                var a2 = json.listAcreditados22[x].etapa + "";
                $('#A22-' + a2.substring(4, 6)).text(json.listAcreditados22[x].total);
            }

            if (json.listAcreditados33[x] !== undefined) {
                var a3 = json.listAcreditados33[x].etapa + "";
                $('#A33-' + a3.substring(4, 6)).text(json.listAcreditados33[x].total);
            }

//            es22 += "<td>&nbsp;" + ((json.listEstudiantes22[x] === undefined ? 0 : json.listEstudiantes22[x].total)) + "&nbsp;</td>";
//            es33 += "<td>&nbsp;" + ((json.listEstudiantes33[x] === undefined ? 0 : json.listEstudiantes33[x].total)) + "&nbsp;</td>";
//
//            sol22 += "<td>&nbsp;" + ((json.listSolicitados22[x] === undefined ? 0 : json.listSolicitados22[x].total)) + "&nbsp;</td>";
//            sol33 += "<td>&nbsp;" + ((json.listSolicitados33[x] === undefined ? 0 : json.listSolicitados33[x].total)) + "&nbsp;</td>";
//
//            pre22 += "<td>&nbsp;" + ((json.listPresentados22[x] === undefined ? 0 : json.listPresentados22[x].total)) + "&nbsp;</td>";
//            pre33 += "<td>&nbsp;" + ((json.listPresentados33[x] === undefined ? 0 : json.listPresentados33[x].total)) + "&nbsp;</td>";
//
//            ac22 += "<td>&nbsp;" + ((json.listAcreditados22[x] === undefined ? 0 : json.listAcreditados22[x].total)) + "&nbsp;</td>";
//            ac33 += "<td>&nbsp;" + ((json.listAcreditados33[x] === undefined ? 0 : json.listAcreditados33[x].total)) + "&nbsp;</td>";

        }


        $('#divTablaJson').show();
        $('#Regresar').show();
        $('#Menu').show();

    };

    headTable = function(json, p) {
        var mes = json.listSolicitados22[0].etapa + "";
        var x = parseInt(mes.substring(4, 6));
        var h;

        switch (x) {
            case 1:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 2:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong></strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 3:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 4:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 5:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></th><th><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></th><th><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></th><th><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 6:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 7:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 8:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 9:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 10:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 11:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Total</strong></th></tr>";
                break;
            case 12:
                h = "<tr><th><strong> Plan / " + p + "</strong></th><th><strong>Dic</strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong> </strong></th><th><strong>Nov</strong></th><th><strong>Total</strong></th></tr>";
                break;
        }
        return h;
    };

//    $('#recargaPagina').click(function() {
//        // Recargo la página
//        location.reload();
//    });

//------------------AjaxParaCrearArchivosJson------------------//

    ArchivoJson = function(tipo, contex, centro) {
        

        $('#mensage').hide();
        $('#divTablaJson').hide();
        $('#Menu').hide();
        $('#Regresar').hide();

        $('#boxLoad').fadeIn("slow");
        $('#mesLoad').fadeIn("slow");
        $('#mesLoad').fadeOut(5000);

        url = contex + "/ServletCentroAsesoriaDetalleJSON";
        $.ajax(
                {
                    type: "GET",
                    url: url,
                    data: 'tipo=' + tipo+'&centro='+centro,
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    error: errorJson,
                    success: successJson,
                    complete: completeJson
                });
    };

    errorJson = function() {
        alert('Error al generar los archivos JSON');
    };

    successJson = function(json) {
        //location.reload();
        //alert(respuesta.mensage);
//        location.reload();
        tablaSemanalJson(json);
    };

    completeJson = function() {
//        alert("Completo");
        $('#boxLoad').hide();
    };

//----AjaxParaLaCargaDelConbox

    ComBoxJson = function(tipo, contex) {
        $('#mensage').hide();
        $('#divTablaJson').hide();
        $('#Menu').hide();
        $('#Regresar').hide();

        $('#boxLoad').fadeIn("slow");
        $('#mesLoad').fadeIn("slow");
        $('#mesLoad').fadeOut(2000);

        url = contex + "/ServletListaCentrosDeAsesoriaJson";
        $.ajax(
                {
                    type: "GET",
                    url: url,
                    data: 'tipo=' + tipo,
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    error: errorJsonBox,
                    success: successJsonBox,
                    complete: completeJsonBox
                });
    };

    errorJsonBox = function() {
        alert('Error al generar los archivos JSON');
    };

    successJsonBox = function(json) {

        for (var x = 0; x < json.length; x++) {
            var option = $('<option />');
            option.attr('value', json[x].idCentro).text(''+ json[x].idCentro+' - '+json[x].centroAsesoria);
            $('#idComboAsesoria').append(option);
        }
        
        $('#tablaJson').remove();
        var tabla = '<table id="tablaJson"><tr><th><strong> Plan / 22 </strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr><tbody id="idTablaJSON"></tbody></table>';
        $('#divTablaJson').append(tabla);
        var es33 = "<tr><td>Estudiantes que solicitan exámenes</td> <td id='E33-01'>0</td> <td id='E33-02'>0</td> <td id='E33-03'>0</td> <td id='E33-04'>0</td> <td id='E33-05'>0</td> <td id='E33-06'>0</td> <td id='E33-07'>0</td> <td id='E33-08'>0</td> <td id='E33-09'>0</td> <td id='E33-10'>0</td> <td id='E33-11'>0</td> <td id='E33-12'>0</td>";
        var es22 = "<tr><td>Estudiantes que solicitan exámenes</td> <td id='E22-01'>0</td> <td id='E22-02'>0</td> <td id='E22-03'>0</td> <td id='E22-04'>0</td> <td id='E22-05'>0</td> <td id='E22-06'>0</td> <td id='E22-07'>0</td> <td id='E22-08'>0</td> <td id='E22-09'>0</td> <td id='E22-10'>0</td> <td id='E22-11'>0</td> <td id='E22-12'>0</td>";
        var sol22 = "<tr><td>Solicitados</td> <td id='S22-01'>0</td> <td id='S22-02'>0</td> <td id='S22-03'>0</td> <td id='S22-04'>0</td> <td id='S22-05'>0</td> <td id='S22-06'>0</td> <td id='S22-07'>0</td> <td id='S22-08'>0</td> <td id='S22-09'>0</td> <td id='S22-10'>0</td> <td id='S22-11'>0</td> <td id='S22-12'>0</td>";
        var sol33 = "<tr><td>Solicitados</td> <td id='S33-01'>0</td> <td id='S33-02'>0</td> <td id='S33-03'>0</td> <td id='S33-04'>0</td> <td id='S33-05'>0</td> <td id='S33-06'>0</td> <td id='S33-07'>0</td> <td id='S33-08'>0</td> <td id='S33-09'>0</td> <td id='S33-10'>0</td> <td id='S33-11'>0</td> <td id='S33-12'>0</td>";
        var pre22 = "<tr><td>Presentados</td> <td id='P22-01'>0</td> <td id='P22-02'>0</td> <td id='P22-03'>0</td> <td id='P22-04'>0</td> <td id='P22-05'>0</td> <td id='P22-06'>0</td> <td id='P22-07'>0</td> <td id='P22-08'>0</td> <td id='P22-09'>0</td> <td id='P22-10'>0</td> <td id='P22-11'>0</td> <td id='P22-12'>0</td>";
        var pre33 = "<tr><td>Presentados</td> <td id='P33-01'>0</td> <td id='P33-02'>0</td> <td id='P33-03'>0</td> <td id='P33-04'>0</td> <td id='P33-05'>0</td> <td id='P33-06'>0</td> <td id='P33-07'>0</td> <td id='P33-08'>0</td> <td id='P33-09'>0</td> <td id='P33-10'>0</td> <td id='P33-11'>0</td> <td id='P33-12'>0</td>";
        var ac22 = "<tr><td>Acreditados</td> <td id='A22-01'>0</td> <td id='A22-02'>0</td> <td id='A22-03'>0</td> <td id='A22-04'>0</td> <td id='A22-05'>0</td> <td id='A22-06'>0</td> <td id='A22-07'>0</td> <td id='A22-08'>0</td> <td id='A22-09'>0</td> <td id='A22-10'>0</td> <td id='A22-11'>0</td> <td id='A22-12'>0</td>";
        var ac33 = "<tr><td>Acreditados</td> <td id='A33-01'>0</td> <td id='A33-02'>0</td> <td id='A33-03'>0</td> <td id='A33-04'>0</td> <td id='A33-05'>0</td> <td id='A33-06'>0</td> <td id='A33-07'>0</td> <td id='A33-08'>0</td> <td id='A33-09'>0</td> <td id='A33-10'>0</td> <td id='A33-11'>0</td> <td id='A33-12'>0</td>";
          $('#idTablaJSON').append(es22 + "<td>0</td></tr>");
        $('#idTablaJSON').append(sol22 + "<td>0</td></tr>");
        $('#idTablaJSON').append(pre22 + "<td>0</td></tr>");
        $('#idTablaJSON').append(ac22 + "<td>0</td></tr>");
        $('#idTablaJSON').append("<tr><th><strong> Plan / 33</strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr>");
        $('#idTablaJSON').append(es33 + "<td>0</td></tr>");
        $('#idTablaJSON').append(sol33 + "<td>0</td></tr>");
        $('#idTablaJSON').append(pre33 + "<td>0</td></tr>");
        $('#idTablaJSON').append(ac33 + "<td>0</td></tr>");

        $('#divTablaJson').show();
        $('#Regresar').show();
        $('#Menu').show();


    };

    completeJsonBox = function() {
//        alert("Completo");
        $('#boxLoad').hide();
    };


});