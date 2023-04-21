package bg.rumen.TaskThree;

import bg.rumen.util.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TaskThree {
    public static void main(String[] args) {

        try {
            solve();
        } catch (IOException exception) {
            Logger.log(exception.getMessage());
        }
    }

    private static void solve() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/resourcesTaskThree/firstOptionInput.txt"));

        String firstWord = scanner.nextLine();
        String nextWord = scanner.nextLine();

        char[] firstSymbols;
        char[] secondSymbols;

        if (firstWord.length() <= nextWord.length()) {
            firstSymbols = firstWord.toCharArray();
            secondSymbols = nextWord.toCharArray();
        } else {
            firstSymbols = nextWord.toCharArray();
            secondSymbols = firstWord.toCharArray();
        }

        String output = "";

            for (char symbolOne : firstSymbols) {
                for (char symbolTwo : secondSymbols) {
                    if (symbolOne == symbolTwo) {
                        output = output.concat(symbolOne + "");
                        break;
                    }
                }
            }

        int sum = (firstWord.length() - output.length()) + (nextWord.length() - output.length());
        Logger.log(sum + "");

    }

}
