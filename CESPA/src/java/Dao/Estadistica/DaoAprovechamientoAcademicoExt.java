/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Estadistica;

import Bean.Estadistica.BeanCentrosDeAsesoria;
import Bean.Estadistica.BeanCentrosDeAsesoriaGenero;
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
public class DaoAprovechamientoAcademicoExt {

    public static String AsesoriaEstudiantes33 = "select ca.clave_etapa, count( distinct se.matricula) from  solicitud_examenes se, estudiantes es,   calendario ca "
            + "where "
            + "se.clave_calendario=ca.clave_calendario and ca.fase in ('1','2','3','4','5') "
            + "and ca.clave_etapa BETWEEN ? and ? and es.matricula=se.matricula "
            + "group by ca.clave_etapa";

    public static String AsesoriaSolicitados33 = "select ca.clave_etapa, count(se.matricula) from solicitud_examenes se,  calendario ca, "
            + "where "
            + "se.clave_calendario=ca.clave_calendario and ca.fase in ('1','2','3','4','5') "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "group by ca.clave_etapa";

    public static String AsesoriaPresentados33 = "select ca.clave_etapa, count(*) from calificaciones ca,where ca.clave_etapa BETWEEN ? and ? and ca.fase in ('1','2','3','4','5') "
            + "group by ca.clave_etapa";

    public static String AsesoriaAcreditados33 = "select ca.clave_etapa, count(*) from calificaciones ca,where ca.clave_etapa BETWEEN ? and ? and ca.fase in ('1','2','3','4','5') "
            + "and ca.calificacion >5  "
            + "group by ca.clave_etapa";

    public static String generoEstudiantes33 = "select ca.clave_etapa, es.sexo,count(distinct se.matricula) from  solicitud_examenes se, estudiantes es,   calendario ca "
            + "where "
            + "se.clave_calendario=ca.clave_calendario and ca.fase in ('1','2','3','4','5')"
            + "and es.matricula=se.matricula "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "group by ca.clave_etapa,es.sexo order by es.sexo, ca.clave_etapa ";

    public List<BeanCentrosDeAsesoriaGenero> GeneroEstudiantes33(int e1, int e2) {
        List<BeanCentrosDeAsesoriaGenero> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(generoEstudiantes33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanCentrosDeAsesoriaGenero p = new BeanCentrosDeAsesoriaGenero();
                p.setEtapa(rs.getInt(1));
                p.setSexo(rs.getString(2));
                p.setTotal(rs.getInt(3));
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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaEstudiantes33(int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaEstudiantes33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanCentrosDeAsesoria p = new BeanCentrosDeAsesoria();
                p.setEtapa(rs.getInt(1));
                p.setTotal(rs.getInt(2));
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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaSolicitados33(int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaSolicitados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanCentrosDeAsesoria p = new BeanCentrosDeAsesoria();
                p.setEtapa(rs.getInt(1));
                p.setTotal(rs.getInt(2));
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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaPresentados33(int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaPresentados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanCentrosDeAsesoria p = new BeanCentrosDeAsesoria();
                p.setEtapa(rs.getInt(1));
                p.setTotal(rs.getInt(2));
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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaAcreditados33(int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaAcreditados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanCentrosDeAsesoria p = new BeanCentrosDeAsesoria();
                p.setEtapa(rs.getInt(1));
                p.setTotal(rs.getInt(2));
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
