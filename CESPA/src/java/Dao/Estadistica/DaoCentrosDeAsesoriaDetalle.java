/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Estadistica;

import Bean.Estadistica.BeanCentrosDeAsesoria;
import Bean.Estadistica.BeanListaCentrosDeAsesoria;
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
public class DaoCentrosDeAsesoriaDetalle {

    public static String AsesoriaEstudiantes33 = "select ca.clave_etapa, count(distinct se.matricula) from  solicitud_examenes se,  calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? and cas.clave_asesoria=? "
            + "group by ca.clave_etapa order by ca.ca.clave_etapa";

    public static String AsesoriaEstudiantes22 = "select ca.clave_etapa, count(distinct se.matricula) from n_solicitud_examenes se, n_calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? and cas.clave_asesoria=? "
            + "group by ca.clave_etapa order by ca.ca.clave_etapa";

    public static String AsesoriaSolicitados22 = "select ca.clave_etapa, count(*) from n_solicitud_examenes se, n_calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? and cas.clave_asesoria=? "
            + "group by ca.clave_etapa order by ca.ca.clave_etapa ";

    public static String AsesoriaSolicitados33 = "select ca.clave_etapa, count(*) from solicitud_examenes se, calendario ca, centro_asesoria cas "
            + "where "
            + "se.clave_calendario=ca.clave_calendario "
            + "and cas.clave_asesoria=se.clave_sede "
            + "and ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? and cas.clave_asesoria=? "
            + "group by ca.clave_etapa order by ca.ca.clave_etapa ";

    public static String AsesoriaPresentados22 = "select ca.clave_etapa ,count(*)"
            + "from nuples_calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "and ca.clave_sede=cas.clave_asesoria "
            + "and ca.calificacion > 0 and cas.clave_asesoria=? "
            + "group by ca.clave_etapa ";
    public static String AsesoriaPresentados33 = "select ca.clave_etapa ,count(*) "
            + "from calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "and ca.clave_sede=cas.clave_asesoria "
            + "and ca.calificacion > 0 and cas.clave_asesoria=? "
            + "group by ca.clave_etapa";

    public static String AsesoriaAcreditados22 = "select ca.clave_etapa ,count(*)"
            + "from nuples_calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "and ca.clave_sede=cas.clave_asesoria "
            + "and ca.calificacion > 5 and cas.clave_asesoria=? "
            + "group by ca.clave_etapa ";

    public static String AsesoriaAcreditados33 = "select ca.clave_etapa ,count(*) "
            + "from calificaciones ca, centro_asesoria cas "
            + "where "
            + "ca.clave_etapa BETWEEN ? and ? "
            + "and cas.tipoasesoria=? "
            + "and ca.clave_sede=cas.clave_asesoria "
            + "and ca.calificacion > 5 and cas.clave_asesoria=? "
            + "group by ca.clave_etapa";

    public static String centrosDeAsesoria = "";

    public List<BeanListaCentrosDeAsesoria> CentroDeAsesoria(String tipo) {
        List<BeanListaCentrosDeAsesoria> lista = new ArrayList();

        if (tipo.equals("P")) {
            centrosDeAsesoria = "select cas.clave_asesoria,cas.asesoria_dsc from centro_asesoria cas where cas.clave_asesoria in(023,035,047,053,309,313,316,343,358,363,365,366,373,374,375,378,382,383,385) order by cas.clave_asesoria";
        } else {
            centrosDeAsesoria = "select cas.clave_asesoria,cas.asesoria_dsc from centro_asesoria cas where cas.clave_asesoria in(085,092,130,202,257,262,269,329,337,356,357,362,376,377,379,384) order by cas.clave_asesoria";

        }

        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(centrosDeAsesoria);
//            ps.setString(1, centros);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanListaCentrosDeAsesoria p = new BeanListaCentrosDeAsesoria();
                p.setIdCentro(rs.getInt(1));
                p.setCentroAsesoria(rs.getString(2));
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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaEstudiantes33(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaEstudiantes33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaEstudiantes22(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaEstudiantes22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaSolicitados22(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaSolicitados22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaSolicitados33(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaSolicitados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaPresentados22(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaPresentados22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaPresentados33(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaPresentados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaAcreditados22(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaAcreditados22);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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

    public List<BeanCentrosDeAsesoria> CentroDeAsesoriaAcreditados33(String tipo, int e1, int e2, int centro) {
        List<BeanCentrosDeAsesoria> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(AsesoriaAcreditados33);
            ps.setInt(1, e1);
            ps.setInt(2, e2);
            ps.setString(3, tipo);
            ps.setInt(4, centro);

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
