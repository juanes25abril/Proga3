public class Biblioteca {

    private String Titulo;
    private String Autor;
    private int id;
    private int Precio;

    public Biblioteca(String titulo, String autor, int id, int precio) {
        Titulo = titulo;
        Autor = autor;
        this.id = id;
        Precio = precio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Biblioteca [Titulo=" + Titulo + ", Autor=" + Autor + ", id=" + id + ", Precio=" + Precio + "]";
    }

    

    

    
}