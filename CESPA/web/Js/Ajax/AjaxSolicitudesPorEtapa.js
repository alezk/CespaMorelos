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
//    $.ajax(
//            {
//                type: "post",
//                url: "http://localhost:8084/CESPA/ServletSolicitudesPorSemanaJSON",
//                dataType: "json",
//                contentType: 'application/json',
//                mimeType: 'application/json',
//                error: errorAjax,
//                success: respuestaJson,
//                complete: cargadoGrafica
//            });



    solicitudesSemanales = function(contex) {
        url = contex + "/ServletSolicitudesPorEtapaJSON";
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
        alert('Error en la carga');
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
                text: 'Solicitudes de Examen'
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
                    text: 'Solicitudes de Exámen'
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
        options.series = [jSon[0], jSon[1], jSon[2]];
        $('#container').highcharts(options);

    };

    tablaSemanalJson = function(jSon) {

        $('#tablaJson').remove();

        var tablita = '<table id="tablaJson"><tr><th><strong>#</strong></th><th><strong> Plan / 33 </strong></th><th><strong>Plan / 22</strong></th><th><strong> Total </strong></th></tr><tbody id="idTablaJSON"></tbody></table>';

        $('#divTablaJson').append(tablita);

        for (var i = 0; i < jSon[0].data.length; i++) {
            
            if (jSon[1].data[i] === undefined) {
                p33 = 0;
            } else {
                p33 = jSon[1].data[i];
            }

            $('#idTablaJSON').append("<tr><td>" + categorias[i] + "</td><td>" + p33 + "</td><td>" + jSon[0].data[i] + "</td><td>" + jSon[2].data[i] + "</td></tr>");

        }


        $('#divTablaJson').show();
        $('#Regresar').show();
        $('#Menu').show();

    };

    $('#recargaPagina').click(function() {
        // Recargo la página
        location.reload();
    });


});