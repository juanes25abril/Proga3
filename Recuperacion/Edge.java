package Recuperacion;
public class Edge {
    public final String to;
    public final double weight;

    public Edge(String to, double weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f km)", to, weight);
    }
}