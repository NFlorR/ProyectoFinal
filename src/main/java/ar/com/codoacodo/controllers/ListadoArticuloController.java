package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import ar.com.codoacodo.dao.DAO;
import ar.com.codoacodo.dao.impl.MysqlDaoImpl;
import ar.com.codoacodo23049.Articulo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListadoArticuloController")
public class ListadoArticuloController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DAO dao = new MysqlDaoImpl();

        try {
            ArrayList<Articulo> articulo = dao.findAll();

            req.setAttribute("listado", articulo);

            req.getRequestDispatcher("listado.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
          
            req.setAttribute("listado", new ArrayList<>());

            req.getRequestDispatcher("listado.jsp").forward(req, resp);
            
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp); 
    }

}
  