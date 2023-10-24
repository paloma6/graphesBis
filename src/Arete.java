public class Arete {
    private Sommet source;
    private Sommet destination;
    /**
     * tempsSecondes représente le poids de l'arc entre le sommet source et le sommet destination
     */
    private int tempsSecondes;

    public Arete(Sommet sommet1, Sommet sommet2, int tempsSecondes) {
        this.source = sommet1;
        this.destination = sommet2;
        this.tempsSecondes = tempsSecondes;
    }

    public int getTempsSecondes() {
        return this.tempsSecondes;
    }
}