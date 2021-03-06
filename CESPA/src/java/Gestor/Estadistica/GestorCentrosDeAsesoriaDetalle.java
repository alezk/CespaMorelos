/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestor.Estadistica;

import Bean.Estadistica.BeanCentrosDeAsesoria;
import Dao.Estadistica.DaoCentrosDeAsesoriaDetalle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alejandro
 */
public class GestorCentrosDeAsesoriaDetalle {
    DaoCentrosDeAsesoriaDetalle ad = new DaoCentrosDeAsesoriaDetalle();

    public Map CentrosDeAsesoriaDetalle(String tipo, int e1, int e2,int centro) {

        Map<String, List> nombreMap = new HashMap();

        List<BeanCentrosDeAsesoria> listEstudiantes22, listEstudiantes33, listSolicitados22, listSolicitados33, listPresentados22, listPresentados33, listAcreditados22, listAcreditados33;
        List totales = new ArrayList();

        listEstudiantes22 = ad.CentroDeAsesoriaEstudiantes22(tipo, e1, e2,centro);
        listEstudiantes33 = ad.CentroDeAsesoriaEstudiantes33(tipo, e1, e2,centro);

        listSolicitados22 = ad.CentroDeAsesoriaSolicitados22(tipo, e1, e2,centro);
        listSolicitados33 = ad.CentroDeAsesoriaSolicitados33(tipo, e1, e2,centro);

        listPresentados22 = ad.CentroDeAsesoriaPresentados22(tipo, e1, e2,centro);
        listPresentados33 = ad.CentroDeAsesoriaPresentados33(tipo, e1, e2,centro);

        listAcreditados22 = ad.CentroDeAsesoriaAcreditados22(tipo, e1, e2,centro);
        listAcreditados33 = ad.CentroDeAsesoriaAcreditados33(tipo, e1, e2,centro);

        nombreMap.put("listEstudiantes22", listEstudiantes22);
        nombreMap.put("listEstudiantes33", listEstudiantes33);

        nombreMap.put("listSolicitados22", listSolicitados22);
        nombreMap.put("listSolicitados33", listSolicitados33);

        nombreMap.put("listPresentados22", listPresentados22);
        nombreMap.put("listPresentados33", listPresentados33);

        nombreMap.put("listAcreditados22", listAcreditados22);
        nombreMap.put("listAcreditados33", listAcreditados33);

        totales.add(sumaValores(listEstudiantes22));
        totales.add(sumaValores(listSolicitados22));
        totales.add(sumaValores(listPresentados22));
        totales.add(sumaValores(listAcreditados22));

        totales.add(sumaValores(listEstudiantes33));
        totales.add(sumaValores(listSolicitados33));
        totales.add(sumaValores(listPresentados33));
        totales.add(sumaValores(listAcreditados33));

        nombreMap.put("Totales", totales);

        return nombreMap;
    }

    public int sumaValores(List<BeanCentrosDeAsesoria> l) {
        int x = 0;
        for (BeanCentrosDeAsesoria a : l) {
            x += a.getTotal();
        }
        return x;
    }

}
