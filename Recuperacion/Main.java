package Recuperacion;
import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Cambia aquí Supplier a ArrayList::new o LinkedList::new
        Supplier<List<Edge>> listFactory = ArrayList::new; // o LinkedList::new

        Graph g = new Graph(listFactory);

        // --- Grafo modelo de Colombia (distancias aproximadas en km, ejemplo) ---
        // Nodos clave
        String CALI = "Cali";
        String BOG = "Bogotá";
        String MEDE = "Medellín";
        String PERE = "Pereira";
        String ARM = "Armenia";
        String BUC = "Bucaramanga";
        String BARR = "Barranquilla";
        String CART = "Cartagena";
        String MON = "Montería";
        String SIN = "Sincelejo";
        String SANT = "Santa Marta";
        String POP = "Popayán";
        String BUEN = "Buenaventura";
        String TUL = "Tuluá";
        String BUGA = "Buga";
        String CALI_PT = CALI; // alias

        // Añadir aristas (ejemplo, orientado; si quieres bidireccional, añadir espejo o modificar addEdge)
        // Voy a añadir aristas en ambas direcciones para simular carreteras bidireccionales:
        addBidirectional(g, CALI, BUGA, 45);
        addBidirectional(g, BUGA, TUL, 40);
        addBidirectional(g, TUL, PERE, 120);
        addBidirectional(g, PERE, ARM, 70);
        addBidirectional(g, ARM, MEDE, 210);
        addBidirectional(g, MEDE, BUC, 400);
        addBidirectional(g, MEDE, MON, 350);
        addBidirectional(g, MON, BARR, 250);
        addBidirectional(g, BARR, CART, 130);
        addBidirectional(g, SIN, CART, 100);
        addBidirectional(g, MON, SIN, 190);
        addBidirectional(g, BUC, BOG, 350);
        addBidirectional(g, PERE, BOG, 220);
        addBidirectional(g, CALI, POP, 130);
        addBidirectional(g, POP, PERE, 160);
        addBidirectional(g, CALI, BUEN, 80);
        addBidirectional(g, CALI, MEDE, 420);
        addBidirectional(g, MEDE, CART, 650);

        // Añade más aristas para densificar si quieres...
        // --------------------------------------------------------------------

        // Ejecutar Dijkstra desde Cali
        Dijkstra.Result res = Dijkstra.run(g, CALI);

        // Objetivo: Cartagena
        String target = CART;
        if (!g.contains(target)) {
            System.out.println("El grafo no contiene Cartagena. Termino.");
            return;
        }

        Double distToCart = res.dist.get(target);
        System.out.printf("Distancia (aprox) de %s a %s: %.2f km%n", CALI, target, distToCart);

        List<String> path = Dijkstra.reconstructPath(target, res.prev);
        System.out.println("Camino más corto encontrado por Dijkstra: " + path);

        // --- Preparar lista de distancias (ejemplo: distancias a varios nodos) ---
        List<Double> distances = new ArrayList<>();
        for (String node : g.nodes()) {
            Double d = res.dist.get(node);
            if (d != null && !d.isInfinite() && d > 0) {
            distances.add(d);
}

        }

        // Convertir a array primitivo para usar los métodos de Sorts
        double[] arr = distances.stream().mapToDouble(Double::doubleValue).toArray();
        System.out.println("Distancias antes de ordenar: " + Sorts.toString(arr));

        // Escoge un método de ordenamiento:
        // Sorts.bubbleSort(arr);
        // Sorts.selectionSort(arr);
        // Sorts.insertionSort(arr);
        // Sorts.mergeSort(arr);
        Sorts.quickSort(arr); // por ejemplo

        System.out.println("Distancias después de ordenar: " + Sorts.toString(arr));
        System.out.printf("La distancia mínima (posición 0) es: %.2f km%n", arr[0]);

        // Encontrar qué nodo corresponde a la distancia mínima encontrada:
        double min = arr[0];
        String minNode = null;
        for (Map.Entry<String, Double> e : res.dist.entrySet()) {
            if (Math.abs(e.getValue() - min) < 1e-6) {
                minNode = e.getKey();
                break;
            }
        }
        System.out.println("Nodo con distancia mínima: " + minNode);
    }

    private static void addBidirectional(Graph g, String a, String b, double d) {
        g.addEdge(a, b, d);
        g.addEdge(b, a, d);
    }
}