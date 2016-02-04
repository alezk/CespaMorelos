/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Estadistica;

import Bean.Estadistica.BeanMaterias;
import Utilerias.ConexionSybase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class DaoAprovechamientoMaterias {

    public static String SqlMateriasPresentadas = "select c.clave_materia, m.materia_dsc, count(*) from nuples_calificaciones c, nuples_modulos m where m.clave_materia=c.clave_materia and clave_etapa=? group by c.clave_materia,m.materia_dsc order by c.clave_materia";
    public static String SqlMateriasAcreditadas = "select c.clave_materia, m.materia_dsc, count(*) from nuples_calificaciones c, nuples_modulos m where m.clave_materia=c.clave_materia and clave_etapa=? and calificacion > 5 group by c.clave_materia,m.materia_dsc order by c.clave_materia ";

    public static String SqlMateriasPresentadas33 = "select c.clave_materia, m.materia_dsc, count(*) from calificaciones c, materias m where m.clave_materia=c.clave_materia and clave_etapa=?  group by c.clave_materia,m.materia_dsc order by c.clave_materia";
    public static String SqlMateriasAcreditadas33 = "select c.clave_materia, m.materia_dsc, count(*) from calificaciones c, materias m where m.clave_materia=c.clave_materia and clave_etapa=? and calificacion > 5 group by c.clave_materia,m.materia_dsc order by c.clave_materia";

    public static String SqlMateriasPresentadas33Ex = "select c.clave_materia, m.materia_dsc, count(*) from calificaciones c, materias m where m.clave_materia=c.clave_materia and clave_etapa=? and c.fase in('1','2','3','4','5') group by c.clave_materia,m.materia_dsc order by c.clave_materia";
    public static String SqlMateriasAcreditadas33Ex = "select c.clave_materia, m.materia_dsc, count(*) from calificaciones c, materias m where m.clave_materia=c.clave_materia and clave_etapa=? and c.fase in('1','2','3','4','5') and calificacion > 5 group by c.clave_materia,m.materia_dsc order by c.clave_materia";

    public List<BeanMaterias> MateriasAcreditadas(int etapa, String fase, String plan) {
        List<BeanMaterias> lista = new ArrayList();

        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps;

            if (plan.equals("p22")) {
                ps = connect.prepareStatement(SqlMateriasAcreditadas);
            } else if (plan.equals("p33")) {
                ps = connect.prepareStatement(SqlMateriasAcreditadas33);
            } else {
                ps = connect.prepareStatement(SqlMateriasAcreditadas33Ex);
            }

            ps.setInt(1, etapa);
//            ps.setString(2, fase);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BeanMaterias p = new BeanMaterias();
                p.setClaveMateria(rs.getInt(1));
                p.setMaterias(rs.getString(2));
                p.setAcreditadas(rs.getInt(3));
                lista.add(p);
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return lista;
    }

    public List<BeanMaterias> MateriasPresentadas(int etapa, String fase, String plan) {
        List<BeanMaterias> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps;

            if (plan.equals("p22")) {
                ps = connect.prepareStatement(SqlMateriasPresentadas);
            } else if (plan.equals("p33")) {
                ps = connect.prepareStatement(SqlMateriasPresentadas33);
            } else {
                ps = connect.prepareStatement(SqlMateriasPresentadas33Ex);
            }

            ps.setInt(1, etapa);
//            ps.setString(2, fase);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BeanMaterias p = new BeanMaterias();
                p.setClaveMateria(rs.getInt(1));
                p.setMaterias(rs.getString(2));
                p.setPresentadas(rs.getInt(3));
                lista.add(p);
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return lista;
    }
}
