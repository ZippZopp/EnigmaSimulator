package Components;


public class Reflector {

    Permutation permutations;

    public Reflector(Permutation permutation) {
        if(!isSymmetric(permutation))
            throw new IllegalArgumentException("permutation needs to be symmetric, but is not");
        this.permutations = permutation;
    }

    private static boolean isSymmetric(Permutation permutation){
        for (int idx = 0; idx < permutation.size(); idx++) {
            if (idx != permutation.get(permutation.get(idx))){
                return false;
            };
        }
        return true;
    }

    public int translate(int inputCharValue){
        return permutations.get(inputCharValue);
    }


}
