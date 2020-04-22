import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GibberisherMain {

    public static String[] runGibberisherTest(int segmentLength, int wordTests) {
        Gibberisher g = new Gibberisher(segmentLength);
        long start = System.currentTimeMillis();
        g.train(Dictionary.getWords());
        long stop = System.currentTimeMillis();
        System.out.println("Loaded " + g.getSampleCount() + " samples in " + (stop - start) + "ms.");

        String[] words = new String[wordTests];
        start = System.currentTimeMillis();
        for (int i = 0; i < words.length; i++) {
            words[i] = g.generate();
        }
        stop = System.currentTimeMillis();
        System.out.println("Generated " + words.length + " words in Loaded in " + (stop - start) + "ms.");
        return words;
    }

    public static void printSome(String[] words, int length) {
        System.out.println("Here's a few:");
        for (int i = 0; i < length; i++) {
            System.out.println(" * "+words[i]);
        }
    }

    public static void printLongest(String[] words, int length) {
        System.out.println("Here's the longest of the bunch:");
        Arrays.sort(words, Comparator.comparingInt(s -> -s.length()));
        for (int i = 0; i < length; i++) {
            System.out.println(" * " + words[i]);
        }
    }

    public static void printContains(String[] words, String toFind) {
        System.out.println("Here's the the ones with "+toFind+" in them:");
        for (String word: words) {
            if (word.contains(toFind)) {
                System.out.println(" * " + word);
            }
        }

    }

    public static void UI() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the desired segment length: ");
        int segLen = input.nextInt();
        System.out.print("Enter how many gibberish words you want: ");
        int amount = input.nextInt();
        printSome(runGibberisherTest(segLen, amount), amount);
    }

    public static void main(String[] args) {
        // I've broken this file up into functions. The purpose here is to help you test runtime properties of your algorithm
        // And generally play around and have fun with this.

        // tests I recommend trying:
        //  * does varying segmentLength have a strong effect on runtime?
        //  * how does varying the number of words to generate change the run time?
        //  * how does changing segmentLength effect the quality of words generated?
        //     * What sort of words are generated when segmentLength is too small?
        //     * What sort of words are generated when segmentLength is too big?

        // some code to get you started:
        printSome(runGibberisherTest(2, 2000), 20);
        //printLongest(runGibberisherTest(2, 2000), 20);
        //printContains(runGibberisherTest(3, 10000000), "gibbord");
        //UI();
    }

}
