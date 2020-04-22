/**
 * Implements a class to store a string and a char.
 * This class stores a string and a char, this is referred to as a "sample" of letters.
 * This class also has a static method toSamples which converts a string into all possible samples
 * that are substrings of n letters and the char that follows them.
 *
 * @author  Peter Weiblen
 */

public class LetterSample {
    public static final char STOP = '.';

    private String sample;
    private char next;

    /**
     * Class constructor that specifies both the string and char that make up a sample.
     * @param sample This is the string which is a sample sequence of letters.
     * @param next This is the char which is associated with the give string.
     */
    public LetterSample(String sample, char next) {
        this.sample = sample;
        this.next = next;
    }

    /**
     * Method which returns the this.sample variable.
     * @return String This returns the sample string sequence variable.
     */
    public String getSegment() {
        return this.sample;
    }

    /**
     * Method which returns the this.next variable.
     * @return char This returns the next char variable.
     */
    public char getNextLetter() {
        return this.next;
    }

    /**
     * The string representation is ""SAMPLE" -> NEXT"
     * Where SAMPLE is the sample's string variable and
     * NEXT is the sample's char variable
     */
    @Override
    public String toString() {
        return "\"" + this.sample + "\" -> " + this.next;
    }

    /**
     * Static method that converts a string into an array of samples given the sequences size.
     * @param input This is the input string from which to derive the letter samples.
     * @param segmentSize This is the size that each sample's string must be, unless pulling
     *                    from the beginning of the word in which case sample strings may be shorter.
     * @return LetterSample [] This returns the array of letter samples that can be derived from the input string.
     */
    public static LetterSample [] toSamples(String input, int segmentSize) {
        // first let's clean up the input
        input = input.toLowerCase();
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                temp += input.charAt(i);
            }
        }
        input = temp + STOP;
        // now create the array of samples
        LetterSample [] samples = new LetterSample[input.length()];
        String substr;
        for (int i = 0; i < input.length(); i++) {
            substr = input.substring(Math.max(i-segmentSize, 0),i);
            samples[i] = new LetterSample(substr, input.charAt(i));
        }
        return samples;
    }
}
