/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestor.Estadistica;

import Bean.Estadistica.BeanSolicitudExamenes;
import Bean.Estadistica.BeanSolicitudesDeServicios;
import Bean.Estadistica.BeanSolicitudesEtapaExamenes;
import Bean.Estadistica.BeanSolicitudesExamenJson;
import Dao.Estadistica.DaoSolicitudesExamen;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class GestorSolicitudesDeExamen {

    DaoSolicitudesExamen dse = new DaoSolicitudesExamen();

    public List ListaTotalSolicitudesExamen() {
        List<BeanSolicitudExamenes> listaPlan22porSemana, listaPlan33porSemana;
        List<BeanSolicitudExamenes> listaTotalPlanes = new ArrayList();

        listaPlan22porSemana = dse.ConsultaSolicitudesSemanales22();
        listaPlan33porSemana = dse.ConsultaSolicitudesSemanales33();

        for (int x = 0; x < listaPlan22porSemana.size(); x++) {

            int p33 = 0;
            if (x < listaPlan33porSemana.size()) {
                p33 = listaPlan33porSemana.get(x).getNoSolicitudes();
            }            
            
            BeanSolicitudExamenes b = new BeanSolicitudExamenes();         
            b.setNoSemana(listaPlan22porSemana.get(x).getNoSemana());
            b.setNoSolicitudes(listaPlan22porSemana.get(x).getNoSolicitudes() + p33);
            listaTotalPlanes.add(b);
        }

        List listaJson = new ArrayList();

        BeanSolicitudesExamenJson b1 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b2 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b3 = new BeanSolicitudesExamenJson();

        b1.setName("Plan/22");
        b1.setData(listaParaJsonSemanal(listaPlan22porSemana));
        b2.setName("Plan/33");
        b2.setData(listaParaJsonSemanal(listaPlan33porSemana));
        b3.setName("Total");
        b3.setData(listaParaJsonSemanal(listaTotalPlanes));

        listaJson.add(b1);
        listaJson.add(b2);
        listaJson.add(b3);

        return listaJson;
    }

    public int[] listaParaJsonSemanal(List<BeanSolicitudExamenes> b) {

        int[] a = new int[b.size()];
        int x = 0;

        for (BeanSolicitudExamenes s : b) {
            a[x] = s.getNoSolicitudes();
            x++;
        }
        //Se agrega toda la cadena a una lista para formar el "Data"     
        return a;
    }

    public List ListaTotalSolicitudesExamenEtapa() {
        List<BeanSolicitudesEtapaExamenes> listaPlan22porEtap, listaPlan33porEtapa;
        List<BeanSolicitudesEtapaExamenes> listaTotalPlanes = new ArrayList();

        listaPlan22porEtap = dse.ConsultaSolicitudesEtapa22();
        listaPlan33porEtapa = dse.ConsultaSolicitudesEtapa33();

        for (int x = 0; x < listaPlan22porEtap.size(); x++) {
            BeanSolicitudesEtapaExamenes b = new BeanSolicitudesEtapaExamenes();
            b.setNoEtapa(listaPlan22porEtap.get(x).getNoEtapa());

            int p33 = 0;
            if (x < listaPlan33porEtapa.size()) {
                p33 = listaPlan33porEtapa.get(x).getNoSolicitudes();
            }

            b.setNoSolicitudes(listaPlan22porEtap.get(x).getNoSolicitudes() + p33);

            listaTotalPlanes.add(b);
        }

        List listaJson = new ArrayList();

        BeanSolicitudesExamenJson b1 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b2 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b3 = new BeanSolicitudesExamenJson();

        b1.setName("Plan/22");
        b1.setData(listaParaJsonEtapa(listaPlan22porEtap));
        b2.setName("Plan/33");
        b2.setData(listaParaJsonEtapa(listaPlan33porEtapa));
        b3.setName("Total");
        b3.setData(listaParaJsonEtapa(listaTotalPlanes));

        listaJson.add(b1);
        listaJson.add(b2);
        listaJson.add(b3);

        return listaJson;
    }

    public int[] listaParaJsonEtapa(List<BeanSolicitudesEtapaExamenes> b) {

        int[] a = new int[b.size()];
        int x = 0;

        for (BeanSolicitudesEtapaExamenes s : b) {
            a[x] = s.getNoSolicitudes();
            x++;
        }
        //Se agrega toda la cadena a una lista para formar el "Data"     
        return a;
    }

    public List ListaTotalSolicitudesServicios() {
        List<BeanSolicitudesDeServicios> listaCredenciales, listaInscripciones, listaConstancias, listaCertificados;
        List<BeanSolicitudesDeServicios> listaTotalServicios = new ArrayList();

        listaCredenciales = dse.ConsultaCredenciales();
        listaInscripciones = dse.ConsultaInscripciones();
        listaConstancias = dse.ConsultaConstancias();
        listaCertificados = dse.ConsultaCertificados();

//        System.out.println("<<" + listaCredenciales.size() + " " + listaInscripciones.size() + " " + listaConstancias.size());
        int tc = 0, tcons = 0, tcred = 0;

        for (int x = 0; x < listaInscripciones.size(); x++) {
            BeanSolicitudesDeServicios b = new BeanSolicitudesDeServicios();

            if (x < listaCertificados.size()) {
                tc = listaCertificados.get(x).getNoSolicitudes() * 46;
            } else {
                tc = 0;
            }

            if (x < listaCredenciales.size()) {
                tcred = listaCredenciales.get(x).getNoSolicitudes() * 36;
            } else {
                tcred = 0;
            }

            if (x < listaConstancias.size()) {
                tcons = listaConstancias.get(x).getNoSolicitudes() * 25;
            } else {
                tcons = 0;
            }

            b.setNoMes(listaInscripciones.get(x).getNoMes());
            b.setNoSolicitudes((listaInscripciones.get(x).getNoSolicitudes() * 100) + tcred + tcons + tc);

            listaTotalServicios.add(b);
        }

        List listaJson = new ArrayList();

        BeanSolicitudesExamenJson b1 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b2 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b3 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b4 = new BeanSolicitudesExamenJson();
        BeanSolicitudesExamenJson b5 = new BeanSolicitudesExamenJson();

        b1.setName("Iscripciones");
        b1.setData(listaParaJsonServicios(listaInscripciones));
        b2.setName("Credenciales");
        b2.setData(listaParaJsonServicios(listaCredenciales));
        b3.setName("Constancias");
        b3.setData(listaParaJsonServicios(listaConstancias));
        b4.setName("Certificados");
        b4.setData(listaParaJsonServicios(listaCertificados));
        b5.setName("Total");
        b5.setData(listaParaJsonServicios(listaTotalServicios));

        listaJson.add(b1);
        listaJson.add(b2);
        listaJson.add(b3);
        listaJson.add(b4);
        listaJson.add(b5);

        return listaJson;
    }

    public int[] listaParaJsonServicios(List<BeanSolicitudesDeServicios> b) {

        int[] a = new int[b.size()];
        int x = 0;

        for (BeanSolicitudesDeServicios s : b) {
            a[x] = s.getNoSolicitudes();
            x++;
        }
        //Se agrega toda la cadena a una lista para formar el "Data"     
        return a;
    }

    public static void main(String[] args) {
        GestorSolicitudesDeExamen g = new GestorSolicitudesDeExamen();
        g.ListaTotalSolicitudesExamen();
    }

}
