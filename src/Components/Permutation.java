package Components;

import java.util.HashSet;
import java.util.Set;

/**
 * The Permutation class represents a bijective (one-to-one and onto) mapping of integers,
 * which is used for encryption and decryption transformations in Enigma components.
 */
public class Permutation {
    /** Stores the permutation mapping as an array of integers.
     */
    private final int[] elements;

    /**
     * Constructs a Permutation with a set of initial elements. Each element must be unique.
     *
     * @param initialElements the initial permutation values, each index maps to the element at that index.
     * @throws IllegalArgumentException if there are duplicate elements in the initial set.
     */
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
    /**
     * Retrieves the element at the specified index in the permutation.
     *
     * @param index the index of the element to retrieve.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of the range of the permutation array.
     */
    public int translate(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }
        return elements[index];
    }
    /**
     * Finds the index of a given value in the permutation array.
     *
     * @param value the value whose index is to be found.
     * @return the index of the value.
     * @throws IllegalArgumentException if the value is out of the expected range.
     * @throws IllegalStateException if the value is not found, which should not occur in a correct permutation setup.
     */
    public int translateBackwards(int value) {
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

    /**
     * Returns the size of the permutation array.
     *
     * @return the number of elements in the permutation.
     */
    public int size() {
        return elements.length;
    }

    /**
     * Returns a string representation of the permutation array.
     *
     * @return the string representation of the permutation, formatted as a list of elements.
     */
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

