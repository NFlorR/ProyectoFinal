package ar.com.codoacodo.controllers;

import java.io.IOException;


import ar.com.codoacodo.dao.DAO;
import ar.com.codoacodo.dao.impl.MysqlDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String id = req.getParameter("id");

        DAO dao = new MysqlDaoImpl();

    
        try {
            dao.delete(Long.parseLong(id));

            req.setAttribute("eliminadook", "Se ha eliminado el producto id:" + id);

            getServletContext().getRequestDispatcher("/ListadoArticuloController").forward(req, resp);

        } catch (Exception e) {
    
            e.printStackTrace();

            req.setAttribute("eliminadofail", "Error en eliminar el producto id:" + id);

            getServletContext().getRequestDispatcher("/ListadoArticuloController").forward(req, resp);
        
        }

    
    }

    
}