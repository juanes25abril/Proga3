public class EjecutarLibro {

    public static void main(String[] args) {

        Biblioteca[] Bibliotecas = new Biblioteca[5];
        
       Bibliotecas[0] = new Biblioteca(1, null, 17800, null);
       Bibliotecas[1] = new Biblioteca(2, null, 59000, null);
       Bibliotecas[2] = new Biblioteca(3, null, 47800, null);
       Bibliotecas[3] = new Biblioteca(4, null, 67900, null);
       Bibliotecas[4] = new Biblioteca(5, null, 43900, null);

       System.out.println("El Costo Total de los libros es " + Bibliotecas[3].CalcularPrecios(Bibliotecas) + " COP");

    }

    
} 