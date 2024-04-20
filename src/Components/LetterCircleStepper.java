package Components;

public class LetterCircleStepper {
    private final int letterCount;

    private boolean resetedLastStep = false;

    private int value;

    public LetterCircleStepper(int startValue, int letterCount) {
        if(letterCount < 0)
            throw new IllegalArgumentException("letterCount cant be negative");

        this.letterCount = letterCount;
        if(startValue < 0 || startValue >= this.letterCount)
            throw new IllegalArgumentException("start value need to be bigger then zero and smaller then "+this.letterCount+", but is "+startValue);

        this.value = startValue;
    }
    int getValue(){
        return value;
    }

    void step(){
        value = (value + 1)%letterCount;

        resetedLastStep = value == 0;
    }

    public boolean resetedLastStep() {
        return resetedLastStep;
    }
}
