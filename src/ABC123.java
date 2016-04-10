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
    private static LinkedList<String> lettersList = new LinkedList<>();
    private static LinkedList<String> numbersList = new LinkedList<>();
    public static void main(String[] args) {
        int level = 1;
        final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        final String[] numbersUsed = { "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String s:numbersUsed) numbersList.add(s);
        for(String s:letters)lettersList.add(s);
        runTest(level);
    }

    private static LinkedList<String> makeNumbers(int count) {

        int randomNumber = (int) Math.floor(Math.random() * numbersList.size());
        LinkedList<String> listN = new LinkedList();
        for (int i = 0; i < count; i++) {

            if(numbersList.size()>0) {
                System.out.println(numbersList.size() + "   r:" + randomNumber + "  n:" + numbersList.get(randomNumber));
                listN.add(numbersList.get(randomNumber));
                numbersList.remove(randomNumber);
            }
            randomNumber = (int) Math.floor(Math.random() * numbersList.size());
        }
        return listN;
    }

    private static LinkedList<String> makeLetters(int count) {

        int randomNumber = (int) Math.floor(Math.random() * lettersList.size());
        LinkedList<String> listL = new LinkedList();
        for (int i = 0; i < count; i++) {
            listL.add(lettersList.get(randomNumber));
            lettersList.remove(randomNumber);
            randomNumber = (int) Math.floor(Math.random() * lettersList.size());
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
        sort(original);
        for(String s:original) System.out.println(s);
    }
    private static LinkedList<String> shuffle(LinkedList<String> original){
        Collections.shuffle(original);
        return original;
    }
    private static LinkedList<String> sort(LinkedList<String> original){
        Collections.sort(original);
        return original;
    }
}

