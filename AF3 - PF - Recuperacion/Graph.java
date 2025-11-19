import java.util.*;
import java.util.function.Supplier;

public class Graph {
    private final Map<String, List<Edge>> adj;
    private final Supplier<List<Edge>> listFactory;

    public Graph(Supplier<List<Edge>> listFactory) {
        this.listFactory = listFactory;
        this.adj = new HashMap<>();
    }

    public void addNode(String node) {
        adj.computeIfAbsent(node, k -> listFactory.get());
    }

    public void addEdge(String from, String to, double weight) {
        addNode(from);
        addNode(to);
        adj.get(from).add(new Edge(to, weight));
        // Si el grafo es no dirigido, añadir la otra arista:
        // adj.get(to).add(new Edge(from, weight));
    }

    public Set<String> nodes() {
        return adj.keySet();
    }

    public List<Edge> neighbors(String node) {
        return adj.getOrDefault(node, Collections.emptyList());
    }

    public boolean contains(String node) {
        return adj.containsKey(node);
    }
}