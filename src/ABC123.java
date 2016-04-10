/**
 * Created by Lytecyde on 9.04.2016.
 *
 * Created by miku on 13.03.2016.
 */
import java.util.Collections;
import java.util.LinkedList;

public class ABC123 {
    private final int STARTING_NUMBERS = 2;
    private final int STARTING_LETTERS = 2;
    private static String originalList;
    private static LinkedList<String> original = new LinkedList<String>();
    private static String orderedOriginalList;
    private static String recalledList;

    public static void main(String[] args) {
        int level = 1;
        runTest(level);
    }

    private static LinkedList<String> makeNumbers(int count) {
        final String[] numbersUsed = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int randomNumber = (int) Math.floor(Math.random() * 10);
        LinkedList<String> listN = new LinkedList();
        for (int i = 0; i < count; i++) {
            listN.add(numbersUsed[randomNumber]);
            randomNumber = (int) Math.floor(Math.random() * 10);
        }
        return listN;
    }

    private static LinkedList<String> makeLetters(int count) {
        final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int randomNumber = (int) Math.floor(Math.random() * letters.length);
        LinkedList<String> listL = new LinkedList();
        for (int i = 0; i < count; i++) {
            listL.add(letters[randomNumber]);
            randomNumber = (int) Math.floor(Math.random() * letters.length);
        }
        return listL;
    }

    private LinkedList<String> getStringList(LinkedList numbers, LinkedList letters) {
        LinkedList<String> complete = new LinkedList<>();
        complete.addAll(numbers);
        complete.addAll(letters);
        return complete;
    }

    private static void runTest(int level) {
        LinkedList<String> lett = new LinkedList<>();
        LinkedList<String> numbr = new LinkedList<>();
        for (int i = 4; i < 8; i++) {
            if (i % 2 == 0) {
                lett = makeLetters(i / 2);
                numbr = makeNumbers(i / 2);
            } else {
                lett = makeLetters((i + 1) / 2);
                numbr = makeNumbers((i - 1) / 2);
            }


        }
        original.addAll(lett);
        original.addAll(numbr);
        shuffle(original);
        for(String s: original) System.out.print(s);
    }
    private static LinkedList<String> shuffle(LinkedList<String> original){
        Collections.shuffle(original);
        return original;
    }
}

