//agrupa clases
package ar.com.codoacodo23049;

import java.time.LocalDate;

//clase
public class Articulo {



    //atributos
    private long id;
    private String titulo;
    private double precio;
    private String imagen;
    private String autor;
    private LocalDate fechaCreacion;
    private String codigo;



    //constructores
    public Articulo(
        long id,
        String titulo, 
        double precio, 
        String imagen, 
        String autor, 
        LocalDate fechaCreacion,
        String codigo
        ) 
        {
            this.id = id;
        init(titulo, precio, imagen, autor, codigo);
    }


    

    //POLIMORFISMO
    /*public Articulo(String titulo, double precio, String imagen, String autor, LocalDate fechaCreacion, String codigo) {
        init(titulo, precio, imagen, autor, fechaCreacion, codigo);
    } */   



    public Articulo(String titulo, double precio, String imagen, String autor, String codigo) {
        init(titulo, precio, imagen, autor, codigo);
    }




    public Articulo(long id, String titulo, double precio, String imagen, String autor, String codigo) {
    }



    private void init(String titulo, double precio, String imagen, String autor,
            String codigo) {
        this.titulo = titulo;
        this.precio = precio;
        this.imagen = imagen;
        this.autor = autor;
        this.fechaCreacion = LocalDate.now();
        this.codigo = codigo;
    }



    //metodos
    String obtenerImagen() {
        return this.imagen;

    }

    void mas10x100() {
        precio = precio *1.1;

    }

    
    //GETTERS AND SETLERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }    

}
