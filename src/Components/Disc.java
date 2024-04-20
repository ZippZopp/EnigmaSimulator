package Components;

public class Disc {

    private final LetterCircleStepper currentPosition;

    private final Permutation permutations;

    public Disc(int startValue, Permutation permutation) {
//        if(letterCount != permutation.size())
//            throw new IllegalArgumentException("letterCount and permutation size needs to be same size");
//
        this.currentPosition = new LetterCircleStepper(startValue, permutation.size());
        this.permutations = permutation;
    }

    public int translate(int inputCharValue){
        return permutations.get(inputCharValue);
    }

    public int translateBackward(int inputCharValue){
        return permutations.indexOf(inputCharValue);
    }

    public void step(){
        currentPosition.step();
        System.out.println("step:"+currentPosition.getValue());

    }

    public boolean resetedLastStep(){
        return currentPosition.resetedLastStep();
    }

    public int size(){
        return permutations.size();
    }

}
