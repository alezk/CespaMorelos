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
public class DaoCentrosDeAsesoria {
   
     public static String AsesoriaEstudiantes33 = "select ca.clave_etapa, count(distinct se.matricula) from solicitud_examenes se,  calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "group by ca.clave_etapa";

    public static String AsesoriaEstudiantes22 = "select ca.clave_etapa, count(distinct se.matricula) from n_solicitud_examenes se,  n_calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "group by ca.clave_etapa";

    public static String AsesoriaSolicitados22 = "select ca.clave_etapa, count(se.matricula) from n_solicitud_examenes se,  n_calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "group by ca.clave_etapa";
    public static String AsesoriaSolicitados33 = "select ca.clave_etapa, count(se.matricula) from solicitud_examenes se,  calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "group by ca.clave_etapa";

    public static String AsesoriaPresentados22 = "select ca.clave_etapa, count(*) "
            + "from nuples_calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=?  "
            + "and cas.clave_asesoria=ca.clave_sede  "
            + "group by ca.clave_etapa";
    public static String AsesoriaPresentados33 = "select ca.clave_etapa, count(*) "
            + "from calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=?  "
            + "and cas.clave_asesoria=ca.clave_sede  "
            + "group by ca.clave_etapa ";

    public static String AsesoriaAcreditados22 = "select ca.clave_etapa, count(*) "
            + "from nuples_calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ?  "
            + "and cas.tipoasesoria=? "
            + "and cas.clave_asesoria=ca.clave_sede and ca.calificacion >5  "
            + "group by ca.clave_etapa";
    public static String AsesoriaAcreditados33 = "select ca.clave_etapa, count(*) "
            + "from calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ?  "
            + "and cas.tipoasesoria=? "
            + "and cas.clave_asesoria=ca.clave_sede and ca.calificacion >5  "
            + "group by ca.clave_etapa";

    public static String generoEstudiantes33 = "select ca.clave_etapa, es.sexo,count(distinct se.matricula) from solicitud_examenes se, estudiantes es,  calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and es.matricula=se.matricula "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "group by ca.clave_etapa,es.sexo order by es.sexo, ca.clave_etapa ";

    public static String generoEstudiantes22 = "select ca.clave_etapa, es.sexo,count(distinct se.matricula) from n_solicitud_examenes se, estudiantes es,  n_calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and es.matricula=se.matricula "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "group by ca.clave_etapa,es.sexo order by es.sexo, ca.clave_etapa ";

    public List<BeanCentrosDeAsesoriaGenero> GeneroEstudiantes33(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoriaGenero> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(generoEstudiantes33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoriaGenero> GeneroEstudiantes22(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoriaGenero> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(generoEstudiantes22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaEstudiantes33(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaEstudiantes33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaEstudiantes22(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaEstudiantes22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaSolicitados22(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaSolicitados22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaSolicitados33(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaSolicitados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaPresentados22(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaPresentados22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaPresentados33(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaPresentados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaAcreditados22(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaAcreditados22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaAcreditados33(String tipo, int e1, int e2) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaAcreditados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);

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
