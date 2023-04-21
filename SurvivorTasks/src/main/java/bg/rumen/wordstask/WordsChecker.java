package bg.rumen.wordstask;

import bg.rumen.util.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordsChecker {
    public static void main(String[] args) {

        try {
            solve();
        } catch (IOException exception) {
            Logger.log(exception.getMessage());
        }
    }

    private static void solve() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/wordstask/input.txt"));

        String command = scanner.nextLine();


        int sum = 0;
        int countIterations = 1;
        String firstWord = "";
        String secondWord = "";
        while (!command.equals("End")) {

            if (countIterations == 1) {
                firstWord = command;
                secondWord = scanner.nextLine();
            } else {
                firstWord = secondWord;
                secondWord = command;
            }

            char[] firstSymbols;
            char[] secondSymbols;
            List<Character> firstSymbolsList = new ArrayList<>();
            List<Character> secondSymbolsList = new ArrayList<>();

            int currentSum = 0;
            if (firstWord.length() < secondWord.length()) {
                firstSymbols = firstWord.toCharArray();
                secondSymbols = secondWord.toCharArray();

            } else {
                firstSymbols = secondWord.toCharArray();
                secondSymbols = firstWord.toCharArray();
            }


            for (char symbol : firstSymbols) {
                firstSymbolsList.add(symbol);
            }

            for (char symbol : secondSymbols) {
                secondSymbolsList.add(symbol);
            }


            String duplicatedChars = "";

            for (int indexOne = 0; indexOne < firstSymbolsList.size(); indexOne++) {

                for (int indexTwo = 0; indexTwo < secondSymbolsList.size(); indexTwo++) {

                    char firstSymbol = firstSymbolsList.get(indexOne);
                    char secondSymbol = secondSymbolsList.get(indexTwo);

                    if (firstSymbol == secondSymbol) {
                       duplicatedChars =  duplicatedChars.concat(firstSymbol + "");
                        firstSymbolsList.remove(indexOne);
                        secondSymbolsList.remove(indexTwo);
                        indexOne--;
                        indexTwo--;
                        break;
                    }
                }
            }

            currentSum = (firstWord.length() - duplicatedChars.length()) + (secondWord.length() - duplicatedChars.length());
            sum += currentSum;

            countIterations++;
            command = scanner.nextLine();
        }

        Logger.log(sum + "");

    }

}
