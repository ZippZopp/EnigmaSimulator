package Components;
/**
 * The LetterCircleStepper class is responsible for managing the position of a rotor within a range defined by the total number of letters.
 * It simulates the mechanical stepping mechanism of a rotor in an Enigma machine.
 */
public class LetterCircleStepper {
    private final int letterCount;

    private boolean resetedLastStep = false;

    private int value;// Current position of the rotor
    /**
     * Constructs a LetterCircleStepper with a specific starting position and letter count.
     *
     * @param startValue  the initial position of the rotor.
     * @param letterCount the total number of distinct positions or letters the rotor can assume.
     * @throws IllegalArgumentException if the letterCount is negative or startValue is outside the valid range.
     */
    public LetterCircleStepper(int startValue, int letterCount) {
        if(letterCount < 0)
            throw new IllegalArgumentException("letterCount cant be negative");

        this.letterCount = letterCount;
        if(startValue < 0 || startValue >= this.letterCount)
            throw new IllegalArgumentException("start value need to be bigger then zero and smaller then "+this.letterCount+", but is "+startValue);

        this.value = startValue;
    }

    /**
     * Returns the current position of the rotor.
     *
     * @return the current value of the rotor position.
     */
    int getValue(){
        return value;
    }
    /**
     * Advances the position of the rotor by one step. If it reaches the end of the cycle, it resets to the beginning.
     * This method also updates the reset status if the rotor returns to the initial position.
     */
    void step(){
        value = (value + 1)%letterCount;

        resetedLastStep = value == 0;
    }

    /**
     * Checks if the rotor has reset to its initial position in the last stepping operation.
     *
     * @return true if the rotor has reset during the last step, otherwise false.
     */
    public boolean resetedLastStep() {
        return resetedLastStep;
    }
}
