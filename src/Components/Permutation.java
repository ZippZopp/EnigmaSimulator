package Components;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
    private final int[] elements;

    public Permutation(int... initialElements) {
        Set<Integer> set = new HashSet<>();
        elements = new int[initialElements.length];

        for (int i = 0; i < initialElements.length; i++) {
            if (!set.add(initialElements[i])) {
                throw new IllegalArgumentException("Duplicate element found: " + initialElements[i]);
            }
            elements[i] = initialElements[i];
        }
    }

    public int get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }
        return elements[index];
    }
    public int indexOf(int value) {
        if (value < 0 || value >= elements.length) {
            throw new IllegalArgumentException("Value " + value + " out of range 0 to " + (elements.length - 1));
        }
        // Since the permutation is a one-to-one mapping of all integers in the range, use the value to find its index.
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        // Since we know all values are within the range, this should never hit
        throw new IllegalStateException("Permutation array does not contain the value, which should be impossible.");
    }

    public int size() {
        return elements.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
    }

