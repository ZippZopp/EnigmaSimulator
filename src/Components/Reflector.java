package Components;

/**
 * The Reflector class represents the reflector component of an Enigma machine.
 * It is responsible for reflecting the signal back through the rotors after passing through them once,
 * using a symmetric permutation mapping.
 */
public class Reflector {
    /**
     * Holds the permutation used for reflecting the signal in the Enigma machine.
     * This permutation must be symmetric, meaning each index maps to a value and that value must map back to the original index.
     */
    Permutation permutations;
    /**
     * Constructs a reflector with a specified symmetric permutation.
     *
     * @param permutation the symmetric permutation used for reflecting signals.
     * @throws IllegalArgumentException if the provided permutation is not symmetric.
     */
    public Reflector(Permutation permutation) {
        if(!isSymmetric(permutation))
            throw new IllegalArgumentException("permutation needs to be symmetric, but is not");
        this.permutations = permutation;
    }
    /**
     * Checks if the provided permutation is symmetric.
     * A permutation is symmetric if for every index and its value, the value at the position of this value is the original index.
     *
     * @param permutation the permutation to check for symmetry.
     * @return true if the permutation is symmetric, false otherwise.
     */
    private static boolean isSymmetric(Permutation permutation){
        for (int idx = 0; idx < permutation.size(); idx++) {
            if (idx != permutation.get(permutation.get(idx))){
                return false;
            }
        }
        return true;
    }
    /**
     * Translates a character value using the symmetric permutation.
     * This method is typically called as part of the encryption process after the signal has passed through all the discs.
     *
     * @param inputCharValue the character value to be translated.
     * @return the reflected character value.
     */
    public int translate(int inputCharValue){
        return permutations.get(inputCharValue);
    }


}
