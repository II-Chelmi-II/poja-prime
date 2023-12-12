package ac.michel.poja.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class PrimeController {

    private static final int MAX_STORED_PRIMES = 10;
    private static final List<BigInteger> generatedPrimes = new ArrayList<>();

    @GetMapping("/new-prime")
    public String generateNewPrime() {
        BigInteger probablePrime = generateProbablePrime();
        storeGeneratedPrime(probablePrime);
        return "Probable Prime Number: " + probablePrime.toString();
    }

    @GetMapping("/generated-primes")
    public List<String> getGeneratedPrimes() {
        List<String> primeStrings = new ArrayList<>();
        for (BigInteger prime : generatedPrimes) {
            primeStrings.add(prime.toString());
        }
        return primeStrings;
    }

    private void storeGeneratedPrime(BigInteger prime) {
        if (generatedPrimes.size() >= MAX_STORED_PRIMES) {
            // Si la liste atteint sa capacité maximale, retire le plus ancien élément.
            generatedPrimes.remove(0);
        }
        // Ajoute le nouveau nombre premier à la liste.
        generatedPrimes.add(prime);
    }

    private BigInteger generateProbablePrime() {
        // Génère un nombre premier probable à 10 000 bits.
        return BigInteger.probablePrime(10000, new Random());
    }
}
