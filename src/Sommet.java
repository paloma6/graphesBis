import java.util.List;

public class Sommet {
    private List<Integer> numeros;
    private String nom;
    private List<Integer> lignes;
    private boolean estTerminus;
    private int branchement;

    public Sommet(List<Integer> numeros, String nom, List<Integer> lignes, boolean estTerminus, int branchement) {
        this.numeros = numeros;
        this.nom = nom;
        this.lignes = lignes;
        this.estTerminus = estTerminus;
        this.branchement = branchement;
    }
}