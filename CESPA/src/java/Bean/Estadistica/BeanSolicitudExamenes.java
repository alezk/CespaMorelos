/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean.Estadistica;

import java.util.List;

/**
 *
 * @author Alejandro
 */
public class BeanSolicitudExamenes {
    private int noSemana;
    private int noSolicitudes;
    private String name;
    private List data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getNoSemana() {
        return noSemana;
    }

    public void setNoSemana(int noSemana) {
        this.noSemana = noSemana;
    }

    public int getNoSolicitudes() {
        return noSolicitudes;
    }

    public void setNoSolicitudes(int noSolicitudes) {
        this.noSolicitudes = noSolicitudes;
    }
}
