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

        tablaSemanalJson(json)

    };

    cargadoGrafica = function() {
        $('#boxLoad').hide();
    };

    tablaSemanalJson = function(json) {
        $('#tablaJson').remove();
        var tabla = '<table id="tablaJson"><tr><th><strong> Plan / 22</strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr><tbody id="idTablaJSON"></tbody></table>';
        $('#divTablaJson').append(tabla);
        var es33 = "<tr><td>Estudiantes que solicitan exámenes</td>";
        var es22 = "<tr><td>Estudiantes que solicitan exámenes</td>";
        var genH22 = "<tr><td>Hombres</td>";
        var genM22 = "<tr><td>Mujeres</td>";
        var genH33 = "<tr><td>Hombres</td>";
        var genM33 = "<tr><td>Mujeres</td>";
        var sol22 = "<tr><td>Solicitados</td>";
        var sol33 = "<tr><td>Solicitados</td>";
        var pre22 = "<tr><td>Presentados</td>";
        var pre33 = "<tr><td>Presentados</td>";
        var ac22 = "<tr><td>Acreditados</td>";
        var ac33 = "<tr><td>Acreditados</td>";

        for (var x = 0; x < 12; x++) {
            var id = parseInt(x) + 1;

            es22 += "<td>&nbsp;" + ((json.listEstudiantes22[x] === undefined ? 0 : json.listEstudiantes22[x].total)) + "&nbsp;</td>";
            es33 += "<td>&nbsp;" + ((json.listEstudiantes33[x] === undefined ? 0 : json.listEstudiantes33[x].total)) + "&nbsp;</td>";

            genH22 += "<td id='h22-" + id + "'>&nbsp;0&nbsp;</td>";
            genM22 += "<td id='m22-" + id + "'>&nbsp;0&nbsp;</td>";

            genH33 += "<td id='h33-" + id + "'>&nbsp;0&nbsp;</td>";
            genM33 += "<td id='m33-" + id + "'>&nbsp;0&nbsp;</td>";

            sol22 += "<td>&nbsp;" + ((json.listSolicitados22[x] === undefined ? 0 : json.listSolicitados22[x].total)) + "&nbsp;</td>";
            sol33 += "<td>&nbsp;" + ((json.listSolicitados33[x] === undefined ? 0 : json.listSolicitados33[x].total)) + "&nbsp;</td>";

            pre22 += "<td>&nbsp;" + ((json.listPresentados22[x] === undefined ? 0 : json.listPresentados22[x].total)) + "&nbsp;</td>";
            pre33 += "<td>&nbsp;" + ((json.listPresentados33[x] === undefined ? 0 : json.listPresentados33[x].total)) + "&nbsp;</td>";

            ac22 += "<td>&nbsp;" + ((json.listAcreditados22[x] === undefined ? 0 : json.listAcreditados22[x].total)) + "&nbsp;</td>";
            ac33 += "<td>&nbsp;" + ((json.listAcreditados33[x] === undefined ? 0 : json.listAcreditados33[x].total)) + "&nbsp;</td>";

        }
        $('#idTablaJSON').append(es22 + "<td>" + json.Totales[0] + "</td>");
        $('#idTablaJSON').append(genH22 + "<td id='h22T'>" + 0 + "</td>");
        $('#idTablaJSON').append(genM22 + "<td id='m22T'>" + 0 + "</td>");
        $('#idTablaJSON').append(sol22 + "<td>" + json.Totales[1] + "</td>");
        $('#idTablaJSON').append(pre22 + "<td>" + json.Totales[2] + "</td>");
        $('#idTablaJSON').append(ac22 + "<td>" + json.Totales[3] + "</td>");
        $('#idTablaJSON').append("<tr><th><strong> Plan / 33</strong></th><th><strong>Ene</strong></th><th><strong>Feb</strong></th><th><strong>Mar</strong></th><th><strong>Abr</strong></th><th><strong>May</strong></th><th><strong>Jun</strong></th><th><strong>Jul</strong></th><th><strong>Ago</strong></th><th><strong>Sep</strong></th><th><strong>Oct</strong></th><th><strong>Nov</strong></th><th><strong>Dic</strong></th><th><strong>Total</strong></th></tr>");
        $('#idTablaJSON').append(es33 + "<td>" + json.Totales[4] + "</td>");
        $('#idTablaJSON').append(genH33 + "<td id='h33T'>" + 0 + "</td>");
        $('#idTablaJSON').append(genM33 + "<td id='m33T'>" + 0 + "</td>");
        $('#idTablaJSON').append(sol33 + "<td>" + json.Totales[5] + "</td>");
        $('#idTablaJSON').append(pre33 + "<td>" + json.Totales[6] + "</td>");
        $('#idTablaJSON').append(ac33 + "<td>" + json.Totales[7] + "</td>");

        $('#divTablaJson').show();
        $('#Regresar').show();
        $('#Menu').show();
//        alert(json.generoEstudiantes33[0].sexo);

        filasGeneroCentroAsesoria(json);


    };

    filasGeneroCentroAsesoria = function(json) {
        var ht22 = 0;
        var mt22 = 0;
        var ht33 = 0;
        var mt33 = 0;

        for (var x = 0; x < json.generoEstudiantes33.length; x++) {
            var etapa = json.generoEstudiantes33[x].etapa + "";
            var id = parseInt(etapa.substring(4, 6));

            if (json.generoEstudiantes33[x].sexo === 'M') {
                ht33 += parseInt(json.generoEstudiantes33[x].total);
                $('#h33-' + id).text(json.generoEstudiantes33[x].total);
            } else if (json.generoEstudiantes33[x].sexo === 'F') {
                mt33 += parseInt(json.generoEstudiantes33[x].total);
                $('#m33-' + id).text(json.generoEstudiantes33[x].total);
            }
        }

        $('#h33T').text(ht33);
        $('#m33T').text(mt33);

        for (var x = 0; x < json.generoEstudiantes22.length; x++) {
            var etapa = json.generoEstudiantes22[x].etapa + "";
            var id = parseInt(etapa.substring(4, 6));

            if (json.generoEstudiantes22[x].sexo === 'M') {
                ht22 += parseInt(json.generoEstudiantes22[x].total);
                $('#h22-' + id).text(json.generoEstudiantes22[x].total);
            } else if (json.generoEstudiantes22[x].sexo === 'F') {
                mt22 += parseInt(json.generoEstudiantes22[x].total);
                $('#m22-' + id).text(json.generoEstudiantes22[x].total);
            }
        }

        $('#h22T').text(ht22);
        $('#m22T').text(mt22);


    };

//    $('#recargaPagina').click(function() {
//        // Recargo la página
//        location.reload();
//    });

//------------------AjaxParaCrearArchivosJson------------------//

    ArchivoJson = function(tipo, contex) {
        $('#mensage').hide();
        $('#divTablaJson').hide();
        $('#Menu').hide();
        $('#Regresar').hide();

        $('#boxLoad').fadeIn("slow");
        $('#mesLoad').fadeIn("slow");
        $('#mesLoad').fadeOut(5000);

        url = contex + "/ServletArchivoJsonCentrosDeAsesorias";
        $.ajax(
                {
                    type: "GET",
                    url: url,
                    data: 'tipo=' + tipo,
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

    successJson = function(respuesta) {
        //location.reload();
        //alert(respuesta.mensage);
        location.reload();
    };

    completeJson = function() {
//        alert("Completo");
    };


});