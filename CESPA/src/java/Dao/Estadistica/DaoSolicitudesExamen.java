/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Estadistica;

import Bean.Estadistica.BeanSolicitudExamenes;
import Bean.Estadistica.BeanSolicitudesDeServicios;
import Bean.Estadistica.BeanSolicitudesEtapaExamenes;
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
public class DaoSolicitudesExamen {

    public static String SqlSolicitudesSemanales33 = "SELECT datepart(wk,se.fecha_solicitud) as Semana, count(*) as NoSolicitudes "
            + "FROM "
      
            + "solicitud_examenes se "

            + "where se.fecha_solicitud BETWEEN '2016-01-01%' and '2016-02-29%' and  not datepart(wk,se.fecha_solicitud) =2 and  not datepart(wk,se.fecha_solicitud) =47 and  not datepart(wk,se.fecha_solicitud) =40 "
            
            + "group by datepart(wk,se.fecha_solicitud) order by Semana;";

    public static String SqlSolicitudesSemanales22 = "SELECT datepart(wk,se.fecha_solicitud) as Semana, count(*) as NoSolicitudes "
            + "FROM "
           
            + "n_solicitud_examenes se "
    
            + "where se.fecha_solicitud BETWEEN '2016-01-01%' and '2016-02-29%'"
          
            + "group by datepart(wk,se.fecha_solicitud) order by Semana;";
    
/*
    public static String SqlSolicitudesEtapas33 = "SELECT  ca.clave_etapa, count(se.matricula) as NoSolicitudes "
            + "FROM "
            + "calendario ca, "
            + "solicitud_examenes se "
          
            + "where ca.clave_etapa BETWEEN '201501' and '201512' and  "
            + "se.clave_calendario=ca.clave_calendario "
            + "group by ca.clave_etapa order by ca.clave_etapa; ";
            

    public static String SqlSolicitudesEtapas22 = "SELECT  ca.clave_etapa, count(se.matricula) as NoSolicitudes "
            + "FROM  "
            + "n_calendario ca, "
            + "n_solicitud_examenes se "
            
            + "where ca.clave_etapa BETWEEN '201501' and '201512' and  "
            + "se.clave_calendario=ca.clave_calendario "
            + "group by ca.clave_etapa order by ca.clave_etapa;";
*/
     public static String SqlSolicitudesEtapas33 ="select MONTH(fecha_solicitud), COUNT(*) from solicitud_examenes where fecha_solicitud BETWEEN '2016-01-01%' and '2016-02-29%' and YEAR(fecha_solicitud)=2016 GROUP BY MONTH(fecha_solicitud);";
     public static String SqlSolicitudesEtapas22 ="select MONTH(fecha_solicitud), COUNT(*) from n_solicitud_examenes where fecha_solicitud BETWEEN '2016-01-01%' and '2016-02-29%'  and YEAR(fecha_solicitud)=2016 GROUP BY MONTH(fecha_solicitud);";

    public static String SqlCredenciales = "select datepart(mm,fecha_sol), count(matricula) as Credencial from siosaddba.M_Credencial where fecha_sol BETWEEN '2016-01-01%' and '2016-02-29%'  group by datepart(mm,fecha_sol);";
    public static String SqlInscripciones = "select datepart(mm,fecha_alta), count(matricula) as Inscripciones from estudiantes where fecha_alta BETWEEN '2016-01-01%' and '2016-02-29%' group by datepart(mm,fecha_alta);";
    public static String SqlConstancias = "select datepart(mm,fecha_sol), count(matricula) as Constancias from siosaddba.M_Constancia where fecha_sol BETWEEN '2016-01-01%' and '2016-02-29%'  group by datepart(mm,fecha_sol);";
    public static String SqlCertificados = "select datepart(mm,fecha_certificacion), count(matricula) as Certificados from Certificados_Expedidos where fecha_certificacion BETWEEN '2016-01-01%' and '2016-02-29%'  and tipo_certificado='p' group by datepart(mm,fecha_certificacion);";

    public List<BeanSolicitudExamenes> ConsultaSolicitudesSemanales33() {
        List<BeanSolicitudExamenes> listaClasificacion = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlSolicitudesSemanales33);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudExamenes p = new BeanSolicitudExamenes();
                p.setNoSemana(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
                listaClasificacion.add(p);
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return listaClasificacion;
    }

    public List<BeanSolicitudExamenes> ConsultaSolicitudesSemanales22() {
        List<BeanSolicitudExamenes> listaClasificacion = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlSolicitudesSemanales22);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudExamenes p = new BeanSolicitudExamenes();
                p.setNoSemana(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
                listaClasificacion.add(p);
            }
            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return listaClasificacion;
    }

    public List<BeanSolicitudesEtapaExamenes> ConsultaSolicitudesEtapa33() {
        List<BeanSolicitudesEtapaExamenes> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlSolicitudesEtapas33);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudesEtapaExamenes p = new BeanSolicitudesEtapaExamenes();
                p.setNoEtapa(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
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

    public List<BeanSolicitudesEtapaExamenes> ConsultaSolicitudesEtapa22() {
        List<BeanSolicitudesEtapaExamenes> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlSolicitudesEtapas22);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudesEtapaExamenes p = new BeanSolicitudesEtapaExamenes();
                p.setNoEtapa(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
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

    public List<BeanSolicitudesDeServicios> ConsultaCredenciales() {
        List<BeanSolicitudesDeServicios> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlCredenciales);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudesDeServicios p = new BeanSolicitudesDeServicios();
                p.setNoMes(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
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

    public List<BeanSolicitudesDeServicios> ConsultaInscripciones() {
        List<BeanSolicitudesDeServicios> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlInscripciones);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudesDeServicios p = new BeanSolicitudesDeServicios();
                p.setNoMes(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
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

    public List<BeanSolicitudesDeServicios> ConsultaConstancias() {
        List<BeanSolicitudesDeServicios> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlConstancias);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudesDeServicios p = new BeanSolicitudesDeServicios();
                p.setNoMes(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
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

    public List<BeanSolicitudesDeServicios> ConsultaCertificados() {
        List<BeanSolicitudesDeServicios> lista = new ArrayList();
        try {
            Connection connect = ConexionSybase.getConnection();
            PreparedStatement ps = connect.prepareStatement(SqlCertificados);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanSolicitudesDeServicios p = new BeanSolicitudesDeServicios();
                p.setNoMes(rs.getInt(1));
                p.setNoSolicitudes(rs.getInt(2));
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
