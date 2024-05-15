import Alphabets.LatainAlphabet;
import Components.Disc;
import Components.Permutation;
import Components.Reflector;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Optional<String> optionalString = Arrays.stream(args).reduce((a, b) -> a + b);
        runEnigmaExampleProgram(optionalString.orElse(""));
    }

    /** example Program.
     */
    private static void runEnigmaExampleProgram(final String text) {
        Permutation plugBoardPermutation = createRandomPermutation(LatainAlphabet.LETTER_COUNT);

        // Generate realistic random permutations for the discs
        Permutation disc1Permutation = createRandomPermutation(LatainAlphabet.LETTER_COUNT);
        Permutation disc2Permutation = createRandomPermutation(LatainAlphabet.LETTER_COUNT);

        // Create a symmetric permutation for the reflector
        Permutation reflectorPermutation = createSymmetricPermutation(LatainAlphabet.LETTER_COUNT);

        // Create two Enigma machine with two discs and one reflector
        Enigma enigmaMachine1 = new Enigma(plugBoardPermutation, List.of(new Disc(0, disc1Permutation),new Disc(1, disc2Permutation)), new Reflector(reflectorPermutation));
        Enigma enigmaMachine2 = new Enigma(plugBoardPermutation, List.of(new Disc(0, disc1Permutation),new Disc(1, disc2Permutation)), new Reflector(reflectorPermutation));

        System.out.println("Created 2 Enigmas");
        System.out.println("this plugBoard permutation:");
        System.out.println(plugBoardPermutation);
        System.out.println("this disc permutation:");
        System.out.println(disc1Permutation);
        System.out.println(disc2Permutation);
        System.out.println("and this reflector permutation:");
        System.out.println(reflectorPermutation);

        // Example encryption
        System.out.println("original text: " + text);
        String encrypted = enigmaMachine1.transform(text);
        System.out.println("Encrypted text: " + encrypted);
        String decrypted = enigmaMachine2.transform(encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }

    private static Permutation createRandomPermutation(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int[] elements = numbers.stream().mapToInt(i -> i).toArray();
        return new Permutation(elements);
    }

    private static Permutation createSymmetricPermutation(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[numbers.get(i)] = numbers.get((size - 1) - i);
        }
        return new Permutation(elements);
    }
}