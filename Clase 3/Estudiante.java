public class Estudiante{


    //Atributos
    private int Id;
    private String nombre;
    private String Facultad;

    //Constructor
    public Estudiante (int Id, String nombre, String Facultad)
    {
        this.Id = Id;
        this.nombre = nombre;
        this.Facultad = Facultad;
    }
    public String getnombre(){
        return nombre;
    }

    public String getFacultad(){
        return Facultad;
    }

    public String  toString()
    {
        return "Estudiante[ Id: "+ Id + "  Nombre : " + nombre + " Facultad: " + Facultad +"]";
    }

    //Metodo para saber cuantos estudiantes tiene una facultad
    public int CantidadEstudiantes(Estudiante[] e, String NombreFacultad) {
        int contador = 0;
        for(int i = 0; i < e.length; i++)
        {
            if(e[i].getFacultad().equals(NombreFacultad))
            {
                contador ++;
            }
        }
        return contador;
            } 

    //Metodo para mostrar  todos los nombres de los estudiantes
    public void mostrarNombres(Estudiante[] e) {
        for(int i = 0; i< e.length; i++)
        {
            System.out.println(e[i].getnombre());
        }
        
    }

            
}

    

