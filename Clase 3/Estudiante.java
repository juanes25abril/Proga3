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

    public String  toString()
    {
        return "Estudiante{ Id: "+ Id + "  Nombre : " + nombre + " Facultad: " + Facultad +"}";
    }

    public static int CantidadEstudiantes(Estudiante[] estudiantes, String facultadBuscada) {
        int contador = 0;
        for (Estudiante est : estudiantes) {
            if (est != null && est.Facultad.equalsIgnoreCase(facultadBuscada)) {
                contador++;
            }
           
            } 
            return contador;
            
}

    public class EjecutarEstudiante
     {

        public static void main(String[] args) {
            //Creacion de los objetos Estudiante.
            Estudiante objEst1 = new Estudiante(756, "Manuel Mora Orozco", "Ingenieria de sistemas");
            Estudiante objEst2 = new Estudiante(757, "Juan Esteban Naranjo", "Ingenieria de sistemas");
            

            Estudiante[] e = new Estudiante[3];
            e[0] = objEst1;
            e[1] = objEst2;
            e[2] = new Estudiante(123, "Danna Jineth", "Artes Integradas");

            int cantidad = Estudiante.CantidadEstudiantes(e, "Ingenieria de sistemas");


            for (int i = 0; i < e.length; i++) 
            {
                System.out.println(e[i]);
            }

            System.out.println("Cantidad de estudiantes de Ingenieria de sistemas = " + cantidad);
        }

    }

}