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


@WebServlet("/EditarController")
public class EditarController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        
        DAO dao = new MysqlDaoImpl();

        try {
            Articulo producto = dao.getById(Long.parseLong(id));

            req.setAttribute("producto",producto);
            
            
        } catch (Exception e) {
            req.setAttribute("error", "No se ha editado el articulo");
            getServletContext().getRequestDispatcher("/ListadoArticuloController").forward(req, resp);    

        }

        getServletContext().getRequestDispatcher("/edicion.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String titulo = req.getParameter(("titulo"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        String imagen = req.getParameter(("imagen"));
        String codigo = req.getParameter(("codigo"));
        String autor = req.getParameter(("autor"));
        
        Articulo nuevo = new Articulo(0, titulo, precio, imagen, autor, codigo);
        
        //Interface nombre  = new ClaseQueImplementaLaIntarface();
        DAO dao = new MysqlDaoImpl();
        
        //puedo usar lo metodos que tiene DAO, sin saber quien cumple el contrato
        try {
            dao.update(nuevo);
            resp.sendRedirect(req.getContextPath() + "/ListadoArticuloController");
        } catch (Exception e) {
            //redirect
            getServletContext().getRequestDispatcher("/edicion.jsp").forward(req, resp);
            e.printStackTrace();
        } 
    }
    
}