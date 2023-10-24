import java.util.List;

public class Sommet {
    private int sommetId;
    private String nom;
    private List<Integer> lignes;
    private boolean estTerminus;
    private int branchement;

    public Sommet(int sommetId, String nom, List<Integer> lignes, boolean estTerminus, int branchement) {
        this.sommetId = sommetId;
        this.nom = nom;
        this.lignes = lignes;
        this.estTerminus = estTerminus;
        this.branchement = branchement;
    }

    public int getSommetId() {
        return this.sommetId;
    }
}