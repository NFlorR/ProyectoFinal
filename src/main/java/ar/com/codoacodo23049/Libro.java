package ar.com.codoacodo23049;


//Libro es un ARTICULO
public class Libro extends Articulo {

    //tiene sus propios atributos
    private String isbn;
    
    //constructor
    public Libro(
        long id,
        String titulo, 
        double precio, 
        String imagen, 
        String autor,  
        String codigo,
        String isbn
        ) {
            super(id, titulo, precio, imagen, autor, codigo);
            // invoca constructor del padre
            
        this.isbn = isbn;
    }

    public String getIsbn() {
        return this.isbn;
    }


}
