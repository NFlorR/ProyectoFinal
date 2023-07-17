package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import ar.com.codoacodo.dao.AdministradorDeConexiones;
import ar.com.codoacodo.dao.DAO;
import ar.com.codoacodo23049.Articulo;

public class MysqlDaoImpl implements DAO {

    public void create(Articulo articulo) throws Exception {
       Connection connection = AdministradorDeConexiones.getConnection();

        String sql = "INSERT INTO articulo (titulo, precio, autor, imagen, fechaCreacion, codigo) VALUES (?, ?, ?, ?, ?, ?)";
    
    
    PreparedStatement pst = connection.prepareStatement(sql);

    pst.setString(1, articulo.getTitulo());
    pst.setDouble(2,articulo.getPrecio());
    pst.setString(3,articulo.getAutor());
    pst.setString(4, articulo.getImagen());
    pst.setDate(5, dateFrom(articulo.getFechaCreacion()));
    pst.setString(6, articulo.getCodigo());

    pst.executeUpdate();
    }

    @Override
    public Articulo getById(Long id) throws Exception {
        
        String sql = "select * from articulo where id =?";

        Connection connection = AdministradorDeConexiones.getConnection();

        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setLong(1, id);

        Articulo articulo = null;

        ResultSet res = pst.executeQuery();

        if(res.next()) {
            Long _id = res.getLong(1);
            String titulo = res.getString(2);
            double precio = res.getDouble(3);
            String imagen = res.getString(4);
            Date fechaCreacion = res.getDate(5);
            String autor = res.getString(6);
            String codigo = res.getString(7);

            articulo = new Articulo(_id, titulo, precio, imagen, autor, fechaCreacion.toLocalDate(), codigo);

        }

        return articulo; //??????????
        
    }






    @Override
    public void delete(Long id) throws Exception {
        String sql = "delete from articulo where id = ?";

        Connection connection = AdministradorDeConexiones.getConnection();

        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setLong(1, id);

        pst.executeUpdate();
    
    }







    @Override
    public ArrayList<Articulo> findAll() throws Exception {
        Connection connection = AdministradorDeConexiones.getConnection();
        String sql = "select * from articulo";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet res = pst.executeQuery();

        ArrayList<Articulo> listado = new ArrayList<>();
        while(res.next()) {
            Long id = res.getLong(1);
            String titulo = res.getString(2);
            double precio = res.getDouble(3);
            String imagen = res.getString(4);
            String autor = res.getString(5);
            Date fechaCreacion = res.getDate(6);
            String codigo = res.getString(7);
            

            listado.add(new Articulo(id, titulo, precio, imagen, autor,fechaCreacion.toLocalDate(), codigo));

        }

        return listado; //??????????
        
    }

    private Date dateFrom(LocalDate ldt) {
        java.util.Date date = Date.from(ldt.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new java.sql.Date(date.getTime());
    }
    







    @Override
    public void update(Articulo articulo) throws Exception {
        String sql = "UPDATE * from articulo SET titulo=? , precio=? , imagen=? , autor =? WHERE id= ?";
        
        Connection connection = AdministradorDeConexiones.getConnection();
        
        PreparedStatement pst = connection.prepareStatement(sql); {
        
            pst.setString(1, articulo.getTitulo());
            pst.setDouble(2, articulo.getPrecio());
            pst.setString(3, articulo.getAutor());
            pst.setLong(4, articulo.getId());

            pst.executeUpdate();
        }
}

    @Override
    public ArrayList<Articulo> findAllByTitle(String clave) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'findAllByTitle'");
    }

}
