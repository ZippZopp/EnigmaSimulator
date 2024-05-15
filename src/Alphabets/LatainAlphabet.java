package Alphabets;

/**
 * The LatinAlphabet class implements the Alphabet interface specifically for the English alphabet (A-Z).
 * It provides functionality to convert characters to numerical indices and vice versa,
 * only considering uppercase letters.
 */
public class LatainAlphabet implements Alphabet {
    public static final int LETTER_COUNT = 26;

    /**
     * Returns the count of letters in the English alphabet, which is 26.
     *
     * @return the number of letters in the Latin alphabet.
     */
    @Override
    public int getLetterCount() {
        return LETTER_COUNT;
    }

    /**
     * Converts an ASCII code of an uppercase letter to a zero-based index.
     * E.g., 'A' becomes 0, 'B' becomes 1, ..., 'Z' becomes 25.
     *
     * @param inputValue the ASCII code of an uppercase letter.
     * @return the zero-based index of the letter within the alphabet.
     * @throws IllegalArgumentException if the provided ASCII code does not represent an uppercase letter.
     */
    @Override
    public int convertToLetterRange(int inputValue) {
        final int valueInLetterRange = inputValue - (int)'A';

        if(!(getLetterCount() > valueInLetterRange && valueInLetterRange >= 0))
            throw new IllegalArgumentException("the char needs to be a Uppercase letter");

        return valueInLetterRange;
    }
    /**
     * Converts a zero-based index back to its corresponding uppercase letter.
     * E.g., 0 becomes 'A', 1 becomes 'B', ..., 25 becomes 'Z'.
     * This method assumes that the input value is valid and within the alphabet range.
     *
     * @param inputValue the zero-based index to be converted back to a character.
     * @return the corresponding uppercase letter of the index.
     */
    @Override
    public char convertToCharacter(int inputValue) {
        assert inputValue >= 0 && inputValue < getLetterCount() : "input value needs to be >=0 and < then "+getLetterCount();
        return (char)(inputValue + (int)'A');
    }
}

