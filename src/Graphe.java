import java.util.List;

public class Graphe {
    private List<Sommet> sommets;
    private List<Arrete> arretes;
    private List<Sommet> sommetsNonConnexes;

    public Graphe(List<Sommet> sommets, List<Arrete> arretes, List<Sommet> sommetsNonConnexes) {
        this.sommets = sommets;
        this.arretes = arretes;
        this.sommetsNonConnexes = sommetsNonConnexes;
    }
}