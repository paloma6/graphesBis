import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {
        List<Sommet> stations = new ArrayList<>();
        List<Arrete> arret = new ArrayList<>();

        if (new File("metro.txt").exists()) {
            try {
                Scanner scanner = new Scanner(new File("metro.txt"), "utf-8");
                while (scanner.hasNextLine()) {
                    String ligne = scanner.nextLine();
                    String[] elements = ligne.trim().split("\\s+");

                    if (elements[0].equals("V")) {
                        if (elements.length >= 5) {
                            int numSommet = Integer.parseInt(elements[1]);
                            String nomSommet = String.join(" ", Arrays.copyOfRange(elements, 2, elements.length - 3));
                            String numLigne = elements[elements.length - 3].replaceAll(";", "");
                            boolean isTerminus = elements[elements.length - 2].replaceAll(";", "").equals("True");
                            String branchement = elements[elements.length - 1];

                            Sommet sommet = new Sommet(numSommet, nomSommet, numLigne, isTerminus, branchement);
                            stations.add(sommet);
                            System.out.printf("Code: %d, Nom: %s, Quais: %s, Souterraine: %b, Branchement: %s%n",
                                    sommet.getNumSommet(), sommet.getNomSommet(), sommet.getNumLigne(), sommet.isTerminus(), sommet.getBranchement());
                        } else {
                            System.out.println("Error: Not enough elements. Sommet should have at least 5 elements.");
                        }
                    }

                    if (elements[0].equals("E")) {
                        if (elements.length == 4) {
                            int numSommet1 = Integer.parseInt(elements[1]);
                            int numSommet2 = Integer.parseInt(elements[2]);
                            int tempsSecondes = Integer.parseInt(elements[3]);

                            Arrete arrete = new Arrete(numSommet1, numSommet2, tempsSecondes);
                            arret.add(arrete);
                            System.out.printf("NumSom1: %d, NumSom2: %d, Temps: %d%n",
                                    arrete.getNumSommet1(), arrete.getNumSommet2(), arrete.getTempsSecondes());
                        } else {
                            System.out.println("Error: Not enough elements. Arrete should have 4 elements.");
                        }
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}