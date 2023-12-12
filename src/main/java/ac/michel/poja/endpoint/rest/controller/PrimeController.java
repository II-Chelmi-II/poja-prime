package ac.michel.poja.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigInteger;
import java.util.Random;

public class PrimeController {

    @GetMapping("/new-prime")
    public String generateNewPrime() {
        BigInteger probablePrime = generateProbablePrime();
        return "Probable Prime Number: " + probablePrime.toString();
    }

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

    private BigInteger generateProbablePrime() {
        // Génère un nombre premier probable à 10 000 bits.
        return BigInteger.probablePrime(10000, new Random());
    }
    
}
