public class Biblioteca {
    
    private int id; 
    private String Autor;
    private double Precio;
    private String Titulo;
   

    

    public Biblioteca(int id, String autor, double precio, String titulo) {
        this.id = id;
        Autor = autor;
        Precio = precio;
        Titulo = titulo;
    }

    




    public int getId() {
        return id;
    }

     




    @Override
    public String toString() {
        return "Biblioteca [id=" + id + ", Autor=" + Autor + ", Precio=" + Precio + ", Titulo=" + Titulo + "]";
    }






    public void setId(int id) {
        this.id = id;
    }






    public String getAutor() {
        return Autor;
    }






    public void setAutor(String autor) {
        Autor = autor;
    }






    public double getPrecio() {
        return Precio;
    }






    public void setPrecio(double precio) {
        Precio = precio;
    }






    public String getTitulo() {
        return Titulo;
    }






    public void setTitulo(String titulo) {
        Titulo = titulo;
    }






    public static double CalcularPrecios(Biblioteca[] bibliotecas) {
    double total = 0.0;
    for (int i = 0; i < bibliotecas.length; i++) {
        total += bibliotecas[i].getPrecio();
    }
    return total;
}



    

    

    
}