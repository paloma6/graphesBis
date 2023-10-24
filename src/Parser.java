import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {

        List<Sommet> stations = new ArrayList<>();
        List<Arete> arret = new ArrayList<>();

        try {
            File file = new File("metro.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                String[] elements = line.trim().split("\\s+");

                if (elements[0].equals("V")) {
                    if (elements.length >= 5) {
                        int numSommet = Integer.parseInt(elements[1]);
                        String nomSommet = String.join(" ", Arrays.copyOfRange(elements, 2, elements.length - 3));
                        String numLigne = elements[elements.length - 3].replaceAll(";", "");
                        boolean isTerminus = elements[elements.length - 2].replaceAll(";", "").equals("True");
                        String branchement = elements[elements.length - 1];
                        Sommet sommet = new Sommet(numSommet, nomSommet, numLigne, isTerminus, branchement);
                    } else {
                        System.out.println("Error: Not enough elements. Sommet should have at least 5 elements.");
                    }
                }

                if (elements[0].equals("E")) {
                    if (elements.length == 4) {
                        int numSommet1 = Integer.parseInt(elements[1]);
                        int numSommet2 = Integer.parseInt(elements[2]);
                        int tempsSecondes = Integer.parseInt(elements[3]);

                        Arete arete = new Arete(numSommet1, numSommet2, tempsSecondes);
                        arret.add(arete);
                        System.out.printf("NumSom1: %d, NumSom2: %d, Temps: %d%n",
                                arete.getNumSommet1(), arete.getNumSommet2(), arete.getTempsSecondes());
                    } else {
                        System.out.println("Error: Not enough elements. Arrete should have 4 elements.");
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}