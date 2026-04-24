import java.util.Random;
import java.util.Scanner;

    public class Devinette {

        public static void main(String[] args) {
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);

            int nombreSecret = random.nextInt(100) + 1;
            int essais = 0;
            boolean gagne = false;

            System.out.println("Jeu de devinettes");
            System.out.println("Devinez un nombre entre 1 et 100. Vous avez 10 essais.");
            System.out.println();

            while (essais < 10) {
                essais++;
                System.out.print("Essai " + essais + "/10 : ");

                int devine;
                try {
                    devine = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Entree invalide. Veuillez entrer un nombre entier.");
                    essais--;
                    continue;
                }

                if (devine < 1 || devine > 100) {
                    System.out.println("Veuillez entrer un nombre entre 1 et 100.");
                    essais--;
                    continue;
                }

                if (devine == nombreSecret) {
                    gagne = true;
                    break;
                } else if (devine < nombreSecret) {
                    System.out.println("Trop petit !");
                } else {
                    System.out.println("Trop grand !");
                }

                System.out.println("Il vous reste " + (10 - essais) + " essai(s).");
                System.out.println();
            }

            System.out.println();
            if (gagne) {
                System.out.println("Felicitations ! Vous avez trouve le nombre " + nombreSecret + " en " + essais + " essai(s) !");
            } else {
                System.out.println("Dommage ! Vous avez epuise vos 10 essais. Le nombre secret etait : " + nombreSecret);
            }

            scanner.close();
        }
    }
