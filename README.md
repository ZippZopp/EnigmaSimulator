# Enigma Machine Simulator

This project is a simple Java implementation of the Enigma Machine, an encryption device used historically for ciphering and deciphering messages. It simulates the functionality of the Enigma rotors and reflector.

## Features

- Simulates multiple rotors (discs) and a reflector.
- Customizable rotor settings through permutations.
- Implements the `Alphabet` interface to handle different character sets.
- Example implementation for encrypting and decrypting text.

## Getting Started

### Prerequisites

Ensure you have Java installed on your machine. You can check your Java version by running:
```bash
java -version
```

### Installation

Clone the repository or download the source code. No additional libraries are required.

### Usage

To use the Enigma simulator, compile and run the `Main` class. Here is an example setup:

```java
import Components.Disc;
import Components.Permutation;
import Components.Reflector;
import Alphabets.LatainAlphabet; // Ensure this import if you're using the LatinAlphabet class

public class Main {
    public static void main(String[] args) {
        // Generate realistic random permutations for the discs
        Permutation disc1Permutation = createRandomPermutation(26);
        Permutation disc2Permutation = createRandomPermutation(26);

        // Create a symmetric permutation for the reflector
        Permutation reflectorPermutation = createSymmetricPermutation(26);

        // Initialize Enigma machines
        Enigma enigmaMachine1 = new Enigma(List.of(new Disc(0, disc1Permutation), new Disc(1, disc2Permutation)), new Reflector(reflectorPermutation));
        Enigma enigmaMachine2 = new Enigma(List.of(new Disc(0, disc1Permutation), new Disc(1, disc2Permutation)), new Reflector(reflectorPermutation));

        // Encrypt and decrypt an example message
        final String text = "GrueßGottHerrOberHauptMann";
        String encrypted = enigmaMachine1.transform(text);
        String decrypted = enigmaMachine2.transform(encrypted);

        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
```
### Example Functions

The `createRandomPermutation` and `createSymmetricPermutation` methods generate the permutations needed for the discs and reflector, respectively. These ensure that each component has a unique mapping that simulates the Enigma's encryption process.

## License

This project is open source and available under the [MIT License](LICENSE.md).

