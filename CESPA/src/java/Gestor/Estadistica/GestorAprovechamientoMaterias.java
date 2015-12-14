/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestor.Estadistica;

import Bean.Estadistica.BeanMaterias;
import Dao.Estadistica.DaoAprovechamientoMaterias;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Alejandro
 */
public class GestorAprovechamientoMaterias {

    DaoAprovechamientoMaterias dam = new DaoAprovechamientoMaterias();

    public List<BeanMaterias> aprovechamientoMaterias(int etapa, String plan) {
        int ac = 1;
        int materia = 0;
        List<BeanMaterias> materiasPresentadas = new ArrayList(dam.MateriasPresentadas(etapa, "", plan));
        List<BeanMaterias> materiasAcreditadas = new ArrayList(dam.MateriasAcreditadas(etapa, "", plan));
        System.out.println(" " + materiasPresentadas.size() + " " + materiasAcreditadas.size());
        List<BeanMaterias> MateriasAprovechamiento = new ArrayList(); //Lsita que contendra los datos finales


        for (BeanMaterias b : materiasPresentadas) {

            for (BeanMaterias bm : materiasAcreditadas) {

                if (b.getClaveMateria() == bm.getClaveMateria()) {

                    BeanMaterias m = new BeanMaterias();
                    m.setMaterias(b.getMaterias());
                    m.setAcreditadas(bm.getAcreditadas());
                    m.setClaveMateria(bm.getClaveMateria());
                    m.setPresentadas(b.getPresentadas());
                    m.setPromedio((100 / b.getPresentadas()) * m.getAcreditadas());
                    MateriasAprovechamiento.add(m);
                    ac = 0;
                    break;

                } else {
                    ac++;
                }
            }

            if (ac >= materiasAcreditadas.size()) {

                BeanMaterias m = new BeanMaterias();
                m.setMaterias(b.getMaterias());
                m.setAcreditadas(0);
                m.setClaveMateria(b.getClaveMateria());
                m.setPresentadas(b.getPresentadas());
                m.setPromedio(0.0);
                MateriasAprovechamiento.add(m);

//                System.out.println("Estos son los elementos que no estan ≤≤ " + b.getMaterias());

            }

        }
//        System.out.println("<<<" + MateriasAprovechamiento.size());
        /*        
         for (int x = 0; x < materiasPresentadas.size(); x++) {

         BeanMaterias bm = new BeanMaterias();

         if (x < materiasAcreditadas.size()) {
         materia = materiasAcreditadas.get(x).getClaveMateria();
         } else {
         materia = materiasPresentadas.get(x).getClaveMateria();
         }

         if (materiasPresentadas.get(x).getClaveMateria() == materia) { //Valida el orden de las listas

         bm.setClaveMateria(materiasPresentadas.get(x).getClaveMateria());
         bm.setMaterias(materiasPresentadas.get(x).getMaterias());
         bm.setPresentadas(materiasPresentadas.get(x).getPresentadas());

         if (x < materiasAcreditadas.size()) { //Validad en caso de que la lista de presentadas sea mayor a acreditadas
         bm.setAcreditadas(materiasAcreditadas.get(x).getAcreditadas());
         ac = materiasAcreditadas.get(x).getAcreditadas();
         } else {
         bm.setAcreditadas(0);
         ac = 0;
         }

         bm.setPromedio((100 / materiasPresentadas.get(x).getPresentadas()) * ac);

         }
         MateriasAprovechamiento.add(bm);
         } */
        
        
        return MateriasAprovechamiento;
    }

}
