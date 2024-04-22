package Alphabets;

/**
 * The Alphabet interface provides the necessary methods to interact with different alphabet systems
 * used in the Enigma machine simulation. It defines how numerical values are translated to and from characters
 * according to specific alphabets.
 */
public interface Alphabet {
    /**
     * Returns the total number of letters in the alphabet.
     *
     * @return the number of letters in the specific alphabet implementation.
     */
    int getLetterCount();
    /**
     * Converts a numerical input value into a corresponding index within the range of the alphabet.
     * This method is used for mapping characters to their numeric positions for encryption.
     *
     * @param inputValue the integer value to be converted (typically a character code).
     * @return an integer representing the position of the character within the alphabet.
     */
    int convertToLetterRange(int inputValue);
    /**
     * Converts a numerical index value back into the corresponding character.
     * This method is used after encryption or decryption processes to convert numeric indices back to textual characters.
     *
     * @param inputValue the index within the alphabet to convert back to a character.
     * @return the character corresponding to the given index.
     */
    char convertToCharacter(int inputValue);
}
