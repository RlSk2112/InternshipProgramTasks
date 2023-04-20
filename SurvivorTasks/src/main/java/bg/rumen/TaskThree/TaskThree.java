package bg.rumen.TaskThree;

import java.util.*;

public class TaskThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialFirst = scanner.nextLine();
        String initialSecond = scanner.nextLine();

        String firstWord = initialFirst;
        String nextWord = initialSecond;

        Set<Character> firstSymbols = getSymbols(firstWord);
        Set<Character> secondSymbols = getSymbols(nextWord);


        firstWord = getFilteredString(firstWord, secondSymbols);
        nextWord = getFilteredString(nextWord, firstSymbols);

        firstSymbols = getSymbols(firstWord);
        secondSymbols = getSymbols(nextWord);

        int sumRemoved = (initialFirst.length() - firstSymbols.size()) + (initialSecond.length() - secondSymbols.size());

        System.out.println(sumRemoved);

    }

    private static String getFilteredString(String word, Set<Character> symbolsSet) {
        int index = 0;
        while (index < word.length()) {

            char searchedSymbol = word.charAt(index);

            if (!symbolsSet.contains(searchedSymbol)) {
                int indexSearched = word.indexOf(searchedSymbol);
               word =  word.replace(word.substring(indexSearched, indexSearched + 1), "");
               index--;
            }

            index++;
        }
        return word;
    }


    public static Set<Character> getSymbols(String word) {
        Set<Character> symbolsSet = new LinkedHashSet<>();
        for (int index = 0; index < word.length(); index++) {
            char currentSymbol = word.charAt(index);
            symbolsSet.add(currentSymbol);
        }
        return symbolsSet;
    }
}
