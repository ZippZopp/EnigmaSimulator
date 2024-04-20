package Alphabets;

public class LatanAlphabet implements Alphabet {
    @Override
    public int getLetterCount() {
        return 26;
    }

    /** converts charValue to normedRange
     *
     * @param inputValue Ascii code as integer, when letter Uppercase
     * @return if letter then index from 0 to 25, else -1
     */
    @Override
    public int convertToLetterRange(int inputValue) {
        final int valueInLetterRange = inputValue - (int)'A';

        if(!(getLetterCount() > valueInLetterRange && valueInLetterRange >= 0))
            throw new IllegalArgumentException("the char needs to be a Uppercase letter");

        return valueInLetterRange;
    }

    @Override
    public char convertToCharacter(int inputValue) {
        assert inputValue >= 0 && inputValue < getLetterCount() : "input value needs to be >=0 and < then "+getLetterCount();
        return (char)(inputValue + (int)'A');
    }
}

