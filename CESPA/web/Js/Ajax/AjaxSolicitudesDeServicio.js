/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {

    var categorias = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
        'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre', '27 Jul',
        '03 Ago', '10 Ago', '17 Ago', '24 Ago', '31 Ago', '7 Sep', '14 Sep', '21 Sep', '28 Sep', '05 Oct','12 Oct','19 Oct','26 Oct','02 Nov','09 Nov','16 Nov','23 Nov','30 Nov'];


    $('#divTablaJson').hide();
    $('#Regresar').hide();
    $('#Menu').hide();

    $('#mesLoad').hide();
    $('#mensage').hide();

    solicitudesSemanales = function(contex) {
        url = contex + "/Json/JsonSolicitudesDeServicio.json";

        $.ajax(
                {
                    type: "post",
                    url: url,
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    error: errorAjax,
                    success: respuestaJson,
                    complete: cargadoGrafica
                });
    };

    errorAjax = function() {
         $('#Regresar').show();
        $('#Menu').show();
        $('#mensage').fadeIn(2000);
    };
    respuestaJson = function(respuesta) {
        generarGrafica(respuesta);
    };

    cargadoGrafica = function() {
        $('#boxLoad').hide();
    };

    generarGrafica = function(jSon) {
        tablaSemanalJson(jSon);



        var options = {
            title: {
                text: 'Solicitudes de Servicios'
//                x: -5 //center

            },
//            subtitle: {
//                text: 'Source: WorldClimate.com',
//                x: -20
//            },
            xAxis: {
                categories: categorias
            },
            yAxis: {
                title: {
                    text: 'Solicitudes de Servicios 2015'
                },
                min: 5,
                plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
            },
            tooltip: {
                //valueSuffix: 'Solicitudes'
            },
            legend: {
                layout: 'horizontal',
                align: 'center',
                verticalAlign: 'top',
                borderWidth: 0,
                floating: true,
                x: 2,
                y: 12
            }
//            series: 
//
//                    [{
//                            name: "Plan/33", data: [55, 173, 58, 140, 54, 126, 66, 125, 77, 72, 11]
//                        }, {
//                            name: 'New York',
//                            data: [0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
//                        }, {
//                            name: 'Berlin',
//                            data: [0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
//                        }, {
//                            name: 'London',
//                            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
//                        }]

        };
        //options.series = [{name: jSon[0].name, data:jSon[0].data}, {name: jSon[1].name, data: []}, {name: jSon[2].name, data: []}];
        options.series = [jSon[0], jSon[1], jSon[2], jSon[3]];
        $('#container').highcharts(options);

    };

    tablaSemanalJson = function(jSon) {

        $('#tablaJson').remove();

        var tablita = '<table id="tablaJson"><tr><th><strong>#</strong></th><th><strong> Iscripciones </strong></th><th><strong>Credenciales</strong></th><th><strong>Constancias</strong></th><th><strong>Certificados</strong></th><th><strong>Total</strong></th></tr><tbody id="idTablaJSON"></tbody></table>';

        $('#divTablaJson').append(tablita);

        for (var i = 0; i < jSon[0].data.length; i++) {

            if (jSon[3].data[i] === undefined) {
                cert = 0;
            } else {
                cert = jSon[3].data[i];
            }
            if (jSon[2].data[i] === undefined) {
                cons = 0;
            } else {
                cons = jSon[2].data[i];
            }
            if (jSon[1].data[i] === undefined) {
                cred = 0;
            } else {
                cred = jSon[1].data[i];
            }

            $('#idTablaJSON').append("<tr><td>&nbsp;" + categorias[i] + "&nbsp;</td><td>&nbsp;" + jSon[0].data[i] + "&nbsp;</td><td>&nbsp;" + cred + "&nbsp;</td><td>&nbsp;" + cons + "&nbsp;</td><td>&nbsp;" + cert + "&nbsp;</td><td>&nbsp;" + '$' + currency(jSon[4].data[i], 0, ',') + "&nbsp;</td></tr>");

        }


        $('#divTablaJson').show();
        $('#Regresar').show();
        $('#Menu').show();

    };

//    $('#recargaPagina').click(function() {
//        // Recargo la página
//        location.reload();
//    });

    function currency(value, decimals, separators) {
        decimals = decimals >= 0 ? parseInt(decimals, 0) : 2;
        separators = separators || ['.', "'", ','];
        var number = (parseFloat(value) || 0).toFixed(decimals);
        if (number.length <= (4 + decimals))
            return number.replace('.', separators[separators.length - 1]);
        var parts = number.split(/[-.]/);
        value = parts[parts.length > 1 ? parts.length - 2 : 0];
        var result = value.substr(value.length - 3, 3) + (parts.length > 1 ?
                separators[separators.length - 1] + parts[parts.length - 1] : '');
        var start = value.length - 6;
        var idx = 0;
        while (start > -3) {
            result = (start > 0 ? value.substr(start, 3) : value.substr(0, 3 + start))
                    + separators[idx] + result;
            idx = (++idx) % 2;
            start -= 3;
        }
        return (parts.length === 3 ? '-' : '') + result;
    }


    //------------------AjaxParaCrearArchivosJson------------------//

    ArchivoJson = function(contex) {
        $('#mensage').hide();
        $('#divTablaJson').hide();
        $('#Menu').hide();
        $('#Regresar').hide();
        $('#container').hide();

        $('#boxLoad').fadeIn("slow");
        $('#mesLoad').fadeIn("slow");
        $('#mesLoad').fadeOut(5000);

        url = contex + "/ServletArchivoJsonSolicitudesDeServicio";
        $.ajax(
                {
                    type: "GET",
                    url: url,
//                    data: 'tipo=' + tipo,
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