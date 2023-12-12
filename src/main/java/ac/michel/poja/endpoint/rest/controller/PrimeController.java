package ac.michel.poja.endpoint.rest.controller;

import java.util.Random;

public class PrimeController {

    public static int generateRandomPrime() {
        Random random = new Random();
        int randomNum;

        do {
            // Génère un entier aléatoire entre 1 et Integer.MAX_VALUE inclus.
            randomNum = random.nextInt(Integer.MAX_VALUE - 1) + 1;
        } while (!isPrime(randomNum));

        return randomNum;
    }

    public static boolean isPrime(int num) {
        // Vérifie que le nombre est strictement supérieur à 1.
        if (num < 2) {
            return false;
        }

        // Vérifie la primalité en utilisant une boucle jusqu'à la racine carrée.
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int randomPrime = generateRandomPrime();
        System.out.println("Random Prime Number: " + randomPrime);
    }
}
