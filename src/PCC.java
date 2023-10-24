/**
 * Classe implémentant l'algorithme de calcul du plus court chemin (Djikstra)
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PCC {
    public List<Sommet> shortestPath(GrapheOriente graph, Sommet start, Sommet end) {
        Map<Sommet, Integer> distance = new HashMap<>(); // Distance from start Sommet to other vertices
        Map<Sommet, Sommet> previous = new HashMap<>(); // Previous Sommet in the shortest path
        PriorityQueue<Sommet> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        // Initialize distances
        for (Sommet Sommet : graph.getVertices()) {
            distance.put(Sommet, Integer.MAX_VALUE);
            previous.put(Sommet, null);
        }
        distance.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Sommet current = queue.poll();

            if (current == end) {
                // Found the shortest path
                List<Sommet> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = previous.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            for (Arete Arete : graph.getOutgoingAretes(current)) {
                Sommet neighbor = Arete.getDestination();
                int newDistance = distance.get(current) + Arete.getWeight();
                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le nom de la station de départ");
        String nomStation1 = sc.nextLine();
        System.out.println("Saisir le nom de la station d'arrivée");
        String nomStation2 = sc.nextLine();



        sc.close();
    }
}
