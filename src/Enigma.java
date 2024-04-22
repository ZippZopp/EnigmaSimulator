import Alphabets.Alphabet;
import Alphabets.LatainAlphabet;
import Components.Disc;
import Components.Reflector;

import java.util.List;
import java.util.stream.Collectors;
/**
 * The Enigma class represents a model of the Enigma encryption machine.
 * It includes a set of rotors (discs), a reflector, and an alphabet system.
 */
public class Enigma {


    List<Disc> discs;
    Reflector reflector;
    Alphabet alphabet;

    /**
     * Constructs an Enigma machine with specified discs, a reflector, and an alphabet.
     * Validates that each disc in the machine has a slot for every letter of the alphabet.
     *
     * @param discs    the list of rotors (discs) to be used in the machine.
     * @param reflector the reflector to be used in the machine.
     * @param alphabet the alphabet system to be used for encryption.
     * @throws IllegalArgumentException if any disc does not match the size of the alphabet.
     */
    public Enigma(List<Disc> discs, Reflector reflector, Alphabet alphabet) {
        this.alphabet = alphabet;

        if(!(discs.stream().allMatch(disc -> disc.size() == alphabet.getLetterCount())))
            throw new IllegalArgumentException("all discs need to have a slot for every letter and not more");

        this.discs = discs;
        this.reflector = reflector;
    }
    /**
     * Constructs an Enigma machine with specified discs and a reflector.
     * Uses the Latin alphabet by default.
     *
     * @param discs    the list of rotors (discs) to be used in the machine.
     * @param reflector the reflector to be used in the machine.
     */
    public Enigma(List<Disc> discs, Reflector reflector) {
        this(discs,reflector,new LatainAlphabet());
    }

    /**
     * Transforms the input string into its encrypted form(or decrypt it when it was encrypted and the original state was the same).
     * Non-letter characters are removed, and the string is converted to uppercase before processing.
     *
     * @param inputString the string to encrypt.
     * @return the encrypted string.
     */
    public String transform(String inputString){
        List<Integer> charValues = inputString.replaceAll("\\s", "")// remove whitespace, because it was common in encryption
                .toUpperCase().chars()
                .map(alphabet::convertToLetterRange).boxed().toList();

        return encryptCharValueList(charValues);
    }

    /**
     * Helper method to encrypt a list of character values.
     *
     * @param inputCharValues the list of character values to encrypt.
     * @return the resulting encrypted string.
     */
    private String encryptCharValueList(List<Integer> inputCharValues){
        return inputCharValues.stream().sequential()
                .map(this::translateCharValue)
                .map(alphabet::convertToCharacter)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    /**
     * Translates a single character value through the encryption process.
     * Processes through all discs forward, then the reflector, and then through all discs backward.
     *
     * @param charValue the character value to translate.
     * @return the translated character value.
     */
    private int translateCharValue(int charValue){
        // go thoug all dics and the reflector and throu all discs again
        for (Disc disc : discs) {
            charValue = disc.translate(charValue);
        }

        charValue = reflector.translate(charValue);

        for (int i = discs.size()-1; i >= 0; i--) {
            charValue = discs.get(i).translateBackward(charValue);
        }

        stepTheDiscs();

        return charValue;
    }

    /**
     * Advances the position of each disc by one step.
     * Automatically resets and advances the next disc when a disc completes a full rotation.
     */
    private void stepTheDiscs(){

        discs.get(0).step();
        for (int idx = 0; idx < (discs.size() - 1);) {
            if(discs.get(idx).resetedLastStep())
                discs.get(idx++).step();
            else
                break;

        }
    }
}
