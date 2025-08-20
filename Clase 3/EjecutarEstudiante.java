import java.lang.reflect.Array;
import java.util.Arrays;

public class EjecutarEstudiante {

    public static void main(String[] args) {
        
        Estudiante objEst1 = new Estudiante(100, "Juan Esteban Naranjo", "Ingenieria");
        Estudiante objEst2 = new Estudiante(101, "Juan Manuel Mora", "Ingenieria");
        Estudiante objEst3 = new Estudiante(102, "Camila Guisao Becerra", "Derecho");

        //Creacion del Arreglo de obejetos
        Estudiante[] est = new Estudiante[4];
        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;
        est[3] = new Estudiante(4, "Danna Jineth Flores", "Psicologia");

        //Forma1 = Imprimir el Arreglo de objetos
        for(int i = 0; i < est.length; i++){
            System.out.println(est[i]);
        }

        //Forma2 = Imprimir el Arreglo de objetos
        System.out.println(Arrays.toString(est));

        //Ejecucion del metodo contar estudiantes
        String f = "Ingenieria";
        System.out.println("Numero de Estudiantes " + objEst1.CantidadEstudiantes(est, f)  + " : " + f);
        
        //Ejecucionm del metodo mostrar
        objEst1.mostrarNombres(est);


       


    }
    
}
