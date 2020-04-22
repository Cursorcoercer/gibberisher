/**
 * Implements a bag ADT specifically for alphabetical characters and one special stop character.
 * This is an implementation of a bag ADT for chars from an underlying array, which by
 * restricting the valid chars to a small set achieves O(1) time complexity for all operations.
 *
 * @author  Peter Weiblen
 */

import java.util.Random;

public class CharBag {

    private static String validChars = "abcdefghijklmnopqrstuvwxyz" + LetterSample.STOP;
    private int[] counts;

    /**
     * Class constructor that initializes the count of each possible char to 0.
     */
    public CharBag () {
        // initialize array of 0's
        this.counts = new int[27];
    }

    /**
     * Method which will clean a char input, making sure it is valid char for this bag.
     * @param c The char input to be cleaned
     * @return char This returns the cleaned char.
     */
    private char cleanInput(char c) {
        c = Character.toLowerCase(c);
        if (! Character.isAlphabetic(c)) {
            // if character is not alphabetic, convert it to a stop
            c = LetterSample.STOP;
        }
        return c;
    }

    /**
     * Method which adds a char to the bag.
     * @param c The char to be added
     */
    public void add(char c) {
        c = cleanInput(c);
        this.counts[validChars.indexOf(c)] += 1;
    }

    /**
     * Method which removes a char from the bag, or does nothing if the char is not present.
     * @param c The char to be removed
     */
    public void remove(char c) {
        c = cleanInput(c);
        int index = validChars.indexOf(c);
        this.counts[index] = Math.max(this.counts[index]-1, 0);
    }

    /**
     * Method which returns how many of a given char are present in the bag.
     * @param c The char to be counted
     * @return int The number of times the given char appears in the bag
     */
    public int getCount(char c) {
        c = cleanInput(c);
        return this.counts[validChars.indexOf(c)];
    }

    /**
     * Method which returns size of the bag.
     * @return int The number elements in the bag
     */
    public int getSize() {
        int total = 0;
        for (int i = 0; i < 27; i++) {
            total += this.counts[i];
        }
        return total;
    }

    /**
     * Method which returns a uniformly random character from the bag.
     * @return char A random character from the bag
     */
    public char getRandomChar() {
        int size = getSize();
        if (size == 0) {
            return LetterSample.STOP;
        }
        Random rng = new Random();
        int choice = rng.nextInt(size);
        // since STOP is the default return, we only need loop over the first 26, the alphabet
        for (int i = 0; i < 26; i++) {
            choice -= this.counts[i];
            if (choice < 0) {
                return validChars.charAt(i);
            }
        }
        return LetterSample.STOP;
    }

    /**
     * The string representation is "CharBag{ELEM:COUNT, ...}"
     * Where ELEM is particular char in the bag, COUNT is
     * the number of times that char appears in the bag, and ...
     * is to indicate that this enumerates all ELEM:COUNT separated by a comma and a space.
     */
    @Override
    public String toString() {
        StringBuilder bag = new StringBuilder("CharBag{");
        for (int i = 0; i < 27; i++) {
            if (i != 0) {
                bag.append(", ");
            }
            bag.append(validChars.charAt(i));
            bag.append(':');
            bag.append(this.counts[i]);
        }
        bag.append('}');
        return bag.toString();
    }
}
