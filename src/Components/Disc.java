package Components;
/**
 * Represents a single rotor (disc) in the Enigma machine.
 * This rotor is capable of both forward and backward translation of character values,
 * according to a predefined permutation mapping.
 */
public class Disc {
    /**
     * Tracks the current position of the rotor in the ciphering process.
     */
    private final LetterCircleStepper currentPosition;
    /**
     * Holds the permutation used for encrypting and decrypting messages.
     * This permutation defines how character values are mapped to different values.
     */
    private final Permutation permutations;
    /**
     * Constructs a disc with a specified initial position and a set of permutations.
     *
     * @param startValue the initial position of the disc.
     * @param permutation the permutation mapping used by this disc.
     */
    public Disc(int startValue, Permutation permutation) {
        this.currentPosition = new LetterCircleStepper(startValue, permutation.size());
        this.permutations = permutation;
    }
    /**
     * Translates a character value according to the permutation.
     *
     * @param inputCharValue the character value to translate.
     * @return the translated character value.
     */
    public int translate(int inputCharValue){
        int adjustedIndex = (inputCharValue + currentPosition.getValue()) % permutations.size();
        return permutations.get(adjustedIndex);
    }
    /**
     * Translates a character value backwards, finding the original value from a given encrypted value.
     *
     * @param inputCharValue the character value to translate back.
     * @return the original character value before encryption.
     */
    public int translateBackward(int inputCharValue){
        int translatedIndex = permutations.indexOf(inputCharValue);
        return (translatedIndex - currentPosition.getValue() + permutations.size()) % permutations.size();

    }
    /**
     * Advances the position of this disc by one step in the rotation.
     */
    public void step(){
        currentPosition.step();
    }
    /**
     * Checks if the disc has just completed a full rotation and reset to the initial position.
     *
     * @return true if the disc has reset in the last step, otherwise false.
     */
    public boolean resetedLastStep(){
        return currentPosition.resetedLastStep();
    }
    /**
     * Returns the size of the permutations, which corresponds to the number of unique character values
     * that can be translated by this disc.
     *
     * @return the size of the permutation set.
     */
    public int size(){
        return permutations.size();
    }

}
