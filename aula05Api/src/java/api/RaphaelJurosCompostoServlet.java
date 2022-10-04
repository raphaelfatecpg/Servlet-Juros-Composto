/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.math.BigInteger;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "RaphaelJurosCompostoServlet", urlPatterns = {"/raphael-juros-composto.json"})
public class RaphaelJurosCompostoServlet extends HttpServlet {
 private static ArrayList<Float> list = new ArrayList<Float>();

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
        if(request.getRequestURI().endsWith("/aula05Api/raphael-juros-composto.json")){
            processJsonRequest(request,response);
    }else{
        response.setStatus(404);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println("URL inválida");
    }
  }

    protected void processJsonRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        response.setContentType("application/json;charset=UTF-8");
                   int capital = Integer.parseInt(request.getParameter("C"));
                   int taxa = Integer.parseInt(request.getParameter("i"));
                   int tempo = Integer.parseInt(request.getParameter("t"));
                   double xx = Math.pow((1+(taxa/100)), tempo);
                   double JC = capital*xx ;
                        
                  
        JSONObject file = new JSONObject();
      
        
        file.put("Resultado", JC);
        
        JSONArray arr = new JSONArray();
        for(Float item: list){
            arr.put(item);
        }
       
        response.getWriter().println(file.toString());
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
