import Alphabets.Alphabet;
import Alphabets.LatanAlphabet;
import Components.Disc;
import Components.Reflector;

import java.util.List;
import java.util.stream.Collectors;

public class Enigma {


    List<Disc> discs;

    Reflector reflector;

    Alphabet alphabet;

    public Enigma(List<Disc> discs, Reflector reflector, Alphabet alphabet) {
        this.alphabet = alphabet;

        if(!(discs.stream().allMatch(disc -> disc.size() == alphabet.getLetterCount())))
            throw new IllegalArgumentException("all discs need to have a slot for every letter and not more");

        this.discs = discs;
        this.reflector = reflector;
    }

    public Enigma(List<Disc> discs, Reflector reflector) {
        this(discs,reflector,new LatanAlphabet());
    }


    public String transform(String inputString){
        List<Integer> charValues = inputString.replaceAll("\\s", "")// remove whitespace, because it was common in encryption
                .toUpperCase().chars()
                .map(alphabet::convertToLetterRange).boxed().toList();

        return encryptCharValueList(charValues);
    }


    private String encryptCharValueList(List<Integer> inputCharValues){
        return inputCharValues.stream().sequential()
                .map(this::translateCharValue)
                .map(alphabet::convertToCharacter)
                .map(Object::toString)
                .collect(Collectors.joining());
    }


    private int translateCharValue(int charValue){
        // go thoug all dics and the reflector and throu all discs again
        System.out.println("translate");
        for (int i = 0; i < discs.size(); i++) {
            charValue = discs.get(i).translate(charValue); // todo do i overwritte the charValue from te caller
        }

        charValue = reflector.translate(charValue);

        for (int i = discs.size()-1; i >= 0; i--) {
            charValue = discs.get(i).translateBackward(charValue); // todo do i overwritte the charValue from te caller
        }

        stepTheDiscs();

        return charValue;
    }

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
