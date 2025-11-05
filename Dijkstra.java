import java.util.Scanner;

public class Dijkstra {
    public int[] distancia;
    public int[][] costo;
    public char[] nodos = {'A', 'B', 'C', 'D', 'E', 'F'};

    public void calc(int n, int origen) {
        int[] bandera = new int[n];
        distancia = new int[n];
        int i, minpos = 0, k, c, minima;

        // Inicialización
        for (i = 0; i < n; i++) {
            bandera[i] = 0;
            distancia[i] = costo[origen][i];
        }

        bandera[origen] = 1;
        c = 1;

        // Ciclo principal
        while (c < n - 1) {
            minima = 999;
            for (k = 0; k < n; k++) {
                if (distancia[k] < minima && bandera[k] != 1) {
                    minima = distancia[k];
                    minpos = k;
                }
            }

            bandera[minpos] = 1;
            c++;

            for (k = 0; k < n; k++) {
                if (bandera[k] != 1) {
                    if (distancia[minpos] + costo[minpos][k] < distancia[k]) {
                        distancia[k] = distancia[minpos] + costo[minpos][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dijkstra d = new Dijkstra();

        System.out.println("Ingrese el número de nodos (máx 6):");
        int n = sc.nextInt();
        d.costo = new int[n][n];

        System.out.println("\nIngrese la matriz de costos (use 0 si no hay conexión):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d.costo[i][j] = sc.nextInt();
                if (d.costo[i][j] == 0 && i != j) {
                    d.costo[i][j] = 999; // representa "sin conexión"
                }
            }
        }

        System.out.println("\nIngrese la letra del nodo de origen (A, B, C, ...):");
        char origenLetra = sc.next().toUpperCase().charAt(0);
        int origen = origenLetra - 'A';

        d.calc(n, origen);

        System.out.println("\n🚩 Caminos más cortos desde el nodo " + origenLetra + ":");
        for (int i = 0; i < n; i++) {
            if (i != origen) {
                System.out.println("Desde " + origenLetra + " → hasta " + d.nodos[i] +
                                   " = " + d.distancia[i]);
            }
        }

        sc.close();
    }
}
