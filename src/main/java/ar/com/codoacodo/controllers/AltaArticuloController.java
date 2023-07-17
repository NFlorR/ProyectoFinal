package ar.com.codoacodo.controllers;

import java.io.IOException;

import ar.com.codoacodo.dao.DAO;
import ar.com.codoacodo.dao.impl.MysqlDaoImpl;
import ar.com.codoacodo23049.Articulo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AltaArticuloController")
public class AltaArticuloController extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String titulo = req.getParameter(("titulo"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        String imagen = req.getParameter(("imagen"));
        String autor = req.getParameter(("autor"));
        String codigo = req.getParameter(("codigo"));


        Articulo nuevoArticulo = new Articulo(titulo, precio, imagen, autor, codigo);

        DAO dao = new MysqlDaoImpl();


        try {
            dao.create(nuevoArticulo);
            getServletContext().getRequestDispatcher("/ListadoArticuloController").forward(req, resp);
            
        } catch (Exception e) {
            e.printStackTrace();  
            getServletContext().getRequestDispatcher("/nuevo.jsp").forward(req, resp);    
        }
        
    }
    
}
