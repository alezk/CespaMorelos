/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Estadistica;

/**
 *
 * @author Alejandro
 */
public class BeanMaterias {

    private String materias;
    private int claveMateria;
    private int calificacion;
    private int numero;
    private double promedio;
    private int presentadas;
    private int acreditadas; 

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getPresentadas() {
        return presentadas;
    }

    public void setPresentadas(int presentadas) {
        this.presentadas = presentadas;
    }

    public int getAcreditadas() {
        return acreditadas;
    }

    public void setAcreditadas(int acreditadas) {
        this.acreditadas = acreditadas;
    }
   
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    public int getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(int claveMateria) {
        this.claveMateria = claveMateria;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

   

}
