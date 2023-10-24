/**
 * Objectif : créer un objet représentant le graphe
 */

import java.util.List;

public class GrapheOriente {
    private List<Sommet> sommets;
    private List<Arete> aretes;

    public GrapheOriente(List<Sommet> sommets, List<Arete> aretes) {
        this.sommets = sommets;
        this.aretes = aretes;
    }

    public void ajoutSommet(Sommet sommet) {
        sommets.add(sommet);
    }

    public void ajoutArete(Sommet source, Sommet destination, int temps) {
        Arete arete = new Arete(source, destination, temps);
        aretes.add(arete);
    }

    /**
     * @param sommetId : l'id (int) du sommet
     * @return l'objet de type Sommet qui correspond à l'id entré en paramètre
     */
    public Sommet getSommetById(int sommetId) {
        for (Sommet sommet : sommets) {
            if (sommet.getSommetId() == sommetId) {
                return sommet;
            }
        }
        return null;
    }
}