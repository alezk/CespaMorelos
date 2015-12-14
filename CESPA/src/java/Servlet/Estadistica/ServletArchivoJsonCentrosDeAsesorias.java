/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Estadistica;

import Gestor.Estadistica.GestorCentrosDeAsesoria;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
public class ServletArchivoJsonCentrosDeAsesorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensage;
        try {
            GestorCentrosDeAsesoria g = new GestorCentrosDeAsesoria();
            String ruta;
            if (request.getParameter("tipo").equals("S")) {
                ruta = request.getServletContext().getRealPath("/Json/JsonCentroAsesoriaSocial.json");
            } else {
                ruta = request.getServletContext().getRealPath("/Json/JsonCentroAsesoriaParticular.json");
            }            

            FileWriter fichero = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fichero);

            pw.write(respuestaJSON(g.CentrosDeAsesoria(request.getParameter("tipo"), 201501, 201512)));
            pw.flush();
            fichero.flush();
            pw.close();
            fichero.close();

            mensage = "{\"mensage\":\"T\"}";
        } catch (Exception e) {
            System.out.println("e " + e);
            mensage = "{\"mensage\":\"F\"}";
        };
        response.setContentType("application/json");
        response.getWriter().write(mensage);

    }

    public String respuestaJSON(Map consultaSolicitudesSemana) {
        Gson gson = new Gson();
        //System.out.println(" < "+consultaSolicitudesSemana.size());
        gson.toJson(consultaSolicitudesSemana);

        return gson.toJson(consultaSolicitudesSemana);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
