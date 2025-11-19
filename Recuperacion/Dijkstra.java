package Recuperacion;
import java.util.*;
public class Dijkstra {
    public static class Result {
        public final Map<String, Double> dist;
        public final Map<String, String> prev;

        public Result(Map<String, Double> dist, Map<String, String> prev) {
            this.dist = dist;
            this.prev = prev;
        }
    }

    public static Result run(Graph g, String start) {
        Map<String, Double> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        for (String node : g.nodes()) {
            dist.put(node, Double.POSITIVE_INFINITY);
            prev.put(node, null);
        }
        dist.put(start, 0.0);

        PriorityQueue<Map.Entry<String, Double>> pq =
                new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        pq.add(new AbstractMap.SimpleEntry<>(start, 0.0));

        while (!pq.isEmpty()) {
            Map.Entry<String, Double> e = pq.poll();
            String u = e.getKey();
            double d = e.getValue();
            if (d > dist.get(u)) continue;

            for (Edge edge : g.neighbors(u)) {
                String v = edge.to;
                double alt = dist.get(u) + edge.weight;
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.add(new AbstractMap.SimpleEntry<>(v, alt));
                }
            }
        }
        return new Result(dist, prev);
    }

    public static List<String> reconstructPath(String target, Map<String, String> prev) {
        LinkedList<String> path = new LinkedList<>();
        String at = target;
        while (at != null) {
            path.addFirst(at);
            at = prev.get(at);
        }
        return path;
    }
}
